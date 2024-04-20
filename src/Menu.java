import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;

public class Menu {
	private static List<Playlist> playlists = new LinkedList<>();
    private static Scanner scanner = new Scanner(System.in);
    static Playlist favorites = new Playlist("Favorites");

	public static void main(String[] args) {
        boolean isFirst = true;
        Profile profile = new Profile("", 0, ""); 
        
		
		Song song1 = new Song("Apache", "Incredible Bongo Band", "Soul", 4.53);
		Song song2 = new Song("1999", "Prince", "Rock", 6.19);
		Song song3 = new Song("My Flame", "Bobby Caldwell", "fdvvdsdc", 4.12);
		Song song4 = new Song("Video Games", "Lana del Rey", "Indie pop", 4.42);
		Song song5 = new Song("Summertime Sadness", "Lana del Rey", "Pop rock", 4.25);
		Song song6 = new Song("Born to Die", "Lana del Rey", "Baroque pop", 4.46);
		Song song7 = new Song("Young and Beautiful", "Lana del Rey", "Orchestral pop", 3.56);
		Song song8 = new Song("West Coast", "Lana del Rey", "Psychedelic rock", 4.16);
		Song song9 = new Song("Goosebumps", "Travis Scott", "Indie pop", 4.03);
		Song song10 = new Song("SICKO MODE", "Travis Scott", "Hip-hop", 5.12);
		Song song11 = new Song("The Weeknd", "Blinding Lights", "Synth-pop", 3.20);
		Song song12 = new Song("Begonvil", "Sezen Aksu", "Pop", 4.18);
		Song song13 = new Song("Gel Bana", "Sezen Aksu", "Pop", 4.49);
		Song song14 = new Song("Git", "Sezen Aksu", "Pop", 4.20);
		Song song15 = new Song("Bangır Bangır", "Gülşen", "Pop", 3.47);
		Song song16 = new Song("Sakıncalı", "Gülşen", "Pop", 3.27);
		Song song17 = new Song("Bensiz Yapamazsın", "Müslüm Gürses", "Turkish Arabesque", 4.42);
		Song song18 = new Song("Affet", "Müslüm Gürses", "Turkish Arabesque", 5.15);

		Tree tree = new Tree(null);
		tree.insert(song1);
		tree.insert(song2);
		tree.insert(song3);
		tree.insert(song4);
		tree.insert(song5);
		tree.insert(song6);
		tree.insert(song7);
		tree.insert(song8);
		tree.insert(song9);
		tree.insert(song10);
		tree.insert(song11);
		tree.insert(song12);
		tree.insert(song13);
		tree.insert(song14);
		tree.insert(song15);
		tree.insert(song16);
		tree.insert(song17);
		tree.insert(song18);


		
		// Menu
		int menuNumber = 0;

        while (menuNumber == 0) {
            System.out.println("Main Menu:");
            System.out.println("1: My Profile");
            System.out.println("2: Discover");
            System.out.println("3: My Favorite Songs");
            System.out.println("4: My Playlists");
            System.out.print("Enter the menu number you want to go: ");

            menuNumber = scanner.nextInt();
		
        switch (menuNumber) {
        case 1:
            System.out.println("Profile Page");
            System.out.println("Welcome to your profile!");
            if(isFirst)
            {
            	 System.out.print("Enter your name: ");
                 String fullName = scanner.next();

                 System.out.print("Enter your age: ");
                 String age = scanner.next();
                 
                 System.out.print("Enter your country: ");
                 String country = scanner.next();
                  
           
                  profile = new Profile(fullName, Integer.parseInt(age), country);  	
                  isFirst = false;
            }
            	
            profile.printProfile();
       
            menuNumber = waitForZeroInput(scanner);
            break;
            
            
        case 2:
            System.out.println("Discover Page");
        	tree.inorder(tree.getRoot());
        	menuNumber = waitForZeroInput(scanner);
            break;
            
            
        case 3:
    System.out.println("My Favorite Songs Page");
    int choice;
    do {
        System.out.println("1. Add Song To Favorites");
        System.out.println("2. Display Favorites");
        System.out.println("3. Remove Song From Favorites");
        System.out.println("0. Exit");
        System.out.print("Make your selection: ");
        choice = scanner.nextInt();

        switch (choice) {
            case 1:
                addSongToFavorites();
                break;
            case 2:
                displayFavorites();
                break;
            case 3:
                removeSongFromFavorites();
                break;
            case 0:
                break;
            default:
                System.out.println("Invalid menu number!");
        }

        System.out.println();
    } while (choice != 0);

            menuNumber = waitForZeroInput(scanner);
            break;
            
        case 4:
            System.out.println("My Playlists Page");
            System.out.println("Manage your playlists here!");
            int choice1;
            do {
                System.out.println("1. View available playlists");
                System.out.println("2. Create new playlist");
                System.out.println("0. Exit");
                System.out.print("Make your selection: ");
                choice1 = scanner.nextInt();

                switch (choice1) {
                    case 1:
                        displayPlaylists();
                        break;
                    case 2:
                        createNewPlaylist();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Invalid menu number!");
                }

                System.out.println();
            } while (choice1 != 0);
          
            menuNumber = waitForZeroInput(scanner);
            break;
        default:
            System.out.println("Invalid menu number!");
            menuNumber = 0;
    }

    System.out.println();
}

scanner.close();
	}
	  
private static int waitForZeroInput(Scanner scanner) {
	        int input;
	        do {
	            System.out.print("Enter 0 to go back to the main menu: ");
	            input = scanner.nextInt();
	        } while (input != 0);
	     return input;   
	    }

private static void displayPlaylists() {
    if (playlists.isEmpty()) {
        System.out.println("You don't have any playlist.");
    } else {
        System.out.println("Your playlists:");
        int index = 1;
        for (Playlist playlist : playlists) {
            System.out.println(index + ". " + playlist.getName());
            index++;
        }

        int playlistChoice;
        do {
            System.out.print("Enter the number of the playlist you want to view (0 to exit): ");
            playlistChoice = scanner.nextInt();

            if (playlistChoice > 0 && playlistChoice <= playlists.size()) {
                Playlist playlist = playlists.get(playlistChoice - 1);
                displayPlaylistSongs(playlist);
                managePlaylist(playlist);
            } else if (playlistChoice != 0) {
                System.out.println("Invalid playlist number!");
            }

        } while (playlistChoice != 0);
    }
}

private static void displayPlaylistSongs(Playlist playlist) {
    System.out.println("Playlist: " + playlist.getName());
    playlist.outputList();
    System.out.println();
}

private static void managePlaylist(Playlist playlist) {
    int choice;
    do {
        System.out.println("1. Add new song");
        System.out.println("2. Remove song");
        System.out.println("0. Exit");
        System.out.print("Make your selection: ");
        choice = scanner.nextInt();

        switch (choice) {
            case 1:
                addSongToPlaylist(playlist);
                break;
            case 2:
                removeSongFromPlaylist(playlist);
                break;
            case 0:
                break;
            default:
                System.out.println("Invalid Number!");
        }

        System.out.println();
    } while (choice != 0);
}

private static void addSongToPlaylist(Playlist playlist) {
    scanner.nextLine(); // Clear the input buffer
    System.out.print("Enter the name of the song to be added: ");
    String title = scanner.nextLine();
    Song song = new Song(title);
    playlist.insert(song);
    System.out.println("Song added to playlist.");
    System.out.println();
}

private static void removeSongFromPlaylist(Playlist playlist) {
    System.out.print("Enter the number of the song to be deleted: ");
    int songNumber = scanner.nextInt();
    boolean removed = playlist.remove(songNumber);
    if (removed) {
        System.out.println("The song has been deleted from the playlist.");
    } else {
        System.out.println("Invalid song number!");
    }
    System.out.println();
}

private static void createNewPlaylist() {
	scanner.nextLine();
	System.out.print("Enter the new playlist name (you can exit by typing 'exit'): ");
    String playlistName = scanner.nextLine();

    while (!playlistName.equals("exit")) {
        Playlist playlist = new Playlist(playlistName);
        playlists.add(playlist);
        System.out.println("Playlist created: " + playlistName);
        System.out.println();

        System.out.print("Enter the new playlist name (you can exit by typing 'exit'): ");
        playlistName = scanner.nextLine();
    }
}

private static void addSongToFavorites() {
   
	scanner.nextLine();
	System.out.print("Enter the name of the song to add to favorites:");
    String title = scanner.nextLine();

    Song song = favorites.search(title);
    if (song != null) {
        System.out.println("This song is already in the favourites.");
    } else {
        song = new Song(title);
        favorites.insert(song);
        System.out.println("The song has been added to favourites.");
    }

    System.out.println();
}

private static void displayFavorites() {
    System.out.println("Favorites:");
    favorites.outputList();
    System.out.println();
}

private static void removeSongFromFavorites() {
	scanner.nextLine();
	System.out.print("Enter the name of the song you want to delete (you can exit by typing 'quit'): ");
    String title = scanner.nextLine();

    while (!title.equalsIgnoreCase("quit")) {
        boolean removed = favorites.remove(title);
        if (removed) {
            System.out.println("The song has been deleted from favourites.");
        } else {
            System.out.println("The specified song could not be found in the favourites.");
        }

        System.out.println();

        System.out.print("Enter the name of another song you want to delete (you can exit by typing 'quit'):");
        title = scanner.nextLine();
    }

    System.out.println();
}

}