import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class MyPanel extends JPanel{//JPanel�� ��ӹ޴� MyPanel����
	private int squareX=50;
	private int squareY=50;
	private int squareW=30;
	private int squareH=30;
	
	public MyPanel() {
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		
		this.addMouseListener(new MouseAdapter() {//���콺 �̺�Ʈ ó��
			public void mousePressed(MouseEvent e) {
				moveSquare(e.getX(), e.getY());
			}
		});
		
		this.addMouseMotionListener(new MouseAdapter() {//���콺 ��� �̺�Ʈ ó��
			public void mouseDragged(MouseEvent e) {
				moveSquare(e.getX(), e.getY());
			}
		});
	}

	/*repaint()�� ȣ���� ��, �ٽ� �׷����� ������ ũ�⸦ �����Ͽ��ٴ� ���̴�. 
	 *���� ��ü ������ �ƴ� Ư���� �������� �ٽ� �׸����� �ϴ� ��쿡�� �� ����� ȿ�����̴�.*/
	private void moveSquare(int x, int y) {
		int OFFSET=1;
		if((squareX!=x) || (squareY != y)) {
			this.repaint(squareX, squareY, squareW+OFFSET, squareH+OFFSET);
			squareX=x;
			squareY=y;
			this.repaint(squareX, squareY, squareW+OFFSET, squareH+OFFSET);
		}
		
	}
	
	protected void paintComponent(Graphics g) {//�� �޼ҵ带 ���� �簢���� �׸���.
		super.paintComponent(g);
		g.drawString("���콺�� Ŭ���ϸ� �簢���� �׷����ϴ�.", 10 ,20);
		g.setColor(Color.RED);
		g.fillRect(squareX, squareY, squareW, squareH);
		g.setColor(Color.BLACK);
		g.drawRect(squareX, squareY, squareW, squareH);
	}
}
public class BasicPaint {

	public static void main(String[] args) {
		JFrame f=new JFrame("�׷��� ���� ���α׷���");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new MyPanel());
		f.setSize(300, 200);
		f.setVisible(true);

	}

}
