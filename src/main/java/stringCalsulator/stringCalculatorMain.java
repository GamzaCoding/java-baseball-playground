package stringCalsulator;

import java.util.Scanner;

public class stringCalculatorMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String strings= scanner.nextLine(); // "2 + 3 * 4 / 2"

        System.out.println(calculate(strings));
    }

    public static int calculate(String strings){
        return sequenceCal(stringToArray(strings));
    }

    public static String[] stringToArray(String string){
        return string.split(" ");
    }

    public static int sequenceCal(String[] array){
        int initNum = stringToInt(array[0]);
        int result = initNum;

        for(int i = 0; i < array.length - 2; i+=2){
            result = operate(result, array[i+1], stringToInt(array[i+2]));
        }
        return result;
    }
    public static int stringToInt(String string){
        return Integer.parseInt(string);
    }

    public static int operate(int firstNum, String operation, int secondNum){
        if(operation.equals("+")) {
            return sum(firstNum, secondNum);
        }
        if(operation.equals("-")) {
            return sub(firstNum, secondNum);
        }
        if(operation.equals("*")) {
            return mul(firstNum, secondNum);
        }
        if(operation.equals("/")) {
            return div(firstNum, secondNum);
        }
        throw new IllegalStateException("연산자 입력이 잘못되었습니다. 확인바랍니다.");
    }

    private static int sum(int firstNum, int secondNum){
        return firstNum + secondNum;
    }
    private static int sub(int firstNum, int secondNum){
        return firstNum - secondNum;
    }
    private static int mul(int firstNum, int secondNum){
        return firstNum * secondNum;
    }
    public static int div(int firstNum, int secondNum){
        if(secondNum == 0){
            throw new ArithmeticException("0으로 나누는 것은 허용하지 않습니다.");
        }
        return firstNum / secondNum;
    }

}
