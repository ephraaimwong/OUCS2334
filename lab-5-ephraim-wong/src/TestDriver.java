import java.io.IOException;

public class TestDriver {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Song s1 = new Song("Where the Streets Have No Name; U2; 7:5:36");
		System.out.println(s1.toString());
//		System.out.println(s1.getTime());
		Song s2 = new Song("Candice; Artic Monkeys; 3:31");
		Playlist playlist = new Playlist();
		playlist.addSong(s1);
		playlist.addSong(s2);
//		System.out.println(playlist);
		int[] testTotalTime = playlist.getTotalTime();
		for (int i : testTotalTime) {
			System.out.println(i);
		}
		playlist.saveSongs("playlist.txt");
	}

}
