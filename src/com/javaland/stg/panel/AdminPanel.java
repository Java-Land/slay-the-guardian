package com.javaland.stg.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	ImageIcon adminLogo = new ImageIcon("image/adminLogo.png");
	
	private ImageIcon adminExit = new ImageIcon("image/adminExit.png");
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
	private JButton adminExitBtn;
	private JButton saveBtn;
	private JLabel resultLb;
	private DefaultTableModel model;
	private JTable table;

	public AdminPanel() {
		adminPanel = this;
		this.setBounds(0, 0, 1600, 900);
		this.setLayout(null);

		/*타이틀 라벨 생성*/
		adminTitlelb = new JLabel();
		adminTitlelb.setIcon(adminLogo);
		adminTitlelb.setBounds(640, 50, 300, 80);


		/*유저 정보 테이블 생성*/
		String title[]= {"아이디", "플레이 시간", "레벨", "현재경험치", "소지골드", "체력","공격력","방어력","블랙리스트 여부" };
		Object data[][] = {
				{"id01","00:00:00","15","12345","123","100","70","20","N"},
				{"id02","00:00:00","17","12345","123","100","70","20","N"},
				{"id03","00:00:00","18","12345","123","100","70","20","N"},
				{"id04","00:00:00","19","12345","123","100","70","20","N"}
		};

		model = new DefaultTableModel(data,title);
		table = new JTable(model);
		scrolledTable = new JScrollPane(table);
		scrolledTable.setBounds(135, 160, 1300, 530);
		scrolledTable.setBorder(BorderFactory.createLineBorder(Color.gray, 4, true));

		/*테이블 셀 가운데 정렬*/
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel columnModel = table.getColumnModel();
		for (int i = 0 ; i < columnModel.getColumnCount(); i++) {
			columnModel.getColumn(i).setCellRenderer(dtcr);
		}

		/*테이블 폰트*/
		JTableHeader header = table.getTableHeader();
		header.setFont(new Font("굴림", Font.BOLD, 15));
 
		/* 나가기 버튼 */
		adminExitBtn = new JButton();
		adminExitBtn.setIcon(adminExit);
		adminExitBtn.setBounds(1450, 20, 90, 90);
		adminExitBtn.setBorderPainted(false);
		adminExitBtn.setContentAreaFilled(false);
		adminExitBtn.setFocusPainted(false);
		
		/* 저장 버튼 */
		saveBtn = new JButton("저장");
		saveBtn.setOpaque(true);
		saveBtn.setBounds(135, 687, 300, 90);
		saveBtn.setBackground(Color.white);
		saveBtn.setBorder(BorderFactory.createLineBorder(Color.gray, 4, true));
		saveBtn.setFont(new Font("굴림", Font.BOLD, 20));
		
		/* 저장 결과 출력 라벨 */
		resultLb = new JLabel("나가기 전에 꼭 저장하세요!");
		resultLb.setOpaque(true);
		resultLb.setBounds(433, 687, 1002, 90);
		resultLb.setBackground(Color.white);
		resultLb.setBorder(BorderFactory.createLineBorder(Color.gray, 4, true));
		resultLb.setVerticalAlignment(SwingConstants.CENTER);
		resultLb.setHorizontalAlignment(SwingConstants.CENTER);
		resultLb.setFont(new Font("굴림", Font.BOLD, 20));

		/*AdminPanel에 컴포넌트 추가*/
		this.add(adminTitlelb);
		this.add(scrolledTable);
		this.add(adminExitBtn);
		this.add(saveBtn);
		this.add(resultLb);
		
		adminPanel.setVisible(false);
	}
 
	public void eventStart() {
		adminExitBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				adminPanel.setVisible(false);
				mainPanel.setVisible(true);
			}
		});
		
		saveBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(model.getValueAt(0,0));
				resultLb.setText("저장이 완료 되었습니다.");
			}
			
		});
		
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

 

 