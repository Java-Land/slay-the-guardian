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

import com.javaland.stg.model.dto.CharacterDTO;

/* 김지혁 담당 패널 */
public class TownPanel extends JPanel{
	
	Image backImg = new ImageIcon("image/TownPanelBackIMG.png").getImage();
	Image characterImg = new ImageIcon("image/Character.png").getImage();
	Image infoImg = new ImageIcon("image/BattleInfo.png").getImage();
	Image storeImg = new ImageIcon("image/StorePanel.png").getImage();
	Image blockImg = new ImageIcon("image/Block.png").getImage();
	private ImageIcon nextImg = new ImageIcon("image/NextBtn.png");
	private ImageIcon restImg = new ImageIcon("image/RestBtn.PNG");
	private ImageIcon marketImg = new ImageIcon("image/StoreBtn.png");
	private ImageIcon exitImg = new ImageIcon("image/ExitBtn1.png");
	private ImageIcon yesImg = new ImageIcon("image/loginBtn.png");
	private ImageIcon noImg = new ImageIcon("image/loginBtn.png");
	
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
	
	private JLabel goldLabel;
	private JLabel yesLabel;
	private JLabel noLabel;
	private JLabel characterHpLabel;
	
	private JButton nextButton;
	private JButton restButton;
	private JButton storeButton;
	private JButton exitButton;
	private JButton yesButton;
	private JButton noButton;
	
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
		townPanel1.add(nextButton);
		
		/* 휴식 버튼 */
		restButton = new JButton();
		restButton.setBounds(130, 470, 195, 122);
		restButton.setBorderPainted(false);
		restButton.setContentAreaFilled(false);
		restButton.setFocusPainted(false);
		restButton.setIcon(restImg);
		townPanel1.add(restButton);
		
		/* 캐릭터 체력 라벨 */
		characterHpLabel = new JLabel();
		characterHpLabel.setHorizontalAlignment(SwingConstants.CENTER);
		characterHpLabel.setFont(new Font("Kreon", Font.PLAIN, 30));
		characterHpLabel.setBounds(555, 500, 100, 30);
		characterHpLabel.setForeground(Color.RED);
		townPanel1.add(characterHpLabel);
		
		/* 상점 버튼 */
		storeButton = new JButton();
		storeButton.setBounds(630, 442, 350, 245);
		storeButton.setBorderPainted(false);
		storeButton.setContentAreaFilled(false);
		storeButton.setFocusPainted(false);
		storeButton.setIcon(marketImg);
		townPanel1.add(storeButton);
		
		/* 나가기 버튼 */
		exitButton = new JButton();
		exitButton.setBounds(1490, 10, 101, 90);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.setIcon(exitImg);
		townPanel1.add(exitButton);
		
		/* 골드 라벨 */
		goldLabel = new JLabel();
		goldLabel.setHorizontalAlignment(SwingConstants.LEFT);
		goldLabel.setFont(new Font("Koren", Font.PLAIN, 30));
		goldLabel.setBounds(170, 13, 200, 50);
		goldLabel.setForeground(new Color(188, 191, 42));
		townPanel1.add(goldLabel);
		
//		/* block 패널 */
//		blockPanel = new JPanel();
//		blockPanel.setLayout(null);
//		blockPanel.setBounds(450, 200, 650, 500);
//		blockPanel.setVisible(false);
//		blockPanel.setBackground(Color.BLACK);


//		blockPanel.setOpaque(false);
		
		/* 네 버튼 */
		yesButton = new JButton();
		yesButton.setBounds(600, 650, 230, 100);
		yesButton.setBorderPainted(false);
		yesButton.setContentAreaFilled(false);
		yesButton.setFocusPainted(false);
		yesButton.setIcon(yesImg);
//		blockPanel.add(yesButton);
		
		/* 아니오 버튼 */
		noButton = new JButton();
		noButton.setBounds(800, 650, 230, 100);
		noButton.setBorderPainted(false);
		noButton.setContentAreaFilled(false);
		noButton.setFocusPainted(false);
		noButton.setIcon(noImg);
		
//		this.add(blockPanel);
		this.add(townPanel1);
//		this.add(yesButton);
		
		character = new CharacterDTO();
		characterInforefresh();
	}
	
	
	public void eventStart() {
		
		storeButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
			}
		});
		
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
				
			}
		});
		
		storeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				townPanel.setVisible(false);
				storePanel.setVisible(true);
//				storeImg = new ImageIcon("image/StorePanel.png").getImage();
//				repaint();
			}
		});
		
		
		exitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "나가시겠습니까?");
				
//				townPanel1.setVisible(false);
//				blockPanel.setVisible(true);
//				blockPanel.add(yesButton);
				
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
		g.drawImage(characterImg, 445, 550, townPanel);
		g.drawImage(infoImg, 0, 10, townPanel);
//		g.drawImage(blockImg, 250, 200, blockPanel);
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
