/*
 * [예제 8-5] FileOutputStream으로 바이너리 파일 쓰기
 * FileOutputStream을 이용하여 byte [] 배열 속에 들어 있는 바이너리 값을 c:\Temp\test.out 파일에 저장한다.
 * 이 파일은 바이너리 파일이 되므로 메모장으로 볼 수 없다. 이 파일은 예제 8-6에서 FileInputStream을 이용하여 읽어 다시 출력한다.
 */

package Chapter8;
import java.io.*;

public class FileOutputStreamEx {
    public static void main(String[] args) {
        byte b[] = {7,51,3,4,-1,24};
        try {
            FileOutputStream fout = new FileOutputStream("c:\\Temp\\test.out");  // FileOutputStream 객체 생성
            for(int i=0; i<b.length; i++)
                fout.write(b[i]);   // 배열 b의 바이너리를 그대로 기록
            fout.close();
        } catch(IOException e) {
            System.out.println( "c:\\Temp\\test.out에 저장할 수 없었습니다. 경로명을 확인해 주세요");  // 파일 저장 실패
            return;
        }
        System.out.println("c:\\Temp\\test.out을 저장하였습니다.");  // 파일 저장 성공
    }
}
