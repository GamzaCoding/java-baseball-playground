package baseballGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BallsByBallTest {

    Balls comBalls;
    @BeforeEach
    void setUp(){
        comBalls = new Balls(Arrays.asList(1,2,3));
    }
    @Test
    void BallsNothingTest(){
        BallHint hint = comBalls.play(new Ball(2,6));
        assertThat(hint).isEqualTo(BallHint.NOTHING);
    }

    @Test
    void BallsBallTest(){
        BallHint hint = comBalls.play(new Ball(1,2));
        assertThat(hint).isEqualTo(BallHint.BALL);
    }

    @Test
    void BallsStrikeTest(){
        BallHint hint = comBalls.play(new Ball(2,2));
        assertThat(hint).isEqualTo(BallHint.STRIKE);
    }


}
