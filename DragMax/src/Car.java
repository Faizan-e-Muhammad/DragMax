import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import sun.audio.*;

public class Car extends JPanel {
    
    private Image image;
    private int x = 700;
    private int y = 470;
    private int dx;
    private int dy;
    private Rectangle carBox;
    private Track track; 
    private int delay = 500;
    private Thread thread;
    private Enemy enemy;
    private Image blastImg,gameOver;
    public static boolean temp = false;
    private int lifes = 3;
    public AudioPlayer MGP = AudioPlayer.player;
    private AudioStream BGM;
    private AudioData MD;
    public ContinuousAudioDataStream loop = null;
    
    public Car() throws FileNotFoundException, IOException{
    	BGM = new AudioStream(new FileInputStream("loop_Engine.wav"));
    	MD = BGM.getData();
    	
    	loop = new ContinuousAudioDataStream(MD);    	
    	
        ImageIcon blast = new ImageIcon("explosion.gif");
        blastImg = blast.getImage();
        
        ImageIcon over = new ImageIcon("gameOver.jpg");
        gameOver = over.getImage();
        
        //Thread object being used to produce delay in case of collision 
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
        
        carBox = new Rectangle(x + 20,y,90,image.getHeight(this) - 5);
        
        if((isCollided(track.getBoundry1()))){
            thread.sleep(delay);   
            setDX(0);
            x = 700;
            y = 470;
            
            /*
             *  This boolean temp is used in the Enemy class to print the enemy again
             *  in case of collision
             * */
            temp = true;
            
            if(lifes != 0)
                lifes--;
           
        }
        
        if(isCollided(track.getBoundry2())){
            thread.sleep(delay);
            setDX(0);
            x = 700;
            y = 470;
            
            temp = true;
            
            if(lifes != 0)
                lifes--;   
           
        }
        if((isCollided(enemy.enemyRect))){
            thread.sleep(delay);
            setDX(0);
            x = 700;
            y = 470;
           
            temp = true;
            
            if(lifes != 0)
                lifes--;    
        }
        
        g.drawImage(image, x, y, this);
    }
    
    public void blast(Graphics g){
       
        g.drawImage(blastImg, carBox.x, carBox.y, enemy);
        
    }
   
    public int getLifes(){
        return lifes;
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
