package level1;//다트 게임
//        카카오톡에 뜬 네 번째 별! 심심할 땐? 카카오톡 게임별~
//
//        카카오톡 게임별의 하반기 신규 서비스로 다트 게임을 출시하기로 했다. 다트 게임은 다트판에 다트를 세 차례 던져 그 점수의 합계로 실력을 겨루는 게임으로, 모두가 간단히 즐길 수 있다.
//        갓 입사한 무지는 코딩 실력을 인정받아 게임의 핵심 부분인 점수 계산 로직을 맡게 되었다. 다트 게임의 점수 계산 로직은 아래와 같다.
//
//        다트 게임은 총 3번의 기회로 구성된다.
//        각 기회마다 얻을 수 있는 점수는 0점에서 10점까지이다.
//        점수와 함께 Single(S), Double(D), Triple(T) 영역이 존재하고 각 영역 당첨 시 점수에서 1제곱, 2제곱, 3제곱 (점수1 , 점수2 , 점수3 )으로 계산된다.
//        옵션으로 스타상(*) , 아차상(#)이 존재하며 스타상(*) 당첨 시 해당 점수와 바로 전에 얻은 점수를 각 2배로 만든다. 아차상(#) 당첨 시 해당 점수는 마이너스된다.
//        스타상(*)은 첫 번째 기회에서도 나올 수 있다. 이 경우 첫 번째 스타상(*)의 점수만 2배가 된다. (예제 4번 참고)
//        스타상(*)의 효과는 다른 스타상(*)의 효과와 중첩될 수 있다. 이 경우 중첩된 스타상(*) 점수는 4배가 된다. (예제 4번 참고)
//        스타상(*)의 효과는 아차상(#)의 효과와 중첩될 수 있다. 이 경우 중첩된 아차상(#)의 점수는 -2배가 된다. (예제 5번 참고)
//        Single(S), Double(D), Triple(T)은 점수마다 하나씩 존재한다.
//        스타상(*), 아차상(#)은 점수마다 둘 중 하나만 존재할 수 있으며, 존재하지 않을 수도 있다.
//        0~10의 정수와 문자 S, D, T, *, #로 구성된 문자열이 입력될 시 총점수를 반환하는 함수를 작성하라.
//
//        입력 형식
//        "점수|보너스|[옵션]"으로 이루어진 문자열 3세트.
//        예) 1S2D*3T
//
//        점수는 0에서 10 사이의 정수이다.
//        보너스는 S, D, T 중 하나이다.
//        옵선은 *이나 # 중 하나이며, 없을 수도 있다.

import java.util.Scanner;

public class level1_32 {
    public static int solution(String dartResult) {
        int answer = 0;
        dartResult = dartResult.replace("10", "?");
        String[] temp = String.valueOf(dartResult).split("");
        int [] seq = new int[3];
        int idx = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i].equals("?")) {
                temp[i] = "10";
            }

            if (temp[i].equals("S")) {
                seq[idx] = Integer.parseInt(temp[i-1]);
                idx++;
            }
            if (temp[i].equals("D")) {
                seq[idx] = (int) Math.pow(Integer.parseInt(temp[i-1]), 2);
                idx++;
            }
            if (temp[i].equals("T")) {
                seq[idx] = (int) Math.pow(Integer.parseInt(temp[i-1]), 3);
                idx++;
            }
            if (temp[i].equals("*")) {

                if (idx >= 1) {
                    seq[idx-1] = seq[idx-1] * 2;
                }
                if (idx >= 2) {
                    seq[idx-2] = seq[idx-2] * 2;
                }
            }
            if (temp[i].equals("#")) {
                seq[idx-1] = seq[idx-1] * -1;
            }
        }

        for (int i : seq) {
            answer += i;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        int result = solution(x);
        System.out.println(result);
    }
}

//stack을 이용하여 풀어도 괜찮을듯
//class Solution {
//    public int solution(String dartResult) {
//        Stack<Integer> stack = new Stack<>();
//        int sum = 0;
//        for (int i = 0; i < dartResult.length(); ++i) {
//            char c = dartResult.charAt(i);
//            if (Character.isDigit(c)) {
//                sum = (c - '0');
//                if (sum == 1 && i < dartResult.length() - 1 && dartResult.charAt(i + 1) == '0') {
//                    sum = 10;
//                    i++;
//                }
//                stack.push(sum);
//            } else {
//                int prev = stack.pop();
//                if (c == 'D') {
//                    prev *= prev;
//                } else if (c == 'T') {
//                    prev = prev * prev * prev;
//                } else if (c == '*') {
//                    if (!stack.isEmpty()) {
//                        int val = stack.pop() * 2;
//                        stack.push(val);
//                    }
//                    prev *= 2;
//                } else if (c == '#') {
//                    prev *= (-1);
//                }
//                // System.out.println(prev);
//                stack.push(prev);
//            }
//        }
//        int totalScore = 0;
//        while (!stack.isEmpty()) {
//            totalScore += stack.pop();
//        }
//        return totalScore;
//    }
//}