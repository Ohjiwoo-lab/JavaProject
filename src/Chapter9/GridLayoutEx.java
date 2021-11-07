/*
 * [예제 9-5] GridLayout으로 입력 폼 만들기
 * 아래 화면과 같이 사용자로부터 입력받는 폼을 스윙 응용프로그램으로 작성한다.
 */

package Chapter9;
import javax.swing.*;
import java.awt.*;

public class GridLayoutEx extends JFrame {
    public GridLayoutEx() {
        setTitle("GridLayout Sample");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridLayout grid = new GridLayout(4, 2);
        grid.setVgap(5);  // 각 행 사이를 5 픽셀 간격으로 설정
        Container c = getContentPane();
        c.setLayout(grid);

        // 이름을 적을 수 있는 행
        c.add(new JLabel(" 이름"));
        c.add(new JTextField(""));

        // 학번을 적을 수 있는 행
        c.add(new JLabel(" 학번"));
        c.add(new JTextField(""));

        // 학과를 적을 수 있는 행
        c.add(new JLabel(" 학과"));
        c.add(new JTextField(""));

        // 과목 이름을 적을 수 있는 행
        c.add(new JLabel(" 과목"));
        c.add(new JTextField(""));

        setSize(300, 200);
        setVisible(true);
    }
    public static void main(String[] args) {
        new GridLayoutEx();
    }
}
