/*
 * [예제 8-2] InputStreamReader로 한글 텍스트 파일 읽기
 * InputStreamReader를 이용하여 MS949 문자 집합으로 한글 텍스트 파일을 읽고 출력한다.
 * -> MS949는 한글이 깨져서 UTF 문자 집합으로 변경
 */

package Chapter8;
import java.io.*;

public class FileReadHangulSuccess {
    public static void main(String[] args) {
        InputStreamReader in = null;
        FileInputStream fin = null;
        try {
            fin = new FileInputStream("c:\\Temp\\hangul.txt");  // FileInputStream 객체 생성
            in = new InputStreamReader(fin, "UTF-8");  // InputStreamReader 객체 생성('MS949'는 한글이 깨져서 나와서 UTF-8로 변경하였습니다.)

            int c;
            System.out.println("인코딩 문자 집합은 " + in.getEncoding());  // 사용한 문자 집합 출력
            while ((c = in.read()) != -1) {  // read()가 -1을 리턴하면 파일의 끝이라는 뜻
                System.out.print((char)c);  // 문자 출력
            }
            in.close();
            fin.close();
        } catch (IOException e) {
            System.out.println("입출력 오류");
        }
    }
}
