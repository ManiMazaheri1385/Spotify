package app;

public class RegularBehavior implements UserBehavior{
    private int playingLimit = 5;

    @Override
    public void createPlaylist(String Title, User Owner) {
        throw new InvalidOperationException("Error: \nTo create playlists, you must purchase a premium account.");
    }

    @Override
    public void playMusic(Music music) {
        if (playingLimit <= 0) {
            throw new InvalidOperationException("Error: \nYour free plan has expired, please purchase a premium account.");
        }
        Music.play(music);
        playingLimit--;
    }

    @Override
    public void buyPremium(User owner, int month) {
        UserBehavior behavior = new PremiumBehavior();
        behavior.buyPremium(owner, month);
    }

    public int getPlayingLimit() {
        return playingLimit;
    }

    public void setPlayingLimit(int playingLimit) {
        if (playingLimit < 0) {
            throw new InvalidOperationException("Error: \nplayingLimit cannot be less than 0.");
        }
        this.playingLimit = playingLimit;
    }

}
