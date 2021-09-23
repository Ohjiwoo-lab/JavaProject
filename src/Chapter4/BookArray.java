/*
 * [예제 4-7] 객체 배열 만들기 연습
 * 예제 4-4의 Book 클래스를 활용하여 2개짜리 BookEx 객체 배열을 만들고, 사용자로부터 책의 제목과 저자를 입력받아 배열을 완성한다.
 */

package Chapter4;
import java.util.Scanner;

class BookEx {
    String title, author;

    //생성자
    public BookEx(String title, String author){
        this.title = title;  //this.title은 클래스 BookEx의 멤버변수 title이다.
        this.author = author;  //this.author는 클래스 BookEx의 멤버변수 author이다.
    }
}

public class BookArray {
    public static void main(String[] args){
        BookEx[] book = new BookEx[2];  //BookEx 객체 배열

        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < book.length; i++){
            System.out.print("제목>> ");
            String title = scanner.nextLine();  //제목 입력받음

            System.out.print("저자>> ");
            String author = scanner.nextLine();  //저자 입력받음

            book[i] = new BookEx(title, author);  //배열 원소에 BookEx 객체를 생성한다.(title과 author를 매개변수로 보내어 멤버변수에 저장함)
        }

        for(int i = 0; i < book.length; i++)
            System.out.print("(" + book[i].title + ", " + book[i].author + ")");  //배열 원소의 객체의 멤버변수를 각각 출력한다.

        System.out.println();

        scanner.close();
    }
}
