package com.gerskom;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class SimulationPanel extends JPanel{
    public final Grid map;
    public boolean pause = true;
    public boolean started = false;

    private int deltaTime = 30;

    private Color bgColor = new Color(50, 50, 50);
    private Color fireColor = new Color(250, 110, 0);
    private Color treeColor = new Color(110, 125, 40);

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
                    g2D.setColor(bgColor);
                else if (map.table[x][y] == Grid.tree)
                    g2D.setColor(treeColor);
                else if (map.table[x][y] == Grid.fire)
                    g2D.setColor(fireColor);
                else {
                    int color = map.inputImageTable[x][y];
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
            timer = new Timer(deltaTime, e -> {
                map.startSimulation();
                repaint();
            });
            timer.start();
        }
    }

    public void exportImage(String fileName) throws IOException {
        BufferedImage bufferedImage = new BufferedImage(map.width, map.height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2D = bufferedImage.createGraphics();

        for(int x = 0; x < map.width; x++){
            for(int y = 0; y < map.height; y++){
                if (map.table[x][y] == Grid.burnt)
                    g2D.setColor(bgColor);
                else if (map.table[x][y] == Grid.tree)
                    g2D.setColor(treeColor);
                else if (map.table[x][y] == Grid.fire)
                    g2D.setColor(fireColor);
                else {
                    int color = map.imageTable[x][y];
                    g2D.setColor(new Color(color, color, color));
                }
                g2D.fillRect(x, y, 1, 1);
            }
        }
        g2D.dispose();

        String formatName = "png";
        File file = new File("output/" + fileName + "_" + map.i + "." + formatName);
        ImageIO.write(bufferedImage, formatName, file);
    }
}
