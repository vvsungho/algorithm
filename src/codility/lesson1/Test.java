package codility.lesson1;

import java.util.Scanner;

public class Test {

    /**
     * https://app.codility.com/programmers/lessons/1-iterations/binary_gap/
     * 변환된 2진수에서 가장 긴 Binary Gap 출력
     * ex)
     * 10진수 1041 = 2진수 10000010001. 각각 1과 1 사이 5, 3 만큼 0이 있음. 해당 경우 5 출력.
     * For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5. Given N = 32 the function should return 0, because N has binary representation '100000' and thus no binary gaps.
     * @param args
     */

    public static void main(String[] args) {
//        System.out.println("abc".substring(0,1));
        Test test = new Test();
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        System.out.println("answer" + test.solution(number));
    }

    public int solution(int number) {
        String binaryNumber = Integer.toBinaryString(number);
        System.out.println("2진수: " + binaryNumber);

        int maxLength = 0;
        String checkBinaryString = binaryNumber;

        while (checkBinaryString.length() > 1) {
            int stopIndex = 0;
            for (int i = 0; i < checkBinaryString.length(); i++) {
                if (i == 0) {
                    continue;
                }
                if (checkBinaryString.charAt(i) == '1') {
                    stopIndex = i;
                    break;
                }
            }

            System.out.println("stopIndex: " + stopIndex);
            System.out.println("checkBinaryString: " + checkBinaryString);
            System.out.println("checkBinaryString.length(): " + checkBinaryString.length());
            System.out.println("checkBinaryString.substring(0, stopIndex): " + checkBinaryString.substring(0, stopIndex));

            if (checkBinaryString.substring(0, stopIndex).length() - 1 > maxLength) {
                maxLength = checkBinaryString.substring(0, stopIndex).length() - 1;
            }

            checkBinaryString = checkBinaryString.substring(stopIndex);
            System.out.println();
        }

        return maxLength;
    }

}
