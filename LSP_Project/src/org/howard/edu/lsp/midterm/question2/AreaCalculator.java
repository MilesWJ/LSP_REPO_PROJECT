package org.howard.edu.lsp.midterm.question2;

public class AreaCalculator {

    public static double area(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("radius must be greater than zero.");
        }
        return Math.PI * Math.pow(radius, 2);
    }

    public static double area(double width, double height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("width and height must be greater than zero.");
        }
        return width * height;
    }

    public static double area(int base, int height) {
        if (base <= 0 || height <= 0) {
            throw new IllegalArgumentException("base and height must be greater than zero.");
        }
        return 0.5 * base * height;
    }

    public static double area(int side) {
        if (side <= 0) {
            throw new IllegalArgumentException("side must be greater than zero.");
        }
        return Math.pow(side, 2);
    }
}
