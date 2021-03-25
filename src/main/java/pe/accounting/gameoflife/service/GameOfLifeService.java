package pe.accounting.gameoflife.service;

import java.util.ArrayList;
import java.util.List;

public class GameOfLifeService {

    public static void initializeGrid(int COLUMNS, int ROWS, List<ArrayList<Integer>> grid) {
        for(int row_index = 0; row_index < ROWS; row_index++) {
            ArrayList<Integer> integerArrayList = new ArrayList<>();
            for (int column_index = 0; column_index< COLUMNS; column_index++) {
                integerArrayList.add(column_index,0);
            }
            grid.add(row_index, integerArrayList);
        }
    }

    public static List<ArrayList<Integer>> generateNext(List<ArrayList<Integer>> currentGrid, int numberOfRows, int numberOfColumns) {
        List<ArrayList<Integer>> futureGrid = new ArrayList<>();
        initializeGrid(numberOfRows, numberOfColumns, futureGrid);

        for(int row_index = 1; row_index < numberOfRows - 1; row_index++) {
            for(int column_index = 1; column_index < numberOfColumns - 1; column_index++) {

                // finding no Of Neighbours that are alive
                int aliveNeighbours = 0;
                for (int row = -1; row <= 1; row++)
                    for (int column = -1; column <= 1; column++)
                        aliveNeighbours += currentGrid.get(row + row_index).get(column + column_index);

                // The cell needs to be subtracted from
                // its neighbours as it was counted before
                aliveNeighbours -= currentGrid.get(row_index).get(column_index);

                // Implementing the Rules of Life
                // Cell is lonely and dies
                if ((currentGrid.get(row_index).get(column_index) == 1) && (aliveNeighbours < 2))
                    futureGrid.get(row_index).set(column_index,0);

                    // Cell dies due to over population
                else if ((currentGrid.get(row_index).get(column_index) == 1) && (aliveNeighbours > 3))
                    futureGrid.get(row_index).set(column_index, 0);

                    // A new cell is born
                else if ((currentGrid.get(row_index).get(column_index) == 0) && (aliveNeighbours == 3))
                    futureGrid.get(row_index).set(column_index, 1);

                    // Remains the same
                else
                    futureGrid.get(row_index).set(column_index,currentGrid.get(row_index).get(column_index));
            }
        }

        return futureGrid;
    }

    public static int getAliveCellCount(List<ArrayList<Integer>> grid, int ROWS, int COLS) {
        int aliveCellsCount = 0;
        for(int row_index = 0;  row_index< ROWS; row_index++)
            for(int column_index = 0;  column_index< COLS; column_index++)
                aliveCellsCount+= grid.get(row_index).get(column_index);

            return aliveCellsCount;
    }
}
