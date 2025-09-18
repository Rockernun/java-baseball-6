package baseball.computer;

public record Score(int strike, int ball, int totalDigits) {

    public boolean isWin() {
        return strike == totalDigits;
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }
}
