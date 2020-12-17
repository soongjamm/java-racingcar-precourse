package racingcar;

import java.util.Arrays;
import java.util.Scanner;

public class Controller {
    private final Scanner scanner;
    private Cars cars;
    private int gameRound;

    public Controller(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        InputView inputView = new InputView(scanner);

        registerCars(inputView);
        gameRound = inputView.enterGameRound();

        for (int i=0; i<gameRound; i++) {
            Cars.progressRound();
        }
        Cars.findWinners();
    }

    private void registerCars(InputView inputView) {
        try {
            Arrays.stream(inputView.enterCars().split(","))
                    .forEach(name -> Cars.add(new Car(name)));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            registerCars(inputView);
        }
    }

}
