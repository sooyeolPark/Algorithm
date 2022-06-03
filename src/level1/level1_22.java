package level1;//문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요.
// 예를 들어 s가 "a234"이면 False를 리턴하고 "1234"라면 True를 리턴하면 됩니다.
//
//제한 사항
//s는 길이 1 이상, 길이 8 이하인 문자열입니다.

import java.util.Scanner;

public class level1_22 {
    public static boolean solution(String s) {
        if (s.length() != 4 && s.length() != 6) {
            return false;
        }
        char [] charArr = s.toCharArray();
        boolean answer = true;
        for (char c : charArr) {
            if (!Character.isDigit(c)) {
                answer = false;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        boolean result = solution(x);
        System.out.println(result);
    }
}

//더 짧고 좋은 코드들이 많다.

// 숫자로 스플릿해서 배열의 개수 구하는 방법
//public boolean solution(String s) {
//    return (s.length() != 4 && s.length() != 6) || (s.split("[0-9]").length > 0) ? false:true;
//  }

//try catch로 한 사람 신기하다고 생각했는데
// 이펙티브 자바 예외처리 관련된 항목에서 금기시 되는 풀이라고.. 예외는 실제 예외 상황일때만 사용해야하고 리소스도 많이 든다고 한다.
//  public boolean solution(String s) {
//      if(s.length() == 4 || s.length() == 6){
//          try{
//              int x = Integer.parseInt(s);
//              return true;
//          } catch(NumberFormatException e){
//              return false;
//          }
//      }
//      else return false;
//  }