import java.util.HashMap;
import java.util.Set;

public class SongList {

    private HashMap<String, String> trackList = new HashMap<String, String>();
    
    public void addSong(String title, String lyrics) {
        trackList.put(title, lyrics);
    }

    public Set<String> getKeySet() {
        return trackList.keySet();
    }

    public String getSong(String title) {
        return trackList.get(title);
    }

}
