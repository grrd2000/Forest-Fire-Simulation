package com.gerskom;

import java.io.IOException;
import java.util.Arrays;

public class ForestFire {

    public ForestFire() {
        new InitialFrame();
    }

    public ForestFire(String path) throws IOException {
        ImageOperation io = new ImageOperation(new ImageData(path));
        io.binarization(200);

        //new Grid(io.imageData, 30000).exportImage("test");
        new MainFrame(new Grid(io.imageData, 30000));
    }
}
