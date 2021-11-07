/*
 * [과제 2번] BufferedReader로 텍스트 파일 읽기
 * Scanner로 입력받은 이름과 전화번호를 한 줄에 한 사람씩 c:\temp\phone.txt 파일에 저장한 뒤, 그 파일을 다시 열어 화면에 출력한다.
 * '그만'이라고 입력받으면 종료한다.
 */

package Chapter8;
import java.io.*;
import java.util.Scanner;

class PhoneWriterEx {
    public void insertProgram() {
        FileWriter fileWriter = null;
        File f = new File("c:\\temp\\phone.txt");
        try {
            fileWriter = new FileWriter(f);
            Scanner scanner = new Scanner(System.in);

            System.out.println("전화번호 입력 프로그램입니다.");
            while(true) {
                System.out.print("이름 전화번호 >> ");
                String line = scanner.nextLine();   // 한 줄을 입력받는다.(이름 전화번호)
                if(line.equals("그만"))
                    break;   // 입력 종료
                fileWriter.write(line+"\r\n");  // 한 줄 띄어 저장하기 위해 "\r\n"을 붙인다.
            }
            System.out.println(f.getPath()+"에 저장하였습니다.");

            scanner.close();
            fileWriter.close();
        }
        catch (IOException e) { // 파일을 저장할 수 없는 경우 예외
            e.printStackTrace();
        }
    }
}

public class Homework2 {
    public static void main(String[] args) {
        PhoneWriterEx writerEx = new PhoneWriterEx();
        writerEx.insertProgram();  // phone.txt 파일에 입력받은 값 저장

        BufferedReader fileReader = null;
        File f = new File("c:\\temp\\phone.txt");
        try {
            fileReader = new BufferedReader(new FileReader(f));
            System.out.println("\n" + f.getPath() + "를 출력합니다.");
            while(true) {
                String line = fileReader.readLine();  // readLine()으로 파일을 한 줄 씩 읽어들인다.
                if(line == null)  // 파일의 끝으로 가면 종료한다.
                    break;
                System.out.print(line+"\n");  // 읽어들인 것 출력
            }
            fileReader.close();
        }
        catch (IOException e) { // 파일을 저장할 수 없는 경우 예외
            e.printStackTrace();
        }
    }
}
