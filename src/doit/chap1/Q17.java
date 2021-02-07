package doit.chap1;

public class Q17 {

    public static void main(String[] args) {

        int num = 4;

        for (int i = 1; i <= num; i++) {
            for (int j1 = 1; j1 <= num - i; j1++) {
                System.out.print(" ");
            }
            for (int j2 = 1; j2 <= (i -1) * 2 + 1; j2++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

}
