package com.wipro.pos.ui;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.wipro.pos.listener.ViewOrderListener;

public class ViewOrderFrame extends JFrame
{
	
	public JButton backButton,viewButton;
	public JLabel label,viewLabel;
	public JTable table;
	public DefaultTableModel model=new DefaultTableModel();
	public Object object[];
	
	public ViewOrderFrame() {
		setTitle("View Order");
		setSize(720,680);
		setLocation(100, 100);
		setResizable(false);
		
		
		setLayout(null);
		

		
		//Background
				setContentPane(new JLabel(new ImageIcon("background.jpg")));
				setLayout(null);
		
		label=new JLabel("View All Order");
		label.setBounds(300, 20, 250, 40);
		add(label);
		
		
		
		backButton=new JButton("Back");
		backButton.setBounds(350, 70, 80, 20);
		backButton.setBackground(Color.orange);
		add(backButton);
		
		viewButton=new JButton("View");
		viewButton.setBounds(250, 70, 80, 20);
		viewButton.setBackground(Color.orange);
		add(viewButton);
		
		
		model.addColumn("Orderid");
		model.addColumn("Userid");
		model.addColumn("oRDERdATE");
		model.addColumn("sTORE Id");
		model.addColumn("Total Price ");
		model.addColumn("OrderStatus");
		model.addColumn("Cart Id");
		model.addColumn("sTREET");
		model.addColumn("CITY");
		model.addColumn("STATE");
		model.addColumn("PINCODE");
		model.addColumn("MOBILENO");
		table=new JTable(model);
		//table.setBounds(150, 200,300,200);
		table.setBackground(Color.LIGHT_GRAY);
		table.setVisible(false);
		add(table);
		
		object=new  Object[8];
		viewButton.addActionListener(new ViewOrderListener(this));
		backButton.addActionListener(new ViewOrderListener(this));
		setVisible(true);
		

		/*viewLabel=new JLabel("Select Schedule");
		viewLabel.setBounds(80, 60, 100, 40);
		add(viewLabel);*/
		
		/*choice=new Choice();
		choice.setBounds(190, 70, 80, 40);
		add(choice);*/

	}

	/*public static void main(String[] args) 
	{
		new ViewOrderFrame();
	}
*/
}
