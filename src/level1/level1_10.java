package level1;// 임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.
// n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고, n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요.
//
//제한 사항
//n은 1이상, 50000000000000 이하인 양의 정수입니다.

import java.util.Scanner;

public class level1_10 {
    public static long solution(long n) {
        return Math.floor(Math.sqrt(n)) == Math.ceil(Math.sqrt(n)) ? (long) Math.pow(Math.sqrt(n) + 1, 2) : -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong();
        long result = solution(x);
        System.out.println(result);
    }
}

// floor랑 ceil이랑 비교 안해도 되는듯 floor함수 결과와 그냥 결과를 비교하면 더 좋아질듯