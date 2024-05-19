import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;


public class LoginPage {

	String user_username, user_password;
	static int invalidCount = 0,position = 100; 
	int fileNo, fileIs;

    public LoginPage(){

        JFrame frame = new JFrame();
        ImageIcon img = new ImageIcon("Images\\logo1.png");
        frame.setIconImage(img.getImage());
        frame.setBounds(0, 0, 1000, 600);
		frame.setLocationRelativeTo(null);
		frame.setTitle("FreshCart : Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Container creation
		Container p1 = new Container();
		p1 = frame.getContentPane();
		p1.setLayout(null);

		// TextField Creation
		JTextField tf = new JTextField();
		new TextPrompt("Username", tf);
        tf.setBounds(360, 225, 300, 30);
        tf.setFont(new Font("Times New Roman", Font.BOLD, 14));
		tf.setForeground(Color.DARK_GRAY);
		tf.setOpaque(false);
		tf.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		p1.add(tf);
		
		JPasswordField pf = new JPasswordField();
		new TextPrompt("Password", pf);
        pf.setBounds(360, 300, 300, 30);
        pf.setFont(new Font("Times New Roman", Font.BOLD, 14));
		pf.setForeground(Color.DARK_GRAY);
		pf.setOpaque(false);
		pf.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		p1.add(pf);

        // Button Creation
        JButton b2= new JButton("Forgot Password?");
		b2.setBounds(312,340,150,18);;
		b2.setContentAreaFilled(false);
		b2.setBorderPainted(false);
		b2.setFont(new Font("Aptos", Font.BOLD, 12));
		b2.setForeground(new Color(0,76,153));
		b2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		p1.add(b2);

		JButton b3 = new JButton();//login button
        b3.setBounds(352, 375, 320, 33);
        b3.setFont(new Font("Bell MT", Font.BOLD, 15));
		b3.setBorderPainted(false);
		b3.setContentAreaFilled(false);
		b3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        p1.add(b3);
		
		JButton b5 = new JButton();//exit button
        b5.setBounds(210, 500, 35, 25);
		b5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		b5.setContentAreaFilled(false);
		b5.setBorderPainted(false);
        p1.add(b5);

		JButton b4 = new JButton();//signup button
        b4.setBounds(352, 450, 320, 33);
		b4.setContentAreaFilled(false);
		b4.setBorderPainted(false);
		b4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        p1.add(b4);

		// Hide Button 
		JButton hide = new JButton(new ImageIcon("Images\\hide.png"));
		hide.setBounds(650,308,30,20);
		hide.setForeground(Color.GRAY);
		hide.setVisible(true);
		hide.setCursor(new Cursor(Cursor.HAND_CURSOR));
		hide.setContentAreaFilled(false);
		hide.setFocusPainted(false);
		hide.setBorderPainted(false);
		p1.add(hide);
	
		//Unhide Icon 
		JButton unhide = new JButton(new ImageIcon("Images\\Unhide.png"));
		unhide.setBounds(650,308,30,20);
		unhide.setForeground(Color.GRAY);
		unhide.setVisible(false);
		unhide.setCursor(new Cursor(Cursor.HAND_CURSOR));
		unhide.setContentAreaFilled(false);
		unhide.setFocusPainted(false);
		unhide.setBorderPainted(false);
		p1.add(unhide);
	
		hide.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
			  pf.setEchoChar((char) 0);
			  hide.setVisible(false);
			  unhide.setVisible(true);
			  pf.requestFocusInWindow();			
			} 
		  });
	  
	  
		  unhide.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
			  pf.setEchoChar('*');  //display password
			  unhide.setVisible(false);
			  hide.setVisible(true);
			  pf.requestFocusInWindow();
			} 
		  });


		
		//Set Background Image		
        ImageIcon Newpass_Background = new ImageIcon("Images\\loginPage.png");
    	JLabel bg_label = new JLabel(Newpass_Background);
        bg_label.setBounds(0,0,1000,600);
        p1.add(bg_label);
		


		//ActionListener for Forgot Password Button
	 	b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				frame.setVisible(false);
				try{
				new OTP();
				}catch(Exception fd)
				{
					System.out.println("Login Panel user gui call problem");
				}
			} 
		});
		


		b2.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
			frame.setVisible(false);
			new OTP();
        }});
			
	//signup button
		b4.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
			frame.setVisible(false);
			new AccountCreate();
        }});

	//exit button
	 	b5.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
			frame.setVisible(false);
			new LoginPage();
			System.exit(0);
        }});
		
		
	//ActionListener for Login Button

	b3.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			//////////////////////////////////////////////////////////////Reading User File NO/////////////////////////////////////////////////////
			String filenumber="";
			try{
				File otp_File = new File("TXT FILES\\User_File_No.txt");		
				Scanner scanFile = new Scanner(otp_File);//Scan File
							
				while(scanFile.hasNext()){
					filenumber=scanFile.next();
					break;
				}
				scanFile.close();
						
				fileNo= Integer.parseInt(filenumber);
				fileNo=fileNo-1;
							
			}catch(Exception f)		{System.out.println("User file no reading problem in login panel");}


			String user=tf.getText();
			String pass=new String(pf.getPassword());
			boolean user_access=false;




			//Get User Information
				
			for(int i=1; i<=fileNo; i++)
			{
				String User_Information_File_Path="TXT FILES\\User Information\\User--"+i+".txt";
					
				try{
					File user_file = new File(User_Information_File_Path);		
					Scanner scanFile = new Scanner(user_file);//Scan File
					
					while(scanFile.hasNext()){
						user_username=scanFile.next();
						user_password=scanFile.next();
						break;
					}
					scanFile.close();
						
						
					if((user.equals(user_username)) && (pass.equals(user_password)))
					{
						fileIs=i;
						break;
					}
				}catch(Exception f)		{System.out.println("User File Problem in Login Panel");}
			}
				
			if((user.equals(user_username)) && (pass.equals(user_password)))
			{
				user_access=true;
			}
			else{
				user_access=false;
			}



//Get login in account
			if(user_access){
					
				//Writting the user file no to running user file
				try{
					Formatter formatter=new Formatter("TXT FILES\\Running_User_File_NO.txt");
					
					formatter.format("%s", ""+fileIs);
					formatter.close();	
					
				}catch(Exception f)		{System.out.println("writting running user file no problem");}
				
				//writting done
				frame.setVisible(false);
				new WelcomePage();
			}
			else{
				invalidCount++;
				
				if(invalidCount>5){
					JOptionPane.showMessageDialog(null,"Wrong attempt !! You Have Entered wrong Information more than 5 times.","WARNING",JOptionPane.WARNING_MESSAGE);
					System.exit(0);
				}
				JOptionPane.showMessageDialog(null, "Enter Valid Username or Password","Login Confirmation",JOptionPane.WARNING_MESSAGE);
			}
	}});

	

//Set Frame as Visible
frame.setVisible(true);
frame.setResizable(false);
EventQueue.invokeLater( () -> tf.requestFocusInWindow() );

    }
}