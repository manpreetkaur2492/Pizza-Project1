package com.wipro.pos.ui;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.wipro.pos.listener.Listener;

public class StoreFrame
{
	public static JFrame frame;
	public JLabel name,Street,mobile,city,state,pincode;
	public JTextField storeidt;
	public static JTextField namet;
	public static JTextField Streett;
	public static JTextField mobilet;
	public static JTextField cityt;
	public static JTextField statet;
	public static JTextField pincodet;
	public static JButton Buttonadd,Buttoncancel,buttonBack;
	
	public StoreFrame()
	{
		frame=new JFrame("Add Store");
		frame.setSize(720,680);
		frame.setLocation(100, 100);
		frame.setResizable(false);
		frame.setLayout(null);

		//Background
				frame.setContentPane(new JLabel(new ImageIcon("background.jpg")));
				frame.setLayout(null);
		
		//		storeid=new JLabel("StoreID");
			//	storeid.setBounds(150, 100, 100, 20);
		
		name=new JLabel("Name");
		name.setBounds(150, 100, 100, 20);
		
		Street=new JLabel("Street");
		Street.setBounds(150, 150, 100, 20);
		
		mobile=new JLabel("MobileNo");
		mobile.setBounds(150, 200, 100, 20);
		
		city=new JLabel("city");
		city.setBounds(150, 250, 100, 20);
		
		state=new JLabel("state");
		state.setBounds(150, 300, 100, 20);
		
		pincode=new JLabel("pincode");
		pincode.setBounds(150, 350, 100, 20);
		
		/*TextFieldrouteID=new JTextField(15);
		TextFieldrouteID.setBounds(300, 100, 200, 20);*/
		//TextFieldrouteID.setEditable(false);
		
		namet=new JTextField(15);
		namet.setBounds(300, 100, 200, 20);
		
		Streett=new JTextField(15);
		Streett.setBounds(300, 150, 200, 20);
		
		mobilet=new JTextField(10);
		mobilet.setBounds(300, 200, 200, 20);
		
		cityt=new JTextField(15);
		cityt.setBounds(300, 250, 200, 20);
		
		statet=new JTextField(15);
		statet.setBounds(300, 300, 200, 20);
		
		pincodet=new JTextField(15);
		pincodet.setBounds(300, 350, 200, 20);

		Buttonadd=new JButton("Add");
		Buttonadd.setBounds(200, 450, 100, 20);
		
		Buttoncancel=new JButton("Cancel");
		Buttoncancel.setBounds(320, 450, 100, 20);
		
		buttonBack=new JButton("Back");
		buttonBack.setBounds(440, 450, 100, 20);
		

		//frame.add(storeid);
		//frame.add(TextFieldrouteID);
		frame.add(name);
		frame.add(namet);
		frame.add(Street);
		frame.add(Streett);
		frame.add(mobile);
		frame.add(mobilet);
		frame.add(city);
		frame.add(cityt);
		frame.add(state);
		frame.add(statet);
		frame.add(pincode);
		frame.add(pincodet);
		frame.add(Buttonadd);
		frame.add(Buttoncancel);
		frame.add(buttonBack);
		
		Buttonadd.addActionListener(new Listener(this));
		Buttoncancel.addActionListener(new Listener(this));
		buttonBack.addActionListener(new Listener(this));
		
		frame.setVisible(true);
		
	}
	public static void main(String args[]){
		new StoreFrame();
	}
}
