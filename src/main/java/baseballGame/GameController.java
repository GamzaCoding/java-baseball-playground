package baseballGame;

public class GameController {
    private static final int GAME_AGAIN = 1;
    private static final int GAME_ENDING = 2;


    private final Computer computer;

    GameController(){
        this.computer = new Computer();
    }
    public void gamePlay(){
        OutputView.gameStartMessage();
        Balls userBalls = new Balls(InputView.inputNumbers());
        computer.play(userBalls);

        if(computer.isGameEnd(userBalls)){
            OutputView.gameEndingMessage();
            OutputView.gameReplayMessage();

            rePlayGame(InputView.inputReplay());
            return;
        }
        gamePlay();
    }

    private void rePlayGame(int replayNumber) {
        if(replayNumber == GAME_AGAIN){
            computer.changeRandomBalls();
            gamePlay();
        }
        if(replayNumber != GAME_ENDING){
            OutputView.replayGameNumberExceptionMessage();
            throw new IllegalArgumentException();
        }
    }

}
