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
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/* 이준한 담당 패널 */
/* 푸쉬 시도 */
/* 테스트 */
public class DungeonPanel extends JPanel {

	private Image backImg = new ImageIcon("image/DungeonPanelBackIMG.png").getImage();
	private ImageIcon returnLogo = new ImageIcon("image/return.png");
	private ImageIcon stageLogo1 = new ImageIcon("image/stage1.png");
	private ImageIcon stageLogo2 = new ImageIcon("image/stage2.png");
	private ImageIcon stageLogo3 = new ImageIcon("image/stage3.png");

	private ImageIcon monster1 = new ImageIcon("image/monster1.png");
	private ImageIcon monster2 = new ImageIcon("image/monster2.png");
	private ImageIcon monster3 = new ImageIcon("image/monster3.png");
	private ImageIcon bossMonster1 = new ImageIcon("image/champicon.png");

	private ImageIcon monster1Text = new ImageIcon("image/monster1Text.png");
	private ImageIcon monster2Text = new ImageIcon("image/monster2Text.png");
	private ImageIcon monster3Text = new ImageIcon("image/monster3Text.png");
	private ImageIcon bossMonster1Text = new ImageIcon("image/bossMonster1Text.png");

	private MainPanel mainPanel;
	private ScriptPanel scriptPanel;
	private TownPanel townPanel;
	private StagePanel stagePanel;
	private DungeonPanel dungeonPanel;
	private BattlePanel battlePanel;
	private AdminPanel adminPanel;
	private StorePanel storePanel;

	private JButton returnLogoBtn;
	private JButton stageLogo1Btn;

	/* 몬스터 이미지 */
	private JButton monster1Btn;
	private JButton monster2Btn;
	private JButton monster3Btn;
	private JButton bossMonster1Btn;

	/* 몬스터 이름 */
	private JLabel monster1Textlb;
	private JLabel monster2Textlb;
	private JLabel monster3Textlb;
	private JLabel bossMonster1Textlb;
	

	public DungeonPanel() {
		dungeonPanel = this;
		this.setBounds(0, 0, 1600, 900);
		this.setLayout(null);
		this.setBackground(Color.BLACK);

		/* 리턴로고부착 */
		returnLogoBtn = new JButton();
		returnLogoBtn.setIcon(returnLogo);
		returnLogoBtn.setBounds(15, 150, 394, 148);
		returnLogoBtn.setBorderPainted(false);
		returnLogoBtn.setContentAreaFilled(false);
		returnLogoBtn.setFocusPainted(false);

		/* 스테이지 1 로고부착 */
		stageLogo1Btn = new JButton();
		stageLogo1Btn.setIcon(stageLogo1);
		stageLogo1Btn.setBounds(572, 164, 456, 134);
		stageLogo1Btn.setBorderPainted(false);
		stageLogo1Btn.setContentAreaFilled(false);
		stageLogo1Btn.setFocusPainted(false);

		/* 던전 몬스터 1 이미지 버튼부착 */
		monster1Btn = new JButton();
		monster1Btn.setIcon(monster1);
		monster1Btn.setBounds(148, 408, 129, 135);
		monster1Btn.setBorderPainted(false);
		monster1Btn.setContentAreaFilled(false);
		monster1Btn.setFocusPainted(false);

		/* 던전 몬스터 2 이미지 버튼부착 */
		monster2Btn = new JButton();
		monster2Btn.setIcon(monster2);
		monster2Btn.setBounds(514, 408, 129, 135);
		monster2Btn.setBorderPainted(false);
		monster2Btn.setContentAreaFilled(false);
		monster2Btn.setFocusPainted(false);
		
		/* 던전 몬스터 3 이미지 버튼부착 */
		monster3Btn = new JButton();
		monster3Btn.setIcon(monster3);
		monster3Btn.setBounds(915, 408, 155, 153);
		monster3Btn.setBorderPainted(false);
		monster3Btn.setContentAreaFilled(false);
		monster3Btn.setFocusPainted(false);
		
		/* 보스 몬스터 1 이미지 버튼부착 */
		bossMonster1Btn = new JButton();
		bossMonster1Btn.setIcon(bossMonster1);
		bossMonster1Btn.setBounds(1280, 340, 220, 220);
		bossMonster1Btn.setBorderPainted(false);
		bossMonster1Btn.setContentAreaFilled(false);
		bossMonster1Btn.setFocusPainted(false);
		
		/* 던전 몬스터 1 이름 라벨 부착 */ 
		monster1Textlb = new JLabel();
		monster1Textlb.setIcon(monster1Text);
		monster1Textlb.setBounds(89, 543, 247, 103);
		
		/* 던전 몬스터 2 이름 라벨 부착 */ 
		monster2Textlb = new JLabel();
		monster2Textlb.setIcon(monster2Text);
		monster2Textlb.setBounds(455, 543, 247, 103);
		
		/* 던전 몬스터 3 이름 라벨 부착 */ 
		monster3Textlb = new JLabel();
		monster3Textlb.setIcon(monster3Text);
		monster3Textlb.setBounds(869, 543, 247, 103);
		
		/* 보스 몬스터 1 이름 라벨 부착 */ 
		bossMonster1Textlb = new JLabel();
		bossMonster1Textlb.setIcon(bossMonster1Text);
		bossMonster1Textlb.setBounds(1310, 543, 247, 103);
		
		/* 라벨 부착 */
		dungeonPanel.add(monster1Textlb);
		dungeonPanel.add(monster2Textlb);
		dungeonPanel.add(monster3Textlb);
		dungeonPanel.add(bossMonster1Textlb);
		
		
		/* 버튼 구현 */
		this.add(returnLogoBtn);
		this.add(stageLogo1Btn);
		this.add(monster1Btn);
		this.add(monster2Btn);
		this.add(monster3Btn);
		this.add(bossMonster1Btn);
		
	}


	public void eventStart() {

		returnLogoBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				dungeonPanel.setVisible(false);
				townPanel.setVisible(true);
				
			}
		});
		
		monster1Btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				battlePanel.startBattle(2, 1);

			}
		});

		monster2Btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				battlePanel.startBattle(2, 2);
			}
		});

		monster3Btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				battlePanel.startBattle(2, 3);
				dungeonPanel.setVisible(false);
				battlePanel.setVisible(true);
			}
		});

		bossMonster1Btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				battlePanel.startBattle(2, 4);
			}
		});
	}
//	public void setStage1() {
//	monster1Btn.setIcon(monster1);
//}
//public void setStage1() {
//	monster2Btn.setIcon(monster2);
//}
//public void setStage1() {
//	monster3Btn.setIcon(monster3);
//}
//public void setStage1() {
//	bossMonster1Btn.setIcon(bossMonster1);
//}
//public void setStage2() {
//	monster1Btn.setIcon(monster1);
//}
//public void setStage2() {
//	monster2Btn.setIcon(monster2);
//}
//public void setStage2() {
//	monster3Btn.setIcon(monster3);
//}
//public void setStage2() {
//	bossMonster2Btn.setIcon(bossMonster2);
//}
//public void setStage3() {
//	monster1Btn.setIcon(monster1);
//}
//public void setStage3() {
//	monster2Btn.setIcon(monster2);
//}
//public void setStage3() {
//	monster3Btn.setIcon(monster3);
//}
//public void setStage3() {
//	bossMonster3Btn.setIcon(bossMonster3);
//}

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