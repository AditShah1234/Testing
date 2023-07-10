package com.example.testing.fun;

public class Control {

    Current current;

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
                rigth();
                break;
            case 'U':
                up();

                break;
            case 'D':
                down();
                break;
            case 'M':
                int spaces = parseSpaces(command);
                System.out.println(spaces);
                break;
            case 'P':
                //Print N *N
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
                System.out.println(size);
                init(size);
                break;
            default:
                System.out.println("Invalid command");
                break;
        }
        current.toString();

    }
    private int parseSize(String command) {
        int size = 0;
        try {
            size = Integer.parseInt(command.substring(2));
        } catch (NumberFormatException e) {
            System.out.println("Invalid size!");
        }
        return size;
    }
    private int parseSpaces(String command) {
        int spaces = 0;
        try {
            spaces = Integer.parseInt(command.substring(2));
        } catch (NumberFormatException e) {
            System.out.println("Invalid number of spaces!");
        }
        return spaces;
    }




    private void rigth() {

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
