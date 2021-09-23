/*
 * [예제 4-4] 생성자 선언 및 활용
 * 제목을 나타내는 title과 저자를 나타내는 author 필드를 가진 Book 클래스를 작성하고, 생성자를 작성하여 필드를 초기화한다.
 */

package Chapter4;

public class Book {
    String title;  //제목
    String author;  //저자

    //생성자1(작가를 누군지 모르는 경우)
    public Book(String t){
        title = t;
        author = "작자미상";
    }

    //생성자2(제목과 작가를 둘 다 아는 경우)
    public Book(String t, String a){
        title = t;
        author = a;
    }

    public static void main(String[] args){
        Book littlePrince = new Book("어린왕자", "생텍쥐페리");  //생성자2를 호출하는 객체 생성(title과 author가 각각 '어린왕자'와 '생텍쥐페리'로 초기화된다)
        Book loveStory = new Book("춘향전");  //생성자1을 호출하는 객체 생성(title은 '춘향전'으로 초기화되며, author는 자동으로 '작자미상'이 된다)

        System.out.println(littlePrince.title + " : " + littlePrince.author);
        System.out.println(loveStory.title + " : " + loveStory.author);
    }
}
