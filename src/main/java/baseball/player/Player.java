package baseball.player;

import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class Player {

    public final List<Integer> input = new ArrayList<>();

    public void inputThreeDistinctDigits() {
        System.out.print("숫자를 입력해주세요: ");
        String line = Console.readLine().trim();   // Scanner 대신 Console 사용
        String[] parts = line.split("\\s+");

        if (parts.length != 3) {
            throw new IllegalArgumentException("정확히 3개를 입력해야 합니다.");
        }

        Set<Integer> set = new LinkedHashSet<>(); // 입력 순서 유지
        for (String part : parts) {
            final int n;
            try {
                n = Integer.parseInt(part);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자를 입력해주세요.");
            }

            if (n < 1 || n > 9) {
                throw new IllegalArgumentException("각 숫자는 범위가 1~9 입니다.");
            }
            if (!set.add(n)) {
                throw new IllegalArgumentException("숫자가 중복되었습니다.");
            }
        }

        input.clear();
        input.addAll(set);
    }
}
