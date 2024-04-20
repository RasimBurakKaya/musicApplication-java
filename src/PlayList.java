
import java.util.LinkedList;

class Playlist {
    private String name;
    private LinkedList<Song> songs;

    public Playlist(String name) {
        this.name = name;
        this.songs = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void insert(Song song) {
        songs.add(song);
    }

    public boolean remove(int songNumber) {
        if (songNumber > 0 && songNumber <= songs.size()) {
            songs.remove(songNumber - 1);
            return true;
        }
        return false;
    }

    public void outputList() {
        if (songs.isEmpty()) {
            System.out.println("The playlist is empty.");
        } else {
            for (int i = 0; i < songs.size(); i++) {
                System.out.println((i + 1) + ". " + songs.get(i).getTitle());
            }
        }
    }
    
    public boolean remove(String title) {
        for (Song song : songs) {
            if (song.getTitle().equalsIgnoreCase(title)) {
                songs.remove(song);
                return true;
            }
        }
        return false;
    }

    public Song search(String title) {
        for (Song song : songs) {
            if (song.getTitle().equalsIgnoreCase(title)) {
                return song;
            }
        }
        return null;
    }
}