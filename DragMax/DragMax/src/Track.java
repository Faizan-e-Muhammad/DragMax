import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Track {
    
    private Rectangle boundry1 = new Rectangle(450,0,50,700);
    private Rectangle boundry2 = new Rectangle(1000,0,50,700);
    private Image track1;
    private Image track2;
  
    public Track(){
        ImageIcon carImage1 = new ImageIcon("Track1.jpg");
        track1 = carImage1.getImage();
        
        ImageIcon carImage2 = new ImageIcon("Track2.jpg");
        track2 = carImage2.getImage();
        
        
    }
    
    public void drawStage(Graphics g,int y,int y2){
        
        g.drawImage(track1, 0, y, null);
        g.drawImage(track2, 0, y2, null);
        
        g.setColor(Color.YELLOW);
        g.drawRect(boundry1.x, y, boundry1.width, boundry1.height);
        
        
        g.setColor(Color.YELLOW);
        g.drawRect(boundry2.x, y, boundry2.width, boundry2.height);
    
    }
     
    
    public Rectangle getBoundry1(){
        return boundry1;
    }
    
    public Rectangle getBoundry2(){
        return boundry2;
    }    
    
}
