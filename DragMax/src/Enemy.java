import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Enemy extends JPanel{

    public int yEnemy = -300;
    private int[] enemyPos = {590,765,930};
    private Random choice;
    private Graphics g;
    boolean[] enemyChoice = {true,false,false};
    private Image enemyImg;
    public static Rectangle enemyRect;
    public int score = 0;
    private int x1 = 530;
    private int x2 = 700;
    private int x3 = 880;
    private boolean xDirection1,xDirection2,xDirection3;
    
    public Enemy(){
        choice = new Random(System.currentTimeMillis());
        ImageIcon img = new ImageIcon("car.png");
        enemyImg = img.getImage();

        enemyRect = new Rectangle();
                
	}
	
	public void drawEnemy1(Graphics g){
                      
            g.setColor(Color.BLACK);
            g.drawImage(enemyImg, x1, yEnemy+=2, this);
            enemyRect = new Rectangle(x1 + 20,yEnemy,90,enemyImg.getHeight(this) - 5);

	}
	
	public void drawEnemy2(Graphics g){
		
            g.setColor(Color.GREEN);
            g.drawImage(enemyImg, x2, yEnemy+=2, this);
            enemyRect = new Rectangle(x2 + 20,yEnemy,90,enemyImg.getHeight(this) - 5);
            
	}
	
	public void drawEnemy3(Graphics g){
		
            g.setColor(Color.YELLOW);
            g.drawImage(enemyImg, x3, yEnemy+=2, this);
            enemyRect = new Rectangle(x3 + 20,yEnemy,enemyImg.getWidth(this),enemyImg.getHeight(this) - 5);
         
	}
	
	/*
	 *  This method randomly invokes any of the three methods drawEnemy1 , drawEnemy2 , drawEnemy3
	 *  and the forward() and backwards() methods are used to move enemy car on the x-axis. In this way,
	 *  enemy car moves on both the axis 
	 * 
	 * */    
	public void enemyDraw(Graphics g){
		
            if(yEnemy == 800 || Car.temp == true){
                score +=10;
                yEnemy = -300;
                Car.temp = false;
            
                for(int i = 0; i<=2; i++ ){
                    enemyChoice[i] = false;
                }
			
                enemyChoice[choice.nextInt(3)] = true;
            }
               
            if(enemyChoice[0] == true){
                drawEnemy1(g);
                   
                if(xDirection1 == false)
                    forward1();
                
                if(xDirection1 == true)
                    backwards1();
            }
            else if(enemyChoice[1] == true){
                drawEnemy2(g);
                
                if(xDirection2 == false)
                    forward2();
                
                if(xDirection2 == true)
                    backwards2();
            }
            else if(enemyChoice[2] == true){
                drawEnemy3(g);
                
                if(xDirection3 == false)
                    forward3();
                
                if(xDirection3 == true)
                    backwards3();
            }
	}
	
	public Rectangle getEnemyRect(){
            return enemyRect;
    }
	
	public int getScore(){
		return score;
	}
        
	public void forward1(){
        x1+=1;
        if(x1 >= 700)
        	xDirection1 = true;
    }
        
    public void backwards1(){
        x1-=1;
        if(x1 <= 530)
            xDirection1 = false;
    }
    
    public void forward2(){
    	x2+=1;
    	if(x2 >= 880)
    		xDirection2 = true;
    }
        
    public void backwards2(){
    	x2-=1;
    	if(x2 <= 700)
    		xDirection2 = false;
    }   
    
    public void forward3(){
    	x3+=1;
    	if(x3 >= 880)
    		xDirection3 = true;
    }
        
    public void backwards3(){
    	x3-=1;
    	if(x3 <= 700)
    		xDirection3 = false;
    }    
        
    public void setScore(int x){
    	score+=x;
    }
        
}

