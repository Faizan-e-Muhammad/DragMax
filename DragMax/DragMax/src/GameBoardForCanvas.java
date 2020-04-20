import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameBoardForCanvas extends JFrame{
	
	private Canvas canvas;
	
	public GameBoardForCanvas(){
		canvas = new Canvas();
		add(canvas);
		setSize(1500,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
