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
            validateCarName(name);
            carNames.add(name);
        }
        validateDuplicateNames(carNames);
        
        return carNames;
    }

    private void validateCarName(String name) {
        if (name.contains(" ")) {
            throw new IllegalArgumentException("자동차 이름에 공백이 포함될 수 없습니다.");
        }

        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
        }

        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 " + MAX_NAME_LENGTH + "자 이하만 가능합니다.");
        }
    }

    private void validateDuplicateNames(List<String> carNames) {
        Set<String> uniqueNames = new HashSet<>();
        for (String name : carNames) {
            if (!uniqueNames.add(name)) {
                throw new IllegalArgumentException("자동차 이름에 중복이 있습니다.");
            }
        }
    }
}
