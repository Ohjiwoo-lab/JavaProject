/*
 * [과제 4번] GridLayout과 JLabel 컴포넌트 색 활용
 * 컴포넌트의 배경색을 노란색으로 설정하려면 comp.setBackground(Color.YELLOW);로 하면 된다.
 * GridLayout을 사용하여 한 줄에 10개의 버튼을 동일한 크기로 배치한 뒤 각 버튼의 배경색을 서로 다르게 설정하는 프로그램을 작성한다.
 */

package Chapter9;
import javax.swing.*;
import java.awt.*;

public class Homework4 extends JFrame {
    Color[] color = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN, Color.BLUE, Color.MAGENTA,
            Color.GRAY, Color.PINK, Color.LIGHT_GRAY};

    public Homework4() {
        setTitle("Homework4 - GridLayout");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridLayout grid = new GridLayout(1, 10);  // 1열 10행으로 그리디 설정
        grid.setVgap(1);  // 각 행 사이를 1픽셀 간격으로 설정
        Container container = getContentPane();
        container.setLayout(grid);  // GridLayout으로 레이아웃 설정

        for(int i=0; i<10; i++) {
            JButton btn=new JButton(Integer.toString(i));  // 버튼 생성
            btn.setBackground(color[i]);  // 버튼 색 설정
            btn.setOpaque(true);
            container.add(btn);  // 버튼을 컨텐트팬에 부착
        }

        setSize(300, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Homework4();
    }
}
