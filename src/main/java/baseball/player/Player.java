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
        String line = Console.readLine();
        return rules.parseRules(line);
    }

    @Override
    public boolean goOrStop() {
        String s = Console.readLine();
        return rules.checkContinue(s);
    }
}
