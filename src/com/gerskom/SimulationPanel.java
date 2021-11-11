package com.gerskom;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public class SimulationPanel extends JPanel{
    public final Grid map;
    public boolean pause = true;
    public boolean started = false;

    public SimulationPanel (Grid grid) {
        super();
        this.map = grid;
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addMouseListener(new MainInputHandler(this));
        this.addMouseMotionListener(new MainInputHandler(this));
        this.addKeyListener(new MainInputHandler(this));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g.create();

        for(int x = 0; x < map.width; x++){
            for(int y = 0; y < map.height; y++){
                if (map.table[x][y] == Grid.burnt)
                    g2D.setColor(map.bgColor);
                else if (map.table[x][y] == Grid.tree)
                    g2D.setColor(map.treeColor);
                else if (map.table[x][y] == Grid.fire)
                    g2D.setColor(map.fireColor);
                else {
                    int color = map.imageTable[x][y];
                    g2D.setColor(new Color(color, color, color));
                }
                g2D.fillRect(x, y, 1, 1);
            }
        }
        g2D.dispose();
        this.requestFocusInWindow();
    }

    public void startTheFire(){
        Timer timer;
        started = true;

        if(!pause) {
            timer = new Timer(16, e -> {
                map.startSimulation();
                repaint();
            });
            timer.start();
        }
    }
}
