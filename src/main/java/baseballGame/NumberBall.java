package baseballGame;

public class NumberBall {
    private final int value;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;


    NumberBall(int value){
        if(!(MIN_VALUE <= value && value <= MAX_VALUE)){
            throw new IllegalArgumentException("1 ~ 9 사이의 수가 아닙니다.");
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
