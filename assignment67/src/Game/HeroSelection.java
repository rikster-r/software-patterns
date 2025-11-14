package Game;

import Hero.*;
import Strategy.*;
import java.util.Scanner;

public class HeroSelection {
    private final Scanner scanner = new Scanner(System.in);

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

        IHero hero;
        if (choice == 1) {
            hero = HeroBuilder.warrior().name(playerName + " (Warrior)").build();
            hero.setStrategy(new MeleeStrategy());
        } else if (choice == 2) {
            hero = HeroBuilder.mage().name(playerName + " (Mage)").build();
            hero.setStrategy(new MagicStrategy());
        } else if (choice == 3) {
            hero = HeroBuilder.archer().name(playerName + " (Archer)").build();
            hero.setStrategy(new RangedStrategy());
        } else {
            System.out.println("Invalid choice. You are a Warrior then");
            hero = HeroBuilder.warrior().name(playerName + " (Warrior)").build();
            hero.setStrategy(new MeleeStrategy());
        }

        return hero;
    }
}
