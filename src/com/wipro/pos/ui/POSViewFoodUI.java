package com.wipro.pos.ui;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.toedter.calendar.JDateChooser;
import com.wipro.pos.bean.FoodBean;
import com.wipro.pos.listener.Listener;
import com.wipro.pos.listener.POSCustomerViewFoodPageListener;
//import com.wipro.pos.listener.POSCustomerViewBookPageListener;
//import com.wipro.pos.listener.POSViewTicketListener;
import com.wipro.pos.listener.POSCustomerViewStorePageListener;
import com.wipro.pos.service.Administrator;

public class POSViewFoodUI extends JPanel {

	public JLabel cityl,MainLabel;
	public JTextField city;
	//public JDateChooser chooser;
	//public JPanel datePanel;
	public JButton searchButton;
	public DefaultTableModel model;
	public JTable flightsTable;
	public Object[] rows=new Object[7];
	public JScrollPane pane;
	//public Choice choice;
	//public JRadioButton domesticRadioButton,internationalRadioButton;
	//JButton searchButton;
	public static JFrame frame;
	//public static JPanel frame;
	public static JButton buttonDelete,add;
	public static Choice choice;
	public static JLabel labelCartId,Quantity;
	public static JTextField cartid,quant;
	public POSViewFoodUI() {
		
		FoodBean flightBean;
		frame=new JFrame("Delete");
		frame.setSize(720, 680);
		frame.setResizable(false);
		frame.setLocation(100, 100);
		frame.setVisible(true);
		
frame.setLayout(null);
		
		//Background
				frame.setContentPane(new JLabel(new ImageIcon("background.jpg")));
				frame.setLayout(null);
		
		
		//frame=new JPanel();
		choice=new Choice();
		choice.setBounds(400, 100, 100, 20);
		
		add=new JButton("Order");
		add.setBounds(100, 500, 100, 20);
		
		JLabel labelFoodName = new JLabel("FoodName");
		labelFoodName.setBounds(200, 100, 100, 20);
		
		
		
		labelCartId=new JLabel("Cart Id");
		labelCartId.setBounds(200,200,100,20);
		frame.add(labelCartId);
		Quantity=new JLabel("Quantity");
		Quantity.setBounds(200,150,100,20);
		frame.add(Quantity);
		quant=new JTextField();
		quant.setBounds(260,150,100,20);
		frame.add(quant);
		cartid=new JTextField();
		cartid.setBounds(260,200,100,20);
		frame.add(cartid);
		frame.add(labelFoodName);
		frame.add(choice);
		//frame.add(buttonDelete);
		frame.add(add);
		FoodBean food=new FoodBean();
		ArrayList<FoodBean> list=new ArrayList<FoodBean>();
		Administrator administrator = new Administrator();
		list=administrator.viewAllFood(null);
		
		Iterator<FoodBean> itr=list.iterator();
		while(itr.hasNext())
		{
			flightBean = new FoodBean();
			flightBean=itr.next();
			food=flightBean;
			POSViewFoodUI.choice.add(flightBean.getName());
		}
		
		//frame.add(frame);
		
		//buttonDelete.addActionListener(new Listener(this));
		add.addActionListener(new Listener(this));
	}
	  
	    
	    
	}
	class ButtonRenderer extends JButton implements TableCellRenderer {

	    public ButtonRenderer() {
	        setOpaque(true);
	    }

	    @Override
	    public Component getTableCellRendererComponent(JTable table, Object value,
	            boolean isSelected, boolean hasFocus, int row, int column) {
	        if (isSelected) {
	            setForeground(table.getSelectionForeground());
	            setBackground(table.getSelectionBackground());
	            new cartUI();
	        } 
	        else {
	            setForeground(table.getForeground());
	            setBackground(UIManager.getColor("Button.background"));
	        }
	        setText((value == null) ? "Cart" : value.toString());
	        return this;
	    }
	}
//	public static void main(String args[]){
//		new POSCustomerViewPageUI();
//	}

