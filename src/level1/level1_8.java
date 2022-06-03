package level1;// 두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수, solution을 완성해 보세요.
// 배열의 맨 앞에 최대공약수, 그다음 최소공배수를 넣어 반환하면 됩니다.
// 예를 들어 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로 solution(3, 12)는 [3, 12]를 반환해야 합니다.
//제한 사항
//두 수는 1이상 1000000이하의 자연수입니다.

import java.util.Arrays;
import java.util.Scanner;

public class level1_8 {
    public static long[] solution(long n, long m) {
        //최대공약수는 두 수 중 최소값에서 시작해 나머지가 0이 되는 제일 작은수를 구하는 for문 이용
        long max = 1;
        for (long i = Math.min(n,m); i>1; i--) {
            if (n%i == 0 && m%i == 0) {
                max = i;
                break;
            }
        }
        //최소공배수는 최대공약수가 구해진 상태이므로 두 수의 곱은 최소공약수와 최대공약수의 곱인 것을 이용
        long min = n*m/max;
        long[] answer = {max,min};
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        if (x > 1000000 || x < 1 || y > 1000000 || y < 1) {
            System.out.println("두 수는 1이상 1000000이하의 자연수입니다.");
            System.exit(1);
        }
        long[] result = solution(x, y);
        System.out.println(Arrays.toString(result));
    }
}

//유클리드 호제법이라는 알고리즘이 있었다. 재귀함수를 통하여 최대공약수를 좀더 효율적으로 구할 수 있음
// 2개의 자연수  a, b에 대해서 a를 b로 나눈 나머지를 r이라 하면 (단 a>b),
// a와 b의 최대공약수는 b와 r의 최대공약수와 같다.
// 이 성질에 따라, b를 r로 나눈 나머지 r0를 구하고, 다시 r을 r0로 나눈 나머지를 구하는 과정을 반복하여 나머지가 0이 되었을 때
// 나누는 수가 a와 b의 최대공약수이다.
//    public static int gcd(int num1, int num2){
//        if(num2 == 0) return num1;
//        else return gcd(num2, num1 % num2);
//    }
//
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int num1 = sc.nextInt(), num2 = sc.nextInt();
//        int gcd = gcd(num1, num2);
//        System.out.println(gcd);
//        System.out.println(num1 * num2 / gcd);
//    }