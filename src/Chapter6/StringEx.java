/*
 * [예제 6-7] String 클래스 메소드 활용
 * String 클래스는 하나의 문자열을 표현하는 클래스로, 수정이 불가능하다. 비교할 때는 반드시 equals()를 사용해야 한다.
 * 문자열 길이 - length(), 문자열의 포함관계 - contains(), 문자열 연결 - concat(), 문자열 앞 뒤의 공백 제거 - trim(), 문자열 대치 - replace(),
 * 문자열 분리 - split(), 특정 인덱스부터 끝까지 서브 스트링 리턴 - substring(), 특정 인덱스의 문자 리턴 - charAt()
 */

package Chapter6;

public class StringEx {
    public static void main(String[] args){
        String a = new String(" C#");
        String b = new String(",C++");

        System.out.println(a + "의 길이는 " + a.length());   // 문자열의 길이(문자열을 이루는 문자의 개수)
        System.out.println(a.contains("#"));   // 문자열의 포함 관계(a에 #을 포함하고 있는가)

        a = a.concat(b);  // 문자열 연결
        System.out.println(a);

        a = a.trim();  // 문자열 앞 뒤의 공백 제거
        System.out.println(a);

        a = a.replace("C#", "Java");  // 문자열 대치
        System.out.println(a);

        String s[] = a.split(",");  // 문자열 분리
        for(int i = 0; i < s.length; i++){
            System.out.println("분리된 문자열" + i + ": " + s[i]);
        }

        a = a.substring(5);  // 인덱스 5부터 끝까지 서브 스트링 리턴
        System.out.println(a);

        char c = a.charAt(2);  // 인덱스 2의 문자 리턴
        System.out.println(c);
    }
}
