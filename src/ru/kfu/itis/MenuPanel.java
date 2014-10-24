package ru.kfu.itis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by mg on 17.10.14.
 */
public class MenuPanel extends JFrame {
    View view;

    public class View{
        public JLabel lbl_height;
        public JLabel lbl_width;
        public JLabel lbl_radius;
        public JTextField tf_height;
        public JTextField tf_width;
        public JTextField tf_radius;
        public JButton btn_go;

        View(){
            lbl_height = new JLabel("Высота прямоугольника:");
            lbl_width = new JLabel("Ширина прямоугольника:");
            lbl_radius = new JLabel("Радиус соты");
            tf_height = new JTextField();
            tf_width = new JTextField();;
            tf_radius = new JTextField();;
            btn_go = new JButton("GO!");
        }
    }

    MenuPanel(){
        super();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(new GridLayout(7,1));
        view  = new View();
        view.btn_go.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new ResultPanel(new Integer(view.tf_height.getText()), new Integer(view.tf_width.getText()),
                            new Integer(view.tf_radius.getText()));
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(Main.menuPanel, "ERROR",  "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        //adding
        this.add(view.lbl_height);
        this.add(view.tf_height);
        this.add(view.lbl_width);
        this.add(view.tf_width);
        this.add(view.lbl_radius);
        this.add(view.tf_radius);
        this.add(view.btn_go);


        this.setVisible(true);
//        System.out.println(this.getBackground().toString());
    }
}
