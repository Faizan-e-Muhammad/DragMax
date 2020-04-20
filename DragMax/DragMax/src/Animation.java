/*
import java.awt.Graphics;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Animation extends JPanel{
    
    URL url;
    ImageIcon image = new ImageIcon();
    private static Image image1,image2;
    private static Graphics g;
    private JPanel panel;
    private JFrame frame;
    private long time;
    
    public Animation() throws MalformedURLException{
        frame = new JFrame("Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ImageIcon carImage = new ImageIcon("explosion.gif");
        image1 = carImage.getImage();
        
        ImageIcon carImage1 = new ImageIcon("car.png");
        image2 = carImage1.getImage();
        
        time = System.currentTimeMillis();
        System.out.println(time);
        panel = new JPanel();
        frame.add(this);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        g.drawRect(20, 20, 20, 20);
        g.drawImage(image1, 20, 20, this);
        
        time = System.currentTimeMillis();
        
        repaint();
    }
    
    public static void main(String args[]) throws MalformedURLException{
        new Animation();
    }
}
*/