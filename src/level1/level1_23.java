package level1;//문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
//        s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.
//
//        제한 사항
//        str은 길이 1 이상인 문자열입니다.

import java.util.*;

public class level1_23 {
    public static String solution(String s) {
        String[] list = String.valueOf(s).split("");
        Arrays.sort(list, Collections.reverseOrder());
        String answer = "";
        for(String v : list) {
            answer += v;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        String result = solution(x);
        System.out.println(result);
    }
}

//StringBuilder를 쓰면 더 좋은 코드를 만들 수 있다.
//public class ReverseStr {
//    public String reverseStr(String str){
//        char[] sol = str.toCharArray();
//        Arrays.sort(sol);
//        return new StringBuilder(new String(sol)).reverse().toString();
//    }