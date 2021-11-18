/*
 * [과제 6번] Mouse 리스너와 배치관리자 없는 컨텐트팬에 컴포넌트 이동 연습
 * 클릭 연습용 스윙 응용프로그램을 작성한다. "C"를 출력하는 JLabel을 하나 만들고 초기 위치를 (100, 100)으로 한 뒤,
 * "C"를 클릭할 때마다 컨텐트팬 내에 랜덤한 위치로 움직이게 하는 프로그램을 작성한다.
 * 배치관리자를 삭제하면 레이블이 임의의 위치로 움직일 수 있다.
 */

package Chapter10;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Homework6 extends JFrame{
    JLabel label;

    public Homework6(){
        setTitle("Chapter10 - Homework6");   // 제목 지정
        setLayout(null);  // 문자를 임의의 위치로 움직이기 위해 배치관리자를 삭제한다.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 닫기 버튼을 눌렀을 시 화면 닫기

        label= new JLabel("C");  // 레이블 생성(문자는 "C")
        label.setSize(100,50);  // 레이블 크기 지정
        label.setLocation(100,100);  // 레이블의 위치 지정(초기 위치는 (100, 100)이다)
        label.addMouseListener(new MyMouseAdapter());  // MouseAdapter 객체 생성 후 리스너를 설정한다.
        add(label);  // 레이블 추가

        setSize(500,500);
        setVisible(true);
        label.requestFocus();  // 컨텐트팬이 키 입력을 받을 수 있도록 포커스 강제 지정
    }

    class MyMouseAdapter extends MouseAdapter{
        int x,y;   // 문자의 x, y 좌표값
        public void mousePressed(MouseEvent e) {
            // Math 클래스의 random() 메소드를 이용하여 문자가 이동할 새로운 좌표값을 설정한다.
            x = (int)(Math.random()*400);   // 여백을 조금 남기기 위해 400으로 지정
            y = (int)(Math.random()*400);   // 여백을 조금 남기기 위해 400으로 지정
            label.setLocation(x,y);  // 설정한 새로운 좌표값으로 문자를 위치시킨다.
        }
    }

    public static void main(String[] args) {
        new Homework6();
    }
}
