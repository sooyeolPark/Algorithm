// 정수를 담고 있는 배열 arr의 평균값을 return하는 함수, solution을 완성해보세요.

import java.util.Arrays;
import java.util.Scanner;

public class level1_6 {
    public static double solution(int[] arr) {
        double sum = 0;
        for (int x : arr) {
            sum += (double) x;
        }
        double answer = sum/arr.length;
        return answer;
    }
    public static void main(String[] args) {
        int[] x = {1, 2 , 2, 3 ,5};
        double result = solution(x);
        System.out.println(result);
    }
}

//1_5에서 본 for문 형식으로 해결
//js나 php에서 쓰던 foreach문이 생각나서 foreach문으로 해결하려고 찾아봤는데 저 형식이 foreach문이라고...