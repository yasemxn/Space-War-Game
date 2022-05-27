import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Timer;
import java.util.TimerTask;

public class Bullet {
	
	public Bullet() {
		
	}
	
	public void spawnBullet(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.orange);
		g2.fillRect(GameFrame.bulX,GameFrame.bulY-25,45,40);
		g2.setColor(Color.red);
		g2.fillArc(GameFrame.bulX+20,GameFrame.bulY-25, 50, 40, 270, 180);
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
//				GameFrame.bx=playerShipTriangle.bulletX;
//				GameFrame.by=playerShipTriangle.bulletY;
				if(GameFrame.bulX>2000) {
//					System.out.println("done");
					timer.cancel();
					GameFrame.isFire=false;

				}else {
					if(GameManager.velocity*1000>10) {
						GameFrame.bulX+=8;
					}else if(GameManager.velocity*1000>20) {
						GameFrame.bulX+=11;;
					}else {
						GameFrame.bulX+=6;
					}
					
					
				}
				
			}
			
		},400);	
		
	}
	public void spawnBullet2(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.yellow);
		g2.fillRect(GameFrame.bulX2,GameFrame.bulY2-25,45,40);
		g2.setColor(Color.red);
		g2.fillArc(GameFrame.bulX2+20,GameFrame.bulY2-25, 50, 40, 270, 180);
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
//				GameFrame.bx=playerShipTriangle.bulletX;
//				GameFrame.by=playerShipTriangle.bulletY;
				if(GameFrame.bulX2>2000) {
//					System.out.println("done");
					timer.cancel();
					GameFrame.isFire2=false;

				}else {
					if(GameManager.velocity*1000>10) {
						GameFrame.bulX2+=9;
					}else if(GameManager.velocity*1000>20) {
						GameFrame.bulX2+=12;;
					}else {
						GameFrame.bulX2+=7;
					}
					
					
				}
				
			}
			
		},400);	
		
	}
	
	public Rectangle collision(Graphics g) {
		return new Rectangle(GameFrame.bulX+20, GameFrame.bulY-25,55,45);

	}
	public Rectangle collision2(Graphics g) {
		return new Rectangle(GameFrame.bulX2+20, GameFrame.bulY2-25,55,45);

	}
}
