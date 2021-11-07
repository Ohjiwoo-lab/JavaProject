/*
 * [과제 12번] Vector 컬렉션, 파일 입출력 실전 응용
 * 텍스트 파일에 있는 단어를 검색하는 프로그램을 작성해보자.
 * 실행 예시는 프로젝트 폴더 밑에 자신이 작성한 자바 파일(ex. Homework6.java)을 복사하여 두고 읽은 경우이다.
 */

package Chapter8;
import java.io.*;
import java.util.*;

public class Homework12 {
    private File targetFile = null;
    Vector<String> lineVector = new Vector<String>();

    public Homework12() { }  // 생성자

    private void readFile(String fileName) {
        targetFile = new File(fileName);
        try {
            Scanner fScanner = new Scanner(new FileReader(targetFile));
            while(fScanner.hasNext()) {  // 파일을 라인 단위로 모두 읽기
                String line = fScanner.nextLine();  // 한 라인 읽고
                lineVector.add(line);  // 한 라인을 벡터에 저장
            }
            fScanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Vector<Integer> searchWord(String word) {  // word가 포함된 라인 번호들을 벡터로 리턴
        Vector<Integer> noVector = new Vector<Integer>();
        for(int i=0; i<lineVector.size(); i++) {
            String line = lineVector.get(i);  // 문장을 받아와서 저장
            if(line.indexOf(word) != -1)
                noVector.add(i);
        }

        return noVector;
    }

    private void printLines(Vector<Integer> noVector) {
        for(int i=0; i<noVector.size(); i++) {
            int lineNo = noVector.get(i);
            String line = lineVector.get(lineNo);  // 문장을 받아와서 출력
            System.out.println(lineNo + ":" + line);
        }
    }

    public void run() {
        System.out.println("전체 경로명이 아닌 파일 이름만 입력하는 경우, 파일은 프로젝트 폴더에 있어야 합니다.");
        System.out.print("대상 파일명 입력>> ");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();  // 파일 이름을 입력받음

        readFile(fileName);  // 파일을 라인 단위로 벡터로 읽어들임

        while(true) {
            System.out.print("검색할 단어나 문장>> ");
            String line = scanner.nextLine();  // 검색할 단어나 문장을 입력받음
            if(line.equals("그만"))
                break;  // 프로그램 종료
            Vector<Integer> noVector = searchWord(line);  // line의 단어를 포함하는모든 라인 번호 리턴
            printLines(noVector);
        }
        scanner.close();
        System.out.println("프로그램을 종료합니다.");
    }
    public static void main(String[] args) {
        Homework12 ws = new Homework12();  // 객체 생성
        ws.run();
    }
}
