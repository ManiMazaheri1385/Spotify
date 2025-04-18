import app.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        User hayedeh = new User("Hayedeh", "Hayedeh1321");
        User ebi = new User("Ebi", "Ebii1328");
        User dariush = new User("Dariush", "Dariush1329");
        User shahram = new User("ShahramShabpareh", "Sharam1326");
        User moein = new User("Moein", "Moein1330");
        User javad = new User("JavadYasari", "Javad1323");
        User homayoun = new User("HomayounShajarian", "Homayoun1354");

        try {
            User hassan = new User("Hassan", "Hassan");
        } catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }

        try {
            User ebi2 = new User("Ebi", "1328Ebii");
        } catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }

        Music nagoNemiyam = new Music("Nago Nemiyam", hayedeh);
        Music poosteShir = new Music("PoosteShir", ebi);
        Music jabehJavaher = new Music("JabehJavaher", ebi);
        Music ghased = new Music("Ghased", ebi);
        Music chakavak = new Music("Chakavak", dariush);
        Music paria = new Music("Paria", shahram);
        Music khalegh = new Music("Khalegh", moein);
        Music sabreAyoob = new Music("Sabre Ayoob", javad);

        Music first1 = new Music("first", homayoun);
        Music first2 = new Music("first", shahram);
        Music first3 = new Music("first", moein);

        try {
            Music arayesheGhaliz = new Music("", homayoun);
        } catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }

        try {
            Music nago = new Music("Nago Nemiyam", hayedeh);
        } catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }

        // playlist tests:
        System.out.println("*****************************************************************************");
        System.out.println();

        System.out.println("playlist tests:");
        System.out.println();

        try {
            moein.createPlaylist("Pop");
        } catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }

        moein.buyPremium(10);

        moein.createPlaylist("Jazz");

        try {
            moein.createPlaylist("Jazz");
        } catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }

        Playlist moeinPlaylist = moein.getPlaylist("Jazz");

        try {
            moeinPlaylist.playPlaylist();
        } catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }

        moeinPlaylist.addMusic("Moein1330", chakavak);
        moeinPlaylist.addMusic("Moein1330", paria);
        moeinPlaylist.addMusic("Moein1330", khalegh);
        moeinPlaylist.addMusic("Moein1330", sabreAyoob);

        try {
            moeinPlaylist.addMusic("Moein1330", chakavak);
        } catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }

        System.out.println("    Shuffle playing:");
        System.out.println();
        moeinPlaylist.shuffle();

        moeinPlaylist.removeMusic("Moein1330", khalegh);

        moeinPlaylist.addMusic("Moein1330", jabehJavaher);
        moeinPlaylist.addMusic("Moein1330", ghased);

        moeinPlaylist.editTitle("Moein1330", "Classic");

        System.out.println("    Normal playing:");
        System.out.println();
        moeinPlaylist.playPlaylist();

        // playing limit tests:
        System.out.println("*****************************************************************************");
        System.out.println();

        System.out.println("playing limit tests:");
        System.out.println();

        ebi.playMusic(nagoNemiyam);
        ebi.playMusic(poosteShir);
        ebi.playMusic(chakavak);
        ebi.playMusic(sabreAyoob);
        ebi.playMusic(paria);

        try {
            ebi.playMusic(khalegh);
        } catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }

        // follow tests:
        System.out.println("*****************************************************************************");
        System.out.println();

        System.out.println("follow tests:");
        System.out.println();

        hayedeh.follow(ebi);
        hayedeh.follow(dariush);
        hayedeh.follow(shahram);
        moein.follow(shahram);

        System.out.println("Hayedeh flowing: " + hayedeh.getFollowingList().toString());

        System.out.println("Shahram flowers: " + ebi.getFollowerList().toString());

        System.out.println();

        try {
            shahram.follow(shahram);
        } catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }

        // search tests:
        System.out.println("*****************************************************************************");
        System.out.println();

        System.out.println("search tests:");
        System.out.println();

        Music lostMusic1 = Music.search("Chakavak", "Dariush");
        moein.playMusic(lostMusic1);

        try {
            Music lostMusic2 = Music.search("khalegh", "ShahramShabpareh");
        } catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }

        ArrayList<Music> lostMusics = Music.search("first");

        System.out.println(lostMusics);

        System.out.println();

        // search in playlist tests:
        System.out.println("*****************************************************************************");
        System.out.println();

        System.out.println("search in playlist tests:");
        System.out.println();

        Music lostMusicInPlaylist1 = moeinPlaylist.searchInPlaylist("Sabre Ayoob", "JavadYasari");
        moein.playMusic(lostMusicInPlaylist1);

        try {
            Music lostMusicInPlayList2 = Music.search("Sabre Ayoob", "Jabeh");
        } catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }

        moeinPlaylist.addMusic("Moein1330", first1);
        moeinPlaylist.addMusic("Moein1330", first2);
        moeinPlaylist.addMusic("Moein1330", first3);

        ArrayList<Music> lostMusicsInPlaylist = moeinPlaylist.searchInPlaylist("first");

        System.out.println(lostMusicsInPlaylist);
    }
}