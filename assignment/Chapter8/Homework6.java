/*
 * [과제 6번] 텍스트 파일 읽기와 쓰기
 * 사용자로부터 두 개의 텍스트 파일 이름을 입력받고 첫 번째 파일 뒤에 두 번째 파일을 덧붙인 새로운 파일을 생성하는 프로그램을 작성한다.
 * 아래 실행 예시에서는 프로젝트 폴더에 elvis1.txt와 elvis2.txt를 미리 준비해두었다.
 */

package Chapter8;
import java.io.*;
import java.util.Scanner;

public class Homework6 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileReader fReader = null;
        FileWriter fWriter = null;

        System.out.println("전체 경로명이 아닌 파일 이름만 입력하는 경우, 파일은 프로젝트 폴더에 있어야 합니다.");

        System.out.print("첫번째 파일 이름을 입력하세요>>");
        String s1 = scanner.nextLine();  // 첫 번째 파일명 입력

        System.out.print("두번째 파일 이름을 입력하세요>>");
        String s2 = scanner.nextLine();  // 두 번째 파일명 입력
        try {
            fReader = new FileReader(s1);  // 첫번째 파일 스트림 열기
            fWriter = new FileWriter("appended.txt");  // 합치는 파일 일름
            writeToFile(fReader, fWriter);  // 첫번째 파일을 읽어 합치는 파일에 기록
            fReader.close();  //  첫번째 스트림 닫기

            fReader = new FileReader(s2);  // 두번째 스트림 열기
            writeToFile(fReader, fWriter);  // 두번째 파일을 읽어 합치는 파일에 연이어 기록

            fReader.close();
            fWriter.close();
            System.out.println("프로젝트 폴더 밑에 appended.txt 파일에 저장하였습니다.");
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다.");
        } catch (IOException e) {
            System.out.println("입출력 오류가 발생했습니다.");
        }
        scanner.close();
    }

    private static void writeToFile(FileReader in, FileWriter out) throws IOException {
        char buf[] = new char[100];  // 버퍼 크기 100 바이트
        int count = 0;  // count는 읽은 문자 개수. while 문에 처음 들어가기 위한 임시 값.
        while (true) {
            count = in.read(buf, 0, buf.length);  // buf[] 크기 만큼 읽기
            if(count == -1)
                break;  // 파일 끝에 도달함
            if (count > 0) {  // 읽은 것이 있다면
                out.write(buf, 0, count);  // 읽은 만큼 합치는 파일에 저장
            }
        }
    }
}
