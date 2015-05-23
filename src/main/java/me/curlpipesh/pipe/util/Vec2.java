package me.curlpipesh.pipe.util;

/**
 * @author audrey
 * @since 5/21/15
 */
@SuppressWarnings("unused")
public class Vec2 {
    private double x, y;

    public Vec2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vec2 add(Vec2 v) {
        x += v.x;
        y += v.y;
        return this;
    }

    public Vec2 sub(Vec2 v) {
        x -= v.x;
        y -= v.y;
        return this;
    }

    public Vec2 mul(Vec2 v) {
        x *= v.x;
        y *= v.y;
        return this;
    }

    public Vec2 div(Vec2 v) {
        x /= v.x;
        y /= v.y;
        return this;
    }

    public double dist(Vec2 v) {
        return Math.sqrt(x*v.x+y*v.y);
    }

    public double dot(Vec2 v) {
        return x*v.x + y*v.y;
    }

    public double cross(Vec2 v) {
        return x*v.y - y*v.x;
    }

    public Vec2 addX(double x) {
        this.x += x;
        return this;
    }

    public Vec2 addY(double y) {
        this.y += y;
        return this;
    }

    public Vec2 set(Vec2 v) {
        this.x = v.x;
        this.y = v.y;
        return this;
    }

    public double x() {
        return x;
    }

    public double y() {
        return y;
    }

    public void x(double x) {
        this.x = x;
    }

    public void y(double y) {
        this.y = y;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
