package com.gerskom;

public enum WindDirection {
     E, SE, S, SW, W, NW, N, NE;

    public static WindDirection fromInteger(int i) {
        return switch (i) {
            case 1 -> E;
            case 2 -> SE;
            case 3 -> S;
            case 4 -> SW;
            case 5 -> W;
            case 6 -> NW;
            case 7 -> N;
            case 8 -> NE;
            default -> throw new IllegalStateException("Unexpected value: " + i);
        };
    }

    public int directionToInt (String dirString) {
        return switch (dirString) {
            case "E"  -> 1;
            case "SE" -> 2;
            case "S"  -> 3;
            case "SW" -> 4;
            case "W"  -> 5;
            case "NW" -> 6;
            case "N"  -> 7;
            case "NE" -> 8;
            default -> throw new IllegalStateException("Unexpected value: " + dirString);
        };
    }
}
