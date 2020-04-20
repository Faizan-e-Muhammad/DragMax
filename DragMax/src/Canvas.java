import java.awt.Color; 
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Canvas extends JPanel implements KeyListener{
    
    private Track track;
    private Car car;
    private int y = -700;
    private int y2 = 0;
    private Graphics g;
    private Enemy enemy;
    private Image gameOver;

    public Canvas(Image img1, Image img2) throws FileNotFoundException, IOException{
        setFocusable(true);
        addKeyListener(this); 
        
        ImageIcon over = new ImageIcon("gameOver.jpg");
        gameOver = over.getImage();
        
        track = new Track(img1,img2);
        car = new Car();
        enemy = new Enemy();
   
    }
    
    @Override
    public void paintComponent(Graphics g ){
        
    	/* Conditions for running the two track images 
    	 * in a loop 
    	 * */
    	if (y == 0)
    		y = -700;
    	
    	if (y2 == 700)
    		y2 = 0;
    		
        super.paintComponent(g);
       
        g.setColor(Color.BLACK) ;
        
        g.fillRect(0, 0, 1500, 700);
        
        car.MGP.start(car.loop);
        track.drawStage(g,y,y2);
        
        
        lifesCounter(g);
        scoreCounter(g);
            
        try {
            car.drawCar(g);
        }catch (InterruptedException e) {		
            e.printStackTrace();
        }
        
        car.move();
        
        if(car.getLifes() == 0){
            drawGameOverScreen(g);
            car.MGP.stop(car.loop);
        }
        else{
            enemy.enemyDraw(g);
            repaint();
        }
        
        /*
         * Incrementing the y-axis of the tracks
         * */
        y += 4;
        y2 += 4;  
        enemy.score++;
        
        g.dispose();
        
        
    }
    
    public void drawGameOverScreen(Graphics g){
    	g.setColor(Color.BLACK);
        g.fillRect(0, 0, 1500, 700);
        g.drawImage(gameOver, 750, 350, null);

    }
    
    public void lifesCounter(Graphics g){
        g.setColor(Color.black);
        Font lifesfont = new Font("Verdana", Font.BOLD, 25);
        g.setFont(lifesfont);
        g.setColor(Color.red);
        g.drawString("Lifes : " + car.getLifes(), 1110, 100);
    }
    
    public void scoreCounter(Graphics g){
        g.setColor(Color.black);
        Font lifesfont = new Font("Verdana", Font.BOLD, 25);
        g.setFont(lifesfont);
        g.setColor(Color.red);
        g.drawString("Score : " +enemy.getScore(), 1110, 130);
    }
    
    public void starter(Graphics g) throws InterruptedException{
        
        g.setColor(Color.BLACK);
        g.draw3DRect(800, 20, 100, 50, true);
        
        
        g.setColor(Color.red);
        g.fillOval(810, 20, 30, 45);
        
        g.setColor(Color.ORANGE);
        g.fillOval(850, 20, 30, 45);
        
        g.setColor(Color.GREEN);
        g.fillOval(890, 20, 30, 45);
        
    }
   
    public Track getTrack(){
        return track;
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        
        if(e.getKeyCode() == KeyEvent.VK_LEFT)
            car.setDX(-3);
        
        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
            car.setDX(3);
    }

    @Override
    public void keyReleased(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_LEFT)
            car.setDX(0);
        
        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
            car.setDX(0);
    }
    
    @Override
    public void keyTyped(KeyEvent e) {}

}