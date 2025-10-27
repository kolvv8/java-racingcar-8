package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private static final int MOVE_THRESHOLD = 4;
    private static final int MIN_RANDOM_VALUE = 0;
    private static final int MAX_RANDOM_VALUE = 9;

    private final String name;
    private int position;
    private String positionString;

    public Car(String name) {
        this.name = name;
        this.position = 0;
        this.positionString = "";
    }

    public void move() {
        int randomValue = Randoms.pickNumberInRange(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
        if (randomValue >= MOVE_THRESHOLD) {
            position++;
            positionString += "-";
        }
    }
}

