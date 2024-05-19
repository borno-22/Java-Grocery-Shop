import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class OTPsubmit {

	String otp;
	static int invalidCount;
    
    public OTPsubmit(){
        JFrame frame = new JFrame();
        ImageIcon img = new ImageIcon("Images\\logo1.png");
        frame.setIconImage(img.getImage());
        frame.setBounds(0, 0, 1000, 600);
		frame.setTitle("Getting OTP");
		frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //// Container creation
		Container p1 = new Container();
		p1 = frame.getContentPane();
		p1.setLayout(null);

		
		// Create TextField		
		JTextField tf = new JTextField();
        tf.setBounds(370, 335, 245, 40);
        tf.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		tf.setForeground(Color.DARK_GRAY);
		tf.setOpaque(false);
		tf.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		new TextPrompt("OTP", tf);
		p1.add(tf);


        // Create Button 	
		JButton b1= new JButton("Submit");
		b1.setBounds(470,383,80,35);
		b1.setContentAreaFilled(false);
		b1.setBorderPainted(false);
        b1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		b1.setForeground(Color.WHITE);
		b1.setFocusPainted(false);
		b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		p1.add(b1);



		JButton b2 = new JButton();//back button
        b2.setBounds(20, 20, 35, 25);
		b2.setFont(new Font("Aptos", Font.BOLD, 12));
		b2.setContentAreaFilled(false);
		b2.setBorderPainted(false);
		b2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        p1.add(b2);


        ImageIcon Newpass_Background = new ImageIcon("Images\\otp1.jpg");
    	JLabel bg_label = new JLabel(Newpass_Background);
        bg_label.setBounds(0,0,1000,610);
        p1.add(bg_label);



		//back Button Listener
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				frame.setVisible(false);
				new OTP();
				
			}
		});
 


			//Submit Button Action Listener
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent u){
				
//////////////////////////////////
				String otp_provided=tf.getText();
				
				
				try{
					File otp_File = new File("TXT FILES\\OTP.txt");		
					Scanner scanFile = new Scanner(otp_File); //Scan File
						
					while(scanFile.hasNext()){
						otp = scanFile.next();
						break;
					}
					scanFile.close();
						
				}catch(Exception f){
					System.out.println("OTP File has problem in OTP Panel");
				}
				
				if(otp_provided.equals(otp))
				{
					
					frame.setVisible(false);
					new changePassword();
				}
				else{
					invalidCount++;
					
					if(invalidCount>5){
						JOptionPane.showMessageDialog(null,"Wrong attempt !! You Have Entered wrong OTP more than 5 times.","WARNING",JOptionPane.WARNING_MESSAGE);
						System.exit(0);
					}
					else{
						JOptionPane.showMessageDialog(null,"Enter a valid OTP","Invalid OTP",JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		

		frame.setVisible(true);
        frame.setResizable(false);
    }
}
