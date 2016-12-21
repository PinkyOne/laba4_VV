/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finder;

import figure.Figure;
import java.awt.Point;
import java.util.LinkedList;

public class Finder extends Thread {

    private LinkedList<Figure> figures = null;
    private int toFigure = 0;
    private int doFigure = 0;
    private double dt = 0.0d;
    private long time = 0;

    public Finder(LinkedList<Figure> figures, int toFigure, int doFigure, double dt) {
        this.figures = figures;
        this.toFigure = toFigure;
        this.doFigure = doFigure;
        this.dt = dt;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        double r = 0.0d;
        for (int i = this.toFigure; i < this.doFigure; i++) {
            double Fxsum = 0.0d;
            double Fysum = 0.0d;
            for (int j = 0; j < this.figures.size(); j++) {
                if (j != i) {
                    double x1x0 = this.figures.get(j).getX() - this.figures.get(i).getX();
                    double y1y0 = this.figures.get(j).getY() - this.figures.get(i).getY();
                    r = Math.sqrt(Math.pow(x1x0, 2.0d) + Math.pow(y1y0, 2.0d));
                    if (r > this.figures.get(i).getR() + this.figures.get(j).getR()) {
                        double F = 6.67300d * Math.pow(10.0d, -11.0d) * this.figures.get(i).getM() * this.figures.get(j).getM() / Math.pow(r, 2.0d);
                        Fxsum += x1x0 * F / r;
                        Fysum += y1y0 * F / r;
                    } else {
                        double F = -6.67300d * Math.pow(10.0d, -11.0d) * this.figures.get(i).getM() * this.figures.get(j).getM() / Math.pow(r, 2.0d);
                        Fxsum += x1x0 * F / r;
                        Fysum += y1y0 * F / r;
                    }
                }
            }
            double dsx = Fxsum * this.dt * (this.dt + 0.5d) / this.figures.get(i).getM();
            double dsy = Fysum * this.dt * (this.dt + 0.5d) / this.figures.get(i).getM();
            this.figures.get(i).setDs(new PointF(dsx, dsy));
        }
        long finish = System.currentTimeMillis();
        time = finish - start;

    }

    public long getTime() {
        return time;
    }
}
