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

                break;
            case 'R':

                break;
            case 'U':

                break;
            case 'D':

                break;
            case 'M':
                int spaces = parseSpaces(command);
                System.out.println(spaces);
                break;
            case 'P':

                break;
            case 'C':

                break;
            case 'Q':

                break;

            case 'I':
                int size = parseSize(command);
                System.out.println(size);
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



}
