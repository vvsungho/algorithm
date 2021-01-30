package programmers;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12928
 * 약수의 합
 */
public class P12928 {

    public static void main(String[] args) {
        P12928 p = new P12928();
        p.solution(12);
    }

    public int solution(int n) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                answer += i;
            }
        }

        return answer;
    }
}
