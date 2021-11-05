/*
 * [예제 8-3] 한글 텍스트 파일 읽기(문자 집합 지정이 잘못된 경우)
 * InputStreamReader의 문자 집합을 US-ASCII로 지정하여 한글 파일을 읽고 출력한다.
 */

package Chapter8;
import java.io.*;

public class FileReadHangulFail {
    public static void main(String[] args) {
        InputStreamReader in = null;
        FileInputStream fin = null;
        try {
            fin = new FileInputStream("c:\\Temp\\hangul.txt");
            in = new InputStreamReader(fin, "US-ASCII");  // 문자 집합 지정이 잘못된 경우의 예를 보이기 위해 일부러 틀린 문자 집합 지정
            int c;
            System.out.println("인코딩 문자 집합은 " + in.getEncoding());
            while ((c = in.read()) != -1) {
                System.out.print((char)c);  // 문자 집합 지정이 잘못되어 읽은 문자가 제대로 인식되지 못한다. 결론적으로 출력 결과가 깨지게 나온다.
            }
            in.close();
            fin.close();
        } catch (IOException e) {
            System.out.println("입출력 오류");
        }
    }
}
