/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finder;

import figure.Figure;
import java.util.LinkedList;

public class Calculator extends Thread {

    private LinkedList<Figure> figures = null;
    private int toFigure = 0;
    private int doFigure = 0;

    public Calculator(LinkedList<Figure> figures, int toFigure, int doFigure) {
        this.figures = figures;
        this.toFigure = toFigure;
        this.doFigure = doFigure;
    }

    @Override
    public void run() {
        for (int i = this.toFigure; i < this.doFigure; i++) {
            double x = this.figures.get(i).getX() + this.figures.get(i).getDs().getX();
            double y = this.figures.get(i).getY() + this.figures.get(i).getDs().getY();

            this.figures.get(i).setX(x);
            this.figures.get(i).setY(y);
        }
    }
}
