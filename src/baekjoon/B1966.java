package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.acmicpc.net/problem/1966
 * 프린트큐
 * 문제는 내가원하는 문서가 몇번째 출력되는가? 이다.
 *
 * 1 --> 입력받을 test case 갯수
 *
 * 6 0 --> 6은 배열의 크기이다 , 0은 내가 찾고싶은 문서의 INDEX위치이다.
 *
 * 1 1 9 1 1 1 --> 주어진 문서이다.
 *
 * 예시로 위처럼 입력을 받은경우에 1 1 9 1 1 1 로 정렬 된 문서에서 0번째 문서가 몇번째로 출력되는지 찾는것이다.
 *
 * 전체문서에서 처리중인 문서보다 중요도가 높은 문서가 하나라도 있다면, 인쇄하지 않고 맨 뒤로 보낸다.
 *
 * 위의 테스트 테스트케이스 에서는 아래와같이 처리가 진행 될 것이다.
 * 중요도가 높은 것이 있으면 뒤로 밀어준다.
 */
public class B1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine()); // @1

        for (int i = 0; i < testcase; i++) {
            String inputData = br.readLine();
            String[] inputSplit = inputData.split(" ");
            int N = Integer.parseInt(inputSplit[0]);
            int M = Integer.parseInt(inputSplit[1]);

            String priorityData = br.readLine();
            String[] prioritySplit = priorityData.split(" ");
            int [] priority = new int[prioritySplit.length];
            Queue<Item> items = new LinkedList<Item>();
            for (int j = 0; j < N; j++) {
                priority[j] = Integer.parseInt(prioritySplit[j]);
                items.add(new Item(priority[j], j));
            }

            int result = 0;

            outer: while (!items.isEmpty()) {
                Item item = items.peek();

                for (int j = 0; j < items.size(); j++) {
                    if (item.getPriority() < ((LinkedList<Item>)items).get(j).getPriority()) {
                        Item moveItem = items.poll();
                        items.offer(moveItem);
                        continue outer;
                    }
                }

                Item checkItem = items.poll();
                result++; // 몇 번째
                if (checkItem.getValue() == M) {
                    System.out.println(result);
                    break;
                }

            }

        }
    }
}


class Item {
    private int priority;
    private int value;

    public int getPriority() {
        return priority;
    }

    public int getValue() {
        return value;
    }

    public Item(int priority, int value) {
        this.priority = priority;
        this.value = value;
    }
}