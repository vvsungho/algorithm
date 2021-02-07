package doit.chap1;

public class Q16 {
    public static void main(String[] args) {
        int num = 4;
        int num2 = 7;
        int subtract = num2 - num;

        for (int i = 0; i < 4; i++) {
            int max = subtract + (i * 2);
            for (int j = 0; j < 7; j++) {
                int sum = i + j;
                if (subtract <= sum && max >= sum) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }
}
