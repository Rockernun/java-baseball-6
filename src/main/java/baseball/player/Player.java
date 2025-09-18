package baseball.player;

import baseball.exception.GameRules;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class Player implements Participant {

    private final GameRules rules;
    public final List<Integer> input = new ArrayList<>();

    public Player(GameRules rules) {
        this.rules = rules;
    }

    @Override
    public List<Integer> inputDistinctDigits() {
        String line = Console.readLine().trim();

        int size = rules.size();
        int min  = rules.min();
        int max  = rules.max();

        String pattern = String.format("^[%d-%d]{%d}$", min, max, size);
        if (!line.matches(pattern)) {
            throw new IllegalArgumentException(
                    String.format("공백 없이 %d~%d 숫자 %d자리를 입력해야 합니다.", min, max, size)
            );
        }

        List<Integer> values = new ArrayList<>();
        Set<Integer> unique = new HashSet<>();
        for (int i = 0; i < size; i++) {
            int n = line.charAt(i) - '0';
            values.add(n);
            if (!unique.add(n)) {
                throw new IllegalArgumentException("숫자가 중복되었습니다.");
            }
        }

        input.clear();
        input.addAll(values);

        return input;
    }

    @Override
    public boolean goOrStop() {
        String s = Console.readLine().trim();

        return switch (s) {
            case "1" -> true;
            case "2" -> false;
            default  -> throw new IllegalArgumentException("1 또는 2만 입력할 수 있습니다.");
        };
    }
}
