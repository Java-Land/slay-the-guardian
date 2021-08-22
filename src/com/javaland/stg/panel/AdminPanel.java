package com.javaland.stg.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

/* 김한솔 담당 패널 */
public class AdminPanel extends JPanel{

	Image backImg = new ImageIcon("image/MainPanelBackIMG.png").getImage();
	private ImageIcon closeImg = new ImageIcon("image/close.png");
	private MainPanel mainPanel;
	private ScriptPanel scriptPanel;
	private TownPanel townPanel;
	private StagePanel stagePanel;
	private DungeonPanel dungeonPanel;
	private BattlePanel battlePanel;
	private AdminPanel adminPanel;
	private StorePanel storePanel;

	private JLabel adminTitlelb;
	private JScrollPane scrolledTable;

	public AdminPanel() {
		adminPanel = this;
		this.setBounds(0, 0, 1600, 900);
		this.setLayout(null);

		/*타이틀 라벨 생성*/
		JLabel adminTitlelb = new JLabel("관리자 모드");
		adminTitlelb.setBounds(640, 50, 300, 80);
		adminTitlelb.setBorder(BorderFactory.createEmptyBorder(10 , 10 , 10 , 10));
		adminTitlelb.setOpaque(true);
		adminTitlelb.setBackground(new Color(192, 192, 192, 150));

		Font titleFont = new Font("돋움", Font.BOLD, 50);
		adminTitlelb.setFont(titleFont);


		/*유저 정보 테이블 생성*/
		String title[]= {"아이디", "플레이 시간", "레벨", "현재경험치", "소지골드", "체력","공격력","방어력","블랙리스트 여부" };
		Object data[][] = {
				{"id01","00:00:00","15","12345","123","100","70","20","N"},
				{"id02","00:00:00","17","12345","123","100","70","20","N"},
				{"id03","00:00:00","18","12345","123","100","70","20","N"},
				{"id04","00:00:00","19","12345","123","100","70","20","N"}
		};

		DefaultTableModel model = new DefaultTableModel(data,title);
		JTable table = new JTable(model);
		JScrollPane scrolledTable = new JScrollPane(table);
		scrolledTable.setBounds(135, 150, 1300, 650);
		scrolledTable.setBorder(BorderFactory.createLineBorder(Color.gray, 4, true));

		/*테이블 셀 가운데 정렬*/
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel columnModel = table.getColumnModel();
		for (int i = 0 ; i < columnModel.getColumnCount(); i++) {
			columnModel.getColumn(i).setCellRenderer(dtcr);
		}

		/*테이플 폰트*/
		JTableHeader header = table.getTableHeader();
		header.setFont(new Font("굴림", Font.BOLD, 15));
 
		/*AdminPanel에 컴포넌트 추가*/
		this.add(adminTitlelb);
		this.add(scrolledTable);

	}
 
	public void eventStart() {

	}

	public void panelInit(ScriptPanel scriptPanel, MainPanel mainPanel, StagePanel stagePanel,
			         	  DungeonPanel dungeonPanel, BattlePanel battlePanel, TownPanel townPanel, StorePanel storePanel) { 
		this.scriptPanel = scriptPanel; 
		this.mainPanel = mainPanel; 
		this.stagePanel = stagePanel; 
		this.dungeonPanel = dungeonPanel; 
		this.battlePanel = battlePanel; 
		this.townPanel = townPanel; 
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

		AdminPanel adminPanel = new AdminPanel(); 

		adminPanel.eventStart(); 

		mf.add(adminPanel); 

		mf.setVisible(true); 

		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

	} 

 

} 

 

 