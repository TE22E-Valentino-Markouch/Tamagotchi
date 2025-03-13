import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Väkomen till Tamagotchi!");

        Tamagotchi myTama = new Tamagotchi();

        System.out.println("Var snäll att välja ett namn till din tamagotchi!");
        myTama.name = scanner.nextLine();

        System.out.println("Perfekt! " + myTama.name + " är ett vakert namn!");
        System.out.println("Tryck på valfri knapp för att fortsätta");
        scanner.nextLine();

        while (myTama.getAlive()) {
            System.out.println("\n".repeat(10)); // För att få en ren arbets yta
            myTama.printStats();
            System.out.println("Vad vill du göra nu?");
            System.out.println("1. Lära " + myTama.name + " ett nytt ord");
            System.out.println("2. Prata med " + myTama.name);
            System.out.println("3. Mata " + myTama.name);
            System.out.println("4. Göra ingenting");

            String doWhat = scanner.nextLine();

            switch (doWhat) {
                case "1":
                    System.out.println("Vilket ord?");
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
                    System.out.println("Gör ingenting...");
                    break;
            }

            myTama.tick();
            System.out.println("Tryck ENTER för att fortsätta!");
            scanner.nextLine();
        }

        System.out.println("åh nej," + myTama.name + " är nu död!");
        System.out.println("Tryck ENTER för att avsluta");
        scanner.nextLine();
        scanner.close();
    }
}
