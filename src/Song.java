

public class Song  {
	private String title;
	private String artist;
	private String genre;
	private double duration;
	
	public Song(String title, String artist, String genre, double duration) {
		this.title = title;
		this.artist = artist;
		this.genre = genre;
		this.duration = duration;
	}
	public Song(String title) {
		this.title = title;
	}
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}
	
	@Override
	public String toString() {
		return "Title: " + title + ", Artist: " + artist + ", Genre: "+ genre + ", Duration: " +duration ;
	}
	
	
	

}
