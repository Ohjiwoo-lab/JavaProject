/*
* 대입 연산자와 증감 연산자 사용을 연습하기 위한 예제
*/

package Chapter2;

public class AssignmentIncDevOperator {
    public static void main(String[] args){
        int a = 3, b = 3, c = 3;

        //대입 연산자 사례
        a += 3;  //a = a + 3
        b *= 3;  //b = b * 3
        c %= 2;  //c = c % 2
        System.out.println("a=" + a + ", b=" + b + ", c=" + c);

        int d = 3;
        //증감 연산자 사례
        a = d++;  //후위 연산자, d를 a에 대입한 뒤 d를 1 증가 => a=3, d=4
        System.out.println("a=" + a + ", d=" + d);
        a = ++d;  //전위 연산자, d를 1 증가시킨 뒤 a에 대입 => a=5, d=5
        System.out.println("a=" + a + ", d=" + d);
        a = d--;  //후위 연산자, d를 a에 대입한 뒤 d를 1 감소 => a=5, d=4
        System.out.println("a=" + a + ", d=" + d);
        a = --d;  //전위 연산자, d를 1 감소시킨 뒤 a에 대입 => a=3, d=3
        System.out.println("a=" + a + ", d=" + d);
    }
}
