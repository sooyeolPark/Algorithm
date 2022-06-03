package level1;//0부터 9까지의 숫자 중 일부가 들어있는 정수 배열 numbers가 매개변수로 주어집니다.
//numbers에서 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 더한 수를 return 하도록 solution 함수를 완성해주세요.

import java.util.Scanner;

public class level1_47 {
    public static int solution(int[] numbers) {
        int answer = 0;
        for(int i = 0; i < 10; i++) {
            boolean chk = false;
            for (int j = 0; j < numbers.length; j++) {
                if (i==numbers[j]) {
                    chk = true;
                    break;
                }
            }
            if(!chk) {
                answer += i;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] a = {1,2,3,4,6,7,8,0};
        int result = solution(a);
        System.out.println(result);
    }
}

// 전체 합에서 있는 숫자만 빼면 쉽게 답을 도출가능
//    public int solution(int[] numbers) {
//        int sum = 45;
//        for (int i : numbers) {
//            sum -= i;
//        }
//        return sum;
//    }