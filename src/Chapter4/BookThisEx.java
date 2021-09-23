/*
 * [예제 4-5] this()로 다른 생성자 호출
 * 예제 4-4에서 작성한 Book 클래스의 생성자를 this()를 이용하여 수정하는 프로그램을 작성한다.
 * this()는 클래스 내의 다른 생성자를 호출하는 데 사용될 수 있다. 생성자 내에서만 사용 가능하고, 코드의 제일 위에 위치해야한다.
 */

package Chapter4;

public class BookThisEx {
    String title;
    String author;

    //저자와 제목을 출력하는 메소드
    void show(){
        System.out.println(title + " : " + author);
    }

    //디폴트 생성자(이미 인자있는 생성자가 2개이기 때문에 디폴트 생성자를 만들지 않는다면, 오류가 발생한다)
    public BookThisEx(){
        this("", "");
        System.out.println("생성자 호출됨");
    }

    //인자가 1개인 생성자(this()로 인자가 2개인 생성자를 호출한다)
    public BookThisEx(String title){
        this(title, "작자미상");  //인자를 2개(title, "작자미상")을 this()에 배치함으로써, 인자 2개인 생성자의 매개변수 'title'에 title, author에 "작자미상"을 보낸다.
    }

    //인자 2개인 생성자
    public BookThisEx(String title, String author){
        this.title = title;  //객체의 title에 매개변수 title을 대입
        this.author = author;  //객체의 author에 매개변수 author를 대입
        /*
         * 여기서의 this는 객체 자신에 대한 레퍼런스이다. 객체의 멤버 변수와 메소드 변수의 이름이 같기 때문에 사용해야 한다.
         */
    }

    public static void main(String[] args){
        BookThisEx littlePrince = new BookThisEx("어린왕자", "생텍쥐페리");  //인자 2개인 생성자 호출
        BookThisEx loveStory = new BookThisEx("춘향전");  //인자 1개인 생성자 호출 -> 이 생성자에서 this()로 인자 2개인 생성자 호출
        BookThisEx emptyBook = new BookThisEx();  //디폴트 생성자 호출(디폴트 생성자가 없으면, 이 객체를 생성할 대 오류가 발생한다) -> 여기서 '생성자 호출됨'이 출력

        littlePrince.show();
        loveStory.show();
    }
}
