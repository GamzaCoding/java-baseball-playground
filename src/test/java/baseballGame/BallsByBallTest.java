package baseballGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BallsByBallTest {


    private Balls comBalls;

    @BeforeEach
    public void setUp(){
        this.comBalls = new Balls(Arrays.asList(1,2,3));
    }

    @Test
    @DisplayName("낫싱 테스트")
    public void nothingTest(){
        Ball userBall = new Ball(1, 4);
        assertThat(comBalls.playBallsByBall(userBall)).isEqualTo(BallHint.NOTHING);
    }

    @Test
    @DisplayName("볼 테스트")
    public void ballTest(){
        Ball userBall = new Ball(1, 2);
        assertThat(comBalls.playBallsByBall(userBall)).isEqualTo(BallHint.BALL);
    }

    @Test
    @DisplayName("스트라이크 테스트")
    public void strikeTest(){
        Ball userBall = new Ball(1, 1);
        assertThat(comBalls.playBallsByBall(userBall)).isEqualTo(BallHint.STRIKE);
    }

}
