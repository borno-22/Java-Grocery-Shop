import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.print.*;
import java.util.*;
import java.io.*;

public class Print_Operation implements Printable, ActionListener {
	
	  int total_orderNo, orderfileIs,Order_Amount_label;
	
	  String runtxt, running_order;
      String ordered_quantity;
      String orderNUMBER, user_phone, user_email, total, user_name, address = "";
      String product,product_id, product_price, product_name, product_category,product_quantity,product_path;
	  


    public int print(Graphics g, PageFormat pf, int page) throws PrinterException {

        if (page > 0) { /* Have only one page, and 'page' is zero-based */
            return NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());
		g.setFont(new Font("Seqoe UI", Font.PLAIN, 16));
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////ORDER Information///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Getting TOtal Order NO 
		String orderNo="";
		try{
			File orderFile = new File("TXT FILES\\Orders.txt"); // TXT FILES\\Orders.txt		
			Scanner scanFile = new Scanner(orderFile);//Scan File
						
			while(scanFile.hasNext()){
				orderNo=scanFile.next();
				break;
			}
			scanFile.close();
					
			total_orderNo= Integer.parseInt(orderNo);
			total_orderNo=total_orderNo-1;
						
		}catch(Exception f)		{System.out.println("Problem Running file user in Confirm");}

//Getting Running Order 
		try{
			File running_user_File = new File("TXT FILES\\TempOrderNo.txt"); //TXT FILES\\TempOrderNo.txt	
			Scanner scanFile = new Scanner(running_user_File);//Scan File
						
			while(scanFile.hasNext()){
				product=scanFile.next();
				break;
			}
			scanFile.close();
						
		}catch(Exception f){
			System.out.println("Running Order file problem in Confirm Panel");
		}

//Getting Running Order Information
		for(int i=1; i<=total_orderNo; i++)
		{
			String Order_File_NO="TXT FILES\\Product_Info\\Product--"+i+".txt"; // TXT FILES\\Product_Info\\Product--"+i+".txt
						
			try{
				File order_File = new File(Order_File_NO);		
				Scanner scanFile = new Scanner(order_File);//Scan File
						
				while(scanFile.hasNext()){
					product_id=scanFile.next();
					product_name=scanFile.next();
					user_phone=scanFile.next();
					user_email=scanFile.next();
					product_quantity=scanFile.next();
					product_price=scanFile.next();
					user_name=scanFile.next()+" "+scanFile.next();
					break;
				}
				scanFile.close();
							
							
				if(product_id.equals(product))
				{
					orderfileIs=i;
					break;
				}
			}catch(Exception f)		{System.out.println("Order File Problem in Confirm Panel");}
		}
		
/////////////////////////////////////////////////////////////////Getting Book Information////////////////////////////////////////////////////////////////////////
//Gtting The Product ID
	String runtxt="";

	try{
			File running_user_File = new File("TXT FILES\\Running_Product.txt"); // TXT FILES\\Running_Product.txt		
			Scanner scanFile = new Scanner(running_user_File); //Scan File
						
			while(scanFile.hasNext()){
				runtxt=scanFile.next();
				break;
			}
			scanFile.close();
						
		}catch(Exception f){
			System.out.println("Running txt problem");
		}
		
//Getting Book Info

	String User_Information_File_Path="TXT FILES\\Product_Info\\Product--"+runtxt+".txt"; // TXT FILES\\Product_Info\\Product--
						
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
			}catch(Exception f)		{System.out.println("Book Info file problem");}

		
		
////////////////////////////////////////////////////////////////////////////////////////////////////
		
		Image imglogo = Toolkit.getDefaultToolkit().getImage("Images\\logo.png");
        
		g.drawImage(imglogo,110,50,null);
		
		
		Image img = Toolkit.getDefaultToolkit().getImage(product_path);
        
		g.drawImage(img,215,150,null);
		
		
		g.drawString("Order ID                  :  "+product_id, 100, 510);
        g.drawString("Name                      :  "+user_name, 100, 535);
        g.drawString("Phone Number       		:  "+user_phone, 100, 560);
        g.drawString("Email Address        		:  "+user_email, 100, 585);
		g.drawString("Product Name             	:  "+product_name, 100, 610);
        g.drawString("Product Quantity         	:  "+product_quantity, 100, 635);
        g.drawString("Product Amount         	:  "+product_price, 100, 660);

        /* tell the caller that this page is part of the printed document */
        return PAGE_EXISTS;
    }

    public void actionPerformed(ActionEvent e) {
         PrinterJob job = PrinterJob.getPrinterJob();
         job.setPrintable(this);
         boolean ok = job.printDialog();
         if (ok) {
             try {
                  job.print();
				  JOptionPane.showMessageDialog(null, "Invoice Successfully printed","Print Confirmation",-1,new ImageIcon("Images\\Successful_Icon.png"));
             } catch (PrinterException ex) {
					System.out.println("Print problem in print confirm");
             }
         }
    }

}