import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.Timer;
import java.util.TimerTask;

public class PlayerTwoShip extends SpaceShip {
	static int Vx;
	static int Vy;
	public  static int i=0,j=0;
	public static double angle=0;
	public static int length=100;
	public static int time=200;
	static Timer  timer = new Timer();
	public static int bulletX2;
	public static int bulletY2;
	public PlayerTwoShip(int hp, int velocity, int armor) {
		super(hp, velocity, armor);		
		Vx=100;
		Vy=300;
		
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
	g.fillArc(PlayerTwoShip.Vx-20, PlayerTwoShip.Vy+33, 100, 50, 270, 180);
	g.setColor(Color.gray);
	
	g2.fillRect(PlayerTwoShip.Vx-40,PlayerTwoShip.Vy + 33,80,50);
	g2.setColor(Color.blue);
	g2.fillOval(PlayerTwoShip.Vx + 2, PlayerTwoShip.Vy+45, 25,25);
	
	g2.setColor(Color.blue);
	g2.fillOval(PlayerTwoShip.Vx - 30, PlayerTwoShip.Vy+45, 25,25);
	
	

	
	g2.setColor(Color.black);
	g2.fillRect(PlayerTwoShip.Vx-70,PlayerTwoShip.Vy+28,15 , 15);
	g2.setColor(Color.black);
	g2.fillRect(PlayerTwoShip.Vx-70,PlayerTwoShip.Vy+33 + 18,15, 15);
	g2.setColor(Color.black);
	g2.fillRect(PlayerTwoShip.Vx-70,PlayerTwoShip.Vy+33 + 40,15 , 15);
	g2.setColor(Color.red);
	g2.fillRect(PlayerTwoShip.Vx-60, PlayerTwoShip.Vy+23,20,70);
	
	g2.setColor(Color.orange);
	g2.fillRect(PlayerTwoShip.Vx -75, PlayerTwoShip.Vy+30, 5,10);
	
	g2.setColor(Color.orange);
	g2.fillRect(PlayerTwoShip.Vx -75, PlayerTwoShip.Vy+53, 5,10);
	
	g2.setColor(Color.orange);
	g2.fillRect(PlayerTwoShip.Vx -75, PlayerTwoShip.Vy+76, 5,10);
	
	g2.setColor(Color.orange);
	g2.fillRect(PlayerTwoShip.Vx -20, PlayerTwoShip.Vy +23, 30,10);
	g2.setColor(Color.red);
	g2.fillArc(PlayerTwoShip.Vx + 2,PlayerTwoShip.Vy+23, 15, 10, 270, 180);
	
	g2.setColor(Color.orange);
	g2.fillRect(PlayerTwoShip.Vx -20, PlayerTwoShip.Vy+83, 30,10);
	g2.setColor(Color.red);
	g2.fillArc(PlayerTwoShip.Vx + 2,PlayerTwoShip.Vy+83, 15, 10, 270, 180);
	
	
}


	
	
}
