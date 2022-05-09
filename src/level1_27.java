//array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.
//        divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.
//
//        제한사항
//        arr은 자연수를 담은 배열입니다.
//        정수 i, j에 대해 i ≠ j 이면 arr[i] ≠ arr[j] 입니다.
//        divisor는 자연수입니다.
//        array는 길이 1 이상인 배열입니다.

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