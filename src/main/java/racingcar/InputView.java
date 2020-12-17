package racingcar;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String enterCars() {
        System.out.println("자동차의 이름을 입력하세요.");
        return scanner.nextLine().trim();
    }

    public void enterGameRound() {

    }
}
