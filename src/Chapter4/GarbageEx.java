/*
 * [예제 4-9] 가비지의 발생
 * 다음의 코드를 작성하면서 언제 가비지가 발생하는 지 설명한다.
 */

package Chapter4;

public class GarbageEx {
    public static void main(String[] args){
        String a = new String("Good");  //객체 a 생성
        String b = new String("Bad");  //객체 b 생성
        String c = new String("Normal");  //객체 c 생성

        String d, e;  //객체 d, e 선언
        a = null;  //a에 null 값을 넣어서 "Good"을 가리키던 포인터가 해제(a 가비지 발생)
        d = c;  //d에 c를 대입함으로써 c는 아무것도 가리키지 않게 됨(c 가바지 발생)
        c = null;  //c에 null 값을 넣어서 "Normal"을 가리키던 포인터가 해제(c 가비지 발생)
        //e는 생성만 하고 아무것도 가리키지 않기 때문에 가비지 발생
        //총 4개의 객체 가비지가 발생한다.
    }
}
