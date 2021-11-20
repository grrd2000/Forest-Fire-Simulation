package com.gerskom;

import java.text.DecimalFormat;
import java.util.Random;

public class Wind {
    public float[][] windEffect;
    public int direction;
    public String dirString;
    private final float windPower;

    private final float MAIN;
    private final float nextToMain;
    private final float nMAIN;
    private final float nNextToMain;
    private final float ninetyToMain;

    Wind() {
        Random random = new Random();
        this.direction = random.nextInt(7) + 1;
        this.windPower = random.nextFloat() * 2.8f + 2.2f;

        MAIN = windPower;
        nextToMain = windPower / 5f;
        nMAIN = -windPower * 7.5f;
        nNextToMain = -windPower * 2f;
        ninetyToMain = -windPower;

        switch (direction) {
            case 1 -> windEffect = new float[][] {  {nNextToMain,   ninetyToMain,   nextToMain},
                                                    {nMAIN,         0,              MAIN},
                                                    {nNextToMain,   ninetyToMain,   nextToMain}};

            case 2 -> windEffect = new float[][] {  {nMAIN,         nNextToMain,   ninetyToMain},
                                                    {nNextToMain,   0,              nextToMain},
                                                    {ninetyToMain,   nextToMain,     MAIN}};

            case 3 -> windEffect = new float[][] {  {nNextToMain,   nMAIN,      nNextToMain},
                                                    {ninetyToMain,   0,           ninetyToMain},
                                                    {nextToMain,     MAIN,        nextToMain}};

            case 4 -> windEffect = new float[][] {  {ninetyToMain,  nNextToMain,    nMAIN},
                                                    {nextToMain,    0,               nNextToMain},
                                                    {MAIN,          nextToMain,      ninetyToMain}};

            case 5 -> windEffect = new float[][] {  {nextToMain,    ninetyToMain,   nNextToMain},
                                                    {MAIN,          0,              nMAIN},
                                                    {nextToMain,    ninetyToMain,   nNextToMain}};

            case 6 -> windEffect = new float[][] {  {MAIN,          nextToMain,      ninetyToMain},
                                                    {nextToMain,    0,               nNextToMain},
                                                    {ninetyToMain,  nNextToMain,    nMAIN}};

            case 7 -> windEffect = new float[][] {  {nextToMain,     MAIN,        nextToMain},
                                                    {ninetyToMain,   0,           ninetyToMain},
                                                    {nNextToMain,   nMAIN,      nNextToMain}};

            case 8 -> windEffect = new float[][] {  {ninetyToMain,   nextToMain,      MAIN},
                                                    {nNextToMain,   0,               nextToMain},
                                                    {nMAIN,         nNextToMain,    ninetyToMain}};

            default -> throw new IllegalStateException("Unexpected value: " + direction);
        }

        printWind(direction, windPower);
    }
    Wind(String dirString) {
        this.dirString = dirString;

        Random random = new Random();
        this.windPower = random.nextFloat() * 2.8f + 2.2f;

        MAIN = windPower;
        nextToMain = windPower / 5f;
        nMAIN = -windPower * 7.5f;
        nNextToMain = -windPower * 2f;
        ninetyToMain = -windPower;

        //windEffect = new float[][] {    {nextToMain,    ninetyToMain,   nNextToMain},         //w dół
        //        {MAIN,          0,              nMAIN},
        //        {nextToMain,    ninetyToMain,   nNextToMain}};

        //windEffect = new float[][] {    {nextToMain,    MAIN,   nextToMain},                  //w prawo
        //         {ninetyToMain,          0,              ninetyToMain},
        //         {nNextToMain,    nMAIN,   nNextToMain}};

        //windEffect = new float[][] {    {nNextToMain,   ninetyToMain,   nextToMain},            //w góre
        //        {nMAIN,         0,              MAIN},
        //        {nNextToMain,   ninetyToMain,   nextToMain}};

        //windEffect = new float[][] {    {nNextToMain,   nMAIN,      nNextToMain},               //w lewo
        //        {ninetyToMain,   0,           ninetyToMain},
        //        {nextToMain,     MAIN,        nextToMain}};

        //System.out.println(MAIN);
        //System.out.println(windEffect[1][0]);
        //System.out.println(Arrays.deepToString(windEffect));

        switch (dirString) {
            case "E" -> windEffect = new float[][] {    {nNextToMain,   ninetyToMain,   nextToMain},
                                                        {nMAIN,         0,              MAIN},
                                                        {nNextToMain,   ninetyToMain,   nextToMain}};

            case "SE" -> windEffect = new float[][] {   {nMAIN,        nNextToMain,    ninetyToMain},
                                                        {nNextToMain,   0,              nextToMain},
                                                        {ninetyToMain,   nextToMain,     MAIN}};

            case "S" -> windEffect = new float[][] {    {nNextToMain,   nMAIN,      nNextToMain},
                                                        {ninetyToMain,   0,           ninetyToMain},
                                                        {nextToMain,     MAIN,        nextToMain}};

            case "SW" -> windEffect = new float[][] {   {ninetyToMain,  nNextToMain,    nMAIN},
                                                        {nextToMain,    0,               nNextToMain},
                                                        {MAIN,          nextToMain,      ninetyToMain}};

            case "W" -> windEffect = new float[][] {    {nextToMain,    ninetyToMain,   nNextToMain},
                                                        {MAIN,          0,              nMAIN},
                                                        {nextToMain,    ninetyToMain,   nNextToMain}};

            case "NW" -> windEffect = new float[][] {   {MAIN,          nextToMain,      ninetyToMain},
                                                        {nextToMain,    0,               nNextToMain},
                                                        {ninetyToMain,  nNextToMain,    nMAIN}};

            case "N" -> windEffect = new float[][] {    {nextToMain,     MAIN,       nextToMain},
                                                        {ninetyToMain,   0,          ninetyToMain},
                                                        {nNextToMain,   nMAIN,     nNextToMain}};

            case "NE" -> windEffect = new float[][] {   {ninetyToMain,   nextToMain,      MAIN},
                                                        {nNextToMain,   0,               nextToMain},
                                                        {nMAIN,         nNextToMain,    ninetyToMain}};

            default -> throw new IllegalStateException("Unexpected value: " + dirString);
        }

        //for (int i = -1; i <= 1; i++)
        //    for (int j = -1; j <= 1; j++)
        //        System.out.println(windEffect[i + 1][j + 1]);

        printWind(dirString, windPower);
    }

    public void printWind(int dir, float windPower) {
        System.out.println("\nToday's wind data:\nWind direction: " + WindDirection.fromInteger(dir) +
                "\nSpeed: " + new DecimalFormat("##.##").format(windPower) + "km/h\n");
    }

    public void printWind(String dirString, float windPower) {
        System.out.println("\nToday's wind data:\nWind direction: " + dirString +
                "\nSpeed: " + new DecimalFormat("##.##").format(windPower) + " km/h\n");
    }
}
