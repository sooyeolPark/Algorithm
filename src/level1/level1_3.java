package level1;//행렬의 덧셈은 행과 열의 크기가 같은 두 행렬의 같은 행, 같은 열의 값을 서로 더한 결과가 됩니다.
// 2개의 행렬 arr1과 arr2를 입력받아, 행렬 덧셈의 결과를 반환하는 함수, solution을 완성해주세요.
// 행렬 arr1, arr2의 행과 열의 길이는 500을 넘지 않습니다.
import java.util.*;

public class level1_3 {
    public static int[][] solution(int[][] arr1, int[][] arr2) {
        //둘중 큰 row, col 결정
        int row = Math.max(arr1.length, arr2.length);
        int col = Math.max(arr1[0].length, arr2[0].length);
        int[][] answer = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] x = { { 1, 2 }, { 2, 3 } };
        int[][] y = { { 3, 4 }, { 5, 6 } };
        int[][] result = solution(x, y);
        System.out.println(Arrays.deepToString(result));
    }
}

// 그냥 할당해버리고 덮어씌우는 방법도 괜찮아 보인다.
//public int[][] solution(int[][] arr1, int[][] arr2) {
//    int[][] answer = {};
//    answer = arr1;
//    for(int i=0; i<arr1.length; i++){
//        for(int j=0; j<arr1[0].length; j++){
//            answer[i][j] += arr2[i][j];
//        }
//    }
//    return answer;
//}