/*
 * [예제 10-4] 마우스로 문자열 이동시키기 - 마우스 이벤트 연습
 * 컨텐트팬의 아무 위치에서 마우스 버튼을 누르면 마우스 포인트가 있는 위치로 "Hello" 문자열을 옮기는 스윙 응용프로그램을 작성한다.
 */

package Chapter10;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MouseListenerEx extends JFrame {
    private JLabel la = new JLabel("Hello");  // Hello 문자열을 출력할 라벨

    public MouseListenerEx() {
        setTitle("Mouse 이벤트 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();  // 컨텐트펜 생성
        c.addMouseListener(new MyMouseListener());
        c.setLayout(null);
        la.setSize(50, 20);  // Hello 문자열의 크기 설정
        la.setLocation(30, 30);  // 초기 Hello 위치 설정
        c.add(la);  // Hello 문자열을 컨텐트펜에 추가
        setSize(250, 250);
        setVisible(true);
    }

    // 내부 클래스
    class MyMouseListener implements MouseListener {
        public void mousePressed(MouseEvent e) {  // 마우스 버튼이 눌러진 위치를 알아내어 la("hello" 문자열)를 그 위치로 옮긴다.
            // getX, getY 메소드로 마우스가 클릭된 위치를 좌표로 얻어냄
            int x = e.getX();
            int y = e.getY();
            la.setLocation(x, y);  // setLocation으로 Hello 문자열의 위치를 새로운 좌표 (x,y)로 옮김
        }
        public void mouseReleased(MouseEvent e) {}
        public void mouseClicked(MouseEvent e) {}
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
    }

    public static void main(String [] args) {
        new MouseListenerEx();
    }
}
