package baseballGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class ExceptionTest {

    @Test
    @DisplayName("ball 자리값 오류 테스트")
    public void illegalPositionTest(){
        assertThatThrownBy(() -> new Ball(4,3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("ball 넘버값 오류 테스트")
    public void illegalNumberTest(){
        assertThatThrownBy(() -> new Ball(3,0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("balls 중복값 오류 테스트")
    public void duplicationNumberTest(){
        assertThatThrownBy(() -> new Balls(Arrays.asList(1,1,2)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("balls size 오류 테스트")
    public void ballsSizeTest(){
        assertThatThrownBy(() -> new Balls(Arrays.asList(1,2,3,4)))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Balls(Arrays.asList(1,2)))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("재시작 선택 숫자 입력 오류 테스트")
    public void replayGameNumberTest(){
        assertThatThrownBy(() -> new Balls(Arrays.asList(1,1,2)))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
