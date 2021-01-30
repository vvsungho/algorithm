package programmers;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12909
 * 올바른 괄호
 */
public class P12909 {

    public static void main(String[] args) {
        P12909 p = new P12909();
        p.solution("()()");
    }

    boolean solution(String s) {
        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            if ('(' == s.charAt(i)) {
                num++;
            } else {
                num--;
            }
            if (num < 0) {
                return false;
            }
        }

        return num == 0;
    }

}
