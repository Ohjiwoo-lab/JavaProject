/*
 * [과제 4번] 텍스트 파일 읽기, Scanner와 FileReader의 연결 연습
 * c:\windows\system.ini 파일에 라인 번호를 붙여 출력한다.
 */

package Chapter8;
import java.io.*;
import java.util.Scanner;

public class Homework4 {
    public static void main(String[] args){
        System.out.println("c:\\windows\\system.ini 파일을 읽어 출력합니다.");
        try {
            Scanner fScanner = new Scanner(new FileReader("c:\\windows\\system.ini"));  // 파일로부터 읽기 위한 목적
            int lineNumber = 1;  // 출력할 라인번호
            while(fScanner.hasNext()) {  // 파일에 읽을 것이 있는 동안
                String line = fScanner.nextLine();  // 읽어와서
                System.out.printf("%4d", lineNumber++); // 행번호 출력
                System.out.println(": "+line);  // 읽어온 것 출력
            }
            fScanner.close();
        } catch (IOException e) {
            System.out.println("입출력 오류가 발생했습니다.");
        }
    }
}
