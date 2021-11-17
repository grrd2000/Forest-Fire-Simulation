package com.gerskom;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageData {
    public final int width;
    public final int height;
    public int[][] dataTable;

    ImageData(String path) throws IOException {
        BufferedImage image = ImageIO.read(new File(path));
        this.width = image.getWidth();
        this.height = image.getHeight();
        this.dataTable = new int[width][height];

        for (int x = 0; x < width; x++) {
            for(int y = 0; y < height; y ++) {
                Color tmpColor = new Color(image.getRGB(x, y), false);
                if(tmpColor.getRed() == tmpColor.getBlue() && tmpColor.getRed() == tmpColor.getGreen() && tmpColor.getGreen() == tmpColor.getBlue())
                    this.dataTable[x][y] = tmpColor.getRed();
                else System.err.println("Image is not black and white!");
            }
        }
    }
}
