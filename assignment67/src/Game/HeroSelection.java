package Game;

import Hero.*;
import Strategy.*;
import java.util.Scanner;

public class HeroSelection {
    private final Scanner scanner = new Scanner(System.in);
    private final HeroFactory heroFactory = new HeroFactory();

    public IHero chooseHero(String playerLabel) {
        System.out.println(playerLabel + ", enter your name (press Enter to keep default):");
        System.out.print("> ");
        String inputName = scanner.nextLine().trim();
        String playerName = inputName.isEmpty() ? playerLabel : inputName;

        System.out.println("\n" + playerName + ", choose your hero:");
        System.out.println("1. Warrior");
        System.out.println("2. Mage");
        System.out.println("3. Archer");
        System.out.print("> ");

        String input = scanner.nextLine().trim();
        int choice;
        try {
            choice = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            choice = 1;
        }

        String heroType = switch (choice) {
            case 1 -> "Warrior";
            case 2 -> "Mage";
            case 3 -> "Archer";
            default -> {
                System.out.println("Invalid choice. Defaulting to Warrior.");
                yield "Warrior";
            }
        };

        IHero hero = heroFactory.makeHero(heroType, playerName + " (" + heroType + ")");

        switch (heroType) {
            case "Warrior" -> hero.setStrategy(new MeleeStrategy());
            case "Mage" -> hero.setStrategy(new MagicStrategy());
            case "Archer" -> hero.setStrategy(new RangedStrategy());
        }

        return hero;
    }
}
