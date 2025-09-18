package baseball.player;

import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class Player implements Participant {

    public final List<Integer> input = new ArrayList<>();

    @Override
    public void inputDistinctDigits() {
        String line = Console.readLine().trim();

        if (!line.matches("^[1-9]{3}$")) {
            throw new IllegalArgumentException("공백 없이 1~9 숫자 3자리를 입력해야 합니다.");
        }

        List<Integer> values = new ArrayList<>();
        Set<Integer> unique = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            int n = line.charAt(i) - '0';
            values.add(n);
            if (!unique.add(n)) {
                throw new IllegalArgumentException("숫자가 중복되었습니다.");
            }
        }

        input.clear();
        input.addAll(values);
    }

    public boolean restartOrExit() {
        String s = Console.readLine().trim();

        if (s.equals("1")) return true;
        if (s.equals("2")) return false;

        throw new IllegalArgumentException("1 또는 2만 입력할 수 있습니다.");
    }
}
