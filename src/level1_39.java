//슈퍼 게임 개발자 오렐리는 큰 고민에 빠졌다.
// 그녀가 만든 프랜즈 오천성이 대성공을 거뒀지만, 요즘 신규 사용자의 수가 급감한 것이다.
// 원인은 신규 사용자와 기존 사용자 사이에 스테이지 차이가 너무 큰 것이 문제였다.
//
//        이 문제를 어떻게 할까 고민 한 그녀는 동적으로 게임 시간을 늘려서 난이도를 조절하기로 했다.
//        역시 슈퍼 개발자라 대부분의 로직은 쉽게 구현했지만, 실패율을 구하는 부분에서 위기에 빠지고 말았다. 오렐리를 위해 실패율을 구하는 코드를 완성하라.
//
//        실패율은 다음과 같이 정의한다.
//        스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
//        전체 스테이지의 개수 N, 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages가 매개변수로 주어질 때,
//        실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return 하도록 solution 함수를 완성하라.
//
//        제한사항
//        스테이지의 개수 N은 1 이상 500 이하의 자연수이다.
//        stages의 길이는 1 이상 200,000 이하이다.
//        stages에는 1 이상 N + 1 이하의 자연수가 담겨있다.
//        각 자연수는 사용자가 현재 도전 중인 스테이지의 번호를 나타낸다.
//        단, N + 1 은 마지막 스테이지(N 번째 스테이지) 까지 클리어 한 사용자를 나타낸다.
//        만약 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 오도록 하면 된다.
//        스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0 으로 정의한다.

import java.util.*;
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class level1_39 {
    public static int[] solution(int N, int[] stages) {
        Map<Integer, Double> result = new HashMap<Integer, Double>();
        for (int i = 1; i <= N; i++) {
            double tryNum = 0;
            double clearNum = 0;
            for (int j = 0; j < stages.length; j ++) {
                if (stages[j] == i) {
                    clearNum++;
                }
                if (stages[j] >= i) {
                    tryNum++;
                }
            }
            double check = tryNum == 0 ? 0 : clearNum/tryNum;
            result.put(i,check);
        }
        List<Entry<Integer, Double>> list = new ArrayList<Entry<Integer, Double>>(result.entrySet());
        Collections.sort(list, new Comparator<Entry<Integer, Double>>() {
            public int compare(Entry<Integer, Double> obj1, Entry<Integer, Double> obj2) {
                return obj2.getValue().compareTo(obj1.getValue());
            }
        });

        int [] answer = new int[N];
        int idx = 0;
        for(Entry<Integer, Double> entry : list) {
            answer[idx] = entry.getKey();
            idx++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int [] s = {4,4,4,4,4};
        int [] result = solution(l, s);
        System.out.println(Arrays.toString(result));
    }
}

// tryNum 과 clearNum을 int로 설정해버리고 나중에 나눠서 double형으로 바꿀려니까 에러나서 오래걸림
//  -> 애초부터 double형으로 선언하고 나눠주자
// 0으로 나눌때를 대비해야함 0으로 나누면 NaN 출력됨