//점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다. 다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다. 학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다. 예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다. 체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.
//
//        전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost, 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때, 체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.
//
//        제한사항
//        전체 학생의 수는 2명 이상 30명 이하입니다.
//        체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
//        여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
//        여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.
//        여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다. 이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.
//  12       [1, 2, 3, 4, 8, 9, 10, 11]         [9, 10]        6

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