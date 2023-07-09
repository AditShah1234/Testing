package com.example.testing.fun;

import java.util.Arrays;

public class Current {
    private int[][] floor;
    private int cX;
    private int cY;
    private boolean Pen;
    private facing currentFace;

    private int rot =0;
    public Current(int n) {
        System.out.println(n+"djk");
        floor = new int[n][n];
        currentFace  = facing.NORTH;
        cX  = 0;
        cY = 0;
        Pen = false;
        int rot =90;
    }

    public int[][] getFloor() {
        return floor;
    }

    public void setFloor(int[][] floor) {
        this.floor = floor;
    }

    public int getcX() {
        return cX;
    }

    public void setcX(int cX) {
        this.cX = cX;
    }

    public int getcY() {
        return cY;
    }

    public void setcY(int cY) {
        this.cY = cY;
    }

    public boolean isPen() {
        return Pen;
    }

    public void setPen(boolean pen) {
        Pen = pen;
    }

    public facing getCurrentFace() {
        return currentFace;
    }

    public void setCurrentFace(facing currentFace) {
        this.currentFace = currentFace;
    }


    @Override
    public String toString() {
        return "Current{" +
                "floor=" + Arrays.toString(floor) +
                ", cX=" + cX +
                ", cY=" + cY +
                ", Pen=" + Pen +
                ", currentFace=" + currentFace +
                '}';
    }

    public enum facing {
        NORTH,
        EAST,
        SOUTH,
        WEST
    }

}
