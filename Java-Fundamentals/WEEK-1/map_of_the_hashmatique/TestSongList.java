import java.util.Set;
public class TestSongList {
    public static void main(String[] args) {

        SongList trackList = new SongList();
        
        trackList.addSong("Bohemian Rhapsody", "Is this the real life? Is this just fantasy?");
        trackList.addSong("Stairway to Heaven", "There's a lady who's sure all that glitters is gold");
        trackList.addSong("Hotel California", "On a dark desert highway, cool wind in my hair");
        trackList.addSong("Imagine", "Imagine there's no heaven, it's easy if you try");

        Set<String> keys = trackList.getKeySet();
        for(String key : keys) {
            System.out.println(key + " : " + trackList.getSong(key));
        }

        String lyrics = trackList.getSong("Imagine");
        System.out.println(lyrics);
    }
}
