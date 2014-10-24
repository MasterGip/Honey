package ru.kfu.itis;

/**
 * Created by mg on 18.10.14.
 */
public class Hexagon {
    double center_x, center_y;
    int radius;

    public Hexagon(double i, double i1, int radius) {
        center_x = i;
        center_y = i1;
        this.radius = radius;
    }

    public int[] getXPoints(){
        int[] x = {(int) (center_x + radius), (int) (center_x + (radius*0.5)),
                (int) (center_x - (radius*0.5)), (int) (center_x - radius),
                (int) (center_x - (radius*0.5)), (int) (center_x + (radius*0.5))};
        return x;
    }

    public int[] getYPoints(){
        int[] y = {(int)center_y , (int) (center_y - (radius*Math.sqrt(3)/2)),
                (int) (center_y - (radius*Math.sqrt(3)/2)), (int) center_y,
                (int) (center_y + (radius*Math.sqrt(3)/2)), (int) (center_y + (radius*Math.sqrt(3)/2))};
        return y;
    }
}
