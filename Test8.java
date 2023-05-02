import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.*;  


public class Test8 extends JFrame{ 	
    JLabel
    A1,A2,A3,A4,A5,A6,A7,A8,A9,
    B1,B2,B3,B4,B5,B6,B7,B8,B9,
    C1,C2,C3,C4,C5,C6,C7,C8,C9,
    D1,D2,D3,D4,D5,D6,D7,D8,D9;
    JLabel[] Aa = {A1,A2,A3,A4,A5,A6,A7,A8,A9};	
	JLabel[] Ba = {B1,B2,B3,B4,B5,B6,B7,B8,B9};
	JLabel[] Ca = {C1,C2,C3,C4,C5,C6,C7,C8,C9};
	JLabel[] Da = {D1,D2,D3,D4,D5,D6,D7,D8,D9};
    JPanel panel,
    JP1,JP2,JP3,JP4; 
    String[] pattern,child,eggcake,drinks;
    Test8(){
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
		
			
		int j=0;
		for (int i=0;i<9;i++) {
			Aa[i] = new JLabel();
			Aa[i].setBorder(new LineBorder(new Color(192, 192, 192)));
			Aa[i].setBounds(0, j, 138, 38);
			j +=37;
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

		int ja = 0;
		for (int i=0;i<9;i++) {
			Ba[i] = new JLabel();
			Ba[i].setBorder(new LineBorder(new Color(192, 192, 192)));
			Ba[i].setBounds(0, ja, 138, 38);
			ja +=37;
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

		int jb = 0;
		for (int i=0;i<9;i++) {
			Ca[i] = new JLabel();
			Ca[i].setBorder(new LineBorder(new Color(192, 192, 192)));
			Ca[i].setBounds(0, jb, 138, 38);
			jb +=37;
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

		int jd = 0;
		for (int i=0;i<9;i++) {
			Da[i] = new JLabel();
			Da[i].setBorder(new LineBorder(new Color(192, 192, 192)));
			Da[i].setBounds(0, jd, 138, 38);
			jd +=37;
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
	Test8 ad =new Test8();
	System.out.println(ad.Aa[0].getText());
	System.out.println(ad.Ba[0].getText());
	System.out.println(ad.Ca[0].getText());
	System.out.println(ad.Da[0].getText());
//    new Test8();
}  
}  
