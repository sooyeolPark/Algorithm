package level1;//대문자와 소문자가 섞여있는 문자열 s가 주어집니다. s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True, 다르면 False를 return 하는 solution를 완성하세요. 'p', 'y' 모두 하나도 없는 경우는 항상 True를 리턴합니다. 단, 개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.
//
//        예를 들어 s가 "pPoooyY"면 true를 return하고 "Pyy"라면 false를 return합니다.
//
//        제한사항
//        문자열 s의 길이 : 50 이하의 자연수
//        문자열 s는 알파벳으로만 이루어져 있습니다..

import java.util.*;

public class level1_24 {
    public static boolean solution(String s) {
        char [] charArr = s.toCharArray();
        int Pnumber = 0;
        int Ynumber = 0;
        for(char c : charArr) {
            if (String.valueOf(c).toLowerCase().equals("p")) {
                Pnumber++;
            } else if (String.valueOf(c).toLowerCase().equals("y")) {
                Ynumber++;
            }
        }
        return Pnumber==Ynumber ? true : false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        boolean result = solution(x);
        System.out.println(result);
    }
}

//arr로 안만들고 charAt을 쓰고 p와 y 개수를 새는 변수 두개를 안만들고 + - 로 true false를 판별 가능
//boolean solution(String s) {
//    s = s.toLowerCase();
//    int count = 0;
//
//    for (int i = 0; i < s.length(); i++) {
//
//        if (s.charAt(i) == 'p')
//            count++;
//        else if (s.charAt(i) == 'y')
//            count--;
//    }
//
//    if (count == 0)
//        return true;
//    else
//        return false;