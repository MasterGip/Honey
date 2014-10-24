package ru.kfu.itis;

import java.util.ArrayList;

/**
 * Created by mg on 24.10.14.
 */
public class Generator{

//    public Hexagon hexagon;
    public int x_l, y_l, R;
    public Point[] pnts;

    public double x_move, y_move;



    Generator(int x, int y, int radius){
        this.x_l = x;
        this.y_l = y;
        this.R = radius;
        pnts = this.getHexagonPoints();
    }

    public Point[] getHexagonPoints(){
        double xm;
        double ym;
        double r = R * Math.sqrt(3)/2;
        Hexagon hex = new Hexagon(0.5 * R, r, R);
        ArrayList<Point> points = new ArrayList<Point>();


        do {

            while (hex.center_y - r  < y_l){


                points.add(new Point(hex.center_x, hex.center_y));

                hex.center_y += r * 2;

            }


            hex.center_y -=  r;
            ym = hex.center_y;
            hex.center_x += 1.5 * R;

            if(hex.center_y - r > y_l){
                hex.center_y -=  2 * r;


            }
            if(hex.center_x - R  < x_l) {
                while ((hex.center_y + r)> 0) {

                    points.add(new Point(hex.center_x, hex.center_y));

                    hex.center_y -= 2 * r ;

                }
                hex.center_y += 3 * r;
                hex.center_x += 1.5 * R;

            }


        }while(hex.center_x - R  < x_l);
        xm = points.get(points.size() - 1).x + R;
//        System.out.println(xm + " " + x_l);
        x_move = ((xm - (double)x_l) - 0.5 * R)/2;
//        System.out.println(x_move);
        y_move = ((ym - (double)y_l))/2;
        Point[] p = new Point[points.size()];
        for(int i = 0; i < points.size(); i++){
            p[i] = points.get(i);
        }
        return p;
    }

//    public double getMoveByX

}
