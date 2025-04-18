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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username == null || username.isEmpty()) {
            throw new InvalidOperationException("Error: \nUsername cannot be null or empty");
        }

        for (User user : allUsers) {
            if (username.equals(user.username)) {
                throw new InvalidOperationException("Error: \nUsername is already in use");
            }
        }

        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password.length() < 8) {
            throw new InvalidOperationException("Error: \nPassword must be at least 8 characters");
        }

        this.password = password;
    }

    public UserBehavior getBehavior() {
        return behavior;
    }

    public void setBehavior(UserBehavior behavior) {
        this.behavior = behavior;
    }

    public ArrayList<User> getAllUsers() {
        return allUsers;
    }

    public ArrayList<User> getFollowerList() {
        return followerList;
    }

    public ArrayList<User> getFollowingList() {
        return followingList;
    }

}
