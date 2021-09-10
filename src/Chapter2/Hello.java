package Chapter2;

public class Hello {
    public static int sum(int n, int m){
        return n + m;
    }

    //main 메소드는 항상 처음에 실행된다.
    public static void main(String[] args){
        int i = 20;
        int s;
        char a;

        s = sum(i, 10);  //클래스의 sum 메소드를 호출하여 n에 i, m에 10을 보내어 더한다. 결과는 30
        a = '?';
        System.out.println(a);
        System.out.println("Hello");
        System.out.println(s);
    }
}
