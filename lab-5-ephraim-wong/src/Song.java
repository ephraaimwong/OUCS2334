import java.util.Arrays;

public class Song {
	
	private String title;
	private String artist;
	private int[] time;
	private static final String INFO_DELIMITER = "; ";
	private static final String TIME_DELIMITER = ":";
	private static final int IDX_TITLE = 0;
	private static final int IDX_ARTIST = 1;
	private static final int IDX_TIME = 2;
	
	public Song(String title, String artist, int[] time) {
		this.title = title;
		this.artist = artist;
		this.time = Arrays.copyOf(time, time.length);
	}
	
	public Song(String info) {
		String[] infoList = info.split(INFO_DELIMITER);
		title = infoList[0];
		artist = infoList[1];
//		splitting song time into hour, min, sec 
		String[] timeAsString = infoList[2].split(TIME_DELIMITER);
		int[] songTimeList = new int[timeAsString.length];
//		storing time vals in reverse order
		int count = 0;
		for (int i = timeAsString.length-1; i >= 0; i--) {
			songTimeList[count] = Integer.valueOf(timeAsString[i]);

			count++;
		}
		time = Arrays.copyOf(songTimeList, songTimeList.length);
		
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public int[] getTime() {
		return Arrays.copyOf(time, time.length);
	}
	public String toString() {
		//sec, min, hr
		StringBuilder timeString = new StringBuilder();
		for (int i = time.length-1; i >= 0; i--) {
			if (i == time.length-1) {
				timeString.append(time[i]);
			} else {
				timeString.append(String.format("%02d", time[i]));
			}
			if (i > i - 1 && i !=0) {
				timeString.append(":");
			}
		}
		String result = timeString.toString();
		return getTitle() + "; " + getArtist() + "; " + result;
	}
}
