/*
 * [예제 6-8] StringBuffer 클래스 메소드 활용
 * StringBuffer 클래스는 가변 크기의 문자열을 저장하는 클래스로, String 클래스와 달리 문자열 변경이 가능하다.
 */

package Chapter6;

public class StringBufferEx {
    public static void main(String[] args){
        StringBuffer sb = new StringBuffer("This");

        sb.append(" is pencil");  // 문자열 덧붙이기
        System.out.println(sb);

        sb.insert(7, " my");  // "my" 문자열 삽입
        System.out.println(sb);

        sb.replace(8, 10, "your");  // 인덱스 8부터 9까지의 문자열 "my"를 "your"로 변경
        System.out.println(sb);

        sb.delete(8, 13);  // 인덱스 8부터 12까지의 문자열 "your "을 삭제
        System.out.println(sb);

        sb.setLength(4);  // 스트링 버퍼 내 문자열 길이 수정
        System.out.println(sb);
    }
}
