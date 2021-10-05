package baseball.domain;

import nextstep.utils.Randoms;

import java.util.*;

public class Computer {

    public static List<Integer> createBallNumbers(final int min, final int max) {
        Set<Integer> numberSet = new LinkedHashSet<>();
        while (numberSet.size() < Balls.maxSize()) {
            numberSet.add(Randoms.pickNumberInRange(min, max));
        }
        return new ArrayList<>(numberSet);
    }

}
