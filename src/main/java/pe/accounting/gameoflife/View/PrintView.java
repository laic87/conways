package pe.accounting.gameoflife.View;

import java.util.ArrayList;
import java.util.List;

public class PrintView {
    public static void printGrid(List<ArrayList<Integer>> grid, int ROWS, int COLUMNS, int counter) {
        if(counter == 0) {
            System.out.println("\t=== Initial GRID ===");
        } else if(counter == 1) {
            System.out.println("\t=== Seeded GRID ===");
        } else {
            System.out.println("\t=== Processed GRID ===");
        }
        for(int row_index = 0; row_index < ROWS; row_index++) {
            for(int column_index = 0; column_index < COLUMNS; column_index++) {
                if (grid.get(row_index).get(column_index) == 0)
                    System.out.print("\t.");
                else
                    System.out.print("\t*");
            }
            System.out.println();
        }
    }
}
