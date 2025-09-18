package baseball.exception;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public record GameRules(int size, int min, int max) {

    public GameRules {
        if (size <= 0) {
            throw new IllegalArgumentException("입력해야 할 임의의 수는 양수여야 합니다.");
        }

        if (min < 0 || max < 0 || min >= max) {
            throw new IllegalArgumentException("범위가 잘못되었습니다.");
        }

        if (size > (max - min + 1)) {
            throw new IllegalArgumentException("뽑아야 할 임의의 수가 범위보다 큽니다.");
        }
    }

    // 사용자 입력값 예외 처리
    public List<Integer> parseRules(String input) {

        String str = input.trim();

        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력이 비어있습니다");
        }

        if (str.length() != size) {
            throw new IllegalArgumentException(String.format("정확히 %d자리를 입력해야 합니다.", size));
        }

        List<Integer> values = new ArrayList<>();
        Set<Integer> unique = new HashSet<>();

        for (int i = 0; i < size; i++) {
            char c = str.charAt(i);
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException(String.format("공백 없이 %d~%d 숫자 %d자리를 입력해야 합니다.", min, max, size));
            }

            int number = c - '0';
            if (number < min || number > max) {
                throw new IllegalArgumentException(String.format("%d~%d 범위의 숫자만 입력할 수 있습니다.", min, max));
            }

            if (!unique.add(number)) {
                throw new IllegalArgumentException("숫자가 중복되었습니다.");
            }

            values.add(number);
        }

        return List.copyOf(values);
    }

    // 사용자 게임 재개 여부 예외 처리
    public boolean checkContinue(String input) {
        String str = input.trim();

        return switch(str) {
            case "1" -> true;
            case "2" -> false;
            default  -> throw new IllegalArgumentException("1 또는 2만 입력할 수 있습니다.");
        };
    }
}
