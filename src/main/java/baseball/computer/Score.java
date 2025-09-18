package baseball.computer;

public record Score(int strike, int ball) {

    public boolean isWin() {
        return strike == 3;
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }
}
