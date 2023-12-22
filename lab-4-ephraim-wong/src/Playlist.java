import java.util.Arrays;

public class Playlist {
	private Song[] songs;
	private int numSongs = 0;
	private static final int MIN_CAPACITY = 3;
	
	public Playlist() {
		this.songs = new Song[MIN_CAPACITY];
	}
	public Playlist(int capacity) {
		if (capacity > MIN_CAPACITY) {
//			this.numSongs = capacity;
			this.songs = new Song[capacity];
		}
		else {
			this.songs = new Song[MIN_CAPACITY];
		}
	}
	public int getCapacity() {
		return this.songs.length;
	}
	public int getNumSongs() {
	// numSongs++ whenever songs are added
		return this.numSongs;
	}
	public Song getSong(int index) {
		if (!(index < 0) && !(index > getCapacity()-1)) {
			return songs[index];
		}
		else {
			return null;
		}
	}
	public Song[] getSongs() {
		//broken
		return Arrays.copyOf(songs, getNumSongs());
	}
	public boolean addSong(Song song) {	
		return addSong(getNumSongs(),song);
	}
	public boolean addSong(int index, Song song) {
//		Song currSong;
//		Song nextSong;
		if(song != null && ((getNumSongs() + 1) <= getCapacity() && !(index < 0) && !(index > getCapacity())) && !(index > getNumSongs())){
			for(int i = getCapacity()-1; i > index; i--) {
//		shifting songs right from the back of array
			songs[i] = songs[i-1];
			}
			songs[index] = song;
			numSongs++;
			return true;
		}else {
			return false;
		}
			
	}

	public int addSongs(Playlist playlist) {
		int count = 0;
		// so the code will only run if addSong(valid object)
		if (playlist != null) {
			Song[] tempPlaylist = new Song[playlist.getCapacity()];

			tempPlaylist = playlist.getSongs();
			//		for (int i = 0; )
			for (Song j : tempPlaylist) {
				//adding to end of array
				if (j != null && !(getNumSongs()+1 > getCapacity())) {
					addSong(getNumSongs(), j);
					count++;
				}
			}
			
		}
		return count;
	}
	
	public Song removeSong() {
		return removeSong(getNumSongs()-1);
	}
	public Song removeSong(int index) {
		Song currSong = null;
		if (getSong(index)!= null) {
//		shifting songs left from index point
			currSong = getSong(index);
			for(int i = index; i < getCapacity()-1; i++) {
							songs[i] = songs[i+1];
			}
			songs[getCapacity()-1] = null;
			numSongs--;
			return currSong;
		}else {
		return currSong;	
		}
	}

}
