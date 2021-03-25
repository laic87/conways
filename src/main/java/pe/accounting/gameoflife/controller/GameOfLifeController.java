package pe.accounting.gameoflife.controller;
import pe.accounting.gameoflife.View.PrintView;
import pe.accounting.gameoflife.service.GameOfLifeService;
import pe.accounting.gameoflife.service.SeedService;

import java.util.ArrayList;
import java.util.List;

public class GameOfLifeController {

    private static final int COLUMNS = 30;
    private static final int ROWS = 30;

    private static int stepCounter = 0;
    private static int aliveCellCount = 0;

    public static void start() {

        List<ArrayList<Integer>> board = new ArrayList<>();
        List<ArrayList<Integer>> nextGeneration;

        GameOfLifeService.initializeGrid(COLUMNS, ROWS, board);

        PrintView.printGrid(board, ROWS, COLUMNS, stepCounter);

        SeedService.plantSeed(5, board);

        PrintView.printGrid(board, ROWS, COLUMNS, ++stepCounter);

        do {
            nextGeneration = board;
            board =  GameOfLifeService.generateNext(nextGeneration, ROWS, COLUMNS);
            PrintView.printGrid(board, ROWS, COLUMNS, ++stepCounter);
            aliveCellCount = GameOfLifeService.getAliveCellCount(board, ROWS, COLUMNS);

        } while( (aliveCellCount > 0));
    }
}
