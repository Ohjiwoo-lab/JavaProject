/*
 * [과제 8번] 이름(name), 전화번호(tel) 필드와 생성자 등을 가진 PhoneAssign 클래스를 작성하고, 실행 예시와 같이 동작하는 PhoneBookAssign 클래스를 작성하라.
 * 사람에 대한 정보를 입력받고, 이름을 입력받았을 때 존재하는 지를 검사한다. 검사하여 존재하면, 해당 사람의 정보를 출력하고, 존재하지 않으면 존재하지 않는다고 출력한다.
 */

package Chapter4;
import java.util.Scanner;

class PhoneAssign {
    String name;  //이름
    String tel;  //전화번호(- 를 포함하기 때문에 정수가 아닌 문자열로 선언)

    //매개변수로 필드를 초기화하는 생성자
    public PhoneAssign(String name, String tel){
        this.name = name;
        this.tel = tel;
    }
}

public class PhoneBookAssign {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("인원수>> ");
        int num = scanner.nextInt();  //클래스에서 저장할 사람의 수를 입력받음

        PhoneAssign phone[] = new PhoneAssign[num];  //num 만큼 PhoneAssign 객체 배열 선언

        //num 만큼 반복하면서 사람에 대한 정보를 입력받아 phone 객체 배열에 저장함.
        for(int i = 0; i < num; i++){
            System.out.print("이름과 전화번호(이름과 번호는 각각은 빈칸없이 입력) >> ");
            String name = scanner.next();  //이름 입력받음(공백을 구분해야하므로 nextLine이 아닌 next로 입력받는다)
            String tel = scanner.next();  //전화번호 입력받음

            phone[i] = new PhoneAssign(name, tel);  //입력받은 이름과 전화번호로 PhoneAssign 객체 선언하면서 초기화
        }

        System.out.println("저장되었습니다...");

        //while의 조건문 판단을 위해 미리 이름 하나를 입력받는다.
        System.out.print("검색할 이름>> ");
        String searchName = scanner.next();

        //입력받은 이름이 '그만'이 아니면 계속 while 루프를 반복한다.
        while(!searchName.equals("그만")) {  //문자열 비교할 때는 ==, !=이 아닌 equals 메소드를 이용해야한다!!!
            int i;
            for(i = 0; i < phone.length; i++) {  //phone 객체 배열의 크기만큼 반복하면서 입력받은 이름과 클래스에 저장된 이름이 같은지 비교한다.
                if (searchName.equals(phone[i].name)) {  //만약 같다면 이름과 번호를 출력한 뒤 break로 빠져나간다.
                                                         // (즉, 입력받은 이름과 같은 이름이 존재한다면 i가 phone.length와 같아질리가 없다. 그 전에 빠져나오기 때문이다)
                    System.out.println(phone[i].name + "의 번호는 " + phone[i].tel + " 입니다.");
                    break;
                }
            }
            if(i == phone.length){  //따라서 i가 phone.length와 같은 경우는 입력받은 이름과 일치하는 것이 없어서 i가 1 증가해 phone.length와 같아짐으로써 for 조건문을 빠져나왔을 때 뿐이므로
                System.out.println(searchName + "이 없습니다.");  //입력받은 이름이 존재하지 않는다고 출력한다.
            }

            System.out.print("검색할 이름>> ");
            searchName = scanner.next();  //다시 이름을 입력받는다(그만이 입력될때까지)
        }

        scanner.close();
    }
}
