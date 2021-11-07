/*
 * [과제 10번] HashMap 컬렉션, 파일 입출력 실전 응용
 * 전화번호를 미리 c:\temp\phone.txt 파일에 여러 개 저장해둔다. 이 파일을 읽어 다음 실행 예시와 같이 동작하는 검색 프로그램을 작성한다.
 */

package Chapter8;
import java.io.*;
import java.util.*;

public class Homework10 {
    private String fileName = "c:\\temp\\phone.txt";
    private HashMap<String, String> phoneMap = new HashMap<String, String>();

    public Homework10() { }  // 생성자(아무일도 하지는 않는다)

    private void readPhoneFile() {
        try {
            Scanner fScanner = new Scanner(new FileReader(new File(fileName)));
            while(fScanner.hasNext()) {
                String name = fScanner.next();  // 이름 읽기
                String tel = fScanner.next();  // 전화번호 읽기
                phoneMap.put(name, tel);  // 해시맵에 저장
            }
            fScanner.close();
        }
        catch (IOException e) { // 파일을 저장할 수 없는 경우 예외
            e.printStackTrace();
        }
        System.out.println("총 " + phoneMap.size() + "개의 전화번호를 읽었습니다.");
    }

    private void processQuery() {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.print("이름>> ");
            String name = scanner.next();  // 이름을 입력받음
            if(name.equals("그만"))  // 그만이 입력되면 종료
                break;
            String tel = phoneMap.get(name);  // 이름에 해당하는 전화번호를 가져옴
            if(tel == null) {  // 전화번호가 없으면 해당 이름의 사람이 존재하지 않는 것.
                System.out.println("찾는 이름이 없습니다.");
            }
            else{  // 전화번호 출력
                System.out.println(tel);
            }
        }
        scanner.close();
    }

    public void run() {
        readPhoneFile();
        processQuery();
    }

    public static void main(String[] args) {
        Homework10 phoneExplorer = new Homework10();  // 객체 생성
        phoneExplorer.run();  // 실행
    }
}
