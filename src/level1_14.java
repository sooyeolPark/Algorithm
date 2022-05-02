//자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
//        예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.

import java.util.*;

public class level1_14 {
    public static int solution(int x) {
        int answer = 0;
        while(x>0) {
            answer += (int)(x%10);
            x/=10;
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

//array로 만들어 더하는 코드 가독성은 좋을지 모르지만 리소스를 더 먹는 코드이다.
//public class Solution {
//    public int solution(int n) {
//        int answer = 0;
//        String[] array = String.valueOf(n).split("");
//        for(String s : array){
//            answer += Integer.parseInt(s);
//        }
//        return answer;
//    }
//}