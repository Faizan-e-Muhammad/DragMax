import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class GameBoard extends JFrame {
    
    private JLabel cordinates = new JLabel(" ");
    private Screen1 screen1;
    private JPanel screen2 ;
    private JButton start = new JButton("Start");
    private JButton exit = new JButton("Exit");
    private JButton selectTrack = new JButton("Select Track");
    private JButton beach = new JButton("Day");
    private JButton night = new JButton("Night");
    private GameBoardForCanvas game;
    private Init init;
    private Image day1,night1;
    private Image day2,night2;
    private JPanel trackPanel;
    private Image imageChoice1,imageChoice2;
    private JLabel track1,track2;
    private JLabel bgImg = new JLabel();
    
    public GameBoard() throws FileNotFoundException, IOException{
        super("Drag Max");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1500,700);
        
        ImageIcon trackImage1 = new ImageIcon("Track1.jpg");
        day1 = trackImage1.getImage();
        
        ImageIcon trackImage2 = new ImageIcon("Track2.jpg");
        day2 = trackImage2.getImage();
        
        ImageIcon trackImage3 = new ImageIcon("Track3.jpg");
        night1 = trackImage3.getImage();
        
        ImageIcon trackImage4 = new ImageIcon("Track4.jpg");
        night2 = trackImage4.getImage();
        
        track1 = new JLabel(trackImage1);
        track1.setBounds(0, 0, 1360, 550);
        
        trackPanel = new JPanel();
        trackPanel.setSize(1500,700);
        trackPanel.setBackground(new Color(1,187,210));
        trackPanel.setLayout(null);
        trackPanel.add(track1);
        trackPanel.add(beach);
        trackPanel.add(night);
        
        init = new Init();
        screen1 = new Screen1();
        
        screen1.setFocusable(true);
        screen1.addKeyListener(new KeyListener(){
            public void keyPressed(KeyEvent e){
                if(e.getExtendedKeyCode() == KeyEvent.VK_ENTER){
           
                    getContentPane().removeAll();
                    add(trackPanel);
                    validate();
        }
            }
            public void keyTyped(KeyEvent e) {}
            public void keyReleased(KeyEvent e) {}

            
        });
        
        add(screen1);
        
         ActionListener starting = new ActionListener(){
         
            @Override
            public void actionPerformed(ActionEvent e){
                getContentPane().removeAll();
                
                init.startCounting();
                add(init);
                
                ActionListener onYes = new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                    				
                        dispose();
                        try {
                                game = new GameBoardForCanvas(imageChoice1,imageChoice2);
                            } catch (IOException e1) {
                                e1.printStackTrace();
						}   
                } 
            };
                init.yes.addActionListener(onYes);
                
                validate();
            } 
        };
        ActionListener closing = new ActionListener(){
         
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(1);
            } 
        };
        
        ActionListener forBeach = new ActionListener(){
         
            @Override
            public void actionPerformed(ActionEvent e){
                imageChoice1 = day1;
                imageChoice2 = day2;
                
                getContentPane().removeAll();
                screen2 = new JPanel();
                screen2.setLayout(null);
                screen2.setSize(1500,700);
                screen2.setBackground(Color.black);
                ImageIcon blast = new ImageIcon("screen2.jpg");
                bgImg.setIcon(blast);
                screen2.add(bgImg);
                screen2.add(start);
                screen2.add(exit);
                add(screen2);
            
                validate();
            } 
        };
        
        ActionListener forNight = new ActionListener(){
         
            @Override
            public void actionPerformed(ActionEvent e){
                imageChoice1 = night1;
                imageChoice2 = night2;
                
                getContentPane().removeAll();
                screen2 = new JPanel();
                screen2.setLayout(null);
                screen2.setSize(1500,700);
                screen2.setBackground(Color.black);
                ImageIcon blast = new ImageIcon("screen2.jpg");
                bgImg.setIcon(blast);
                screen2.add(bgImg);
                screen2.add(start);
                screen2.add(exit);
                add(screen2);
            
                validate();
            } 
        };
        
        bgImg.setBounds(0, 0, 1500, 500);
        
        start.setBackground(Color.red);
        start.setForeground(Color.yellow);
        start.setBounds(400, 550, 200, 50);
        start.putClientProperty("JComponent.sizeVariant", "mini");
        
        exit.putClientProperty("JComponent.sizeVariant", "mini");
        exit.setBackground(Color.red);
        exit.setForeground(Color.yellow);
        exit.setBounds(800, 550, 200, 50);
        
        beach.putClientProperty("JComponent.sizeVariant", "mini");
        beach.setBackground(Color.red);
        beach.setForeground(Color.yellow);
        beach.setBounds(400, 570, 200, 50);
        
        night.putClientProperty("JComponent.sizeVariant", "mini");
        night.setBackground(Color.red);
        night.setForeground(Color.yellow);
        night.setBounds(700, 570, 200, 50);
        
        start.addActionListener(starting);
        exit.addActionListener(closing);
        beach.addActionListener(forBeach);
        night.addActionListener(forNight);
        
        setVisible(true);
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException{
        
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {}
       new GameBoard();
    }
    
}
