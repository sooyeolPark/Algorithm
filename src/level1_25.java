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

public class level1_25 {
    public static String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        Arrays.sort(strings);

        for(int i = 0; i < strings.length; i++) {
            answer[i] = strings[i];
            for(int j = i+1; j < strings.length; j++) {
                if(strings[i].charAt(n) > strings[j].charAt(n)) {
                    answer[i] = strings[j];
                    strings[j] = strings[i];
                    strings[i] = answer[i];
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] x = {};
        int n = 2;
        boolean result = solution(x, n);
        System.out.println(result);
    }
}

//public static void sort ( T[] a, Comparator<? super T> c )</b>
//인자 값으로 객체를 받으며, 지정된 Comparator가 가리키는 순서에 따라 지정된 객체의 배열을 정렬한다
// 위에 걸 쓰면 sort함수만으로 쉽게 가능
//  public String[] solution(String[] strings, int n) {
//      Arrays.sort(strings, new Comparator<String>(){
//          @Override
//          public int compare(String s1, String s2){
//              if(s1.charAt(n) > s2.charAt(n)) return 1;
//              else if(s1.charAt(n) == s2.charAt(n)) return s1.compareTo(s2);
//              else if(s1.charAt(n) < s2.charAt(n)) return -1;
//              else return 0;
//          }
//      });
//      return strings;
//  }