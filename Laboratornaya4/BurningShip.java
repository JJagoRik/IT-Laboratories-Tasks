package Laboratornaya4;

import java.awt.geom.Rectangle2D;

public class BurningShip extends FractalGenerator{

    public static final int MAX_ITERATIONS = 2000;

    @Override
    public void getInitialRange(Rectangle2D.Double range) {
        range.x = -2;
        range.y = -2.5;
        range.width = 4;
        range.height = 4;
    }

    @Override
    public int numIterations(double x, double y) {
        kompChisl z = new kompChisl(0, 0);
        kompChisl c = new kompChisl(x, y);
        int n = 0;
        while (z.getReZ() * z.getReZ() + z.getImZ() * z.getImZ() < 4){
            z = z.squareAbs().iteration(c);
            n += 1;
            if (MAX_ITERATIONS == n) return -1;
        }
        return n;
    }

    public String toString(){
        return "BurningShip";
    }
}