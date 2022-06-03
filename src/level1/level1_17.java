package level1;//어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다.
// 예를 들어 "AB"는 1만큼 밀면 "BC"가 되고, 3만큼 밀면 "DE"가 됩니다. "z"는 1만큼 밀면 "a"가 됩니다.
// 문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.
//
//제한 조건
//공백은 아무리 밀어도 공백입니다.
//s는 알파벳 소문자, 대문자, 공백으로만 이루어져 있습니다.
//s의 길이는 8000이하입니다.
//n은 1 이상, 25이하인 자연수입니다.

import java.util.Scanner;

public class level1_17 {
    public static String solution(String s, int n) {
        String answer = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //공백일때 넘어가기
            if (c==' ') {
                answer += c;
                continue;
            }
            // 대문자건 소문자건 다 소문자로 변환해서 + n을 했을때 z를 넘어가면 -26을 빼주고 n을 더한다.
            if (String.valueOf(c).toLowerCase().charAt(0) + n > 'z') {
                answer += (char) (c-26+n);
            } else {
                answer += (char) (c+n);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        int y = sc.nextInt();
        String result = solution(x, y);
        System.out.println(result);
    }
}


// 조건이 n이 25 이하라고 나오지 않았으면 나머지를 구해서 해야함
// 괜찮은 코드
// ch = (char) ((ch - 'A' + n) % 26 + 'A');하면 n을 더했을 때 z값을 넘어가나 안넘어가나 분기처리를 안해도 된다.

// String caesar(String s, int n) {
//        String result = "";
//    n = n % 26;
//    for (int i = 0; i < s.length(); i++) {
//      char ch = s.charAt(i);
//      if (Character.isLowerCase(ch)) {
//        ch = (char) ((ch - 'a' + n) % 26 + 'a');
//      } else if (Character.isUpperCase(ch)) {
//        ch = (char) ((ch - 'A' + n) % 26 + 'A');
//      }
//      result += ch;
//    }
//        return result;
//    }