package baseballGame;

import java.util.Objects;

public class Ball {
    private static final int POSITION_START = 1;
    private static final int POSITION_END = 3;
    private static final int NUMBER_START = 1;
    private static final int NUMBER_END = 9;

    private final int position;
    private final int number;

    Ball(int position, int number){
        checkPositionException(position);
        checkNumberException(number);
        this.position = position;
        this.number = number;
    }

    private void checkNumberException(int number) {
        if(number < NUMBER_START || number > NUMBER_END){
            OutputView.numberExceptionMessage();
            throw new IllegalArgumentException();
        }
    }

    private void checkPositionException(int position) {
        if (position < POSITION_START || position > POSITION_END){
            OutputView.positionExceptionMessage();
            throw new IllegalArgumentException();
        }
    }


    public BallHint playBallByBall(Ball ball) {
        if(isBall(ball)){
            return BallHint.BALL;
        }
        if(isStrike(ball)){
            return BallHint.STRIKE;
        }
        return BallHint.NOTHING;
    }

    private boolean isStrike(Ball ball) {
        return equals(ball);
    }

    private boolean isBall(Ball ball) {
        return position != ball.position && number == ball.number;
    }

    public int getNumber() {
        return number;
    }

    public int getPosition(){
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return position == ball.position && number == ball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, number);
    }
}
