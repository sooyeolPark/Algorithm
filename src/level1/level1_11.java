package level1;//정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수, solution을 완성해주세요.
// 단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요.
// 예를들어 arr이 [4,3,2,1]인 경우는 [4,3,2]를 리턴 하고, [10]면 [-1]을 리턴 합니다.
//        제한 조건
//        arr은 길이 1 이상인 배열입니다.
//        인덱스 i, j에 대해 i ≠ j이면 arr[i] ≠ arr[j] 입니다.

import java.util.*;
import java.util.Scanner;

public class level1_11 {
    public static int[] solution(int[] arr) {
        //하나일때는 무조건 -1
        if (arr.length == 1) {
            return new int[]{-1};
        }
        int[] answer = new int[arr.length-1];
        //최소값 index구하기
        int minIdx = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[minIdx] > arr[i]) {
                minIdx = i;
            }
        }
        //chkPoint를 index로 잡아 그 수 빼고 새로운 값 answer array에 넣기
        boolean chkPoint = false;
        for (int j = 0; j < arr.length; j++) {
            if (j == minIdx) {
                chkPoint = true;
                continue;
            }
            if (chkPoint) {
                answer[j-1] = arr[j];
            } else {
                answer[j] = arr[j];
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] x = {1 ,3 , 2 ,5 ,8, -4, 9, 10, -1, -3};
        int[] result = solution(x);
        System.out.println(Arrays.toString(result));
    }
}

// 문제가 어렵지 않았지만 계속 제출하면 틀렸다고 나와 많은 시간을 소비함
// 배열의 순서가 바뀌면 안되는거였다... 조건이 딱히 안적혀있어서 신경안썼는데
// 신경썼으면 금방 풀 수 있는 문제...

// 라이브러리쓰면 쉽게 풀림
// 자바 라이브러리와 사용법을 많이 배워놓자 (속도가 for문 보다 느리다는 단점이....)
// public int[] solution(int[] arr) {
//      if (arr.length <= 1) return new int[]{ -1 };
//      int min = Arrays.stream(arr).min().getAsInt();
//      return Arrays.stream(arr).filter(i -> i != min).toArray();
//  }