/*
 * [예제 8-10] 바이너리 파일 복사
 * 바이트 스트림을 이용하여 바이너리 파일을 복사하는 프로그램을 작성한다.
 */

package Chapter8;
import java.io.*;

public class BinaryCopyEx {
    public static void main(String[] args) {
        File src = new File("c:\\Windows\\Web\\Wallpaper\\Theme1\\img1.jpg");  // 원본 이미지 경로
        File dest = new File("c:\\Temp\\copyimg.jpg");  // 복사할 이미지 경로
        int c;
        try {
            FileInputStream fi = new FileInputStream(src);
            FileOutputStream fo = new FileOutputStream(dest);

            long beforeTime = System.currentTimeMillis();  // 파일 읽어오기 전 시간

            while((c = fi.read()) != -1) {  // 숫자를 하나씩 읽어서(바이너리 파일이므로 문자가 아닌 수)
                fo.write((byte)c);  // 읽은 숫자를 하나씩 쓴다.
            }

            long afterTime = System.currentTimeMillis();  // 파일 읽어온 후 시간

            fi.close();
            fo.close();

            long secDiffTime = (afterTime - beforeTime)/1000;  // 파일을 읽어오는 데 걸린 시간
            System.out.println(src.getPath()+ "를 " + dest.getPath()+ "로 복사하였습니다.");
            System.out.println("걸린 시간(s) : "+secDiffTime);
        } catch (IOException e) {
            System.out.println("파일 복사 오류");
        }
    }
}
