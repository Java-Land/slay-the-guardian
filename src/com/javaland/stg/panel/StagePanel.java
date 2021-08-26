package com.javaland.stg.panel;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.javaland.stg.model.dto.CharacterDTO;
/* 이신희담당 */
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
	
	private CharacterDTO character;        

	   
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
		
		super.setVisible(false);
	}
	
	public void eventStart() {
		stageBtn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
	            dungeonPanel.setStage(1);
				stagePanel.setVisible(false);
	            dungeonPanel.setVisible(true);        // 스테이지 1을 눌렀을 때 던전패널이 나오게
			}
		});
		
		stageBtn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dungeonPanel.setStage(2);
				stagePanel.setVisible(false);
	            dungeonPanel.setVisible(true);
			}
		});
		
		stageBtn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dungeonPanel.setStage(3);
				stagePanel.setVisible(false);
	            dungeonPanel.setVisible(true);
			}
		});
		
		exitStageBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
	            stagePanel.setVisible(false);
	            townPanel.setVisible(true);				// 나가기 눌렀을 때 타운 패널이 보이게
			}
		});
		
//	      stageBtn2.setEnabled(false);    // 스테이지 클리어 못했을때         
//	      stageBtn3.setEnabled(false);      
		
	}
	// 스테이지 클리어 여부 'Y'이면 열리고 'N'이면 안열리게 하는 메소드
	public void stageClearYN() {   
	      if (character.getStage1ClearYN().equals("Y")) {
	         stageBtn2.setEnabled(true);
	      } else {
	         stageBtn2.setEnabled(false);
	      }
	      if (character.getStage2ClearYN().equals("Y")) {
	         stageBtn3.setEnabled(true);
	      } else {
	         stageBtn3.setEnabled(false);
	      }		
	}
	
	@Override
	public void setVisible(boolean aFlag) {
		super.setVisible(aFlag);
		stageClearYN();
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
	
	public void setCharacter(CharacterDTO character) {
		this.character = character;
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