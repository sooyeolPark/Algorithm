package level2;

import java.util.Scanner;

//피보나치 수는 F(0) = 0, F(1) = 1일 때, 1 이상의 n에 대하여 F(n) = F(n-1) + F(n-2) 가 적용되는 수 입니다.
//
//예를들어
//
//F(2) = F(0) + F(1) = 0 + 1 = 1
//F(3) = F(1) + F(2) = 1 + 1 = 2
//F(4) = F(2) + F(3) = 1 + 2 = 3
//F(5) = F(3) + F(4) = 2 + 3 = 5
//와 같이 이어집니다.
//
//2 이상의 n이 입력되었을 때, n번째 피보나치 수를 1234567으로 나눈 나머지를 리턴하는 함수, solution을 완성해 주세요.
//
//제한 사항
//n은 2 이상 100,000 이하인 자연수입니다.
//입출력 예
public class level2_1 {
    public static int solution(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        int prev1 = 1;
        int prev2 = 1;
        int current = 0;
        for (int i = 3; i <= n; i++) {
            current = (prev1 + prev2) % 1234567;
            prev2 = prev1;
            prev1 = current;
        }
        return current;
    }

//    public static int fibonacci(int n) {
//        if (n == 0) {
//            return 0;
//        }
//        if (n == 1) {
//            return 1;
//        }
//        return fibonacci(n - 1) + fibonacci(n - 2);
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int result = solution(x);
        System.out.println(result);
    }
}

//처음에 재귀함수로 해봤는데 메모리 초과로 일반 반복문을 돌리게 되었다.
// 재귀함수는 일반 for문에 비해서 많이 느리다.. int 값 범위를 고려하자!