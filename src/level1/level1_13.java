package level1;// 자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요.
// 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.

import java.util.Arrays;
import java.util.Scanner;

public class level1_13 {

    public static int[] solution(long n){
        String[] list = String.valueOf(n).split("");
        int [] answer = new int[list.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = Integer.parseInt(list[list.length-1-i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong();
        int[] result = solution(x);
        System.out.println(Arrays.toString(result));
    }


}

//굳이 array로 만들지 않고 다음과 같이 1의 자리부터 잘라서 담는것도 괜찮아 보인다.
//class Solution {
//    public int[] solution(long n) {
//        String a = "" + n;
//        int[] answer = new int[a.length()];
//        int cnt=0;
//
//        while(n>0) {
//            answer[cnt]=(int)(n%10);
//            n/=10;
//            System.out.println(n);
//            cnt++;
//        }
//        return answer;
//    }
//}