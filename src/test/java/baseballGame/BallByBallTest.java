package baseballGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BallByBallTest {

    Ball comBall;
    @BeforeEach
    void setUp(){
        comBall = new Ball(1,2);
    }

    @Test
    void nothingHintTest(){
        BallHint hint = comBall.play(new Ball(3,4));
        assertThat(hint).isEqualTo(BallHint.NOTHING);
    }

    @Test
    void ballHintTest(){
        BallHint hint = comBall.play(new Ball(3,2));
        assertThat(hint).isEqualTo(BallHint.BALL);
    }

    @Test
    void strikeHintTest(){
        BallHint hint = comBall.play(new Ball(1,2));
        assertThat(hint).isEqualTo(BallHint.STRIKE);
    }


}
