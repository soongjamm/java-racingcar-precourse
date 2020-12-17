package racingcar;

public class Car implements Comparable<Car> {
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
        if (Cars.findByName(name)) {
            throw new IllegalArgumentException(String.format("%s는 이미 존재하는 이름입니다.", name));
        };
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

    public int getPosition() {
        return position;
    }

    @Override
    public int compareTo(Car other) {
        return this.position - other.position;
    }

    public boolean isSamePosition(Car other) {
        return this.position == other.position;
    }

}
