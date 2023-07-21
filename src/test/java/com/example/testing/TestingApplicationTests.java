package com.example.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.testing.fun.Control;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Random;

@SpringBootTest
class TestingApplicationTests {


	
	String next_dir(String Current, String input){  //R2
		if (Current.equals("North") && (input.equals("R") || input.equals("r")))
			return "East";
		else if (Current.equals("North") && (input.equals("L") || input.equals("l")))
			return "West";
		else if (Current.equals("South") && (input.equals("R") || input.equals("r")))
			return "West";
        else if (Current.equals("South") && (input.equals("L") || input.equals("l")))
			return "East";
		else if (Current.equals("East") && (input.equals("R") || input.equals("r")))
			return "South";
        else if (Current.equals("East") && (input.equals("L") || input.equals("l")))
			return "North";
		else if (Current.equals("West") && (input.equals("R") || input.equals("r")))
			return "North";
        else if (Current.equals("West") && (input.equals("L") || input.equals("l")))
			return "South";
		else
			return null;
	}
	@Test
	void Pentest(){ //R2
		Control c = new Control();
        Random random = new Random();

        int n = random.nextInt(1,5);
        String k;
        c.setBoard(n);
		for (int i = 0; i < n; i++) {
			c.current.setPen(true);
			assert c.current.isPen();
			c.current.setPen(false);
			assert !c.current.isPen();

		}

	}
	@Test
	void floorTest(){ //R4
		Control c = new Control();
		Random random = new Random();

		int n = random.nextInt(100);
        String k;
        c.setBoard(n);
		int[][] floor1 = c.current.getFloor();
		assert  floor1.length==n;
	}
	@Test
	void ControlTest(){ //R2
		//Full rotation test
		Control c = new Control();
		int  n= 10;
		int rand;
		String k;
		c.setBoard(n);

		for(int r = 0; r < 4; r++){
			String curr = c.current.array[c.current.getRot()];
			c.commandCenter("R");
			String s = c.current.array[c.current.getRot()];
			assert next_dir(curr, "R").equals(s);
			}// Right Test
		for(int r = 0; r < 4; r++){
			String curr = c.current.array[c.current.getRot()];
			c.commandCenter("L");
			String s = c.current.array[c.current.getRot()];
			assert next_dir(curr, "L").equals(s);
			}// Left Test
		Random random = new Random();

		for(int r = 0; r < 10; r++){
			rand = random.nextInt(50);
			if (rand%2 == 0) {
				 k = "R";
			} else {
				 k = "L";
			}
			String curr = c.current.array[c.current.getRot()];
            c.commandCenter(k);
            String s = c.current.array[c.current.getRot()];
            assert next_dir(curr, k).equals(s);
			}
        }
	@Test
	public void testSystemOut() { //R4
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));

		
		System.out.println("Hello, World!");

		
		String printedOutput = outputStream.toString().trim();

		
		System.setOut(System.out);

	
		Assertions.assertEquals("Hello, World!", printedOutput);
	}
	@Test
	void MoveOutOfBoundsTest() { //R1
		Control c= new Control();
		c.commandCenter("I 10");
		//North
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outputStream);
		System.setOut(printStream);
		c.commandCenter("M 11");
		String printedOutput = outputStream.toString().trim();
		System.setOut(System.out);
		Assertions.assertEquals("java.lang.IndexOutOfBoundsException: Out of bounds error", printedOutput);
        //East
		c.commandCenter("I 10");
        c.commandCenter("R");
		outputStream = new ByteArrayOutputStream();
		printStream = new PrintStream(outputStream);
		System.setOut(printStream);
		c.commandCenter("M 11");
		printedOutput = outputStream.toString().trim();
		System.setOut(System.out);
		Assertions.assertEquals("java.lang.IndexOutOfBoundsException: Out of bounds error", printedOutput);
        //South
		c.commandCenter("I 10");
        c.commandCenter("R");
        c.commandCenter("R");
		outputStream = new ByteArrayOutputStream();
		printStream = new PrintStream(outputStream);
		System.setOut(printStream);
		c.commandCenter("M 11");
		printedOutput = outputStream.toString().trim();
		System.setOut(System.out);
		Assertions.assertEquals("java.lang.IndexOutOfBoundsException: Out of bounds error", printedOutput);
        //West
        c.commandCenter("I 10");
        c.commandCenter("L");
		outputStream = new ByteArrayOutputStream();
		printStream = new PrintStream(outputStream);
		System.setOut(printStream);
		c.commandCenter("M 11");
		printedOutput = outputStream.toString().trim();
		System.setOut(System.out);
		Assertions.assertEquals("java.lang.IndexOutOfBoundsException: Out of bounds error", printedOutput);
}
	@Test
	void MoveFunctionTest() { //R1
		
		//PenDownOneRotation
		Control c = new Control();
		c.commandCenter("I 10");
		c.commandCenter("D");
		c.commandCenter("M 9");
		for(int i=0;i<10;i++) {
			
			assert c.current.getFloor()[0][0+i]==1;
		}
		
		c.commandCenter("R");
		c.commandCenter("M 9");
        for(int i=0;i<10;i++) {
			
			assert c.current.getFloor()[0+i][9]==1;
		}
        
        c.commandCenter("R");
		c.commandCenter("M 9");
        for(int i=0;i<10;i++) {
			
			assert c.current.getFloor()[9][9-i]==1;
		}
        c.commandCenter("R");
		c.commandCenter("M 9");
        for(int i=0;i<10;i++) {
			
			assert c.current.getFloor()[9-i][0]==1;
		}
        
        //PenUpOneRotation
		c.commandCenter("U");
		c.commandCenter("I 10");
		c.commandCenter("M 9");
		
		assert c.current.getcX()==0 & c.current.getcY()==9 ;
		
		
		c.commandCenter("R");
		c.commandCenter("M 9");
		
		assert c.current.getcX()==9 & c.current.getcY()==9 ;
        
        c.commandCenter("R");
		c.commandCenter("M 9");
		
		assert c.current.getcX()==9 & c.current.getcY()==0 ;
        
        c.commandCenter("R");
		c.commandCenter("M 9");
		
		assert c.current.getcX()==0 & c.current.getcY()==0 ;
		
		
		//PenUpandDownTestDuringMovement
		c.commandCenter("I 10");
		c.commandCenter("D");
		c.commandCenter("M 3");
        for(int i=0;i<4;i++) {
			
			assert c.current.getFloor()[0][0+i]==1;
		}
        c.commandCenter("U");
        c.commandCenter("M 6");
        for(int i=0;i<4;i++) {
			
			assert c.current.getFloor()[0][4+i]==0;
		}
	}
		@Test
		void InvalidInputTest() { //R3

			Control c = new Control();
			c.commandCenter("I 10");
			c.commandCenter("M 3");
			c.commandCenter("L");
			c.commandCenter("R");
			c.commandCenter("U");
			c.commandCenter("P");
			c.commandCenter("C");


			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			PrintStream printStream = new PrintStream(outputStream);
			System.setOut(printStream);
			c.commandCenter("X");
			String printedOutput = outputStream.toString().trim();
			System.setOut(System.out);
			Assertions.assertEquals("java.lang.IllegalArgumentException: Invalid input", printedOutput);

			c.commandCenter("I 10");

			outputStream = new ByteArrayOutputStream();
			printStream = new PrintStream(outputStream);
			System.setOut(printStream);
			c.commandCenter("I");
			printedOutput = outputStream.toString().trim();
			System.setOut(System.out);
			Assertions.assertEquals("Invalid command format!", printedOutput);


			c.commandCenter("I 10");

			outputStream = new ByteArrayOutputStream();
			printStream = new PrintStream(outputStream);
			System.setOut(printStream);
			c.commandCenter("I10");
			printedOutput = outputStream.toString().trim();
			System.setOut(System.out);
			Assertions.assertEquals("Invalid command format!", printedOutput);


			c.commandCenter("D");
			outputStream = new ByteArrayOutputStream();
			printStream = new PrintStream(outputStream);
			System.setOut(printStream);
			c.commandCenter("D1");
			printedOutput = outputStream.toString().trim();
			System.setOut(System.out);
			Assertions.assertEquals("Invalid command format!", printedOutput);


			c.commandCenter("D");
			outputStream = new ByteArrayOutputStream();
			printStream = new PrintStream(outputStream);
			System.setOut(printStream);
			c.commandCenter("D ");
			printedOutput = outputStream.toString().trim();
			System.setOut(System.out);
			Assertions.assertEquals("Invalid command format!", printedOutput);


			c.commandCenter("M 8");
			outputStream = new ByteArrayOutputStream();
			printStream = new PrintStream(outputStream);
			System.setOut(printStream);
			c.commandCenter("M");
			printedOutput = outputStream.toString().trim();
			System.setOut(System.out);
			Assertions.assertEquals("Invalid command format!", printedOutput);

			c.commandCenter("M 9");
			outputStream = new ByteArrayOutputStream();
			printStream = new PrintStream(outputStream);
			System.setOut(printStream);
			c.commandCenter("M3");
			printedOutput = outputStream.toString().trim();
			System.setOut(System.out);
			Assertions.assertEquals("Invalid command format!", printedOutput);


		}
		
		@Test
        void PrintFunctionTest() { //R4
			Control c = new Control();

			//Initialize the system, the array elements will be set to 0
			c.commandCenter("I 6");
			for (int i = 0; i < 6; i++) {
		        for (int j = 0; j < 6; j++) {
		        	assert c.current.printFloor()[i][j] == '0';
		        }}
			//Moving while pen up and the array elements will be 0
			c.commandCenter("M 5");
			for (int i = 5; i >= 0; i--) {
		        	assert c.current.printFloor()[i][0] == '0';
			}

			//Moving while pen down and the array elements will be 1 in the path moved
			c.commandCenter("D");
			c.commandCenter("R");
			c.commandCenter("M 4");
			for (int j = 0; j <4; j++) {
	        	assert c.current.printFloor()[0][0] == '*';
			}

			//Moving while pen down and pen up and checking together
			c.commandCenter("I 10");
			c.commandCenter("M 9");
			c.commandCenter("D");
			c.commandCenter("R");
			c.commandCenter("M 9");
			for(int i=9;i>0;i--)
				assert c.current.printFloor()[i][0] == '0';
			for(int j=0;j<10;j++)
				assert c.current.printFloor()[0][j] == '*';





	}

		
		
			

	



}