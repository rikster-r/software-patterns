package Game;

import Hero.*;
import Strategy.*;
import Observer.*;

import java.util.*;

public class GameLoopFacade {
    private IHero player1;
    private IHero player2;
    private final HeroObserver observer = new HeroObserver();
    private final Scanner scanner = new Scanner(System.in);

    public void setupGame() {
        System.out.println("=== Welcome to Hero Battle (2 Players) ===\n");

        System.out.println("Player 1, choose your hero:");
        player1 = chooseHero("Player 1");

        System.out.println("\nPlayer 2, choose your hero:");
        player2 = chooseHero("Player 2");

        // Add observers
        player1.addObserver(observer);
        player2.addObserver(observer);

        System.out.println("\n⚔️  The battle begins: " + player1.getName() + " vs " + player2.getName() + " ⚔️\n");
    }

    private IHero chooseHero(String playerLabel) {
        System.out.println("1. Warrior");
        System.out.println("2. Mage");
        System.out.println("3. Archer");
        System.out.print("> ");

        int choice = scanner.nextInt();
        IHero hero;

        switch (choice) {
            case 1 -> hero = new Warrior(playerLabel + " (Warrior)");
            case 2 -> hero = new Mage(playerLabel + " (Mage)");
            case 3 -> hero = new Archer(playerLabel + " (Archer)");
            default -> {
                System.out.println("Invalid choice. Defaulting to Warrior.");
                hero = new Warrior(playerLabel + " (Warrior)");
            }
        }

        // Assign logical default strategy
        if (hero instanceof Warrior) hero.setStrategy(new MeleeStrategy());
        else if (hero instanceof Mage) hero.setStrategy(new MagicStrategy());
        else if (hero instanceof Archer) hero.setStrategy(new RangedStrategy());

        return hero;
    }

    public void startBattle() {
        IHero current = player1;
        IHero opponent = player2;

        while (player1.isAlive() && player2.isAlive()) {
            System.out.println("\n=======================================");
            System.out.println(current.getName() + "'s turn!");
            System.out.println("Your HP: " + current.getHealth() + " | Opponent HP: " + opponent.getHealth());
            System.out.println("Choose an action:");

            if (current instanceof Warrior || current instanceof Archer) {
                System.out.println("1. Melee Attack");
                System.out.println("2. Ranged Attack");
                System.out.println("3. Defend");
            } else if (current instanceof Mage) {
                System.out.println("1. Magic Attack");
                System.out.println("2. Ranged Attack");
                System.out.println("3. Defend");
            }
            System.out.print("> ");

            int action = scanner.nextInt();

            switch (action) {
                case 1 -> {
                    IStrategy strategy = (current instanceof Mage) ? new MagicStrategy() : new MeleeStrategy();
                    if (canPerformAction(current, strategy)) {
                        current.setStrategy(strategy);
                        current.act(opponent);
                    }
                }
                case 2 -> {
                    IStrategy strategy = new RangedStrategy();
                    if (canPerformAction(current, strategy)) {
                        current.setStrategy(strategy);
                        current.act(opponent);
                    }
                }
                case 3 -> {
                    IStrategy strategy = new DefenseStrategy();
                    if (canPerformAction(current, strategy)) {
                        current.setStrategy(strategy);
                        current.act(opponent);
                    }
                }


                default -> System.out.println("Invalid input! You miss your turn.");
            }

            if (!opponent.isAlive()) break;

            // swap turns
            IHero temp = current;
            current = opponent;
            opponent = temp;
        }

    }

    private boolean canPerformAction(IHero hero, IStrategy strategy) {
        int current = hero.getResource();
        int cost = strategy.getResourceCost(hero);
        String resourceName = hero.getResourceName(cost > 1);

        if (current < cost) {
            System.out.println(hero.getName() + " tried to use " + strategy.getClass().getSimpleName().replace("Strategy", "") +
                    " but doesn’t have enough " + resourceName + "! (" + current + "/" + cost + ")");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        GameLoopFacade game = new GameLoopFacade();
        game.setupGame();
        game.startBattle();
    }
}
