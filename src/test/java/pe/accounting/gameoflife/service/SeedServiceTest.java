package pe.accounting.gameoflife.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SeedServiceTest {

    private final List<ArrayList<Integer>> INITIAL_GRID = new ArrayList<>();

    private final int ROWS = 5;
    private final int COLUMNS = 5;

    @BeforeEach
    public void setUp() {
        initializeGrid();
    }

    private void initializeGrid() {
        for(int row_index = 0; row_index < ROWS; row_index++) {
            ArrayList<Integer> integerArrayList = new ArrayList<>();
            for (int column_index = 0; column_index< COLUMNS; column_index++) {
                integerArrayList.add(column_index,0);
            }
            INITIAL_GRID.add(row_index, integerArrayList);
        }
    }

    @Test
    public void testShouldCreateNoneEmptyGrid() {
        Assertions.assertFalse(INITIAL_GRID.isEmpty());
    }

    @Test
    public void testShouldSeedTwoLiveCells() {
        SeedService.plantSeed(2, INITIAL_GRID);
        Assertions.assertEquals(2, GameOfLifeService.getAliveCellCount(INITIAL_GRID, ROWS, COLUMNS));
    }
}