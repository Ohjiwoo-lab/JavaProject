/*
 * [과제 8번] 고객의 이름과 포인트 점수를 관리하는 프로그램을 해시맵을 이용하여 작성한다.
 * 프로그램은 고객의 이름과 포인트를 함께 저장, 관리하는데, 포인트는 추가될 때마다 누적하여 저장된다.
 */

package Chapter7;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Homework8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Scanner 객체 생성
        HashMap<String, Integer> manage = new HashMap<String, Integer>();  // 해시맵 생성

        System.out.println("** 포인트 관리 프로그램입니다 **");
        while(true) {
            System.out.print("이름과 포인트 입력 >> ");
            String name = scanner.next();  // 이름을 입력받음

            if(name.equals("그만"))  // '그만'이 입력되면 break로 while문을 빠져나간다.
                break;

            int point = scanner.nextInt();  // 정수를 입력받음(포인트)
            if(manage.get(name) == null) {  // 존재하지 않은 이름이라면
                manage.put(name, point);  // 이름과 포인트를 추가한다.
            }
            else {  // 이미 HashMap에 존재하는 이름이라면
                manage.put(name,  manage.get(name) + point);  // 해당 이름에 포인트를 더하여 업데이트한다.
            }

            Set<String> key = manage.keySet();  // HashMap의 모든 Key를 담은 컬렉션을 리턴한다.
            Iterator<String> it = key.iterator();  // Iterator 생성

            while(it.hasNext()) {  // Iterator가 다음을 가리키도록 한다. null이 되면 종료
                String people = it.next();  // Iterator가 가리키는 원소를 가져온다.(사람 이름)
                Integer sum = manage.get(people);  // 가져온 사람 이름에 대한 포인트도 가져온다.
                System.out.print("(" + people + "," + sum + ")");  // 가져온 이름과 포인트를 출력한다.
            }
            System.out.println();
        }
        scanner.close();
    }
}
