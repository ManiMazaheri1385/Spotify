package app;

import java.util.ArrayList;

public class Music {
    private static ArrayList<Music> allMusics = new ArrayList<>();

    private String title;
    private User singer;
    private int numberOfStream = 0;

    public Music(String title, User singer) {
        setTitle(title);
        setSinger(singer);
        allMusics.add(this);

        System.out.println("Music: " + title + " " + singer.getUsername() + " successfully created.");
        System.out.println();
    }

    public static void play(Music music) {
        System.out.println("Playing: " + music.title);
        System.out.println("    Singer: " + music.singer.getUsername());

        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            System.out.println("Error: \nSleep interrupted!");
        }

        System.out.println();
        music.numberOfStream++;
    }

    public static Music search (String title, String singerName) {
        if (allMusics.isEmpty()) {
            throw new InvalidOperationException("Music list is empty!");
        }

        for (Music music : allMusics) {
            if (title.equals(music.title) && singerName.equals(music.singer.getUsername())) {
                return music;
            }
        }

        return null;
    }

    public static ArrayList<Music> search (String title) {
        if (allMusics.isEmpty()) {
            throw new InvalidOperationException("Music list is empty!");
        }

        ArrayList<Music> musics = new ArrayList<>();

        for (Music music : allMusics) {
            if (title.equals(music.title)) {
                musics.add(music);
            }
        }

        return musics;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new InvalidOperationException("Error: \nTitle cannot be null or empty.");
        }

        for (Music music : allMusics) {
            if (music.singer.equals(singer) && title.equals(music.title)) {
                throw new InvalidOperationException("Error: \nMusic already exists.");
            }
        }

        this.title = title;
    }

    public User getSinger() {
        return singer;
    }

    public void setSinger(User singer) {
        if (singer == null) {
            throw new InvalidOperationException("Error: \nSinger cannot be null.");
        }

        for (Music music : allMusics) {
            if (singer.equals(music.singer) && title.equals(music.title)) {
                throw new InvalidOperationException("Error: \nMusic already exists.");
            }
        }

        this.singer = singer;
    }

    public int getNumberOfStream() {
        return numberOfStream;
    }

    @Override
    public String toString() {
        return "(" + title + ", " + singer + ")";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Music music = (Music) object;
        return title.equals(music.title) && singer.equals(music.singer);
    }

}
