package level1;//정수 배열 numbers가 주어집니다.
// numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는
// 모든 수를 배열에 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요.
//제한사항
//numbers의 길이는 2 이상 100 이하입니다.
//numbers의 모든 수는 0 이상 100 이하입니다.

import java.util.*;

public class level1_35 {
    public static int[] solution(int [] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i == j) {
                    continue;
                }
                list.add(numbers[i]+numbers[j]);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer i : list) {
            if (!result.contains(i)) {
                result.add(i);
            }
        }
        Collections.sort(result);
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = {2,1,3,4,1};
        int[] result = solution(a);
        System.out.println(Arrays.toString(result));
    }
}

// Set 인터페이스는 중복을 허용하지 않고, 순서가 유지되지 않는 컬렉션 클래스를 구현하는데 사용되는 인터페이스이다
// HashSet,  TreeSet는 Set 인터페이스를 구현하므로, 중복된 값은 저장하지 않고, 순서에 상관없이 저장한다.
// 차이점은 TreeSet는 기본적으로 오름차순으로 데이터를 정렬한다.
// TreeSet을 이용하면 중복과 정렬 둘다 수행할 수 있다.
//    public int[] solution(int[] numbers) {
//        Set<Integer> sumNumber = new TreeSet();
//
//        for(int i = 0; i < numbers.length-1; i++){
//            for(int j = i+1; j < numbers.length; j++){
//                sumNumber.add(numbers[i] + numbers[j]);
//            }
//        }
//
//        int[] answer = new int[sumNumber.size()];
//        int index = 0;
//        Iterator itor = sumNumber.iterator();
//        while(itor.hasNext()){
//            answer[index] = (int)itor.next();
//            index++;
//        }
//
//        return answer;
//    }