package racingcar;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Controller {
    private final Scanner scanner;
    private Cars cars;
    private int gameRound;

    public Controller(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        InputView inputView = new InputView(scanner);
        cars = getCars(inputView);
        gameRound = inputView.enterGameRound();
    }

    private Cars getCars(InputView inputView) {
        return new Cars(Arrays.stream(inputView.enterCars().split(","))
                .map(name -> new Car(name))
                .collect(Collectors.toList()));
    }

}
