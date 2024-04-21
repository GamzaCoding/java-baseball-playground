package baseballGame;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String SPLIT_STANDARD = "";

    public static List<Integer> inputNumbers(){
        Scanner scanner = new Scanner(System.in);
        return StringToIntegerList(scanner.nextLine());
    }
    private static List<Integer> StringToIntegerList(String numbers){
        return Arrays.stream(numbers.split(SPLIT_STANDARD))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
    public static int inputReplay(){
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }
}
