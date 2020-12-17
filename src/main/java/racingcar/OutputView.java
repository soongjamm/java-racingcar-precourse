package racingcar;

import java.util.List;

public class OutputView {
    public static void printCarsStatus(List<Car> cars) {
        System.out.println("현재 상황");
        cars.stream()
                .forEach(car -> System.out.println(String.format("%s : %s", car.getName(), car.getPositionBar())));
        System.out.println();
    }

    public void printWinners() {

    }
}
