package racingcar;

import java.util.List;

public class OutputView {
    public static void printCarsStatus(List<Car> cars) {
        System.out.println("실행 결과");
        cars.stream()
                .forEach(car -> System.out.println(String.format("%s : %s", car.getName(), car.getPositionBar())));
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        String message = "최종 우승자: ";
        for (int i=0; i<winners.size(); i++) {
            message += winners.get(i).getName();
            if (i < winners.size() -1 ) {
                message += ",";
            }
            message += " ";
        }
        System.out.println(message);
    }
}
