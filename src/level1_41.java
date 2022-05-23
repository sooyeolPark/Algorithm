//수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다.
// 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
//
//        1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
//        2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
//        3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
//
//        1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때,
//        가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
//
//        제한 조건
//        시험은 최대 10,000 문제로 구성되어있습니다.
//        문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
//        가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class level1_41 {
    public static int[] solution(int[] answers) {
        int[] supo1 = {1, 2, 3, 4, 5};
        int[] supo2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] supo3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int answerArr [] = new int [3];
        for (int i = 0; i < answers.length; i++) {
            if(answers[i] == supo1[i%supo1.length]) {
                answerArr[0]++;
            }
            if(answers[i] == supo2[i%supo2.length]) {
                answerArr[1]++;
            }
            if(answers[i] == supo3[i%supo3.length]) {
                answerArr[2]++;
            }
        }
        int max = 0;
        for (int j : answerArr ) {
            max = Math.max( j, max );
        }
        List<Integer> answerList = new ArrayList<Integer>();
        for (int k = 0; k < answerArr.length; k++) {
            if(max == answerArr[k]) {
                answerList.add(k+1);
            }
        }
        int [] answer = new int[answerList.size()];
        for (int n = 0; n < answerList.size(); n ++) {
            answer[n] = answerList.get(n);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] l = {4,4,4,4,4};
        int[] result = solution(l);
        System.out.println(result);
    }
}

// 괜찮은 해법 2차 배열로 깔끔하게 가능
//public static int[] solution(int[] answers) {
//    int[][] patterns = {
//            {1, 2, 3, 4, 5},
//            {2, 1, 2, 3, 2, 4, 2, 5},
//            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
//    };
//
//    int[] hit = new int[3];
//    for(int i = 0; i < hit.length; i++) {
//        for(int j = 0; j < answers.length; j++) {
//            if(patterns[i][j % patterns[i].length] == answers[j]) hit[i]++;
//        }
//    }
//
//    int max = Math.max(hit[0], Math.max(hit[1], hit[2]));
//    List<Integer> list = new ArrayList<>();
//    for(int i = 0; i < hit.length; i++)
//        if(max == hit[i]) list.add(i + 1);
//
//    int[] answer = new int[list.size()];
//    int cnt = 0;
//    for(int num : list)
//        answer[cnt++] = num;
//    return answer;
//}