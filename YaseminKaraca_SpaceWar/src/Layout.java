import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Layout extends JFrame{

	public static JPanel jp = new GameManager();

	static JTextField txtuserName;
	JButton instButton;
	JButton regButton;
	JButton quitButton;
	JCheckBox subscribeEmail;
	JLabel gamingSkill;
	JLabel highScore;
	static JLabel highScoreText;
	static JList<String> skillList;
	JLabel lblYear;
	JComboBox<Integer> boxYear;
	Container titleBack;
	JFrame askFrame = new JFrame("");
	ImageIcon rocket;
	ImageIcon ufo;
	ImageIcon saturn;
	ImageIcon floating;
	ImageIcon hey;
	ImageIcon img;
	static boolean twoPlayer=false;
	public Layout() {
		super("Space War WW2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Start();
		
	
	}	
	  
	
	public static void openGameFrame(GameFrame  g) {
		
		g.setSize(1200,768);
		g.add(jp);
		g.setVisible(true);
		g.setResizable(false);
	}
	
	public void closeIntro(Layout w) {
		w.dispose();
	}
	
	public void openIntro(Layout w) {
		w.setVisible(true);
	}
	
	public void Start() {
		JPanel jpCenter = new JPanel();
		JPanel titleName = new JPanel();
		
		
		rocket = new ImageIcon(this.getClass().getResource("rocket.gif"));
		ufo = new ImageIcon(this.getClass().getResource("ufo.gif"));
		
	
		JLabel rocketLabel = new JLabel(rocket);
		JLabel ufoLabel = new JLabel(ufo);
		rocketLabel.setSize(400,800);
		

		ufoLabel.setSize(400, 800);
		ufoLabel.setBounds(700,100,500,550);
		
		
		JLabel title = new JLabel("Space War");
		Font titleFont = new Font ("Times New Roman",Font.BOLD,50);
		Font startQuitFont = new Font("Times New Roman", Font.PLAIN,30);
		Font instRegFont = new Font("Times New Roman", Font.PLAIN,20);
		titleName.setBounds(440,70,300,90);
		titleName.setBackground(new Color(59,3,11).brighter());
		title.setForeground(Color.white);
		title.setFont(titleFont);
		jpCenter.setBackground(Color.black);
		jpCenter.setLayout(null);
		add(jpCenter);
		
		JButton startButton = new JButton("Start");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(startQuitFont);
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				multiPlayer();
				closeIntro(Source.w);
			}
		});
		
		JButton instButton = new JButton("How to play");
		instButton.setBackground(Color.black);
		instButton.setForeground(Color.white);
		instButton.setFont(instRegFont);
		instButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Instructions();
			}
			});
		
		JButton regButton = new JButton ("My Profile");
		regButton.setBackground(Color.black);
		regButton.setForeground(Color.white);
		regButton.setFont(instRegFont);
		regButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register();
					
			}
			});
		
		JButton quitButton = new JButton ("Quit");
		quitButton.setBackground(Color.black);
		quitButton.setForeground(Color.white);
		quitButton.setFont(startQuitFont);
		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuitInfo();
			}
			});
		
		startButton.setBounds(520,220,133,50);
		instButton.setBounds(520,300,133,50);
		regButton.setBounds(520,380,133,50);
		quitButton.setBounds(520,460,133,50);

		jpCenter.add(titleName);
		titleName.add(title);
		jpCenter.add(startButton);
		jpCenter.add(instButton);
		jpCenter.add(regButton);
		jpCenter.add(quitButton);
		

		jpCenter.add(rocketLabel);
		jpCenter.add(ufoLabel);
	

		
	}
	

	public void Instructions() {
		new InstFrame();

		
	}

	public void Register() {
		new RegFrame();
												
		}

	public void QuitInfo() {
		
		if ((JOptionPane.showConfirmDialog(null, "Are you sure?", "WARNING",
		        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) ) {
			System.exit(0);
		}
		else {
//			remove(optionType);
			
			openIntro(Source.w);
			
			
		}
	}


	public class InstFrame {
		private JFrame second = new JFrame("Game Controls");
		public InstFrame() {
			JPanel instBack = new JPanel();
			JLabel instTitle = new JLabel("Game Controls");
			
			saturn = new ImageIcon(this.getClass().getResource("unicorn.gif"));
			JLabel saturnLabel = new JLabel(saturn);
		
			saturnLabel.setBounds(100,40,1000,1000);
			
			JPanel player1Back = new JPanel();
			JPanel player2Back = new JPanel();
			JPanel backMove = new JPanel();
			JPanel backShoot = new JPanel();
			JPanel backAngle = new JPanel();
			JLabel player1Title = new JLabel("Player 1");
			JLabel player2Title = new JLabel("Player 2");
			Font playerFont = new Font("Times New Roman", Font.BOLD, 25);
			Font instTitleFont = new Font ("Times New Roman",Font.PLAIN,45);
			Font instAllFont = new Font("Times New Roman", Font.BOLD, 20);
			JLabel moves = new JLabel("Moves: ");
			JLabel wasd = new JLabel("W,A,S,D");
			JLabel shoot = new JLabel("Shooting: ");
			JLabel spaceKey = new JLabel("Space");
			JLabel space2 = new JLabel ("Left-Click");
			JLabel upDown = new JLabel("Arrow keys");
		
			JLabel angle = new JLabel("Angle: ");
			JLabel automatic = new JLabel ("Automatically up&down");
			JLabel automatic2 = new JLabel ("Automatically up&down");
			
			JButton back = new JButton("Back");
			back.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					second.setVisible(false);
					openIntro(Source.w);
				}
				});
			
			second.getContentPane().setBackground(Color.black);
			instBack.setBounds(440,70,300,90);
			instBack.setBackground(new Color(59,3,11));
			instTitle.setForeground(Color.white);
			instTitle.setFont(instTitleFont);
			
			player1Back.setBounds(230,170,170,40);
			player1Back.setBackground(new Color(59,139,139));
			player1Title.setForeground(new Color(255,212,82).brighter());
			player1Title.setFont(playerFont);
			
			player2Back.setBounds(770,170,170,40);
			player2Back.setBackground(new Color(59,139,139));
			player2Title.setForeground(new Color(255,212,82).brighter());
			player2Title.setFont(playerFont);
			
			backMove.setBounds(40,240,100,30);
			backMove.setBackground(Color.orange);
			
			backShoot.setBounds(40,340,100,30);
			backShoot.setBackground(Color.orange);
			
			backAngle.setBounds(40,440,100,30);
			backAngle.setBackground(Color.orange);
			

			moves.setForeground(Color.white);
			moves.setFont(instAllFont);

			wasd.setForeground(Color.white);
			wasd.setFont(instAllFont);
			wasd.setBounds(280,230,110,50);
			shoot.setForeground(Color.white);
			shoot.setFont(instAllFont);
			shoot.setBounds(440,270,120,50);
			spaceKey.setForeground(Color.white);
			spaceKey.setFont(instAllFont);
			spaceKey.setBounds(282,330,110,50);
			
			space2.setForeground(Color.white);
			space2.setFont(instAllFont);
			space2.setBounds(815,330,110,50);
		
		
			
			angle.setForeground(Color.white);
			angle.setFont(instAllFont);
			
			upDown.setForeground(Color.white);
			upDown.setFont(instAllFont);
			upDown.setBounds(809,230,110,50);
			
			automatic.setForeground(Color.white);
			automatic.setFont(instAllFont);
			automatic.setBounds(789,430,250,90);
			
			automatic2.setForeground(Color.white);
			automatic2.setFont(instAllFont);
			automatic2.setBounds(200,430,250,90);
			
			back.setBackground(new Color(59,3,11));
			back.setForeground(Color.white);
			back.setBounds(930,650,100,30);
			
			
			
			second.add(instBack);
			instBack.add(instTitle);
			
			second.add(player1Back);
			player1Back.add(player1Title);
			
			second.add(player2Back);
			player2Back.add(player2Title);
			
			second.add(backMove);
			backMove.add(moves);
			
			second.add(backShoot);
			backShoot.add(shoot);
			
			second.add(backAngle);
			backAngle.add(angle);
			
			
			
			second.add(wasd);

			second.add(spaceKey);
			
			second.add(space2);
		
			
			second.add(upDown);
			
			second.add(automatic);
			second.add(automatic2);
			second.add(back);
	
			second.add(saturnLabel);
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			second.setSize(1200,768);
			closeIntro(Source.w);
			second.setLayout(null);
			second.setVisible(true);
			
		}
	}


	public class RegFrame {
		private JFrame reg = new JFrame("My Profile");
		public RegFrame() {
		
			floating = new ImageIcon(this.getClass().getResource("float.gif"));
			JLabel floatingLabel = new JLabel(floating);
		
			floatingLabel.setBounds(900,400,200,300);
			
			hey = new ImageIcon(this.getClass().getResource("alienGif.gif"));
			JLabel heyLabel = new JLabel(hey);
		
			heyLabel.setSize(100,300);
			heyLabel.setBounds(10,20,400,400);
			
			JPanel profilePanel = new JPanel();
			JLabel profileTitle = new JLabel("My Profile");
			Font profileTitleFont = new Font ("Times New Roman",Font.PLAIN,45);
			Font FontsForAll = new Font("Times New Roman",Font.PLAIN,20);
			JLabel userName = new JLabel("Username: ");
			txtuserName = new JTextField();
			String[] difficultyData = new String[4];
			difficultyData[0] = "Beginner";
			difficultyData[1] = "Easy";
			difficultyData[2] = "Normal";
			difficultyData[3] = "Pro";
			
			gamingSkill = new JLabel("Game Difficulty:");
			skillList = new JList<String>(difficultyData);
			
			highScore = new JLabel("High-Score: ");
			try {
				highScoreText=new JLabel(GameManager.getHighScore());
				if(GameManager.getHighScore()==null) {
					highScoreText=new JLabel("Empty For Now");
				}
				//highScoreText=new JLabel(GameManager.getHighScore());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			JButton jbSave = new JButton ("Save");
			jbSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					saveInfo();
				}
			});
			JButton jbCancel = new JButton("Main Menu");
			jbCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					reg.setVisible(false);
					openIntro(Source.w);
					}
				});

			
			
			reg.getContentPane().setBackground(Color.black);
			
			profilePanel.setBounds(440,70,300,90);
			profilePanel.setBackground(new Color(59,3,11));
			
			profileTitle.setForeground(Color.white);
			profileTitle.setFont(profileTitleFont);

		

			userName.setForeground(Color.white);
			userName.setFont(FontsForAll);
			userName.setBounds(420,190,120,50);
			
			txtuserName.setForeground(Color.black);
			txtuserName.setFont(FontsForAll);
			txtuserName.setBounds(580,192,110,30);
			
			gamingSkill.setForeground(Color.white);
			gamingSkill.setFont(FontsForAll);
			gamingSkill.setBounds(420,240,200,50);
			
			skillList.setForeground(Color.black);
			skillList.setFont(FontsForAll);
			skillList.setBounds(580,242,130,100);
			
			highScore.setForeground(Color.white);
			highScore.setFont(FontsForAll);
			highScore.setBounds(420,400,110,50);
			

			highScoreText.setForeground(Color.white);
			highScoreText.setFont(FontsForAll);
			highScoreText.setBounds(580,400,300,50);
			
			jbSave.setForeground(Color.white);
			jbSave.setBackground(new Color(59,3,11));
			jbSave.setBounds(530,520,110,25);
			jbCancel.setForeground(Color.white);
			jbCancel.setBackground(new Color(59,3,11));
			
			jbCancel.setBounds(530,560,110,25);
			
			reg.add(profilePanel);
			profilePanel.add(profileTitle);
			
		
			reg.add(floatingLabel);
			reg.add(heyLabel);
			reg.add(userName);
			reg.add(txtuserName);
			reg.add(gamingSkill);
			reg.add(skillList);
			reg.add(highScore);
			reg.add(highScoreText);
			reg.add(jbSave);
			reg.add(jbCancel);
			closeIntro(Source.w);
			reg.setSize(1200,768);
			reg.setLayout(null);
			reg.setVisible(true);
		
		}
	}
	public static void saveInfo() {
		String info = "Username: " + txtuserName.getText() + " ";
		info += "\nGame Difficulty: " + skillList.getSelectedValue() + " ";
		info += "\nCurrent Highscore:" + highScoreText.getText() + " ";
		JOptionPane.showMessageDialog(null, info);
	}
	
	public void multiPlayer() {

		Font sinmul = new Font("Times New Roman", Font.BOLD, 20);
		
		img = new ImageIcon(this.getClass().getResource("galaxy.gif"));
		JLabel imgLabel = new JLabel(img);
	
		imgLabel.setBounds(330,170, 510,310);
		
		JButton singlePlayer = new JButton("Single Player");
		JButton multiPlayer = new JButton("Multi Player");
		
		singlePlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openGameFrame(Source.g);
				closeIntro(Source.w);
				twoPlayer=false;
				askFrame.setVisible(false);
			
			}
		
		});

		multiPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Multiplayer!");
				closeIntro(Source.w);
				openGameFrame(Source.g);
				twoPlayer=true;
				askFrame.setVisible(false);
			
			}
		
		});
		
		singlePlayer.setBounds(490,200,200,80);
		singlePlayer.setBackground(new Color(59,139,139));
		singlePlayer.setForeground(Color.white);
		singlePlayer.setFont(sinmul);
		
		multiPlayer.setBounds(490,350,200,80);
		multiPlayer.setBackground(new Color(27,11,43));
		multiPlayer.setFont(sinmul);
		multiPlayer.setForeground(Color.white);
		
		askFrame.add(singlePlayer);
		askFrame.add(multiPlayer);
		
		askFrame.add(imgLabel);
		

		askFrame.getContentPane().setBackground(Color.black);
		askFrame.setSize(1200,768);
		askFrame.setLayout(null);
		askFrame.setVisible(true);
		
	}
	

			
		}
	
	





