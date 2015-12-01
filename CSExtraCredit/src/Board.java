
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;


public class Board extends JPanel implements ActionListener 
{

    private Timer timer;
    private Player player;
    private Enemy enemy;
    private final int DELAY = 1;

    public Board() {

        initBoard();
    }
    
    private void initBoard() {
        
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);

        player = new Player();
        enemy = new Enemy();

        timer = new Timer(DELAY, this);
        timer.start();        
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);

        Toolkit.getDefaultToolkit().sync();
    }

    private void doDrawing(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(enemy.getImage(), enemy.getX(), enemy.getY(), this);
        g2d.drawImage(player.getImage(), player.getX(), player.getY(), this);
        g.setColor(Color.WHITE);
        g.drawString("Hello", Player.getX(), Player.getY());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        player.move();
        enemy.move();
        repaint();  
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            player.keyReleased(e);
            enemy.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            player.keyPressed(e);
            enemy.keyPressed(e);
        }
    }
    
    public void checkCollisions() 
    {
    	Rectangle p = player.getBounds();
    	Rectangle e = enemy.getBounds();
    	
    	if (p.intersects(e)) {
    		System.out.println("Collision");
    	}
}
    
    
    
    
}