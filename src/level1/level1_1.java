package level1;//이 문제에는 표준 입력으로 두 개의 정수 n과 m이 주어집니다.
//별(*) 문자를 이용해 가로의 길이가 n, 세로의 길이가 m인 직사각형 형태를 출력해보세요.
//제한 조건
//n과 m은 각각 1000 이하인 자연수입니다.
import java.util.Scanner;

public class level1_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if (a > 1000 || b > 1000) {
            System.out.println("1000이하의 자연수만 입력해주세요");
            System.exit(0);
        }
        for (int i = 0; i < b; i++) {
            String result = "";
            for  (int j = 0; j < a; j++) {
                result += "*";
            }
            System.out.println(result);
        }
    }
}
