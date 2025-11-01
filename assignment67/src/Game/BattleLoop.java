package Game;

import Hero.*;
import Strategy.*;
import java.util.Scanner;

public class BattleLoop {
    private final Scanner scanner = new Scanner(System.in);
    private final StatsViewer statsViewer;

    public BattleLoop(StatsViewer statsViewer, BattlefieldVisualizer battlefieldVisualizer) {
        this.statsViewer = statsViewer;
    }

    public void start(IHero player1, IHero player2) {
        IHero current = player1;
        IHero opponent = player2;

        player1.setPosition(1);
        player2.setPosition(6);

        while (player1.isAlive() && player2.isAlive()) {
            System.out.println("\n=======================================");
            System.out.println(current.getName() + "'s turn!");
            System.out.println("Your HP: " + current.getHealth() +
                    " | Opponent HP: " + opponent.getHealth());
            BattlefieldVisualizer.show(player1, player2);

            boolean turnTaken = false;
            while (!turnTaken) {
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
                System.out.println("4. Move");
                System.out.println("5. View Stats");
                System.out.print("> ");

                int action = scanner.nextInt();

                switch (action) {
                    case 1 -> {
                        IStrategy strategy = (current instanceof Mage)
                                ? new MagicStrategy() : new MeleeStrategy();
                        if (isOutsideRange(current, opponent, strategy)) break;
                        if (canPerformAction(current, strategy)) {
                            current.setStrategy(strategy);
                            current.act(opponent);
                            turnTaken = true;
                        }
                    }
                    case 2 -> {
                        IStrategy strategy = new RangedStrategy();
                        if (isOutsideRange(current, opponent, strategy)) break;
                        if (canPerformAction(current, strategy)) {
                            current.setStrategy(strategy);
                            current.act(opponent);
                            turnTaken = true;
                        }
                    }
                    case 3 -> {
                        IStrategy strategy = new DefenseStrategy();
                        if (canPerformAction(current, strategy)) {
                            current.setStrategy(strategy);
                            current.act(opponent);
                            turnTaken = true;
                        }
                    }
                    case 4 -> {
                        moveHero(current, opponent);
                        turnTaken = true;
                    }
                    case 5 -> statsViewer.show(current, opponent); // does NOT end the turn
                    default -> System.out.println("Invalid input! Try again.");
                }
            }

            if (!opponent.isAlive()) break;

            IHero temp = current;
            current = opponent;
            opponent = temp;
        }
    }

    private void moveHero(IHero current, IHero opponent) {
        System.out.println("Current position: " + current.getPosition());
        System.out.println("Enter new position (1–6): ");
        int newPos = scanner.nextInt();

        if (newPos < 1 || newPos > 6) {
            System.out.println("Invalid position!");
            return;
        }

        if (newPos == opponent.getPosition()) {
            System.out.println("You can’t move into opponent’s spot!");
            return;
        }

        current.setPosition(newPos);
        System.out.println(current.getName() + " moved to position " + newPos);
        BattlefieldVisualizer.show(current, opponent);
    }

    private boolean isOutsideRange(IHero current, IHero opponent, IStrategy strategy) {
        int distance = Math.abs(current.getPosition() - opponent.getPosition());

        if (strategy instanceof MeleeStrategy && distance != 1) {
            System.out.println("Too far away for a melee attack! (Need distance = 1)");
            return true;
        }
        if (strategy instanceof RangedStrategy && distance < 2) {
            System.out.println("Too close for a ranged attack! (Need distance ≥ 2)");
            return true;
        }
        if (strategy instanceof MagicStrategy && (distance < 1 || distance > 2)) {
            System.out.println("Out of range for a magic attack! (Need distance 1–2)");
            return true;
        }
        return false;
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
