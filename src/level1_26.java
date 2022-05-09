//문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때, 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다.
//        예를 들어 strings가 ["sun", "bed", "car"]이고 n이 1이면 각 단어의 인덱스 1의 문자 "u", "e", "a"로 strings를 정렬합니다.
//
//        제한 조건
//        strings는 길이 1 이상, 50이하인 배열입니다.
//        strings의 원소는 소문자 알파벳으로 이루어져 있습니다.
//        strings의 원소는 길이 1 이상, 100이하인 문자열입니다.
//        모든 strings의 원소의 길이는 n보다 큽니다.
//        인덱스 1의 문자가 같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치합니다.

import java.util.Arrays;
import java.util.Scanner;

public class level1_26 {
    public static long solution(int a, int b) {
        long answer  = 0;
        int x, y;
        if (a < b) {
            x = a;
            y = b;
        } else {
            x = b;
            y = a;
        }
        for (int i = x; i <= y; i++) {
            answer += i;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        long result = solution(a, b);
        System.out.println(result);
    }
}

// 등차수열의 합 공식을 이용하면 쉽다.  (a1+an)/2 * n
//    public long solution(int a, int b) {
//        return sumAtoB(Math.min(a, b), Math.max(b, a));
//    }
//
//    private long sumAtoB(long a, long b) {
//        return (b - a + 1) * (a + b) / 2;
//    }