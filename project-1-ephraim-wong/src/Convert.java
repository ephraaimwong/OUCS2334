import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Convert {
	public static void convertFile(String filename) {
//		input GPX file, output CSV file
//		StringBuilder result = new StringBuilder();
//		result.append(filename);
//		result.append(".csv");
		
		String inputFilePath = filename;
		String outputFilePath = convertFileType(filename, ".csv");
		try(BufferedReader br = new BufferedReader(new FileReader(inputFilePath)); BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))){
			String line;
//			time, lat, lon
//			String[] infoList = new String[3];
			int count = 0;
			bw.write("Time,Latitude,Longitude\n");
			while((line = br.readLine()) != null) {
				if (!line.trim().isEmpty()) {
					line = line.trim();
					if (line.startsWith("<trkpt")) {
//					storing formatted values
						String lat = getVal(line, "lat");
						lat = formatVal(lat);
						String lon = getVal(line, "lon");
						lon = formatVal(lon);
						String time = timeStub(count);
//					write new CSV file
						bw.write(time + "," + lat + "," + lon + "\n");
						count++;
					}
				}
			}
//			bw.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getVal(String line, String varName) {
		int startIndex = line.indexOf(varName) + varName.length() + 2;
		int endIndex = line.indexOf("\"", startIndex);
//		int endIndex = line.lastIndexOf("\"");
		return line.substring(startIndex, endIndex);
	}
	
	private static String formatVal(String val) {
		String result;
		result = val.replaceAll("\\s+", "");
		result = result.replaceAll("[^0-9.-]","");
		return result;
		
	}
	private static String timeStub(int entryNum) {
		String time = Integer.toString(entryNum*5);
		return time;
	}
	private static String convertFileType(String filename, String newType) {
//		int startIndex = filename.indexOf(0);
		int endIndex = filename.indexOf(".");
		String s = filename.substring(0, endIndex) + newType;
		return s;
	}
}
