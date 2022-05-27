

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;


public class PlayerOneShip extends SpaceShip  {
	static int Vx;
	static int Vy;
	public static int i=0,j=0;
	public static double angle=0;
	public static int length=100;
	public static  int time=10;
	public static int bulletX;
	public static int bulletY;
	static Timer  timer = new Timer();
	public PlayerOneShip(int hp, int velocity, int armor) {
		super(hp, velocity, armor);		
		Vx=100;
		Vy=150;
		
	}

		
	public int getVx() {
		return Vx;
	}


	public void setVx(int a) {
		Vx+=a;
	}



	public int getVy() {
		return Vy;
	}



	public void setVy(int vy) {
		Vy += vy;
	}
	@Override
	public void stopVx() {
		if(Vx>580) {
			Vx=590;
		}else {
			Vx=10;
		}
		
	}
	@Override
	public void stopVy() {
		
		if(Vy>500) {
			Vy=600;
		}else {
			Vy=10;
		}
	}
	
	public void ship(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		
		g.setColor(Color.black);
		g.fillArc(PlayerOneShip.Vx-20, PlayerOneShip.Vy+33, 100, 50, 270, 180);
		g.setColor(Color.white);
		
		g2.fillRect(PlayerOneShip.Vx-40,PlayerOneShip.Vy + 33,80,50);
		g2.setColor(Color.blue);
		g2.fillOval(PlayerOneShip.Vx + 2, PlayerOneShip.Vy+45, 25,25);
		
		g2.setColor(Color.blue);
		g2.fillOval(PlayerOneShip.Vx - 30, PlayerOneShip.Vy+45, 25,25);
		
		
	
		
		g2.setColor(Color.black);
		g2.fillRect(PlayerOneShip.Vx-70,PlayerOneShip.Vy+28,15 , 15);
		g2.setColor(Color.black);
		g2.fillRect(PlayerOneShip.Vx-70,PlayerOneShip.Vy+33 + 18,15, 15);
		g2.setColor(Color.black);
		g2.fillRect(PlayerOneShip.Vx-70,PlayerOneShip.Vy+33 + 40,15 , 15);
		g2.setColor(Color.red);
		g2.fillRect(PlayerOneShip.Vx-60, PlayerOneShip.Vy+23,20,70);
		
		g2.setColor(Color.orange);
		g2.fillRect(PlayerOneShip.Vx -75, PlayerOneShip.Vy+30, 5,10);
		
		g2.setColor(Color.orange);
		g2.fillRect(PlayerOneShip.Vx -75, PlayerOneShip.Vy+53, 5,10);
		
		g2.setColor(Color.orange);
		g2.fillRect(PlayerOneShip.Vx -75, PlayerOneShip.Vy+76, 5,10);
		
		g2.setColor(Color.orange);
		g2.fillRect(PlayerOneShip.Vx -20, PlayerOneShip.Vy +23, 30,10);
		g2.setColor(Color.red);
		g2.fillArc(PlayerOneShip.Vx + 2,PlayerOneShip.Vy+23, 15, 10, 270, 180);
		
		g2.setColor(Color.orange);
		g2.fillRect(PlayerOneShip.Vx -20, PlayerOneShip.Vy+83, 30,10);
		g2.setColor(Color.red);
		g2.fillArc(PlayerOneShip.Vx + 2,PlayerOneShip.Vy+83, 15, 10, 270, 180);
		
		
	}

	






	

}
