package ch03;

public class SongTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Song song = new Song();
//		
//		song.setArtist("아이유");
//		song.setTitle("좋은날");
//		song.setAlbum("Real");
//		song.setYear(2010);
//		song.setTrack(3);
//		song.setComposer("이민수");
		
		Song songg=new Song("좋은날", "아이유", "real", "이민수",2010, 3);
		
		songg.show();
	}

}
