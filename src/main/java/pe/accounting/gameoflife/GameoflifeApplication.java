package pe.accounting.gameoflife;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.accounting.gameoflife.controller.GameOfLifeController;

import java.util.Scanner;
@SpringBootApplication
public class GameoflifeApplication {

    public static void main(String[] args) {
        SpringApplication.run(GameoflifeApplication.class, args);
        Scanner scan = new Scanner(System.in);
        System.out.print("Do you want to play Game of Life: (y/n): ");
        String answer = scan.next().toLowerCase();
        if(answer.equals("y")) {
            GameOfLifeController.start();
        } else {
            System.out.println("Exit!");
        }

    }

}
