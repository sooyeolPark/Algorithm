// 양의 정수 x가 하샤드 수이려면 x의 자릿수의 합으로 x가 나누어져야 합니다.
// 예를 들어 18의 자릿수 합은 1+8=9이고, 18은 9로 나누어 떨어지므로 18은 하샤드 수입니다.
// 자연수 x를 입력받아 x가 하샤드 수인지 아닌지 검사하는 함수, solution을 완성해주세요.
import java.util.*;

public class level1_5 {
    public static Boolean solution(int x) {
        String xStr = Integer.toString(x);
        int xSum = 0;
        for (int i = 0; i<xStr.length() ; i++) {
            xSum += Integer.parseInt(String.valueOf(xStr.charAt(i)));
        }
        boolean answer = x % xSum == 0 ? true : false;
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        boolean result = solution(x);
        System.out.println(result);
    }
}

//""구분으로 잘라서 배열에 담은뒤 포문으로 돌린다.
// JAVA에서 배열을 이용한 for문 활용법을 익혀두자!
//public boolean solution(int num){
//
//    String[] temp = String.valueOf(num).split("");
//
//    int sum = 0;
//    for (String s : temp) {
//        sum += Integer.parseInt(s);
//    }
//
//    if (num % sum == 0) {
//        return true;
//    } else {
//        return false;
//    }
//}