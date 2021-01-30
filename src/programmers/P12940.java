package programmers;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12940
 * 최대공약수와 최소공배수
 */
public class P12940 {

    public static void main(String[] args) {
        P12940 p = new P12940();
        p.solution(3, 12);
    }

    public int[] solution(int n, int m) {
        int[] answer = {};
        answer = new int[2];

        for(int i = m; i>0; i--) {
            if (n >= i) {
                if (m % i == 0 && n % i == 0) {
                    answer[0] = i;
                    answer[1] = n*m/i;
                    break;
                }
            }
        }

        return answer;
    }

}
