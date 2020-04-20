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
        
	public Enemy(){
		choice = new Random();
                ImageIcon img = new ImageIcon("car.png");
                enemyImg = img.getImage();
                
                enemyRect = new Rectangle();
                
	}
	
	public void drawEnemy1(Graphics g){
                      
    			g.setColor(Color.BLACK);
			g.drawImage(enemyImg, 590, yEnemy+=2, this);
                        enemyRect = new Rectangle(590,yEnemy,enemyImg.getWidth(this),enemyImg.getHeight(this));
                        g.drawRect(590,yEnemy,enemyImg.getWidth(this),enemyImg.getHeight(this));
	}
	
	public void drawEnemy2(Graphics g){
		
			g.setColor(Color.GREEN);
			g.drawImage(enemyImg, 765, yEnemy+=2, this);
                        enemyRect = new Rectangle(765,yEnemy,enemyImg.getWidth(this),enemyImg.getHeight(this));
                        g.drawRect(765,yEnemy,enemyImg.getWidth(this),enemyImg.getHeight(this));
	}
	
	public void drawEnemy3(Graphics g){
		
			g.setColor(Color.YELLOW);
			g.drawImage(enemyImg, 930, yEnemy+=2, this);
                        enemyRect = new Rectangle(930,yEnemy,enemyImg.getWidth(this),enemyImg.getHeight(this));
                        g.drawRect(930,yEnemy,enemyImg.getWidth(this),enemyImg.getHeight(this));
	}
        
	
	public void enemyDraw(Graphics g){
		
		if(yEnemy == 800){
                    yEnemy = -300;
                    for(int i = 0; i<=2; i++ ){
                        enemyChoice[i] = false;
                    }
			enemyChoice[choice.nextInt(3)] = true;
		}
               
		if(enemyChoice[0] == true){
			drawEnemy1(g);
                        drawEnemy3(g);
		}
		else if(enemyChoice[1] == true){
			drawEnemy2(g);
		}
		else if(enemyChoice[2] == true){
			drawEnemy3(g);
                        drawEnemy1(g);
		}
	}
	public Rectangle getEnemyRect(){
            return enemyRect;
        }

}

