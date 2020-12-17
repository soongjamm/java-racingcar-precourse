package racingcar.domain;

import utils.RandomUtils;

public class RandomNumberGenerator {
    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;

    public static int generate() {
        return RandomUtils.nextInt(START_INCLUSIVE, END_INCLUSIVE);
    }
}
