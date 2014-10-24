package ru.kfu.itis;

import javax.swing.*;

/**
 * Created by mg on 17.10.14.
 */
public class Main {
    public static MenuPanel menuPanel;

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                menuPanel = new MenuPanel();
            }
        });
    }
}
