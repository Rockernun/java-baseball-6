package baseball.computer;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer implements Machine {

    private static final int SIZE = 3;
    private static final int MIN = 1;
    private static final int MAX = 9;

    // 선택한 임의의 수 3개
    private List<Integer> numbers;

    @Override
    public void reset() {
        numbers = generate();
    }

    @Override
    public List<Integer> generate() {
        List<Integer> computer = new ArrayList<>(SIZE);
        while (computer.size() < SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN, MAX);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    @Override
    public Score judge(List<Integer> guess) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < SIZE; i++) {
            int g = guess.get(i);
            if (g == numbers.get(i)) {
                strike++;

            } else if (numbers.contains(g)) {
                ball++;
            }
        }

        return new Score(strike, ball, numbers.size());

    }
}
