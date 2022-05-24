//주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다. 숫자들이 들어있는 배열 nums가 매개변수로 주어질 때, nums에 있는 숫자들 중 서로 다른 3개를 골라 더했을 때 소수가 되는 경우의 개수를 return 하도록 solution 함수를 완성해주세요.
//
//        제한사항
//        nums에 들어있는 숫자의 개수는 3개 이상 50개 이하입니다.
//        nums의 각 원소는 1 이상 1,000 이하의 자연수이며, 중복된 숫자가 들어있지 않습니다.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class level1_44 {
    public static int solution(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                for(int k = j + 1; k < nums.length; k++){
                    arr.add(nums[i] + nums[j] + nums[k]);
                }
            }
        }
        int answer = 0;
        for (Integer j : arr) {
            if (isPrime(j)) {
                answer++;
            }
        }
        return answer;
    }
    public static boolean isPrime(int n) {
        for (int i = 2; i<=(int)Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] a = {1,2,7,6,4};
        int result = solution(a);
        System.out.println(result);
    }
}

// 이건 다들 비슷한듯... 다만 세 값을 더하고 바로 계산해서 answer++하느냐 array에 담하서 for문을 한번 더 돌리느냐 차이