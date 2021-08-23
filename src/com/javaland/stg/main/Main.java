package com.javaland.stg.main;

import javax.swing.JFrame;

import com.javaland.stg.panel.AdminPanel;
import com.javaland.stg.panel.BattlePanel;
import com.javaland.stg.panel.DungeonPanel;
import com.javaland.stg.panel.MainPanel;
import com.javaland.stg.panel.ScriptPanel;
import com.javaland.stg.panel.StagePanel;
import com.javaland.stg.panel.TownPanel;
import com.javaland.stg.panel.StorePanel;

public class Main {

	public static void main(String[] args) {
		
		MainPanel mainPanel = new MainPanel();
		AdminPanel adminPanel = new AdminPanel();
		BattlePanel battlePanel = new BattlePanel();
		DungeonPanel dungeonPanel = new DungeonPanel();
		ScriptPanel scriptPanel = new ScriptPanel();
		StagePanel stagePanel = new StagePanel();
		TownPanel townPanel = new TownPanel();
		StorePanel storePanel = new StorePanel();
		
		mainPanel.panelInit(scriptPanel, townPanel, stagePanel, dungeonPanel, battlePanel, adminPanel, storePanel);
		adminPanel.panelInit(scriptPanel, mainPanel, stagePanel, dungeonPanel, battlePanel, townPanel, storePanel);
		battlePanel.panelInit(scriptPanel, townPanel, stagePanel, dungeonPanel, mainPanel, adminPanel, storePanel);
		dungeonPanel.panelInit(scriptPanel, townPanel, stagePanel, mainPanel, battlePanel, adminPanel, storePanel);
		scriptPanel.panelInit(mainPanel, townPanel, stagePanel, dungeonPanel, battlePanel, adminPanel, storePanel);
		stagePanel.panelInit(scriptPanel, townPanel, mainPanel, dungeonPanel, battlePanel, adminPanel, storePanel);
		townPanel.panelInit(scriptPanel, mainPanel, stagePanel, dungeonPanel, battlePanel, adminPanel, storePanel);
		storePanel.panelInit(scriptPanel, mainPanel, stagePanel, dungeonPanel, battlePanel, adminPanel, townPanel);
		
		adminPanel.setVisible(false);
		battlePanel.setVisible(false);
		dungeonPanel.setVisible(false);
		stagePanel.setVisible(false);
		townPanel.setVisible(false);
		storePanel.setVisible(false);
		scriptPanel.setVisible(false);
		
		mainPanel.eventStart();
		adminPanel.eventStart();
		battlePanel.eventStart();
		dungeonPanel.eventStart();
		scriptPanel.eventStart();
		stagePanel.eventStart();
		townPanel.eventStart();
		storePanel.eventStart();
		
		/* */
		JFrame mf = new JFrame("Slay The Guarian");
		mf.setSize(1600, 900);
		mf.setLocationRelativeTo(null);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mf.getContentPane().setLayout(null);
		mf.setResizable(false);
		
		mf.getContentPane().add(mainPanel);
		mf.getContentPane().add(adminPanel);
		mf.getContentPane().add(battlePanel);
		mf.getContentPane().add(dungeonPanel);
		mf.getContentPane().add(scriptPanel);
		mf.getContentPane().add(stagePanel);
		mf.getContentPane().add(townPanel);
		mf.getContentPane().add(storePanel);
		
		mf.setVisible(true);
	}
}
