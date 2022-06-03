package level1;//두 정수 left와 right가 매개변수로 주어집니다.
//        left부터 right까지의 모든 수들 중에서, 약수의 개수가 짝수인 수는 더하고,
//        약수의 개수가 홀수인 수는 뺀 수를 return 하도록 solution 함수를 완성해주세요.

import java.util.Scanner;

public class level1_38 {
    public static int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            int num = 0;
            for (int j = 1; j <= i; j++) {
                if (i%j==0) {
                    num++;
                }
            }
            if (num%2==0) {
                answer += i;
            } else {
                answer -= i;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int r = sc.nextInt();
        int result = solution(l, r);
        System.out.println(result);
    }
}

// 사실 약수는 짝을 가지기 마련이다. 하지만 제급수이라면 같은 숫자가 두개니까 약수가 하나만 생기는데 이때만 약수가 홀수개가 된다.
// 제곱수인 경우 약수의 개수가 홀수라는 것을 이용하여 하나의 for문 하나만을 사용하여 문제를 푸는것이 베스트인듯..
// 수학적으로 생각하면 알고리즘의 성능이 좋아질 수 있다......

//    public int solution(int left, int right) {
//        int answer = 0;
//
//        for (int i=left;i<=right;i++) {
//            //제곱수인 경우 약수의 개수가 홀수
//            if (i % Math.sqrt(i) == 0) {
//                answer -= i;
//            }
//            //제곱수가 아닌 경우 약수의 개수가 짝수
//            else {
//                answer += i;
//            }
//        }
//
//        return answer;
//    }
