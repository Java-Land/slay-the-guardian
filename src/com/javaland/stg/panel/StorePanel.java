package com.javaland.stg.panel;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class StorePanel extends JPanel {

	Image storeImg = new ImageIcon("image/StorePanel.png").getImage();
	private ImageIcon exitImg = new ImageIcon("image/exitStage.png");
	
	private MainPanel mainPanel;
	private ScriptPanel scriptPanel;
	private TownPanel townPanel;
	private StagePanel stagePanel;
	private DungeonPanel dungeonPanel;
	private BattlePanel battlePanel;
	private AdminPanel adminPanel;
	private StorePanel storePanel;
	
	private JButton exitButton;
	private JButton itemButton;
	
	public StorePanel() {
		storePanel = this;
		
		this.setBounds(0, 0, 1600, 900);
		this.setLayout(null);
	
	
	/* 나가기 버튼 */
	exitButton = new JButton();
	exitButton.setBounds(-60, 660, 394, 148);
	exitButton.setBorderPainted(false);
	exitButton.setContentAreaFilled(false);
	exitButton.setFocusPainted(false);
	exitButton.setIcon(exitImg);
	storePanel.add(exitButton);
	
	/* 아이템 버튼 */
	itemButton = new JButton();
	itemButton.setBounds(30, 30, 110, 120);
	itemButton.setBorderPainted(false);
	itemButton.setContentAreaFilled(false);
	itemButton.setFocusPainted(false);
//	itemButton.setIcon();
	storePanel.add(itemButton);
	
	storePanel.setVisible(false);
	}
	public void eventStart() {
//		
//		exitButton.addMouseListener(new MouseListener() {
//
//			@Override
//			public void mouseReleased(MouseEvent e) {
//				
//			}
//			
//			@Override
//			public void mousePressed(MouseEvent e) {
//				
//			}
//
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				
//			}
//
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				
//			}
//
//			@Override
//			public void mouseExited(MouseEvent e) {
//				
//			}
		}
	
	public void panelInit(ScriptPanel scriptPanel, MainPanel mainPanel, StagePanel stagePanel,
       	  DungeonPanel dungeonPanel, BattlePanel battlePanel, AdminPanel adminPanel, TownPanel townPanel) {
		this.scriptPanel = scriptPanel;
		this.mainPanel = mainPanel;
		this.stagePanel = stagePanel;
		this.dungeonPanel = dungeonPanel;
		this.battlePanel = battlePanel;
		this.adminPanel = adminPanel;
		this.townPanel = townPanel;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(storeImg, 0, 0, storePanel);
	}
	
	public static void main(String[] args) {
		
		JFrame mf = new JFrame("Test");
		mf.setSize(1600, 900);
		mf.setLocationRelativeTo(null);
		mf.setLayout(null);
		mf.setResizable(false);
		
		StorePanel storePanel = new StorePanel();
//		storePanel.eventStart();
		
		mf.add(storePanel);
	
		mf.setVisible(true);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
