package com.javaland.stg.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.javaland.stg.common.Monster;
import com.javaland.stg.controller.CharacterController;
import com.javaland.stg.controller.CharacterUpdateController;
import com.javaland.stg.model.dto.CharacterDTO;

/* 황성연 담당 패널 */
public class BattlePanel extends JPanel {

	private Image backImg = new ImageIcon("image/BattlePanelBackIMG.jpg").getImage();
	private Image infoImg = new ImageIcon("image/BattleInfo.png").getImage();
	private Image stageInfoImg = new ImageIcon("image/battleStageInfo.png").getImage();
	private Image characterImg = new ImageIcon("image/character.png").getImage();

	/* 적 정보 */
	private Image enemyImg;
	private int enemyX;
	private int enemyY;

	private Monster slime = new Monster("slime"); // 1-1
	private Monster jawWorm = new Monster("jawWorm"); // 1-2
	private Monster gremlin = new Monster("gremlin"); // 1-3
	private Monster champion = new Monster("champion"); // 1-boss
	private Monster parasite = new Monster("parasite"); // 2-1
	private Monster snecko = new Monster("snecko"); // 2-2
	private Monster book = new Monster("book"); // 2-3
	private Monster timeEater = new Monster("timeEater"); // 2-boss
	private Monster transienter = new Monster("transienter"); // 3-1
	private Monster writhingMass = new Monster("writhingMass"); // 3-2
	private Monster nemesis = new Monster("nemesis"); // 3-3
	private Monster theGuardian = new Monster("theGuardian"); // 3-boss
	private Monster nowEnemy;
	
	private CharacterDTO character;

	private ImageIcon strikeButtonImg = new ImageIcon("image/StrikeButtonImg.png");
	private ImageIcon defenseButtonImg = new ImageIcon("image/DefenseButtonImg.png");
	private ImageIcon escapeButtonImg = new ImageIcon("image/EscapeButtonImg.png");

	private MainPanel mainPanel;
	private ScriptPanel scriptPanel;
	private TownPanel townPanel;
	private StagePanel stagePanel;
	private DungeonPanel dungeonPanel;
	private BattlePanel battlePanel;
	private AdminPanel adminPanel;
	private StorePanel storePanel;

	private JButton strikeButton;
	private JButton defenseButton;
	private JButton escapeButton;

	private JLabel goldLabel;
	private JLabel stageLabel;
	private JLabel characterHpLabel;
	private JLabel enemyHpLabel;
	private JLabel enemyName;
	private JLabel turnInfo;
	
	private CharacterController characterController = new CharacterController();
	private CharacterUpdateController characterUpdateController = new CharacterUpdateController();

	public BattlePanel() {
		battlePanel = this;
		this.setBounds(0, 0, 1600, 900);
		this.setLayout(null);

		/* 공격 버튼 */
		strikeButton = new JButton();
		strikeButton.setIcon(strikeButtonImg);
		strikeButton.setBounds(1220, 620, 175, 145);
		strikeButton.setBorderPainted(false);
		strikeButton.setContentAreaFilled(false);
		strikeButton.setFocusPainted(false);
		battlePanel.add(strikeButton);

		/* 방어 버튼 */
		defenseButton = new JButton();
		defenseButton.setIcon(defenseButtonImg);
		defenseButton.setBounds(1420, 600, 171, 144);
		defenseButton.setBorderPainted(false);
		defenseButton.setContentAreaFilled(false);
		defenseButton.setFocusPainted(false);
		battlePanel.add(defenseButton);

		/* 도망 버튼 */
		escapeButton = new JButton();
		escapeButton.setIcon(escapeButtonImg);
		escapeButton.setBounds(1380, 725, 171, 144);
		escapeButton.setBorderPainted(false);
		escapeButton.setContentAreaFilled(false);
		escapeButton.setFocusPainted(false);
		battlePanel.add(escapeButton);

		/* 골드 라벨 */
		goldLabel = new JLabel();
		goldLabel.setHorizontalAlignment(SwingConstants.LEFT);
		goldLabel.setFont(new Font("Kreon", Font.PLAIN, 30));
		goldLabel.setBounds(170, 13, 200, 50);
		goldLabel.setForeground(new Color(188, 191, 42));
		battlePanel.add(goldLabel);

		/* 스테이지 라벨 */
		stageLabel = new JLabel();
		stageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		stageLabel.setFont(new Font("Kreon", Font.PLAIN, 30));
		stageLabel.setBounds(1346, 52, 30, 30);
		stageLabel.setForeground(new Color(87, 87, 87));
		battlePanel.add(stageLabel);

		/* 캐릭터 체력 라벨 */
		characterHpLabel = new JLabel();
		characterHpLabel.setHorizontalAlignment(SwingConstants.CENTER);
		characterHpLabel.setFont(new Font("Kreon", Font.PLAIN, 30));
		characterHpLabel.setBounds(260, 450, 300, 30);
		characterHpLabel.setForeground(Color.RED);
		battlePanel.add(characterHpLabel);

		/* 몬스터 체력 라벨 */
		enemyHpLabel = new JLabel();
		enemyHpLabel.setHorizontalAlignment(SwingConstants.CENTER);
		enemyHpLabel.setFont(new Font("Kreon", Font.PLAIN, 30));
		enemyHpLabel.setBounds(1250, 170, 300, 30);
		enemyHpLabel.setForeground(Color.RED);
		battlePanel.add(enemyHpLabel);

		/* 몬스터 이름 라벨 */
		enemyName = new JLabel();
		enemyName.setHorizontalAlignment(SwingConstants.CENTER);
		enemyName.setFont(new Font("Kreon", Font.BOLD, 30));
		enemyName.setBounds(1250, 170, 100, 30);
		enemyName.setForeground(Color.WHITE);
		battlePanel.add(enemyName);
		
		/* 현재 턴 라벨 */
		turnInfo = new JLabel("<== 캐릭터 턴");
		turnInfo.setHorizontalAlignment(SwingConstants.CENTER);
		turnInfo.setFont(new Font("Kreon", Font.BOLD, 30));
		turnInfo.setBounds(475, 500, 250, 30);
		turnInfo.setForeground(Color.WHITE);
		battlePanel.add(turnInfo);
		
//		character = characterController.searchPlayerById("user01");
//		character.setHp(1000);
//		character.setMaxHp(1000);
//		character.setSp(3);
//		character.setDp(0);
//		character.setLevel(1);
//		character.setGold(200);
//		character.setExp(0);
//		characterInforefresh();
//		startBattle(1,2);
		
	}

	public void eventStart() {
		strikeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				character.attackMonster(nowEnemy);
				monsterInfoRefresh();
				if(nowEnemy.getHp() <= 0) {
					character.victoryBattle(nowEnemy);
					character.checkLevelUp();
					if(nowEnemy.getName().equals("champion")) {
						character.setStage1ClearYN("Y");
					} else if (nowEnemy.getName().equals("timeEater")) {
						character.setStage2ClearYN("Y");
					}
					characterUpdateController.updatePlayer(character);
					battlePanel.setVisible(false);
					dungeonPanel.setVisible(true);
				} else {
					monsterTurnStart(1);
				}
			}
		});

		defenseButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				monsterTurnStart(2);
			}
		});

		escapeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int random = (int)(Math.random() * 2) + 1;
				System.out.println(random);
				if(random == 1) {
					JOptionPane.showMessageDialog(null, "도망 성공");
					battlePanel.setVisible(false);
					townPanel.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "도망 실패");
				}
			}
		});
	}

	public void monsterSpawn(Monster monster) {
		battlePanel.enemyImg = monster.getImg();
		battlePanel.enemyX = monster.getImgX();
		battlePanel.enemyY = monster.getImgY();
		monster.setHp(monster.getMaxHp());
		enemyName.setText(monster.getName());
		enemyName.setBounds(monster.getImgX(), monster.getImgY() - 80, monster.getImg().getWidth(null), 30);
		enemyHpLabel.setText(monster.getHp() + "/" + monster.getMaxHp());
		enemyHpLabel.setBounds(monster.getImgX(), monster.getImgY() - 40, monster.getImg().getWidth(null), 30);
		nowEnemy = monster;
	}
	
	public void monsterInfoRefresh() {
		enemyHpLabel.setText(nowEnemy.getHp() + "/" + nowEnemy.getMaxHp());
	}

	public void characterInforefresh() {
		characterHpLabel.setText(character.getHp() + "/" + character.getMaxHp());
		goldLabel.setText(character.getGold() + "");
	}

	public void monsterTurnStart(int tactics) {
		strikeButton.setEnabled(false);
		defenseButton.setEnabled(false);
		escapeButton.setEnabled(false);
		turnInfo.setText("몬스터 턴===>");
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(tactics == 1) {
					nowEnemy.attackCharacter(character);
				}
				turnInfo.setText("<===캐릭터 턴");
				strikeButton.setEnabled(true);
				defenseButton.setEnabled(true);
				escapeButton.setEnabled(true);
				characterInforefresh();
				if(character.getHp() <= 0) {
					character.setLiveYN("N");
					characterUpdateController.updatePlayer(character);
//					새로운 캐릭터 생성하는 컨트롤러
					characterController.characterInsertById(character.getId());
					character = characterController.searchPlayerById(character.getId());
					townPanel.setCharacter(character);
					battlePanel.setVisible(false);
					townPanel.setVisible(true);
				}
			}
		}).start();
		
	}
	
	public void startBattle(int stageNo, int dungeonNo) {
		switch(stageNo) {
		case 1:
			stageLabel.setText(stageNo + "");
			switch(dungeonNo) {
			case 1:
				monsterSpawn(slime);
				break;
			case 2:
				monsterSpawn(jawWorm);
				break;
			case 3:
				monsterSpawn(gremlin);
				break;
			case 4:
				monsterSpawn(champion);
				break;
			}
			break;
		case 2:
			stageLabel.setText(stageNo + "");
			switch(dungeonNo) {
			case 1:
				monsterSpawn(parasite);
				break;
			case 2:
				monsterSpawn(snecko);
				break;
			case 3:
				monsterSpawn(book);
				break;
			case 4:
				monsterSpawn(timeEater);
				break;
			}
			break;
		case 3:
			stageLabel.setText(stageNo + "");
			switch(dungeonNo) {
			case 1:
				monsterSpawn(transienter);
				break;
			case 2:
				monsterSpawn(writhingMass);
				break;
			case 3:
				monsterSpawn(nemesis);
				break;
			case 4:
				monsterSpawn(theGuardian);
				break;
			}
			break;
		}
		characterInforefresh();
	}

	public void setCharacter(CharacterDTO character) {
		this.character = character;
		characterInforefresh();
	}
	
	public void panelInit(ScriptPanel scriptPanel, TownPanel townPanel, StagePanel stagePanel,
			DungeonPanel dungeonPanel, MainPanel mainPanel, AdminPanel adminPanel, StorePanel storePanel) {
		this.scriptPanel = scriptPanel;
		this.townPanel = townPanel;
		this.stagePanel = stagePanel;
		this.dungeonPanel = dungeonPanel;
		this.mainPanel = mainPanel;
		this.adminPanel = adminPanel;
		this.storePanel = storePanel;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(backImg, 0, 0, this);
		g.drawImage(infoImg, 0, 10, this);

		g.drawImage(enemyImg, enemyX, enemyY, this);

		g.drawImage(stageInfoImg, 1140, 20, this);
		g.drawImage(characterImg, 250, 500, this);
	}

	public static void main(String[] args) {

		JFrame mf = new JFrame("Test");
		mf.setSize(1600, 900);
		mf.setLocationRelativeTo(null);
		mf.setLayout(null);
		mf.setResizable(false);

		BattlePanel battlePanel = new BattlePanel();
		battlePanel.eventStart();

		mf.add(battlePanel);

		mf.setVisible(true);
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
