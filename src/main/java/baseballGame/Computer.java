package baseballGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Computer {

    public Balls createRandomBalls() {
        return new Balls(notDuplicateList());
    }

    private List<Integer> notDuplicateList() {
        List<Integer> list = createRandomThreeNumbers();

        while(!duplicateCheck(list)){
            list = createRandomThreeNumbers();
        }
        return list;
    }

    private boolean duplicateCheck(List<Integer> list) {
        if(list.get(0) == list.get(1) ||
                list.get(0) == list.get(2) ||
                list.get(1) == list.get(2)){
            return false;
        }
        return true;
    }

    private List<Integer> createRandomThreeNumbers() {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            list.add((int)(Math.random() * 9) + 1);
        }
        return list;
    }


}
