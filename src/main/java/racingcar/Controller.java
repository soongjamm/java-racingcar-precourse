package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Controller {
    private final Scanner scanner;

    public Controller(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        InputView inputView = new InputView(scanner);
        List<Car> cars = Arrays.stream(inputView.enterCars().split(","))
                    .map(x -> new Car(x)).collect(Collectors.toList());
    }
}
