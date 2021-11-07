/*
 * [과제 8번] File 클래스로 파일 리스트, 파일 크기 알아내기
 * File 클래스를 이용하여 c:\에 있는 파일 중에서 제일 큰 파일의 이름과 크기를 출력한다.
 */

package Chapter8;
import java.io.*;

public class Homework8 {
    public static void main(String[] args) {
        File file = new File("c:\\");
        File [] files = file.listFiles();  // c:\에 있는 디렉터리와 파일의 리스트 얻기

        long bigSize = 0;
        File bigFile =null;
        for(int i=0; i<files.length; i++) {  // 전체 파일에 대해
            File f = files[i];
            if(!f.isFile())  // 디렉터리인 경우 넘어감
                continue;

            long size = f.length();  // 파일인 경우 길이 얻어내기
            if(bigSize < size) {  // size가 더 큰 파일로 bigSize와 bigFile을 교체
                bigSize = size;
                bigFile = f;
            }
        }

        if(bigFile == null)  // 모두 디렉터리인 경우
            System.out.println("파일은 없습니다");
        else
            System.out.println("가장 큰 파일은 " + bigFile.getPath() + " " + bigSize + "바이트");
    }

}
