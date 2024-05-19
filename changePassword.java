import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;


public class changePassword {

	String fileIs, otp;
    
	String user_username, user_password, user_email, user_phone, user_gender, user_name;
    public changePassword(){
        JFrame frame = new JFrame();
        ImageIcon img = new ImageIcon("Images\\logo1.png");
        frame.setIconImage(img.getImage());
        frame.setBounds(0, 0, 1000, 600);
		frame.setTitle("Change Password");
		frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //// Container creation
		Container p1 = new Container();
		p1 = frame.getContentPane();
		p1.setLayout(null);

        // Create TextField		
		JTextField tf = new JTextField();
        tf.setBounds(730, 280, 245, 40);
        tf.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		tf.setForeground(Color.BLACK);
		tf.setOpaque(false);
		tf.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		new TextPrompt("New Password", tf);
		p1.add(tf);


        // Create Button 		
		JButton b1 = new JButton("Change Password");
		b1.setBounds(765,332,200,30);;
		b1.setContentAreaFilled(false);
		b1.setBorderPainted(false);
        b1.setFont(new Font("Aptos", Font.BOLD, 14));
		b1.setForeground(Color.WHITE);
		b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		p1.add(b1);

		JButton b2 = new JButton();//back button
        b2.setBounds(20, 20, 35, 25);
		b2.setFont(new Font("Aptos", Font.BOLD, 12));
		b2.setContentAreaFilled(false);
		b2.setBorderPainted(false);
		b2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        p1.add(b2);


        ImageIcon Newpass_Background = new ImageIcon("Images\\otp2.jpg");
    	JLabel bg_label = new JLabel(Newpass_Background);
        bg_label.setBounds(0,0,1000,600);
        p1.add(bg_label); 

		

		//back Button Listener
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.setVisible(false);
				new OTP();
				
			}
		});


		//ActionListener for Change Password button
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a){
				String password = tf.getText();
				if( (password.length()<6) || (password.length()>10) )
				{
					JOptionPane.showMessageDialog(null, "Password must be 6 to 10 character","Password Warning",JOptionPane.WARNING_MESSAGE);
				}
				else{
					
			//Getting username from file, whice password will be change
					try{
						File admin_file = new File("TXT FILES\\OTP.txt");		
						Scanner scanFile = new Scanner(admin_file); //Scan File
							
						while(scanFile.hasNext()){
							otp=scanFile.next();
							fileIs=scanFile.next();
							break;
						}
						scanFile.close();
							
					}catch(Exception f){
						System.out.println("OTP File has problem in OTP Panel");
					}
						
			//Getting the usernames file
						String User_Information_File_Path="TXT FILES/User Information/User--"+fileIs+".txt";
							
						try{
							File user_file = new File(User_Information_File_Path);		
							Scanner scanFile = new Scanner(user_file);//Scan File
							
							while(scanFile.hasNext()){
								user_username=scanFile.next();
								user_password=scanFile.next();
								user_email=scanFile.next();
								user_phone=scanFile.next();
								user_gender=scanFile.next();
								user_name=scanFile.next()+" "+scanFile.next();
								break;
							}
							scanFile.close();
						}catch(Exception f)		{System.out.println("User File Problem in Username Panel");}
					
			//Got the File
			//Re-Write the file with new password
					
					try{
							String userfile="TXT FILES/User Information/User--"+fileIs+".txt";
							Formatter formatter=new Formatter(userfile);
							
							formatter.format("%s\r\n", user_username);
							formatter.format("%s\r\n", password);
							formatter.format("%s\r\n", user_email);
							formatter.format("%s\r\n", user_phone);
							formatter.format("%s\r\n", user_gender);
							formatter.format("%s\r\n", user_name);
							
							formatter.close();	
						}catch(Exception f)		{System.out.println(f);}


						
						frame.setVisible(false);
					new LoginPage();
				}
			} 
		});


		frame.setVisible(true);
        frame.setResizable(false);
    }
}
