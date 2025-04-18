package app;

import java.util.ArrayList;
import java.util.Random;

public class Playlist {
    private User owner;
    private String title;
    private ArrayList<Music> playlist = new ArrayList<>();

    public Playlist(String title, User owner) {
        setTitle(title);
        this.owner = owner;
    }

    public void editTitle(String password, String title) {
        if (!password.equals(owner.getPassword())) {
            throw new InvalidOperationException("Error: \nPassword does not match");
        }

        setTitle(title);
    }

    public void addMusic(String password, Music music) {
        if (!password.equals(owner.getPassword())) {
           throw new InvalidOperationException("Error: \nPassword does not match");
        }

        if (playlist.contains(music)) {
            throw new InvalidOperationException("Error: \nMusic already exists in playlist");
        }

        playlist.add(music);
    }

    public void removeMusic(String password, Music music) {
        if (!password.equals(owner.getPassword())) {
            throw new InvalidOperationException("Error: \nPassword does not match");
        }

        if (playlist.contains(music)) {
            playlist.remove(music);
        }

        throw new InvalidOperationException("Error: \nMusic does not exist in playlist");
    }

    public Music searchInPlaylist (String title, String singer) {
        if (playlist.isEmpty()) {
            throw new InvalidOperationException("Error: \nPlaylist is empty");
        }

        for (Music music : playlist) {
            if (title.equals(music.getTitle()) && singer.equals(music.getSinger().getUsername())) {
                return music;
            }
        }

        return null;
    }

    public ArrayList<Music> searchInPlaylist (String title) {
        ArrayList<Music> musics = new ArrayList<>();

        if (playlist.isEmpty()) {
            throw new InvalidOperationException("Error: \nPlaylist is empty");
        }

        for (Music music : playlist) {
            if (title.equals(music.getTitle())) {
                musics.add(music);
            }
        }

        return musics;
    }

    public void playPlaylist () {
        if (playlist.isEmpty()) {
            throw new InvalidOperationException("Error: \nPlaylist is empty");
        }

        for (Music music : playlist) {
            Music.play(music);
        }

    }

    public void shuffle() {
        if (playlist.isEmpty()) {
            throw new InvalidOperationException("Error: \nPlaylist is empty");
        }

        ArrayList<Music> musics = new ArrayList<>(playlist);

        Random random = new Random();

        while (!musics.isEmpty()) {
            int index = random.nextInt(musics.size());
            Music music = musics.remove(index);
            Music.play(music);
        }

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new InvalidOperationException("Error: \nTitle cannot be null or empty");
        }
        this.title = title;
    }

    public ArrayList<Music> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(ArrayList<Music> playlist) {
        this.playlist = playlist;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

}
