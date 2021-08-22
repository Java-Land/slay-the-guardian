package com.javaland.stg.panel;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
/* 이신희 담당 */
public class StagePanel extends JPanel{
	
	Image backImg = new ImageIcon("image/StagePanelBackIMG.png").getImage();
	private ImageIcon stageImg1 = new ImageIcon("image/stageImg1.png");
	private ImageIcon stageImg2 = new ImageIcon("image/stageImg2.png");
	private ImageIcon stageImg3 = new ImageIcon("image/stageImg3.png");
	private ImageIcon exitStage = new ImageIcon("image/exitStage.png");
	
	private MainPanel mainPanel;
	private ScriptPanel scriptPanel;
	private TownPanel townPanel;
	private StagePanel stagePanel;
	private DungeonPanel dungeonPanel;
	private BattlePanel battlePanel;
	private AdminPanel adminPanel;
	private StorePanel storePanel;
	
	private JButton stageBtn1;
	private JButton stageBtn2;
	private JButton stageBtn3;
	private JButton exitStageBtn;
	
	public StagePanel() {
		stagePanel = this;
		this.setBounds(0, 0, 1600, 900);
		this.setLayout(null);

		/* 스테이지1 버튼 */
		stageBtn1 = new JButton();
		stageBtn1.setIcon(stageImg1);
		stageBtn1.setBounds(60, 430, 447, 131);
		stageBtn1.setBorderPainted(false);
		stageBtn1.setContentAreaFilled(false);
		stageBtn1.setFocusPainted(false);
		stagePanel.add(stageBtn1);

		/* 스테이지2 버튼 */
		stageBtn2 = new JButton();
		stageBtn2.setIcon(stageImg2);
		stageBtn2.setBounds(605, 430, 447, 131);
		stageBtn2.setBorderPainted(false);
		stageBtn2.setContentAreaFilled(false);
		stageBtn2.setFocusPainted(false);
		stagePanel.add(stageBtn2);
		
		/* 스테이지3 버튼 */
		stageBtn3 = new JButton();
		stageBtn3.setIcon(stageImg3);
		stageBtn3.setBounds(1148, 430, 447, 131);
		stageBtn3.setBorderPainted(false);
		stageBtn3.setContentAreaFilled(false);
		stageBtn3.setFocusPainted(false);
		stagePanel.add(stageBtn3);
		
		/* 나가기 버튼 */
		exitStageBtn = new JButton();
		exitStageBtn.setIcon(exitStage);
		exitStageBtn.setBounds(-50, 732, 394, 148);
		exitStageBtn.setBorderPainted(false);
		exitStageBtn.setContentAreaFilled(false);
		exitStageBtn.setFocusPainted(false);
		stagePanel.add(exitStageBtn);
	}
	
	public void eventStart() {
		stageBtn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		stageBtn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		stageBtn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		exitStageBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
	}
	
	public void panelInit(ScriptPanel scriptPanel, TownPanel townPanel, MainPanel mainPanel,
						  DungeonPanel dungeonPanel, BattlePanel battlePanel, AdminPanel adminPanel, StorePanel storePanel) {
		this.scriptPanel = scriptPanel;
		this.townPanel = townPanel;
		this.mainPanel = mainPanel;
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
		
		StagePanel stagePanel = new StagePanel();
		stagePanel.eventStart();
		
		mf.add(stagePanel);
	
		mf.setVisible(true);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
