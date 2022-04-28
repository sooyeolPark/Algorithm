// 정수 num이 짝수일 경우 "Even"을 반환하고 홀수인 경우 "Odd"를 반환하는 함수, solution을 완성해주세요.
// num은 int 범위의 정수입니다.
// 0은 짝수입니다.

import java.util.Arrays;
import java.util.Scanner;

public class level1_9 {
    public static String solution(int num) {
        return num%2==0 ? "Even" : "Odd";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        String result = solution(x);
        System.out.println(result);
    }
}