//String형 배열 seoul의 element중 "Kim"의 위치 x를 찾아, "김서방은 x에 있다"는 String을 반환하는 함수, solution을 완성하세요.
//        seoul에 "Kim"은 오직 한 번만 나타나며 잘못된 값이 입력되는 경우는 없습니다.
//
//        제한 사항
//        seoul은 길이 1 이상, 1000 이하인 배열입니다.
//        seoul의 원소는 길이 1 이상, 20 이하인 문자열입니다.
//        "Kim"은 반드시 seoul 안에 포함되어 있습니다.

import java.util.Scanner;

public class level1_21 {
    public static String solution(String[] seoul) {
        String answer = "";
        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                answer =  "김서방은 " + i + "에 있다";
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] x = {"1", "2" , "Kim", "3" ,"5"};
        String result = solution(x);
        System.out.println(result);
    }
}
