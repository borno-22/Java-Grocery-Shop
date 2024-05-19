import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;



public class View_details {

	String product_id, product_price, product_name, product_category,product_quantity,product_path;
	int valueInt = 1;
    
    public View_details(){
		
        JFrame frame = new JFrame();
        ImageIcon img = new ImageIcon("Images\\logo1.png");
        frame.setIconImage(img.getImage());
        frame.setBounds(250, 110, 1000, 600);
		frame.setTitle("VIEW DETAILS");
        frame.setFont(new Font("Times New Roman", Font.BOLD, 15));
		frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //// Container creation

		Container p1 = new Container();
		p1=frame.getContentPane();
		p1.setLayout(null);


//Gtting The Product ID
	String runtxt="";

	try{
			File running = new File("TXT FILES/Running_Product.txt");		
			Scanner scanFile = new Scanner(running);//Scan File
						
			while(scanFile.hasNext()){
				runtxt=scanFile.next();
				break;
			}
			scanFile.close();
						
		}catch(Exception f){
			System.out.println("Running txt problem");
		}
		
//Getting Product Info

	String User_Information_File_Path="TXT FILES\\Product_Info\\Product--"+runtxt+".txt";
						
			try{
				File user_file = new File(User_Information_File_Path);		
				Scanner scanFile = new Scanner(user_file); //Scan File
						
				while(scanFile.hasNext()){
					product_id=scanFile.next();
					product_price=scanFile.next();
					product_name=scanFile.next();
					product_category=scanFile.next();
					product_path=scanFile.next();
					product_quantity=scanFile.next();
					break;
				}
				scanFile.close();
			}catch(Exception f)		{System.out.println("Product Info file problem");}

		// Category label set
		JLabel Category_label = new JLabel("Product Category :");
		Category_label.setBounds(400,190,165,30);
		Category_label.setFont(new Font ("Times New Roman", Font.PLAIN,20));
		frame.add(Category_label);

		JLabel category2_label = new JLabel(product_category);
		category2_label.setBounds(555,190,150,30);
		category2_label.setFont(new Font ("Times New Roman", Font.BOLD,20));
		frame.add(category2_label);


	    // ID label		
		JLabel ID_label = new JLabel("Product ID :");
		ID_label.setBounds(400,225,150,30);
		ID_label.setFont(new Font ("Times New Roman", Font.PLAIN,20));
		frame.add(ID_label);
		
		JLabel ID2_label = new JLabel(product_id);
		ID2_label.setBounds(500,225,25,30);
		ID2_label.setFont(new Font ("Times New Roman", Font.BOLD,20));
		frame.add(ID2_label);

		// Price
        JLabel tk_label = new JLabel("TK.");
		tk_label.setBounds(400,253,150,30);
		tk_label.setFont(new Font ("Times New Roman", Font.BOLD,15));
		frame.add(tk_label);

		JLabel productName_label = new JLabel(product_name);
		productName_label.setBounds(400,120,260,50);
		productName_label.setFont(new Font ("Arial", Font.BOLD,35));
		frame.add(productName_label);

	    JLabel tk2_label = new JLabel(product_price);
		tk2_label.setBounds(430,251,100,30);
		tk2_label.setFont(new Font ("Times New Roman", Font.BOLD,21));		
		frame.add(tk2_label);

		//In Stock label
		int stock= Integer.parseInt(product_quantity);
		if(stock < 10){
			JLabel stock_label = new JLabel("In Stock :");
			stock_label.setBounds(400,280,100,30);
			stock_label.setForeground(Color.RED);
			stock_label.setFont(new Font ("Times New Roman", Font.PLAIN,20));
			frame.add(stock_label);
			
			JLabel available_label = new JLabel(product_quantity);
			available_label.setBounds(480,280,130,30);
			available_label.setForeground(Color.RED);
			available_label.setFont(new Font ("Times New Roman", Font.BOLD,15));
			frame.add(available_label);
		}
		
		else{
			JLabel stock_label = new JLabel("In Stock :");
			stock_label.setBounds(400,280,100,30);
			stock_label.setFont(new Font ("Times New Roman", Font.PLAIN,15));
			frame.add(stock_label);
			
			JLabel available_label = new JLabel("Available");
			available_label.setBounds(470,280,130,30);
			available_label.setFont(new Font ("Times New Roman", Font.BOLD,15));
			frame.add(available_label);
		}

		//photo
		JLabel image_label = new JLabel(new ImageIcon(product_path));
		image_label.setBounds(150,150,179,265);
		frame.add(image_label);

		//increment or decrement quantity
		JButton incBtn = new JButton();	
		incBtn.setBounds(458,315,15,15);
		incBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		incBtn.setFocusPainted(false);
		incBtn.setContentAreaFilled(false);		  
		incBtn.setBorderPainted(false);
		incBtn.setOpaque(false);
					  
		JButton decBtn = new JButton();
		decBtn.setBounds(398,315,15,15);
		decBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		decBtn.setContentAreaFilled(false);		  
		decBtn.setBorderPainted(false);
		decBtn.setFocusPainted(false); 
		decBtn.setOpaque(false);


		//Place Order button
		JButton buy_Button = new JButton("PLACE ORDER");
		buy_Button.setBounds(400,345,130,20);
		buy_Button.setFont(new Font ("Times New Roman", Font.BOLD,10));
		buy_Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		buy_Button.setForeground(Color.DARK_GRAY);
		buy_Button.setFocusPainted(false);
		buy_Button.setBackground(Color.WHITE);
		frame.add(buy_Button);

//////////////////////// QUANTITY////////////////////////////////
		JLabel showLbl = new JLabel("01");
		showLbl.setBounds(430,315,15,15);
				
		frame.add(showLbl);
		frame.add(incBtn);
		frame.add(decBtn);
		
		
		   incBtn.addActionListener(new ActionListener() {
		   public void actionPerformed(ActionEvent e) {
			   valueInt = Integer.parseInt(showLbl.getText());
			   valueInt++;
			   if (valueInt >= 10) {
				   showLbl.setText(String.valueOf(valueInt));
			   } else {
				   showLbl.setText("0" + String.valueOf(valueInt));
			   }
		   }
	   });

	   decBtn.addActionListener(new ActionListener() {
		   public void actionPerformed(ActionEvent e) {
			   valueInt = Integer.parseInt(showLbl.getText());
			   if (valueInt > 1) {
				   valueInt--;
			   }
			   if (valueInt >= 10) {
				   showLbl.setText(String.valueOf(valueInt));
			   } else {
				   showLbl.setText("0" + String.valueOf(valueInt));
			   }
		   }
	   });




		// Home Button

		JButton b1 = new JButton();
        b1.setBounds(25, 31, 35, 25);
        b1.setFont(new Font("Bell MT", Font.BOLD, 15));
		b1.setForeground(Color.DARK_GRAY);
		b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		b1.setContentAreaFilled(false);
		b1.setBorderPainted(false);
        p1.add(b1);


        ImageIcon Newpass_Background = new ImageIcon("Images\\View_details.png");
    	JLabel bg_label = new JLabel(Newpass_Background);
        bg_label.setBounds(0,0,986,563);
        p1.add(bg_label);



	b1.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
		frame.setVisible(false);
		new WelcomePage();
	}});




	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	buy_Button.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
		int purchaseQuantity=Integer.parseInt( showLbl.getText() );
			
			if(stock==0)
			{
				JOptionPane.showMessageDialog(null, product_name+" is Stock out. You can check our others books", "STOCK OUT",JOptionPane.WARNING_MESSAGE);
			}
			else if(purchaseQuantity>stock)
			{
				JOptionPane.showMessageDialog(null, "Only "+stock+" Pieces of "+product_name+" is in Stock", "Stock Limited",JOptionPane.WARNING_MESSAGE);
			}
			else
			{
				
				try{
					Formatter formatter=new Formatter("TXT FILES\\Quantity.txt");
					
					
					formatter.format("%s\r\n", showLbl.getText());
					formatter.close();  
						
				}catch(Exception f)    {System.out.println("Problem in Quantity file");}
				
				frame.setVisible(false);
				new Checkout_summary();
			}
			
	}});
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    frame.setVisible(true);
    frame.setResizable(false);
  }
}
