package app;

import java.util.ArrayList;

public class User {
    private static ArrayList<User> allUsers = new ArrayList<>();

    private String username;
    private String password;
    private UserBehavior behavior;
    private ArrayList<User> followerList = new ArrayList<>();
    private ArrayList<User> followingList = new ArrayList<>();

    public User(String username, String password) {
        setUsername(username);
        setPassword(password);
        behavior = new RegularBehavior();
        allUsers.add(this);
    }

    void follow (User user) {
        followerList.add(user);
        user.followingList.add(this);
    }

    public void createPlaylist (String title, User owner) {
        this.behavior.createPlaylist(title, owner);
    }

    public void playMusic (Music music) {
        this.behavior.playMusic(music);
    }

    public void buyPremium (User owner, int month) {
        this.behavior.buyPremium(owner, month);
    }

    void playMusic (Music music) {}

    void buyPremium (User owner, int month) {}

}
