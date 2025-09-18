package baseball;

import baseball.computer.Computer;
import baseball.computer.Machine;
import baseball.computer.Score;
import baseball.player.Player;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        Player player = new Player();
        Machine computer = new Computer();

        try {
            while (true) {
                computer.reset();
                System.out.println("숫자 야구 게임을 시작합니다!");

                while (true) {
                    player.inputThreeDistinctDigits();
                    Score score = computer.judge(player.input);

                    if (score.isNothing()) {
                        System.out.println("낫싱");
                    } else {
                        System.out.printf("%d볼 %d스트라이크%n", score.ball(), score.strike());
                    }

                    if (score.isWin()) {
                        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                        break;
                    }
                }

                System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");
                boolean restart = player.restartOrExit();
                if (!restart) {
                    return;
                }
            }
        } finally {
            try { Console.close(); } catch (Exception ignore) {}
        }
    }
}

