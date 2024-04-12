package stringCalsulator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class stringCalculatorMainTest {

    @Test
    @DisplayName("문자열 계산기 테스트")
    void calculate() {
        Assertions.assertThat(stringCalculatorMain
                        .calculate("1 + 1 + 2 / 4"))
                        .isEqualTo(1);
    }

    @Test
    @DisplayName("문자열 분리 테스트")
    void StringToArrayTest(){
        String given = "2 + 1 / 3";
        assertThat(stringCalculatorMain.stringToArray(given))
                .containsExactly("2","+","1","/","3");
    }

    @Test
    @DisplayName("")
    void sequenceCal() {
    }

    @Test
    @DisplayName("+,-,*,/ 이외 연산자 입력 시 오류 테스트")
    void illegalOperatorTest() {
        assertThatThrownBy(() -> {
            String given = "1 $ 2";
            String[] array = given.split(" ");
            stringCalculatorMain.sequenceCal(array);
        }).isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("0으로 나누는 예외 테스트")
    void divByZeroTest() {
        assertThatThrownBy(()->{
            String given = "1 / 0";
            String[] array = given.split(" ");
            stringCalculatorMain.sequenceCal(array);
        }).isInstanceOf(ArithmeticException.class);
    }
}