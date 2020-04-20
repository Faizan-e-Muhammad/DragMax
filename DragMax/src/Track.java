import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Track {
    
    private Rectangle boundry1 = new Rectangle(463,0,50,700);
    private Rectangle boundry2 = new Rectangle(987,0,50,700);
    private Image track1;
    private Image track2;
  
    public Track(Image img1, Image img2){
        track1 = img1;
        track2 = img2;
    }
    public Track(){
        
    }
    
    public void drawStage(Graphics g,int y,int y2){
        
        g.drawImage(track1, 0, y, null);
        g.drawImage(track2, 0, y2, null);
        
    }
     
    
    public Rectangle getBoundry1(){
        return boundry1;
    }
    
    public Rectangle getBoundry2(){
        return boundry2;
    }    
    
}
