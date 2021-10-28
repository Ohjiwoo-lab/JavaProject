/*
 * [예제 7-7] HashMap에 객체 저장, 학생 정보 관리
 * id와 전화번호로 구성되는 Student 클래스를 만들고, 이름을 '키'로 하고, Student 객체를 '값'으로 하는 해시맵을 작성한다.
 */

package Chapter7;
import java.util.*;

// 학생을 표현하는 클래스
class Student {
    private int id;
    private String tel;

    // 인자 있는 생성자
    public Student(int id, String tel) {
        this.id = id;
        this.tel = tel;
    }

    // private 멤버 변수를 리턴해주는 메소드
    public int getId(){
        return id;
    }
    public String getTel(){
        return tel;
    }
}

public class HashMapStudentEx {
    public static void main(String[] args) {
        HashMap<String, Student> map = new HashMap<String, Student>();  // 학생 이름과 Student 객체를 쌍으로 저장하는 HashMap 컬렉션 생성

        // 3 명의 학생에 대한 정보를 저장
        map.put("황기태", new Student(1, "010-111-1111"));
        map.put("이재문", new Student(2, "010-222-2222"));
        map.put("김남윤", new Student(3, "010-333-3333"));

        Scanner scanner = new Scanner(System.in);  // Scanner 객체 생성
        while(true) {
            System.out.print("검색할 이름?");
            String name = scanner.nextLine(); // 사용자로부터 이름 입력
            if(name.equals("exit"))  // exit을 입력하면
                break;   // while 문을 벗어나 프로그램 종료
            Student student = map.get(name); // 이름에 해당하는 Student 객체 검색
            if(student == null)  // 객체를 검색했을 때 null을 리턴한다면, 없는 사람이라는 의미이다.
                System.out.println(name + "은 없는 사람입니다.");
            else
                System.out.println("id:" + student.getId() + ", 전화:" + student.getTel());  // id와 전화번호 출력
        }
        scanner.close();
    }
}
