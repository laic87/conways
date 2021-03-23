package pe.accounting.gameoflife.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Runner {
    public static void main(String[] args) {

        final int COLUMNS = 5;
        final int ROWS= 5;

        boolean isAlive = true;

        //int[][] board = new int[column][row];
        List<ArrayList<Integer>> board = new ArrayList<>();


        for(int i = 0; i < ROWS; i++) {
            ArrayList<Integer> integerArrayList = new ArrayList<>();
            for (int j = 0; j< COLUMNS ; j++) {
             integerArrayList.add(j,0);
            }
            board.add(i, integerArrayList);
        }


        System.out.println("\t=== board ====");
        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLUMNS; j++) {
                    System.out.print("\t.");
            }
            System.out.println();
        }

        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLUMNS; j++) {
                System.out.print("\t" + board.get(i).get(j));
            }
            System.out.println();
        }

        plantSeed(board);

        nextGeneration(board, ROWS, COLUMNS);

        System.out.println("\t=== board ====");

        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLUMNS; j++) {
                if (board.get(i).get(j) == 0)
                    System.out.print("\t.");
                else
                    System.out.print("\t*");
            }
            System.out.println();
        }


    }

    private static void plantSeed(List<ArrayList<Integer>> board) {
        board.get(generateNumber()).set(generateNumber(), 1);
        board.get(generateNumber()).set(generateNumber(), 1);
        board.get(generateNumber()).set(generateNumber(), 1);
        board.get(generateNumber()).set(generateNumber(), 1);
    }

    private static int generateNumber() {
        Random random = new Random();
        return random.nextInt(5);
    }

    private static List<ArrayList<Integer>> nextGeneration(List<ArrayList<Integer>> board, int numberOfRows, int numberOfColumns) {
        List<ArrayList<Integer>> newMatrics = new ArrayList<>();

        for(int i = 0; i < numberOfRows; i++) {
            for(int j = 0; j < numberOfColumns; j++) {
                List<Integer> neighbours = getNeighbours(i, j, numberOfRows, numberOfColumns, board);
                System.out.println(neighbours.size());
            }
        }
        return newMatrics;
    }

    private static List<Integer> getNeighbours(int currentCellRowIndex, int currentCellColIndex, int numberOfRows, int numberOfColumns, List<ArrayList<Integer>> board) {
        List<Integer> neighbours = new ArrayList<>();

        for(int i = 0; i < numberOfRows; i++) {
            for(int j = 0; j < numberOfColumns; j++) {

                if(currentCellRowIndex < numberOfRows - 1 && currentCellColIndex < numberOfColumns - 1) {
                    if(currentCellRowIndex != 0 && currentCellColIndex != 0) {
                        neighbours.add(board.get(currentCellRowIndex--).get(currentCellColIndex--));
                    }

                    else if(currentCellRowIndex != 0 ) {
                        neighbours.add(board.get(currentCellRowIndex--).get(currentCellColIndex));
                    }

                    else if(currentCellRowIndex != 0 && currentCellColIndex != numberOfColumns - 1) {
                        neighbours.add(board.get(currentCellRowIndex--).get(currentCellColIndex++));
                    }

                    else if(currentCellColIndex != 0) {
                        neighbours.add(board.get(currentCellRowIndex).get(currentCellColIndex--));
                    }

                    else if(currentCellColIndex != numberOfColumns - 1) {
                        neighbours.add(board.get(currentCellRowIndex).get(currentCellColIndex++));
                    }

                    else if(currentCellRowIndex != numberOfRows - 1) {
                        neighbours.add(board.get(currentCellRowIndex++).get(currentCellColIndex));
                    }

                    else if(currentCellRowIndex != numberOfRows - 1 && currentCellColIndex != 0) {
                        neighbours.add(board.get(currentCellRowIndex++).get(currentCellColIndex--));
                    }

                    else if(currentCellRowIndex != numberOfRows - 1 && currentCellColIndex != numberOfColumns -1) {
                        neighbours.add(board.get(currentCellRowIndex++).get(currentCellColIndex++));
                    }
                }
            }
        }

        return neighbours;
    }

}
