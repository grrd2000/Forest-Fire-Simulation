package com.gerskom;

import java.util.Random;

public class Wind {
    public float[][] windEffect;

    Wind() {
        Random random = new Random();
        int direction = random.nextInt(7) + 1;

        switch (direction) {
            case 1 -> windEffect = new float[][] {{-5, 0, 5},
                                                {-7.5f, 0, 7.5f},
                                                {-5, 0, 5}};
            case 2 -> windEffect = new float[][] {{-7.5f, -6, 0},
                                                {-6f, 0, 4f},
                                                {0, 4, 7.5f}};
            case 3 -> windEffect = new float[][] {{-5, -7.5f, -5},
                                                {0, 0, 0},
                                                {5, 7.5f, 5}};
            case 4 -> windEffect = new float[][] {{0, -6, -7.5f},
                                                {4, 0, -6},
                                                {7.5f, 4, 0}};
            case 5 -> windEffect = new float[][] {{5, 0, -5},
                                                {7.5f, 0, -7.5f},
                                                {5, 0, -5}};
            case 6 -> windEffect = new float[][] {{7.5f, 4, 0},
                                                {4, 0, -6},
                                                {0, -6, -7.5f}};
            case 7 -> windEffect = new float[][] {{5, 7.5f, 5},
                                                {0, 0, 0},
                                                {-5, -7.5f, -5}};
            case 8 -> windEffect = new float[][] {{0, 4, 7.5f},
                                                {-6, 0, 4},
                                                {-7.5f, -6, 0}};
        }
    }
}
