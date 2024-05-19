import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;



	public class Order_Slip {
      String runtxt, running_order;
      String ordered_quantity;
      String orderNUMBER, user_phone, user_email, total, user_name;
      String product_id, product_price, product_name, product_category,product_quantity,product_path;
	  
    public Order_Slip(){
        JFrame frame = new JFrame();
        ImageIcon img = new ImageIcon("Images\\brand.png");
        frame.setIconImage(img.getImage());
        frame.setBounds(250, 110, 1000, 600);
		frame.setTitle("ORDER SLIP");
        frame.setFont(new Font("Times New Roman", Font.BOLD, 15));
		frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


         // Container creation
		Container panel = new Container();
		panel=frame.getContentPane();
		panel.setLayout(null);

        // Delete Dot Class File 
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
                }catch(Exception f)		{System.out.println("Product Info file problem");}

        //get running order
              try{
                File running = new File("TXT FILES\\TempOrderNo.txt");		
                Scanner scanFile = new Scanner(running);//Scan File
                      
                while(scanFile.hasNext()){
                  running_order=scanFile.next();
                  break;
                }
                scanFile.close();

              }catch(Exception f){
                System.out.println("Running order txt problem");
              }
          //get running order info
              try{
                File running = new File("TXT FILES\\Orders\\Order--"+running_order+".txt");		
                Scanner scanFile = new Scanner(running);//Scan File
                      
                while(scanFile.hasNext()){
                  
                  orderNUMBER = scanFile.next();
                  product_name = scanFile.next();
                  user_phone = scanFile.next();
                  user_email = scanFile.next();
                  ordered_quantity = scanFile.next();
                  total=scanFile.next();
                  user_name = scanFile.next();
                  break;
                }
                scanFile.close();

              }catch(Exception f){
                System.out.println("Running order txt problem");
              }



        //photo
            JLabel image_label = new JLabel(new ImageIcon(product_path));
            image_label.setBounds(350,145,179,265);
            panel.add(image_label);

        //productName label	
            JLabel productName_label = new JLabel(product_name);
            productName_label.setBounds(350,425,260,50);
            productName_label.setFont(new Font ("Arial", Font.BOLD,25));
            panel.add(productName_label);

        //Order_id label	
            JLabel Order_id_label = new JLabel(orderNUMBER);
            Order_id_label.setBounds(733,206,250,30);
            Order_id_label.setFont(new Font ("Arial", Font.BOLD,14));
            panel.add(Order_id_label);

        //Name label	
            JLabel Name_label = new JLabel(user_name);
            Name_label.setBounds(733,244,250,30);
            Name_label.setFont(new Font ("Arial", Font.BOLD,14));
            panel.add(Name_label);

        //Phone_Number label	
            JLabel Phone_Number_label = new JLabel(user_phone);
            Phone_Number_label.setBounds(733,282,250,30);
            Phone_Number_label.setFont(new Font ("Arial", Font.BOLD,14));
            panel.add(Phone_Number_label);

        //Email_Address label	
            JLabel Email_Address_label = new JLabel(user_email);
            Email_Address_label.setBounds(733,319,250,30);
            Email_Address_label.setFont(new Font ("Arial", Font.BOLD,14));
            panel.add(Email_Address_label);

        //Product_Quantity label	
            JLabel Product_Quantity_label = new JLabel(ordered_quantity);
            Product_Quantity_label.setBounds(733,352,250,30);
            Product_Quantity_label.setFont(new Font ("Arial", Font.BOLD,14));
            panel.add(Product_Quantity_label);

        //Order_Amount label	
            JLabel Order_Amount_label = new JLabel(total);
            Order_Amount_label.setBounds(733,390,250,30);
            Order_Amount_label.setFont(new Font ("Arial", Font.BOLD,14));
            panel.add(Order_Amount_label);



            //button set
            JButton back_home = new JButton("Back to Home");
            back_home.setBounds(570, 445, 140, 25);
            back_home.setFont(new Font("Bell MT", Font.BOLD, 15));
            back_home.setBackground(Color.LIGHT_GRAY);
            back_home.setForeground(Color.RED);
            back_home.setFocusPainted(false);
            back_home.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            panel.add(back_home);
			
			//button set
            JButton print = new JButton("Print");
            print.setBounds(790, 445, 140, 25);
            print.setFont(new Font("Bell MT", Font.BOLD, 15));
            print.setBackground(Color.LIGHT_GRAY);
            print.setForeground(Color.RED);
            print.setFocusPainted(false);
            print.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            panel.add(print);


            //Tick_Mark label	
            JLabel Tick_Mark_Label = new JLabel((new ImageIcon("Images\\Confirm_Page_Giphy.gif")));
            Tick_Mark_Label.setBounds(550,110,53,50);
            Tick_Mark_Label.setOpaque(true);		
            frame.add(Tick_Mark_Label);

            

            // Set Background Image
            ImageIcon Newpass_Background = new ImageIcon("Images\\Order_Slip.png");
            JLabel bg_label = new JLabel(Newpass_Background);
            bg_label.setBounds(0,0,986,563);
            panel.add(bg_label);


            back_home.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
                frame.setVisible(false);
                new WelcomePage();
            }});
			
			print.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
				frame.setVisible(false);
				new WelcomePage();
            }});
			
			//Print Button Action Listener
			print.addActionListener(new Print_Operation());
			
            // set visible 
            frame.setVisible(true);
            frame.setResizable(false);

    }
}
