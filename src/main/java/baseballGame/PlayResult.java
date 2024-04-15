package baseballGame;

public class PlayResult {

    private final int strikePoint;
    private final int ballPoint;

    PlayResult(int strikePoint, int ballPoint){
        this.strikePoint = strikePoint;
        this.ballPoint = ballPoint;
    }

    public int getBallPoint() {
        return ballPoint;
    }

    public int getStrikePoint() {
        return strikePoint;
    }
}
