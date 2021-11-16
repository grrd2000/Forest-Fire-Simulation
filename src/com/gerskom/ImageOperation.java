package com.gerskom;

import java.awt.*;

public class ImageOperation {
    public final ImageData imageData;

    ImageOperation(ImageData id) {
        this.imageData = id;
    }

    void binarization(int th) {
        for(int x = 0; x < imageData.width; x++){
            for(int y = 0; y < imageData.height; y++){
                if(imageData.dataTable[x][y] < th || imageData.dataTable[x][y] == 255)
                    imageData.dataTable[x][y] = 0;
                else
                    imageData.dataTable[x][y] = 255;
            }
        }
    }

    void dilatation() {
        int[][] tmpData = new int[imageData.width][imageData.height];
        for(int x = 0;x < imageData.width; x++) {
            System.arraycopy(imageData.dataTable[x], 0, tmpData[x], 0, imageData.height);
        }
        boolean done;
        for(int x = 1; x < imageData.width - 1; x++){
            for(int y = 1; y < imageData.height - 1; y++){
                if(tmpData[x][y] == 255) {
                    done = false;
                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            if (!(i == 0 && j == 0)) {
                                if (tmpData[x + i][y + j] == 0) {
                                    imageData.dataTable[x][y] = 0;
                                    done = true;
                                    break;
                                }
                            }
                        }
                        if (done) break;
                    }
                }
            }
        }
    }
}
