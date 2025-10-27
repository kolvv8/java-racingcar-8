package racingcar.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SplitCarName {

    private static final String DELIMITER = ",";
    private static final int MAX_NAME_LENGTH = 5;

    public List<String> parseCarNames(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("이름이 입력되지 않았습니다.");
        }

        String[] names = input.split(DELIMITER, -1);
        List<String> carNames = new ArrayList<>();

        for (String name : names) {
            carNames.add(name);
        }

        return carNames;
    }

}

