package baseballGame;

import com.sun.org.apache.xpath.internal.Arg;

public class Ball {
    private final int position;
    private final int number;

    Ball(int position, int number){
        checkException(position, number);

        this.position = position;
        this.number = number;
    }

    private void checkException(int position, int number) {
        if(number < 1 || number > 9){
            throw new IllegalArgumentException("1 ~ 9 사이 값을 입력하세요 ");
        }

        if(position < 1 || position > 3){
            throw new IllegalArgumentException("1 ~ 3 사이의 위치값을 입력하세요");
        }
    }

    public BallHint play(Ball userBall) {
        if(isBall(userBall)){
            return BallHint.BALL;
        }
        if(isStrike(userBall)){
            return BallHint.STRIKE;
        }
        return BallHint.NOTHING;
    }

    private boolean isStrike(Ball userBall) {
        return (position == userBall.position && number == userBall.number);
    }

    private boolean isBall(Ball userBall) {
        return (position != userBall.position && number == userBall.number);
    }


}
