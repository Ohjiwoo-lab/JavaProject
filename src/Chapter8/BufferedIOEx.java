/*
 * [예제 8-7] 버퍼 스트림을 이용한 출력
 * 버퍼 크기를 5로 하고, 표준 출력 스트림(System.out)과 연결한 버퍼 출력 스트림을 생성하라. c:\Temp\test2.txt 파일을 저장된 영문 텍스트를 읽어 버퍼 출력 스트림을 통해 출력한다.
 */

package Chapter8;
import java.io.*;
import java.util.Scanner;

public class BufferedIOEx {
    public static void main(String[] args) {
        FileReader fin = null;
        int c;
        try {
            fin = new FileReader("c:\\Temp\\test2.txt");  // 저장한 test2 파일을 읽어온다.
            BufferedOutputStream out = new BufferedOutputStream(System.out, 5);
            while ((c = fin.read()) != -1) {  // 파일의 끝까지 읽음
                out.write(c);  // 버퍼가 꽉 찰 때 문자가 화면에 출력된다.
            }

            // 파일 데이터가 모두 출력된 상태(하지만 버퍼의 크기가 5여서 8개의 문자 중 3개의 문자는 버퍼에 남아있다. 화면에도 출력되지 않는다.)
            new Scanner(System.in).nextLine();  // Enter 키를 기다린다.
            out.flush(); // 버퍼에 남아 있던 문자 모두 출력(Enter키를 입력받으면 버퍼에 남아있던 나머지 3개의 문자를 모두 출력한다.)
            fin.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
