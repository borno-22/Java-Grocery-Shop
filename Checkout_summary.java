import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class Checkout_summary {

  	int fileNo, orderFileNo, fileIs, addressFileNo;
	String runtxt;
	String ordered_quantity;
	
  	String product_id, product_price, product_name, product_category,product_quantity,product_path;
	String purchase_Quantity;
	int quantity;
	double price;

    public Checkout_summary() {

        JFrame frame = new JFrame();
        ImageIcon img = new ImageIcon("Images\\logo1.png");
        frame.setIconImage(img.getImage());
        frame.setBounds(250, 110, 1000, 600);
		frame.setTitle("CHECKOUT SUMMARY");
        frame.setFont(new Font("Times New Roman", Font.BOLD, 15));
		frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Container creation
		Container panel = new Container();
		panel=frame.getContentPane();
		panel.setLayout(null);



        // Home button
        JButton home = new JButton();
        home.setBounds(18, 24, 35, 25);
        home.setFont(new Font("Bell MT", Font.BOLD, 15));
		home.setForeground(Color.DARK_GRAY);
		home.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		home.setContentAreaFilled(false);
		home.setBorderPainted(false);
        home.setFocusPainted(false);
        panel.add(home);

        // back button
        JButton back = new JButton();
        back.setBounds(18, 465, 35, 25);
        back.setFont(new Font("Bell MT", Font.BOLD, 15));
		back.setForeground(Color.DARK_GRAY);
		back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
        back.setFocusPainted(false);
        panel.add(back);
		
		JButton check_out = new JButton("Checkout");
		check_out.setBounds(735, 417, 103, 25);
		check_out.setFont(new Font("Bell MT", Font.BOLD, 16));
		check_out.setForeground(Color.DARK_GRAY);
		check_out.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		check_out.setContentAreaFilled(false);
		check_out.setBorderPainted(false);
        check_out.setFocusPainted(false);
		check_out.setToolTipText("Confirm Order");
		frame.add(check_out);


        // Add hover

        check_out.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
              check_out.setForeground(Color.RED);
            }
      
            public void mouseExited(java.awt.event.MouseEvent evt) {
              check_out.setForeground(Color.DARK_GRAY);
            }
          });
//////////////////////////////////////////////////////////////////////////////////////////
//Gtting The Product ID
	String runtxt="";

	try{
			File running = new File("TXT FILES/Running_Product.txt");		
			Scanner scanFile = new Scanner(running); //Scan File
						
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
				Scanner scanFile = new Scanner(user_file);//Scan File
						
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
				price=Double.parseDouble(product_price);
			}catch(Exception f)		{System.out.println("Product Info file problem");}

		//get ordered quantity
		try{
			File running = new File("TXT FILES\\Quantity.txt");		
			Scanner scanFile = new Scanner(running);//Scan File
						
			while(scanFile.hasNext()){
				ordered_quantity=scanFile.next();
				break;
			}
			scanFile.close();
			quantity=Integer.parseInt(ordered_quantity);

		}catch(Exception f){
			System.out.println("Running txt problem");
		}
//////////////////////////////////////////////////////////////////////////////////////////

//Product_Price
	    JLabel Product_Price_label = new JLabel(product_price);//Product Price//
		Product_Price_label.setBounds(870,211,100,30);
		Product_Price_label.setFont(new Font ("Arial", Font.BOLD,15));
		frame.add(Product_Price_label);

//ordered quantity
	    JLabel ordered_quantity_label = new JLabel(ordered_quantity);//Product Price//
		ordered_quantity_label.setBounds(870,255,100,30);
		ordered_quantity_label.setFont(new Font ("Arial", Font.BOLD,15));
		frame.add(ordered_quantity_label);

      
//shipping
	    JLabel shipping_label = new JLabel("50.0");//Product Price//
		shipping_label.setBounds(870,295,100,30);
		shipping_label.setFont(new Font ("Arial", Font.BOLD,15));
		frame.add(shipping_label);

      
//total
		double total=(price*quantity)+50;

	    JLabel total_label = new JLabel(""+total);//Product Price//
		total_label.setBounds(870,335,100,30);
		total_label.setFont(new Font ("Arial", Font.BOLD,15));
		frame.add(total_label);

//photo
		JLabel image_label = new JLabel(new ImageIcon(product_path));
		image_label.setBounds(165,180,230,280);
		frame.add(image_label);      
 


			//Set background image
            ImageIcon Newpass_Background = new ImageIcon("Images\\Checkout_Summary.png");
            JLabel bg_label = new JLabel(Newpass_Background);
            bg_label.setBounds(0,0,986,563);
            panel.add(bg_label);

            back.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
            frame.setVisible(false);
            new View_details();
            }});

			check_out.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                new Payment();
            }});

            home.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                new WelcomePage();
            }});
			
		      //Checkout Button Listener
		check_out.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
				  
		}}); 

        frame.setVisible(true);
        frame.setResizable(false);
    
    }
}