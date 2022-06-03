package level1;//0부터 9까지의 숫자 중 일부가 들어있는 정수 배열 numbers가 매개변수로 주어집니다.
//numbers에서 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 더한 수를 return 하도록 solution 함수를 완성해주세요.

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class level1_48 {
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer>[] stackArr = new Stack[board[0].length];
        for (int j = 0; j < board[0].length; j++) {
            Stack<Integer> tmp = new Stack<Integer>();
            for (int i = board.length - 1; i >= 0; i--) {
                if (board[i][j] != 0) {
                    tmp.push(board[i][j]);
                }
            }
            stackArr[j] = tmp;
        }
        Stack<Integer> answerStack = new Stack<Integer>();
        for (int k = 0; k < moves.length; k++) {
            if (stackArr[moves[k]-1].empty()) {
                continue;
            }
            int a = stackArr[moves[k]-1].pop();
            if (answerStack.empty() == true) {
                answerStack.push(a);
            } else {
                if(answerStack.peek() == a) {
                    answer += 2;
                    answerStack.pop();
                } else {
                    answerStack.push(a);
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [][] a = {{0,0,0,0,0}, {0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2}, {3,5,1,3,1}};
        int [] b = {1,5,3,5,1,2,1,4};
        int result = solution(a, b);
        System.out.println(result);
    }
}

// 스택으로 푸는 문제임
// 다만 따로 스택 array를 안만들고 푼 사람이 있었음
// move 배열로만 for문 돌려서 해당 배열의 값을 가져와서 answerStack에 넣고
// 해당 값을 0으로 바꿔주는 식임