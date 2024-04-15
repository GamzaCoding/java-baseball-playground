package baseballGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.aggregator.ArgumentAccessException;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class ExceptionTest {

    @Test
    @DisplayName("1 ~ 9 이외의 숫자가 입력된 예외")
    void outOfOneToNineTest() {
        assertThatThrownBy(() -> new Ball(1, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("1 ~ 3 이외의 위치값이 입력된 예외")
    void outOfPositionTest() {
        assertThatThrownBy(() -> new Ball(4, 3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복된 숫자가 입력된 예")
    void notNumberInputTest() {
        assertThatThrownBy(() -> new Balls(Arrays.asList(1,1,2)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

