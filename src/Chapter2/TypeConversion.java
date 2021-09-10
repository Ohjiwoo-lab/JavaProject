/*
* 타입 변환
* 자동 타입 변환과 강제 타입 변환의 이해를 위한 예제
*/

package Chapter2;

public class TypeConversion {
    public static void main(String[] args){
        byte b = 127;
        int i = 100;

        System.out.println(b + i);  //byte타입과 int타입의 덧셈 -> 결과는 정수
        System.out.println(10 / 4);  //정수끼리 나눗셈 -> 결과도 정수
        System.out.println(10.0 / 4);  //실수와 정수의 나눗셈 -> 결과는 실수
        System.out.println((char)0x12340041);  //강제 타입 변환 결과 0x41이 되며, 문자 A를 나타내는 코드이다.
        System.out.println((byte)(b + i));  //b + i의 결과를 byte로 강제변환한다. int를 byte로 변환하면서 값이 손실될 수 있다.
        System.out.println((int)2.9 + 1.8);  //2.9를 int로 변환한 뒤, 실수와 더하므로 결과는 실수
        System.out.println((int)(2.9 + 1.8));  //실수와 실수를 더한 뒤, int로 강제 변환 -> 값 손실이 있을 수 있다.
        System.out.println((int)2.9 + (int)1.8);  //2.9와 1.8을 각각 정수로 변환한 뒤 더하므로 값 손실 없이 정수가 나온다.
    }
}
