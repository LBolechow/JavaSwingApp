package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Sterowanie {
    public Panel pan;

    public Sterowanie(Panel panel) {
        pan = panel;
        pan.panel1.addUpListener(new MoveUp());
        pan.panel1.addDownListener(new MoveDown());
        pan.panel1.addLeftListener(new MoveLeft());
        pan.panel1.addRightListener(new MoveRight());
        pan.panel1.addSaveListener(new Save());
        pan.panel1.addLoadListener(new Load());
        pan.panel1.addResetListener(new Reset());
    }
    class MoveRight implements ActionListener {
        MoveRight() {
        }

        public void actionPerformed(ActionEvent e) {
            if (pan.obecnyX < 9) {
                if (pan.panel1.trail.isSelected()) {
                    pan.arr[pan.obecnyX][pan.obecnyY] = 1;
                }
                if (pan.panel1.Guma.isSelected()) {
                    if (pan.arr[pan.obecnyX][pan.obecnyY] == 1) {
                        pan.arr[pan.obecnyX][pan.obecnyY] = 0;
                    }


                }
                pan.panel2.yellow_trail(pan.arr);
                pan.obecnyX = pan.obecnyX + 1;
                pan.panel2.rysujkwadrat(pan.obecnyX, pan.obecnyY);
            }

        }
    }

    class MoveLeft implements ActionListener {
        MoveLeft() {
        }

        public void actionPerformed(ActionEvent e) {
            if (pan.obecnyX > 0) {
                if (pan.panel1.trail.isSelected()) {
                    pan.arr[pan.obecnyX][pan.obecnyY] = 1;
                }
                if (pan.panel1.Guma.isSelected()) {
                    if (pan.arr[pan.obecnyX][pan.obecnyY] == 1) {
                        pan.arr[pan.obecnyX][pan.obecnyY] = 0;
                    }


                }
                pan.panel2.yellow_trail(pan.arr);
                pan.obecnyX = pan.obecnyX - 1;
                pan.panel2.rysujkwadrat(pan.obecnyX, pan.obecnyY);
            }

        }
    }

    class MoveDown implements ActionListener {
        MoveDown() {
        }

        public void actionPerformed(ActionEvent e) {
            if (pan.obecnyY < 9) {
                if (pan.panel1.trail.isSelected()) {
                    pan.arr[pan.obecnyX][pan.obecnyY] = 1;
                }
                if (pan.panel1.Guma.isSelected()) {
                    if (pan.arr[pan.obecnyX][pan.obecnyY] == 1) {
                        pan.arr[pan.obecnyX][pan.obecnyY] = 0;
                    }


                }
                pan.panel2.yellow_trail(pan.arr);
                pan.obecnyY = pan.obecnyY + 1;
                pan.panel2.rysujkwadrat(pan.obecnyX, pan.obecnyY);
            }

        }
    }

    class MoveUp implements ActionListener {
        MoveUp() {
        }

        public void actionPerformed(ActionEvent e) {
            if (pan.obecnyY > 0) {
                if (pan.panel1.trail.isSelected()) {
                    pan.arr[pan.obecnyX][pan.obecnyY] = 1;
                }

                if (pan.panel1.Guma.isSelected()) {
                    if (pan.arr[pan.obecnyX][pan.obecnyY] == 1) {
                        pan.arr[pan.obecnyX][pan.obecnyY] = 0;
                    }


                }
                pan.panel2.yellow_trail(pan.arr);
                pan.obecnyY= pan.obecnyY-1;
                pan.panel2.rysujkwadrat(pan.obecnyX, pan.obecnyY);
            }

        }
    }
    class Reset implements ActionListener
    {
        Reset()
        {

        }
        public void actionPerformed(ActionEvent e) {
            pan.obecnyX = 0;
            pan.obecnyY = 0;
            pan.panel2.rysujkwadrat(pan.obecnyX, pan.obecnyY);
            for(int i = 0; i < 10; ++i) {
                for(int j = 0; j < 10; ++j) {
                    pan.arr[i][j] = 0;
                }
                pan.panel2.yellow_trail(pan.arr);
            }
        }

    }

    class Load implements ActionListener {
        Load() {
        }
        String path;
        public void actionPerformed(ActionEvent e) {
            int j;
            try {
                JFileChooser fileChooser = new JFileChooser();
                if (fileChooser.showOpenDialog(null) ==JFileChooser.APPROVE_OPTION)
                {
                    File selectedFile = fileChooser.getSelectedFile();
                    path = selectedFile.getAbsolutePath();
                }

                DataInputStream strumienWejsciowy = new DataInputStream(new FileInputStream(path));
                pan.obecnyX = strumienWejsciowy.readInt();
                pan.obecnyY = strumienWejsciowy.readInt();

                for(j = 0; j < 10; ++j) {
                    for(int z = 0; z < 10; ++z) {
                        pan.panel2.arr[j][z] = strumienWejsciowy.readInt();
                        pan.arr[j][z] =  pan.panel2.arr[j][z];
                    }
                }
            } catch (IOException var5) {
                var5.printStackTrace();
            }

            pan.panel2.yellow_trail(pan.panel2.arr);
            pan.panel2.rysujkwadrat(pan.obecnyX, pan.obecnyY);
        }
    }

    class Save implements ActionListener {
        Save() {
        }
        String path;
        public void actionPerformed(ActionEvent e) {
            try {
                JFileChooser fileChooser = new JFileChooser();
                if (fileChooser.showSaveDialog(null) ==JFileChooser.APPROVE_OPTION)
                {
                    File selectedFile = fileChooser.getSelectedFile();
                    path = selectedFile.getAbsolutePath();
                }
                DataOutputStream strumienWejsciowy = new DataOutputStream(new FileOutputStream(path));
                strumienWejsciowy.writeInt(pan.obecnyX);
                strumienWejsciowy.writeInt(pan.obecnyY);

                for(int i = 0; i < 10; ++i) {
                    for(int j = 0; j < 10; ++j) {
                        strumienWejsciowy.writeInt(pan.panel2.arr[i][j]);
                    }
                }

                strumienWejsciowy.close();
            } catch (IOException var5) {
                var5.printStackTrace();
            }

        }
    }
}




