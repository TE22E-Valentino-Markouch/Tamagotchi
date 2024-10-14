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
        System.out.println("[" + name + "] eats and becomes less hungry");
        hunger -= 2;
        if (hunger < 0) {
            hunger = 0;
        }
    }

    public void hi() {
        int wordNum = new Random().nextInt(words.size());
        System.out.println("[" + name + "] says: " + words.get(wordNum));
        reduceBoredom();
    }

    public void teach(String word) {
        System.out.println("[" + name + "] learns: " + word);
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
        System.out.println("Name: " + name + " || Hunger: " + hunger + " || Boredom: " + boredom + " || Vocabulary: " + words.size() + " words");
    }

    public boolean getAlive() {
        return isAlive;
    }

    private void reduceBoredom() {
        System.out.println("[" + name + "] is now less bored!");
        boredom -= 2;
        if (boredom < 0) {
            boredom = 0;
        }
    }
}
