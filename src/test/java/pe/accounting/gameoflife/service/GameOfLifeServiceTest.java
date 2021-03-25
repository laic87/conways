package pe.accounting.gameoflife.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameOfLifeServiceTest {

    private final List<ArrayList<Integer>> INITIAL_GRID = new ArrayList<>();
    private final List<ArrayList<Integer>> FIVE_LIVE_CELL_GRID = new ArrayList<>();

    private final List<ArrayList<Integer>> SEED_GRID_1 = new ArrayList<>();
    private final List<ArrayList<Integer>> EXPECTED_GRID_1 = new ArrayList<>();

    private final List<ArrayList<Integer>> SEED_GRID_2 = new ArrayList<>();
    private final List<ArrayList<Integer>> EXPECTED_GRID_2 = new ArrayList<>();

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
    public void testGetZeroLiveCellWithInitilizedGrid() {
        Assertions.assertEquals(0, GameOfLifeService.getAliveCellCount(INITIAL_GRID, ROWS, COLUMNS));
    }

    @Test
    public void testGetFiveLiveCellWithGridWithFiveCells() {
        FIVE_LIVE_CELL_GRID.add(new ArrayList<Integer>(Arrays.asList(0, 1, 0, 0, 0)));
        FIVE_LIVE_CELL_GRID.add(new ArrayList<Integer>(Arrays.asList(0, 1, 0, 0, 0)));
        FIVE_LIVE_CELL_GRID.add(new ArrayList<Integer>(Arrays.asList(0, 1, 0, 0, 1)));
        FIVE_LIVE_CELL_GRID.add(new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0)));
        FIVE_LIVE_CELL_GRID.add(new ArrayList<Integer>(Arrays.asList(1, 0, 0, 0, 0)));
        Assertions.assertEquals(5, GameOfLifeService.getAliveCellCount(FIVE_LIVE_CELL_GRID, ROWS, COLUMNS));
    }

    @Test
    public void testGenerateNextWithThreeSeededGridExpectedTwoLiveCell() {
        SEED_GRID_1.add(new ArrayList<Integer>(Arrays.asList(0, 1, 0, 0, 0)));
        SEED_GRID_1.add(new ArrayList<Integer>(Arrays.asList(0, 1, 0, 0, 0)));
        SEED_GRID_1.add(new ArrayList<Integer>(Arrays.asList(0, 1, 0, 0, 0)));
        SEED_GRID_1.add(new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0)));
        SEED_GRID_1.add(new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0)));

        EXPECTED_GRID_1.add(new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0)));
        EXPECTED_GRID_1.add(new ArrayList<Integer>(Arrays.asList(0, 1, 1, 0, 0)));
        EXPECTED_GRID_1.add(new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0)));
        EXPECTED_GRID_1.add(new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0)));
        EXPECTED_GRID_1.add(new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0)));
        List<ArrayList<Integer>> future = GameOfLifeService.generateNext(SEED_GRID_1, ROWS, COLUMNS);
        Assertions.assertEquals( EXPECTED_GRID_1, future);
    }

    @Test
    public void testGenerateNextWithFourSeededGridShouldntExpectFourLiveCell() {

        SEED_GRID_2.add(new ArrayList<Integer>(Arrays.asList(0, 1, 0, 0, 0)));
        SEED_GRID_2.add(new ArrayList<Integer>(Arrays.asList(0, 1, 0, 0, 0)));
        SEED_GRID_2.add(new ArrayList<Integer>(Arrays.asList(0, 1, 0, 0, 0)));
        SEED_GRID_2.add(new ArrayList<Integer>(Arrays.asList(0, 1, 0, 0, 0)));
        SEED_GRID_2.add(new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0)));

        EXPECTED_GRID_2.add(new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0)));
        EXPECTED_GRID_2.add(new ArrayList<Integer>(Arrays.asList(0, 0, 1, 0, 0)));
        EXPECTED_GRID_2.add(new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0)));
        EXPECTED_GRID_2.add(new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0)));
        EXPECTED_GRID_2.add(new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0)));

        List<ArrayList<Integer>> future = GameOfLifeService.generateNext(SEED_GRID_2, ROWS, COLUMNS);

        Assertions.assertNotEquals(EXPECTED_GRID_2, future);
    }
}