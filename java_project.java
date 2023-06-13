
import java.awt.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Vector; 
public class Menu implements ActionListener {
	private JFrame frame;
	private JTable table,A2,B2,C2,D2;
	JPanel panel,panel01,
	panel_1,panel_2,panel_3,panel_4,panel_5,panel_6,panel_7,panel_8,panel_9,panel_10,
	panel_11,panel_12,panel_13,panel_14,panel_15,panel_16,panel_17,panel_18,panel_19,panel_20,
	panel_21,panel_22,panel_23,panel_24,panel_25,panel_26,panel_27,panel_28,panel_29,panel_30,
	panel_31,panel_32,panel_33,panel_34,panel_35,panel_36,panel_37,panel_38,panel_39,panel_40,
	panel_41,panel_42,panel_43,panel_44,panel_45,panel_46,panel_47,panel_48,panel_49,panel_50,
	panel_51,panel_52,panel_53,JP1,JP2,JP3,JP4;
	CardLayout crd;
	DefaultTableModel def,def_ta1,def_ta2,def_ta3,def_ta4;
	JSpinner spinner;
	JLabel lblNewLabel_9;
	JLabel lblNewLabel_8;
	JLabel lblNewLabel_12;
	public LinkedList<Integer> list_int = new LinkedList<>();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
		
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setMinimumSize(new Dimension(1024, 720));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("點餐");
//		內容頁------
		panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
//		上方頁面切換按鍵範圍設定------
		panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, SystemColor.inactiveCaption, SystemColor.inactiveCaption, SystemColor.inactiveCaption, SystemColor.inactiveCaption));
		panel_1.setPreferredSize(new Dimension(500, 45));
		panel_1.setSize(new Dimension(500, 50));
		panel.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 1));
//		建立頁面切換按鍵並插入範圍
		JButton btnNewButton_1 = new JButton("各桌明細");
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		btnNewButton_1.setPreferredSize(new Dimension(90, 38));
		btnNewButton_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		JButton btnNewButton = new JButton("點餐");
		btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		btnNewButton.setPreferredSize(new Dimension(90, 38));
		btnNewButton_1.addActionListener(this);
		btnNewButton.addActionListener(this);
		panel_1.add(btnNewButton);panel_1.add(btnNewButton_1);
		
//		設定內容切換頁面CardLayout基礎頁
		crd = new CardLayout();
		panel_3 = new JPanel();
		panel_3.setPreferredSize(new Dimension(32767, 32767));
		panel_3.setMinimumSize(new Dimension(500, 550));
		panel.add(panel_3);
		panel_3.setLayout(crd);
//		CardLayout第一顯示頁面設定
		panel_52 = new JPanel();
		panel_52.setSize(new Dimension(532, 532));
		panel_3.add(panel_52, "1");
		panel_52.setLayout(new BoxLayout(panel_52, BoxLayout.X_AXIS));
//		左至右第一行點餐按鍵Panel_4------
		panel_4 = new JPanel();
		panel_52.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.Y_AXIS));
//		拼盤餐點Panel_9範圍設定	
		panel_9 = new JPanel();
		panel_4.add(panel_9);
		panel_9.setLayout(new BoxLayout(panel_9, BoxLayout.Y_AXIS));
//		Panel_9拼盤標籤範圍
		panel_18 = new JPanel();
		panel_18.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_9.add(panel_18);
		panel_18.setLayout(new BorderLayout(0, 0));
//		拼盤標籤設定
		JLabel lblNewLabel = new JLabel("   花樣拼盤");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		panel_18.add(lblNewLabel);
//		點餐按鍵設定btnNewButton_6("歐姆蛋拼盤")
		panel_19 = new JPanel();
		panel_9.add(panel_19);
		panel_19.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_6 = new JButton("歐姆蛋拼盤");
		btnNewButton_6.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent e) {       
	        	
	        	def.addRow(new Object[]{btnNewButton_6.getText(), spinner.getValue()});
	        	list_int.add((int)spinner.getValue()*145);
	        	int sum = 0;
	        	for (int num : list_int) {
	        	    sum += num;
	        	}
	        	lblNewLabel_9.setText(" "+sum);
	        	lblNewLabel_8.setText(""+(int)(Integer.parseInt(lblNewLabel_9.getText().trim())*0.1));
	        	lblNewLabel_12.setText(""+((int)(Integer.parseInt(lblNewLabel_9.getText().trim()))+(int)(Integer.parseInt(lblNewLabel_8.getText().trim()))));
//	        	lblNewLabel_9.setText(" "+(Integer.parseInt(lblNewLabel_9.getText().trim())+((int)spinner.getValue()*145)));
//	        	System.out.println(list_int);
	        	
	        }});
		btnNewButton_6.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewButton_6.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		btnNewButton_6.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_6.setHorizontalTextPosition(SwingConstants.LEFT);
		btnNewButton_6.setVerticalTextPosition(SwingConstants.TOP);
		btnNewButton_6.setHorizontalAlignment(SwingConstants.LEFT);
		JLabel lblNewLabel9 = new JLabel("$145");
		lblNewLabel9.setForeground(new Color(0, 128, 255));
		lblNewLabel9.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel9.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		lblNewLabel9.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblNewLabel9.setHorizontalTextPosition(SwingConstants.LEFT);
		lblNewLabel9.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel9.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblNewLabel9.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewButton_6.add(lblNewLabel9);
		panel_19.add(btnNewButton_6, BorderLayout.CENTER);
//		點餐按鍵設定btnNewButton_7("焦糖奶油法國吐司")
		panel_20 = new JPanel();
		panel_9.add(panel_20);
		panel_20.setLayout(new BorderLayout(0, 0));
//		---左至右第一區塊---
		JButton btnNewButton_7 = new JButton("焦糖奶油法國吐司");
		btnNewButton_7.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent e) {       
	        	
	        	def.addRow(new Object[]{btnNewButton_7.getText(), spinner.getValue()});
	        	list_int.add((int)spinner.getValue()*135);
	        	int sum = 0;
	        	for (int num : list_int) {
	        	    sum += num;
	        	}
	        	lblNewLabel_9.setText(" "+sum);
//	        	lblNewLabel_9.setText(" "+(Integer.parseInt(lblNewLabel_9.getText().trim())+((int)spinner.getValue()*135)));
	        	lblNewLabel_8.setText(""+(int)(Integer.parseInt(lblNewLabel_9.getText().trim())*0.1));
	        	lblNewLabel_12.setText(""+((int)(Integer.parseInt(lblNewLabel_9.getText().trim()))+(int)(Integer.parseInt(lblNewLabel_8.getText().trim()))));
	        	
	        }});
		btnNewButton_7.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_7.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_7.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		JLabel lblNewLabel10 = new JLabel("$135");
		lblNewLabel10.setForeground(new Color(0, 128, 255));
		lblNewLabel10.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel10.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btnNewButton_7.add(lblNewLabel10);
		panel_20.add(btnNewButton_7);
//		點餐按鍵設定btnNewButton_8("厚切義大利麵")
		panel_21 = new JPanel();
		panel_9.add(panel_21);
		panel_21.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_8 = new JButton("厚切義大利麵");
		btnNewButton_8.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent e) {       
	        	
	        	def.addRow(new Object[]{btnNewButton_8.getText(), spinner.getValue()});
	        	list_int.add((int)spinner.getValue()*170);
	        	int sum = 0;
	        	for (int num : list_int) {
	        	    sum += num;
	        	}
	        	lblNewLabel_9.setText(" "+sum);
//	        	lblNewLabel_9.setText(" "+(Integer.parseInt(lblNewLabel_9.getText().trim())+((int)spinner.getValue()*170)));
	        	lblNewLabel_8.setText(""+(int)(Integer.parseInt(lblNewLabel_9.getText().trim())*0.1));
	        	lblNewLabel_12.setText(""+((int)(Integer.parseInt(lblNewLabel_9.getText().trim()))+(int)(Integer.parseInt(lblNewLabel_8.getText().trim()))));
	        	
	        }});
		btnNewButton_8.setForeground(new Color(0, 0, 0));
		btnNewButton_8.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_8.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		btnNewButton_8.setVerticalAlignment(SwingConstants.TOP);
		JLabel lblNewLabel11 = new JLabel("$170");
		lblNewLabel11.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel11.setForeground(new Color(0, 128, 255));
		lblNewLabel11.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btnNewButton_8.add(lblNewLabel11);
		panel_21.add(btnNewButton_8);
//		點餐按鍵設定btnNewButton_9("炸物拼盤"))
		panel_22 = new JPanel();
		panel_9.add(panel_22);
		panel_22.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_9 = new JButton("炸物拼盤");
		btnNewButton_9.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent e) {       
	        	
	        	def.addRow(new Object[]{btnNewButton_9.getText(), spinner.getValue()});
	        	list_int.add((int)spinner.getValue()*130);
	        	int sum = 0;
	        	for (int num : list_int) {
	        	    sum += num;
	        	}
	        	lblNewLabel_9.setText(" "+sum);
//	        	lblNewLabel_9.setText(" "+(Integer.parseInt(lblNewLabel_9.getText().trim())+((int)spinner.getValue()*130)));
	        	lblNewLabel_8.setText(""+(int)(Integer.parseInt(lblNewLabel_9.getText().trim())*0.1));
	        	lblNewLabel_12.setText(""+((int)(Integer.parseInt(lblNewLabel_9.getText().trim()))+(int)(Integer.parseInt(lblNewLabel_8.getText().trim()))));
	        	
	        }});
		btnNewButton_9.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_9.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_9.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		JLabel lblNewLabel12 = new JLabel("$130");
		lblNewLabel12.setForeground(new Color(0, 128, 255));
		lblNewLabel12.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel12.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btnNewButton_9.add(lblNewLabel12);
		panel_22.add(btnNewButton_9);
//		點餐按鍵設定btnNewButton_10("明星組合")
		panel_23 = new JPanel();
		panel_9.add(panel_23);
		panel_23.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_10 = new JButton("明星組合");
		btnNewButton_10.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent e) {       
	        	
	        	def.addRow(new Object[]{btnNewButton_10.getText(), spinner.getValue()});
	        	list_int.add((int)spinner.getValue()*135);
	        	int sum = 0;
	        	for (int num : list_int) {
	        	    sum += num;
	        	}
	        	lblNewLabel_9.setText(" "+sum);
//	        	lblNewLabel_9.setText(" "+(Integer.parseInt(lblNewLabel_9.getText().trim())+((int)spinner.getValue()*135)));
	        	lblNewLabel_8.setText(""+(int)(Integer.parseInt(lblNewLabel_9.getText().trim())*0.1));
	        	lblNewLabel_12.setText(""+((int)(Integer.parseInt(lblNewLabel_9.getText().trim()))+(int)(Integer.parseInt(lblNewLabel_8.getText().trim()))));
	        	
	        }});
		btnNewButton_10.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_10.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_10.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		JLabel lblNewLabel13 = new JLabel("$135");
		lblNewLabel13.setForeground(new Color(0, 128, 255));
		lblNewLabel13.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel13.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btnNewButton_10.add(lblNewLabel13);
		panel_23.add(btnNewButton_10);
//		小童專屬範圍設定panel_8
		panel_8 = new JPanel();
		panel_4.add(panel_8);
		panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.Y_AXIS));
		panel_13 = new JPanel();
		panel_13.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_8.add(panel_13);
		panel_13.setLayout(new BorderLayout(0, 0));
//		小童專屬標籤設定
		JLabel lblNewLabel_1 = new JLabel("   小童專屬");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		panel_13.add(lblNewLabel_1);
		
		panel_14 = new JPanel();
		panel_8.add(panel_14);
		panel_14.setLayout(new BorderLayout(0, 0));
//		點餐按鍵設定btnNewButton_11("兒童餐")
		JButton btnNewButton_11 = new JButton("兒童餐");
		btnNewButton_11.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent e) {       
	        	
	        	def.addRow(new Object[]{btnNewButton_11.getText(), spinner.getValue()});
	        	list_int.add((int)spinner.getValue()*80);
	        	int sum = 0;
	        	for (int num : list_int) {
	        	    sum += num;
	        	}
	        	lblNewLabel_9.setText(" "+sum);
//	        	lblNewLabel_9.setText(" "+(Integer.parseInt(lblNewLabel_9.getText().trim())+((int)spinner.getValue()*80)));
	        	lblNewLabel_8.setText(""+(int)(Integer.parseInt(lblNewLabel_9.getText().trim())*0.1));
	        	lblNewLabel_12.setText(""+((int)(Integer.parseInt(lblNewLabel_9.getText().trim()))+(int)(Integer.parseInt(lblNewLabel_8.getText().trim()))));
	        	
	        }});
		btnNewButton_11.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_11.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_11.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		JLabel lblNewLabel14 = new JLabel("$80");
		lblNewLabel14.setForeground(new Color(0, 128, 255));
		lblNewLabel14.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel14.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btnNewButton_11.add(lblNewLabel14);
		panel_14.add(btnNewButton_11);
		
		panel_15 = new JPanel();
		panel_8.add(panel_15);
		panel_15.setLayout(new BorderLayout(0, 0));
//		點餐按鍵設定btnNewButton_12("週一59元特餐")
		JButton btnNewButton_12 = new JButton("週一59元特餐");
		btnNewButton_12.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent e) {       
	        	
	        	def.addRow(new Object[]{btnNewButton_12.getText(), spinner.getValue()});
	        	list_int.add((int)spinner.getValue()*59);
	        	int sum = 0;
	        	for (int num : list_int) {
	        	    sum += num;
	        	}
	        	lblNewLabel_9.setText(" "+sum);
//	        	lblNewLabel_9.setText(" "+(Integer.parseInt(lblNewLabel_9.getText().trim())+((int)spinner.getValue()*59)));
	        	lblNewLabel_8.setText(""+(int)(Integer.parseInt(lblNewLabel_9.getText().trim())*0.1));
	        	lblNewLabel_12.setText(""+((int)(Integer.parseInt(lblNewLabel_9.getText().trim()))+(int)(Integer.parseInt(lblNewLabel_8.getText().trim()))));
	        	
	        }});
		btnNewButton_12.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_12.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_12.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		JLabel lblNewLabel15 = new JLabel("$59");
		lblNewLabel15.setForeground(new Color(0, 128, 255));
		lblNewLabel15.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel15.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btnNewButton_12.add(lblNewLabel15);
		panel_15.add(btnNewButton_12);
		
		panel_16 = new JPanel();
		panel_8.add(panel_16);
		panel_16.setLayout(new BorderLayout(0, 0));
//		點餐按鍵設定btnNewButton_13("週二59元特餐")	
		JButton btnNewButton_13 = new JButton("週二59元特餐");
		btnNewButton_13.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent e) {       
	        	
	        	def.addRow(new Object[]{btnNewButton_13.getText(), spinner.getValue()});
	        	list_int.add((int)spinner.getValue()*59);
	        	int sum = 0;
	        	for (int num : list_int) {
	        	    sum += num;
	        	}
	        	lblNewLabel_9.setText(" "+sum);
//	        	lblNewLabel_9.setText(" "+(Integer.parseInt(lblNewLabel_9.getText().trim())+((int)spinner.getValue()*59)));
	        	lblNewLabel_8.setText(""+(int)(Integer.parseInt(lblNewLabel_9.getText().trim())*0.1));
	        	lblNewLabel_12.setText(""+((int)(Integer.parseInt(lblNewLabel_9.getText().trim()))+(int)(Integer.parseInt(lblNewLabel_8.getText().trim()))));
	        	
	        }});
		btnNewButton_13.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_13.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_13.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		JLabel lblNewLabel16 = new JLabel("$59");
		lblNewLabel16.setForeground(new Color(0, 128, 255));
		lblNewLabel16.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel16.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btnNewButton_13.add(lblNewLabel16);
		panel_16.add(btnNewButton_13);

		panel_17 = new JPanel();
		panel_8.add(panel_17);
		panel_17.setLayout(new BorderLayout(0, 0));
//		點餐按鍵設定btnNewButton_14("週三59元特餐")
		JButton btnNewButton_14 = new JButton("週三59元特餐");
		btnNewButton_14.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent e) {       
	        	
	        	def.addRow(new Object[]{btnNewButton_14.getText(), spinner.getValue()});
	        	list_int.add((int)spinner.getValue()*59);
	        	int sum = 0;
	        	for (int num : list_int) {
	        	    sum += num;
	        	}
	        	lblNewLabel_9.setText(" "+sum);
//	        	lblNewLabel_9.setText(" "+(Integer.parseInt(lblNewLabel_9.getText().trim())+((int)spinner.getValue()*59)));
	        	lblNewLabel_8.setText(""+(int)(Integer.parseInt(lblNewLabel_9.getText().trim())*0.1));
	        	lblNewLabel_12.setText(""+((int)(Integer.parseInt(lblNewLabel_9.getText().trim()))+(int)(Integer.parseInt(lblNewLabel_8.getText().trim()))));
	        	
	        }});
		btnNewButton_14.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_14.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_14.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		JLabel lblNewLabel17 = new JLabel("$59");
		lblNewLabel17.setForeground(new Color(0, 128, 255));
		lblNewLabel17.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel17.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btnNewButton_14.add(lblNewLabel17);
		panel_17.add(btnNewButton_14);
//		左至右第二行點餐按鍵Panel_5------
		panel_5 = new JPanel();
		panel_52.add(panel_5);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.Y_AXIS));
//		蛋餅系列餐點Panel_10範圍設定
		panel_10 = new JPanel();
		panel_5.add(panel_10);
		panel_10.setLayout(new BoxLayout(panel_10, BoxLayout.Y_AXIS));
//		Panel_24蛋餅標籤範圍
		panel_24 = new JPanel();
		panel_24.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_10.add(panel_24);
		panel_24.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("   蛋餅系列");
		lblNewLabel_2.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		panel_24.add(lblNewLabel_2);
	
		panel_25 = new JPanel();
		panel_10.add(panel_25);
		panel_25.setLayout(new BorderLayout(0, 0));
//		點餐按鍵設定btnNewButton_3("手工蛋餅")	
		JButton btnNewButton_3 = new JButton("手工蛋餅");
		btnNewButton_3.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent e) {       
	        	
	        	def.addRow(new Object[]{btnNewButton_3.getText(), spinner.getValue()});
	        	list_int.add((int)spinner.getValue()*55);
	        	int sum = 0;
	        	for (int num : list_int) {
	        	    sum += num;
	        	}
	        	lblNewLabel_9.setText(" "+sum);
//	        	lblNewLabel_9.setText(" "+(Integer.parseInt(lblNewLabel_9.getText().trim())+((int)spinner.getValue()*55)));
	        	lblNewLabel_8.setText(""+(int)(Integer.parseInt(lblNewLabel_9.getText().trim())*0.1));
	        	lblNewLabel_12.setText(""+((int)(Integer.parseInt(lblNewLabel_9.getText().trim()))+(int)(Integer.parseInt(lblNewLabel_8.getText().trim()))));
	        	
	        }});
		btnNewButton_3.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_3.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_3.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		JLabel lblNewLabel18 = new JLabel("$55");
		lblNewLabel18.setForeground(new Color(0, 128, 255));
		lblNewLabel18.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		lblNewLabel18.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btnNewButton_3.add(lblNewLabel18);
		panel_25.add(btnNewButton_3);
		
		panel_26 = new JPanel();
		panel_10.add(panel_26);
		panel_26.setLayout(new BorderLayout(0, 0));
//		點餐按鍵設定btnNewButton_4("芋泥蛋餅")		
		JButton btnNewButton_4 = new JButton("芋泥蛋餅");
		btnNewButton_4.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent e) {       
	        	
	        	def.addRow(new Object[]{btnNewButton_4.getText(), spinner.getValue()});
	        	list_int.add((int)spinner.getValue()*50);
	        	int sum = 0;
	        	for (int num : list_int) {
	        	    sum += num;
	        	}
	        	lblNewLabel_9.setText(" "+sum);
//	        	lblNewLabel_9.setText(" "+(Integer.parseInt(lblNewLabel_9.getText().trim())+((int)spinner.getValue()*50)));
	        	lblNewLabel_8.setText(""+(int)(Integer.parseInt(lblNewLabel_9.getText().trim())*0.1));
	        	lblNewLabel_12.setText(""+((int)(Integer.parseInt(lblNewLabel_9.getText().trim()))+(int)(Integer.parseInt(lblNewLabel_8.getText().trim()))));
	        	
	        }});
		btnNewButton_4.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_4.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_4.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		JLabel lblNewLabel19 = new JLabel("$50");
		lblNewLabel19.setForeground(new Color(0, 128, 255));
		lblNewLabel19.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel19.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btnNewButton_4.add(lblNewLabel19);
		panel_26.add(btnNewButton_4);
		panel_27 = new JPanel();
		panel_10.add(panel_27);
		panel_27.setLayout(new BorderLayout(0, 0));
//		點餐按鍵設定btnNewButton_15("地瓜蜂蜜蛋餅")	
		JButton btnNewButton_15 = new JButton("地瓜蜂蜜蛋餅");
		btnNewButton_15.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent e) {       
	        	
	        	def.addRow(new Object[]{btnNewButton_15.getText(), spinner.getValue()});
	        	list_int.add((int)spinner.getValue()*40);
	        	int sum = 0;
	        	for (int num : list_int) {
	        	    sum += num;
	        	}
	        	lblNewLabel_9.setText(" "+sum);
//	        	lblNewLabel_9.setText(" "+(Integer.parseInt(lblNewLabel_9.getText().trim())+((int)spinner.getValue()*40)));
	        	lblNewLabel_8.setText(""+(int)(Integer.parseInt(lblNewLabel_9.getText().trim())*0.1));
	        	lblNewLabel_12.setText(""+((int)(Integer.parseInt(lblNewLabel_9.getText().trim()))+(int)(Integer.parseInt(lblNewLabel_8.getText().trim()))));
	        	
	        }});
		btnNewButton_15.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_15.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_15.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		JLabel lblNewLabel20 = new JLabel("$40");
		lblNewLabel20.setForeground(new Color(0, 128, 255));
		lblNewLabel20.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel20.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btnNewButton_15.add(lblNewLabel20);
		panel_27.add(btnNewButton_15);
//		老師傅蘿蔔糕餐點Panel_11範圍設定
		panel_11 = new JPanel();
		panel_5.add(panel_11);
		panel_11.setLayout(new BoxLayout(panel_11, BoxLayout.Y_AXIS));
//		Panel_28老師傅蘿蔔糕標籤範圍
		panel_28 = new JPanel();
		panel_28.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_11.add(panel_28);
		panel_28.setLayout(new BorderLayout(0, 0));
//		Panel_28蛋餅標籤設定
		JLabel lblNewLabel_3 = new JLabel("   老師傅蘿蔔糕");
		lblNewLabel_3.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		panel_28.add(lblNewLabel_3);
		
		panel_33 = new JPanel();
		panel_11.add(panel_33);
		panel_33.setLayout(new BorderLayout(0, 0));
//		點餐按鍵設定btnNewButton_16("原味蘿蔔糕")
		JButton btnNewButton_16 = new JButton("原味蘿蔔糕");
		btnNewButton_16.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent e) {       
	        	
	        	def.addRow(new Object[]{btnNewButton_16.getText(), spinner.getValue()});
	        	list_int.add((int)spinner.getValue()*35);
	        	int sum = 0;
	        	for (int num : list_int) {
	        	    sum += num;
	        	}
	        	lblNewLabel_9.setText(" "+sum);
//	        	lblNewLabel_9.setText(" "+(Integer.parseInt(lblNewLabel_9.getText().trim())+((int)spinner.getValue()*35)));
	        	lblNewLabel_8.setText(""+(int)(Integer.parseInt(lblNewLabel_9.getText().trim())*0.1));
	        	lblNewLabel_12.setText(""+((int)(Integer.parseInt(lblNewLabel_9.getText().trim()))+(int)(Integer.parseInt(lblNewLabel_8.getText().trim()))));
	        	
	        }});
		btnNewButton_16.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewButton_16.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_16.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_16.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		JLabel lblNewLabel21 = new JLabel("$35");
		lblNewLabel21.setForeground(new Color(0, 128, 255));
		lblNewLabel21.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel21.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btnNewButton_16.add(lblNewLabel21);
		panel_33.add(btnNewButton_16);
		
		panel_34 = new JPanel();
		panel_11.add(panel_34);
		panel_34.setLayout(new BorderLayout(0, 0));
//		點餐按鍵設定btnNewButton_17("肉鬆蘿蔔糕")
		JButton btnNewButton_17 = new JButton("肉鬆蘿蔔糕");
		btnNewButton_17.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent e) {       
	        	
	        	def.addRow(new Object[]{btnNewButton_17.getText(), spinner.getValue()});
	        	list_int.add((int)spinner.getValue()*45);
	        	int sum = 0;
	        	for (int num : list_int) {
	        	    sum += num;
	        	}
	        	lblNewLabel_9.setText(" "+sum);
//	        	lblNewLabel_9.setText(" "+(Integer.parseInt(lblNewLabel_9.getText().trim())+((int)spinner.getValue()*45)));
	        	lblNewLabel_8.setText(""+(int)(Integer.parseInt(lblNewLabel_9.getText().trim())*0.1));
	        	lblNewLabel_12.setText(""+((int)(Integer.parseInt(lblNewLabel_9.getText().trim()))+(int)(Integer.parseInt(lblNewLabel_8.getText().trim()))));
	        	
	        }});
		btnNewButton_17.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_17.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_17.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		JLabel lblNewLabel22 = new JLabel("$45");
		lblNewLabel22.setForeground(new Color(0, 128, 255));
		lblNewLabel22.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel22.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btnNewButton_17.add(lblNewLabel22);
		panel_34.add(btnNewButton_17);
		
		panel_35 = new JPanel();
		panel_11.add(panel_35);
		panel_35.setLayout(new BorderLayout(0, 0));
//		點餐按鍵設定btnNewButton_19("金沙鹹蛋蘿蔔糕")
		JButton btnNewButton_19 = new JButton("金沙鹹蛋蘿蔔糕");
		btnNewButton_19.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent e) {       
	        	
	        	def.addRow(new Object[]{btnNewButton_19.getText(), spinner.getValue()});
	        	list_int.add((int)spinner.getValue()*50);
	        	int sum = 0;
	        	for (int num : list_int) {
	        	    sum += num;
	        	}
	        	lblNewLabel_9.setText(" "+sum);
//	        	lblNewLabel_9.setText(" "+(Integer.parseInt(lblNewLabel_9.getText().trim())+((int)spinner.getValue()*50)));
	        	lblNewLabel_8.setText(""+(int)(Integer.parseInt(lblNewLabel_9.getText().trim())*0.1));
	        	lblNewLabel_12.setText(""+((int)(Integer.parseInt(lblNewLabel_9.getText().trim()))+(int)(Integer.parseInt(lblNewLabel_8.getText().trim()))));
	        	
	        }});
		btnNewButton_19.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_19.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_19.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		JLabel lblNewLabel23 = new JLabel("$50");
		lblNewLabel23.setForeground(new Color(0, 128, 255));
		lblNewLabel23.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel23.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btnNewButton_19.add(lblNewLabel23);
		panel_35.add(btnNewButton_19);
//		甜吐司/厚片餐點Panel_12範圍設定
		panel_12 = new JPanel();
		panel_5.add(panel_12);
		panel_12.setLayout(new BoxLayout(panel_12, BoxLayout.Y_AXIS));
//		Panel_29甜吐司/厚片標籤範圍設定
		panel_29 = new JPanel();
		panel_29.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_12.add(panel_29);
		panel_29.setLayout(new BorderLayout(0, 0));
//		Panel_29甜吐司/厚片標籤設定		
		JLabel lblNewLabel_4 = new JLabel("   甜吐司/厚片");
		lblNewLabel_4.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		panel_29.add(lblNewLabel_4);
		
		panel_30 = new JPanel();
		panel_12.add(panel_30);
		panel_30.setLayout(new BorderLayout(0, 0));
//		點餐按鍵設定btnNewButton_20("吐司薄片")
		JButton btnNewButton_20 = new JButton("吐司薄片");
		btnNewButton_20.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent e) {       
	        	
	        	def.addRow(new Object[]{btnNewButton_20.getText(), spinner.getValue()});
	        	list_int.add((int)spinner.getValue()*25);
	        	int sum = 0;
	        	for (int num : list_int) {
	        	    sum += num;
	        	}
	        	lblNewLabel_9.setText(" "+sum);
//	        	lblNewLabel_9.setText(" "+(Integer.parseInt(lblNewLabel_9.getText().trim())+((int)spinner.getValue()*25)));
	        	lblNewLabel_8.setText(""+(int)(Integer.parseInt(lblNewLabel_9.getText().trim())*0.1));
	        	lblNewLabel_12.setText(""+((int)(Integer.parseInt(lblNewLabel_9.getText().trim()))+(int)(Integer.parseInt(lblNewLabel_8.getText().trim()))));
	        	
	        }});
		btnNewButton_20.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_20.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_20.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		JLabel lblNewLabel24 = new JLabel("$25");
		lblNewLabel24.setForeground(new Color(0, 128, 255));
		lblNewLabel24.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel24.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btnNewButton_20.add(lblNewLabel24);
		panel_30.add(btnNewButton_20);

		panel_31 = new JPanel();
		panel_12.add(panel_31);
		panel_31.setLayout(new BorderLayout(0, 0));
//		點餐按鍵設定btnNewButton_22("方塊厚片")
		JButton btnNewButton_22 = new JButton("方塊厚片");
		btnNewButton_22.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent e) {       
	        	
	        	def.addRow(new Object[]{btnNewButton_22.getText(), spinner.getValue()});
	        	list_int.add((int)spinner.getValue()*55);
	        	int sum = 0;
	        	for (int num : list_int) {
	        	    sum += num;
	        	}
	        	lblNewLabel_9.setText(" "+sum);
//	        	lblNewLabel_9.setText(" "+(Integer.parseInt(lblNewLabel_9.getText().trim())+((int)spinner.getValue()*55)));
	        	lblNewLabel_8.setText(""+(int)(Integer.parseInt(lblNewLabel_9.getText().trim())*0.1));
	        	lblNewLabel_12.setText(""+((int)(Integer.parseInt(lblNewLabel_9.getText().trim()))+(int)(Integer.parseInt(lblNewLabel_8.getText().trim()))));
	        	
	        }});
		btnNewButton_22.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_22.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_22.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		JLabel lblNewLabel25 = new JLabel("$55");
		lblNewLabel25.setForeground(new Color(0, 128, 255));
		lblNewLabel25.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel25.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btnNewButton_22.add(lblNewLabel25);
		panel_31.add(btnNewButton_22);
		
		panel_32 = new JPanel();
		panel_12.add(panel_32);
		panel_32.setLayout(new BorderLayout(0, 0));
//		點餐按鍵設定btnNewButton_23("山形厚片")
		JButton btnNewButton_23 = new JButton("山形厚片");
		btnNewButton_23.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent e) {       
	        	
	        	def.addRow(new Object[]{btnNewButton_23.getText(), spinner.getValue()});
	        	list_int.add((int)spinner.getValue()*55);
	        	int sum = 0;
	        	for (int num : list_int) {
	        	    sum += num;
	        	}
	        	lblNewLabel_9.setText(" "+sum);
//	        	lblNewLabel_9.setText(" "+(Integer.parseInt(lblNewLabel_9.getText().trim())+((int)spinner.getValue()*55)));
	        	lblNewLabel_8.setText(""+(int)(Integer.parseInt(lblNewLabel_9.getText().trim())*0.1));
	        	lblNewLabel_12.setText(""+((int)(Integer.parseInt(lblNewLabel_9.getText().trim()))+(int)(Integer.parseInt(lblNewLabel_8.getText().trim()))));
	        	
	        }});
		btnNewButton_23.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_23.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_23.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		JLabel lblNewLabel26 = new JLabel("$55");
		lblNewLabel26.setForeground(new Color(0, 128, 255));
		lblNewLabel26.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel26.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btnNewButton_23.add(lblNewLabel26);
		panel_32.add(btnNewButton_23);
//		左至右第三行點餐按鍵Panel_6------
		panel_6 = new JPanel();
		panel_52.add(panel_6);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.Y_AXIS));
//		經典飲品餐點Panel_36標籤範圍設定
		panel_36 = new JPanel();
		panel_36.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_6.add(panel_36);
		panel_36.setLayout(new BorderLayout(0, 0));
//		經典飲品餐點Panel_36標籤設定
		JLabel lblNewLabel_5 = new JLabel("   經典飲品");
		lblNewLabel_5.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		panel_36.add(lblNewLabel_5);

		panel_37 = new JPanel();
		panel_6.add(panel_37);
		panel_37.setLayout(new BorderLayout(0, 0));
//		點餐按鍵設定btnNewButton_5("紅茶")
		JButton btnNewButton_5 = new JButton("紅茶");
		btnNewButton_5.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent e) {       
	        	
	        	def.addRow(new Object[]{btnNewButton_5.getText(), spinner.getValue()});
	        	list_int.add((int)spinner.getValue()*15);
	        	int sum = 0;
	        	for (int num : list_int) {
	        	    sum += num;
	        	}
	        	lblNewLabel_9.setText(" "+sum);
//	        	lblNewLabel_9.setText(" "+(Integer.parseInt(lblNewLabel_9.getText().trim())+((int)spinner.getValue()*15)));
	        	lblNewLabel_8.setText(""+(int)(Integer.parseInt(lblNewLabel_9.getText().trim())*0.1));
	        	lblNewLabel_12.setText(""+((int)(Integer.parseInt(lblNewLabel_9.getText().trim()))+(int)(Integer.parseInt(lblNewLabel_8.getText().trim()))));
	        	
	        }});
		btnNewButton_5.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_5.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_5.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		JLabel lblNewLabel27 = new JLabel("$15");
		lblNewLabel27.setForeground(new Color(0, 128, 255));
		lblNewLabel27.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel27.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btnNewButton_5.add(lblNewLabel27);
		panel_37.add(btnNewButton_5, BorderLayout.CENTER);
		
		panel_38 = new JPanel();
		panel_6.add(panel_38);
		panel_38.setLayout(new BorderLayout(0, 0));
//		點餐按鍵設定btnNewButton_5("奶茶")
		JButton btnNewButton_18 = new JButton("奶茶");
		btnNewButton_18.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent e) {       
	        	
	        	def.addRow(new Object[]{btnNewButton_18.getText(), spinner.getValue()});
	        	list_int.add((int)spinner.getValue()*20);
	        	int sum = 0;
	        	for (int num : list_int) {
	        	    sum += num;
	        	}
	        	lblNewLabel_9.setText(" "+sum);
//	        	lblNewLabel_9.setText(" "+(Integer.parseInt(lblNewLabel_9.getText().trim())+((int)spinner.getValue()*20)));
	        	lblNewLabel_8.setText(""+(int)(Integer.parseInt(lblNewLabel_9.getText().trim())*0.1));
	        	lblNewLabel_12.setText(""+((int)(Integer.parseInt(lblNewLabel_9.getText().trim()))+(int)(Integer.parseInt(lblNewLabel_8.getText().trim()))));
	        	
	        }});
		btnNewButton_18.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_18.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_18.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		JLabel lblNewLabel28 = new JLabel("$20");
		lblNewLabel28.setForeground(new Color(0, 128, 255));
		lblNewLabel28.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel28.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btnNewButton_18.add(lblNewLabel28);
		panel_38.add(btnNewButton_18, BorderLayout.CENTER);
		
		panel_39 = new JPanel();
		panel_6.add(panel_39);
		panel_39.setLayout(new BorderLayout(0, 0));
//		點餐按鍵設定btnNewButton_21("豆漿")
		JButton btnNewButton_21 = new JButton("豆漿");
		btnNewButton_21.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent e) {       
	        	
	        	def.addRow(new Object[]{btnNewButton_21.getText(), spinner.getValue()});
	        	list_int.add((int)spinner.getValue()*15);
	        	int sum = 0;
	        	for (int num : list_int) {
	        	    sum += num;
	        	}
	        	lblNewLabel_9.setText(" "+sum);
//	        	lblNewLabel_9.setText(" "+(Integer.parseInt(lblNewLabel_9.getText().trim())+((int)spinner.getValue()*15)));
	        	lblNewLabel_8.setText(""+(int)(Integer.parseInt(lblNewLabel_9.getText().trim())*0.1));
	        	lblNewLabel_12.setText(""+((int)(Integer.parseInt(lblNewLabel_9.getText().trim()))+(int)(Integer.parseInt(lblNewLabel_8.getText().trim()))));
	        	
	        }});
		btnNewButton_21.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_21.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_21.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		JLabel lblNewLabel29 = new JLabel("$15");
		lblNewLabel29.setForeground(new Color(0, 128, 255));
		lblNewLabel29.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel29.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btnNewButton_21.add(lblNewLabel29);
		panel_39.add(btnNewButton_21, BorderLayout.CENTER);
		
		panel_40 = new JPanel();
		panel_6.add(panel_40);
		panel_40.setLayout(new BorderLayout(0, 0));
//		點餐按鍵設定btnNewButton_24("鮮奶茶")
		JButton btnNewButton_24 = new JButton("鮮奶茶");
		btnNewButton_24.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent e) {       
	        	
	        	def.addRow(new Object[]{btnNewButton_24.getText(), spinner.getValue()});
	        	list_int.add((int)spinner.getValue()*35);
	        	int sum = 0;
	        	for (int num : list_int) {
	        	    sum += num;
	        	}
	        	lblNewLabel_9.setText(" "+sum);
//	        	lblNewLabel_9.setText(" "+(Integer.parseInt(lblNewLabel_9.getText().trim())+((int)spinner.getValue()*35)));
	        	lblNewLabel_8.setText(""+(int)(Integer.parseInt(lblNewLabel_9.getText().trim())*0.1));
	        	lblNewLabel_12.setText(""+((int)(Integer.parseInt(lblNewLabel_9.getText().trim()))+(int)(Integer.parseInt(lblNewLabel_8.getText().trim()))));
	        	
	        	
	        }});
		btnNewButton_24.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_24.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_24.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		JLabel lblNewLabel30 = new JLabel("$35");
		lblNewLabel30.setForeground(new Color(0, 128, 255));
		lblNewLabel30.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel30.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btnNewButton_24.add(lblNewLabel30);
		panel_40.add(btnNewButton_24, BorderLayout.CENTER);
		
		panel_41 = new JPanel();
		panel_6.add(panel_41);
		panel_41.setLayout(new BorderLayout(0, 0));
//		點餐按鍵設定btnNewButton_25("柳橙汁")
		JButton btnNewButton_25 = new JButton("柳橙汁");
		btnNewButton_25.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent e) {       
	        	
	        	def.addRow(new Object[]{btnNewButton_25.getText(), spinner.getValue()});
	        	list_int.add((int)spinner.getValue()*20);
	        	int sum = 0;
	        	for (int num : list_int) {
	        	    sum += num;
	        	}
	        	lblNewLabel_9.setText(" "+sum);
//	        	lblNewLabel_9.setText(" "+(Integer.parseInt(lblNewLabel_9.getText().trim())+((int)spinner.getValue()*20)));
	        	lblNewLabel_8.setText(""+(int)(Integer.parseInt(lblNewLabel_9.getText().trim())*0.1));
	        	lblNewLabel_12.setText(""+((int)(Integer.parseInt(lblNewLabel_9.getText().trim()))+(int)(Integer.parseInt(lblNewLabel_8.getText().trim()))));
	        	
	        }});
		btnNewButton_25.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_25.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_25.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		JLabel lblNewLabel31 = new JLabel("$20");
		lblNewLabel31.setForeground(new Color(0, 128, 255));
		lblNewLabel31.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel31.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btnNewButton_25.add(lblNewLabel31);
		panel_41.add(btnNewButton_25, BorderLayout.CENTER);
		
		panel_42 = new JPanel();
		panel_6.add(panel_42);
		panel_42.setLayout(new BorderLayout(0, 0));
//		點餐按鍵設定btnNewButton_26("豆漿紅茶")
		JButton btnNewButton_26 = new JButton("豆漿紅茶");
		btnNewButton_26.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent e) {       
	        	
	        	def.addRow(new Object[]{btnNewButton_26.getText(), spinner.getValue()});
	        	list_int.add((int)spinner.getValue()*20);
	        	int sum = 0;
	        	for (int num : list_int) {
	        	    sum += num;
	        	}
	        	lblNewLabel_9.setText(" "+sum);
//	        	lblNewLabel_9.setText(" "+(Integer.parseInt(lblNewLabel_9.getText().trim())+((int)spinner.getValue()*20)));
	        	lblNewLabel_8.setText(""+(int)(Integer.parseInt(lblNewLabel_9.getText().trim())*0.1));
	        	lblNewLabel_12.setText(""+((int)(Integer.parseInt(lblNewLabel_9.getText().trim()))+(int)(Integer.parseInt(lblNewLabel_8.getText().trim()))));
	        	
	        }});
		btnNewButton_26.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_26.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_26.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		JLabel lblNewLabel32 = new JLabel("$20");
		lblNewLabel32.setForeground(new Color(0, 128, 255));
		lblNewLabel32.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel32.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btnNewButton_26.add(lblNewLabel32);
		panel_42.add(btnNewButton_26, BorderLayout.CENTER);
		
		panel_43 = new JPanel();
		panel_6.add(panel_43);
		panel_43.setLayout(new BorderLayout(0, 0));
//		點餐按鍵設定btnNewButton_27("寶貝純鮮奶")
		JButton btnNewButton_27 = new JButton("寶貝純鮮奶");
		btnNewButton_27.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent e) {       
	        	
	        	def.addRow(new Object[]{btnNewButton_27.getText(), spinner.getValue()});
	        	list_int.add((int)spinner.getValue()*20);
	        	int sum = 0;
	        	for (int num : list_int) {
	        	    sum += num;
	        	}
	        	lblNewLabel_9.setText(" "+sum);
//	        	lblNewLabel_9.setText(" "+(Integer.parseInt(lblNewLabel_9.getText().trim())+((int)spinner.getValue()*20)));
	        	lblNewLabel_8.setText(""+(int)(Integer.parseInt(lblNewLabel_9.getText().trim())*0.1));
	        	lblNewLabel_12.setText(""+((int)(Integer.parseInt(lblNewLabel_9.getText().trim()))+(int)(Integer.parseInt(lblNewLabel_8.getText().trim()))));
	        	
	        }});
		btnNewButton_27.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_27.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_27.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		JLabel lblNewLabel33 = new JLabel("$20");
		lblNewLabel33.setForeground(new Color(0, 128, 255));
		lblNewLabel33.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel33.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btnNewButton_27.add(lblNewLabel33);
		panel_43.add(btnNewButton_27, BorderLayout.CENTER);

		panel_44 = new JPanel();
		panel_6.add(panel_44);
		panel_44.setLayout(new BorderLayout(0, 0));
//		點餐按鍵設定btnNewButton_28("無糖冷泡茶")
		JButton btnNewButton_28 = new JButton("無糖冷泡茶");
		btnNewButton_28.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent e) {       
	        	
	        	def.addRow(new Object[]{btnNewButton_28.getText(), spinner.getValue()});
	        	list_int.add((int)spinner.getValue()*15);
	        	int sum = 0;
	        	for (int num : list_int) {
	        	    sum += num;
	        	}
	        	lblNewLabel_9.setText(" "+sum);
//	        	lblNewLabel_9.setText(" "+(Integer.parseInt(lblNewLabel_9.getText().trim())+((int)spinner.getValue()*15)));
	        	lblNewLabel_8.setText(""+(int)(Integer.parseInt(lblNewLabel_9.getText().trim())*0.1));
	        	lblNewLabel_12.setText(""+((int)(Integer.parseInt(lblNewLabel_9.getText().trim()))+(int)(Integer.parseInt(lblNewLabel_8.getText().trim()))));
	        	
	        }});
		btnNewButton_28.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_28.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_28.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		JLabel lblNewLabel34 = new JLabel("$15");
		lblNewLabel34.setForeground(new Color(0, 128, 255));
		lblNewLabel34.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel34.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btnNewButton_28.add(lblNewLabel34);
		panel_44.add(btnNewButton_28, BorderLayout.CENTER);
		
		panel_45 = new JPanel();
		panel_6.add(panel_45);
		panel_45.setLayout(new BorderLayout(0, 0));
//		點餐按鍵設定btnNewButton_29("柚子釀蜜茶")
		JButton btnNewButton_29 = new JButton("柚子釀蜜茶");
		btnNewButton_29.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent e) {       
	        	
	        	def.addRow(new Object[]{btnNewButton_29.getText(), spinner.getValue()});
	        	list_int.add((int)spinner.getValue()*40);
	        	int sum = 0;
	        	for (int num : list_int) {
	        	    sum += num;
	        	}
	        	lblNewLabel_9.setText(" "+sum);
//	        	lblNewLabel_9.setText(" "+(Integer.parseInt(lblNewLabel_9.getText().trim())+((int)spinner.getValue()*40)));
	        	lblNewLabel_8.setText(""+(int)(Integer.parseInt(lblNewLabel_9.getText().trim())*0.1));
	        	lblNewLabel_12.setText(""+((int)(Integer.parseInt(lblNewLabel_9.getText().trim()))+(int)(Integer.parseInt(lblNewLabel_8.getText().trim()))));
	        	
	        }});
		btnNewButton_29.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_29.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_29.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		JLabel lblNewLabel35 = new JLabel("$40");
		lblNewLabel35.setForeground(new Color(0, 128, 255));
		lblNewLabel35.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel35.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btnNewButton_29.add(lblNewLabel35);
		panel_45.add(btnNewButton_29, BorderLayout.CENTER);
		
		panel_46 = new JPanel();
		panel_6.add(panel_46);
		panel_46.setLayout(new BorderLayout(0, 0));
//		點餐按鍵設定btnNewButton_30("桂花釀蜜茶")
		JButton btnNewButton_30 = new JButton("桂花釀蜜茶");
		btnNewButton_30.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent e) {       
	        	
	        	def.addRow(new Object[]{btnNewButton_30.getText(), spinner.getValue()});
	        	list_int.add((int)spinner.getValue()*40);
	        	int sum = 0;
	        	for (int num : list_int) {
	        	    sum += num;
	        	}
	        	lblNewLabel_9.setText(" "+sum);
//	        	lblNewLabel_9.setText(" "+(Integer.parseInt(lblNewLabel_9.getText().trim())+((int)spinner.getValue()*40)));
	        	lblNewLabel_8.setText(""+(int)(Integer.parseInt(lblNewLabel_9.getText().trim())*0.1));
	        	lblNewLabel_12.setText(""+((int)(Integer.parseInt(lblNewLabel_9.getText().trim()))+(int)(Integer.parseInt(lblNewLabel_8.getText().trim()))));
	        	
	        }});
		btnNewButton_30.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_30.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_30.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		JLabel lblNewLabel36 = new JLabel("$40");
		lblNewLabel36.setForeground(new Color(0, 128, 255));
		lblNewLabel36.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel36.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btnNewButton_30.add(lblNewLabel36);
		panel_46.add(btnNewButton_30, BorderLayout.CENTER);

		panel_47 = new JPanel();
		panel_6.add(panel_47);
		panel_47.setLayout(new BorderLayout(0, 0));
//		點餐按鍵設定btnNewButton_31("冰塊加購"))
		JButton btnNewButton_31 = new JButton("冰塊加購");
		btnNewButton_31.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent e) {       
	        	
	        	def.addRow(new Object[]{btnNewButton_31.getText(), spinner.getValue()});
	        	list_int.add((int)spinner.getValue()*5);
	        	int sum = 0;
	        	for (int num : list_int) {
	        	    sum += num;
	        	}
	        	lblNewLabel_9.setText(" "+sum);
//	        	lblNewLabel_9.setText(" "+(Integer.parseInt(lblNewLabel_9.getText().trim())+((int)spinner.getValue()*5)));
	        	lblNewLabel_8.setText(""+(int)(Integer.parseInt(lblNewLabel_9.getText().trim())*0.1));
	        	lblNewLabel_12.setText(""+((int)(Integer.parseInt(lblNewLabel_9.getText().trim()))+(int)(Integer.parseInt(lblNewLabel_8.getText().trim()))));
	        	
	        	
	        }});
		btnNewButton_31.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_31.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_31.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		JLabel lblNewLabel37 = new JLabel("$5");
		lblNewLabel37.setForeground(new Color(0, 128, 255));
		lblNewLabel37.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel37.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		btnNewButton_31.add(lblNewLabel37);
		panel_47.add(btnNewButton_31, BorderLayout.CENTER);
//		點參暫存、明細區塊panel_7範圍設定加入CardLayout第一顯示頁面
		panel_7 = new JPanel();
		panel_7.setPreferredSize(new Dimension(200, 550));
		panel_52.add(panel_7);
		panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.Y_AXIS));
//		建立明細加入panel_7
		panel_50 = new JPanel();
		panel_50.setBounds(new Rectangle(0, 0, 200, 38));
		panel_7.add(panel_50);
		panel_50.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_50.setLayout(new BoxLayout(panel_50, BoxLayout.Y_AXIS));
//		店內點單標籤設定
		JLabel lblNewLabel_6 = new JLabel("店內點單");
		lblNewLabel_6.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel_6.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		lblNewLabel_6.setPreferredSize(new Dimension(125, 38));
		lblNewLabel_6.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_50.add(lblNewLabel_6);
		
		panel_49 = new JPanel();
		panel_49.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		panel_49.setLocation(new Point(0, 38));
		panel_49.setSize(new Dimension(200, 38));
		panel_7.add(panel_49);
		panel_49.setLayout(new BoxLayout(panel_49, BoxLayout.X_AXIS));
//		服務費標籤設定
		JLabel lblNewLabel_7 = new JLabel("  服務費10% : ");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_7.setHorizontalTextPosition(SwingConstants.LEFT);
		lblNewLabel_7.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		panel_49.add(lblNewLabel_7);		
		
		lblNewLabel_8 = new JLabel("0");
		lblNewLabel_8.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_8.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblNewLabel_8.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		panel_49.add(lblNewLabel_8);
//		明細表內部table設定
		def = new DefaultTableModel();		
		def.addColumn("菜名");
    	def.addColumn("數量");
		table = new JTable();
		table.setModel(def);
		table.getColumnModel().getColumn(1).setPreferredWidth(35);
		table.setRowHeight(30);
		table.setIntercellSpacing(new Dimension(0, 0));
		table.setFont(new Font("新細明體", Font.PLAIN, 12));
//		明細頁面滾軸jScrollpane_1範圍設定		
		JScrollPane jScrollPane_1 = new JScrollPane(table);
        jScrollPane_1.setBounds(new Rectangle(0, 77, 200, 380));
        jScrollPane_1.getViewport().setOpaque(false);	
        jScrollPane_1.setToolTipText("");
        jScrollPane_1.setLocation(new Point(0, 78));
        jScrollPane_1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        
        panel_7.add(jScrollPane_1);
		panel_7.setLayout(null);
//		小計panel_48範圍設定
		panel_48 = new JPanel();
		panel_48.setSize(new Dimension(200, 40));
		panel_48.setLocation(new Point(0, 458));
		panel_7.add(panel_48);
		panel_48.setLayout(null);
//		小計標籤設定		
		JLabel lblNewLabel_28 = new JLabel("  小計 :");
		lblNewLabel_28.setBounds(0, 11, 38, 18);
		lblNewLabel_28.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel_28.setFont(new Font("微軟正黑體", Font.BOLD, 13));
		lblNewLabel_28.setHorizontalTextPosition(SwingConstants.LEFT);
		lblNewLabel_28.setHorizontalAlignment(SwingConstants.LEFT);
		panel_48.add(lblNewLabel_28);
//		小計金額標籤設定
		lblNewLabel_9 = new JLabel(" 0");
		lblNewLabel_9.setBounds(39, 11, 59, 18);
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_9.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		panel_48.add(lblNewLabel_9);
//		總計標籤設定
		JLabel lblNewLabel_11 = new JLabel("   總計 :");
		lblNewLabel_11.setFont(new Font("微軟正黑體", Font.BOLD, 13));
		lblNewLabel_11.setBounds(103, 11, 49, 19);
		panel_48.add(lblNewLabel_11);
//		總計金額標籤設定
		lblNewLabel_12 = new JLabel("0");
		lblNewLabel_12.setBounds(141, 15, 49, 15);
		lblNewLabel_12.setToolTipText("");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_48.add(lblNewLabel_12);
//		數量變更按鍵spinner設定
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(Integer.valueOf(1), null, null, Integer.valueOf(1)));
		spinner.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		spinner.setBounds(new Rectangle(100, 500, 100, 40));
		spinner.setOpaque(false);
		panel_7.add(spinner);
		
		panel_2 = new JPanel();
		panel_2.setBounds(new Rectangle(0, 540, 200, 110));
		panel_7.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
//		刪除按鍵新增及監聽
		JButton btnNewButton_32 = new JButton("刪除");
		btnNewButton_32.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton_32.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				list_int.remove(table.getSelectedRow());
	        	int sum = 0;
	        	for (int num : list_int) {
	        	    sum += num;
	        	}
	        	

	        	lblNewLabel_9.setText(" "+sum);
	        	lblNewLabel_8.setText(""+(int)(Integer.parseInt(lblNewLabel_9.getText().trim())*0.1));
	        	lblNewLabel_12.setText(""+((int)(Integer.parseInt(lblNewLabel_9.getText().trim()))+(int)(Integer.parseInt(lblNewLabel_8.getText().trim()))));
	        	
				

				def.removeRow(table.getSelectedRow());
				table.setModel(def);
				
				
			}
		});
//		刪除按鍵位置設定
		btnNewButton_32.setMaximumSize(new Dimension(200, 40));
		panel_2.add(btnNewButton_32);
//		結帳按鍵新增及監聽
		JButton btnNewButton_2 = new JButton("結帳");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int rowCount = def.getRowCount();
				int columnCount = def.getColumnCount();
//				def.getDataVector();
				
//				int rowCount = def_ta1.getRowCount();
//			    判斷各桌明細表若為空格代入列及欄(一號桌)
				if (def_ta1.getRowCount() == 0) {

					for (int row = 0; row < rowCount; row++) {
					    Vector<Object> rowData = new Vector<>();
					    for (int column = 0; column < columnCount; column++) {
					        Object value = def.getValueAt(row, column);
					        rowData.add(value);
					    }
					    def_ta1.addRow(rowData);

					}
					
				} 
//			    判斷各桌明細表若為空格代入列及欄(二號桌)
				else if(def_ta2.getRowCount() == 0) {

					for (int row = 0; row < rowCount; row++) {
					    Vector<Object> rowData = new Vector<>();
					    for (int column = 0; column < columnCount; column++) {
					        Object value = def.getValueAt(row, column);
					        rowData.add(value);
					    }
					    def_ta2.addRow(rowData);
					}
					
				}
//			    判斷各桌明細表若為空格代入列及欄(三號桌)
				else if(def_ta3.getRowCount() == 0) {

					for (int row = 0; row < rowCount; row++) {
					    Vector<Object> rowData = new Vector<>();
					    for (int column = 0; column < columnCount; column++) {
					        Object value = def.getValueAt(row, column);
					        rowData.add(value);
					    }
					    def_ta3.addRow(rowData);
					}
					
				}
//			    判斷各桌明細表若為空格代入列及欄(四號桌)
				else if(def_ta4.getRowCount() == 0) {

					for (int row = 0; row < rowCount; row++) {
					    Vector<Object> rowData = new Vector<>();
					    for (int column = 0; column < columnCount; column++) {
					        Object value = def.getValueAt(row, column);
					        rowData.add(value);
					    }
					    def_ta4.addRow(rowData);
					}
					
				}
				else {
				    // 表格为空
					JOptionPane.showMessageDialog(null, "已客滿");
				}
				try {
				    // 加載MySQL JDBC驅動程序
				    Class.forName("com.mysql.jdbc.Driver");

				    // 建立到MySQL數據庫的連接。連接URL包含數據庫的位置、使用的協議、時間區和字符編碼設置
				    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&characterEncoding=utf8", "root", "zds123456");

				    // 創建一個用於執行SQL語句的Statement對象
				    Statement stmt = con.createStatement(); 

				    // 執行SQL語句，創建一個新的數據庫"food"
				    stmt.execute("CREATE DATABASE IF NOT EXISTS food CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci");

				    // 切換到剛創建的數據庫"food"
				    stmt.execute("USE food");

				    // 在"food"數據庫中創建一個新的數據表"test1"
				    stmt.execute("CREATE TABLE IF NOT EXISTS test1 " +
				            "(id INT AUTO_INCREMENT, " +
				            "dish_name VARCHAR(255), " +
				            "quantity VARCHAR(255), " +
				            "PRIMARY KEY(id))");

				    // 在新建的數據表中插入數據
				    for (int row = 0; row < rowCount; row++) {
				        // 創建一個預備語句，該語句可包含一個或多個輸入參數
				        PreparedStatement pstmt = con.prepareStatement("INSERT INTO test1 (dish_name, quantity) VALUES (?, ?)");
				        
				        // 設置預備語句的參數值
				        for (int column = 0; column < columnCount; column++) {
				            Object value = def.getValueAt(row, column);
				            pstmt.setObject(column + 1, value);
				        }

				        // 執行預備語句，將數據插入數據表中
				        pstmt.executeUpdate();
				    }

				    // 關閉數據庫連接
				    con.close();
				} catch (Exception ex) {
				    // 打印出現的異常
				    ex.printStackTrace();
				} 

				def.setRowCount(0);
				list_int.clear();
				
				int sum = 0;
				for (int num : list_int) {
					sum += num;
				}
				
				lblNewLabel_9.setText(" " + sum);
				lblNewLabel_8.setText("" + (int) (Integer.parseInt(lblNewLabel_9.getText().trim()) * 0.1));
				lblNewLabel_12.setText(""+((int)(Integer.parseInt(lblNewLabel_9.getText().trim()))+(int)(Integer.parseInt(lblNewLabel_8.getText().trim()))));
				
			}
		});
//		結帳按鍵字體及位置設定
		btnNewButton_2.setMaximumSize(new Dimension(200, 75));
		btnNewButton_2.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		panel_2.add(btnNewButton_2);
		
		panel_51 = new JPanel();
		panel_51.setBounds(new Rectangle(0, 500, 100, 40));
		panel_7.add(panel_51);
		panel_51.setLayout(new BoxLayout(panel_51, BoxLayout.X_AXIS));
//		spinner 註解label
		JLabel lblNewLabel_10 = new JLabel("變更數量 :");
		lblNewLabel_10.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		panel_51.add(lblNewLabel_10);
//		CardLayout點餐頁面切換按鈕監聽
		btnNewButton.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent e) {       
	        	
	        	crd.show(panel_3,"1");
	        	frame.setTitle("點餐");
	        	
	        }});
		
		
//		CardLayout第二顯示頁面(各桌明細)
		panel_53 = new JPanel();
		panel_53.setSize(new Dimension(532, 532));
		panel01 = new JPanel();
		panel01.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		panel01.setLayout(new BoxLayout(panel01, BoxLayout.X_AXIS));
		
		
		// 创建一个新的 JPanel，并将其添加到 panel01
		JP1 = new JPanel();
		panel01.add(JP1);
		JP1.setLayout(new BoxLayout(JP1, BoxLayout.Y_AXIS));

		// 创建一个新的 JLabel，并将其添加到 JP1
		JLabel AA = new JLabel("第1號桌");
		AA.setAlignmentX(Component.CENTER_ALIGNMENT);
		AA.setBorder(new LineBorder(new Color(192, 192, 192)));
		AA.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		AA.setForeground(Color.black);
		JP1.add(AA);

		// 创建一个新的 DefaultTableModel，并添加列
		def_ta1 = new DefaultTableModel();
		def_ta1.addColumn("菜名");
		def_ta1.addColumn("數量");

		// 创建一个新的 JTable，并设置其模型
		A2 = new JTable();
		A2.setModel(def_ta1);

		// 获取表格的列模型，并设置首列的宽度
		TableColumnModel columnModel1 = A2.getColumnModel();
		columnModel1.getColumn(0).setPreferredWidth(230);

		// 设置行高、网格颜色和字体
		A2.setRowHeight(32);
		A2.setGridColor(Color.black);
		A2.setFont(new Font("微軟正黑體", Font.BOLD, 18)); 

		// 设置表头字体
		Font headerFont1 = new Font("微软雅黑", Font.BOLD, 20);
		A2.getTableHeader().setFont(headerFont1);

		// 设置表头对齐方式
		DefaultTableCellRenderer headerRenderer1 = (DefaultTableCellRenderer) A2.getTableHeader().getDefaultRenderer();
		headerRenderer1.setHorizontalAlignment(SwingConstants.CENTER);

		// 创建一个新的 JScrollPane，并将其添加到 JP1
		JScrollPane A1 = new JScrollPane(A2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		A1.getViewport().setBackground(Color.WHITE);
		JP1.add(A1);
		
		
		
		// 创建一个新的 JPanel，并将其添加到 panel01
		JP2 = new JPanel();
		panel01.add(JP2);
		JP2.setLayout(new BoxLayout(JP2, BoxLayout.Y_AXIS));

		// 创建一个新的 JLabel，并将其添加到 JP2
		JLabel BB = new JLabel("第2號桌");
		BB.setAlignmentX(Component.CENTER_ALIGNMENT);
		BB.setBorder(new LineBorder(new Color(192, 192, 192)));
		BB.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		BB.setForeground(Color.black);
		BB.setHorizontalAlignment(SwingConstants.CENTER);
		JP2.add(BB);

		// 创建一个新的 DefaultTableModel，并添加列
		def_ta2 = new DefaultTableModel();
		def_ta2.addColumn("菜名");
		def_ta2.addColumn("數量");

		// 创建一个新的 JTable，并设置其模型
		B2 = new JTable();
		B2.setModel(def_ta2);

		// 获取表格的列模型，并设置首列的宽度
		TableColumnModel columnModel2 = B2.getColumnModel();
		columnModel2.getColumn(0).setPreferredWidth(230);

		// 设置行高、网格颜色和字体
		B2.setRowHeight(32);
		B2.setGridColor(Color.black);
		B2.setFont(new Font("微軟正黑體", Font.BOLD, 18)); 

		// 设置表头字体
		Font headerFont2 = new Font("微软雅黑", Font.BOLD, 20);
		B2.getTableHeader().setFont(headerFont2);

		// 设置表头对齐方式
		DefaultTableCellRenderer headerRenderer2 = (DefaultTableCellRenderer) B2.getTableHeader().getDefaultRenderer();
		headerRenderer2.setHorizontalAlignment(SwingConstants.CENTER);

		// 创建一个新的 JScrollPane，并将其添加到 JP2
		JScrollPane B1 = new JScrollPane(B2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		B1.getViewport().setBackground(Color.WHITE);
		JP2.add(B1);
		
		// 创建一个新的 JPanel，并将其添加到 panel01
		JP3 = new JPanel();
		panel01.add(JP3);	
		JP3.setLayout(new BoxLayout(JP3, BoxLayout.Y_AXIS));

		// 创建一个新的 JLabel，并将其添加到 JP3
		JLabel CC = new JLabel("第3號桌");
		CC.setAlignmentX(Component.CENTER_ALIGNMENT);
		CC.setBorder(new LineBorder(new Color(192, 192, 192)));
		CC.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		CC.setForeground(Color.black);
		CC.setHorizontalAlignment(SwingConstants.CENTER);
		JP3.add(CC);     

		// 创建一个新的 DefaultTableModel，并添加列
		def_ta3 = new DefaultTableModel();
		def_ta3.addColumn("菜名");
		def_ta3.addColumn("數量");        

		// 创建一个新的 JTable，并设置其模型
		C2 = new JTable();
		C2.setModel(def_ta3);

		// 获取表格的列模型，并设置首列的宽度
		TableColumnModel columnModel3 = C2.getColumnModel();
		columnModel3.getColumn(0).setPreferredWidth(230);

		// 设置行高、网格颜色和字体
		C2.setRowHeight(32);
		C2.setGridColor(Color.black);		
		C2.setFont(new Font("微軟正黑體", Font.BOLD, 18)); 

		// 设置表头字体
		Font headerFont3 = new Font("微软雅黑", Font.BOLD, 20);
		C2.getTableHeader().setFont(headerFont3);

		// 设置表头对齐方式
		DefaultTableCellRenderer headerRenderer3 = (DefaultTableCellRenderer) C2.getTableHeader().getDefaultRenderer();
		headerRenderer3.setHorizontalAlignment(SwingConstants.CENTER);

		// 创建一个新的 JScrollPane，并将其添加到 JP3
		JScrollPane C1 = new JScrollPane(C2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		C1.getViewport().setBackground(Color.WHITE);
		JP3.add(C1);  
		
		
		// 创建一个新的 JPanel，并将其添加到 panel01
		JP4 = new JPanel();
		panel01.add(JP4);
		JP4.setLayout(new BoxLayout(JP4, BoxLayout.Y_AXIS));

		// 创建一个新的 JLabel，并将其添加到 JP4
		JLabel DD = new JLabel("第4號桌");
		DD.setAlignmentX(Component.CENTER_ALIGNMENT);
		DD.setBorder(new LineBorder(new Color(192, 192, 192)));
		DD.setFont(new Font("微軟正黑體", Font.BOLD, 20));	
		DD.setForeground(Color.black);
		DD.setHorizontalAlignment(SwingConstants.CENTER);		
		JP4.add(DD);		

		// 创建一个新的 DefaultTableModel，并添加列
		def_ta4 = new DefaultTableModel();
		def_ta4.addColumn("菜名");
		def_ta4.addColumn("數量");        

		// 创建一个新的 JTable，并设置其模型
		D2 = new JTable();
		D2.setModel(def_ta4);

		// 获取表格的列模型，并设置首列的宽度
		TableColumnModel columnModel4 = D2.getColumnModel();
		columnModel4.getColumn(0).setPreferredWidth(230);

		// 设置行高、网格颜色和字体
		D2.setRowHeight(32);
		D2.setGridColor(Color.black);		
		D2.setFont(new Font("微軟正黑體", Font.BOLD, 18)); 

		// 设置表头字体
		Font headerFont4 = new Font("微软雅黑", Font.BOLD, 20);
		D2.getTableHeader().setFont(headerFont4);

		// 设置表头对齐方式
		DefaultTableCellRenderer headerRenderer4 = (DefaultTableCellRenderer) D2.getTableHeader().getDefaultRenderer();
		headerRenderer4.setHorizontalAlignment(SwingConstants.CENTER);    

		// 创建一个新的 JScrollPane，并将其添加到 JP4
		JScrollPane D1 = new JScrollPane(D2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		D1.getViewport().setBackground(Color.WHITE);

		// 设置 panel_53 的布局
		panel_53.setLayout(new BorderLayout(0, 0));

		// 将 JScrollPane 添加到 JP4
		JP4.add(D1);   

		
		
//		CardLayout各桌明細頁面切換按鈕監聽
        panel_53.add(panel01);
		panel_3.add(panel_53, "2");
		btnNewButton_1.addActionListener(new ActionListener() {  
	        public void actionPerformed(ActionEvent e) {       
	        	
	        	crd.show(panel_3,"2");
	        	frame.setTitle("各桌明細");
	        	
	        }});
		}
		public void actionPerformed(ActionEvent e) {
	        };
			
	}
