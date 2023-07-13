package com.example.testing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;
import com.example.testing.fun.Control;
@SpringBootApplication
public class TestingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestingApplication.class, args);
		Scanner scanner = new Scanner(System.in);


		Control robo = new Control();

		Boolean start = true;

		while (true) {
			if (!start) {
				System.out.print("Enter command: ");
				String command = scanner.nextLine();

				robo.commandCenter(command);

			}
			else {
				System.out.print("Please Initialize the board: ");
				String command = scanner.nextLine();
				if (command.toUpperCase().charAt(0) == 'I') {

					int size = robo.parseSize(command);

					if (size == -1){
						System.out.println("Invalid command format!");
					}
					else {
						robo.setBoard(size);
						start = false;

					}
				}
			}


	}
	}
}
