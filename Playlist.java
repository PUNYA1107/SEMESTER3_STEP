import java.util.Arrays;

class Playlist {
    private final String[] songs;
    private int count;

    public Playlist(int capacity) {
        this.songs = new String[capacity];
        this.count = 0;
    }

    public void addSong(String song) {
        if (count < songs.length) {
            songs[count] = song;
            count++;
        } else {
            System.out.println("Playlist is full!");
        }
    }

    public int getSongCount() {
        return count;
    }

    // Returns a safe copy of the stored songs array
    public String[] getSongs() {
        return Arrays.copyOf(songs, count);
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        copy[0] = "Hacked"; // Mutates only the local copy

        System.out.println("Original playlist song 0: " + p.getSongs()[0]); // Outputs "Song A"
        System.out.println("Copy array song 0: " + copy[0]);               // Outputs "Hacked"
        System.out.println("Total song count: " + p.getSongCount());
    }
}
