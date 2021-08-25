package com.javaland.stg.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.javaland.stg.controller.CharacterUpdateController;
import com.javaland.stg.model.dto.CharacterDTO;

/* 김지혁 담당 패널 */
public class TownPanel extends JPanel{
	
	Image backImg = new ImageIcon("image/TownPanelBackIMG.png").getImage();
	Image infoImg = new ImageIcon("image/BattleInfo.png").getImage();
	private ImageIcon characterImg = new ImageIcon("image/Character.png");
	private ImageIcon blockImg = new ImageIcon("image/Block.png");
	private ImageIcon nextImg = new ImageIcon("image/NextBtn.png");
	private ImageIcon restImg = new ImageIcon("image/RestBtn.PNG");
	private ImageIcon marketImg = new ImageIcon("image/StoreBtn.png");
	private ImageIcon exitImg = new ImageIcon("image/ExitBtn1.png");
	private ImageIcon yesImg = new ImageIcon("image/yes.png");
	private ImageIcon noImg = new ImageIcon("image/no.png");
	private ImageIcon fullHpImg = new ImageIcon("image/Fullhp.png");

	private CharacterUpdateController characterUpdate = new CharacterUpdateController();
	
	private MainPanel mainPanel;
	private ScriptPanel scriptPanel;
	private TownPanel townPanel;
	private StagePanel stagePanel;
	private DungeonPanel dungeonPanel;
	private BattlePanel battlePanel;
	private AdminPanel adminPanel;
	private StorePanel storePanel;
	
	private CharacterDTO character;
	
	private JPanel blockPanel;
	private JPanel townPanel1;
	private JPanel restPanel;
	
	private JLabel goldLabel;
	private JLabel yesLabel;
	private JLabel noLabel;
	private JLabel characterHpLabel;
	private JLabel blockLabel;
	private JLabel characterLabel;
	private JLabel fullHpLabel;
	
	private JButton nextButton;
	private JButton restButton;
	private JButton storeButton;
	private JButton exitButton;
	private JButton yesButton;
	private JButton noButton;
	private JButton exitButton2;
	
	public TownPanel() {
		townPanel = this;
		this.setBounds(0, 0, 1600, 900);
		this.setLayout(null);
		
		townPanel1 = new JPanel();
		townPanel1.setBounds(0, 0, 1600, 900);
		townPanel1.setLayout(null);
		townPanel1.setOpaque(false);
		
		/* 이동 버튼 */
		nextButton = new JButton();
		nextButton.setBounds(1190, 450, 348, 182);
		nextButton.setBorderPainted(false);
		nextButton.setContentAreaFilled(false);
		nextButton.setFocusPainted(false);
		nextButton.setIcon(nextImg);
		
		/* 휴식 버튼 */
		restButton = new JButton();
		restButton.setBounds(130, 470, 195, 122);
		restButton.setBorderPainted(false);
		restButton.setContentAreaFilled(false);
		restButton.setFocusPainted(false);
		restButton.setIcon(restImg);
		
		/* rest 패널 */
		restPanel = new JPanel();
		restPanel.setLayout(null);
		restPanel.setBounds(0, 0, 1600, 900);
		restPanel.setVisible(false);
		restPanel.setOpaque(false);
		
		/* 체력 회복 라벨 */
		fullHpLabel = new JLabel();
		fullHpLabel.setIcon(fullHpImg);
		fullHpLabel.setBounds(425, 180, 744, 578);
		
		/* 캐릭터 체력 라벨 */
		characterHpLabel = new JLabel();
		characterHpLabel.setHorizontalAlignment(SwingConstants.CENTER);
		characterHpLabel.setFont(new Font("Kreon", Font.PLAIN, 30));
		characterHpLabel.setBounds(555, 500, 100, 30);
		characterHpLabel.setForeground(Color.RED);
		
		/* 상점 버튼 */
		storeButton = new JButton();
		storeButton.setBounds(630, 442, 350, 245);
		storeButton.setBorderPainted(false);
		storeButton.setContentAreaFilled(false);
		storeButton.setFocusPainted(false);
		storeButton.setIcon(marketImg);
		
		/* 나가기 버튼 */
		exitButton = new JButton();
		exitButton.setBounds(1400, 25, 101, 90);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.setIcon(exitImg);
		
		/* 골드 라벨 */
		goldLabel = new JLabel();
		goldLabel.setHorizontalAlignment(SwingConstants.LEFT);
		goldLabel.setFont(new Font("Koren", Font.PLAIN, 30));
		goldLabel.setBounds(170, 13, 200, 50);
		goldLabel.setForeground(new Color(188, 191, 42));
		
		/* 캐릭터 라벨 */
		characterLabel = new JLabel();
		characterLabel.setIcon(characterImg);
		characterLabel.setBounds(445, 380, 420, 547);
		
		/* block 패널 */
		blockPanel = new JPanel();
		blockPanel.setLayout(null);
		blockPanel.setBounds(0, 0, 1600, 900);
		blockPanel.setVisible(false);
		blockPanel.setOpaque(false);
		
		/* block 라벨 */
		blockLabel = new JLabel();
		blockLabel.setIcon(blockImg);
		blockLabel.setBounds(425, 180, 744, 578);
		
		/* 예 버튼 */
		yesButton = new JButton();
		yesButton.setBounds(470, 570, 230, 64);
		yesButton.setBorderPainted(false);
		yesButton.setContentAreaFilled(false);
		yesButton.setFocusPainted(false);
		yesButton.setIcon(yesImg);
		
		
		
		/* 아니오 버튼 */
		noButton = new JButton();
		noButton.setBounds(800, 570, 230, 64);
		noButton.setBorderPainted(false);
		noButton.setContentAreaFilled(false);
		noButton.setFocusPainted(false);
		noButton.setIcon(noImg);
		
		/* 뒤로가기 버튼 */
		exitButton2 = new JButton();
		exitButton2.setIcon(exitImg);
		exitButton2.setBounds(1400, 25, 101, 90);
		exitButton2.setBorderPainted(false);
		exitButton2.setContentAreaFilled(false);
		exitButton2.setFocusPainted(false);
		
		/* 패널 부착 */
		this.add(townPanel1);
		this.add(blockPanel);
		this.add(restPanel);
		
		blockPanel.add(yesButton);
		blockPanel.add(noButton);
		blockPanel.add(exitButton2);
		
		blockPanel.add(blockLabel);		
		
		townPanel1.add(nextButton);		
		townPanel1.add(exitButton);
		townPanel1.add(storeButton);
		townPanel1.add(restButton);
		townPanel1.add(characterHpLabel);
		townPanel1.add(goldLabel);
		townPanel1.add(characterLabel);
		
		restPanel.add(fullHpLabel);
		restPanel.add(exitButton2);
		
		
		
		character = new CharacterDTO();
		characterInforefresh();
	}
	
	
	public void eventStart() {
		
		nextButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				townPanel.setVisible(false);
				stagePanel.setVisible(true);
			}
		});
		
		restButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				/* 휴식 버튼 클릭 시 체력 회복 */
				character.setHp(character.getMaxHp());
				characterUpdate.updatePlayer(character);
				restPanel.setVisible(true);
				townPanel1.setVisible(false);
				
			}
		});
		
		storeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				townPanel.setVisible(false);
				storePanel.setVisible(true);
				
			}
		});
		
		
		exitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				townPanel1.setVisible(false);
				blockPanel.setVisible(true);
				
			}
		});
		
		exitButton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				townPanel1.setVisible(true);
				blockPanel.setVisible(false);
				restPanel.setVisible(false);
				
			}
		});
		
		yesButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				townPanel.setVisible(false);
				blockPanel.setVisible(false);
			}
		});
		
		noButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				townPanel1.setVisible(true);
				blockPanel.setVisible(false);
			}
		});
		
		yesButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				yesButton.setIcon(new ImageIcon("image/yes.png"));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				yesButton.setIcon(new ImageIcon("image/yes_Clicked.png"));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
		noButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				noButton.setIcon(new ImageIcon("image/no.png"));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				noButton.setIcon(new ImageIcon("image/no_Clicked.png"));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
	}
	
	
	
	public void characterInforefresh() {
		characterHpLabel.setText(character.getHp() + "/" + character.getMaxHp());
		goldLabel.setText(character.getGold() + "");
	}
	
	public void panelInit(ScriptPanel scriptPanel, MainPanel mainPanel, StagePanel stagePanel,
			         	  DungeonPanel dungeonPanel, BattlePanel battlePanel, AdminPanel adminPanel, StorePanel storePanel) {
		this.scriptPanel = scriptPanel;
		this.mainPanel = mainPanel;
		this.stagePanel = stagePanel;
		this.dungeonPanel = dungeonPanel;
		this.battlePanel = battlePanel;
		this.adminPanel = adminPanel;
		this.storePanel = storePanel;
		
	}
	
	public void setCharacter(CharacterDTO character) {
		this.character = character;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(backImg, 0, 0, townPanel);
		g.drawImage(infoImg, 0, 10, townPanel);

	}
	
	public static void main(String[] args) {
		
		JFrame mf = new JFrame("Test");
		mf.setSize(1600, 900);
		mf.setLocationRelativeTo(null);
		mf.setLayout(null);
		mf.setResizable(false);
		
		TownPanel townPanel = new TownPanel();
		townPanel.eventStart();
		
		mf.add(townPanel);
	
		mf.setVisible(true);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
