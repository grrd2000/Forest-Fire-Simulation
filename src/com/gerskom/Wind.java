package com.gerskom;

import java.util.Random;

public class Wind {
    public float[][] windEffect;
    public int direction;
    public String dirString;

    private final float MAIN = 18;
    private final float nextToMain = MAIN / 2;
    private final float ninetyToMain = 0;

    Wind() {
        Random random = new Random();
        direction = random.nextInt(7) + 1;

        switch (direction) {
            case 1 -> windEffect = new float[][] {  {-nextToMain,   ninetyToMain,   nextToMain},
                                                    {-MAIN,         0,              MAIN},
                                                    {-nextToMain,   ninetyToMain,   nextToMain}};

            case 2 -> windEffect = new float[][] {  {-MAIN,         -nextToMain,    ninetyToMain},
                                                    {-nextToMain,   0,              nextToMain},
                                                    {ninetyToMain,  nextToMain,     MAIN}};

            case 3 -> windEffect = new float[][] {  {-nextToMain,   -MAIN,      -nextToMain},
                                                    {ninetyToMain,  0,          ninetyToMain},
                                                    {nextToMain,    MAIN,       nextToMain}};

            case 4 -> windEffect = new float[][] {  {ninetyToMain,  -nextToMain,    -MAIN},
                                                    {nextToMain,    0,              -nextToMain},
                                                    {MAIN,          nextToMain,     ninetyToMain}};

            case 5 -> windEffect = new float[][] {  {nextToMain,    ninetyToMain,   -nextToMain},
                                                    {MAIN,          0,              -MAIN},
                                                    {nextToMain,    ninetyToMain,   -nextToMain}};

            case 6 -> windEffect = new float[][] {  {MAIN,          nextToMain,     ninetyToMain},
                                                    {nextToMain,    0,              -nextToMain},
                                                    {ninetyToMain,  -nextToMain,    -MAIN}};

            case 7 -> windEffect = new float[][] {  {nextToMain,    MAIN,       nextToMain},
                                                    {ninetyToMain,  0,          ninetyToMain},
                                                    {-nextToMain,   -MAIN,      -nextToMain}};

            case 8 -> windEffect = new float[][] {  {ninetyToMain,  nextToMain,     MAIN},
                                                    {-nextToMain,   0,              nextToMain},
                                                    {-MAIN,         -nextToMain,    ninetyToMain}};
        }
    }
    Wind(String dirString) {
        this.dirString = dirString;

        switch (dirString) {
            case "W" -> windEffect = new float[][] {    {-nextToMain,   ninetyToMain,   nextToMain},
                                                        {-MAIN,         0,              MAIN},
                                                        {-nextToMain,   ninetyToMain,   nextToMain}};

            case "NW" -> windEffect = new float[][] {   {-MAIN,         -nextToMain,    ninetyToMain},
                                                        {-nextToMain,   0,              nextToMain},
                                                        {ninetyToMain,  nextToMain,     MAIN}};

            case "N" -> windEffect = new float[][] {    {-nextToMain,   -MAIN,      -nextToMain},
                                                        {ninetyToMain,  0,          ninetyToMain},
                                                        {nextToMain,    MAIN,       nextToMain}};

            case "NE" -> windEffect = new float[][] {   {ninetyToMain,  -nextToMain,    -MAIN},
                                                        {nextToMain,    0,              -nextToMain},
                                                        {MAIN,          nextToMain,     ninetyToMain}};

            case "E" -> windEffect = new float[][] {    {nextToMain,    ninetyToMain,   -nextToMain},
                                                        {MAIN,          0,              -MAIN},
                                                        {nextToMain,    ninetyToMain,   -nextToMain}};

            case "SE" -> windEffect = new float[][] {   {MAIN,          nextToMain,     ninetyToMain},
                                                        {nextToMain,    0,              -nextToMain},
                                                        {ninetyToMain,  -nextToMain,    -MAIN}};

            case "S" -> windEffect = new float[][] {    {nextToMain,    MAIN,       nextToMain},
                                                        {ninetyToMain,  0,          ninetyToMain},
                                                        {-nextToMain,   -MAIN,      -nextToMain}};

            case "SW" -> windEffect = new float[][] {   {ninetyToMain,  nextToMain,     MAIN},
                                                        {-nextToMain,   0,              nextToMain},
                                                        {-MAIN,         -nextToMain,    ninetyToMain}};
        }
    }
}
