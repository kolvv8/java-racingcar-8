package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Racing {

    private final List<Car> cars;

    public Racing(List<String> carNames) {
        List<Car> carList = new ArrayList<>();

        for (String name : carNames) {
            carList.add(new Car(name));
        }
        this.cars = carList;
    }

    public void playRound() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<String> getCurrentStatus() {
        List<String> statuses = new ArrayList<>();
        for (Car car : cars) {
            statuses.add(car.getCurrentStatusString());
        }
        return statuses;
    }

    public List<Car> getCarList() {
        return Collections.unmodifiableList(cars);
    }

}
