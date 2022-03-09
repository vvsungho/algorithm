package doit.excercise.chap02;

public class PrimeNumber1 {

    public static void main(String[] args) {
        solution();
    }

    // 1000까지 소수 구하기.
    public static void solution() {

        int 효율성체크 = 0;

        for (int i = 2; i <= 1000; i++) {
            int j;
            for (j = 2; j < i; j++) {
                효율성체크++;
                if (i % j == 0) break;
            }
            if (i == j) System.out.println(i);
        }
        System.out.println("효율성체크: " + 효율성체크);

    }

}
