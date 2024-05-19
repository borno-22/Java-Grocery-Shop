import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


public class WelcomePage {
  

    public WelcomePage(){
		
        JFrame frame = new JFrame();
        ImageIcon img = new ImageIcon("Images\\logo1.png");
        frame.setIconImage(img.getImage());
        frame.setBounds(0, 0, 1000, 610);
		frame.setTitle("WElCOME PAGE");
		frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//Container creation
		Container panel = new Container();
		panel=frame.getContentPane();
		panel.setLayout(null);


		JButton frozen = new JButton();
        frozen.setBounds(255, 390, 110, 170);
		frozen.setForeground(Color.BLACK);
        frozen.setContentAreaFilled(false);
		frozen.setBorderPainted(false);
        frozen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(frozen);


		JButton organic = new JButton();
        organic.setBounds(440, 390, 110, 170);
		organic.setForeground(Color.BLACK);
        organic.setContentAreaFilled(false);
		organic.setBorderPainted(false);
        organic.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(organic);


		JButton drinks_item = new JButton();
        drinks_item.setBounds(622, 390, 110, 170);
		drinks_item.setForeground(Color.BLACK);
        drinks_item.setContentAreaFilled(false);
		drinks_item.setBorderPainted(false);
        drinks_item.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(drinks_item);


		JButton logout = new JButton("Logout");
		logout.setContentAreaFilled(false);
		logout.setBorderPainted(false);
		logout.setFont(new Font("Aptos", Font.BOLD, 12));
		logout.setBounds(870, 5, 100, 25);
		logout.setForeground(new Color(142,58,22));
		logout.setFocusPainted(false);
		logout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(logout);
	
		//Set Background Image
		
        ImageIcon Newpass_Background = new ImageIcon("Images\\WelcomePage.png");
    
        JLabel bg_label = new JLabel(Newpass_Background);
        bg_label.setBounds(0,0,1000,610);
        panel.add(bg_label);
		

		
		frozen.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
			frame.setVisible(false);
			new HomePage();
        }});


		drinks_item.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
			frame.setVisible(false);
			new drinksItem();
        }});



		organic.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
			frame.setVisible(false);
			new ChocolateItem();
        }});
	
		
		logout.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
		frame.setVisible(false);
		new LoginPage();
		}});

		
		logout.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				logout.setForeground(Color.CYAN);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				logout.setForeground(new Color(142,58,22));
			}
		}); 
		

		frame.setVisible(true);
        frame.setResizable(false);
		
		
		
    }
    
}