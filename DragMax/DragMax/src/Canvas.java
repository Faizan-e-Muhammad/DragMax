import java.awt.BorderLayout; 
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Canvas extends JPanel implements KeyListener,ActionListener{
    
    private Track track;
    private Car car;
    private int y = -700;
    private int y2 = 0;
    private Graphics g;
    private Enemy enemy;
   // private Timer timer;
   // private long time = System.currentTimeMillis();
    
    public Canvas(){
        setFocusable(true);
        addKeyListener(this); 
        
        track = new Track();
        car = new Car();
        enemy = new Enemy();
     //   timer = new Timer(1000, this);
    }
    
    @Override
    public void paintComponent(Graphics g ){
    	while (y == 0)
    		y = -700;
    	
    	while (y2 == 700)
    		y2 = 0;
    		
        super.paintComponent(g);
       
        g.setColor(Color.BLACK) ;
        
        g.fillRect(0, 0, 1500, 700);
        
        
        track.drawStage(g,y,y2);
       
        enemy.enemyDraw(g);
        try {
			car.drawCar(g);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
        
        car.move();
        
        if(car.forBlast){
        	car.setVisible(false);
        	car.blast(g);
        	car.forBlast = false;
        	
        }
        
        y += 2;
        y2 += 2;  
        
        g.dispose();
        repaint();
        
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
        if(e.getKeyCode() == KeyEvent.VK_UP)
            car.setDY(-3);
        
        if(e.getKeyCode() == KeyEvent.VK_DOWN)
            car.setDY(3);
        
        if(e.getKeyCode() == KeyEvent.VK_LEFT)
        	System.out.println("left");
            car.setDX(-3);
        
        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
            car.setDX(3);
    }

    @Override
    public void keyReleased(KeyEvent e) {
    
        if(e.getKeyCode() == KeyEvent.VK_UP)
            car.setDY(0);
        
        if(e.getKeyCode() == KeyEvent.VK_DOWN)
            car.setDY(0);
        
        if(e.getKeyCode() == KeyEvent.VK_LEFT)
            car.setDX(0);
        
        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
            car.setDX(0);
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}