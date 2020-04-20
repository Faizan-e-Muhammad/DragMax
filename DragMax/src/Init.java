
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Init extends JPanel implements ActionListener{
    
    private JLabel label;
    private Timer timer;
    private int count = 3;
    public JButton yes = new JButton("Yes");
    private JButton no = new JButton("No");
    private JLabel bgImg1 = new JLabel();
    private JLabel bgImg2 = new JLabel();
    
    
    public Init(){
        timer = new Timer(1000, this);
        
        setLayout(null);
        setBackground(Color.WHITE);
        ImageIcon Image2 = new ImageIcon("screen3Image2.jpg");      
        bgImg2.setIcon(Image2);
        
        bgImg2.setBounds(-105, 0, 500, 700);
        add(bgImg2);
        
        ImageIcon Image1 = new ImageIcon("screen3Image1.jpg");      
        bgImg1.setIcon(Image1);
        
        bgImg1.setBounds(940, 0, 500, 700);
        add(bgImg1);
        
        
        label = new JLabel("" + count);
        label.setFont(new Font("Serif", Font.BOLD, 120));
        label.setBounds(600, 200, 600, 200);
        add(label, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(count != 0){
            count--;
            label.setText("" + count);
        }
        else{
            timer.stop();
            
            label.setFont(new Font("Serif", Font.BOLD, 70));
            label.setText("Are You Ready ?");
            label.setBounds(400, 100, 600, 200);
            yes.putClientProperty("JComponent.sizeVariant", "mini");
            yes.setBackground(Color.red);
            yes.setForeground(Color.yellow);
            yes.setBounds(600,250,150,50);
            add(yes);
          
        }
    }
    
    public void startCounting(){
            timer.start();
    }
    
    public int getCount(){
        return count;
    }
    
}
