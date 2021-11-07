/*
 * [예제 8-11] 블록 단위로 바이너리 파일 고속 복사
 * 예제 8-10을 10KB 단위로 읽고 쓰도록 수정하여 고속으로 파일을 복사하는 코드를 작성한다.
 */

package Chapter8;
import java.io.*;

public class BlockBinaryCopyEx {
    public static void main(String[] args) {
        File src = new File("c:\\Windows\\Web\\Wallpaper\\Theme1\\img1.jpg");  // 원본 파일 경로
        File dest = new File("c:\\Temp\\desert.jpg");  // 복사할 이미지 경로
        try {
            FileInputStream fi = new FileInputStream(src);
            FileOutputStream fo = new FileOutputStream(dest);
            byte [] buf = new byte [1024*10];  // 10KB 버퍼

            long beforeTime = System.currentTimeMillis();  // 파일 읽어오기 전 시간

            while(true) {
                int n = fi.read(buf);  // 버퍼 크기만큼 읽기. n은 실제 읽은 바이트
                fo.write(buf, 0, n);  // buf[0]부터 n 바이트 쓰기
                if(n < buf.length)
                    break;
            }

            long afterTime = System.currentTimeMillis();  // 파일 읽어온 후 시간

            fi.close();
            fo.close();

            long secDiffTime = (afterTime - beforeTime)/1000;  // 파일을 읽어오는 데 걸린 시간
            System.out.println( src.getPath() + "를 " + dest.getPath() + "로 복사하였습니다.");
            System.out.println("걸린 시간(s) : "+secDiffTime);
        } catch (IOException e) {
            System.out.println("파일 복사 오류");
        }
    }
}
