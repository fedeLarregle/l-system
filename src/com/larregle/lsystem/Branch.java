package com.larregle.lsystem;

public class Branch {
    private final int x;
    private final int y;
    private final int angle;

    public Branch(int x, int y, int angle) {
        this.x = x;
        this.y = y;
        this.angle = angle;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getAngle() {
        return angle;
    }
}
