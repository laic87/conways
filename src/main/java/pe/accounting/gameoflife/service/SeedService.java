package pe.accounting.gameoflife.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SeedService {

    public static void plantSeed(int number, List<ArrayList<Integer>> board) {
        for(int index = 0; index < number; index++) {
            board.get(generateNumber(number)).set(generateNumber(number), 1);
        }
    }

    private static int generateNumber(int number) {
        Random random = new Random();
        int random_number = random.nextInt(number);
        return random_number;
    }

    public static void generateHardcodedPosition(List<ArrayList<Integer>> board) {
        board.get(3).set(1, 1);
        board.get(0).set(0, 1);
    }

}
