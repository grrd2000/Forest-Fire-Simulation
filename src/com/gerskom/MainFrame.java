package com.gerskom;

import java.awt.*;
import javax.swing.*;

public class MainFrame extends JFrame {

    JPanel northPanel = new JPanel();
    JPanel westPanel = new JPanel();
    JPanel southPanel = new JPanel();
    JPanel eastPanel = new JPanel();

    SimulationPanel centerPanel;

    MainFrame(Grid map) {
        //ImageIcon icon = new ImageIcon("triangle.png");

        centerPanel = new SimulationPanel(map);

        int width = map.width + 20;
        int height = map.height + 20;
        this.setSize(width, height);
        this.setTitle("Game Of Life");
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        //this.setIconImage(icon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(10,10));
        this.setVisible(true);

        northPanel.setBackground(Color.DARK_GRAY);
        westPanel.setBackground(Color.DARK_GRAY);
        southPanel.setBackground(Color.DARK_GRAY);
        eastPanel.setBackground(Color.DARK_GRAY);
        centerPanel.setBackground(new Color(58,58,58));

        centerPanel.setLayout(new BorderLayout());

        northPanel.setPreferredSize(new Dimension(100,10));
        westPanel.setPreferredSize(new Dimension(10,100));
        eastPanel.setPreferredSize(new Dimension(10,100));
        southPanel.setPreferredSize(new Dimension(100,10));
        centerPanel.setPreferredSize(new Dimension(100,100));

        this.add(northPanel, BorderLayout.NORTH);
        this.add(westPanel, BorderLayout.WEST);
        this.add(eastPanel, BorderLayout.EAST);
        this.add(southPanel, BorderLayout.SOUTH);
        this.add(centerPanel, BorderLayout.CENTER);
    }
}
