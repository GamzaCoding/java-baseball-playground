package baseballGame;

public class PlayResult {

    private final int ballCount;
    private final int strikeCount;

    PlayResult(int ballCont, int strikeCount){
        this.ballCount = ballCont;
        this.strikeCount = strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }
}
