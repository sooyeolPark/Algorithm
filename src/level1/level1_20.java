package level1;//1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.
//
//        소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.
//        (1은 소수가 아닙니다.)
//
//        제한 조건
//        n은 2이상 1000000이하의 자연수입니다.

import java.util.Scanner;

public class level1_20 {
    public static int solution(int n) {
        boolean arr[] = new boolean[n+1];
        int answer = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = true;
        }

        arr[0] = arr[1] = false;

        for (int i = 2; i <= n; i++) {
            if (arr[i] == false) {
                continue;
            }
            for (int j = 2*i ; j <= n; j += i) {
                arr[j] = false;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            answer = arr[i] == true? answer+1 : answer;
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

//2중 for문을 안쓰는 방법을 찾아봤으나 없는듯 ㅠ 에라토스테네스의 체라는 소수 찾는 알고리즘을 사용했다.