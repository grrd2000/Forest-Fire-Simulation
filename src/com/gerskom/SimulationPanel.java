package com.gerskom;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SimulationPanel extends JPanel{
    public final Grid map;
    public boolean started = false;

    private int deltaTime = 5;

    private  Color water = new Color(50, 50, 50);
    private Color bgColor = new Color(110, 110, 110);
    private Color treeColor = new Color(170, 170, 170);
    private  Color grass = new Color(225, 225, 225);
    private Color fireColor = new Color(255, 10, 0);

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
                    int color = map.imageTable[x][y];
                    //g2D.setColor(new Color(color, color, color));
                    if(color == 255)
                        g2D.setColor(grass);
                    else
                        g2D.setColor(water);
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

        timer = new Timer(deltaTime, e -> {
            map.startSimulation();
            //if(i % 2 == 0) {
            //    try { exportImage("no_wind_and_map"); }
            //    catch (IOException ex) { ex.printStackTrace(); }
            //}
            repaint();
        });
        timer.start();
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
                    //g2D.setColor(new Color(color, color, color));
                    if(color == 255)
                        g2D.setColor(grass);
                    else
                        g2D.setColor(water);
                }
                g2D.fillRect(x, y, 1, 1);
            }
        }
        g2D.dispose();

        String formatName = "bmp";
        File file;

        if (map.i != 0)
            file = new File("output/" + fileName + "_" + map.i + "." + formatName);
         else
             file = new File("output/test_map." + formatName);

        ImageIO.write(bufferedImage, formatName, file);
    }
}
