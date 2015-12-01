
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Player {

    private int dx;
    private int dy;
    private static int x;
    private static int y;
    private Image image;
    private int speed = 5;
    private static int width;
    private static int height;

    public Player() {
        
        initPlayer();
    }
    
    private void initPlayer() {
        
        ImageIcon ii = new ImageIcon("player.png");
        image = ii.getImage();
        width = ii.getIconWidth();
        height = ii.getIconHeight();
        x = 40;
        y = 60;        
    }
    
    public void getPlayerDimensions() {
    	
    	width = image.getWidth(null);
    	height = image.getHeight(null);
    }
    
    public Rectangle getBounds() {
    	return new Rectangle(x, y, width, height);
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

    public Image getImage() {
        return image;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -speed;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = speed;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -speed;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = speed;
        }
        
        if (key == KeyEvent.VK_SPACE) {
        	
        }
        
    }

    public void keyReleased(KeyEvent e) {
        
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
}