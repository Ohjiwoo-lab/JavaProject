/*
 * [예제 7-5] HashMap을 이용하여 (영어, 한글) 단어 쌍을 저장하고 검색하는 프로그램을 작성한다.
 * (영어, 한글) 단어를 쌍으로 해시맵에 저장하고 영어로 한글을 검색하는 프로그램을 작성한다. "exit"이 입력되면 프로그램을 종료한다.
 */

package Chapter7;
import java.util.*;

public class HashMapDicEx {
    public static void main(String[] args) {
        HashMap<String, String> dic = new HashMap<String, String>();  // 영어 단어와 한글 단어의 쌍을 저장하는 HashMap 컬렉션 생성

        // 3 개의 (key, value) 쌍을 dic에 저장
        dic.put("baby", "아기");  // "baby"는 key, "아기"은 value
        dic.put("love", "사랑");  // "love"는 key, "사랑"은 value
        dic.put("apple", "사과");  // "apple"는 key, "사과"는 value

        // 영어 단어를 Scanner 객체를 이용해 입력받고 한글 단어 검색. "exit" 입력받으면 종료
        Scanner scanner = new Scanner(System.in);  // Scanner 객체 생성
        while(true) {
            System.out.print("찾고 싶은 단어는?");
            String eng = scanner.next();  // 영어 단어를 입력받음
            if(eng.equals("exit")) {  // 만약 입력받은 것이 exit 이면 프로그램을 종료
                System.out.println("종료합니다...");
                break;
            }

            String kor = dic.get(eng);  // 해시맵 객체 dic에서 '키' eng를 이용하여 '값' kor를 검색
            if(kor == null)  // kor가 null이라는 것은 '키' eng에 해당하는 '값' kor가 없다는 말이다.
                System.out.println(eng + "는 없는 단어 입니다.");
            else  // kor가 있다면
                System.out.println(kor);  // kor를 출력
        }
        scanner.close();
    }
}