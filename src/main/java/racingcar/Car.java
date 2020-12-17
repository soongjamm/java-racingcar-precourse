package racingcar;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private int position = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("자동차 이름의 최대 길이는 %d를 넘을 수 없습니다.", MAX_NAME_LENGTH));
        }
        if (name.trim().equals("")) {
            throw new IllegalArgumentException("자동차의 이름이 제대로 입력되지 않았습니다.");
        }
    }

    public void goForward() {

    }


}
