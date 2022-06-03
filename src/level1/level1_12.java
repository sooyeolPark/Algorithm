package level1;//함수 solution은 정수 n을 매개변수로 입력받습니다.
// n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요.
// 예를들어 n이 118372면 873211을 리턴하면 됩니다.
import java.util.*;

public class level1_12 {

    public static long solution(long x){
        char[] ch = Long.toString(x).toCharArray();
        Arrays.sort(ch);
        String answer = "";
        for(int i = ch.length-1; i>=0; i--) {
            answer += ch[i];
        }
        return Long.parseLong(answer);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextLong();
        long result = solution(x);
        System.out.println(result);
    }


}

//Arrays.sort(ch, Collections.reverseOrder());를 쓸려고했는데 컴파일 에러가 난다.
//그냥 어차피 FOR문 돌릴거 역순으로 돌리는 방법을 택함
//컴파일 에러의 이유는 sort에 Comparator에 T에는 기본 자료형이 들어가지 못 해서이다.
// Integer type이나 String type 등으로 배열을 선언하셔서 사용하시면 된다! 그래서 toCharArray는 안되고 .split()은 되는 이유
//이렇게 하면 된다.
//public long solution(long n) {
//    String[] list = String.valueOf(n).split("");
//    Arrays.sort(list, Collections.reverseOrder());
//    String answer = "";
//    for(String s : list) {
//        answer += s;
//    }
//    return Long.parseLong(answer);
//}