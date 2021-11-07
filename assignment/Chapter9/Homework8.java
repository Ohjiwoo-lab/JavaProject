/*
 * [과제 8번] 여러 개의 컴포넌트와 여러 개의 패널을 가진 스윙 프레임 만들기
 * 다음과 같은 GUI 모양을 가진 스윙 프레임을 작성한다. Open Challenge의 힌트나 정답을 참고한다.
 * 10개의 '*' 문자는 10개의 JLabel을 이용하여 랜덤한 위치에 출력한다.
 */

package Chapter9;
import javax.swing.*;
import java.awt.*;

// 상단의 패널
class NorthPanel extends JPanel{
    public NorthPanel() {
        setBackground(Color.LIGHT_GRAY);  // 배경 회색

        // 버튼 생성
        add(new JButton("열기"));
        add(new JButton("닫기"));
        add(new JButton("나가기"));
    }
}

// 중간 패널
class CenterPanel extends JPanel{
    public CenterPanel() {
        setLayout(null);
        for (int i = 0; i < 20; i++) {
            int x = (int)(Math.random()*450);
            int y = (int)(Math.random()*450);
            JLabel label=new JLabel("*");  // 레이블에 * 출력
            label.setForeground(Color.RED);  // '*' 색상을 빨간색으로 설정
            label.setLocation(x,y);
            label.setSize(20, 20);
            label.setOpaque(true);
            add(label);
        }
    }
}

// 하단의 패널
class SouthPanel extends JPanel{
    public SouthPanel() {
        setBackground(Color.YELLOW);  // 배경 노란색
        add(new JButton("Word Input"));  // 버튼 생성
        add(new TextField(30));  // 글자를 입력할 수 있는 공간
    }
}

public class Homework8 extends JFrame{
    public Homework8(){  // 생성자
        setTitle("Homework8 - 여러 개의 패널을 가진 프레임");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        NorthPanel northPanel=new NorthPanel();  // 상단의 패널
        CenterPanel centerPanel=new CenterPanel();  // 중간 패널
        SouthPanel southPanel=new SouthPanel();  // 하단의 패널

        // 패널을 프레임에 추가
        add(northPanel, BorderLayout.NORTH);
        add(southPanel, BorderLayout.SOUTH);
        add(centerPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Homework8();
    }
}