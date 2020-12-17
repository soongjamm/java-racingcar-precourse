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
    }

    public void goForward() {
       position++;
    }

    public String getPositionBar() {
        String bar = "";
        for (int i = 0 ; i < position; i++) {
            bar += "-";
        }
        return bar;
    }

    public String getName() {
        return name;
    }
}
