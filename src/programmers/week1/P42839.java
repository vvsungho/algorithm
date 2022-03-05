package programmers.week1;

import java.util.*;

/**
 * #level2
 * https://programmers.co.kr/learn/courses/30/lessons/42839
 * 소수 찾기
 * 문제 설명
 * 한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
 *
 * 각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * numbers는 길이 1 이상 7 이하인 문자열입니다.
 * numbers는 0~9까지 숫자만으로 이루어져 있습니다.
 * "013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
 * 입출력 예
 * numbers	return
 * "17"	3
 * "011"	2
 * 입출력 예 설명
 * 예제 #1
 * [1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.
 *
 * 예제 #2
 * [0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.
 *
 * 11과 011은 같은 숫자로 취급합니다.
 */

public class P42839 {
    static HashSet<Integer> set= new HashSet<>();
    static char[] arr;
    static boolean[] visited;

    public int solution(String numbers) {
        int answer = 0;
        arr= new char[numbers.length()];
        visited= new boolean[numbers.length()];

        for(int i=0; i<numbers.length(); i++){
            arr[i]=numbers.charAt(i);
        }
        recursion("", 0);

        answer= set.size();
        return answer;
    }

    //재귀: 가능한 숫자 조합을 찾고 소수여부에 따라 set에 추가
    public void recursion(String str, int idx){
        int num;
        if(str!="") {
            num= Integer.parseInt(str);
            if(isPrime(num)) set.add(num);
        }

        if(idx== arr.length) return;

        for(int i=0; i<arr.length; i++){
            if(visited[i]) continue;
            visited[i]= true;
            recursion(str+arr[i], idx+1);
            visited[i]= false;
        }
    }//rec

    public boolean isPrime(int num){ //소수 판별
        if(num==1||num==0) return false;
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num%i==0) return false;
        }

        return true;
    }
}
