import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tamagotchi {
    private int hunger;
    private int boredom;
    private List<String> words;
    private boolean isAlive;
    public String name;

    public Tamagotchi() {
        hunger = 0;
        boredom = 0;
        isAlive = true;
        words = new ArrayList<>();
        words.add("Hewwo");
    }

    public void feed() {
        System.out.println("[" + name + "] äter och är mindre hungrig!");
        hunger -= 2;
        if (hunger < 0) {
            hunger = 0;
        }
    }

    public void hi() {
        int wordNum = new Random().nextInt(words.size());
        System.out.println("[" + name + "] Säger: " + words.get(wordNum));
        reduceBoredom();
    }

    public void teach(String word) {
        System.out.println("[" + name + "] kan nu ordet: " + word);
        words.add(word);
        reduceBoredom();
    }

    public void tick() {
        hunger++;
        boredom++;
        if (hunger > 10 || boredom > 10) {
            isAlive = false;
        }
    }

    public void printStats() {
        System.out.println("Namn: " + name + " || Hunger: " + hunger + " || Uttråkad: " + boredom + " || Vokabulär: " + words.size() + " Ord");
    }

    public boolean getAlive() {
        return isAlive;
    }

    private void reduceBoredom() {
        System.out.println("[" + name + "] är nu mindre uttråkad!");
        boredom -= 2;
        if (boredom < 0) {
            boredom = 0;
        }
    }
}
