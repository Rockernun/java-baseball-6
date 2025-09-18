package baseball.mediator;

public interface GameMediator {

    // 게임을 개시하는 책임
    void start();

    // 참가자에게 게임 재개 여부를 묻는 책임
    boolean restartOrExit();
}
