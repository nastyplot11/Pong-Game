import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class pong implements ActionListener, KeyListener, MouseMotionListener{
	//Properties
	JFrame Pong;
	//This builds the AnimationPanel3 object
	//This comes from another program
	AnimationPanel3 panel;
	Timer timer;
	
	//Methods
	//There doesn't need to be an if statement for actionPerformed because there is only one component that is being listened to
	//The timer is the only event that will trigger this method
	//When the timer ends, the panel will be repainted
	public void actionPerformed(ActionEvent evt){
		if(evt.getSource() == timer){
			//Every time the timer ends, the AnimationPanel3 program will run
			panel.repaint();
		}
	}
	//MouseMotionListener is an interface that has the methods mouseMoved and mouseDragged
	public void mouseMoved(MouseEvent evt){
		panel.intBlock2Y = evt.getY();
	}
	public void mouseDragged(MouseEvent evt){
	}
	
	//Key Listener is an interface that has the methods keyTyped, keyReleased, and keyPressed
	public void keyTyped(KeyEvent evt){
		
	}
	
	public void keyReleased(KeyEvent evt){
		if(evt.getKeyCode()==38){
			panel.blnGoUp = false;
		}else if(evt.getKeyCode()==40){
			panel.blnGoDown = false;
		}
	}
	
	public void keyPressed(KeyEvent evt){
		if(evt.getKeyCode()==38){
			panel.blnGoUp = true;
		}else if(evt.getKeyCode()==40){
			panel.blnGoDown = true;
		}
	}
	
	//Constructor
	public pong(){
		//Panel adds MouseMotionListener
		//Frame adds KeyListener
		Pong = new JFrame("Pong");
		//The AnimationPanel3 object is being constructed and set to the variable panel
		panel = new AnimationPanel3();
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(1280, 720));
		panel.addMouseMotionListener(this);
		
		timer = new Timer(1000/60, this);
		timer.start();
		
		Pong.addKeyListener(this);
		Pong.setContentPane(panel);
		Pong.pack();
		Pong.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Pong.setVisible(true);
		
	}
	
	//Main Method
	public static void main(String[]args){
		new pong();
	}
}
