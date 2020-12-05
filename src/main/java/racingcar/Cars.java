package racingcar;

import View.OutputView;
import exceptions.Validator;
import utils.RandomNumber;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final int MINIMUM_NUMBER_TO_MOVE = 4;
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        Validator.validateCarsSize(cars);
        Validator.validateCarNameLength(cars);
        this.cars = cars;
    }

    public void showCurrentStatus() {
        OutputView.printCurrentStatus(cars);
    }

    public void progressTurn() {
        for (Car car : cars) {
            compareRandomNumberAndMove(car);
        }
    }

    public List<Car> findWinners() {
        return findCoWinners(findOneWinner());
    }

    private List<Car> findCoWinners(Car winner) {
        return cars.stream()
                .filter(car -> car.isSamePositionAs(winner))
                .collect(Collectors.toList());
    }

    private Car findOneWinner() {
        return cars.stream()
                .max(Car::compareTo)
                .get();
    }

    private void compareRandomNumberAndMove(Car car) {
        if (RandomNumber.generate() >= MINIMUM_NUMBER_TO_MOVE) {
            car.moveCarForward();
        }
    }

}
