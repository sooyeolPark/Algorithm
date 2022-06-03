package level1;//2016년 1월 1일은 금요일입니다. 2016년 a월 b일은 무슨 요일일까요?
// 두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수, solution을 완성하세요.
// 요일의 이름은 일요일부터 토요일까지 각각 SUN,MON,TUE,WED,THU,FRI,SAT 입니다.
// 예를 들어 a=5, b=24라면 5월 24일은 화요일이므로 문자열 "TUE"를 반환하세요.
//
//        제한 조건
//        2016년은 윤년입니다.
//        2016년 a월 b일은 실제로 있는 날입니다. (13월 26일이나 2월 45일같은 날짜는 주어지지 않습니다)

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class level1_34 {
    public static String solution(int a, int b) {
        String[] days = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int idx = 0;
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            Date FirstDate = format.parse("20160101");
            Date SecondDate = format.parse("2016"+String.format("%02d", a)+b);

            long calDate = FirstDate.getTime() - SecondDate.getTime();

            long calDateDays = calDate / ( 24*60*60*1000);

            idx = (int) Math.abs(calDateDays) % 7;
        } catch(ParseException e){
            // 예외 처리
        }
        return days[idx];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        String result = solution(a, b);
        System.out.println(result);
    }
}

// 라이브러리 안쓰고 하는 방법
//public String solution(int a, int b) {
//    String answer = "";
//
//    int[] c = {31,29,31,30,31,30,31,31,30,31,30,31};
//    String[] MM ={"FRI","SAT","SUN","MON","TUE","WED","THU"};
//    int Adate = 0;
//    for(int i = 0 ; i< a-1; i++){
//        Adate += c[i];
//    }
//    Adate += b-1;
//    answer = MM[Adate %7];
//
//    return answer;
//}