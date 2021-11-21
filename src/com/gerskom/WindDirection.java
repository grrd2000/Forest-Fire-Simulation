package com.gerskom;

public enum WindDirection {
     E, SE, S, SW, W, NW, N, NE;

    public static WindDirection fromInteger(int i) {
        return switch (i) {
            case 1 -> W;
            case 2 -> NW;
            case 3 -> N;
            case 4 -> NE;
            case 5 -> E;
            case 6 -> SE;
            case 7 -> S;
            case 8 -> SW;
            default -> throw new IllegalStateException("Unexpected value: " + i);
        };
    }

    public int directionToInt (String dirString) {
        return switch (dirString) {
            case "W"  -> 1;
            case "NW" -> 2;
            case "N"  -> 3;
            case "NE" -> 4;
            case "E"  -> 5;
            case "SE" -> 6;
            case "S"  -> 7;
            case "SW" -> 8;
            default -> throw new IllegalStateException("Unexpected value: " + dirString);
        };
    }
}
