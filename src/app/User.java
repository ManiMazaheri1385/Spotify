package app;

import java.util.ArrayList;

public class User {
    private static ArrayList<User> allUsers = new ArrayList<>();

    private String username;
    private String password;
    private UserBehavior behavior;
    private ArrayList<User> followerList = new ArrayList<>();
    private ArrayList<User> followingList = new ArrayList<>();
    private ArrayList<Playlist> playlistList = new ArrayList<>();

    public User(String username, String password) {
        setUsername(username);
        setPassword(password);
        behavior = new RegularBehavior();
        allUsers.add(this);

        System.out.println("User: " + username + " successfully created.");
        System.out.println();
    }

    public void follow (User user) {
        if (user.equals(this)) {
            throw new InvalidOperationException("Error: \nYou can't follow this yourself.");
        }

        if (followerList.contains(user)) {
            throw new InvalidOperationException("Error: \nYou already followed this user.");
        }

        followingList.add(user);
        user.followerList.add(this);
    }

    public void createPlaylist (String title) {
        for (Playlist playlist : playlistList) {
            if (playlist.getTitle().equals(title)) {
                throw new InvalidOperationException("Error: \nPlaylist already exists.");
            }
        }
        this.behavior.createPlaylist(title, this);
    }

    public void playMusic (Music music) {
        this.behavior.playMusic(music);
    }

    public void buyPremium (int month) {
        this.behavior.buyPremium(this, month);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username == null || username.isEmpty()) {
            throw new InvalidOperationException("Error: \nUsername cannot be null or empty.");
        }

        for (User user : allUsers) {
            if (username.equals(user.username)) {
                throw new InvalidOperationException("Error: \nUsername is already in use.");
            }
        }

        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password.length() < 8) {
            throw new InvalidOperationException("Error: \nPassword must be at least 8 characters.");
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

    public ArrayList<Playlist> getPlaylistList() {
        return playlistList;
    }

    public void addToPlaylist (Playlist playlist) {
        playlistList.add(playlist);
    }

    public Playlist getPlaylist (String title) {
        if (playlistList.isEmpty()) {
            throw new InvalidOperationException("Error: \nPlaylistList is empty.");
        }
        for (Playlist playlist : playlistList) {
            if (playlist.getTitle().equals(title)) {
                return playlist;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return username;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        User user = (User) object;
        return username.equals(user.username);
    }

}
