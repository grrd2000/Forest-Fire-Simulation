package com.gerskom;

import java.util.Random;

public class Wind {
    public float[][] windEffect;
    public int direction;
    public String dirString;

    private final float MAIN = 1.25f;
    private final float nextToMain = MAIN / 5f;
    private final float nMAIN = -MAIN * 10f;
    private final float nNextToMain = nMAIN / 5f;
    private final float ninetyToMain = MAIN / 25f;

    Wind() {
        Random random = new Random();
        direction = random.nextInt(7) + 1;

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
        }
    }
    Wind(String dirString) {
        this.dirString = dirString;

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
        }
    }
}
