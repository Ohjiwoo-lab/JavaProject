/*
 * [예제 8-4] 키보드 입력을 파일로 저장하기
 * Scanner를 이용하여 키보드에서 입력받은 데이터를 c:\Temp\test.txt 파일에 저장하는 프로그램을 작성한다.
 */

package Chapter8;
import java.io.*;
import java.util.*;

public class FileWriterEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Scanner 객체 생성
        FileWriter fout = null;
        int c;
        try {
            fout = new FileWriter("c:\\Temp\\test.txt");  // FileWriter 객체 생성
            while(true) {
                String line = scanner.nextLine();  // 파일에 저장할 글 입력받음
                if(line.length() == 0)  // 입력이 없으면 저장하지 않음(Enter만 입력되면 종료)
                    break;
                fout.write(line, 0, line.length());  // 파일에 입력받은 글 저장
                fout.write("\r\n", 0, 2);  // 한 줄 띄우기 위해 \r\n을 파일에 저장
            }
            fout.close();
        } catch (IOException e) {
            System.out.println("입출력 오류");
        }
        scanner.close();
    }
}
