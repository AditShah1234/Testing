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

	@Test
	void contextLoads() {
	}
	String next_dir(String Current, String input){
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
	void Pentest(){
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
	void floorTest(){
		Control c = new Control();
		Random random = new Random();

		int n = random.nextInt(100);
        String k;
        c.setBoard(n);
		int[][] floor1 = c.current.getFloor();
		assert  floor1.length==n;
	}
	@Test
	void ControlTest(){
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
	public void testSystemOut() {
		// Redirect System.out to a ByteArrayOutputStream
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));

		// Perform the operation that prints to System.out
		System.out.println("Hello, World!");

		// Get the output from System.out
		String printedOutput = outputStream.toString().trim();

		// Restore the original System.out
		System.setOut(System.out);

		// Assert the expected output
		Assertions.assertEquals("Hello, World!", printedOutput);
	}
	@Test
	void MoveOutOfBoundsTest() {
		Control c= new Control();
		c.commandCenter("I 10");
//		Throwable exception1 = assertThrows(
//				IndexOutOfBoundsException.class, () -> {
//					c.commandCenter("M 11");
//                }
//        );

//		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//		PrintStream printStream = new PrintStream(outputStream);
//
//		System.setOut(printStream);
//		c.commandCenter("M 11");
//		System.setOut(System.out);
//		String output = outputStream.toString();
//		System.out.println(output);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(outputStream);
		System.setOut(printStream);
		c.commandCenter("M 11");
		String printedOutput = outputStream.toString().trim();
		System.setOut(System.out);
		Assertions.assertEquals("java.lang.IndexOutOfBoundsException: Out of bounds error", printedOutput);

//
        c.commandCenter("I 10");
        c.commandCenter("R");
//
//        Throwable exception2 = assertThrows(
//				IndexOutOfBoundsException.class, () -> {
//					c.commandCenter("M 11");
//                }
//        );
//        Assertions.assertEquals("Out of bounds error", exception2.getMessage());
//
		outputStream = new ByteArrayOutputStream();
		printStream = new PrintStream(outputStream);
		System.setOut(printStream);
		c.commandCenter("M 11");
		printedOutput = outputStream.toString().trim();
		System.setOut(System.out);
		Assertions.assertEquals("java.lang.IndexOutOfBoundsException: Out of bounds error", printedOutput);
        c.commandCenter("I 10");
        c.commandCenter("R");
        c.commandCenter("R");
//
//        Throwable exception3 = assertThrows(
//				IndexOutOfBoundsException.class, () -> {
//					c.commandCenter("M 11");
//                }
//        );
//        Assertions.assertEquals("Out of bounds error", exception3.getMessage());
//
		outputStream = new ByteArrayOutputStream();
		printStream = new PrintStream(outputStream);
		System.setOut(printStream);
		c.commandCenter("M 11");
		printedOutput = outputStream.toString().trim();
		System.setOut(System.out);
		Assertions.assertEquals("java.lang.IndexOutOfBoundsException: Out of bounds error", printedOutput);
        c.commandCenter("I 10");
        c.commandCenter("L");
//
//        Throwable exception4 = assertThrows(
//				IndexOutOfBoundsException.class, () -> {
//					c.commandCenter("M 11");
//                }
//        );
//        Assertions.assertEquals("Out of bounds error", exception4.getMessage());
//
//
		outputStream = new ByteArrayOutputStream();
		printStream = new PrintStream(outputStream);

		System.setOut(printStream);
		c.commandCenter("M 11");
		printedOutput = outputStream.toString().trim();
		System.setOut(System.out);
		Assertions.assertEquals("java.lang.IndexOutOfBoundsException: Out of bounds error", printedOutput);
        
			

}
	@Test
	void MoveFunctionTest() {
		
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
        
        //PenDownOneRotation
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
	



}