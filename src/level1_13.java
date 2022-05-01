// 자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요.
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

//Arrays.sort(ch, Collections.reverseOrder());를 쓸려고했는데 컴파일 에러가 난다.
//그냥 어차피 FOR문 돌릴거 역순으로 돌리는 방법을 택함
//컴파일 에러의 이유는 sort에 Comparator에 T에는 기본 자료형이 들어가지 못 해서이다.
// Integer type이나 String type 등으로 배열을 선언하셔서 사용하시면 된다! 그래서 toCharArray는 안되고 .split()은 되는 이유
//이렇게 하면 된다.
//public long solution(long n) {
//    String[] list = String.valueOf(n).split("");
//    Arrays.sort(list, Collections.reverseOrder());
//    String answer = "";
//    for(String s : list) {
//        answer += s;
//    }
//    return Long.parseLong(answer);
//}