package baseballGame;

import java.util.ArrayList;
import java.util.List;

public class Rule {
    private static final int LENGTH_OF_INPUT_NUMBER = 3;
    private static final int MAX_INPUT_NUMBER = 987;
    private static final int MIN_INPUT_NUMBER = 123;
    private final List<Integer> inputNumberList;
    private final Computer computer;

    Rule(Computer computer, String inputNumber){
        checkError(inputNumber);
        this.computer = computer;
        inputNumberList = stringToIntegerList(inputNumber);
    }

    private void checkError(String inputNumber){
        if(!checkInputNumberIsNumber(inputNumber)){
            throw new IllegalArgumentException("입력 형태 오류 : 입력값이 숫자가 아닙니다.");
        }

        if(inputNumber.length() != LENGTH_OF_INPUT_NUMBER){
            throw new IllegalArgumentException("입력 숫자 자리수 오류 : 3자리 수를 입력해주세요");
        }

        if(MIN_INPUT_NUMBER > Integer.parseInt(inputNumber) || Integer.parseInt(inputNumber) > MAX_INPUT_NUMBER){
            throw new IllegalArgumentException("입력값 범위 오류 : 입력한 숫자의 범위가 123 미만 또는 987 초과 입니다.");
        }

        if(!checkDuplicationInputNumber(inputNumber)){
            throw new IllegalArgumentException("서로 다른 3개의 수를 입력해 주세요");
        }
    }

    private boolean checkInputNumberIsNumber(String inputNumber){
        try{
            int number = Integer.parseInt(inputNumber);
        } catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    private List<Integer> stringToIntegerList(String number){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            list.add(charToInt(number.charAt(i)));
        }
        return list;
    }

    private int charToInt(char token){
        return Integer.parseInt(String.valueOf(token));
    }

    private boolean checkDuplicationInputNumber(String inputNumber){
        if(charToInt(inputNumber.charAt(0)) == charToInt(inputNumber.charAt(1)) ||
                charToInt(inputNumber.charAt(0)) == charToInt(inputNumber.charAt(2)) ||
                charToInt(inputNumber.charAt(1)) == charToInt(inputNumber.charAt(2))){
            return false;
        }
        return true;
    }

    private int[] ballAndStrikeCheck(){ /// 스트라이크 볼 낫띵 체크 로직이 어렵다, 이게 메인 로직인데...
        int ballCount = 0;
        int strikeCount = 0;

        for(int i = 0; i < LENGTH_OF_INPUT_NUMBER; i++){
            ballCount += ballCheck(inputNumberList.get(i), i);
            strikeCount += strikeCheck(inputNumberList.get(i), i);
        }

        return new int[]{ballCount,strikeCount};
    }

    private int ballCheck(int number, int numberIndex){
        int ballCount = 0;
        List<Integer> list = deepCopyList(computer.getComputerNumberBallValueList());
        list.remove(numberIndex);

        if(list.contains(number)){
            ballCount += 1;
        }

        return ballCount;
    }

    private List<Integer> deepCopyList(List<Integer> list){
        List<Integer> copiedList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++){
            copiedList.add(list.get(i));
        }
        return copiedList;
    }

    private int strikeCheck(int number, int numberIndex){
        int strikeCount = 0;

        if(computer.getComputerNumberBallValue(numberIndex)==number){
            strikeCount += 1;
        }
        return strikeCount;
    }

    public void resultPrint(){
        int[] strikeAndBallCount = ballAndStrikeCheck();
        final int BALL = 0;
        final int STRIKE = 1;

        if(strikeAndBallCount[BALL] == 0 && strikeAndBallCount[STRIKE] == 0){
            System.out.println("낫싱");
        }
        if(strikeAndBallCount[BALL] > 0 && strikeAndBallCount[STRIKE] == 0){
            System.out.printf("%d볼",strikeAndBallCount[BALL]);
            System.out.println();
        }
        if(strikeAndBallCount[BALL] == 0 && strikeAndBallCount[STRIKE] > 0){
            System.out.printf("%d스트라이크",strikeAndBallCount[STRIKE]);
            System.out.println();
        }
        if(strikeAndBallCount[BALL] > 0 && strikeAndBallCount[STRIKE] > 0){
            System.out.printf("%d볼 %d스트라이크",strikeAndBallCount[BALL], strikeAndBallCount[STRIKE]);
            System.out.println();
        }

        if(strikeAndBallCount[STRIKE] == 3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
        }
    }

    public boolean isGameEnding() {
        if (ballAndStrikeCheck()[1] == 3) {
            return true;
        }
        return false;
    }
}
