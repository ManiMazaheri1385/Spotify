package app;

import java.util.ArrayList;

public class User {
    private static ArrayList<User> allUsers = new ArrayList<User>();

    private String username;
    private String password;
    private ArrayList<User> followerList = new ArrayList<User>();
    private ArrayList<User> followingList = new ArrayList<User>();
    private UserBehavior behavior;

    void follow (User user) {}

    void createPlaylist (String title, User owner){}

    void playMusic (Music music) {}

    void buyPremium (User owner, int month) {}

}
