package Game;

import Hero.*;
import Strategy.*;
import java.util.Scanner;

public class BattleLoop {
    private final Scanner scanner = new Scanner(System.in);

    public void start(IHero player1, IHero player2) {
        IHero current = player1;
        IHero opponent = player2;

        while (player1.isAlive() && player2.isAlive()) {
            System.out.println("\n=======================================");
            System.out.println(current.getName() + "'s turn!");
            System.out.println("Your HP: " + current.getHealth() +
                    " | Opponent HP: " + opponent.getHealth());
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
                    IStrategy strategy = (current instanceof Mage)
                            ? new MagicStrategy() : new MeleeStrategy();
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
            System.out.println(hero.getName() + " tried to use "
                    + strategy.getClass().getSimpleName().replace("Strategy", "")
                    + " but doesn’t have enough " + resourceName + " ("
                    + current + "/" + cost + ")");
            return false;
        }
        return true;
    }
}
