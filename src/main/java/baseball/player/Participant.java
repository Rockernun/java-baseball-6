package baseball.player;

import java.util.List;

public interface Participant {

    // 숫자를 입력할 책임
    List<Integer> inputDistinctDigits();

    // 게임 재개 여부를 답해야 할 책임
    boolean goOrStop();
}
