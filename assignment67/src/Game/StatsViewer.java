package Game;
import Hero.IHero;

public class StatsViewer{
    public void show(IHero hero1, IHero hero2) {
        System.out.println("\n===== HERO STATS =====");
        System.out.println(hero1.getName()+": HP="+hero1.getHealth()+" | "+hero1.getResourceName(true)+"="+hero1.getResource());
        System.out.println(hero2.getName()+": HP="+hero2.getHealth()+" | "+hero2.getResourceName(true)+"="+hero2.getResource());
        System.out.println("======================\n");
    }
}
