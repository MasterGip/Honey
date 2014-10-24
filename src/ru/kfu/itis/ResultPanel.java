package ru.kfu.itis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.awt.Font.ITALIC;

/**
 * Created by mg on 17.10.14.
 */
public class ResultPanel extends JFrame{

    private int unit;
    private int y_l, x_l, radius, radius_l;
    public View view;
    public Generator generator;

    public class View{
        public GraphicsPanel panel;
        public JButton btn_go;
    }

    private int gCD(int a, int b){
        int ret = 0;
        if(a!=0 && b!=0) {
            if (a < b) {
                int h = a;
                a = b;
                b = h;
            }
            while (a % b != 0) {
                int h = b;
                b = a % b;
                a = h;

            }
            ret = b;
        }
        return ret;
    }

    private int gCD(int a, int b, int c){
        int gCD1 = gCD(a, b);
        gCD1 = gCD(gCD1, c);
//        int gCD3 = gCD(b, c);
//        System.out.println(gCD(gCD1, gCD2));
        return gCD1;
    }

    private int round(double d){
        return ((int)(d*10)%10 > 5)?(int)d+1:(int)d;
    }

   public class GraphicsPanel extends JPanel{

       public int help;
       public boolean b;

       private void drawHexagon(Graphics g, Hexagon h){
           g.drawPolygon(h.getXPoints(), h.getYPoints(), 6);
       }

       private void drawNumber(Graphics g){
           generator = new Generator(x_l, y_l, radius);
           if (y_l < 2 * radius) {
               unit = round(this.getSize().getHeight() / (6 * radius));
           } else {
               unit = round(this.getSize().getHeight() / (y_l + 4 * radius));
           }
           int[] x = {2 * radius * unit  + (int)(generator.x_move * unit),
                   2 * radius * unit + x_l * unit  + (int)(generator.x_move * unit),
                   2 * radius * unit + x_l * unit + (int)(generator.x_move*unit),
                   2 * radius * unit  + (int)(generator.x_move*unit)
           };
           int[] y = {2 * radius * unit + (int)(generator.y_move * unit),
                   2 * radius * unit + + (int)(generator.y_move * unit),
                   2 * radius * unit + y_l * unit + (int)(generator.y_move * unit),
                   2 * radius * unit + y_l * unit+ (int)(generator.y_move*unit)
           };

           g.drawPolygon(x, y , 4);
           g.setColor(Color.RED);
//           drawHexagon(g, );
//           Hexagon hexagon = new Hexagon((int) (2.0 * radius * unit + radius * Math.cos(Math.PI / 3) * unit),
//                   (int) (2.0 * radius * unit + radius * Math.sin(Math.PI / 3) * unit), radius * unit);


//           int k = 1;
//           radius_l = (int) (radius * unit/ (2 * Math.tan(Math.PI / 6)));
            for(Point point : generator.pnts){

                drawHexagon(g, new Hexagon(point.x * unit + 2 * radius * unit, point.y * unit + 2 * radius * unit, radius * unit));
            }
           g.setColor(Color.BLACK);

           g.drawString("Число сот: " + generator.pnts.length,0,10);
       }


//
//       private void drawNotNumber(Graphics g){
//           drawNumber(g);
//           Color c = g.getColor();
//
//
//            g.setColor(new Color(238, 238, 238));
//            g.fillRect(0,0,2*radius*unit,this.getHeight());
//            g.fillRect(0,0,this.getWidth() , 2*radius*unit);
//            g.fillRect(2*radius*unit+1 + x_l*unit,0,this.getWidth() - (2*radius*unit+1 + x_l*unit),this.getHeight());
//            g.fillRect(0,2*radius*unit+1 + y_l*unit,this.getWidth(), this.getHeight() - (2*radius*unit+1 + y_l*unit));
//           g.setColor(c);
//       }


       @Override
       public void paint(Graphics g) {
           super.paint(g);

           drawNumber(g);

       }

       GraphicsPanel(){
           super();
           help = 0;
           b = false;

       }

   }



    ResultPanel(int h, int w, int r){
        super();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(700,700);
//        this.setResizable(false);
        int gDC = gCD(h, w, r);
        h /=gDC;
        w/=gDC;
        r/=gDC;
        this.y_l = Math.max(h, w);
        this.x_l = Math.min(h, w);
        this.radius = r;
        view = new View();
        view.panel = new GraphicsPanel();
//        view.btn_go = new JButton("!");
//        view.btn_go.setActionCommand("0");
//        view.btn_go.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if(e.getActionCommand().equals("0")){
//                    view.btn_go.setActionCommand("1");
//                    view.panel.b = true;
//                    view.panel.repaint();
//                }else {
//                    view.btn_go.setActionCommand("0");
//                    view.panel.b = false;
//                    view.panel.repaint();
//                }
//            }
//        });
        this.add(view.panel, BorderLayout.CENTER);
//        this.add(view.btn_go, BorderLayout.SOUTH);




//        this.addComponentListener();
        this.setVisible(true);

    }



}
