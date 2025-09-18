package baseball.mediator;

import baseball.computer.Machine;
import baseball.computer.Score;
import baseball.player.Participant;

import java.util.List;

public class DefaultGameMediator implements GameMediator {

    private final Machine machine;
    private final Participant participant;

    public DefaultGameMediator(Machine machine, Participant participant) {
        this.machine = machine;
        this.participant = participant;
    }

    @Override
    public void start() {
        machine.reset();
        System.out.println("숫자 야구 게임을 시작합니다!");
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> guess = participant.inputDistinctDigits();
            Score score = machine.judge(guess);

            if (score.isNothing()) {
                System.out.println("낫싱");
            } else {
                System.out.printf("%d볼 %d스트라이크%n", score.ball(), score.strike());
            }

            if (score.isWin()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

                if (restartOrExit()) {
                    machine.reset();
                    continue;
                } else {
                    break;
                }
            }
        }
    }

    @Override
    public boolean restartOrExit() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
        return participant.goOrStop();
    }

}
