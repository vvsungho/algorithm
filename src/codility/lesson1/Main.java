package codility.lesson1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();
        System.out.println("Answer: " + main.solution(scanner.nextInt()));
    }

    public int solution(int number) {
        String binaryNumber = Integer.toBinaryString(number);
        System.out.println("10진수: " + number + ", 2진수: " + binaryNumber);
        int char1Count = 0;
        int char0Count = 0;
        int maxChar0Count = 0;


        for (int i = 0; i < binaryNumber.length(); i++) {
            char c = binaryNumber.charAt(i);
            if (c == '0') {
                char0Count++;

            } else {
                char1Count++;
                if (char0Count > maxChar0Count) {
                    maxChar0Count = char0Count;
                    char0Count = 0;
                }
            }
        }

        if (char1Count < 2) { // 100, 1000, 10000 -> no binary gap
            return 0;
        }
        return maxChar0Count;
    }

}
