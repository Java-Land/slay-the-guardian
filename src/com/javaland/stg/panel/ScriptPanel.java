package com.javaland.stg.panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ScriptPanel extends JPanel{
	
	private MainPanel mainPanel;
	private ScriptPanel scriptPanel;
	private TownPanel townPanel;
	private StagePanel stagePanel;
	private DungeonPanel dungeonPanel;
	private BattlePanel battlePanel;
	private AdminPanel adminPanel;
	private StorePanel storePanel;

	public ScriptPanel() {
		scriptPanel = this;
		this.setBounds(0, 0, 1600, 900);
		this.setLayout(null);
		this.setBackground(Color.BLACK);

	}
	
	public void eventStart() {
		
	}
	
	public void panelInit(MainPanel mainPanel, TownPanel townPanel, StagePanel stagePanel,
			         	  DungeonPanel dungeonPanel, BattlePanel battlePanel, AdminPanel adminPanel, StorePanel storePanel) {
		this.mainPanel = mainPanel;
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
	}
	
	public static void main(String[] args) {
		
		JFrame mf = new JFrame("Test");
		mf.setSize(1600, 900);
		mf.setLocationRelativeTo(null);
		mf.setLayout(null);
		mf.setResizable(false);
		
		ScriptPanel scriptPanel = new ScriptPanel();
		scriptPanel.eventStart();
		
		mf.add(scriptPanel);
	
		mf.setVisible(true);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
