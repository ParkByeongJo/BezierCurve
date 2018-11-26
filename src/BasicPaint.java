import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class MyPanel extends JPanel{//JPanel을 상속받는 MyPanel정의
	private int squareX=50;
	private int squareY=50;
	private int squareW=30;
	private int squareH=30;
	
	public MyPanel() {
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		
		this.addMouseListener(new MouseAdapter() {//마우스 이벤트 처리
			public void mousePressed(MouseEvent e) {
				moveSquare(e.getX(), e.getY());
			}
		});
		
		this.addMouseMotionListener(new MouseAdapter() {//마우스 모션 이벤트 처리
			public void mouseDragged(MouseEvent e) {
				moveSquare(e.getX(), e.getY());
			}
		});
	}

	/*repaint()를 호출할 때, 다시 그려야할 영역의 크기를 전달하였다는 점이다. 
	 *만약 전체 영역이 아닌 특정한 영역만을 다시 그리고자 하는 경우에는 이 방법이 효율적이다.*/
	private void moveSquare(int x, int y) {
		int OFFSET=1;
		if((squareX!=x) || (squareY != y)) {
			this.repaint(squareX, squareY, squareW+OFFSET, squareH+OFFSET);
			squareX=x;
			squareY=y;
			this.repaint(squareX, squareY, squareW+OFFSET, squareH+OFFSET);
		}
		
	}
	
	protected void paintComponent(Graphics g) {//이 메소드를 통해 사각형을 그린다.
		super.paintComponent(g);
		g.drawString("마우스를 클릭하면 사각형이 그려집니다.", 10 ,20);
		g.setColor(Color.RED);
		g.fillRect(squareX, squareY, squareW, squareH);
		g.setColor(Color.BLACK);
		g.drawRect(squareX, squareY, squareW, squareH);
	}
}
public class BasicPaint {

	public static void main(String[] args) {
		JFrame f=new JFrame("그래픽 기초 프로그래밍");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new MyPanel());
		f.setSize(300, 200);
		f.setVisible(true);

	}

}
