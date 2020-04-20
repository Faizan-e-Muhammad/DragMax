import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Screen1 extends JPanel{
    
    private JLabel bgImg = new JLabel();
    private JLabel keyPrompt = new JLabel("Press Enter to Continue");
    private Font font;
    
    public Screen1(){
       
        font = new Font("Serif",Font.BOLD,20);
        ImageIcon blast = new ImageIcon("cover.jpg");      
        bgImg.setIcon(blast);
        add(bgImg);
        keyPrompt.setFont(font);
        add(keyPrompt);
    }  
}
