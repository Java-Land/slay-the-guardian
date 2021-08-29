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
	private JLabel characterSp;
	private JLabel characterDp;
	private JLabel characterLevel;
	private JLabel characterExp;
	private JLabel monsterSp;
	private JLabel monsterDp;
	
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
		turnInfo.setBounds(700, 300, 250, 30);
		turnInfo.setForeground(Color.WHITE);
		battlePanel.add(turnInfo);
		
		/* 캐릭터 공격력 라벨 */
		characterSp = new JLabel();
		characterSp.setHorizontalAlignment(SwingConstants.LEFT);
		characterSp.setFont(new Font("Kreon", Font.BOLD, 30));
		characterSp.setBounds(300, 700, 400, 30);
		characterSp.setForeground(Color.WHITE);
		battlePanel.add(characterSp);
		
		/* 캐릭터 방어력 라벨 */
		characterDp = new JLabel();
		characterDp.setHorizontalAlignment(SwingConstants.LEFT);
		characterDp.setFont(new Font("Kreon", Font.BOLD, 30));
		characterDp.setBounds(300, 730, 400, 30);
		characterDp.setForeground(Color.WHITE);
		battlePanel.add(characterDp);
		
		/* 캐릭터 레벨 라벨 */
		characterLevel = new JLabel();
		characterLevel.setHorizontalAlignment(SwingConstants.LEFT);
		characterLevel.setFont(new Font("Kreon", Font.BOLD, 30));
		characterLevel.setBounds(300, 760, 400, 30);
		characterLevel.setForeground(Color.WHITE);
		battlePanel.add(characterLevel);
		
		/* 캐릭터 레벨 라벨 */
		characterExp = new JLabel();
		characterExp.setHorizontalAlignment(SwingConstants.LEFT);
		characterExp.setFont(new Font("Kreon", Font.BOLD, 30));
		characterExp.setBounds(300, 790, 400, 30);
		characterExp.setForeground(Color.WHITE);
		battlePanel.add(characterExp);
		
		/* 캐릭터 공격력 라벨 */
		monsterSp = new JLabel();
		monsterSp.setHorizontalAlignment(SwingConstants.LEFT);
		monsterSp.setFont(new Font("Kreon", Font.BOLD, 30));
		monsterSp.setBounds(800, 700, 400, 30);
		monsterSp.setForeground(Color.WHITE);
		battlePanel.add(monsterSp);
		
		/* 캐릭터 방어력 라벨 */
		monsterDp = new JLabel();
		monsterDp.setHorizontalAlignment(SwingConstants.LEFT);
		monsterDp.setFont(new Font("Kreon", Font.BOLD, 30));
		monsterDp.setBounds(800, 730, 400, 30);
		monsterDp.setForeground(Color.WHITE);
		battlePanel.add(monsterDp);
		
		monsterSpawn(slime);
		
		battlePanel.setVisible(false);
		
//		character = characterController.searchPlayerById("user01");
//		character.setHp(1000);
//		character.setMaxHp(1000);
//		character.setSp(3);
//		character.setDp(0);
//		character.setLevel(1);
//		character.setGold(200);
//		character.setExp(0);
//		characterInforefresh();
//		startBattle(1,4);
		
	}
	
	/* 현재 캐릭터 정보를 GUI에 표출하여 주는 메소드 */
	public void characterInforefresh() {
		characterHpLabel.setText(character.getHp() + "/" + character.getMaxHp());
		goldLabel.setText(character.getGold() + "");
		characterSp.setText("Character SP : " + character.getSp());
		characterDp.setText("Character DP : " + character.getDp());
		characterLevel.setText("Character Lv : " + character.getLevel());
		characterExp.setText("Character Exp : " + character.getLevel() * 100 + "/" + character.getExp());
	}
	
	/* 로그인 하였을 경우 로그인한 캐릭터에 정보를 가지고오는 메소드 */
	public void setCharacter(CharacterDTO character) {
		this.character = character;
		characterInforefresh();
	}

	/* 현재 몬스터 정보를 GUI에 표출하여 주는 메소드 */
	public void monsterInfoRefresh() {
		enemyHpLabel.setText(nowEnemy.getHp() + "/" + nowEnemy.getMaxHp());
		monsterSp.setText(nowEnemy.getName() + " SP : " + nowEnemy.getSp());
		monsterDp.setText(nowEnemy.getName() + " DP : " + nowEnemy.getDp());
	}
	
	/* 전투 할 몬스터의 정보를 세팅하는 메소드 */
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
	
	/* 전투를 시작할 몬스터를 선택하는 메소드 */
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
		monsterInfoRefresh();
		characterInforefresh();
	}
	
	/* 몬스터의 공격 턴이 시작 되는 메소드 */
	public void monsterTurnStart(int tactics) {
		
		/* 캐릭터가 클릭 할 수 있는 모든 버튼을 잠그는 메소드 */
		strikeButton.setEnabled(false);
		defenseButton.setEnabled(false);
		escapeButton.setEnabled(false);
		
		/* 몬스터 턴 시작을 알리는 라벨을 수정하는 메소드 */
		turnInfo.setText("몬스터 턴===>");
		
		/* 2초 동안 몬스터에 턴이 진행되도록 하는 스레드 메소드 */
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				/* 캐릭터가 공격 또는 도망 버튼을 눌렀을 경우 몬스터가 캐릭터를 공격하는 메소드 */
				/* 만약 캐릭터가 방어 버튼을 눌렀다면 몬스터에 공격이 방어 되어 몬스터가 캐릭터를 공격하지 못함 */
				if(tactics == 1) {
					nowEnemy.attackCharacter(character);
				}
				
				/* 캐릭터 턴 시작을 알리는 라벨을 수정하는 메소드 */
				turnInfo.setText("<===캐릭터 턴");
				
				/* 다시 캐릭터가 클릭 할 수 있는 모든 버튼의 잠금을 풀어주는 메소드 */
				strikeButton.setEnabled(true);
				defenseButton.setEnabled(true);
				escapeButton.setEnabled(true);
				
				/* 몬스터에 공격으로 인해 변화된 캐릭터에 정보를 뿌려주는 메소드 */
				characterInforefresh();
				
				/* 만약 몬스터에 공격으로 캐릭터에 HP가 0이하로 떨어지면 캐릭터에 죽음을 판별하는 조건 문 */
				if(character.getHp() <= 0) {
					
					/* 캐릭터에 죽음 정보를 변경하는 메소드 */
					character.setLiveYN("N");
					
					/* 변경된 캐릭터 정보를 업데이트 하는 메소드 */
					characterUpdateController.updatePlayer(character);
					
					/* 현재 계정에 아이디로 새로운 캐릭터를 생성하는 메소드 */
					characterController.characterInsertById(character.getId());
					
					/* 위에서 인서트 한 캐릭터 정보를 가지고 오는 메소드 */
					character = characterController.searchPlayerById(character.getId());
					
					/* 새로운 캐릭터 정보를 타운 패널에 전달하는 메소드 */
					townPanel.setCharacter(character);
					
					/* 타운패널로 패널을 변경하는 메소드 */
					battlePanel.setVisible(false);
					townPanel.setVisible(true);
				}
			}
		}).start();
		
	}
	
	/* 모든 이벤트가 구현되는 메소드 */
	public void eventStart() {
		
		/* 공격 버튼 클릭 이벤트 */
		strikeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				character.attackMonster(nowEnemy);
				monsterInfoRefresh();
				
				/* 캐릭터에 공격으로 인하여 몬스터에 체력이 0이하로 떨어질 경우 발생 */
				if(nowEnemy.getHp() <= 0) {
					
					/* 캐릭터가 전투를 승리하여 몬스터가 드랍한 경험치, 및 골드를 획득 */
					character.victoryBattle(nowEnemy);
					
					/* 캐릭터가 현재 경험치가 레벨업 할 경험치인지 확인하여 맞을 경우 레벨업을 하는 메소드 */
					character.checkLevelUp();
					
					/* 현재 전투한 몬스터에 따라 다음 전투를 설정하여 패널을 변경하는 조건 문 */
					if(nowEnemy.getName().equals("slime")) {
						dungeonPanel.setDungeon(2);
						battlePanel.setVisible(false);
						dungeonPanel.setVisible(true);
					} else if (nowEnemy.getName().equals("jawWorm")) {
						dungeonPanel.setDungeon(3);
						battlePanel.setVisible(false);
						dungeonPanel.setVisible(true);
					} else if (nowEnemy.getName().equals("gremlin")) { 
						dungeonPanel.setDungeon(4);
						battlePanel.setVisible(false);
						dungeonPanel.setVisible(true);
					} else if (nowEnemy.getName().equals("champion")) { 
						character.setStage1ClearYN("Y");
						dungeonPanel.setDungeon(1);
						battlePanel.setVisible(false);
						townPanel.setVisible(true);
					} else if (nowEnemy.getName().equals("parasite")) { 
						dungeonPanel.setDungeon(2);
						battlePanel.setVisible(false);
						dungeonPanel.setVisible(true);
					} else if (nowEnemy.getName().equals("snecko")) { 
						dungeonPanel.setDungeon(3);
						battlePanel.setVisible(false);
						dungeonPanel.setVisible(true);
					} else if (nowEnemy.getName().equals("book")) { 
						dungeonPanel.setDungeon(4);
						battlePanel.setVisible(false);
						dungeonPanel.setVisible(true);
					} else if (nowEnemy.getName().equals("timeEater")) { 
						dungeonPanel.setDungeon(1);
						character.setStage2ClearYN("Y");
						battlePanel.setVisible(false);
						townPanel.setVisible(true);
					} else if (nowEnemy.getName().equals("transienter")) { 
						dungeonPanel.setDungeon(2);
						battlePanel.setVisible(false);
						dungeonPanel.setVisible(true);
					} else if (nowEnemy.getName().equals("writhingMass")) { 
						dungeonPanel.setDungeon(3);
						battlePanel.setVisible(false);
						dungeonPanel.setVisible(true);
					} else if (nowEnemy.getName().equals("nemesis")) { 
						dungeonPanel.setDungeon(4);
						battlePanel.setVisible(false);
						dungeonPanel.setVisible(true);
					} else if (nowEnemy.getName().equals("theGuardian")) { 
						dungeonPanel.setDungeon(1);
						battlePanel.setVisible(false);
						townPanel.setVisible(true);
					}
					
					/* 전투 승리로 인하여 변경된 캐릭터 정보를 업데이트 하는 메소드 */
					characterUpdateController.updatePlayer(character);
				} else {
					
					/* 몬스터 공격턴 시작 메소드 */
					monsterTurnStart(1);
				}
			}
		});
		
		/* 방어 버튼 클릭 메소드 */
		defenseButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				/* 몬스터 공격 턴 시작 메소드 */
				monsterTurnStart(2);
			}
		});
		
		/* 도망 버튼 클릭 메소드 */
		escapeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				/* 1 또는 2 난수를 발생하여 random 변수에 저장 */
				int random = (int)(Math.random() * 2) + 1;
				
				if(random == 1) {
					/* 랜덤 변수가 1일 경우 도망에 성공하여 타운 패널로 이동 */
					JOptionPane.showMessageDialog(null, "도망 성공");
					battlePanel.setVisible(false);
					townPanel.setVisible(true);
				} else {
					/* 랜던 변수가 2일 경우 도망에 실패라는 메세지 출력 */
					JOptionPane.showMessageDialog(null, "도망 실패");
					monsterTurnStart(1);
				}
				
			}
		});
	}

	/* 현재 패널 클래스에서 다른 패널에 있는 메소드를 사용하기 위한 패널 초기화 메소드 */
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

	/* 패널에 이미지를 그리기 위한 JPanel에 있는 메소드를 오버라이드 하여 사용 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(backImg, 0, 0, this);
		g.drawImage(infoImg, 0, 10, this);

		g.drawImage(enemyImg, enemyX, enemyY, this);

		g.drawImage(stageInfoImg, 1140, 20, this);
		g.drawImage(characterImg, 250, 500, this);
	}
	
	/* Panel GUI 확인을 위해 만든 메인 메소드 */
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
