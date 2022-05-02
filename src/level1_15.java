//문자열 s는 한 개 이상의 단어로 구성되어 있습니다. 각 단어는 하나 이상의 공백문자로 구분되어 있습니다.
// 각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.

import java.util.*;

public class level1_15 {
    public static String solution(String x) {
        char [] charArr = x.toCharArray();
        String answer = "";

        int reset = 0;
        for(char c : charArr) {
            if(c==' ') {
                answer += String.valueOf(c);
                reset = 0;
            } else {
                answer += reset%2==0 ? String.valueOf(c).toUpperCase() : String.valueOf(c).toLowerCase();
                reset++;
            }
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

// if(String.valueOf(c)==" ") 이부분에서 false값만 리턴해서 시간이 걸림
// java에서는 큰 따옴표를 사용하여 String상수 ( " ") 를 만들고 작은 따옴표를 사용 하면 char상수 ( ' ')를 만든다.
// 왜 String.valueOf(c)는 공백이되는데 string 공백은 == " " 로 안되고 String.valueOf(c).equals(" ")로 된다.
// https://go-coding.tistory.com/35 - String에서의 ==와 equals의 차이점
// 단순하게 말하면 == 연산자는 int,boolean과 같은 primitive type에 대해서는 값을 비교한다. reference type에 대해서는 주소값을 비교한다.
// 사실 primitive type도 Constant Pool에 있는 특정 상수를 참조하는 것이기 때문에 결국 주소값을 비교하는 것으로 볼 수 있다.