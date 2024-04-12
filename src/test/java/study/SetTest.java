package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp(){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }
    @Test
    @DisplayName("setSize 테스트")
    void setSizeTest(){
        int setSize = numbers.size();
        assertThat(setSize).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("Parameterized 테스트")
    @ValueSource(ints = {1,2,3})
    void setContainTest(int ints){
        assertThat(numbers.contains(ints)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("CsvSource 테스트")
    @CsvSource(value = {"1:True", "2:True", "3:True", "4:False", "5:False"}, delimiter = ':')
    void setContainTestWithTrueAndFalse(int input, boolean result){
        assertThat(numbers.contains(input)).isEqualTo(result);
    }
}
