/*
 * [예제 8-1] FileReader로 텍스트 파일 읽기
 * FileReader를 이용하여 c:\windows\system.ini 파일을 읽어 화면에 출력하는 프로그램을 작성한다. system.ini는 텍스트 파일이다
 */

package Chapter8;
import java.io.*;

public class FileReaderEx {
    public static void main(String[] args){
        FileReader fin = null;
        try{
            fin = new FileReader("C:\\windows\\system.ini");  // FileReader 객체 생성

            int c;
            while((c=fin.read()) != -1){  // 한 문자씩 파일 끝까지 읽기(파일의 끝을 만나면 read()는 -1을 리턴)
                System.out.print((char)c);  // 한 문자씩 출력
            }
            fin.close();
        }
        catch(IOException e){
            System.out.println("입출력 오류");
        }
    }
}
