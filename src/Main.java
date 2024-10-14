import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Tamagotchi!");

        Tamagotchi myTama = new Tamagotchi();

        System.out.println("Please choose a name for your Tamagotchi!");
        myTama.name = scanner.nextLine();

        System.out.println("Great! " + myTama.name + " is a beautiful name!");
        System.out.println("Press any key to continue");
        scanner.nextLine();

        while (myTama.getAlive()) {
            System.out.println("\n".repeat(10)); // To simulate clearing the console
            myTama.printStats();
            System.out.println("Now what do you want to do?");
            System.out.println("1. Teach " + myTama.name + " a new word");
            System.out.println("2. Talk to " + myTama.name);
            System.out.println("3. Feed " + myTama.name);
            System.out.println("4. Do nothing");

            String doWhat = scanner.nextLine();

            switch (doWhat) {
                case "1":
                    System.out.println("What word?");
                    String word = scanner.nextLine();
                    myTama.teach(word);
                    break;
                case "2":
                    myTama.hi();
                    break;
                case "3":
                    myTama.feed();
                    break;
                default:
                    System.out.println("Doing nothing...");
                    break;
            }

            myTama.tick();
            System.out.println("Press Enter to continue");
            scanner.nextLine();
        }

        System.out.println("OH NO! " + myTama.name + " is dead!");
        System.out.println("Press ENTER to quit");
        scanner.nextLine();
        scanner.close();
    }
}
