/*
 * [예제 7-3] 문자열을 입력받아 ArrayList에 저장하는 프로그램
 * 이름을 4개 입력받아 ArrayList에 저장하고 모두 출력한 후 제일 긴 이름을 출력한다.
 */

package Chapter7;
import java.util.*;

public class ArrayListEx {
    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<String>();  // 문자열만 삽입가능한 ArrayList 컬렉션 생성
        Scanner scanner = new Scanner(System.in);  // Scanner 클래스 객체 생성

        // 키보드로부터 4개의 이름 입력받아 ArrayList에 삽입
        for (int i = 0; i < 4; i++) {
            System.out.print("이름을 입력하세요>>");
            String s = scanner.next(); // 키보드로부터 이름 입력
            a.add(s); // ArrayList 컬렉션에 삽입
        }

        // ArrayList에 들어 있는 모든 이름 출력
        for (int i = 0; i < a.size(); i++) {
            String name = a.get(i);  // ArrayList의 i 번째 문자열 얻어오기
            System.out.print(name + " ");  // 입력받은 이름 출력
        }

        // 가장 긴 이름 출력
        int longestIndex = 0;
        for (int i = 1; i < a.size(); i++) {
            if (a.get(longestIndex).length() < a.get(i).length())
                longestIndex = i;  // 가장 긴 이름을 저장하고 있는 인덱스를 longestIndex에 저장한다.
        }
        System.out.println("\n가장 긴 이름은 : " + a.get(longestIndex));  // 가장 긴 이름을 저장하고 있는 인덱스의 요소를 가져와서 출력한다.
        scanner.close();
    }
}

