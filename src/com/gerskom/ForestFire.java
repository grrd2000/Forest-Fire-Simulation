package com.gerskom;

import java.io.IOException;

public class ForestFire {

    public ForestFire() {
        new InitialFrame();
    }

    public ForestFire(String path) throws IOException {
        new ImageOperation(new ImageData(path)).binarization(200);
    }
}
