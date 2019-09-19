package com.playground.practice.codility.workday;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import com.sun.org.apache.xpath.internal.SourceTree;

public class SolutionWorkday {

    // Direction map to deduce the next direction after making a turn
    private static final Map<String, String> directionsMap = new HashMap<>();

    static {
        directionsMap.put("nr", "e");
        directionsMap.put("nl", "w");
        directionsMap.put("er", "s");
        directionsMap.put("el", "n");
        directionsMap.put("wr", "n");
        directionsMap.put("wl", "s");
        directionsMap.put("sr", "w");
        directionsMap.put("sl", "e");
    }

    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        String[] tokens = in.nextLine().split(" ");

        /* Enter your code here. */
        String direction = "n"; // Default direction is North
        int currentX = 0;
        int currentY = 0;
        Location location = followTheInstructions(tokens, direction, currentX, currentY);
        System.out.println(location.getX() + ", " + location.getY());
    }

    private static Location followTheInstructions(String[] tokens, String direction, int currentX, int currentY) {
        Location location = new Location(currentX, currentY);

        for (String token : tokens) {
            // The token should have either direction to turn or a number of space to move
            // in the current direction
            if (isValidDir(token)) {
                // Turn instruction
                direction = directionsMap.get(direction + token);
            } else {
                try {
                    // Move instruction
                    int spaces = Integer.valueOf(token).intValue();

                    // Follow the instruction
                    moveSpaces(location, direction, spaces);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    System.out.println("Invalid input token=" + token);
                    break;
                }
            }
        }

        return location;
    }

    private static boolean isValidDir(String token) {
        return "r".equals(token) || "l".equals(token);
    }

    private static void moveSpaces(Location location, String direction, int spaces) {
        switch (direction) {
            case "e":
                location.moveEast(spaces);
                break;
            case "w":
                location.moveWest(spaces);
                break;
            case "n":
                location.moveNorth(spaces);
                break;
            case "s":
                location.moveSouth(spaces);
                break;
            default:
                System.out.println("Invalid instruction");
        }
    }

    private static class Location {
        private int x;
        private int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }

        public void moveEast(int spaces) {
            this.x += spaces;
        }

        public void moveWest(int spaces) {
            this.x -= spaces;
        }

        public void moveNorth(int spaces) {
            this.y += spaces;
        }

        public void moveSouth(int spaces) {
            this.y -= spaces;
        }
    }
}


