package com.company;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Kwadraty extends JPanel {
    public int[][] arr = new int[10][10];
    public int x = 0;
    public int y = 0;

    public Kwadraty() {
        setPreferredSize(new Dimension(500, 500));
        setLayout(new FlowLayout());
    }

    public void rysujkwadrat(int X, int Y) {
        x = X;
        y = Y;
        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);

        for (int i = 0; i < 10; ++i) {
            g.setColor(Color.RED);
            g.fillRect(x * 50, y * 50, 50, 50);
            for (int j = 0; j < 10; ++j) {
                g.setColor(Color.yellow);
                if (arr[j][i] == 1) {
                    g.fillRect(j * 50 + 20, i * 50 + 20, 20, 20);

                }

            }
        }
    }

    public void yellow_trail(int[][] tab1) {
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 10; ++j) {
                arr[i][j] = tab1[i][j];
            }
        }
    }
}

