import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameFrame extends JFrame implements KeyListener,MouseListener {
	JFrame gFrame;
	static AlienShip alien1;
	static AlienShip alien2;
	static AlienShip alien3;
	static int level=1;
	public JPanel jp = new GameManager();
	public Bullet bullet=new Bullet();
	public static boolean isFire=false;
	public static boolean isFire2=false;
	public int bx;
	public  int by;
	public int bx2;
	public  int by2;
	public static int bulX;
	public static int bulY;
	public static int bulX2;
	public static int bulY2;
	public int move=30;
	static PlayerOneShip player1=new PlayerOneShip(100,50,50);
	static PlayerTwoShip player2=new PlayerTwoShip(150,80,100);
	static boolean isSpawn=true;
	ImageIcon spaceShip;
	
	public GameFrame() {
		super("Space Game");
		addKeyListener(this);
		addMouseListener(this);
		createAlienShips();
//		spawnShip1();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		gFrame.setVisible(true);
		
	}
	
	public void spawnShip1() {
		spaceShip = new ImageIcon(this.getClass().getResource("as4.png"));

		JLabel shipLabel = new JLabel(spaceShip);
		shipLabel.setBounds(PlayerOneShip.Vx,PlayerOneShip.Vy, 100, 200);
		shipLabel.setSize(80,80);
		add(shipLabel);
	}
	
	

	public static void createAlienShips() {
		if(level==1) {
			 alien1=new AlienShip(1,100,50,550,100);
			 alien2=new AlienShip(3,100,50,700,300);
			 alien3=new AlienShip(0,100,50,900,500);
			 if(isSpawn) {
				 level++;
				 isSpawn=false;
			 }
			 if(level==2) {
				 isSpawn=true;
			 }

			
		}else if(level==2) {
			 alien1=new AlienShip(1,100,50,600,100);
			 alien2=new AlienShip(1,100,50,720,200);
			 alien3=new AlienShip(2,100,50,900,500);
			 if(isSpawn) {
				 level++;
				 isSpawn=false;

				 }
			 if(level==3) {
				 isSpawn=true;
			 }
		}else if(level==3 && GameManager.isSpawn2) {
			 alien1=new AlienShip(3,100,50,620,200);
			 alien2=new AlienShip(3,100,50,750,500);
			 alien3=new AlienShip(2,100,50,900,700);
			 if(isSpawn) {
				 level++;
				 isSpawn=false;

				 
			 }
			 level=3;
			 
		}
	}
	

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_D) {
			if(GameManager.velocity*1000>10) {
				this.move=80;
			}else if(GameManager.velocity*1000>20) {
				this.move=100;
			}
			if(player1.getVx()>580) {
				player1.stopVx();
			}else {
				player1.setVx(this.move);
			}
			
			repaint();
		}else if(e.getKeyCode()==KeyEvent.VK_W) {
			if(GameManager.velocity*1000>10) {
				this.move=80;
			}else if(GameManager.velocity*1000>20) {
				this.move=100;
			}
			if(player1.getVy()<20) {
				player1.stopVy();
			}else {
				player1.setVy(-this.move);
			}

			repaint();
		}else if(e.getKeyCode()==KeyEvent.VK_S) {
			if(GameManager.velocity*1000>10) {
				this.move=80;
			}else if(GameManager.velocity*1000>20) {
				this.move=100;
			}
			if(player1.getVy()>570) {
				player1.stopVy();
			}else {
				player1.setVy(this.move);
			}
			repaint();
		}
		else if(e.getKeyCode()==KeyEvent.VK_A) {
			if(GameManager.velocity*1000>10) {
				this.move=80;
			}else if(GameManager.velocity*1000>20) {
				this.move=100;
			}
			if(player1.getVx()<20) {
				player1.stopVx();
			}else {
				player1.setVx(-this.move);
			}
		
			repaint();
		}else if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			boolean checkX=true;
			if(PlayerOneShip.bulletX<1100) {
				checkX=true;
			}else {
				checkX=false;
			}
			if(PlayerOneShip.bulletX<1100 && checkX) {
				this.bx=PlayerOneShip.bulletX;
				this.by=PlayerOneShip.bulletY;
				GameFrame.bulX=this.bx;
				GameFrame.bulY=this.by;
				isFire=true;
				GameManager.score-=50;
			}
		}else if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			if(GameManager.velocity*1000>10) {
				this.move=80;
			}else if(GameManager.velocity*1000>20) {
				this.move=100;
			}
			if(player2.getVx()>580) {
				player2.stopVx();
			}else {
				player2.setVx(this.move);
			}
			
			repaint();
		}else if(e.getKeyCode()==KeyEvent.VK_UP) {
			if(GameManager.velocity*1000>10) {
				this.move=80;
			}else if(GameManager.velocity*1000>20) {
				this.move=100;
			}
			if(player2.getVy()<20) {
				player2.stopVy();
			}else {
				player2.setVy(-this.move);
			}

			repaint();
		}else if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			if(GameManager.velocity*1000>10) {
				this.move=80;
			}else if(GameManager.velocity*1000>20) {
				this.move=100;
			}
			if(player2.getVy()>570) {
				player2.stopVy();
			}else {
				player2.setVy(this.move);
			}
			repaint();
		}
		else if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			if(GameManager.velocity*1000>10) {
				this.move=80;
			}else if(GameManager.velocity*1000>20) {
				this.move=100;
			}
			if(player2.getVx()<20) {
				player2.stopVx();
			}else {
				player2.setVx(-this.move);
			}
		
			repaint();
		}
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(Layout.twoPlayer) {
			this.bx2=PlayerTwoShip.bulletX2;
			this.by2=PlayerTwoShip.bulletY2;
			GameFrame.bulX2=this.bx2;
			GameFrame.bulY2=this.by2;
			isFire2=true;
			GameManager.score-=50;
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
