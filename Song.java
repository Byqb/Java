public class Song {
    String title;
    String artist;
    Song next;

    public Song(String t, String a) {
        title = t;
        artist = a;
        next = null;
    }
}
