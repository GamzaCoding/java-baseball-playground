package baseballGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BallByBallTest {

    private Ball comBall;

    @BeforeEach
    public void setUp(){
        this.comBall = new Ball(1,2);
    }

    @Test
    @DisplayName("낫싱 테스트")
    public void nothingTest(){
        Ball userBall = new Ball(2,4);
        assertThat(comBall.playBallByBall(userBall)).isEqualTo(BallHint.NOTHING);
    }
    @Test
    @DisplayName("볼 테스트")
    public void ballTest(){
        Ball userBall = new Ball(2,2);
        assertThat(comBall.playBallByBall(userBall)).isEqualTo(BallHint.BALL);
    }

    @Test
    @DisplayName("스트라이크 테스트")
    public void strikeTest(){
        Ball userBall = new Ball(1,2);
        assertThat(comBall.playBallByBall(userBall)).isEqualTo(BallHint.STRIKE);
    }
}
