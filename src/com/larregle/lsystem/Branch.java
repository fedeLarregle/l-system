package com.larregle.lsystem;

public class Branch {
    private final int x;
    private final int y;
    private final float angle;

    public Branch(int x, int y, float angle) {
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

    public float getAngle() {
        return angle;
    }
}
