/*
 * [과제 10번] 키와 값을 하나의 아이템으로 저장하고 검색 수정이 가능한 추상 클래스 PairMap이 있다.
 * PairMap을 상속받는 Dictionary 클래스를 구현하고, 이를 다음과 같이 활용하는 main() 메소드를 가진 클래스 DictionaryApp도 작성하라.
 * 하지만 파일의 이름을 Homework10으로 하기 위해서는 DictionaryApp을 사용할 수 없다. 따라서 Homework10 클래스가 DictionaryApp 클래스의 역할을 한다고 생각하면 된다.
 * 또한 배열의 현재 상태를 확인하기 위해 저장된 원소의 개수를 리턴하는 length() 메소드를 배열의 현재 상태도 출력하도록 변경하였다.
 */

package Chapter5;

// 추상 메소드를 4개 가지는 추상클래스
abstract class PairMap{
    protected String keyArray[];  // key 들을 저장하는 배열
    protected String valueArray[];  // value 들을 저장하는 배열

    // 추상 메소드
    abstract String get(String key);  // key 값을 가진 value를 리턴, 없으면 null을 리턴
    abstract void put(String key, String value);  // key와 value를 쌍으로 저장. 기존에 key가 있으면, 값을 value로 수정
    abstract String delete(String key);  // key 값을 가진 아이템(value와 함께) 삭제. 삭제된 value 값 리턴
    abstract int length();  // 현재 저장된 아이템의 개수 리턴
}

// 추상 메소드를 구현한 클래스
class Dictionary extends PairMap{
    // 인자 있는 생성자
    public Dictionary(int length){  // 객체를 생성할 때 전달받은 값만큼 key 배열과 value 배열을 할당한다.
        keyArray = new String[length];
        valueArray = new String[length];
    }

    @Override
    String get(String key){
        for(int i = 0; i < keyArray.length; i++){  // keyArray의 크기만큼 반복문을 수행
            if(key.equals(keyArray[i])){  // key와 동일한 값이 있는지 확인
                return valueArray[i];  // 있다면 그 value를 리턴
                /*
                 * 아이디어:
                 * key와 동일한 값이 keyArray에 존재하면, keyArray와 동일한 위치의 인덱스에 있는 value 값을 리턴한다.
                 * key 배열과 value 배열 모두 length 만큼 할당을 받은 뒤, 동일한 인덱스에 key와 value 쌍을 저장한다.
                 * 즉, '황기태' 아이템의 값이 '자바'이고, '황기태'를 keyArray의 인덱스 0에 저장했다면, 값인 '자바'는 valueArray의 인덱스 0에 저장된다.
                 * 즉, 인덱스 0에서 '황기태'를 찾았다면, 동일한 인덱스에 valueArray를 찾으면 값을 발견할 수 있다.
                 */
            }
        }
        return null;  // key와 동일한 값을 가지는 아이템이 없으므로 null을 리턴
    }

    @Override
    void put(String key, String value){
        /*
         * 아이디어:
         * key와 일치하는 값이 있다면 그 value에 새롭게 업데이트를 해주고, 일치하는 값이 없다면 새로운 위치에 새로운 아이템을 추가해주는 방식이다.
         * 따라서 먼저, key와 일치하는 값이 있는지를 살펴봐야한다. 없다면, 배열을 탐색하면서 null(원소가 없다)인 자리에 새로운 아이템을 삽입해주면 된다.
         */
        for(int i = 0; i < keyArray.length; i++){  // keyArray의 크기만큼 반복문을 수행
            if(key.equals(keyArray[i])){  // key와 일치하는 값이 있는지 탐색
                valueArray[i] = value;  // 있으면 그 value에 전달받은 값을 덮어씌운다.
                return;
            }
        }
        // key와 일치하는 값이 없는 경우
        for(int i = 0; i < keyArray.length; i++){  // keyArray의 크기만큼 반복문을 수행
            if(keyArray[i] == null){  // 배열을 탐색하면서 null 값을 찾는다. null이라면 원소가 아무것도 없다는 의미이므로 그 자리에 아이템을 삽입한다.
                keyArray[i] = key;  // key 배열에 key 삽입
                valueArray[i] = value;  // value 배열에 value 삽입
                return;
            }
        }
    }

    @Override
    String delete(String key){
        String value = null;  // 삭제할 아이템의 value를 저장. 후에 이를 리턴하기 위함.
        for(int i = 0; i < keyArray.length; i++){  // keyArray의 크기만큼 반복문을 수행
            if(key.equals(keyArray[i])){  // 만약 key와 일치하는 값이 있다면
                value = valueArray[i];  // 그 key에 해당하는 value를 변수에 저장한 뒤
                keyArray[i] = null;  // key를 null로 초기화
                valueArray[i] = null;  // value를 null로 초기화한다.
            }
        }
        // key와 일치하는 값이 없다면 아무 작업도 수행하지 않는다.

        return value;  // 삭제할 아이템의 value를 리턴함
    }

    @Override
    int length(){
        int count = 0;  // 원소 개수를 셀 변수
        for(int i = 0; i < keyArray.length; i++){  // keyArray의 크기만큼 반복문을 수행
            System.out.print("(" + keyArray[i] + ", " + valueArray[i] + ") ");  // 배열의 현제 상태 출력
            if(keyArray[i] != null){  // key 배열의 값이 null이 아니라면(무엇인가 값을 가지고 있다면)
                count++;  // count를 1씩 증가시켜준다.
            }
        }
        return count;  // 총 아이템의 원소의 개수를 리턴한다.
    }
}

// DictionaryApp 클래스 역할을 하는 클래스, main() 메소드를 이용하여 Dictionary 클래스를 활용한다.
public class Homework10 {
    public static void main(String[] args){
        Dictionary dic = new Dictionary(10);  // 배열의 크기를 10으로 하는 Dictionary 객체 생성

        System.out.println("황기태 아이텝 삽입>> ");
        dic.put("황기태", "자바");  // 황기태 아이템 삽입
        System.out.println("=> " + dic.length());  // 현재 상태 출력

        System.out.println("이재문 아이템 삽입>> ");
        dic.put("이재문", "파이썬");  // 이재문 아이템 삽입
        System.out.println("=> " + dic.length());  // 현재 상태 출력

        System.out.println("이재문 아이템의 값 변경>> ");
        dic.put("이재문", "C++");  // 이재문의 값을 c++로 수정
        System.out.println("=> " + dic.length());  // 현재 상태 출력

        System.out.println("이재문의 값은 " + dic.get("이재문"));  // 이재문 아이템 출력
        System.out.println("황기태의 값은 " + dic.get("황기태"));  // 황기태 아이템 출력

        System.out.println("황기태 원소 삭제>> ");
        dic.delete("황기태");   // 황기태 아이템 삭제
        System.out.println("=> " + dic.length());  // 현재 상태 출력
        System.out.println("황기태의 값은 " + dic.get("황기태"));  // 삭제된 아이템 접근

        System.out.println("오지우 원소 삽입>> ");
        dic.put("오지우", "JAVA");  // 오지우 원소 삽입
        System.out.println("=> " + dic.length());  // 현재 상태 출력
        /*
         * 0번 인덱스의 아이템을 삭제한 뒤, 새로운 원소를 삽입했을 때를 살펴보자.
         * '황기태' 아이템을 삭제하고 나서 배열의 상태는 0번 인덱스가 비어있고, 1번 인덱스에 값이 들어있다.
         * 그런 뒤 '오지우'라는 새로운 아이템을 삽입하면, 1번 인덱스의 다음인 2번 인덱스에 들어가는 것이 아니라, 0번 인덱스에 값이 채워짐을 알 수 있다.
         * 배열의 앞에서부터 비어있지 않도록 차례대로 삽입되도록 하였기 때문이다.
         */
    }
}