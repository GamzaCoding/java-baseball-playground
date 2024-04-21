package baseballGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CreateRandomBallsTest {

    @Test
    @DisplayName("랜덤 숫자 변환 테스트")
    public void changeRandomNumberTest(){
        Balls balls = new Balls(Arrays.asList(1, 2, 3));
        Balls copyBalls = new Balls(Arrays.asList(1, 2, 3));
        balls.changeBalls();
        assertThat(balls.playBallsByBalls(copyBalls).getStrikeCount() == 3)
                .isFalse();
    }


}
