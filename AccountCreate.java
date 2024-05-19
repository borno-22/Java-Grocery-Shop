import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class AccountCreate {

	int fileNo=1;

    public AccountCreate(){

        JFrame f1 = new JFrame();
        ImageIcon img = new ImageIcon("Images\\logo1.png");
        f1.setIconImage(img.getImage());
        f1.setBounds(0, 0, 1000, 600);
		f1.setLocationRelativeTo(null);
		f1.setTitle("ACCOUNT CREATE");
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // Container creation
		Container p1 = new Container();
		p1=f1.getContentPane();
		p1.setLayout(null);

        // JTextField Create

        // First Name 

        JTextField tf = new JTextField();
        tf.setBounds(618, 147, 162, 30);
        tf.setBackground(Color.WHITE);
        tf.setFont(new Font("Aptos", Font.PLAIN, 13));
        tf.setForeground(Color.DARK_GRAY);
        tf.setOpaque(false);
		tf.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        new TextPrompt("First Name", tf);
        p1.add(tf); 

        // Last Name 

        JTextField tf1 = new JTextField();
        tf1.setBounds(825, 147, 120, 30);
        tf1.setBackground(Color.WHITE);
        tf1.setFont(new Font("Aptos", Font.PLAIN, 13));
        tf1.setForeground(Color.DARK_GRAY);
		tf1.setOpaque(false);
		tf1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        new TextPrompt("Last Name", tf1);
        p1.add(tf1); 

       
       
        // For E-Mail Set 

        JTextField tf2 = new JTextField();
        tf2.setBounds(620, 205, 300, 30);
        tf2.setBackground(Color.WHITE);
        tf2.setFont(new Font("Aptos", Font.PLAIN, 13));
        tf2.setForeground(Color.DARK_GRAY);
		tf2.setOpaque(false);
		tf2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        new TextPrompt("example@email.com", tf2);
        p1.add(tf2);

        // For Mobile Number Set

        JTextField tf3 = new JTextField();
        tf3.setBounds(620, 265, 300, 30);
        tf3.setBackground(Color.WHITE);
        tf3.setFont(new Font("Aptos", Font.PLAIN, 13));
        tf3.setForeground(Color.DARK_GRAY);
		tf3.setOpaque(false);
		tf3.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        new TextPrompt(("017********"), tf3);
        p1.add(tf3);


        // For Birth date Set

        JTextField tf6 = new JTextField();
        tf6.setBounds(620, 325, 200, 30);
        tf6.setBackground(Color.WHITE);
        tf6.setFont(new Font("Aptos", Font.PLAIN, 13));
        tf6.setForeground(Color.DARK_GRAY);
		tf6.setOpaque(false);
		tf6.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        new TextPrompt(("DD/MM/YYYY"), tf6);
        p1.add(tf6);
    

        // Radio-Button Set

        JRadioButton r1 = new JRadioButton("Male");
        r1.setBounds(790,330, 70, 20);
        r1.setForeground(Color.DARK_GRAY);
		r1.setSelected(true);
		r1.setFocusPainted(false);
        r1.setFont(new Font("Aptos", Font.PLAIN, 13));
		r1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        r1.setContentAreaFilled(false);
		r1.setBorderPainted(false);
        p1.add(r1);
		
		JRadioButton r2 = new JRadioButton("Female");
        r2.setBounds(877, 330, 70, 20);
        r2.setForeground(Color.DARK_GRAY);
		r2.setFocusPainted(false);
        r2.setFont(new Font("Aptos", Font.PLAIN, 13));
		r2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        r2.setContentAreaFilled(false);
		r2.setBorderPainted(false);
        p1.add(r2);

		ButtonGroup gender_grp = new ButtonGroup();
		gender_grp.add(r1);
		gender_grp.add(r2);


		//username set
        JTextField tf4 = new JTextField();
        tf4.setBounds(620, 385, 180, 30);
        tf4.setFont(new Font("Aptos", Font.PLAIN, 13));
        tf4.setForeground(Color.DARK_GRAY);
		tf4.setOpaque(false);
		tf4.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        new TextPrompt(("Username(a-z)"), tf4);
        p1.add(tf4);

		//password set
        JTextField tf5 = new JTextField();
        tf5.setBounds(620, 443, 180, 30);
        tf5.setFont(new Font("Aptos", Font.PLAIN, 13));
        tf5.setForeground(Color.DARK_GRAY);
		tf5.setOpaque(false);
		tf5.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        new TextPrompt(("Password"), tf5);
        p1.add(tf5);

        // Button Set

        JButton b1 = new JButton();//sign up button
        b1.setBounds(610, 490, 330, 35);
		b1.setContentAreaFilled(false);
		b1.setBorderPainted(false);
		b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        p1.add(b1);

		JButton b2 = new JButton();//login button
        b2.setBounds(843, 530, 50, 25);
		b2.setContentAreaFilled(false);
		b2.setBorderPainted(false);
		b2.setFocusPainted(false);
		b2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        p1.add(b2);



		// Set BackGround
		ImageIcon signBack = new ImageIcon("Images\\signBack.png");
		JLabel bg_label = new JLabel(signBack);
		bg_label.setBounds(0,0,1000,600);
		p1.add(bg_label);

        
   	 // Back to Login Button ActionListener 

		 b2.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
			f1.setVisible(false);
			new LoginPage();
        }});



// Confirm Button ActionListener
        b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent u){
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
						
				}catch(Exception f)		{System.out.println("User_File_No problem in account creation");}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				String username,password,email,phone,birth,name,gender;
									
			//Getting User Information
				username = tf4.getText();
				password = tf5.getText();
				email = tf2.getText();
				phone = tf3.getText();
				birth = tf6.getText();
				name = tf.getText()+" "+tf1.getText();
				if(r1.isSelected()){gender="Male";}
				else{gender="Female";}
				
				int Username_Warning=5;
				int Username_Exist_Warning=5;
				int Phone_Warning=5;
				
				//Check Username ok or not
				for(int i=0; i<username.length(); i++)
				{
					if( (username.charAt(i)<97) || (username.charAt(i)>122) ){
						Username_Warning=1;
						break;
					}
				}
				
				//Check Phone Number ok or not
				for(int i=0; i<phone.length(); i++)
				{
					if( (phone.charAt(i)<48) || (phone.charAt(i)>57) ){
						Phone_Warning=1;
						break;
					}
				}


				//Check Username Exist or not			
				String username_exist="";
				for(int i=1; i<=(fileNo-1); i++)
				{
					String User_Information_File_Path="TXT FILES\\User Information\\User--"+i+".txt";
					
					try{
						File user_file = new File(User_Information_File_Path);		
						Scanner scanFile = new Scanner(user_file);//Scan File
						
						while(scanFile.hasNext()){
							username_exist=scanFile.next();
							break;
						}
						scanFile.close();
						
						
						if((username.equals(username_exist)))
						{
							Username_Exist_Warning+=1;
							break;
						}
					}catch(Exception f)		{System.out.println("User File Problem in Sigup Panel");}
				}









				if( (tf.getText().isEmpty()) || (username.isEmpty()) || (password.isEmpty()) || (email.isEmpty()) || (phone.isEmpty()) || (tf1.getText().isEmpty()) || (birth.isEmpty()) )
				{
					if( tf.getText().isEmpty() )
					{
						JOptionPane.showMessageDialog(null, "First Name can not be empty","Empty Warning",JOptionPane.WARNING_MESSAGE);
					}
					else if( tf1.getText().isEmpty() )
					{
						JOptionPane.showMessageDialog(null, "Last Name can not be empty","Empty Warning",JOptionPane.WARNING_MESSAGE);
					}
					else if( email.isEmpty() )
					{
						JOptionPane.showMessageDialog(null, "Email can not be empty","Empty Warning",JOptionPane.WARNING_MESSAGE);
					}
					else if( phone.isEmpty() )
					{
					JOptionPane.showMessageDialog(null, "Email can not be empty","Empty Warning",JOptionPane.WARNING_MESSAGE);
					}
					else if( birth.isEmpty() )					
					{
						JOptionPane.showMessageDialog(null, "Date of Birth can not be empty","Empty Warning",JOptionPane.WARNING_MESSAGE);
					}
					else if( username.isEmpty() )
					{
						JOptionPane.showMessageDialog(null, "Username can not be empty","Empty Warning",JOptionPane.WARNING_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Password can not be empty","Empty Warning",JOptionPane.WARNING_MESSAGE);
					}
				}
				else if(Email_Decision(email))
				{
					JOptionPane.showMessageDialog(null, "Enter a valid Email Address","Email Warning",JOptionPane.WARNING_MESSAGE);
				}
				else if( (phone.length()<11) || (phone.length()>11) || Phone_Warning!=5)
				{
					JOptionPane.showMessageDialog(null, "Enter a valid Phone Number","Phone Number Warning",JOptionPane.WARNING_MESSAGE);
				}
				else if( (birth.length()<10) || (birth.length()>10) || Phone_Warning!=5)
				{
					JOptionPane.showMessageDialog(null, "Enter a valid Date of Birth","Date of Birth Warning",JOptionPane.WARNING_MESSAGE);
				}
				else if(Username_Warning!=5)
				{
					JOptionPane.showMessageDialog(null, "Username contains small Alphabets only","Username Warning",JOptionPane.WARNING_MESSAGE);
				}
				else if(Username_Exist_Warning!=5)
				{
					JOptionPane.showMessageDialog(null, "Username already exist. Try different One","Username Warning",JOptionPane.WARNING_MESSAGE);
				}
				else if( (password.length()<6) || (password.length()>10) )
				{
					JOptionPane.showMessageDialog(null, "Password must be 6 to 10 character","Password Warning",JOptionPane.WARNING_MESSAGE);
				}
///////////////////////////////////////////////////////////User Information Written/////////////////////////////////////////////////////////////////////////////////////////
				else{
					try{
						String User_Information_File_Path="TXT FILES\\User Information\\User--"+fileNo+".txt";
						Formatter formatter=new Formatter(User_Information_File_Path);
						fileNo++;
						
						formatter.format("%s\r\n", username);
						formatter.format("%s\r\n", password);
						formatter.format("%s\r\n", email);
						formatter.format("%s\r\n", phone);
						formatter.format("%s\r\n", birth);
						formatter.format("%s\r\n", gender);
						formatter.format("%s\r\n", name);
						
						
						
						formatter.close();	
					}catch(Exception f)		{System.out.println("Writting user info problem in account creation");}
					
/////////////////////////////////////////////////////////////////////Writting Next User File Number////////////////////////////////////////////////////////////////////////
					try{
						Formatter formatter=new Formatter("TXT FILES\\User_File_No.txt");
							
							
						formatter.format("%s", ""+fileNo);
						formatter.close();	
							
					}catch(Exception f)		{System.out.println("User file no writting problem in accounnt creation");}
					
					JOptionPane.showMessageDialog(null,tf.getText()+", Welcome to FreshCart ","Account Created Successfully",-1,new ImageIcon("Images\\tick.png"));
					
					f1.setVisible(false);
					new LoginPage();
				}
		}});



        // Frame Visibility 
        
        f1.setVisible(true);
        f1.setResizable(false);

    }

    private boolean Email_Decision(String email){
		
		String word=email;
		int countAt=0,countDot=0;
		
		
		
		for(int i=0; i<word.length();i++)
		{
			if(word.charAt(i)=='@')
			{
				countAt++;
			}if(countAt==1 && word.charAt(i)=='.')
			{
				countDot++;
			}
			
		}
		
		if(countAt==1 && countDot==1){
			return false;
		}
		else{
			return true;
		}
		
	}
}
