import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class AlienShip {
	public int armorLevel;
	public int x;
	public int y;
	int hp;
	int velocity;
	boolean hitGround=true;
	TimerTask setXByTime;
	
	ImageIcon alienImage;

	public AlienShip(int armorLevel,int hp, int velocity,int x,int y){
		super();
		this.hp = hp;
		this.velocity = velocity;
		this.x=x;
		this.y=y;
		this.armorLevel=armorLevel;

		
	}
	
	public void setXandYByTimer() {
		
		Timer setY=new Timer();
		setXByTime = new TimerTask() {
			public void run() {

				setY();
				GameManager.startTime+=1;
			}
		};
		setY.schedule(setXByTime,1000);
	}
	
	public  int getArmorLevel() {
		return armorLevel;
	}
	public void setArmorLevel(int armorLevel) {
		this.armorLevel = armorLevel;
	}
	public  int getX() {
		return x;
	}
//	public  void setX() {
//		if(this.getX()>600 && this.getX()<1100) {
//			//System.out.println(this.getX());
//			Random rand = new Random();
//			int randomNum = rand.nextInt((10 - 0) + 1) + 0;
//			if(randomNum>5) {
//				this.x +=1;
//			}else {
//				this.x -=1;
//			}
//			
//		}else if(this.getX()>1100) {
//			this.x+=1;
//		}else if(this.getX()<600) {
//			this.x-=1;
//		}
//		
//	}
	public  int getY() {
		return y;
	}
	public  void setY() {
		int move=2;
		if(GameManager.velocity*1000>10) {
			move=2*move;
		}else if(GameManager.velocity*1000>20) {
			move=move*(8/3);
		}
		if(this.getY()>0 && hitGround) {
				this.y+=move;
				if(this.getY()>700) {
					hitGround=false;
				}
		}
		else if(!hitGround) {
			this.y-=move;	
			if(this.getY()<20) {
				hitGround=true;
			}
		}
//		else {
//			this.y+=2;
//		}
		
	}
	
	public void alienShip(Graphics g) {
	
		g.setColor(Color.green);
		g.drawOval(this.getX() - 10, this.getY() +10 + 30, 80,18);
		g.setColor(Color.green);
		g.drawOval(this.getX(), this.getY() + 60, 60,15);
		g.setColor(Color.green);
		g.drawOval(this.getX() + 15, this.getY() + 80, 30, 10);
		
		
		g.setColor(new Color(254,191,78));
		g.fillArc(this.getX() - 10,this.getY() + 10,80,40,220,360);
	
		g.setColor(Color.red);
		g.drawOval(this.getX() - 10, this.getY() - 13 + 30, 80,23);
		
		g.setColor(new Color(92,104,156).brighter());
		g.fillArc(this.getX() - 10, this.getY() +10, 80, 30, 220,360);
		g.setColor(new Color(255,255,168));
		g.fillArc(this.getX() + 10, this.getY() + 2, 40, 40, 0, 180);
		g.setColor(Color.green.darker());
		g.fillArc(this.getX() + 20, this.getY() + 12, 20, 20, 0, 180);
		
	
		
	
		 if(this.getArmorLevel()==1) {
			 Graphics2D g2d = (Graphics2D) g;
			 g2d.setColor(Color.red.darker());
			 g2d.drawOval(this.getX()-20,this.getY()-10, 100, 100);
		 }else if(this.getArmorLevel()==2) {
			 Graphics2D g2d = (Graphics2D) g;
			 g2d.setColor(Color.black);
		      g2d.drawOval(this.getX()-20,this.getY()-10, 100, 100);
		      g2d.setColor(Color.yellow);
		      g2d.drawOval(this.getX()-43,this.getY()-35, 150, 150);
		 }
		 else if(this.getArmorLevel()==3) {
			 Graphics2D g2d = (Graphics2D) g;
			 g2d.setColor(Color.black);
			 g2d.drawOval(this.getX()-20,this.getY()-10, 100, 100);
			 g2d.setColor(Color.yellow);
			 g2d.drawOval(this.getX()-43,this.getY()-35, 150, 150);
			 g2d.setColor(Color.LIGHT_GRAY);
			 g2d.drawOval(this.getX()-66,this.getY()-60, 200, 200);
		 }else if(this.getArmorLevel()==-1) {
			 g.clearRect(x -20, y, 100, 100);
			 g.setColor(new Color(64,64,62).darker());
			 g.fillRect(x - 20, y, 100, 100);

			 
			 
		 }
		
	}
	
	public Rectangle collision(Graphics g) {
		if(this.getArmorLevel() == 3) {
			return new Rectangle(this.getX(),this.getY(), 210,210);
		}
		else if(this.getArmorLevel() == 2) {
			return new Rectangle(this.getX(),this.getY(), 160,160);
		}
		else {
			return new Rectangle(this.getX(),this.getY(),110,110);
		}
	};
}
