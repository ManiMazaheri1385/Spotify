package app;

import java.util.ArrayList;

public class Music {
    private static ArrayList<Music> allMusics = new ArrayList<>();

    private String title;
    private User singer;
    private int numberOfStream = 0;

    public Music(String title, User singer) {
        setTitle(title);
        this.singer = singer;
        allMusics.add(this);
    }

    public static void play(Music music) {
        System.out.println("Playing: " + music.title);
        System.out.println("    Singer: " + music.singer.getUsername());

        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            System.out.println("Error: \nSleep interrupted!");
        }

        System.out.println();
        music.numberOfStream++;
    }

    public static Music search (String title, String singerName) {
        for (Music music : allMusics) {
            if (title.equals(music.title) && singerName.equals(music.singer.getUsername())) {
                return music;
            }
        }
        return null;
    }

    public static ArrayList<Music> search (String title) {
        ArrayList<Music> musics = new ArrayList<>();

        for (Music music : allMusics) {
            if (title.equals(music.title)) {
                musics.add(music);
            }
        }

        return musics;
    }

}
