package baseballGame;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class CreateBallTest {

    @Test
    void creatRandomBallsTest(){
        Computer computer = new Computer();
        Balls comFirstRnadomBalls = computer.createRandomBalls();
        Balls comSecondRandomBalls = computer.createRandomBalls();
        PlayResult result = comFirstRnadomBalls.playByFullBallList(comSecondRandomBalls);
        assertThat(result).isNotEqualTo(BallHint.STRIKE);
    }


}
