package baseball.exception;

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
}
