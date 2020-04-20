import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Car extends JPanel {
    
    private Image image;
    private int x = 640;
    private int y = 420;
    private int dx;
    private int dy;
    private Rectangle carBox;
    private Track track; 
    private int width = 100;
    private int delay = 1000;
    private Thread thread;
    private Enemy enemy;
    private Image blastImg;
    public boolean forBlast;
    
    
    public Car(){
        ImageIcon blast = new ImageIcon("explosion.gif");
        blastImg = blast.getImage();
        
    	thread = new Thread();
    	track = new Track();
        enemy = new Enemy();
    }
    
    public Rectangle carBox(){
        return carBox;
    }
    
   
    public void drawCar(Graphics g) throws InterruptedException{
        ImageIcon carImage = new ImageIcon("car.png");
        image = carImage.getImage();
        
        carBox = new Rectangle(x,y,image.getWidth(this),image.getHeight(this));
        
        if((isCollided(track.getBoundry1()))){
            forBlast = true;
            thread.sleep(delay);
            setDX(0);
            x = 640;
            y = 420;
        }
        
        if(isCollided(track.getBoundry2())){
        	forBlast = true;
        	thread.sleep(delay);
            setDX(0);
            x = 640;
            y = 420;
        }
        if((isCollided(enemy.enemyRect))){
        	forBlast = true;
        	thread.sleep(delay);
            setDX(0);
            x = 640;
            y = 420;
        }
        
        g.drawImage(image, carBox.x, carBox.y, this);
        g.drawRect(x,y,image.getWidth(this),image.getHeight(this));
    }
    
    public void blast(Graphics g){
       
        g.drawImage(blastImg, carBox.x, carBox.y, enemy);
        
    }
    
    public boolean isCollided(Rectangle entity){
        return (carBox.intersects(entity));
    }
    
    public Rectangle getCarBox(){
        return carBox;
    }
   
    public void move(){
        x += dx;
        y += dy;
    }
    
    public void setDX(int value){
        this.dx = value;
    }
    
    public void setDY(int value){
        this.dy = value;
    }
    
    public Image getImage(){
        return image;
    }
    
    public int getx(){
        return x;
    }
    
    public int gety(){
        return y;
    }
    
    public int getdx(){
        return dx;
    }
    
    public int getdy(){
        return dy;
    }
   public void setX(int x){
       this.x = x;
   }
   
   public void setY(int y){
       this.y = y;
   }
}
