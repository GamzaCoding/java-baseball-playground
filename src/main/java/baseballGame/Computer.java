package baseballGame;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final List<NumberBall> computerBallList;

    Computer(){
        List<NumberBall> list = generateThreeNumberBall();

        while(!duplicationNumberBallCheck(list)){
            list = generateThreeNumberBall();
        }

        this.computerBallList = list;
    }

    private List<NumberBall> generateThreeNumberBall(){
        final List<NumberBall> list = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            list.add(createRamdemNumberBall());
        }
        return list;
    }
    private NumberBall createRamdemNumberBall(){
        return new NumberBall(makeRandomNumberOneToNine());
    }

    private int makeRandomNumberOneToNine(){
        return (int)(Math.random() * 9) + 1;
    }

    private boolean duplicationNumberBallCheck(List<NumberBall> list){
        if (compareNumberBallValue(list.get(0), list.get(1)) ||
                compareNumberBallValue(list.get(0), list.get(2)) ||
                compareNumberBallValue(list.get(1), list.get(2)) ){
            return false;
        }
        return true;
    }

    private Boolean compareNumberBallValue(NumberBall firstBall, NumberBall secondBall){
        return firstBall.getValue() == secondBall.getValue();
    }

    public int getComputerNumberBallValue(int index){
        return computerBallList.get(index).getValue();
    }

    public List<Integer> getComputerNumberBallValueList(){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < computerBallList.size(); i++){
            list.add(getComputerNumberBallValue(i));
        }
        return list;
    }
}
