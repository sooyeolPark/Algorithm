package level1;//정수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요.

import java.util.Scanner;

public class level1_16 {
    public static int solution(int n) {
        int answer = 0;
        for (double i = 1; i <= n; i++) {
            answer += Math.floor((double)n / i) == (double) n / i ? i : 0;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int result = solution(x);
        System.out.println(result);
    }
}

// 첨에 for문 2번이라도 더 줄여보려고
//        int answer = 1 + n;
//        for (int i = 2; i < n; i++) {
//        answer += Math.floor((double)n / i) == (double) n / i ? i : 0;
//        }
// 이렇게 코드를 짰는데 생각해보니 1일때는 오답이 되어버린다...
// 그리고 약수를 구하는건 n % i == 0으로 하면 되는걸 왜 어렵게 했을까..

//for문을 절반만 돌리고 나머지는 자기자신(제일 큰 약수)랑 합쳐준다.. 1을 제외한 약수 중 2가 제일 작기 때문에 절반 이상은 돌릴 필요가 없다...
//public int sumDivisor(int num) {
//        int answer = 0;
//            for(int i = 1; i <= num/2; i++){
//        if(num%i == 0) answer += i;
//      }
//        return answer+num;
//    }