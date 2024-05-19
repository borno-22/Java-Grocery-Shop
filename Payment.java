import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.text.*;

public class Payment {
      String runtxt, running_userFile;
      String ordered_quantity;
      
      String product_id, product_price, product_name, product_category,product_quantity,product_path;
      String user_username, user_password, user_email, user_phone, user_gender, user_name;
      int quantity;
      double price;


      int orderFileNo, product_Stock;


    public Payment() {

        JFrame frame = new JFrame();
        ImageIcon img = new ImageIcon("Images\\brand.png");
        frame.setIconImage(img.getImage());
        frame.setBounds(250, 110, 1000, 600);
		frame.setTitle("PAYMENT");
        frame.setFont(new Font("Times New Roman", Font.BOLD, 15));
		frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Container creation
		    Container panel = new Container();
		    panel=frame.getContentPane();
		    panel.setLayout(null);

            // card holder
            JTextField card_holder = new JTextField();
            new TextPrompt("Card Holder Name", card_holder);
            card_holder.setBounds(740, 212, 150, 22);
            card_holder.setFont(new Font("Times New Roman", Font.PLAIN, 15));
            card_holder.setForeground(Color.BLACK);
            card_holder.setOpaque(false);
            card_holder.setBorder(javax.swing.BorderFactory.createEmptyBorder());
            panel.add(card_holder);


            // card number
            JTextField card_number = new JTextField();
            new TextPrompt("Card Number", card_number);
            card_number.setBounds(740, 270, 150, 22);
            card_number.setFont(new Font("Times New Roman", Font.PLAIN, 15));
            card_number.setForeground(Color.BLACK);
            card_number.setOpaque(false);
            card_number.setBorder(javax.swing.BorderFactory.createEmptyBorder());
            panel.add(card_number);


            // valid number
            JTextField validity = new JTextField();
            new TextPrompt("Valid Number", validity);
            validity.setBounds(731, 325, 150, 22);
            validity.setFont(new Font("Times New Roman", Font.PLAIN, 15));
            validity.setForeground(Color.BLACK);
            validity.setOpaque(false);
            validity.setBorder(javax.swing.BorderFactory.createEmptyBorder());
            panel.add(validity);

            // CVV code
            JPasswordField pf = new JPasswordField();
            new TextPrompt("Code", pf);
            pf.setBounds(721, 383, 172, 22);
            pf.setHorizontalAlignment(JPasswordField.CENTER);
            pf.setEchoChar('*');
            pf.setFont(new Font("Times New Roman",Font.PLAIN, 15));
            pf.setOpaque(false);
            pf.setBorder(javax.swing.BorderFactory.createEmptyBorder());
            panel.add(pf);

            // Button Creation
            JButton confirm_Button = new JButton("Confirm");
            confirm_Button.setBounds(690,446,135,18);;
            confirm_Button.setContentAreaFilled(false);
            confirm_Button.setBorderPainted(false);
            confirm_Button.setFocusPainted(false);
            confirm_Button.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            confirm_Button.setForeground(Color.RED);
            confirm_Button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            panel.add(confirm_Button);
			
			 //back button
            JButton back = new JButton();
            back.setBounds(20,465,30,30);;
            back.setContentAreaFilled(false);
            back.setBorderPainted(false);
            back.setFocusPainted(false);
            back.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            back.setForeground(Color.RED);
            back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            panel.add(back);
			
			back.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
			frame.setVisible(false);
			new Checkout_summary();
			}});

        
  


            // Background Image set 
            ImageIcon Newpass_Background = new ImageIcon("Images\\Payment.png");
            JLabel bg_label = new JLabel(Newpass_Background);
            bg_label.setBounds(0,0,986,563);
            panel.add(bg_label);


            confirm_Button.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae) {
                  String nameOnCard = card_holder.getText();
                  String cardNumber = card_number.getText();
                  String validOn = validity.getText();
                  String cvvCode = new String(pf.getPassword());
                  
                  if (nameOnCard.isEmpty() || cardNumber.isEmpty() || validOn.isEmpty() || cvvCode.isEmpty()) {
                      JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",
                              JOptionPane.WARNING_MESSAGE);
                  }
                  else{
                    int orderConfirmation = JOptionPane.showConfirmDialog (null,"Do you want Confirm the order?", "Order Confirmation",JOptionPane.YES_NO_OPTION);
					
                    if (orderConfirmation == JOptionPane.YES_OPTION){
//////////////////////////////////////////////////////////////////////////////////////////
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
                                product_id = scanFile.next();
                                product_price = scanFile.next();
                                product_name = scanFile.next();
                                product_category = scanFile.next();
                                product_path = scanFile.next();
                                product_quantity = scanFile.next();
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
                      
                          double total=(price*quantity)+50;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                          String randomnumber;
                          //Generate Order No
                          Calendar c = Calendar.getInstance();
                          SimpleDateFormat ft= new SimpleDateFormat("dd/MM/yyyy");
                          String AMPM, date = ft.format(new Date());
                          int meridiem= c.get(Calendar.AM_PM);
                              
                          if(meridiem==1)		{AMPM="PM";}
                          else		{AMPM="AM";}
                              
                          String Time_Date= date+"_"+c.get(Calendar.HOUR)+":"+c.get(Calendar.MINUTE)+":"+c.get(Calendar.SECOND)+AMPM;

                          randomnumber=generateOtp(2);
                          String orderNUMBER="MSPN " +randomnumber+Time_Date;
//////////////////////////////////////////////////////////////////////////
////////////////////////Getting order file NO to create new order file////////////////////////////////////
                          String orderfile="";
                          try{
                            File running_user_File = new File("TXT FILES\\OrderFileNo.txt");		
                            Scanner scanFile = new Scanner(running_user_File);//Scan File
                                  
                            while(scanFile.hasNext()){
                              orderfile=scanFile.next();
                              break;
                            }
                            scanFile.close();
                            
                            orderFileNo= Integer.parseInt(orderfile);
                            
                          }catch(Exception f){
                            System.out.println("Running txt problem");
                          }
///////////////Writting Order Info in file/////////////////////////////////////////////////////////////
            //Get running user file no
                          try{
                            File running_user_File = new File("TXT FILES\\Running_User_File_NO.txt");		
                            Scanner scanFile = new Scanner(running_user_File);//Scan File
                                  
                            while(scanFile.hasNext()){
                              running_userFile=scanFile.next();
                              break;
                            }
                            scanFile.close();
                          }catch(Exception f){
                            System.out.println("Running user txt problem");
                          }
                          
              //Get running user Info
                          try{
                            File running_user_File = new File("TXT FILES\\User Information\\User--"+running_userFile+".txt");		
                            Scanner scanFile = new Scanner(running_user_File);//Scan File
                                  
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
                          }catch(Exception f){
                            System.out.println("Running user txt problem");
                          }

              //creating new order file
                          try{
                            String USER_FILE="TXT FILES\\Orders\\Order--"+orderFileNo+".txt";
                            Formatter formatter = new Formatter(USER_FILE);
                            
                            orderFileNo++;
                            
                            
                            
                            formatter.format("%s\r\n", orderNUMBER);
                            formatter.format("%s\r\n", product_name);
                            formatter.format("%s\r\n", user_phone);
                            formatter.format("%s\r\n", user_email);
                            formatter.format("%s\r\n", ordered_quantity);
                            formatter.format("%s\r\n", ""+total);
                            formatter.format("%s\r\n", user_username);
                            
                            
                            
                            formatter.close();	
                          }catch(Exception f)		{System.out.println(f);}
                        
/////////////////////Updating Order file NO file/////////////////////////////////////////////////
                          try{
                            Formatter formatter=new Formatter("TXT FILES\\OrderFileNo.txt");
                            
                            formatter.format("%s", ""+orderFileNo);
                            
                            
                            formatter.close();	
                          }catch(Exception f)		{System.out.println(f);}

/////////////////////Updating Order ID in tempfile/////////////////////////////////////////////////
                          try{
                            Formatter formatter=new Formatter("TXT FILES\\TempOrderNo.txt");
                            
                            formatter.format("%s", ""+(orderFileNo-1));
                            
                            
                            formatter.close();
                          }catch(Exception f)		{System.out.println(f);}


/////////////////////////////Update product Stock///////////////////////////////////////////////
                          product_Stock=Integer.parseInt(product_quantity);
                          product_Stock-=quantity;
                          product_quantity=Integer.toString(product_Stock);



                          try{
                            Formatter formatter=new Formatter("TXT FILES\\Product_Info\\Product--"+runtxt+".txt");
                            
                            formatter.format("%s\r\n", product_id);
                            formatter.format("%s\r\n", product_price);
                            formatter.format("%s\r\n", product_name);
                            formatter.format("%s\r\n", product_category);
                            formatter.format("%s\r\n", product_path);
                            formatter.format("%s\r\n", product_quantity);
                            
                            formatter.close();	
                          }catch(Exception f)		{System.out.println(f);}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                          JOptionPane.showMessageDialog(null, "Successfully order placed.Thanks for being with us","Payment Confirmation",-1,new ImageIcon("Images\\tick.png"));
                          frame.setVisible(false);
                          new Order_Slip();
                    }
                    else{
						
                    
                    }

                  }

            }});          

            frame.setVisible(true);
            frame.setResizable(false);

    }
    private String generateOtp(int otpLength){
      SplittableRandom split = new SplittableRandom();
      
      StringBuilder sb=new StringBuilder();
      
      for(int i=0; i<otpLength; i++){
        sb.append(split.nextInt(0,10));
      }
      return sb.toString();
    }
}
