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
		System.out.print("Enter the size of the floor: ");
		int size = scanner.nextInt();
		Control robo = new Control();
		robo.setBoard(size);


		while (true) {
			System.out.print("Enter command: ");
			try {
				String command = scanner.nextLine();

				robo.commandCenter(command);
			}
			catch (Exception e) {
                continue;
            }

	}
	}
}
