
import java.awt.EventQueue;

import javax.swing.JFrame;


public class Main extends JFrame {
	public static int B_HEIGHT = 480;
	public static int B_WIDTH = 800;

    public Main() {
        
        initUI();
    }
    
    private void initUI() {
        
        add(new Board());
        
        setSize(B_WIDTH, B_HEIGHT);
        setResizable(false);
        
        setTitle("Kek");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                Main m = new Main();
                m.setVisible(true);
                
            }
            
        });
    }
}