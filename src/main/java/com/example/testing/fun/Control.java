package com.example.testing.fun;




public class Control {

    public Current current;

    public void setBoard(int n) {
        current = new Current(n);
    }


    public void commandCenter(String command) {
        System.out.println(command);

        char action = command.toUpperCase().charAt(0);

        switch (action) {
            case 'L':
                left();

                break;
            case 'R':
                right();
                break;
            case 'U':
                up();

                break;
            case 'D':
                down();
                break;
            case 'M':
                int spaces = parseSpaces(command);
                move(spaces);
                break;
            case 'P':
                //Print N *N
            	current.printFloor();
                break;
            case 'C':
                System.out.println(current.toString());
                break;
            case 'Q':
                System.out.println("Stopping the program...");
                System.exit(0);
                break;
            case 'I':
                int size = parseSize(command);
                if (size==-1) {
                    System.out.println("Invalid input");
                    break;
                 }
                System.out.println(size);
                init(size);
                break;
            default:
            	throw new IllegalArgumentException("Invalid input");	
                
        }
        current.toString();

    }
    public int parseSize(String command) {
        int size = 0;
        try {
            size = Integer.parseInt(command.substring(2));
        } catch (NumberFormatException e) {
            return -1;
        }
        return size;
    }
    public int parseSpaces(String command) {
        int spaces = 0;
        try {
            spaces = Integer.parseInt(command.substring(2));
        } catch (NumberFormatException e) {
            System.out.println("Invalid number of spaces!");
        }
        return spaces;
    }
    
    private void move(int spaces) {
    	
    	    //North
    	    if(current.getRot()==0) {
    	    	if(current.getcY()+spaces>= current.getFloor().length) {	
    	    	   throw new IndexOutOfBoundsException("Out of bounds error");	
    	    	   }
    	    	else{
    	    		if(current.isPen()==true) {	
    	    			int[][] newfloor = current.getFloor();
    	    			for(int i=0;i<=spaces;i++) {
    	    			newfloor[current.getcX()][current.getcY()+i]=1;
    	    			}
    	    			current.setFloor(newfloor);
    	    			current.setcY(current.getcY()+spaces);	
    	    		    }
    	    		else {
    	                current.setcY(current.getcY()+spaces);
    	    	}
    	    }	
}
    	    //East
    	    else if(current.getRot()==1) {
    	    	
    	    	if(current.getcX()+spaces>=current.getFloor().length) {
    	    		throw new IndexOutOfBoundsException("Out of bounds error");		
    	    	}
    	    	else {	
    	    		if(current.isPen()==true) {	
    	    			int[][] newfloor = current.getFloor();
    	    			for(int i=0;i<=spaces;i++) {
    	    			newfloor[current.getcX()+i][current.getcY()]=1;
    	    			}
    	    			current.setFloor(newfloor);
    	    			current.setcX(current.getcX()+spaces);	
    	    		    }
    	    		else {
    	                current.setcX(current.getcX()+spaces);
    	    	}
    	    }	
}
    	    //South
    	    else if(current.getRot()==2) {  	
    	    	if(current.getcY()-spaces<0) {
    	    		throw new IndexOutOfBoundsException("Out of bounds error");		    		
    	    	}
    	    	else {
	    		    if(current.isPen()==true) {	
    	    			int[][] newfloor = current.getFloor();
    	    			for(int i=0;i<=spaces;i++) {
    	    			newfloor[current.getcX()][current.getcY()-i]=1;
    	    			}
    	    			current.setFloor(newfloor);
    	    			current.setcY(current.getcY()-spaces);	
    	    		    }
    	    		else {
    	                current.setcY(current.getcY()-spaces);
    	    	}
    	    }	
}
    	    //West
    	    else if(current.getRot()==3) {
    	    	if(current.getcX()-spaces<0) {  	    		
    	    		throw new IndexOutOfBoundsException("Out of bounds error");	
    	    	}
    	    	else {
    	    		
    	    		if(current.isPen()==true) {	
    	    			int[][] newfloor = current.getFloor();
    	    			for(int i=0;i<=spaces;i++) {
    	    			newfloor[current.getcX()-i][current.getcY()]=1;
    	    			}
    	    			current.setFloor(newfloor);
    	    			current.setcX(current.getcX()-spaces);	
    	    		    }
    	    		else {
    	                current.setcX(current.getcX()-spaces);
    	    	}
    	    }	
}}




    private void right() {

        if (current.getRot() == 0) {
            current.setRot(1);

        }
        else if (current.getRot() == 1) {
            current.setRot(2);
        }
        else if (current.getRot() == 2) {
            current.setRot(3);
        }
        else {
            current.setRot(0);
        }


    }

    private void init(int n) {
        current = new Current(n);
    }

    private void left() {
        if (current.getRot() == 0) {
            current.setRot(3);
        }
        else if (current.getRot() == 1) {
            current.setRot(0);
        }
        else if (current.getRot() == 2) {
            current.setRot(1);
        }
        else {
            current.setRot(2);
        }
    }

    private void up() {
        current.setPen(false);
    }

    private void down() {
        current.setPen(true);
    }
    


}
