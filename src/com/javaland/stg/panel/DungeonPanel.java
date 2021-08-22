package com.javaland.stg.panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/* 이준한 담당 패널 */
/* 푸쉬 시도 */
public class DungeonPanel extends JPanel {

	private Image backImg = new ImageIcon("image/DungeonPanelBackIMG.png").getImage();
	private ImageIcon returnLogo = new ImageIcon("image/return.png");
	private ImageIcon stageLogo1 = new ImageIcon("image/stage1.png");
	private ImageIcon stageLogo2 = new ImageIcon("image/stage2.png");
	private ImageIcon stageLogo3 = new ImageIcon("image/stage3.png");
	private ImageIcon textBossLogo = new ImageIcon("image/textBoss.png");
	private ImageIcon imageMonster1Logo = new ImageIcon("image/imageMonster1.png");
	private ImageIcon imageMonster2Logo = new ImageIcon("image/imageMonster2.png");
	private ImageIcon imageMonster3Logo = new ImageIcon("image/imageMonster3.png");

	private MainPanel mainPanel;
	private ScriptPanel scriptPanel;
	private TownPanel townPanel;
	private StagePanel stagePanel;
	private DungeonPanel dungeonPanel;
	private BattlePanel battlePanel;
	private AdminPanel adminPanel;
	private StorePanel storePanel;

	private JButton returnLogoButton;
	private JButton stageLogo1Button;
	private JButton imageMonster1LogoButton;
	private JButton imageMonster2LogoButton;
	private JButton imageMonster3LogoButton;
	private JButton textBossLogoButton;

	/* 이준한 담당 패널 */
	public DungeonPanel() {
		dungeonPanel = this;
		this.setBounds(0, 0, 1600, 900);
		this.setLayout(null);
		this.setBackground(Color.BLACK);

		/* 리턴로고부착 */
		returnLogoButton = new JButton();
		returnLogoButton.setIcon(returnLogo);
		returnLogoButton.setBounds(70, 170, 360, 200);
		returnLogoButton.setBorderPainted(false);
		returnLogoButton.setContentAreaFilled(false);
		returnLogoButton.setFocusPainted(false);

		/* 스테이지 1 로고부착 */
		stageLogo1Button = new JButton();
		stageLogo1Button.setIcon(stageLogo1);
		stageLogo1Button.setBounds(572, 164, 456, 134);
		stageLogo1Button.setBorderPainted(false);
		stageLogo1Button.setContentAreaFilled(false);
		stageLogo1Button.setFocusPainted(false);

		/* 던전 몬스터 1 버튼부착 */
		imageMonster1LogoButton = new JButton();
		imageMonster1LogoButton.setIcon(imageMonster1Logo);
		imageMonster1LogoButton.setBounds(148, 408, 129, 135);
		imageMonster1LogoButton.setBorderPainted(false);
		imageMonster1LogoButton.setContentAreaFilled(false);
		imageMonster1LogoButton.setFocusPainted(false);

		/* 던전 몬스터 2 버튼부착 */
		imageMonster2LogoButton = new JButton();
		imageMonster2LogoButton.setIcon(imageMonster2Logo);
		imageMonster2LogoButton.setBounds(534, 408, 129, 134);
		imageMonster2LogoButton.setBorderPainted(false);
		imageMonster2LogoButton.setContentAreaFilled(false);
		imageMonster2LogoButton.setFocusPainted(false);

		/* 던전 몬스터 3 버튼부착 */
		imageMonster3LogoButton = new JButton();
		imageMonster3LogoButton.setIcon(imageMonster3Logo);
		imageMonster3LogoButton.setBounds(915, 398, 155, 153);
		imageMonster3LogoButton.setBorderPainted(false);
		imageMonster3LogoButton.setContentAreaFilled(false);
		imageMonster3LogoButton.setFocusPainted(false);

		/* 보스 몬스터 1 버튼부착 */
		textBossLogoButton = new JButton();
		textBossLogoButton.setIcon(textBossLogo);
		textBossLogoButton.setBounds(1268, 513, 164, 103);
		textBossLogoButton.setBorderPainted(false);
		textBossLogoButton.setContentAreaFilled(false);
		textBossLogoButton.setFocusPainted(false);

		/* 버튼 부착 */
		dungeonPanel.add(returnLogo);
		dungeonPanel.add(stageLogo1);
		dungeonPanel.add(imageMonster1Logo);
		dungeonPanel.add(imageMonster2Logo);
		dungeonPanel.add(imageMonster3Logo);
		dungeonPanel.add(textBossLogoButton);

		/* 버튼 구현 */
		this.add(returnLogoButton);
		this.add(stageLogo1Button);
		this.add(imageMonster1LogoButton);
		this.add(imageMonster2LogoButton);
		this.add(imageMonster3LogoButton);
		this.add(textBossLogoButton);
	}

	private void add(ImageIcon returnLogo2) {

	}

	private void add(Image backImg2) {

	}

	public void eventStart() {

		imageMonster1LogoButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				battlePanel.startBattle(2, 1);
				
			}
		});
		
		imageMonster2LogoButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				battlePanel.startBattle(2, 2);
			}
		});
		
		imageMonster3LogoButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				battlePanel.startBattle(2, 3);
				dungeonPanel.setVisible(false);
				battlePanel.setVisible(true);
			}
		});
		
		textBossLogoButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				battlePanel.startBattle(2, 4);
			}
		});
	}

	public void panelInit(ScriptPanel scriptPanel, TownPanel townPanel, StagePanel stagePanel, MainPanel mainPanel,
			BattlePanel battlePanel, AdminPanel adminPanel, StorePanel storePanel) {
		this.scriptPanel = scriptPanel;
		this.townPanel = townPanel;
		this.stagePanel = stagePanel;
		this.mainPanel = mainPanel;
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

		DungeonPanel dungeonPanel = new DungeonPanel();
		dungeonPanel.eventStart();

		mf.add(dungeonPanel);

		mf.setVisible(true);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}