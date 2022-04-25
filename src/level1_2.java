//함수 solution은 정수 x와 자연수 n을 입력 받아,
// x부터 시작해 x씩 증가하는 숫자를 n개 지니는 리스트를 리턴해야 합니다.
// 다음 제한 조건을 보고, 조건을 만족하는 함수, solution을 완성해주세요.
import java.util.*;

public class level1_2 {

    public static long[] solution(long x, int n){
        long[] answer = new long[n];
        for (int i = 0; i < n; i++) {
            answer[i] = x + (i * x);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong();
        int n = sc.nextInt();
        long[] result = solution(x, n);
        System.out.println(Arrays.toString(result));
    }


}

//괜찮은 코드
//class Solution {
//    public static long[] solution(int x, int n) {
//        long[] answer = new long[n];
//        answer[0] = x;
//
//        for (int i = 1; i < n; i++) {
//            answer[i] = answer[i - 1] + x;
//        }
//
//        return answer;
//
//    }
//}