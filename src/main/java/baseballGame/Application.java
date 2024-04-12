package baseballGame;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Computer computer = new Computer();
        Scanner scanner = new Scanner(System.in);


        while (true){
            System.out.print("숫자를 입력해 주세요 : ");
            Rule rule = new Rule(computer, scanner.nextLine());
            rule.resultPrint();

            if(rule.isGameEnding()){
                break;
            }
        }


    }
}
