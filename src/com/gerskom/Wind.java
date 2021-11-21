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
        this.windPower = random.nextFloat() * 5f + 0.5f;

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
        this.windPower = random.nextFloat() * 5f + 0.5f;

        MAIN = windPower;
        nextToMain = windPower / 5f;
        nMAIN = -windPower * 7.5f;
        nNextToMain = -windPower * 2f;
        ninetyToMain = -windPower;

        switch (dirString) {
            case "W" -> windEffect = new float[][] {    {nNextToMain,   ninetyToMain,   nextToMain},
                                                        {nMAIN,         0,              MAIN},
                                                        {nNextToMain,   ninetyToMain,   nextToMain}};

            case "NW" -> windEffect = new float[][] {   {nMAIN,        nNextToMain,    ninetyToMain},
                                                        {nNextToMain,   0,              nextToMain},
                                                        {ninetyToMain,   nextToMain,     MAIN}};

            case "N" -> windEffect = new float[][] {    {nNextToMain,   nMAIN,      nNextToMain},
                                                        {ninetyToMain,   0,           ninetyToMain},
                                                        {nextToMain,     MAIN,        nextToMain}};

            case "NE" -> windEffect = new float[][] {   {ninetyToMain,  nNextToMain,    nMAIN},
                                                        {nextToMain,    0,               nNextToMain},
                                                        {MAIN,          nextToMain,      ninetyToMain}};

            case "E" -> windEffect = new float[][] {    {nextToMain,    ninetyToMain,   nNextToMain},
                                                        {MAIN,          0,              nMAIN},
                                                        {nextToMain,    ninetyToMain,   nNextToMain}};

            case "SE" -> windEffect = new float[][] {   {MAIN,          nextToMain,      ninetyToMain},
                                                        {nextToMain,    0,               nNextToMain},
                                                        {ninetyToMain,  nNextToMain,    nMAIN}};

            case "S" -> windEffect = new float[][] {    {nextToMain,     MAIN,       nextToMain},
                                                        {ninetyToMain,   0,          ninetyToMain},
                                                        {nNextToMain,   nMAIN,     nNextToMain}};

            case "SW" -> windEffect = new float[][] {   {ninetyToMain,   nextToMain,      MAIN},
                                                        {nNextToMain,   0,               nextToMain},
                                                        {nMAIN,         nNextToMain,    ninetyToMain}};

            default -> throw new IllegalStateException("Unexpected value: " + dirString);
        }

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
