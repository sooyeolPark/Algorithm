package level1;
// 자연수 n이 매개변수로 주어집니다.
// n을 x로 나눈 나머지가 1이 되도록 하는 가장 작은 자연수 x를 return 하도록 solution 함수를 완성해주세요.
// 답이 항상 존재함은 증명될 수 있습니다.


import java.util.Scanner;

public class level1_31 {
    public static int solution(int n) {
        int answer = n-1;
        for (int i = 1; i <= n; i++) {
            if (n%i==1) {
                answer = i;
                break;
            }
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