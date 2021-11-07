/*
 * [예제 8-8] File 클래스 활용한 파일 관리
 * File 클래스는 파일의 경로명을 다루는 클래스이다. 파일과 디렉토리 경로명의 추상적 표현이다.
 * File 클래스를 이용하여 파일의 타입을 알아내고, 디렉터리에 있는 파일들을 나열하며, 디렉터리 이름을 변경하는 프로그램을 작성해본다.
 */

package Chapter8;
import java.io.File;

public class FileEx {
    public static void listDirectory(File dir) {
        System.out.println("-----" + dir.getPath() + "의 서브 리스트 입니다.-----");  // 파일의 경로명
        File[] subFiles = dir.listFiles();  // 파일 dir 및 서브디렉토리 리스트 얻기

        for(int i=0; i<subFiles.length; i++) {
            File f = subFiles[i];
            long t = f.lastModified();  // 가장 마지막으로 수정된 날짜
            System.out.print(f.getName());  // 파일의 이름
            System.out.print("\t파일 크기: " + f.length());
            System.out.printf("\t수정한 시간: %tb %td %ta %tT\n",t, t, t, t);
        }
    }

    public static void main(String[] args) {
        File f1 = new File("c:\\windows\\system.ini");
        System.out.println(f1.getPath() + ", " + f1.getParent() + ", " + f1.getName());

        // 지정한 system.ini 파일의 종류 알아내기
        String res="";
        if(f1.isFile())
            res = "파일";
        else if(f1.isDirectory())
            res = "디렉토리";
        System.out.println(f1.getPath() + "은 " + res + "입니다.");

        File f2 = new File("c:\\Temp\\java_sample");
        if(!f2.exists()) {
            f2.mkdir();  // 존재하지 않으면 디렉토리 생성
        }
        listDirectory(new File("c:\\Temp"));
        f2.renameTo(new File("c:\\Temp\\javasample"));
        listDirectory(new File("c:\\Temp"));
    }
}
