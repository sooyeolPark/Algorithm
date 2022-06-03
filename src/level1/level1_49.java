package level1;//스마트폰 전화 키패드의 각 칸에 다음과 같이 숫자들이 적혀 있습니다.

//        이 전화 키패드에서 왼손과 오른손의 엄지손가락만을 이용해서 숫자만을 입력하려고 합니다.
//        맨 처음 왼손 엄지손가락은 * 키패드에 오른손 엄지손가락은 # 키패드 위치에서 시작하며, 엄지손가락을 사용하는 규칙은 다음과 같습니다.
//
//        엄지손가락은 상하좌우 4가지 방향으로만 이동할 수 있으며 키패드 이동 한 칸은 거리로 1에 해당합니다.
//        왼쪽 열의 3개의 숫자 1, 4, 7을 입력할 때는 왼손 엄지손가락을 사용합니다.
//        오른쪽 열의 3개의 숫자 3, 6, 9를 입력할 때는 오른손 엄지손가락을 사용합니다.
//        가운데 열의 4개의 숫자 2, 5, 8, 0을 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용합니다.
//        4-1. 만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용합니다.
//        순서대로 누를 번호가 담긴 배열 numbers, 왼손잡이인지 오른손잡이인 지를 나타내는 문자열 hand가 매개변수로 주어질 때, 각 번호를 누른 엄지손가락이 왼손인 지 오른손인 지를 나타내는 연속된 문자열 형태로 return 하도록 solution 함수를 완성해주세요.
//
//        [제한사항]
//        numbers 배열의 크기는 1 이상 1,000 이하입니다.
//        numbers 배열 원소의 값은 0 이상 9 이하인 정수입니다.
//        hand는 "left" 또는 "right" 입니다.
//        "left"는 왼손잡이, "right"는 오른손잡이를 의미합니다.
//        왼손 엄지손가락을 사용한 경우는 L, 오른손 엄지손가락을 사용한 경우는 R을 순서대로 이어붙여 문자열 형태로 return 해주세요.

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.IntStream;

public class level1_49 {
    public static String solution(int[] numbers, String hand) {
        String answer = "";
        int[] leftSection = {1,4,7,10};
        int[] rightSection = {3,6,9,12};
        int[] commonSection = {2,5,8,11};
        int prevRHand = 12;
        int prevLHand = 10;
        for (int i = 0; i < numbers.length; i++) {
            int number;
            if (numbers[i]==0) {
                number = 11;
            } else {
                number = numbers[i];
            }
            if (IntStream.of(leftSection).anyMatch(x -> x == number)) {
                answer+= "L";
                prevLHand = number;
            } else if (IntStream.of(rightSection).anyMatch(x -> x == number)) {
                answer+= "R";
                prevRHand = number;
            } else {
                int distanceRight = Math.abs(prevRHand-number)/3 +Math.abs(prevRHand-number)%3;
                int distanceLight = Math.abs(prevLHand-number)/3 +Math.abs(prevLHand-number)%3;
                if (distanceLight<distanceRight) {
                    answer+= "L";
                    prevLHand = number;
                } else if (distanceLight>distanceRight) {
                    answer+= "R";
                    prevRHand = number;
                } else if (distanceLight==distanceRight) {
                    if(hand.equals("left")) {
                        answer+= "L";
                        prevLHand = number;
                    } else {
                        answer+= "R";
                        prevRHand = number;
                    }
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] number = {1,3,4,5,8,2,1,4,5,9,5};
        String result = solution(number, "right");
        System.out.println(result);
    }
}

// 전에 누른 손과의 거리 구하는 방식만 정한다면 금방 풀 수 있는 문제