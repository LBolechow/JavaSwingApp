package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

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
