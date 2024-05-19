import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class ChocolateItem{
	
	public ChocolateItem(){
		
		JFrame frame = new JFrame();
        ImageIcon img = new ImageIcon("Images\\logo1.png");
        frame.setIconImage(img.getImage());
        frame.setBounds(0, 0, 1000, 610);
		frame.setTitle("Organic Products");
		frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/////////// Container creation /////////////

		Container panel = new Container();
		panel=frame.getContentPane();
		panel.setLayout(null); 
		
        JButton b1 = new JButton("View Details");
        b1.setBounds(350, 245, 150, 15);
        b1.setFont(new Font("Times New Roman",Font.BOLD,13));
        b1.setForeground(Color.BLACK);
        b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		b1.setContentAreaFilled(false);
		b1.setBorderPainted(false);
        b1.setFocusPainted(false);
        panel.add(b1);



        JButton b2 = new JButton("View Details");
        b2.setBounds(510, 245, 150, 15);
        b2.setFont(new Font("Times New Roman",Font.BOLD,13));
        b2.setForeground(Color.BLACK);
        b2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		    b2.setContentAreaFilled(false);
		    b2.setBorderPainted(false);
        b2.setFocusPainted(false);
        panel.add(b2);


		JButton b3 = new JButton("View Details");
		b3.setBounds(350, 445, 150, 15);
		b3.setFont(new Font("Times New Roman",Font.BOLD,13));
		b3.setForeground(Color.BLACK);
		b3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			b3.setContentAreaFilled(false);
			b3.setBorderPainted(false);
		b3.setFocusPainted(false);
		panel.add(b3);


		JButton b4 = new JButton("View Details");
		b4.setBounds(505, 435, 150, 15);
		b4.setFont(new Font("Times New Roman",Font.BOLD,13));
		b4.setForeground(Color.BLACK);
		b4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		b4.setContentAreaFilled(false);
		b4.setBorderPainted(false);
		b4.setFocusPainted(false);
		panel.add(b4);


        JButton b6 = new JButton();//back button
        b6.setBounds(20, 20, 35, 25);
        b6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    	b6.setContentAreaFilled(false);
	    	b6.setBorderPainted(false);
        b6.setFocusPainted(false);
        panel.add(b6);
		

		//Action Listeners
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
			  try{
				Formatter formatter=new Formatter("TXT FILES\\Running_Product.txt");
				
				
				formatter.format("%s", "5");
				formatter.close();  
				  
			  }catch(Exception f)    {System.out.println("Problem in runnung product");}
			  
			  frame.setVisible(false);
			  new View_details();
			}
		  });
	



		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
			  try{
				Formatter formatter=new Formatter("TXT FILES\\Running_Product.txt");
				
				
				formatter.format("%s", "6");
				formatter.close();  
				  
			  }catch(Exception f)    {System.out.println("Problem in runnung product");}
			  
			  frame.setVisible(false);
			  new View_details();
			}
		  });
		


		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
			  try{
				Formatter formatter=new Formatter("TXT FILES\\Running_Product.txt");
				
				
				formatter.format("%s", "7");
				formatter.close();  
				  
			  }catch(Exception f)    {System.out.println("Problem in runnung product");}
			  
			  frame.setVisible(false);
			  new View_details();
			}
		  });



		b4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
			  try{
				Formatter formatter=new Formatter("TXT FILES\\Running_Product.txt");
				
				
				formatter.format("%s", "8");
				formatter.close();  
				  
			  }catch(Exception f)    {System.out.println("Problem in runnung product");}
			  
			  frame.setVisible(false);
			  new View_details();
			}
		  });


		
		ImageIcon Newpass_Background = new ImageIcon("Images\\organic.png");
    	JLabel bg_label = new JLabel(Newpass_Background);
        bg_label.setBounds(0,0,1000,610);
        panel.add(bg_label);

      
		
		b1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				// b1.setBackground(Vivid_Blue);
				b1.setForeground(Color.CYAN);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				// b1.setBackground(Aqua);
				b1.setForeground(Color.RED);
			}
		});
		
		b2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				// b2.setBackground(Vivid_Blue);
				b2.setForeground(Color.CYAN);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				// b2.setBackground(Aqua);
				b2.setForeground(Color.RED);
			}
		});
		
		b3.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				// b3.setBackground(Vivid_Blue);
				b3.setForeground(Color.CYAN);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				// b3.setBackground(Aqua);
				b3.setForeground(Color.RED);
			}
		});
		
		b4.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				// b4.setBackground(Vivid_Blue);
				b4.setForeground(Color.CYAN);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				// b4.setBackground(Aqua);
				b4.setForeground(Color.RED);
			}
		});

		
		b6.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
			frame.setVisible(false);
			new WelcomePage();
        }});

		frame.setVisible(true);
        frame.setResizable(false);
    }
	
}