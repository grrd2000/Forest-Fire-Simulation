package com.gerskom;

import java.awt.event.*;
import java.io.IOException;

public class MainInputHandler implements KeyListener, MouseListener, MouseMotionListener {
    SimulationPanel simulationPanel;
    private static int mouseButton = -1;

    private final float fireBrushSize = 20f;
    private final float treesBrushSize = 70f;

    public MainInputHandler(SimulationPanel simulationPanel) {
        this.simulationPanel = simulationPanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        switch (e.getKeyChar()) {
            case '\n' -> {
                if (!simulationPanel.started) {
                    System.out.println("START");
                    simulationPanel.startTheFire();
                }
            }
            case 'r' -> {
                simulationPanel.map.addInitialRandomTrees();
                simulationPanel.repaint();
                //System.out.println("NEW RANDOM TREES!");
            }
            case 'f' -> {
                try {
                    simulationPanel.exportImage("forest_fire");
                    System.out.println("FRAME EXPORTED");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }


    @Override
    public void mousePressed(MouseEvent e) {
        int x = simulationPanel.getMousePosition().x;
        int y = simulationPanel.getMousePosition().y;

        switch (e.getButton()) {
            case 1 -> {
                mouseButton = 1;
                simulationPanel.map.addBrushOfFire(x, y, fireBrushSize);
            }
            case 2 -> {
                mouseButton = 2;
                simulationPanel.map.addTree(x, y);
            }
            case 3 -> {
                mouseButton = 3;
                simulationPanel.map.addBrushOfTrees(x, y, treesBrushSize);
            }
        }
        simulationPanel.map.dataCopier();
        simulationPanel.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int x = simulationPanel.getMousePosition().x;
        int y = simulationPanel.getMousePosition().y;

        switch (mouseButton) {
            case 1 -> simulationPanel.map.addBrushOfFire(x, y, fireBrushSize);
            case 2 -> simulationPanel.map.addTree(x, y);
            case 3 -> simulationPanel.map.addBrushOfTrees(x, y, treesBrushSize);
        }
        simulationPanel.map.dataCopier();
        simulationPanel.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}
