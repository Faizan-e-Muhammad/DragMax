import java.awt.Image;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameBoardForCanvas extends JFrame{
	
	private Canvas canvas;
	
	public GameBoardForCanvas(Image img1, Image img2) throws FileNotFoundException, IOException{
		
		canvas = new Canvas(img1, img2);
		add(canvas);
		setSize(1500,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
