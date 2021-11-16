package com.gerskom;

import java.io.IOException;

public class ForestFire {

    public ForestFire() {
        new InitialFrame();
    }

    public ForestFire(String path) throws IOException {
        ImageOperation io = new ImageOperation(new ImageData(path));
        io.binarization(200);
        io.dilatation();

        new MainFrame(new Grid(io.imageData, 30000));
    }
}
