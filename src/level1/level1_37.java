package level1;//자연수 n이 매개변수로 주어집니다.
// n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.

import java.util.ArrayList;
import java.util.Scanner;

public class level1_37 {
    public static int solution(int n) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while(n>0) {
            list.add(n%3);
            n /= 3;
        }
        int exponent = list.size() - 1;
        for (int i : list) {
            answer += (int) Math.pow(3, exponent) * i;
            exponent--;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = solution(n);
        System.out.println(result);
    }
}

// String으로 x진수를 만들어서 parseInt 두번째 파라미터에 x진수를 넣어주면 10진수로 바꿔주는 기능이 있었음.
//public int solution(int n) {
//    int answer = 0;
//    String ans = "";
//    while(n != 0) {
//        ans += n%3;
//        n /= 3;
//    }
//    return Integer.parseInt(ans, 3);
//}
