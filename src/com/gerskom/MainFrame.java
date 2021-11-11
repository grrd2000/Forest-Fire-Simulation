package com.gerskom;

import java.awt.*;
import javax.swing.*;

public class MainFrame extends JFrame {

    JPanel northPanel = new JPanel();
    JPanel westPanel = new JPanel();
    JPanel southPanel = new JPanel();
    JPanel eastPanel = new JPanel();

    SimulationPanel centerPanel;

    private final int hGap = 10;
    private final int vGap = 10;

    MainFrame(Grid map) {
        //ImageIcon icon = new ImageIcon("triangle.png");

        centerPanel = new SimulationPanel(map);

        int width = map.width + 6 * hGap - 3;
        int height = map.height + 8 * vGap;
        //System.out.println(map.width + "x" + map.height);
        //System.out.println(width + "x" + height);
        this.setSize(width, height);
        this.setTitle("Game Of Life");
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        //this.setIconImage(icon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(hGap,vGap));
        this.setVisible(true);

        northPanel.setBackground(Color.DARK_GRAY);
        westPanel.setBackground(Color.DARK_GRAY);
        southPanel.setBackground(Color.DARK_GRAY);
        eastPanel.setBackground(Color.DARK_GRAY);
        centerPanel.setBackground(new Color(58,58,58));

        centerPanel.setLayout(new BorderLayout());

        northPanel.setPreferredSize(new Dimension(0,vGap));
        westPanel.setPreferredSize(new Dimension(hGap,0));
        eastPanel.setPreferredSize(new Dimension(hGap,0));
        southPanel.setPreferredSize(new Dimension(0,vGap));

        this.add(northPanel, BorderLayout.NORTH);
        this.add(westPanel, BorderLayout.WEST);
        this.add(eastPanel, BorderLayout.EAST);
        this.add(southPanel, BorderLayout.SOUTH);
        this.add(centerPanel, BorderLayout.CENTER);
    }
}
