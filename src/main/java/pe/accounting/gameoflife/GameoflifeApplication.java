package pe.accounting.gameoflife;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.accounting.gameoflife.model.Board;
import pe.accounting.gameoflife.model.Cell;

@SpringBootApplication
public class GameoflifeApplication {

    public static void main(String[] args) {
        SpringApplication.run(GameoflifeApplication.class, args);

        Board board = new Board();
        Cell cell = new Cell();

        System.out.println(cell.getStatus());

    }

}
