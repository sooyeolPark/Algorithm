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

import java.util.*;
import java.util.Map.Entry;

public class level1_40 {
    public static int solution(int n, int[] lost, int[] reserve) {
        TreeSet<Integer> possible = new TreeSet<Integer>();
        int num = 0;

        for (int i = 0; i < lost.length; i++) {
            int b = lost[i];
            boolean a = Arrays.stream(reserve).anyMatch(q -> q == b);
            if (a) {
                num++;
                continue;
            }
            if (lost[i] == 1) {
                possible.add(lost[i]);
                possible.add(lost[i] + 1);
            } else {
                possible.add(lost[i] - 1);
                possible.add(lost[i]);
                possible.add(lost[i] + 1);
            }
        }
        System.out.println(possible);
        for (int i = 0; i < lost.length; i++) {
            int b = lost[i];
            boolean a = Arrays.stream(reserve).anyMatch(q -> q == b);
            if (a) {
                possible.remove(lost[i]);
            }
        }
        System.out.println(possible);
        for(Integer i : possible) {
            for (int j = 0; j < reserve.length; j++) {
                if(reserve[j]==i) {
                    num++;
                }
            }
        }

        return n-lost.length+num > n ? n : n-lost.length+num;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] l = {4,4,4,4,4};
        int [] r = {4,4,4,4,4};
        int result = solution(n, l, r);
        System.out.println(result);
    }
}

// 괜찮은 해법
//class Solution {
//    public int solution(int n, int[] lost, int[] reserve) {
//        int[] people = new int[n];
//        int answer = n;
//
//        for (int l : lost)
//            people[l-1]--;
//        for (int r : reserve)
//            people[r-1]++;
//
//        for (int i = 0; i < people.length; i++) {
//            if(people[i] == -1) {
//                if(i-1>=0 && people[i-1] == 1) {
//                    people[i]++;
//                    people[i-1]--;
//                }else if(i+1< people.length && people[i+1] == 1) {
//                    people[i]++;
//                    people[i+1]--;
//                }else
//                    answer--;
//            }
//        }
//        return answer;
//    }
//}