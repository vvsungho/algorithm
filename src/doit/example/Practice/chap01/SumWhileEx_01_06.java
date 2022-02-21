package doit.example.Practice.chap01;
import java.util.Scanner;
// 1, 2, …, n의 합을 구합니다(while문 종료 뒤의 i의 값을 확인).

class SumWhileEx_01_06 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		System.out.println("1부터 n까지의 합을 구합니다.");
		System.out.print("n의 값：");
		int n = stdIn.nextInt();

		int sum = 0; 		// 합
		int i = 1;

		while (i <= n) { 	// i가 n 이하면 반복
			sum += i; 		// sum에 i를 더함
			i++; 			// i의 값을 1 증가(increment)
		}
		System.out.println("1부터 " + n + "까지의 합은 " + sum + "입니다.");
		System.out.println("i의 값은 " + i + "가(이) 되었습니다.");
	}
}
