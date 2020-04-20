/*import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class InternalFrames extends JFrame implements KeyListener{

    private JPanel screen1;
    private JPanel screen2;
    private JLabel bgImg = new JLabel();
    private JLabel keyPrompt = new JLabel("Press Enter to Continue");
    private JButton start;
    private JButton exit;
    private Font font;
    
    public InternalFrames(){
        super("Internal Framing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1500,700);
        validate();
    
        font = new Font("Serif",Font.BOLD,20);
        
        screen1 = new JPanel();
        screen1.setSize(1500,700);
        ImageIcon blast = new ImageIcon("cover.jpg");      
        bgImg.setIcon(blast);
        start = new JButton("Start");
        exit = new JButton("Exit");
        keyPrompt.setFont(font);
        ActionListener starting = new ActionListener(){
         
            @Override
            public void actionPerformed(ActionEvent e){
                getContentPane().removeAll();
                screen2 = new JPanel();
                screen2.setSize(1500,700);
                add(screen2);
                validate();
            } 
        };
        ActionListener closing = new ActionListener(){
         
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(1);
            } 
        };
        
        start.addActionListener(starting);
        exit.addActionListener(closing);
        
        
        screen1.setFocusable(true);
        screen1.addKeyListener(this);
        screen1.add(bgImg);
        keyPrompt.setBounds(500, 500, 300, 25);
        add(keyPrompt);
        add(screen1);
        
        
        
        setVisible(true);
        
        
    }
   
    public static void main(String[] args){
        new InternalFrames();
    }
 
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getExtendedKeyCode() == KeyEvent.VK_ENTER){
            getContentPane().removeAll();
                screen2 = new JPanel();
                screen2.setSize(1500,700);
                screen2.add(start);
                screen2.add(exit);
                add(screen2);
                validate();
        }
    }

    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}

}

*/