import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
/**
 * project 3
 * @author iampo
 * collection of points in trip with time-stamp and geographical location
 *
 */
public class TripPoint {

	private double lat;	// latitude
	private double lon;	// longitude
	private int time;	// time in minutes
	
	private static ArrayList<TripPoint> trip;	// ArrayList of every point in a trip
	private static ArrayList<TripPoint> movingTrip;

	/**
	 *  default constructor
	 */
	public TripPoint() {
		time = 0;
		lat = 0.0;
		lon = 0.0;
	}
	
	/**
	 *  constructor given time, latitude, and longitude
	 * @param time time-stamp
	 * @param lat latitude
	 * @param lon longitude
	 */
	public TripPoint(int time, double lat, double lon) {
		this.time = time;
		this.lat = lat;
		this.lon = lon;
	}
	
	/**
	 *   
	 * @return this.time
	 */
	public int getTime() {
		return time;
	}
	
	/**
	 * 
	 * @return this.lat
	 */
	public double getLat() {
		return lat;
	}
	
	/**
	 * 
	 * @return this.lon
	 */
	public double getLon() {
		return lon;
	}
	
	/**
	 * 
	 * @return copy of trip ArrayList
	 */
	public static ArrayList<TripPoint> getTrip() {
		return new ArrayList<>(trip);
	}
	
	/**
	 * 
	 * @return copy of movingTrip ArrayList 
	 */
	public static ArrayList<TripPoint> getMovingTrip(){
		return new ArrayList<>(movingTrip);
	}
	
	/**
	 *  uses the haversine formula for great sphere distance between two points
	 * @param first point 1
	 * @param second point 2
	 * @return distance in km
	 */
	public static double haversineDistance(TripPoint first, TripPoint second) {
		// distance between latitudes and longitudes
		double lat1 = first.getLat();
		double lat2 = second.getLat();
		double lon1 = first.getLon();
		double lon2 = second.getLon();
		
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
 
        // convert to radians
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);
 
        // apply formulae
        double a = Math.pow(Math.sin(dLat / 2), 2) +
                   Math.pow(Math.sin(dLon / 2), 2) *
                   Math.cos(lat1) *
                   Math.cos(lat2);
        double rad = 6371;
        double c = 2 * Math.asin(Math.sqrt(a));
        return rad * c;
	}
	
	/**
	 *  finds the average speed between two TripPoints in km/hr
	 * @param a point a
	 * @param b point b
	 * @return average speed in km/hr
	 */
	public static double avgSpeed(TripPoint a, TripPoint b) {
		
		int timeInMin = Math.abs(a.getTime() - b.getTime());
		
		double dis = haversineDistance(a, b);
		
		double kmpmin = dis / timeInMin;
		
		return kmpmin*60;
	}
	
	/**
	 *  finds the average speed of all moving points during trip
	 * @return average speed in km/hr
	 */
	public static double avgMovingSpeed() {
		ArrayList<TripPoint> movingTrip = getMovingTrip();
		double movingDist = 0;
		for (int i = 1; i < movingTrip.size();i++) {
			TripPoint a = movingTrip.get(i-1);
			TripPoint b = movingTrip.get(i);
			movingDist += haversineDistance(a,b);
		}
		return (movingDist/movingTime());
	}
	
	/**
	 * 
	 * @return total time of trip in hours
	 */
	public static double totalTime() {
		int minutes = trip.get(trip.size()-1).getTime();
		double hours = minutes / 60.0;
		return hours;
	}
	
	/**
	 * 
	 * @return moving time in hours
	 */
	public static double movingTime() {
		double time = 0;
		time = (movingTrip.size()-1) * 5.0;
		return time/60.0;
	}
	
	/**
	 * 
	 * @return total time spent stopped
	 */
	public static double stoppedTime() {
		return totalTime() - movingTime();
	}
	
	/**
	 *
	 * @return total distance traveled over the trip in km
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static double totalDistance() throws FileNotFoundException, IOException {
		
		double distance = 0.0;
		
		if (trip.isEmpty()) {
			readFile("triplog.csv");
		}
		
		for (int i = 1; i < trip.size(); ++i) {
			distance += haversineDistance(trip.get(i-1), trip.get(i));
		}
		
		return distance;
	}
	
	public String toString() {
		
		return null;
	}
	/**
	 * reads file, storing each line as a TripPoint object
	 * @param filename file being read
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void readFile(String filename) throws FileNotFoundException, IOException {

		// construct a file object for the file with the given name.
		File file = new File(filename);

		// construct a scanner to read the file.
		Scanner fileScanner = new Scanner(file);
		
		// initiliaze trip
		trip = new ArrayList<TripPoint>();

		// create the Array that will store each lines data so we can grab the time, lat, and lon
		String[] fileData = null;

		// grab the next line
		while (fileScanner.hasNextLine()) {
			String line = fileScanner.nextLine();

			// split each line along the commas
			fileData = line.split(",");

			// only write relevant lines
			if (!line.contains("Time")) {
				// fileData[0] corresponds to time, fileData[1] to lat, fileData[2] to lon
				trip.add(new TripPoint(Integer.parseInt(fileData[0]), Double.parseDouble(fileData[1]), Double.parseDouble(fileData[2])));
			}
		}

		// close scanner
		fileScanner.close();
	}
	/**
	 * compares 2 points and removes 2nd point from movingTrip if within .6km of each other
	 * @return number of stops
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static int h1StopDetection() throws FileNotFoundException, IOException {
		if (trip == null) {
			readFile("triplog.csv");
		}
		int stopCount = 0;
		movingTrip = getTrip();
		Set<TripPoint> pointsToRemove = new LinkedHashSet<>();
		
		
		for (int i = 1; i < trip.size(); i++) {
			TripPoint a = trip.get(i-1);
			TripPoint b = trip.get(i);

			double dist = haversineDistance(a, b);	
			if (dist <= 0.6) {
				pointsToRemove.add(b);
				stopCount++;
			}
		}
		movingTrip.removeAll(pointsToRemove);
		return stopCount;
	}
/**
 * if 3 or more stops are made within .5km of each other, they are removed from movingTrip
 * @return number of stops
 * @throws FileNotFoundException
 * @throws IOException
 */
	public static int h2StopDetection() throws FileNotFoundException, IOException{
		if(trip == null) {
			readFile("triplog.csv");
		}
		int stopCount = 0;
		movingTrip = getTrip();
		Set<TripPoint> pointsToRemove = new LinkedHashSet<>();
		ArrayList<ArrayList<TripPoint>> listOfStopZones = new ArrayList<>();
		
		for (TripPoint curr: movingTrip) {
			boolean added = false;
			//recursion to add curr to all current stopZone
			for (ArrayList<TripPoint> stopZone: listOfStopZones) {
				for (TripPoint pointInStop: stopZone) {
					//accessing point in list in list
					double dist = haversineDistance(curr, pointInStop);
					
					if(dist<=0.5) {
						stopZone.add(curr);
						added = true;
						//break to 2nd for loop
						break;
					}
				}
			}
			//not within any other points, start new zone
			if (!added) {
				ArrayList<TripPoint> newStopZone = new ArrayList<>();
				newStopZone.add(curr);
				listOfStopZones.add(newStopZone);
			}
			
		}
		for(ArrayList<TripPoint> stopZone: listOfStopZones) {
			if(stopZone.size()>=3) {
				stopCount += stopZone.size();
				//hashset, no worries about duplicates
				pointsToRemove.addAll(stopZone);
			}
		}
		movingTrip.removeAll(pointsToRemove);
		return stopCount;
	}


}
