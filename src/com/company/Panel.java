package com.company;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Panel extends JFrame {
    public PanelSterowania panel1 = new PanelSterowania();
    public Kwadraty panel2 = new Kwadraty();
    public int obecnyX = 0;
    public int obecnyY = 0;
    public int[][] arr = new int[10][10];

    public Panel() {
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 10; ++j) {
                arr[i][j] = 0;
            }
        }
        add(panel1, "West");
        add(panel2, "East");
        setResizable(false);
        panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }
}