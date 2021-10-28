/*
 * [예제 7-6] HashMap을 이용하여 자바 과목의 이름과 점수를 관리한다.
 * 해시맵을 이용하여 학생의 이름과 자바 점수를 기록, 관리하는 프로그램을 작성한다.
 */

package Chapter7;
import java.util.*;

public class HashMapScoreEx {
    public static void main(String[] args) {
        HashMap<String, Integer> javaScore = new HashMap<String, Integer>();  // 사용자 이름과 점수를 기록하는 HashMap 컬렉션 생성

        // 5명의 학생에 대한 5개의 점수를 저장
        javaScore.put("김성동", 97);
        javaScore.put("황기태", 88);
        javaScore.put("김남윤", 98);
        javaScore.put("이재문", 70);
        javaScore.put("한원선", 99);
        System.out.println("HashMap의 요소 개수 : " + javaScore.size());  // 요소 개수 출력 : 5

        Set<String> keys = javaScore.keySet();  // key 문자열을 가진 집합 Set 컬렉션 리턴
        Iterator<String> it = keys.iterator();  // key 문자열을 순서대로 접근할 수 있는 Iterator 리턴

        // javaScore에 들어 있는 모든 (key, value) 쌍 출력하여 모든 사람의 자바 점수를 출력한다.
        while(it.hasNext()) {  // Iterator it을 다음으로 이동해가면서 null이 아닐 때까지 반복(모든 사람에 대하여 반복)
            String name = it.next();  // Iterator가 가리키고 있는 요소를 리턴
            int score = javaScore.get(name);  // 이름에 해당하는 점수를 리턴
            System.out.println(name + " : " + score);  // 이름과 점수 출력
        }
    }
}