package com.example.testing;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.testing.fun.Control;

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

}
