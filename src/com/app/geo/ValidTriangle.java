package com.app.geo;

public class ValidTriangle {

    public static double distanceBetweenTwoPoints(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static boolean isValidTriangle(double ab, double bc, double ac) {
        return (ab + bc) > ac && (bc + ac) > ab && (ab + ac) > bc;
    }

    public static double area(int x1, int y1, int x2, int y2, int x3, int y3) {
        return Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0;
    }

    public static int pointsBelong(int x1, int y1, int x2, int y2, int x3, int y3, int xp, int yp, int xq, int yq) {
        // Write your code here
        double ab = distanceBetweenTwoPoints(x1, y1, x2, y2);
        double bc = distanceBetweenTwoPoints(x2, y2, x3, y3);
        double ac = distanceBetweenTwoPoints(x1, y1, x3, y3);

        if (isValidTriangle(ab, bc, ac)) {
            double area = area(x1, y1, x2, y2, x3, y3);
            double pa = area(xp, yp, x2, y2, x3, y3);
            double pb = area(x1, y1, xp, yp, x3, y3);
            double pc = area(x1, y1, x2, y2, xp, yp);

            double qa = area(xq, yq, x2, y2, x3, y3);
            double qb = area(x1, y1, xq, yq, x3, y3);
            double qc = area(x1, y1, x2, y2, xq, yq);
            double area1 = pa + pb + pc;
            double area2 = qa + qb + qc;
            if (area != area1 && area != area2) {
                return 4;
            }
            if (area == area1) {
                if (area == area2) {
                    return 3;
                }
                return 1;
            } else {
                return 2;
            }

        } else {
            return 0;
        }

    }


    public static void main(String[] args) {
        int i = pointsBelong(0, 0, 2, 0, 4, 0, 2, 0, 4, 0);
        System.out.println("i = " + i);
    }


}