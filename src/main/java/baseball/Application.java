package baseball;

import baseball.computer.Computer;
import baseball.computer.Machine;
import baseball.exception.GameRules;
import baseball.mediator.DefaultGameMediator;
import baseball.mediator.GameMediator;
import baseball.player.Player;

public class Application {

    public static void main(String[] args) {

        GameRules rules = new GameRules(3, 1, 9);
        Player player = new Player(rules);
        Machine computer = new Computer(rules);
        GameMediator mediator = new DefaultGameMediator(computer, player);

        mediator.start();
    }
}

