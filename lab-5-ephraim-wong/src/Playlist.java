import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Playlist {
	
	private ArrayList<Song> songs;
	private int numSongs = 0;
	
	public Playlist() {
		// TODO: Initialize the songs field.
		songs = new ArrayList<>();
	}
	public Playlist(String filename) throws IOException {
		songs = new ArrayList<>();
		addSongs(filename);
	}
	public int getCapacity() {
		if (songs != null) {
			return songs.size();
		}
		else {
			return 10;
		}
	}
	public int getNumSongs() {
		return numSongs;
	}
	
	public Song getSong(int index) {
		if (index < 0 || index >= getNumSongs()) {
			return null;
		}
		return songs.get(index);
	}
	
	public Song[] getSongs() {
		return songs.toArray(new Song[0]);
	}
	
	public boolean addSong(Song song) {
		return addSong(getNumSongs(), song);
	}
	
	public boolean addSong(int index, Song song) {
		// TODO: Update the Lab 3 method.((getNumSongs()+1) <= getCapacity()
		if(song != null && (getNumSongs() <= getCapacity() && !(index < 0) && !(index > getCapacity())) && !(index > getNumSongs())){	
			songs.add(index, song);
			numSongs++;
			return true;
		}else {
			return false;
		}
	}
	
	public int addSongs(Playlist playlist) {
		// TODO: Update the Lab 3 method.
		int count = 0;
		// so the code will only run if addSong(valid object)
		if (playlist != null) {
			Song[] tempPlaylist = playlist.getSongs();
			for (Song j : tempPlaylist) {
				//adding to end of array
				addSong(j);
				count++;
			}
		}
		return count;
	}
	
	public int addSongs(String filename) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		int count = 0;
		String line;
		while ((line = br.readLine())!= null) {
			Song tempVar = new Song(line);
			songs.add(tempVar);
			count++;
			numSongs++;
		}
		br.close();
		return count;
	}
	
	public Song removeSong() {
		return removeSong(getNumSongs() - 1);
	}
	
	public Song removeSong(int index) {
		// TODO: Update the Lab 3 method.
		Song currSong = null;
		if (getSong(index)!= null) {
			currSong = getSong(index);
			songs.remove(index);
			numSongs--;
			return currSong;
		}else {
		return currSong;	
		}
	}
	
	public void saveSongs(String filename) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
		bw.write(toString());
		bw.close();
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < getCapacity(); i++) {
			result.append(getSong(i).toString());
			if(i != getCapacity()-1) {
				result.append(System.lineSeparator());
			}
		}
		return "" + result;
	}
	 public int[] getTotalTime() {
		 int totalSec = 0;
		 int totalMin = 0;
		 int totalHr = 0;
		 
		 for(Song i: songs) {
			int[] timeTally = i.getTime();
			if (timeTally.length > 2) {
				totalHr += timeTally[2];
			}
			if(timeTally.length > 1) {
				totalMin += timeTally[1];
			}
			if(timeTally.length > 0) {
				totalSec += timeTally[0];
			}
		 }
		 
		 totalMin += totalSec/60;
		 totalHr += totalMin/60;
		 
		 totalMin %= 60;
		 totalSec %= 60;
		 System.out.println("Hr:"+totalHr+"Min:"+totalMin+"Sec:"+totalSec);
		 if (totalMin == 0 && totalHr == 0) {
			 return new int[] {totalSec};
		 }
		 else if(totalHr == 0) {
			 return new int[] {totalSec, totalMin};
		 }
		 else {
			 return new int[] {totalSec, totalMin, totalHr};
		 }
		 
	 }
}
