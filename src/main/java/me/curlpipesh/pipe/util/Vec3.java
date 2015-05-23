package me.curlpipesh.pipe.util;

/**
 * @author audrey
 * @since 5/11/15
 */
@SuppressWarnings("unused")
public class Vec3 implements Cloneable {
    private double x, y, z;

    private static final Vec3 ZERO_VEC = new Vec3(0, 0, 0);
    private static final Vec3 UNIT_VEC = new Vec3(1, 1, 1);

    public Vec3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vec3 add(Vec3 v) {
        x += v.x;
        y += v.y;
        z += v.z;
        return this;
    }

    public Vec3 sub(Vec3 v) {
        x -= v.x;
        y -= v.y;
        z -= v.z;
        return this;
    }

    public Vec3 mul(Vec3 v) {
        x *= v.x;
        y *= v.y;
        z *= v.z;
        return this;
    }

    public Vec3 div(Vec3 v) {
        x /= v.x;
        y /= v.y;
        z /= v.z;
        return this;
    }

    public double dist(Vec3 v) {
        return Math.sqrt(x * v.x + y * v.y + z * v.z);
    }

    public double dot(Vec3 v) {
        return x * v.x + y * v.y + z * v.z;
    }

    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public Vec3 normalize() {
        double l = length();
        x = x / l;
        y = y / l;
        z = z / l;
        return this;
    }

    public Vec3 cross(Vec3 v) {
        double tx = y * v.z - z * v.y;
        double ty = z * v.x - x * v.z;
        double tz = x * v.y - y * v.x;
        x = tx;
        y = ty;
        z = tz;
        return this;
    }

    public Vec3 addX(double x) {
        this.x += x;
        return this;
    }

    public Vec3 addY(double y) {
        this.y += y;
        return this;
    }

    public Vec3 addZ(double z) {
        this.z += z;
        return this;
    }

    public Vec3 set(Vec3 v) {
        this.x = v.x;
        this.y = v.y;
        this.z = v.z;
        return this;
    }

    public double x() {
        return x;
    }

    public double y() {
        return y;
    }

    public double z() {
        return z;
    }

    public void x(double x) {
        this.x = x;
    }

    public void y(double y) {
        this.y = y;
    }

    public void z(double z) {
        this.z = z;
    }

    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }

    public static Vec3 zero() {
        return ZERO_VEC;
    }

    public static Vec3 unit() {
        return UNIT_VEC;
    }
}
