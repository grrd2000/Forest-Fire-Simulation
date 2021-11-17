package com.gerskom;

import java.io.IOException;
import java.util.Random;

public class Grid {
    public int width;
    public int height;
    public int nMax;
    public int[][] table;
    private final int[][] tmpTable;
    public final int[][] imageTable;
    public int[][] inputImageTable;

    public int i = 0;

    public static int tree = -1;
    public static int fire = -2;
    public static int burnt = -3;
    public static int grass = 255;

    private final float fireBrushSpeed = 6.5f;
    private final float treesBrushSpeed = 14f;

    private final double fireP = 22.5;
    private final double grassFireP = 14;         //17.5
    private final double randomFireP = 0.000001;
    private final double resurrectionP = 0.001;
    private final double burntP = 10;

    public Grid(int width, int height, int nMax) {
        this.width = width;
        this.height = height;
        this.nMax = nMax;
        this.table = new int[width][height];
        for (int x = 0; x < width; x++)
            for (int y = 0; y < height; y++)
                this.table[x][y] = burnt;
        this.tmpTable = new int[width][height];
        this.imageTable = new int[width][height];
        for (int x = 0; x < width; x++)
            for (int y = 0; y < height; y++)
                this.imageTable[x][y] = burnt;
        this.inputImageTable = new int[width][height];
        dataCopier();
    }

    public Grid(ImageData id, int nMax) throws IOException {
        this.width = id.width;
        this.height = id.height;
        this.nMax = nMax;
        this.table = new int[width][height];
        this.tmpTable = new int[width][height];
        this.imageTable = new int[width][height];
        this.inputImageTable = new int[width][height];
        backgroundImage();
        importImageData(id);
        dataCopier();
    }

    public void startSimulation() {
        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
                if(imageTable[x][y] != 0) {
                    Random random = new Random();
                    double r = random.nextDouble() * 100;

                    if ((tmpTable[x][y] == burnt || imageTable[x][y] == grass) && resurrectionP >= r)
                        addTree(x, y);
                    else if (tmpTable[x][y] == tree && neighbourTreesFireScan(x, y) >= r)
                        addFire(x, y);
                    else if (tmpTable[x][y] == fire && burntP >= r)
                        table[x][y] = burnt;
                    else if (imageTable[x][y] == grass && neighbourFireScan(x, y) >= r)
                        addFire(x, y);
                }
            }
        }
        i++;
        dataCopier();
    }

    double neighbourTreesFireScan(int w, int h) {
        int treesOnFire = 0;

        if (w != 0 && w != width - 1 && h != 0 && h != height - 1) {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (!(i == 0 && j == 0)) {
                        if (tmpTable[w + i][h + j] == fire) {
                            treesOnFire++;
                        }
                    }
                }
            }
        }
        else if (w == 0 && (h != 0 && h != height - 1)) {
            for (int i = 0; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (!(i == 0 && j == 0)) {
                        if (tmpTable[w + i][h + j] == fire) {
                            treesOnFire++;
                        }
                    }
                }
            }
        }
        else if (w == width - 1 && (h != 0 && h != height - 1)) {
            for (int i = -1; i <= 0; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (!(i == 0 && j == 0)) {
                        if (tmpTable[w + i][h + j] == fire) {
                            treesOnFire++;
                        }
                    }
                }
            }
        }
        else if (h == 0 && (w != 0 && w != width - 1)) {
            for (int i = -1; i <= 1; i++) {
                for (int j = 0; j <= 1; j++) {
                    if (!(i == 0 && j == 0)) {
                        if (tmpTable[w + i][h + j] == fire) {
                            treesOnFire++;
                        }
                    }
                }
            }
        }
        else if (h == height - 1 && (w != 0 && w != width - 1)) {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 0; j++) {
                    if (!(i == 0 && j == 0)) {
                        if (tmpTable[w + i][h + j] == fire) {
                            treesOnFire++;
                        }
                    }
                }
            }
        }
        if (treesOnFire == 0) return randomFireP;
        else return treesOnFire * fireP;
    }

    double neighbourFireScan(int w, int h) {
        int onFire = 0;

        if (w != 0 && w != width - 1 && h != 0 && h != height - 1) {
            for (int i = -1; i <= 1; i++)
                for (int j = -1; j <= 1; j++)
                    if (!(i == 0 && j == 0))
                        if (tmpTable[w + i][h + j] == fire)
                            onFire++;
        }
        else if (w == 0 && (h != 0 && h != height - 1)) {
            for (int i = 0; i <= 1; i++)
                for (int j = -1; j <= 1; j++)
                    if (!(i == 0 && j == 0))
                        if (tmpTable[w + i][h + j] == fire)
                            onFire++;
        }
        else if (w == width - 1 && (h != 0 && h != height - 1)) {
            for (int i = -1; i <= 0; i++)
                for (int j = -1; j <= 1; j++)
                    if (!(i == 0 && j == 0))
                        if (tmpTable[w + i][h + j] == fire)
                            onFire++;
        }
        else if (h == 0 && (w != 0 && w != width - 1)) {
            for (int i = -1; i <= 1; i++)
                for (int j = 0; j <= 1; j++)
                    if (!(i == 0 && j == 0))
                        if (tmpTable[w + i][h + j] == fire)
                            onFire++;
        }
        else if (h == height - 1 && (w != 0 && w != width - 1)) {
            for (int i = -1; i <= 1; i++)
                for (int j = -1; j <= 0; j++)
                    if (!(i == 0 && j == 0))
                        if (tmpTable[w + i][h + j] == fire)
                            onFire++;
        }
        return onFire * grassFireP;
    }

    public void dataCopier() {
        for(int x = 0; x < width; x++)
            if (height >= 0) System.arraycopy(table[x], 0, this.tmpTable[x], 0, height);
    }

    public void addTree(int xCor, int yCor) {
        if(imageTable[xCor][yCor] != 0) {
            this.table[xCor][yCor] = tree;
            this.imageTable[xCor][yCor] = -1;
        }
    }

    public void addFire(int xCor, int yCor) {
        if(imageTable[xCor][yCor] != 0) {
            this.table[xCor][yCor] = fire;
            this.imageTable[xCor][yCor] = -1;
        }
    }

    public void addBrushOfTrees(int xCor, int yCor, float size) {
        for (double r = 4; r <= size / 2; r += 1.5) {
            for (double a = 0; a < 2 * Math.PI; a += 0.05) {
                Random random = new Random();
                float rand = 100 * random.nextFloat();

                int x = (int)(r * Math.cos(a));
                int y = (int)(r * Math.sin(a));

                if (treesBrushSpeed >= rand)
                    if ((x + xCor) >= 0 && (x + xCor) <= width && (y + yCor) >= 0 && (y + yCor) <= height)
                        addTree(x + xCor, y + yCor);
            }
        }
    }

    public void addBrushOfFire(int xCor, int yCor, float size) {
        for (double r = 3; r <= size / 2; r += 1.5) {
            for (double a = 0; a < 2 * Math.PI; a += 0.05) {
                Random random = new Random();
                float rand = 100 * random.nextFloat();

                int x = (int)(r * Math.cos(a));
                int y = (int)(r * Math.sin(a));

                if (fireBrushSpeed >= rand)
                    if ((x + xCor) >= 0 && (x + xCor) <= width && (y + yCor) >= 0 && (y + yCor) <= height)
                        addFire(x + xCor, y + yCor);
            }
        }
    }

    public void addInitialRandomTrees() {
        for(int c = 0; c < nMax; c++) {
            Random ran = new Random();
            int x = ran.nextInt(width);
            int y = ran.nextInt(height);
            addTree(x, y);
        }
    }

    private void importImageData(ImageData id) {
        for (int x = 0; x < width; x++)
            if (height >= 0) System.arraycopy(id.dataTable[x], 0, this.imageTable[x], 0, height);
    }

    private void backgroundImage() throws IOException {
        ImageData bg = new ImageData("input/input_map.bmp");
        this.inputImageTable = bg.dataTable;
    }
}