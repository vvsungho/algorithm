package programmers;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42584
 * 주식가격
 */
public class P42584 {

    public static void main(String[] args) {
        P42584 p = new P42584();
        p.solution(new int[]{1, 2, 3, 2, 3});
    }

    public int[] solution(int[] prices) {
        int[] answer = new int [prices.length];

        for (int i = 0; i < prices.length; i++) {
            int second = 0;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] <= prices[j]) {
                    second++;
                } else {
                    second++;
                    break;
                }
            }
            answer[i] = second;
        }

        return answer;
    }
}
