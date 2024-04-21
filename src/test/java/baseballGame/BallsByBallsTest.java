package baseballGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BallsByBallsTest {

    private Balls comBalls;

    @BeforeEach
    public void setUp(){
        this.comBalls = new Balls(Arrays.asList(1,2,3));
    }

    @Test
    @DisplayName("낫싱 테스트")
    public void nothingTest(){
        Balls userBalls = new Balls(Arrays.asList(4, 5, 6));
        assertThat(comBalls.playBallsByBalls(userBalls).getBallCount())
                .isEqualTo(0);
        assertThat(comBalls.playBallsByBalls(userBalls).getStrikeCount())
                .isEqualTo(0);
    }

    @Test
    @DisplayName("볼 테스트")
    public void ballTest(){
        Balls userBalls1 = new Balls(Arrays.asList(5,1,4)); // 1볼
        assertThat(comBalls.playBallsByBalls(userBalls1).getBallCount())
                .isEqualTo(1);

        Balls userBalls2 = new Balls(Arrays.asList(2,1,4)); // 2볼
        assertThat(comBalls.playBallsByBalls(userBalls2).getBallCount())
                .isEqualTo(2);

        Balls userBalls3 = new Balls(Arrays.asList(2,3,1)); // 3볼
        assertThat(comBalls.playBallsByBalls(userBalls3).getBallCount())
                .isEqualTo(3);
    }
    @Test
    @DisplayName("스트라이크 테스트")
    public void strikeTest(){
        Balls userBalls1 = new Balls(Arrays.asList(1,6,7)); // 1스트라이크
        assertThat(comBalls.playBallsByBalls(userBalls1).getStrikeCount())
                .isEqualTo(1);

        Balls userBalls2 = new Balls(Arrays.asList(1,2,4)); // 2스트라이크
        assertThat(comBalls.playBallsByBalls(userBalls2).getStrikeCount())
                .isEqualTo(2);

        Balls userBalls3 = new Balls(Arrays.asList(1,2,3)); // 3스트라이크
        assertThat(comBalls.playBallsByBalls(userBalls3).getStrikeCount())
                .isEqualTo(3);
    }
}
