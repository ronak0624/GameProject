
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Enemy {

    private int dx;
    private int dy;
    private static int x;
    private static int y;
    private Image image;
    private static int width;
    private static int height;
    private int speed = 5;

    public Enemy() {
        
        initEnemy();
    }
    
    private void initEnemy() {
        
        ImageIcon ii = new ImageIcon("enemy.png");
        image = ii.getImage();
        width = ii.getIconWidth();
        height = ii.getIconHeight();
        x = 1000; 
        y = 600;        
    }
    
    public void move() {
        x += dx;
        y += dy;
        
        if (x < 1) {
        	x = 1;
        }
        
        if (x > Main.B_WIDTH - width) {
        	x = Main.B_WIDTH - width;
        }
        
        if (y < 1) {
        	y = 1;
        }
        
        if (y > Main.B_HEIGHT - height) {
        	y = Main.B_HEIGHT - height;
        }
    }

    public static int getX() {
        return x;
    }

    public static int getY() {
        return y;
    }
    
    public static int getWidth() {
    	return width;
    }
    
    public static int getHeight() {
    	return height;
    }
    
    public Rectangle getBounds() {
    	return new Rectangle(x, y, width, height);
    }

    public Image getImage() {
        return image;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_A) {
            dx = -speed;
        }

        if (key == KeyEvent.VK_D) {
            dx = speed;
        }

        if (key == KeyEvent.VK_W) {
            dy = -speed;
        }

        if (key == KeyEvent.VK_S) {
            dy = speed;
        }
        
        if (key == KeyEvent.VK_SPACE) {
        	
        }
        
    }

    public void keyReleased(KeyEvent e) {
        
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_A) {
            dx = 0;
        }

        if (key == KeyEvent.VK_D) {
            dx = 0;
        }

        if (key == KeyEvent.VK_W) {
            dy = 0;
        }

        if (key == KeyEvent.VK_S) {
            dy = 0;
        }
    }
}