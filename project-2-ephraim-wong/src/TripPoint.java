import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 * 
 * @author iampo
 * collection of points in trip with time-stamp and geographical location
 *
 */
public class TripPoint {
	private double lat;
	private double lon;
	private int time;
	private static ArrayList<TripPoint> trip = new ArrayList<TripPoint>();
	/**
	 * Constructor
	 * @param time time-stamp.
	 * @param lat latitude.
	 * @param lon longitude.
	 */
	public TripPoint(int time, double lat, double lon) {
		this.time = time;
		this.lat = lat;
		this.lon = lon;
//		trip = new ArrayList<TripPoint>();
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
	 * @return deep copy of ArrayList trip
	 */
	public static ArrayList<TripPoint> getTrip(){
		ArrayList<TripPoint> deepCopy = new ArrayList<TripPoint>();
		for (TripPoint i : trip) {
			TripPoint copyObj = new TripPoint(i.getTime(), i.getLat(), i.getLon());
			deepCopy.add(copyObj);
		}
		return deepCopy;
	}
	/**
	 * 
	 * @param a point a.
	 * @param b point b.
	 * @return distance between a and b in kilometers
	 */
	public static double haversineDistance(TripPoint a, TripPoint b) {
		double lat1,lat2,lon1,lon2 = 0;
		lat1 = Math.toRadians(a.getLat());
		lat2 = Math.toRadians(b.getLat());
		lon1 = a.getLon();
		lon2 = b.getLon();
		
		double diffLat = lat2 - lat1;
		double diffLon = Math.toRadians(lon2 - lon1);
		
		double x = Math.pow(Math.sin(diffLat / 2), 2) + Math.pow(Math.sin(diffLon / 2), 2) * Math.cos(lat1) * Math.cos(lat2);
		double r = 6371;
		double c = 2 * Math.asin(Math.sqrt(x));
		return r * c;
	}
	/**
	 * 
	 * @param a point a.
	 * @param b point b.
	 * @return average speed between a and b in km/h
	 */
	public static double avgSpeed(TripPoint a, TripPoint b) {
		double dist = haversineDistance(a,b);
		double time = (b.getTime() - a.getTime()) / 60.0;
		return Math.abs(dist / time);
	}
	/**
	 * 
	 * @return total time the trip took in hrs
	 */
	public static double totalTime() {
		double timeMin = -5;
		for(TripPoint i : trip) {
			timeMin += 5;
		}
		return (timeMin/60.0);
	}
	/**
	 * 
	 * @return total distance covered in kilometers
	 */
	public static double totalDistance() {
		double tally = 0;
		for(int i = 0; i < trip.size()-1; i++) {
			tally += haversineDistance(trip.get(i),trip.get(i+1));
		}
		return tally;
	}
	/**
	 * 
	 * @param filename file being read.
	 * @throws IOException 
	 * reading and storing time, lat, lon values from the file
	 */
	public static void readFile(String filename) throws IOException {
		BufferedReader read = new BufferedReader(new FileReader(filename));
		String line;
		int currTime;
		double currLat;
		double currLon;
		String[] holdingLine;
		read.readLine();
		trip.clear();
		while ((line = read.readLine()) != null) {
			//put time, lat and lon into ArrayList<> trip
			holdingLine = line.split(",");
			currTime = Integer.valueOf(holdingLine[0]);
			currLat = Double.parseDouble(holdingLine[1]);
			currLon = Double.parseDouble(holdingLine[2]);

			TripPoint i = new TripPoint(currTime, currLat, currLon);
			//keeps writing over 1st element
			trip.add(i);
			
		}
		read.close();
	}
}
