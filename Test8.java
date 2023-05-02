package project;


import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.*;  


public class First extends JFrame{ 	
    JLabel
    AA,A1,A2,A3,A4,A5,A6,A7,A8,A9,
    BB,B1,B2,B3,B4,B5,B6,B7,B8,B9,
    CC,C1,C2,C3,C4,C5,C6,C7,C8,C9,
    DD,D1,D2,D3,D4,D5,D6,D7,D8,D9;
    JLabel[] Aa = {A1,A2,A3,A4,A5,A6,A7,A8,A9};	
	JLabel[] Ba = {B1,B2,B3,B4,B5,B6,B7,B8,B9};
	JLabel[] Ca = {C1,C2,C3,C4,C5,C6,C7,C8,C9};
	JLabel[] Da = {D1,D2,D3,D4,D5,D6,D7,D8,D9};
    JPanel panel,
    JP1,JP2,JP3,JP4; 
    String[] pattern,child,eggcake,drinks;   
    First(){
		setBounds(100, 100, 570, 383);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 554, 344);
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		getContentPane().add(panel);
		panel.setLayout(null);
	
		JP1 = new JPanel();
		JP1.setBounds(0, 0, 138, 334);
		panel.add(JP1);
		JP1.setLayout(null);
		
		String[] pattern= new String[]{"歐姆蛋拼盤","焦糖奶油法國吐司","厚切義大利麵", "炸物拼盤","明星組合"};
		String[] child=   new String[]{"兒童餐","週一59元特餐", "週二59元特餐","週三59元特餐"};		
		String[] eggcake= new String[]{"手工蛋餅系列(鹹)","芋泥蛋餅系列(甜)","地瓜蜂蜜蛋餅(甜)"};
		String[] drinks=  new String[]{"紅茶","奶茶","鮮奶茶","豆漿紅茶","無糖冷泡茶","柚子釀蜜茶","桂花釀蜜茶"};
		
		JLabel AA = new JLabel("第1号桌");
		AA.setBorder(new LineBorder(new Color(192, 192, 192)));
		AA.setBounds(0, 0, 138, 38);			
		AA.setFont(new Font("楷体",Font.PLAIN,16));	
		AA.setForeground(Color.black);
		AA.setHorizontalAlignment(SwingConstants.CENTER);		
		JP1.add(AA);
		

		
		
		int j=0;
		for (int i=0;i<9;i++) {
			Aa[i] = new JLabel();
			Aa[i].setBorder(new LineBorder(new Color(192, 192, 192)));			
			j +=37;
			Aa[i].setBounds(0, j, 138, 38);
			JP1.add(Aa[i]);	
		}	
		
		if(Aa[0].getText()=="") {
	    for (int i=0;i<pattern.length;i++) {
	        Aa[i].setText(pattern[i]);
			Font f = new Font("楷体",Font.PLAIN,16);			
			Aa[i].setFont(f);	
			Aa[i].setForeground(Color.blue);
			Aa[i].setHorizontalAlignment(SwingConstants.CENTER);
			
	    }
	    
		}		
		JP2 = new JPanel();
		JP2.setBounds(138, 0, 138, 334);
		panel.add(JP2);
		JP2.setLayout(null);
		
		JLabel BB = new JLabel("第2号桌");
		BB.setBorder(new LineBorder(new Color(192, 192, 192)));
		BB.setBounds(0, 0, 138, 38);			
		BB.setFont(new Font("楷体",Font.PLAIN,16));	
		BB.setForeground(Color.black);
		BB.setHorizontalAlignment(SwingConstants.CENTER);		
		JP2.add(BB);
		

		int ja = 0;
		for (int i=0;i<9;i++) {
			Ba[i] = new JLabel();
			Ba[i].setBorder(new LineBorder(new Color(192, 192, 192)));
			ja +=37;
			Ba[i].setBounds(0, ja, 138, 38);
			JP2.add(Ba[i]);					
		}
		
		if(Ba[0].getText()=="") {
		    for (int i=0;i<child.length;i++) {
				Ba[i].setText(child[i]);
				Font fa = new Font("楷体",Font.PLAIN,16);			
				Ba[i].setFont(fa);	
				Ba[i].setForeground(Color.blue);
				Ba[i].setHorizontalAlignment(SwingConstants.CENTER);
		    }
		}
		
		JP3 = new JPanel();
		JP3.setBounds(276, 0, 138, 334);
		panel.add(JP3);
		JP3.setLayout(null);
		
		JLabel CC = new JLabel("第3号桌");
		CC.setBorder(new LineBorder(new Color(192, 192, 192)));
		CC.setBounds(0, 0, 138, 38);			
		CC.setFont(new Font("楷体",Font.PLAIN,16));	
		CC.setForeground(Color.black);
		CC.setHorizontalAlignment(SwingConstants.CENTER);		
		JP3.add(CC);

		int jb = 0;
		for (int i=0;i<9;i++) {
			Ca[i] = new JLabel();
			Ca[i].setBorder(new LineBorder(new Color(192, 192, 192)));
			jb +=37;
			Ca[i].setBounds(0, jb, 138, 38);
			JP3.add(Ca[i]);		
		}
		if(Ca[0].getText()=="") {
		    for (int i=0;i<eggcake.length;i++) {
				Ca[i].setText(eggcake[i]);
				Font fb = new Font("楷体",Font.PLAIN,16);			
				Ca[i].setFont(fb);	
				Ca[i].setForeground(Color.blue);
				Ca[i].setHorizontalAlignment(SwingConstants.CENTER);
		    }
		}
		
		JP4 = new JPanel();
		JP4.setBounds(414, 0, 138, 334);
		panel.add(JP4);
		JP4.setLayout(null);
		
		JLabel DD = new JLabel("第4号桌");
		DD.setBorder(new LineBorder(new Color(192, 192, 192)));
		DD.setBounds(0, 0, 138, 38);			
		DD.setFont(new Font("楷体",Font.PLAIN,16));	
		DD.setForeground(Color.black);
		DD.setHorizontalAlignment(SwingConstants.CENTER);		
		JP4.add(DD);

		int jd = 0;
		for (int i=0;i<9;i++) {
			Da[i] = new JLabel();
			Da[i].setBorder(new LineBorder(new Color(192, 192, 192)));
			jd +=37;
			Da[i].setBounds(0, jd, 138, 38);
			JP4.add(Da[i]);					
		}
		if(Da[0].getText()=="") {
		    for (int i=0;i<drinks.length;i++) {
			Da[i].setText(drinks[i]);
			Font fd = new Font("楷体",Font.PLAIN,16);			
			Da[i].setFont(fd);	
			Da[i].setForeground(Color.blue);
			Da[i].setHorizontalAlignment(SwingConstants.CENTER);	
		    }
		}
        setSize(570,355);  
        setLayout(null);  
        setVisible(true);  
        setDefaultCloseOperation(EXIT_ON_CLOSE);  
    }  
	
    public void actionPerformed(ActionEvent e){
    	
}    
 
public static void main(String[] args) { 
	First ad =new First();
	System.out.println(ad.Aa[0].getText());
	System.out.println(ad.Ba[0].getText());
	System.out.println(ad.Ca[0].getText());
	System.out.println(ad.Da[0].getText());
//    new First();
}  
}  
