package baseballGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Balls {
    private final static int SETTING_NUM_ONE = 1;
    private final static int SETTING_NUM_TWO = 2;
    private final static int SETTING_NUM_THREE = 3;
    private final static int BALLS_SIZE = 3;
    private final static int INDEX_CORRECTION = 1;
    private final static int STRIKE_POINT_ZERO = 0;
    private final static int BALL_POINT_ZERO = 0;
    private final static int MAX_BALL_NUMBER = 9;
    private final static int MIN_BALL_NUMBER = 1;
    private final static int BALLS_START_INDEX = 0;
    private final static int THREE_STRIKE_POINT = 3;


    private final List<Ball> balls;

    Balls(List<Integer> balls){
        checkDuplicateException(balls);
        checkBallSizeException(balls);

        this.balls = mapBalls(balls);
    }

    private void checkBallSizeException(List<Integer> balls) {
        if(!isSizeThree(balls)){
            OutputView.ballsSizeExceptionMessage();
            throw new IllegalArgumentException();
        }
    }

    private boolean isSizeThree(List<Integer> balls) {
        if(balls.size() != BALLS_SIZE){
            return false;
        }
        return true;
    }

    private void checkDuplicateException(List<Integer> balls) {
        if(isDuplicate(balls)){
            OutputView.duplicationExceptionMessage();
            throw new IllegalArgumentException();
        }
    }

    private boolean isDuplicate(List<Integer> balls) {
        return balls.stream()
                .distinct()
                .count() != balls.size();
    }

    private List<Ball> mapBalls(List<Integer> numbers) {
        return Stream.of(SETTING_NUM_ONE, SETTING_NUM_TWO, SETTING_NUM_THREE)
                .map(position -> new Ball(position, numbers.get(position - INDEX_CORRECTION)))
                .collect(Collectors.toList());
    }

    public BallHint playBallsByBall(Ball userBall) {
        if(isBall(userBall)){
            return BallHint.BALL;
        }
        if(isStrike(userBall)){
            return BallHint.STRIKE;
        }
        return BallHint.NOTHING;
    }

    private boolean isStrike(Ball userBall) {
        int result = (int)balls.stream()
                .filter(ball -> ball.equals(userBall))
                .count();

        return result > STRIKE_POINT_ZERO;
    }

    private boolean isBall(Ball userBall) {
        int result = (int)balls.stream()
                .filter(ball -> ball.getPosition() != userBall.getPosition() &&
                        ball.getNumber() == userBall.getNumber())
                .count();

        return result > BALL_POINT_ZERO;
    }

    public PlayResult playBallsByBalls(Balls userBalls) {
        int ballCount = (int)userBalls.balls.stream()
                .filter(userBall -> playBallsByBall(userBall) == BallHint.BALL)
                .count();

        int strikeCount = (int)userBalls.balls.stream()
                .filter(userBall -> playBallsByBall(userBall) == BallHint.STRIKE)
                .count();

        return new PlayResult(ballCount, strikeCount);
    }

    private List<Integer> createRandomNumber(){
        List<Integer> list0;
        List<Integer> list1 = Stream.of(SETTING_NUM_ONE, SETTING_NUM_TWO, SETTING_NUM_THREE)
                .map(number -> (int)(Math.random() * MAX_BALL_NUMBER) + MIN_BALL_NUMBER)
                .collect(Collectors.toList());

        list0 = list1;

        if(isDuplicate(list1)){
            list0 = createRandomNumber();
        }

        return list0;
    }

    public void changeBalls(){
        List<Integer> newNumbers = createRandomNumber();
        balls.clear();
        for(int i = BALLS_START_INDEX; i < BALLS_SIZE; i++){
            balls.add(new Ball(i+INDEX_CORRECTION, newNumbers.get(i)));
        }
    }

    public boolean isThreeStrike(Balls userBalls) {
        return playBallsByBalls(userBalls).getStrikeCount() == THREE_STRIKE_POINT;
    }
}
