package com.gerskom;

public class ImageOperation {
    public final ImageData imageData;

    ImageOperation(ImageData id) {
        this.imageData = id;
    }

    void binarization(int th) {
        for(int x = 0; x < imageData.width; x++){
            for(int y = 0; y < imageData.height; y++){
                if(imageData.dataTable[x][y] < th || imageData.dataTable[x][y] >= 253)
                    imageData.dataTable[x][y] = 0;
                else
                    imageData.dataTable[x][y] = 255;
            }
        }
    }
}
