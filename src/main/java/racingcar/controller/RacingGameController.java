package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Racing;
import racingcar.model.SelectWinner;
import racingcar.model.SplitCarName;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final SplitCarName splitCarName;
    private final SelectWinner selectWinner;

    public RacingGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.splitCarName = new SplitCarName();
        this.selectWinner = new SelectWinner();
    }

    public void run() {
        List<String> carNames = getCarNames();
        int tryCount = getTryCount();

        Racing racing = new Racing(carNames);
        runRace(racing, tryCount);

        getWhoIsWinner(racing);
    }

    private List<String> getCarNames() {
        outputView.promptCarNames();
        String carNamesInput = inputView.readCarNames();
        return splitCarName.parseCarNames(carNamesInput);
    }

    private int getTryCount() {
        outputView.promptTryCount();
        String tryCountInput = inputView.readTryCount();
        return splitCarName.parseTryCount(tryCountInput);
    }

    private void runRace(Racing racing, int tryCount) {
        outputView.printExecutionResultHeader();
        for (int i = 0; i < tryCount; i++) {
            racing.playRound();
            List<String> roundStatus = racing.getCurrentStatus();
            outputView.printRoundResult(roundStatus);
        }
    }

    private void getWhoIsWinner(Racing racing) {
        List<Car> carList = racing.getCarList();
        List<String> winnerNames = selectWinner.findWinnerNames(carList);

        outputView.printWinners(winnerNames);
    }
}
