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
class PanelSterowania extends JPanel {
    JButton Up = new JButton("Góra");
    JButton Down = new JButton("Dół");
    JButton Left = new JButton("Lewo");
    JButton Right = new JButton("Prawo");
    JCheckBox trail = new JCheckBox("Zostaw ślad");
    JButton Save = new JButton("Zapisz");
    JButton Load = new JButton("Odczytaj");
    JButton Reset = new JButton("Resetuj");
    JCheckBox Guma = new JCheckBox("Gumuj slad");

    public PanelSterowania() {
        setPreferredSize(new Dimension(150, 75));
        add(Up);
        add(Down);
        add(Left);
        add(Right);
        add(trail);
        add(Reset);
        add(Save);
        add(Load);
        add(Guma);


    }

    void addUpListener(ActionListener listenUp) {
        Up.addActionListener(listenUp);
    }

    void addDownListener(ActionListener listenDown) {
        Down.addActionListener(listenDown);
    }

    void addLeftListener(ActionListener listenLeft) {
        Left.addActionListener(listenLeft);
    }

    void addRightListener(ActionListener listenRight) {
        Right.addActionListener(listenRight);
    }

    void addSaveListener(ActionListener listenSave) {
        Save.addActionListener(listenSave);
    }

    void addLoadListener(ActionListener listenLoad) {
        Load.addActionListener(listenLoad);
    }

    void addResetListener(ActionListener listenReset) {
        Reset.addActionListener(listenReset);
    }
}