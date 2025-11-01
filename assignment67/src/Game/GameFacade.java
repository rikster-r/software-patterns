package Game;

import Hero.IHero;
import Observer.HeroObserver;

public class GameFacade {
    private final HeroSelection heroSelection = new HeroSelection();
    private final StatsViewer statsViewer = new StatsViewer();
    private final BattlefieldVisualizer battlefieldVisualizer = new BattlefieldVisualizer();
    private final BattleLoop battleLoop = new BattleLoop(statsViewer, battlefieldVisualizer);

    public void startGame() {
        System.out.println("=== Welcome to Hero Battle (2 Players) ===\n");

        HeroObserver observer = new HeroObserver();
        IHero player1 = heroSelection.chooseHero("Player 1");
        IHero player2 = heroSelection.chooseHero("Player 2");

        player1.addObserver(observer);
        player2.addObserver(observer);

        System.out.println("\n⚔️  The battle begins: "
                + player1.getName() + " vs " + player2.getName() + " ⚔️\n");

        battleLoop.start(player1, player2);
    }
}
