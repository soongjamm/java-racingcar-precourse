package racingcar;

import java.util.List;

public class Cars {
    private static final int MINIMUM_NUMBER_TO_MOVE = 4;
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void findWinners() {

    }

    public void progressRound() {
        for (Car car : cars) {
            int randomNumber = RandomNumberGenerator.generate();
            if (randomNumber > MINIMUM_NUMBER_TO_MOVE) {
                System.out.println(randomNumber);
                car.goForward();
            }
        }

    }

}
