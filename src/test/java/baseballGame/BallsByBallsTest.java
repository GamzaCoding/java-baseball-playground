package baseballGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BallsByBallsTest {

    Balls comBalls;
    @BeforeEach
    void setUp(){
        comBalls = new Balls(Arrays.asList(1,2,3));
    }
    @Test
    void nothingTest(){
        PlayResult result = comBalls.playByFullBallList(new Balls(Arrays.asList(8,4,5)));
        assertThat(result.getStrikePoint()).isEqualTo(0);
        assertThat(result.getBallPoint()).isEqualTo(0);
    }
    @Test
    void BallTest(){
        PlayResult result = comBalls.playByFullBallList(new Balls(Arrays.asList(2,4,5)));
        assertThat(result.getStrikePoint()).isEqualTo(0);
        assertThat(result.getBallPoint()).isEqualTo(1);
    }

    @Test
    void StrikeTest(){
        PlayResult result = comBalls.playByFullBallList(new Balls(Arrays.asList(1,2,3)));
        assertThat(result.getStrikePoint()).isEqualTo(3);
        assertThat(result.getBallPoint()).isEqualTo(0);
    }

    @Test
    void StrikeAndBallTest(){
        PlayResult result = comBalls.playByFullBallList(new Balls(Arrays.asList(1,3,2)));
        assertThat(result.getStrikePoint()).isEqualTo(1);
        assertThat(result.getBallPoint()).isEqualTo(2);
    }

}
