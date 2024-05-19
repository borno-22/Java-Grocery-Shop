import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class drinksItem {

    public drinksItem(){

        JFrame frame = new JFrame();
        ImageIcon img = new ImageIcon("Images\\brand.png");
        frame.setIconImage(img.getImage());
        frame.setBounds(250, 110, 1000, 600);
		frame.setTitle("DRINKS ITEM");
		frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /////////// Container creation /////////////

		Container panel = new Container();
		panel=frame.getContentPane();
		panel.setLayout(null); 


        JButton b1 = new JButton("View Details");
        b1.setBounds(430, 240, 100, 20);
        b1.setFont(new Font("Times New Roman",Font.BOLD,10));
        b1.setForeground(Color.RED);
        b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		b1.setContentAreaFilled(false);
		b1.setBorderPainted(false);
		b1.setFocusPainted(false);
        panel.add(b1);

		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
			  try{
				Formatter formatter=new Formatter("TXT FILES\\Running_Product.txt");
				
				
				formatter.format("%s", "10");
				formatter.close();  
				  
			  }catch(Exception f)    {System.out.println("Problem in runnung product of CocaCola Drinks");}
			  
			  frame.setVisible(false);
			  new View_details();
			}
		  });


      

        JButton b2 = new JButton("View Details");
        b2.setBounds(633, 240, 100, 20);
        b2.setFont(new Font("Times New Roman",Font.BOLD,10));
        b2.setForeground(Color.RED);
        b2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		b2.setContentAreaFilled(false);
		b2.setBorderPainted(false);
		b2.setFocusPainted(false);
        panel.add(b2);

		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
			  try{
				Formatter formatter=new Formatter("TXT FILES\\Running_Product.txt");
				
				
				formatter.format("%s", "11");
				formatter.close();  
				  
			  }catch(Exception f)    {System.out.println("Problem in runnung product of Pepsi Drinks");}
			  
			  frame.setVisible(false);
			  new View_details();
			}
		  });


        
        JButton b3 = new JButton("View Details");
        b3.setBounds(820, 240, 100, 20);
        b3.setFont(new Font("Times New Roman",Font.BOLD,10));
        b3.setBackground(Color.YELLOW);
        b3.setForeground(Color.RED);
        b3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		b3.setContentAreaFilled(false);
		b3.setBorderPainted(false);
		b3.setFocusPainted(false);
        panel.add(b3);


		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
			  try{
				Formatter formatter=new Formatter("TXT FILES\\Running_Product.txt");
				
				
				formatter.format("%s", "12");
				formatter.close();  
				  
			  }catch(Exception f)    {System.out.println("Problem in runnung product of 7Up Drinks");}
			  
			  frame.setVisible(false);
			  new View_details();
			}
		  });


        JButton b4 = new JButton("View Details");
        b4.setBounds(430, 410, 100, 20);
        b4.setFont(new Font("Times New Roman",Font.BOLD,10));
        b4.setForeground(Color.RED);
        b4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		b4.setContentAreaFilled(false);
		b4.setBorderPainted(false);
		b4.setFocusPainted(false);
        panel.add(b4);


		b4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
			  try{
				Formatter formatter=new Formatter("TXT FILES\\Running_Product.txt");
				
				
				formatter.format("%s", "13");
				formatter.close();  
				  
			  }catch(Exception f)    {System.out.println("Problem in runnung product of Sprite Drinks");}
			  
			  frame.setVisible(false);
			  new View_details();
			}
		  });

        JButton b5 = new JButton("View Details");
        b5.setBounds(630, 410, 100, 20);
        b5.setFont(new Font("Times New Roman",Font.BOLD,10));
        b5.setForeground(Color.RED);
        b5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		b5.setContentAreaFilled(false);
		b5.setBorderPainted(false);
		b5.setFocusPainted(false);
        panel.add(b5);


		b5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
			  try{
				Formatter formatter=new Formatter("TXT FILES\\Running_Product.txt");
				
				
				formatter.format("%s", "14");
				formatter.close();  
				  
			  }catch(Exception f)    {System.out.println("Problem in runnung product of Lemon Drinks");}
			  
			  frame.setVisible(false);
			  new View_details();
			}
		  });
		
		JButton b8 = new JButton("View Details");
        b8.setBounds(850, 410, 100, 20);
        b8.setFont(new Font("Times New Roman",Font.BOLD,10));
        b8.setForeground(Color.RED);
        b8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		b8.setContentAreaFilled(false);
		b8.setBorderPainted(false);
		b8.setFocusPainted(false);
        panel.add(b8);


		b8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
			  try{
				Formatter formatter=new Formatter("TXT FILES\\Running_Product.txt");
				
				
				formatter.format("%s", "15");
				formatter.close();  
				  
			  }catch(Exception f)    {System.out.println("Problem in runnung product of RedBull Drinks");}
			  
			  frame.setVisible(false);
			  new View_details();
			}
		  });


        JButton b6 = new JButton();
        b6.setBounds(870, 515, 40, 30);
        b6.setFont(new Font("Times New Roman",Font.BOLD,15));
        b6.setForeground(Color.CYAN);
        b6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b6.setContentAreaFilled(false);
		b6.setBorderPainted(false);
		b6.setFocusPainted(false);
        panel.add(b6);

        
        ImageIcon Newpass_Background = new ImageIcon("Images\\drinksItem.png");
    	JLabel bg_label = new JLabel(Newpass_Background);
        bg_label.setBounds(0,0,986,563);
        panel.add(bg_label);

        frame.setVisible(true);
        frame.setResizable(false);

		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
			  
			  int result = JOptionPane.showConfirmDialog (null,"Do you want to Exit?", "Exit Confirmation",JOptionPane.YES_NO_OPTION);
			  
			  if (result == JOptionPane.YES_OPTION){
				
				File folder = new File("C:\\Users\\user\\Desktop\\MyProject");
				File fList[] = folder.listFiles();
	
				for (File f : fList) {
				  if (f.getName().endsWith(".class")) {
					f.delete(); 
				  }
				}
				
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			  
			  }else{
				frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			  }
			}
		  }
		); 


        
		
		/* b7.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				// b7.setBackground(Vivid_Blue);
				b7.setForeground(Color.WHITE);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				// b7.setBackground(Aqua);
				b7.setForeground(Color.CYAN);
			}
		}); */ 

        b6.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
			frame.setVisible(false);
			new WelcomePage();
        }});
		
		
		b6.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				// b6.setBackground(Vivid_Blue);
				b6.setForeground(Color.WHITE);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				// b6.setBackground(Aqua);
				b6.setForeground(Color.CYAN);
			}
		});
		
		b1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				// b1.setBackground(Vivid_Blue);
				b1.setForeground(Color.BLACK);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				// b1.setBackground(Aqua);
				b1.setForeground(Color.RED);
			}
		});
		
		
		b2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				// b2.setBackground(Vivid_Blue);
				b2.setForeground(Color.BLACK);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				// b2.setBackground(Aqua);
				b2.setForeground(Color.RED);
			}
		});
		
		b3.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				// b3.setBackground(Vivid_Blue);
				b3.setForeground(Color.BLACK);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				// b3.setBackground(Aqua);
				b3.setForeground(Color.RED);
			}
		});
		
		b4.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				// b4.setBackground(Vivid_Blue);
				b4.setForeground(Color.BLACK);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				// b4.setBackground(Aqua);
				b4.setForeground(Color.RED);
			}
		});
		
		b5.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				// b5.setBackground(Vivid_Blue);
				b5.setForeground(Color.BLACK);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				// b5.setBackground(Aqua);
				b5.setForeground(Color.RED);
			}
		});
		
		b8.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				// b8.setBackground(Vivid_Blue);
				b8.setForeground(Color.BLACK);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				// b8.setBackground(Aqua);
				b8.setForeground(Color.RED);
			}
		});
    }
}
