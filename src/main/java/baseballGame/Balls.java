package baseballGame;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private final List<Ball> ballList;
    Balls(List<Integer> userBallNumbers){
        checkException(userBallNumbers);
        this.ballList = mapBall(userBallNumbers);
    }

    private void checkException(List<Integer> userBallNumbers) {
        if(userBallNumbers.get(0) == userBallNumbers.get(1) ||
                userBallNumbers.get(0) == userBallNumbers.get(2) ||
                userBallNumbers.get(1) == userBallNumbers.get(2)){
            throw new IllegalArgumentException("숫자를 중복해서 입력할 수 없습니다.");
        }
    }

    private List<Ball> mapBall(List<Integer> userBallNumbers) {
        final List<Ball> list = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            list.add(new Ball(i+1, userBallNumbers.get(i)));
        }
        return list;
    }
    public BallHint play(Ball userBall) {
        for (Ball ball : ballList) {
            if(ball.play(userBall) == BallHint.BALL){
                return BallHint.BALL;
            }
            if(ball.play(userBall) == BallHint.STRIKE){
                return BallHint.STRIKE;
            }
        }
        return BallHint.NOTHING;
    }

    public PlayResult playByFullBallList(Balls userBalls) {
        int strikePoint = 0;
        int ballPoint = 0;
        for (Ball userBall : userBalls.ballList) {
            if(play(userBall) == BallHint.BALL){
                ballPoint++;
            }
            if (play(userBall) == BallHint.STRIKE){
                strikePoint++;
            }
        }
        return new PlayResult(strikePoint, ballPoint);
    }
}
