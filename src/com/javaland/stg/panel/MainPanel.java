package com.javaland.stg.panel;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.javaland.stg.controller.UserController;
import com.javaland.stg.model.dto.CharacterDTO;

/* 김종현 담당 패널 */
public class MainPanel extends JPanel{
	
	private CharacterDTO character = new CharacterDTO();
	private UserController userController = new UserController();
	
	Image backImg = new ImageIcon("image/MainPanelBackIMG.png").getImage();
	ImageIcon logo = new ImageIcon("image/logo.png");
	ImageIcon idText = new ImageIcon("image/textField.png");
	ImageIcon pwText = new ImageIcon("image/textField.png");
	ImageIcon idImg = new ImageIcon("image/id.png");
	ImageIcon pwImg = new ImageIcon("image/pw.png");
	ImageIcon loginImg = new ImageIcon("image/loginBtn.png");
	ImageIcon registerImg = new ImageIcon("image/registerBtn.png");
	ImageIcon confirmImg = new ImageIcon("image/confirm.png");
	ImageIcon exitImg = new ImageIcon("image/exit.png");
	ImageIcon registSuccessImg = new ImageIcon("image/registSuccess.png");
	ImageIcon registFailNoPwdImg = new ImageIcon("image/registFail_noPwd.png");
	ImageIcon registFailWrongPwdImg = new ImageIcon("image/registFail_wrongPwd.png");
	ImageIcon loginSuccessImg = new ImageIcon("image/loginSuccess.png");
	ImageIcon loginFailImg = new ImageIcon("image/loginFail.png");
	ImageIcon okBtnImg = new ImageIcon("image/okBtn.png");
	ImageIcon registFailDupIDImg = new ImageIcon("image/registFail_dupID.png");

	private MainPanel mainPanel;
	private ScriptPanel scriptPanel;
	private TownPanel townPanel;
	private StagePanel stagePanel;
	private DungeonPanel dungeonPanel;
	private BattlePanel battlePanel;
	private AdminPanel adminPanel;
	private StorePanel storePanel;
	
	private JLabel logoLabel;
	private JLabel idLabel;
	private JLabel idLabel2;
	private JLabel pwLabel;
	private JLabel pwLabel2;
	private JLabel confirmPwLabel;
	private JLabel idImgLabel;
	private JLabel idImgLabel2;
	private JLabel pwImgLabel;
	private JLabel pwImgLabel2;
	private JLabel confirmPwImgLabel;
	private JLabel loginSuccesslabel;
	private JLabel loginFaillabel;
	private JLabel registSuccesslabel;
	private JLabel registFailNoPwdlabel;
	private JLabel registFailWrongPwdlabel;
	private JLabel registFailDupIdlabel;
	private JTextField idField;
	private JTextField idField2;
	private JPasswordField pwField;
	private JPasswordField pwField2;
	private JPasswordField confirmPwField;
	
	private JPanel loginPanel;
	private JPanel registPanel;
	private JPanel popUpPanel;
	
	private JButton loginBtn;
	private JButton registerBtn;
	private JButton registerBtn2;
	private JButton exitBtn1;
	private JButton exitBtn2;
	private JButton registOkBtn;
	private JButton okBtn;
	private JButton okBtn2;
	private JButton okBtn3;
	
	public MainPanel() {
		
		mainPanel = this;
		this.setBounds(0, 0, 1600, 900);
		this.setLayout(null);
		
		/* 로그인 패널 */
		loginPanel = new JPanel();
		loginPanel.setLayout(null);
		loginPanel.setBounds(0, 0, 1600, 900);
		loginPanel.setOpaque(false);

		/* 로고 */
		logoLabel = new JLabel();
		logoLabel.setIcon(logo);
		logoLabel.setBounds(475, 50, 600, 350);
		
		/* ID, PW  */
		idField = new JTextField();
		idField.setBounds(625, 430, 560, 110);
		idField.setFont(new Font("Kreon", Font.BOLD, 40));
		idField.setOpaque(false);
		idField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		idLabel = new JLabel();
		idLabel.setIcon(idText);
		idLabel.setBounds(525, 430, 560, 110);
		
		idImgLabel = new JLabel();
		idImgLabel.setIcon(idImg);
		idImgLabel.setBounds(400, 450, 85, 65);
		
		pwField = new JPasswordField();
		pwField.setBounds(625, 550, 560, 110);
		pwField.setFont(new Font("Kreon", Font.BOLD, 40));
		pwField.setOpaque(false);
		pwField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		pwLabel = new JLabel();
		pwLabel.setIcon(pwText);
		pwLabel.setBounds(525, 550, 560, 110);
		
		pwImgLabel = new JLabel();
		pwImgLabel.setIcon(pwImg);
		pwImgLabel.setBounds(375, 580, 110, 50);
		
		/* 로그인버튼, 회원가입버튼 */
		loginBtn = new JButton();
		loginBtn.setIcon(loginImg);
		loginBtn.setBounds(500, 725, 300, 85);
		loginBtn.setBorderPainted(false);
		loginBtn.setContentAreaFilled(false);
		loginBtn.setFocusPainted(false);
		
		registerBtn = new JButton();
		registerBtn.setIcon(registerImg);
		registerBtn.setBounds(850, 725, 300, 85);
		registerBtn.setBorderPainted(false);
		registerBtn.setContentAreaFilled(false);
		registerBtn.setFocusPainted(false);
		
		exitBtn1 = new JButton();
		exitBtn1.setIcon(exitImg);
		exitBtn1.setBounds(1400, 25, 101, 90);
		exitBtn1.setBorderPainted(false);
		exitBtn1.setContentAreaFilled(false);
		exitBtn1.setFocusPainted(false);
		
		/* 회원 가입 패널 */
		registPanel = new JPanel();
		registPanel.setLayout(null);
		registPanel.setVisible(false);
		registPanel.setBounds(0, 0, 1600, 900);
		registPanel.setOpaque(false);
		
		/* ID, PW  */
		idField2 = new JTextField();
		idField2.setBounds(625, 235, 560, 110);
		idField2.setFont(new Font("Kreon", Font.BOLD, 40));
		idField2.setOpaque(false);
		idField2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		idLabel2 = new JLabel();
		idLabel2.setIcon(idText);
		idLabel2.setBounds(525, 235, 560, 110);
		
		idImgLabel2 = new JLabel();
		idImgLabel2.setIcon(idImg);
		idImgLabel2.setBounds(400, 250, 85, 65);
		
		pwField2 = new JPasswordField();
		pwField2.setBounds(625, 375, 560, 110);
		pwField2.setFont(new Font("Kreon", Font.BOLD, 40));
		pwField2.setOpaque(false);
		pwField2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		confirmPwField = new JPasswordField();
		confirmPwField.setBounds(625, 525, 560, 110);
		confirmPwField.setFont(new Font("Kreon", Font.BOLD, 40));
		confirmPwField.setOpaque(false);
		confirmPwField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		pwLabel2 = new JLabel();
		pwLabel2.setIcon(pwText);
		pwLabel2.setBounds(525, 375, 560, 110);
		
		confirmPwLabel = new JLabel();
		confirmPwLabel.setIcon(pwText);
		confirmPwLabel.setBounds(525, 525, 560, 110);
		
		pwImgLabel2 = new JLabel();
		pwImgLabel2.setIcon(pwImg);
		pwImgLabel2.setBounds(375, 400, 110, 50);
		
		confirmPwImgLabel = new JLabel();
		confirmPwImgLabel.setIcon(confirmImg);
		confirmPwImgLabel.setBounds(130, 545, 353, 53);
		
		/* 회원가입 버튼 */
		registerBtn2 = new JButton();
		registerBtn2.setIcon(registerImg);
		registerBtn2.setBounds(650, 700, 300, 85);
		registerBtn2.setBorderPainted(false);
		registerBtn2.setContentAreaFilled(false);
		registerBtn2.setFocusPainted(false);
		
		/* 뒤로가기 버튼 */
		exitBtn2 = new JButton();
		exitBtn2.setIcon(exitImg);
		exitBtn2.setBounds(1400, 25, 101, 90);
		exitBtn2.setBorderPainted(false);
		exitBtn2.setContentAreaFilled(false);
		exitBtn2.setFocusPainted(false);
		
		/* 팝업창 패널 */
		popUpPanel = new JPanel();
		popUpPanel.setLayout(null);
		popUpPanel.setVisible(false);
		popUpPanel.setBounds(0, 0, 1600, 900);
		popUpPanel.setOpaque(false);
		
		/* 로그인 팝업 */
		loginSuccesslabel = new JLabel();
		loginSuccesslabel.setVisible(false);
		loginSuccesslabel.setIcon(loginSuccessImg);
		loginSuccesslabel.setBounds(425, 180, 744, 578);
		
		loginFaillabel = new JLabel();
		loginFaillabel.setVisible(false);
		loginFaillabel.setIcon(loginFailImg);
		loginFaillabel.setBounds(425, 180, 744, 578);
		
		okBtn = new JButton();
		okBtn.setVisible(false);;
		okBtn.setIcon(okBtnImg);
		okBtn.setBounds(690, 650, 236, 66);
		okBtn.setBorderPainted(false);
		okBtn.setContentAreaFilled(false);
		okBtn.setFocusPainted(false);
		
		okBtn2 = new JButton();
		okBtn2.setVisible(false);;
		okBtn2.setIcon(okBtnImg);
		okBtn2.setBounds(690, 650, 236, 66);
		okBtn2.setBorderPainted(false);
		okBtn2.setContentAreaFilled(false);
		okBtn2.setFocusPainted(false);
		
		okBtn3 = new JButton();
		okBtn3.setVisible(false);;
		okBtn3.setIcon(okBtnImg);
		okBtn3.setBounds(690, 650, 236, 66);
		okBtn3.setBorderPainted(false);
		okBtn3.setContentAreaFilled(false);
		okBtn3.setFocusPainted(false);
		
		registOkBtn = new JButton();
		registOkBtn.setVisible(false);;
		registOkBtn.setIcon(okBtnImg);
		registOkBtn.setBounds(690, 650, 236, 66);
		registOkBtn.setBorderPainted(false);
		registOkBtn.setContentAreaFilled(false);
		registOkBtn.setFocusPainted(false);
		
		/* 회원가입 팝업 */
		registSuccesslabel = new JLabel();
		registSuccesslabel.setVisible(false);
		registSuccesslabel.setIcon(registSuccessImg);
		registSuccesslabel.setBounds(425, 180, 744, 578);
		
		registFailNoPwdlabel = new JLabel();
		registFailNoPwdlabel.setVisible(false);
		registFailNoPwdlabel.setIcon(registFailNoPwdImg);
		registFailNoPwdlabel.setBounds(425, 180, 744, 578);
		
		registFailWrongPwdlabel = new JLabel();
		registFailWrongPwdlabel.setVisible(false);
		registFailWrongPwdlabel.setIcon(registFailWrongPwdImg);
		registFailWrongPwdlabel.setBounds(425, 180, 744, 578);
		
		registFailDupIdlabel = new JLabel();
		registFailDupIdlabel.setVisible(false);
		registFailDupIdlabel.setIcon(registFailDupIDImg);
		registFailDupIdlabel.setBounds(425, 180, 744, 578);
		
		/* 패널 부착 */
		loginPanel.add(logoLabel);
		loginPanel.add(idImgLabel);
		loginPanel.add(idField);
		loginPanel.add(idLabel);
		loginPanel.add(pwImgLabel);
		loginPanel.add(pwField);
		loginPanel.add(pwLabel);
		loginPanel.add(loginBtn);
		loginPanel.add(registerBtn);
		loginPanel.add(exitBtn1);
		
		registPanel.add(idImgLabel2);
		registPanel.add(idField2);
		registPanel.add(idLabel2);
		registPanel.add(pwImgLabel2);
		registPanel.add(pwField2);
		registPanel.add(pwLabel2);
		registPanel.add(confirmPwImgLabel);
		registPanel.add(confirmPwField);
		registPanel.add(confirmPwLabel);
		registPanel.add(registerBtn2);
		registPanel.add(exitBtn2);
		
		popUpPanel.add(okBtn);
		popUpPanel.add(okBtn2);
		popUpPanel.add(okBtn3);
		popUpPanel.add(registOkBtn);
		popUpPanel.add(loginSuccesslabel);
		popUpPanel.add(registSuccesslabel);
		popUpPanel.add(registFailWrongPwdlabel);
		popUpPanel.add(registFailNoPwdlabel);
		popUpPanel.add(registFailDupIdlabel);
		popUpPanel.add(loginFaillabel);

		this.add(popUpPanel);
		this.add(loginPanel);
		this.add(registPanel);
	}
	
	public void eventStart() {
		loginBtn.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				loginBtn.setIcon(new ImageIcon("image/loginBtn.png"));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				loginBtn.setIcon(new ImageIcon("image/loginBtn_Clicked.png"));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
		registerBtn.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				registerBtn.setIcon(new ImageIcon("image/registerBtn.png"));
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				registerBtn.setIcon(new ImageIcon("image/registerBtn_Clicked.png"));
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		registerBtn2.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				registerBtn2.setIcon(new ImageIcon("image/registerBtn.png"));
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				registerBtn2.setIcon(new ImageIcon("image/registerBtn_Clicked.png"));
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		loginBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				/* 로그인 버튼 입력 시 userController로 캐릭터 정보 전달 */
				String id = idField.getText();
				String pw = Arrays.toString(pwField.getPassword());
				
				Map<String, String> map = new HashMap<String, String>();
				map.put("ID", id);
				map.put("PW", pw);
				
				int loginResult = userController.loginSuccess(map);
				
				if (loginResult == 1) {									// 로그인 성공
					popUpPanel.setVisible(true);
					loginSuccesslabel.setVisible(true);
					okBtn.setVisible(true);
					
					battlePanel.setCharacter(character);				
					loginPanel.setVisible(false);
				} else if (loginResult == 0) {							// 비밀번호 불일치
					popUpPanel.setVisible(true);
					loginFaillabel.setVisible(true);
					okBtn2.setVisible(true);
				} else if (loginResult == -1) {							// 아이디 없음
					popUpPanel.setVisible(true);
					loginFaillabel.setVisible(true);
					okBtn2.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "DB 오류");
				}

			}
		});
	
		
		registerBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				loginPanel.setVisible(false);
				registPanel.setVisible(true);
				
			}
		});
		
		registerBtn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				/* 아이디와 비밀번호 userController로 전달 */
				String id = idField2.getText();
				String pw = Arrays.toString(pwField2.getPassword());
				String confirmPw = Arrays.toString(confirmPwField.getPassword());
				
				int sameIdResult = userController.selectSameId(id);
				
				
				if (pw.equals(confirmPw) && pw != "[]" && sameIdResult != -1) {			// 회원 가입 성공
					Map<String, String> map = new HashMap<>();
					map.put("ID", id);
					map.put("PW", pw);
					
					userController.registPlayer(map);
					int infoResult = userController.registInfo(map);
					
					popUpPanel.setVisible(true);
					registSuccesslabel.setVisible(true);
					registOkBtn.setVisible(true);
					
				} else if (pw == "[]") {												// 비밀번호 미입력
					popUpPanel.setVisible(true);
					registFailNoPwdlabel.setVisible(true);
					okBtn3.setVisible(true);
				} else if (sameIdResult == -1) {										// 아이디 중복
					popUpPanel.setVisible(true);
					registFailDupIdlabel.setVisible(true);
					okBtn3.setVisible(true);
				} else {																// 비밀번호 다름
					popUpPanel.setVisible(true);
					registFailWrongPwdlabel.setVisible(true);
					okBtn3.setVisible(true);
				}
				
			}
		});
		
		exitBtn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		exitBtn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				registPanel.setVisible(false);
				loginPanel.setVisible(true);
				
			}
		});
		
		exitBtn1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				exitBtn1.setIcon(new ImageIcon("image/exit.png"));
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				exitBtn1.setIcon(new ImageIcon("image/exit_Clicked.png"));
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	
		exitBtn2.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				exitBtn2.setIcon(new ImageIcon("image/exit.png"));
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				exitBtn2.setIcon(new ImageIcon("image/exit_Clicked.png"));
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	
		okBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				popUpPanel.setVisible(false);
				okBtn.setVisible(false);
			}
		});
	
		okBtn.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				okBtn.setIcon(new ImageIcon("image/okBtn.png"));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				okBtn.setIcon(new ImageIcon("image/okBtn_Clicked.png"));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	
		okBtn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				popUpPanel.setVisible(false);
				loginFaillabel.setVisible(false);
				okBtn2.setVisible(false);
				
				idField.setText("");
				idField.requestFocus();
				pwField.setText("");
			}
		});
	
		okBtn2.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				okBtn2.setIcon(new ImageIcon("image/okBtn.png"));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				okBtn2.setIcon(new ImageIcon("image/okBtn_Clicked.png"));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		okBtn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				popUpPanel.setVisible(false);
				registFailNoPwdlabel.setVisible(false);
				registFailWrongPwdlabel.setVisible(false);
				registFailDupIdlabel.setVisible(false);
				okBtn3.setVisible(false);
				
				pwField2.setText("");
				confirmPwField.setText("");
				pwField2.requestFocus();
			}
		});
	
		okBtn3.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				okBtn3.setIcon(new ImageIcon("image/okBtn.png"));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				okBtn3.setIcon(new ImageIcon("image/okBtn_Clicked.png"));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	
		registOkBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				popUpPanel.setVisible(false);
				registPanel.setVisible(false);
				registSuccesslabel.setVisible(false);
				registOkBtn.setVisible(false);
				
				loginPanel.setVisible(true);
			}
		});
		
		registOkBtn.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				registOkBtn.setIcon(new ImageIcon("image/okBtn.png"));
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				registOkBtn.setIcon(new ImageIcon("image/okBtn_Clicked.png"));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public void panelInit(ScriptPanel scriptPanel, TownPanel townPanel, StagePanel stagePanel,
			         DungeonPanel dungeonPanel, BattlePanel battlePanel, AdminPanel adminPanel, StorePanel storePanel) {
		this.scriptPanel = scriptPanel;
		this.townPanel = townPanel;
		this.stagePanel = stagePanel;
		this.dungeonPanel = dungeonPanel;
		this.battlePanel = battlePanel;
		this.adminPanel = adminPanel;
		this.storePanel = storePanel;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(backImg, 0, 0, this);
	}
	
	public static void main(String[] args) {
		
		JFrame mf = new JFrame("Test");
		mf.setSize(1600, 900);
		mf.setLocationRelativeTo(null);
		mf.setLayout(null);
		mf.setResizable(false);
		
		MainPanel mainPanel = new MainPanel();
		mainPanel.eventStart();
		
		mf.add(mainPanel);
		
	
		mf.setVisible(true);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
