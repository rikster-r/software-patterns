package Game;

import Hero.IHero;

public class BattlefieldVisualizer {
    public static void show(IHero hero1, IHero hero2) {
        int maxPos = hero1.getMaxPosition();
        String[] field = new String[maxPos + 1];
        for (int i = 0; i <= maxPos; i++) field[i] = "_";

        field[hero1.getPosition()] = hero1.getEmoji();
        field[hero2.getPosition()] = hero2.getEmoji();

        StringBuilder sb = new StringBuilder("\nBattlefield:\n");
        for (int i = 0; i <= maxPos; i++) {
            sb.append("[").append(field[i]).append("]");
        }
        sb.append("\n");
        System.out.println(sb);
    }
}
