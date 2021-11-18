/*
 * [과제 2번] Mouse 이벤트와 MouseMotion 이벤트 동시 처리
 * 컨텐트팬의 배경색은 초록색으로 하고 마우스를 드래깅하는 동안만 노란색으로 유지하는 스윙 응용프로그램을 작성한다.
 */

package Chapter10;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Homework2 extends JFrame{
    JPanel contentPane = new JPanel();  // 컨텐트팬으로 사용할 패널 생성

    public Homework2(){
        setTitle("Chapter10 - Homework2");   // 제목 지정
        setLayout(new FlowLayout());  // 레이아웃 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 닫기 버튼을 눌렀을 시 화면 닫기

        setContentPane(contentPane);
        contentPane.setBackground(Color.GREEN);  // 컨텐트펜 배경색을 초록색으로 설정

        contentPane.addMouseMotionListener(new MyMouseMotionAdapter());  // JPanel에 MouseMotionListener 추가
        contentPane.addMouseListener(new MyMouseAdapter2());   // JPanel에 MouseListener 추가
        setSize(400,200);
        setVisible(true);
    }

    //MouseMotionAdapter를 상속 받는 MyMouseMotionAdapter 클래스
    class MyMouseMotionAdapter extends MouseMotionAdapter{
        public void mouseDragged(MouseEvent e) {
            // 마우스가 드래그되는 동안 배경색을 노란색으로 유지
            contentPane.setBackground(Color.YELLOW);
        }
    }

    //MouseAdapter를 상속 받는 MyMouseAdapter2 클래스
    class MyMouseAdapter2 extends MouseAdapter{
        public void mouseReleased(MouseEvent e) {
            // 눌러진 마우스 버튼이 떼어질 때 배경색을 다시 초록색으로 변경
            contentPane.setBackground(Color.GREEN);
        }
    }

    public static void main(String[] args) {
        new Homework2();
    }
}
