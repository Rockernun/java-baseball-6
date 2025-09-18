package baseball.computer;

import baseball.exception.GameRules;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer implements Machine {

    private final GameRules rules;

    // 선택한 임의의 수 3개
    private List<Integer> numbers;

    public Computer(GameRules rules) {
        this.rules = rules;
    }

    @Override
    public void reset() {
        numbers = generate();
    }

    @Override
    public List<Integer> generate() {

        int size = rules.size();
        int max = rules.max();
        int min = rules.min();

        List<Integer> computer = new ArrayList<>(size);
        while (computer.size() < size) {
            int randomNumber = Randoms.pickNumberInRange(min, max);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    @Override
    public Score judge(List<Integer> guess) {

        int size = rules.size();

        int strike = 0;
        int ball = 0;
        for (int i = 0; i < size; i++) {
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
