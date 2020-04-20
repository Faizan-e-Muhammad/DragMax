import java.awt.BorderLayout; 
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameBoard extends JFrame implements KeyListener{
    
    private JLabel cordinates = new JLabel(" ");
    private Screen1 screen1;
    private JPanel screen2 ;
    private JButton start = new JButton("Start");
    private JButton exit = new JButton("Exit");
    private GameBoardForCanvas game;
    
    public GameBoard(){
        super("Drag Max");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1500,700);
        
        screen1 = new Screen1();
        this.addMouseMotionListener(new MouseAdapter()
        {
          @Override
          public void mouseMoved(MouseEvent e){
                cordinates.setText("( " + e.getX() + " ," + e.getY() + ")");
          }  
        });
        
        screen1.setFocusable(true);
        screen1.addKeyListener(new KeyListener(){
            public void keyPressed(KeyEvent e){
                if(e.getExtendedKeyCode() == KeyEvent.VK_ENTER){
           
                    getContentPane().removeAll();
                    screen2 = new JPanel();
                    screen2.setSize(1500,700);
                    screen2.add(start);
                    screen2.add(exit);
                    add(screen2);
                    removeKeyListener(this);
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
                setFocusable(true);
                /*add(cordinates , BorderLayout.SOUTH);
                Canvas game = new Canvas();
                add(game, BorderLayout.CENTER);
                */
                dispose();
                game = new GameBoardForCanvas();
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
        
        
        
        setVisible(true);
    }
    
    public static void main(String[] args){
       new GameBoard();
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
            removeKeyListener(this);
            validate();
        }
    }

    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
    
    
}
