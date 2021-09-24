/*
 * [예제 4-10] 멤버의 접근 지정자
 * 두 개의 클래스 Sample과 AccessEx는 동일한 패키지에 저장된다. 그런데, 이 코드를 실행하면 컴파일 오류가 발생한다. 왜 그런지 설명하라.
 */

package Chapter4;

/*
 * a와 c는 Sample의 멤버변수이지만 public, defalut 지정자 이므로 같은 패키지 내의 또 다른 클래스 AccessEx에서는 접근이 가능하다.
 * 하지만 b는 private으로 선언되어 있어서 다른 클래스에서는 접근이 불가능하다.
 */
class Sample {
    public int a;
    private int b;
    int c;
}

public class AccessEx {
    public static void main(String[] args){
        Sample aClass = new Sample();

        aClass.a = 10;  //a는 접근 가능하다.
        //aClass.b = 10;  //b는 다른 클래스에서 접근할 수 없어, 컴파일 오류가 발생한다.
                          //오류가 발생하지 않게 주석처리해준다. 만약 이 코드를 사용하고 싶다면, Sample 클래스에서 b를 선언할 때 public 또는 defalut로 해주어야 한다.

        aClass.c = 10;  //c는 접근 가능하다.
    }
}
