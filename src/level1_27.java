//문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때, 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다.
//        예를 들어 strings가 ["sun", "bed", "car"]이고 n이 1이면 각 단어의 인덱스 1의 문자 "u", "e", "a"로 strings를 정렬합니다.
//
//        제한 조건
//        strings는 길이 1 이상, 50이하인 배열입니다.
//        strings의 원소는 소문자 알파벳으로 이루어져 있습니다.
//        strings의 원소는 길이 1 이상, 100이하인 문자열입니다.
//        모든 strings의 원소의 길이는 n보다 큽니다.
//        인덱스 1의 문자가 같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치합니다.

import java.util.*;

public class level1_27 {
    public static int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : arr) {
            if (i % divisor == 0) {
                list.add(i);
            }
        }
        if (list.size() == 0) {
            return new int[] {-1};
        }
        Collections.sort(list);
        int[] answer = new int[list.size()];
        for (int j = 0; j < list.size(); j++) {
            answer[j] = list.get(j);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] x = {2, 35, 1, 3};
        int y = 2;
        int[] result = solution(x, y);
        System.out.println(result.toString());
    }
}

// 람다와 Array 내장 함수를 이용하여 간단하게...
//public int[] solution(int[] arr, int divisor) {
//    int[] answer = Arrays.stream(arr).filter(factor -> factor % divisor == 0).toArray();
//    if(answer.length == 0) answer = new int[] {-1};
//    java.util.Arrays.sort(answer);
//    return answer;
//}