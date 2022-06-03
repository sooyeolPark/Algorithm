package level1;//길이가 n이고, "수박수박수박수...."와 같은 패턴을 유지하는 문자열을 리턴하는 함수, solution을 완성하세요. 예를들어 n이 4이면 "수박수박"을 리턴하고 3이라면 "수박수"를 리턴하면 됩니다.
//
//        제한 조건
//        n은 길이 10,000이하인 자연수입니다.

import java.util.Scanner;

public class level1_19 {
    public static String solution(int n) {
        String answer = "";
        for (int i = 0; i < n; i++) {
            answer += i%2==0 ? "수" : "박";
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        String result = solution(x);
        System.out.println(result);
    }
}
// 다른 사람의 풀이
// 빈 char배열이 생성되면 \0으로 먼저 생성이 된다. 이것을 수박으로 replace한 다음 글자수 만큼 잘라준다.
// return new String(new char [n/2+1]).replace("\0", "수박").substring(0,n);