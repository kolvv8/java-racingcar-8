package racingcar.view;

import java.util.List;

public class OutputView {

    private static final String CAR_NAMES_QUESTION = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_COUNT_QUESTION = "시도할 횟수를 입력하세요";

    public void promptCarNames() {
        System.out.println(CAR_NAMES_QUESTION);
    }

    public void promptTryCount() {
        System.out.println(TRY_COUNT_QUESTION);
    }

    public void printExecutionResultHeader() {
        System.out.println("\n실행결과");
    }

    public void printRoundResult(List<String> roundStatus) {
        for (String status : roundStatus) {
            System.out.println(status);
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        String winnerNames = String.join(", ", winners);
        System.out.println("최종 우승자 : " + winnerNames);
    }
}

