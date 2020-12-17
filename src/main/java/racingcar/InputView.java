package racingcar;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String enterCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        try {
            String input = scanner.nextLine().trim();
            validateStringForm(input);
            return input;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]" + e.getMessage());
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
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            String input = scanner.nextLine().trim();
            validateNumberForm(input);
            validatePositiveNumber(Integer.parseInt(input));
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]" + e.getMessage());
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

    private void validatePositiveNumber(int input) {
        if (input <= 0) {
            throw new IllegalArgumentException("시도 회차는 양수여야 합니다.");
        }
    }

}
