/*
 * [예제 7-8] Collections 클래스의 활용
 * Collections 클래스를 활용하여 문자열 정렬, 반대로 정렬, 이진 검색 등을 실행하는 사례를 살펴본다.
 */

package Chapter7;
import java.util.*;

public class CollectionsEx {
    // 연결 리스트를 출력해주는 메소드
    static void printList(LinkedList<String> l) {
        Iterator<String> iterator = l.iterator();  // Iterator<String> 생성
        while (iterator.hasNext()) {  // 다음으로 Iterator를 이동시킴. null이 되면 종료
            String e = iterator.next();  // Iterator가 가리키는 곳의 값을 가져옴
            String separator;
            if (iterator.hasNext())
                separator = "->";  // 요소가 마지막이 아니라면 '->'로 리스트를 구분해줌
            else
                separator = "\n";  // 요소가 마지막이라면 '->' 출력하지 않고 줄을 바꿔준다.
            System.out.print(e + separator);
        }
    }

    // 메인 메소드
    public static void main(String[] args) {
        LinkedList<String> myList = new LinkedList<String>();  // 연결리스트 생성

        // 요소들 추가
        myList.add("트랜스포머");
        myList.add("스타워즈");
        myList.add("매트릭스");
        myList.add(0,"터미네이터");
        myList.add(2,"아바타");

        Collections.sort(myList);  // 요소 정렬
        printList(myList);  // 정렬된 요소 출력

        Collections.reverse(myList);  // 요소의 순서를 반대로 정렬
        printList(myList);  // 반대로 정렬된 요소 출력

        // 아바타가 들어있는 요소를 받아옴(실제 인덱스 값과 몇 번째 요소인가는 차이가 있으므로 1을 더해준다)
        int index = Collections.binarySearch(myList, "아바타") + 1;
        System.out.println("아바타는 " + index + "번째 요소입니다.");  // 해당 인덱스의 요소를 출력
    }
}
