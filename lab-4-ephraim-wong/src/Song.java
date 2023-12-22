import java.util.Arrays;

public class Song {
	private String title;
	private String artist;
	private int[] time;
	
	
	public Song(String title, String artist, int[] time) {
		this.title = title;
		this.artist = artist;
		this.time = Arrays.copyOf(time, time.length);
		
//		for (int i = 0; i < time.length; i++) {
//			this.time[i] = time[i];
		
//			if (time.length == 1) {
//				this.time[i] = time[i];
//			}
//			else if (time.length == 2) {
//				this.time[i] = time[i];
//				
//			}
//			else if (time.length == 3) {
//				
//			}
//			this.time
		}
		
	
	
	public String getTitle() {
		return this.title;
	}
	public String getArtist() {
		return this.artist;
		
	}
	public int[] getTime() {
		return Arrays.copyOf(this.time, this.time.length);
//		int[] songTime = Arrays.copyOf(this.time, this.time.length);
//		return songTime;
		
	}
}
