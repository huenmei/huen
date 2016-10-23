package huen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class StartGame extends JFrame  { 
  private static final long serialVersionUID = 1L;
    static World world;

	public static void main(final String[] args) {
		StartGame frame = new StartGame();
		world = new World(40,50);
		new Thread(world).start();
		frame.add(world);
			
		
		//设置菜单
		JMenuBar menu = new JMenuBar();
        frame.setJMenuBar(menu);
        
        JMenu options = new JMenu("Options");
        menu.add(options);
        
        JMenuItem z = options.add("Z");
		z.addActionListener(frame.new ZActionListener());        
        JMenuItem square = options.add("Square");
        square.addActionListener(frame.new SquareActionListener());        
        
        JMenu help = new JMenu("Help");        
        menu.add(help);
        
        //设置可视化界面
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1007, 859);
        frame.setTitle("Life of Cell");
        frame.setVisible(true);
        frame.setResizable(false);
	}
	
	class ZActionListener implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
    		world.setZ();
    	}
    }
    
    class SquareActionListener implements ActionListener {
    	public void actionPerformed(ActionEvent e){
    		world.setSquare();
    	}
    }    

}
