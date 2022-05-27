import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class GameManager extends JPanel {

	Bullet bullet1;
	Bullet bullet2;
	static boolean isSpawn2=false;
	public static double velocity=0.008;
	public static int bulletX2;
	public static int bulletY2;
	public static int bulletVelocity=0;
	public static int level=GameFrame.level;
	boolean isInside = true;
	boolean isInsideSecond = true;
	public  int alienAlive=3;
	public static int startTime=0;
	public static String highScore="";
	static int score=0;
	Image spaceShip;
	ImageIcon neptune;
    ImageIcon shot;

	static JFrame levelFrame2 = new JFrame("");
    static JFrame levelFrame = new JFrame("");
    static JFrame levelFrame1 = new JFrame("");
	public void paint(Graphics g) {
		super.paint(g);
		setBackground(new Color(64,64,62).darker());
		if(alienAlive != 0) {
			
			alienSpawn(g);
			
		}else {
			cheackAliens();
		}
		if(Layout.twoPlayer) {
			GameFrame.player1.ship(g);		aimTracker1(g);
			GameFrame.player2.ship(g);
			aimTracker2(g);
			repaint();
		}else {
			GameFrame.player1.ship(g);
			aimTracker1(g);
			repaint();
		}
		if(GameFrame.isFire) {
			bullet1 = new Bullet();
			bullet1.spawnBullet(g);
			checkCollision(g,bullet1);

		}
		if(GameFrame.isFire2) {
			bullet2 = new Bullet();
			bullet2.spawnBullet2(g);
			checkCollision(g,bullet2);
		}
		information(g);
		if(GameManager.highScore=="") {
			try {
				GameManager.highScore=GameManager.getHighScore();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public void aimTracker1(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.GREEN);
		int bulletFinalX=PlayerOneShip.Vx+180+PlayerOneShip.i;
		int bulletFinalY=PlayerOneShip.Vy+60+PlayerOneShip.j;
		PlayerOneShip.bulletX=bulletFinalX;
		PlayerOneShip.bulletY=bulletFinalY;
		Line2D line = new Line2D.Double(PlayerOneShip.Vx+80, PlayerOneShip.Vy+60, PlayerOneShip.bulletX, PlayerOneShip.bulletY);
		g2.draw(line);
		PlayerOneShip.timer.schedule(new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				PlayerOneShip.i= (int) (PlayerOneShip.length*(Math.cos(PlayerOneShip.angle)));
				PlayerOneShip.j=(int) (PlayerOneShip.length*(Math.sin(PlayerOneShip.angle)));
				PlayerOneShip.angle=PlayerOneShip.angle+(velocity*Math.PI);
				repaint();
			}
			
		},PlayerOneShip.time);	
	}

	
	public void aimTracker2(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.RED);
		int bulletFinalX=PlayerTwoShip.Vx+180+PlayerTwoShip.i;
		int bulletFinalY=PlayerTwoShip.Vy+60+PlayerTwoShip.j;
		PlayerTwoShip.bulletX2=bulletFinalX;
		PlayerTwoShip.bulletY2=bulletFinalY;
		Line2D line = new Line2D.Double(PlayerTwoShip.Vx+80, PlayerTwoShip.Vy+60, PlayerTwoShip.bulletX2, PlayerTwoShip.bulletY2);
		g2.draw(line);
		PlayerTwoShip.timer.schedule(new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				PlayerTwoShip.i= (int) (PlayerTwoShip.length*(Math.cos(PlayerTwoShip.angle)));
				PlayerTwoShip.j=(int) (PlayerTwoShip.length*(Math.sin(PlayerTwoShip.angle)));
				PlayerTwoShip.angle=PlayerTwoShip.angle+(velocity*Math.PI);
				repaint();
			}
			
		},PlayerTwoShip.time);	
	}
	
	public void checkScore() {
		if(GameManager.highScore==null) {
			GameManager.highScore="nobody:0";
		}
		if(GameManager.score>Integer.parseInt(GameManager.highScore.split(":")[1])) {
			String name = JOptionPane.showInputDialog("You set a new HighScore. What is your name? ");
			highScore=name+":"+score;
			File scoreFile=new File("HighScore.txt");
			if(!scoreFile.exists()) {
				try {
					scoreFile.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			FileWriter writeFile=null;
			BufferedWriter writer=null;
			try {
				writeFile=new FileWriter(scoreFile);
				writer=new BufferedWriter(writeFile);
				writer.write(GameManager.highScore);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {
					if(writer!=null) {
						writer.close();
					}
				}
				catch(Exception e) {
					
				}
			}
		}else {
			JOptionPane.showMessageDialog(null,"Sorry it is not The Highest Score :((");
		}
	}
	public static String getHighScore() throws IOException {
		FileReader readFile=null;
		BufferedReader reader = null;
		try {
			readFile =new FileReader("HighScore.txt");
			reader=new BufferedReader(readFile);
			return reader.readLine();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			return "Nobody:0";
		}
		finally {
			try {
				if(reader!=null) {
					reader.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	public void cheackAliens() {
		if(alienAlive==0 ) {
			
			Check(levelFrame2,levelFrame,levelFrame1);
		}else {
			levelFrame2.disable();
			levelFrame2.dispose();
			levelFrame2.setVisible(false);
			levelFrame.disable();
			levelFrame.dispose();
			levelFrame.setVisible(false);
			levelFrame1.disable();
			levelFrame1.dispose();
			levelFrame1.setVisible(false);
		}
	}
	
	


	
	
	
	
	public void alienSpawn(Graphics g) {
		if(level==1) {
			GameFrame.alien1.alienShip(g);
			GameFrame.alien2.alienShip(g);
			GameFrame.alien3.alienShip(g);
			GameFrame.alien3.setXandYByTimer();
		}else if(level==2) {
			GameFrame.alien1.alienShip(g);
			GameFrame.alien2.alienShip(g);
			GameFrame.alien3.alienShip(g);
			GameFrame.alien3.setXandYByTimer();
			isSpawn2=true;
			
			//GameFrame.alien3.setXandYByTimer();
		}else if(level==3)  {
			GameFrame.alien1.alienShip(g);
			GameFrame.alien2.alienShip(g);
			GameFrame.alien3.alienShip(g);
			GameFrame.alien3.setXandYByTimer();
		}
	}
	
	public void checkCollision(Graphics g, Bullet bullet) {
		Rectangle bulletCollision = null;
		if(bullet==bullet1) {
			 bulletCollision = bullet.collision(g);
		}else if(bullet==bullet2) {
			 bulletCollision = bullet.collision2(g);
		}
		
		Rectangle alienCollision1 = GameFrame.alien1.collision(g);
		Rectangle alienCollision2 = GameFrame.alien2.collision(g);
		Rectangle alienCollision3 = GameFrame.alien3.collision(g);
		if(GameFrame.bulX+20 > 1200) {
			isInside = true;
		}else if(GameFrame.bulX2+20>1200) {
			isInsideSecond=true;
		}else
		if(  isInside || isInsideSecond) {
			if(bulletCollision.intersects(alienCollision1)) {

				switch(GameFrame.alien1.getArmorLevel()) {
					case 3: 
						GameFrame.alien1.setArmorLevel(2);
						score+=100;
						repaint();
						break;
					case 2:
						GameFrame.alien1.setArmorLevel(1);
						score+=100;
						repaint();
						break;
					case 1:
						GameFrame.alien1.setArmorLevel(0);
						score+=100;
						repaint();
						break;
					case 0:
						GameFrame.alien1.setArmorLevel(-1);
						score+=300;
						alienAlive-=1;
						repaint();
						break;
					case -1:
						break;
					default:
						break;
				}
				isInside = false;
				isInsideSecond=false;
				}
			else if(bulletCollision.intersects(alienCollision2)) {

				switch(GameFrame.alien2.getArmorLevel()) {
					case 3: 
						GameFrame.alien2.setArmorLevel(2);
						score+=100;
						repaint();
						break;
					case 2:
						GameFrame.alien2.setArmorLevel(1);
						score+=100;
						repaint();
						break;
					case 1:
						GameFrame.alien2.setArmorLevel(0);
						score+=100;
						repaint();
						break;
					case 0:
						GameFrame.alien2.setArmorLevel(-1);
						alienAlive-=1;
						score+=300;
						repaint();
						break;
					case -1:
						break;
					default:
						break;
						}
				
				isInside = false;
				isInsideSecond=false;
				}
			else if(bulletCollision.intersects(alienCollision3)) {
				switch(GameFrame.alien3.getArmorLevel()) {
					case 3: 
						GameFrame.alien3.setArmorLevel(2);
						score+=100;
						repaint();
						break;
					case 2:
						GameFrame.alien3.setArmorLevel(1);
						score+=100;
						repaint();
						break;
					case 1:
						GameFrame.alien3.setArmorLevel(0);
						score+=100;
						break;
					case 0:
						GameFrame.alien3.setArmorLevel(-1);
						score+=300;
						alienAlive-=1;
						repaint();
						break;
					case -1:
						break;
					default:
						break;
					}
				isInside = false;
				isInsideSecond=false;
				}
			}
		}
	

	public void information(Graphics g) {
		int angle=PlayerOneShip.j;
		g.setColor(Color.white);
		g.drawString("Velocity: " + GameManager.velocity*1000, 1000, 650);
		g.drawString("Score: " + GameManager.score , 1100, 650);
		g.drawString("Time: " + GameManager.startTime/60, 1000, 700);
		g.drawString("Angle: " + angle, 1100, 700);
	}
	

	public void Check(JFrame levelFrame,JFrame levelFrame2, JFrame levelFrame1) {
		GameFrame.createAlienShips();
		
		neptune = new ImageIcon(this.getClass().getResource("463f.gif"));
        JLabel neptuneLabel = new JLabel(neptune);
 
        neptuneLabel.setBounds(350,480, 500,100);
		JPanel gameTitle = new JPanel();
		JLabel gameName = new JLabel("Space War");
		Font checkFont = new Font ("Times New Roman", Font.PLAIN, 30);
		Font titleFont = new Font("Times New Roman", Font.PLAIN, 50);
		gameTitle.setBounds(460,70,300,60);
		gameTitle.setBackground(new Color(59,3,11).brighter());
		gameName.setForeground(Color.white);
		gameName.setFont(titleFont);
		
		shot = new ImageIcon(this.getClass().getResource("shot.gif"));
        JLabel shotLabel = new JLabel(shot);
        shotLabel.setBounds(350,280, 700,100);
		if(level ==1 ) {
			levelFrame.getContentPane().setBackground(Color.black);
			levelFrame.setSize(1200,768);
			levelFrame.setLayout(null);
			levelFrame.setVisible(true);
			levelFrame.setResizable(false);
			JLabel message = new JLabel("Congratulations!! Level " + level + " is done.");
			JButton next = new JButton("Next Level");
			next.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					level++;
					repaint();
					levelFrame.dispose();
					levelFrame.setVisible(false);
					alienAlive = 3;
					
				}
			});
			
			;
			
			message.setBounds(400,100,500,500);
			message.setFont(checkFont);
			message.setForeground(Color.white);
			next.setBounds(930,650,100,30);
			next.setBackground(new Color(59,3,11).brighter());
			next.setForeground(Color.white);
			GameManager.velocity=0.008;
			levelFrame.add(gameTitle);
			gameTitle.add(gameName);
			levelFrame.add(neptuneLabel);
			levelFrame.add(message);
			levelFrame.add(next);
			

			if(GameManager.startTime/60<90) {
				GameManager.velocity=0.012;
				score+=100;
			}else if(GameManager.startTime/60<140) {
				GameManager.velocity=0.018;
				score+=1000;
			}
		}else if(level==2) {
				levelFrame1.getContentPane().setBackground(Color.black);
				levelFrame1.setSize(1200,768);
				levelFrame1.setLayout(null);
				levelFrame1.setVisible(true);
				levelFrame1.setResizable(false);
				JLabel message = new JLabel("Congratulations!! Level " + level + " is done.");
				JButton next = new JButton("Next Level");
				next.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						level++;
						repaint();
						levelFrame1.dispose();
						levelFrame1.setVisible(false);
						alienAlive = 3;
						
					}
				});
				
				;
				
				message.setBounds(400,100,500,500);
				message.setFont(checkFont);
				message.setForeground(Color.white);
				next.setBounds(930,650,100,30);
				next.setBackground(new Color(59,3,11).brighter());
				next.setForeground(Color.white);
				
				levelFrame1.add(gameTitle);
				gameTitle.add(gameName);
				levelFrame1.add(neptuneLabel);
				levelFrame1.add(message);
				levelFrame1.add(next);
				

				if(GameManager.startTime/60<80) {
					GameManager.velocity=0.012;
					score+=200;
				}
				
		}
		else if ( level >= 3) {
			Source.g.dispose();
			Source.g.setVisible(false);
			levelFrame2.getContentPane().setBackground(Color.black);
			levelFrame2.setSize(1200,768);
			levelFrame2.setLayout(null);
			levelFrame2.setVisible(true);
			levelFrame2.setResizable(false);
			JLabel message2 = new JLabel("You won the game!");
			JButton jbCancel = new JButton("Return to Main Menu");
			JButton jbSave = new JButton ("Save");;
			jbSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(GameManager.velocity==0.012) {
						score+=200;
					}else if(GameManager.velocity==0.018) {
						score+=500;
					}
					
					checkScore();
					GameFrame.level=0;
					GameManager.velocity=0.009;
					GameManager.startTime=0;

				}
			});
			jbCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					levelFrame2.dispose();
					levelFrame2.setVisible(false);
					Source.w.setSize(1200,768);
					Source.w.setVisible(true);
					Source.w.setResizable(false);
					alienAlive = 3;
					GameFrame.level=0;
					GameManager.velocity=0.009;
					level=1;
					score=0;
					GameManager.startTime=0;

					
				}
			});

			
			message2.setBounds(500,90,500,500);
			message2.setFont(checkFont);
			message2.setForeground(Color.white);
			
			jbSave.setForeground(Color.white);
			jbSave.setBackground(new Color(59,3,11).brighter());
			jbSave.setBounds(510,520,200,25);
			jbCancel.setForeground(Color.white);
			jbCancel.setBackground(new Color(59,3,11).brighter());
			jbCancel.setBounds(510,560,200,25);
			
			levelFrame2.add(gameTitle);
			gameTitle.add(gameName);
			levelFrame2.add(message2);
			levelFrame2.add(jbSave);
			levelFrame2.add(jbCancel);
			levelFrame2.add(shotLabel);

		}
		
	}
}
	
