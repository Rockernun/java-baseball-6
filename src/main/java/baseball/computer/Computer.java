package baseball.computer;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> numbers = generate();

    public void reset() {
        numbers = generate();
    }

    public Score judge(List<Integer> guess) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            int g = guess.get(i);
            if (g == numbers.get(i)) {
                strike++;

            } else if (numbers.contains(g)) {
                ball++;
            }
        }

        return new Score(strike, ball);

    }

    private List<Integer> generate() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static final class Score {
        public final int strike;
        public final int ball;

        public Score(int strike, int ball) {
            this.strike = strike;
            this.ball = ball;
        }

        public boolean isWin() {
            return strike == 3;
        }

        public boolean isNothing() {
            return strike == 0 && ball == 0;
        }

    }
}
