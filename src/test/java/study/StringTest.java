package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("요구사항 1-A")
    void splitTest01(){
        String[] str = "1,2".split(",");
        assertThat(str).contains("1");
        assertThat(str).contains("2");
        assertThat(str).contains("1", "2");
        assertThat(str).contains("2", "1");
        assertThat(str).contains("2", "2");
        assertThat(str).contains("2", "1", "1");
        assertThat(str).containsExactly("1","2");
    }
    @Test
    @DisplayName("요구사항 1-B")
    void splitTest02(){
        String[] str = "1".split(",");
        assertThat(str).contains("1");
    }

    @Test
    @DisplayName("요구사항 2")
    void substringTest(){
        String str = "(1,2)".substring(1,4);
        assertThat(str).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항 3 ,StringIndexOutOfBoundsException 연습")
    void strExceptionTest(){
        String input = "abc";
        char strPoint0 = input.charAt(0);
        char strPoint1 = input.charAt(1);
        char strPoint2 = input.charAt(2);
        assertThat(strPoint0).isEqualTo('a');
        assertThat(strPoint1).isEqualTo('b');
        assertThat(strPoint2).isEqualTo('c');

        assertThatThrownBy(() -> input.charAt(input.length()))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range");
    }
}
