package baseball;

import baseball.computer.Computer;
import baseball.computer.Machine;
import baseball.mediator.DefaultGameMediator;
import baseball.mediator.GameMediator;
import baseball.player.Player;

public class Application {

    public static void main(String[] args) {

        Player player = new Player();
        Machine computer = new Computer();
        GameMediator mediator = new DefaultGameMediator(computer, player);

        mediator.start();
    }
}

