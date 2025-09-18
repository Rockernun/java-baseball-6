package baseball.computer;

import java.util.List;

public interface Machine {

    // 게임 재시작 시 선택한 임의의 수 3개 초기화하는 책임
    void reset();

    // 임의의 수 3개 생성하는 책임
    List<Integer> generate();

    // 추측값을 바탕으로 결과를 판단하는 책임
    Score judge(List<Integer> guess);
}
