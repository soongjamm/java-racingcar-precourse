package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final int MINIMUM_NUMBER_TO_MOVE = 4;
    private static List<Car> cars = new ArrayList<>();

    public static void add(Car car) {
        cars.add(car);
    }

    public static void findWinners() {
        Car winner = findOneWinner();
        List<Car> winners = cars.stream()
                .filter(car -> winner.isSamePosition(car))
                .collect(Collectors.toList());
        OutputView.printWinners(winners);
    }

    private static Car findOneWinner() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("??이런경우도 있나"));
    }

    public static void progressRound() {
        for (Car car : cars) {
            int randomNumber = RandomNumberGenerator.generate();
            if (randomNumber > MINIMUM_NUMBER_TO_MOVE) {
                System.out.println(randomNumber);
                car.goForward();
            }
        }
        showStatus();
    }

    private static void showStatus() {
        OutputView.printCarsStatus(cars);
    }

    public static boolean findByName(String name) {
        return cars.stream()
                .anyMatch(car -> car.getName().equals(name));
    }

}
