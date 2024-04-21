package baseballGame;

import java.util.Arrays;

public class Computer {
    private final static int SETTING_NUM_ONE = 1;
    private final static int SETTING_NUM_TWO = 2;
    private final static int SETTING_NUM_THREE = 3;

    private final Balls comBalls;

    Computer(){
        this.comBalls = new Balls(Arrays.asList(SETTING_NUM_ONE, SETTING_NUM_TWO, SETTING_NUM_THREE));
        comBalls.changeBalls();
    }

    public void changeRandomBalls(){
        comBalls.changeBalls();
    }

    public void play(Balls userBalls){
        PlayResult playResult = comBalls.playBallsByBalls(userBalls);
        OutputView.printGameResult(playResult);
    }

    public boolean isGameEnd(Balls userBalls) {
        return comBalls.isThreeStrike(userBalls);
    }
}
