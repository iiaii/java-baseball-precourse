package baseball.domain;

import nextstep.utils.Randoms;

import java.util.*;

public class Computer {

    public static List<Integer> createNumbers() {
        Set<Integer> numberSet = new LinkedHashSet<>();
            numberSet.add(Randoms.pickNumberInRange(1, 9));
        }
        return new ArrayList<>(numberSet);
    }

}
