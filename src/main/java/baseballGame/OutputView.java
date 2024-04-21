package baseballGame;

public class OutputView {
    private static final String GAME_START_MESSAGE = "숫자를 입력해 주세요 : ";
    private static final String GAME_ENDING_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임종료";
    private static final String GAME_REPLAY_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";
    private static final String NUMBER_EXCEPTION_MESSAGE = "숫자는 1 ~ 9의 값만 허용합니다.";
    private static final String POSITION_EXCEPTION_MESSAGE = "자리값은 1,2,3만 허용합니다.";
    private static final String BALLS_SIZE_EXCEPTION_MESSAGE = "3자리 숫자를 입력해야 합니다.";
    private static final String DUPLICATION_EXCEPTION_MESSAGE = "볼의 숫자는 중복되면 안됩니다.";
    private static final String REPLAY_GAME_NUMBER_EXCEPTION_MESSAGE = "1, 2 이외의 숫자는 허용하지 않습니다.";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String BALL_MESSAGE = "%d볼\n";
    private static final String STRIKE_MESSAGE = "%d스트라이크\n";
    private static final String BALL_AND_STRIKE_MESSAGE = "%d볼 %d스트라이크\n";

    private static final int ZERO_POINT = 0;


    public static void gameReplayMessage(){
        System.out.println(GAME_REPLAY_MESSAGE);
    }
    public static void gameEndingMessage(){
        System.out.println(GAME_ENDING_MESSAGE);
    }
    public static void gameStartMessage(){
        System.out.print(GAME_START_MESSAGE);
    }

    public static void numberExceptionMessage(){
        System.out.println(NUMBER_EXCEPTION_MESSAGE);
    }

    public static void positionExceptionMessage(){
        System.out.println(POSITION_EXCEPTION_MESSAGE);
    }

    public static void ballsSizeExceptionMessage(){
        System.out.println(BALLS_SIZE_EXCEPTION_MESSAGE);
    }
    public static void duplicationExceptionMessage(){
        System.out.println(DUPLICATION_EXCEPTION_MESSAGE);
    }
    public static void replayGameNumberExceptionMessage(){
        System.out.println(REPLAY_GAME_NUMBER_EXCEPTION_MESSAGE);
    }

    public static void printPlayResultNothing(int ballPoint, int strikePoint){
        if(strikePoint == ZERO_POINT && ballPoint == ZERO_POINT){
            System.out.println(NOTHING_MESSAGE);
        }
    }
    public static void printPlayResultBall(int ballPoint, int strikePoint){
        if(strikePoint == ZERO_POINT && ballPoint > ZERO_POINT){
            System.out.printf(BALL_MESSAGE,ballPoint);
        }
    }
    public static void printPlayResultStrike(int ballPoint, int strikePoint){
        if(strikePoint > ZERO_POINT && ballPoint == ZERO_POINT){
            System.out.printf(STRIKE_MESSAGE,strikePoint);
        }
    }
    public static void printPlayResultBallAndStrike(int ballPoint, int strikePoint){
        if(strikePoint > ZERO_POINT && ballPoint > ZERO_POINT){
            System.out.printf(BALL_AND_STRIKE_MESSAGE,ballPoint,strikePoint);
        }
    }
    public static void printGameResult(PlayResult playResult) {
        OutputView.printPlayResultNothing(playResult.getBallCount(), playResult.getStrikeCount());
        OutputView.printPlayResultBall(playResult.getBallCount(), playResult.getStrikeCount());
        OutputView.printPlayResultStrike(playResult.getBallCount(), playResult.getStrikeCount());
        OutputView.printPlayResultBallAndStrike(playResult.getBallCount(), playResult.getStrikeCount());
    }

}
