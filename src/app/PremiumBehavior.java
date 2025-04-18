package app;

public class PremiumBehavior implements UserBehavior {
    private int month = 0;

    @Override
    public void createPlaylist(String title, User owner) {
        Playlist playlist = new Playlist(title, owner);
    }

    @Override
    public void playMusic(Music music) {
        Music.play(music);
    }

    @Override
    public void buyPremium(User owner, int month) {
        if (month <= 0) {
            throw new InvalidOperationException("Error: \nMonth must be a positive integer");
        }
        this.month += month;
        owner.setBehavior(this);
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (month <= 0) {
            throw new InvalidOperationException("Error: \nMonth must be a positive integer");
        }
        this.month = month;
    }

}
