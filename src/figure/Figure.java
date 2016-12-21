/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package figure;

import finder.PointF;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

public class Figure {

    private double x = 0;
    private double y = 0;
    private PointF ds = null;
    private double v0 = 0.0d;
    private double m = 0.0d;
    private double r = 0.0d;

    public Figure(int x, int y, double v0, double m) {
        this.x = x;
        this.y = y;
        this.m = m;
        this.r = 10 * m / 10000000000000d;
        this.v0 = v0;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getM() {
        return m;
    }

    public double getR() {
        return r;
    }

    public double getV0() {
        return v0;
    }

    public void setM(double m) {
        this.m = m;
    }

    public void setV0(double v0) {
        this.v0 = v0;
    }

    public PointF getDs() {
        return ds;
    }

    public void setDs(PointF ds) {
        this.ds = ds;
    }

}
