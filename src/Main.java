import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {


    public static void main(String[] args) {
        final int MIN_NUMBER, MAX_NUMBER, ATTEMPTS, NUMBER_OF_SIMULATIONS;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Zadejte dolni hranici intervalu: ");
        int minNumber = scanner.nextInt();
        MIN_NUMBER = minNumber;
        System.out.println("Zadejte horni hranici intervalu: ");
        int maxNumber = scanner.nextInt();
        MAX_NUMBER = maxNumber;
        System.out.println("Zadejte pocet pokusu: ");
        int attempts = scanner.nextInt();
        ATTEMPTS = attempts;
        System.out.println("Zadejte pocet opakovani: ");
        int numberOfSimulations = scanner.nextInt();
        NUMBER_OF_SIMULATIONS = numberOfSimulations;


        // Config check
        if (MIN_NUMBER < 1 || MAX_NUMBER < 1 || MAX_NUMBER <= MIN_NUMBER || ATTEMPTS > MAX_NUMBER) {
            System.out.println("Spatne paramenty");
        }

        // INIT
        List<Integer> range = IntStream.range(MIN_NUMBER, MAX_NUMBER + 1).boxed().toList();
        List<Integer> orderRange = new ArrayList<Integer>(range);
        List<Integer> randomRange = new ArrayList<Integer>(range);
        Collections.shuffle(randomRange);

        BoxArray boxRoom = new BoxArray(orderRange, randomRange);
        PrisonerArray prisoners1 = new PrisonerArray(orderRange);
        PrisonerArray prisoners2 = new PrisonerArray(orderRange);
        Engine engine = new Engine();

        engine.random(orderRange, ATTEMPTS, prisoners1, boxRoom);
        engine.loop(orderRange, ATTEMPTS, prisoners2, boxRoom);
    }

}
