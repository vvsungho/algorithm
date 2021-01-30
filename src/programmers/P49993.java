package programmers;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/49993
 * 스킬트리
 */
public class P49993 {

    public static void main(String[] args) {
        P49993 p = new P49993();
        p.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"});
    }

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (int i = 0; i < skill_trees.length; i++) {

            String skill_tree = skill_trees[i];
            int num = 0;
            answer ++;
            for (int j = 0; j < skill_tree.length(); j++) {

                if (skill.contains(String.valueOf(skill_tree.charAt(j)))) {
                    if (skill.charAt(num) == skill_tree.charAt(j)) {
                        num++;
                    } else {
                        answer--;
                        break;
                    }
                }

            }

        }

        return answer;
    }


}
