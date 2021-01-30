package programmers;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42862
 * 체육복
 */

public class P42862 {

    public static void main(String[] args) {

        P42862 p = new P42862();
        p.solution(5, new int[]{2,4}, new int[]{1,3,5});

    }

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        answer = n - lost.length;

        for(int i=0; i< lost.length; i++) {
            for(int j=0; j< reserve.length; j++) {
                if(lost[i] == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    answer++;
                    break;
                }

            }
        }

        for(int i=0; i< lost.length; i++) {
            for(int j=0; j< reserve.length; j++) {
                if(lost[i]-reserve[j]==1 || reserve[j]- lost[i]==1) {
                    reserve[j] = -1;
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }
}
