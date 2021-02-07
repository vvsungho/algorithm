package doit.chap1;

public class Median {

    public static void main(String[] args) {

    }

    public static int getResult(int a, int b, int c) {

        if (a >= b) {
            if (b >= c) {
                return b;
            } else if (a <= c) {
                return a;
            } else {
                return c;
            }
        } else if (a > c) {
            return a;
        } else if (b > c) {
            return c;
        } else {
            return b;
        }
    }

}
