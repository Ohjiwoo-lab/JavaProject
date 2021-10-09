/*
 * [예제 5-4] instanceof 연산자 활용
 * instanceof 연산자를 이용하여 상속 관계에 따라 레퍼런스가 가리키는 객체의 타입을 알아본다. 업캐스팅으로 인해 어떤 타입의 객체를 가리키는 지 알 수 없을 때 사용한다.
 */

package Chapter5;

class PersonFour{}
class StudentFour extends PersonFour{}
class ResearcherFour extends PersonFour{}
class ProfessorFour extends ResearcherFour{}

public class InstanceIfEx {
    static void print(PersonFour p){
        if(p instanceof PersonFour)
            System.out.print("PersonFour ");
        if(p instanceof StudentFour)
            System.out.print("StudentFour ");
        if(p instanceof ResearcherFour)
            System.out.print("ResearcherFour ");
        if(p instanceof ProfessorFour)
            System.out.print("ProfessorFour ");
        System.out.println();
    }

    public static void main(String[] args){
        // 상속관계 : PersonFour -> StudentFour
        //          PersonFour -> ResearcherFour -> ProfessorFour
        System.out.print("new StudentFour() -> ");
        print(new StudentFour());  // StudentFour 객체 생성 후 PersonFour 객체로 업캐스팅 -> StudentFour 타입이기도 하고 PersonFour 타입 이기도 함

        System.out.print("new ResearcherFour() -> ");
        print(new ResearcherFour());  // ResearcherFour 객체 생성 후 PersonFour 객체로 업캐스팅 -> ResearcherFour 타입이기도 하고 PersonFour 타입 이기도 함

        System.out.print("new ProfessorFour() -> ");
        print(new ProfessorFour());  // ProfessorFour 객체 생성 후 PersonFour 객체로 업캐스팅 -> ProfessorFour 타입이기도 하고 ResearcherFour 타입이기도 하며, PersonFour 타입 이기도 함
    }
}
