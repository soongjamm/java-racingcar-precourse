package racingcar;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String enterCars() {
        System.out.println("자동차의 이름을 입력하세요.");
        try {
            String input = scanner.nextLine().trim();
            validateStringForm(input);
            return input;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return enterCars();
        }

    }

    private void validateStringForm(String input) {
        if (input.equals("")) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
        if (input.replace(",", "").equals("")) {
            throw new IllegalArgumentException("이름이 입력되지 않았습니다.");
        }
    }

    public int enterGameRound() {
        System.out.println("몇 회를 진행할지 입력하세요.");
        try {
            String input = scanner.nextLine().trim();
            validateNumberForm(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return enterGameRound();
        }
    }

    private void validateNumberForm(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("숫자만 입력 가능합니다.");
            }
        }
        validateStringForm(input);
    }

}
