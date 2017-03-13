package com.wipro.pos.listener;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.wipro.pos.bean.CartBean;
import com.wipro.pos.bean.CredentialsBean;
import com.wipro.pos.bean.FoodBean;
import com.wipro.pos.bean.ProfileBean;
import com.wipro.pos.bean.StoreBean;
import com.wipro.pos.dao.FoodDAO;
import com.wipro.pos.service.Administrator;
import com.wipro.pos.service.Customer;
import com.wipro.pos.ui.AdminAdd;
import com.wipro.pos.ui.AdminDelete;
import com.wipro.pos.ui.AdminPassword;
import com.wipro.pos.ui.AdminUI;
import com.wipro.pos.ui.AdminUpdate;
import com.wipro.pos.ui.AdminView;
import com.wipro.pos.ui.AdminViewAll;
import com.wipro.pos.ui.ChangePassword;
import com.wipro.pos.ui.DeleteStoreFrame;
import com.wipro.pos.ui.Login;
import com.wipro.pos.ui.ModifyOrderFrame;
import com.wipro.pos.ui.ModifyStoreFrame;
import com.wipro.pos.ui.POSCustomerMainPageUI;
import com.wipro.pos.ui.POSCustomerRegisterationUI;
import com.wipro.pos.ui.POSModifyCartUI;
import com.wipro.pos.ui.POSViewFoodUI;
import com.wipro.pos.ui.StoreFrame;
import com.wipro.pos.ui.StoreView;
import com.wipro.pos.ui.ViewCustomerFrame;
import com.wipro.pos.ui.ViewOrderFrame;
import com.wipro.pos.ui.ViewStoreFrame;
import com.wipro.pos.ui.viewFoodById;
import com.wipro.pos.util.AuthenticationImpl;
import com.wipro.pos.util.UserImpl;

public class Listener extends MouseAdapter implements ActionListener {

	Login login;
	UserImpl user;
	CredentialsBean cb;
	AuthenticationImpl auth;
	AdminPassword adminPassword;
	AdminUI adminUI;
	Administrator administrator;
	FoodBean foodBean;
	AdminAdd adminAdd;
	 AdminDelete adminDelete;
	AdminUpdate adminUpdate;
	AdminViewAll adminViewAll;
	ChangePassword changePassword;
	StoreFrame storeFrame;
	ViewCustomerFrame viewCustomerFrame;
	AdminView adminView;
	private POSViewFoodUI posViewFoodUI;
	private POSModifyCartUI posModifyCartUI;
	public Listener (Login login){
		this.login=login;
	}
	public Listener(AdminUI adminUI) {
		// TODO Auto-generated constructor stub
		this.adminUI=adminUI;
	}
	public Listener(AdminPassword adminPassword) {
		// TODO Auto-generated constructor stub
		this.adminPassword=adminPassword;
	}
	public Listener(AdminAdd adminAdd) {
		// TODO Auto-generated constructor stub
		this.adminAdd=adminAdd;
	}
	public Listener(AdminDelete adminDelete) {
		// TODO Auto-generated constructor stub
		this.adminDelete=adminDelete;
	}
	public Listener(AdminUpdate adminUpdate) {
		// TODO Auto-generated constructor stub
		this.adminUpdate=adminUpdate;
	}
	public Listener(AdminViewAll adminViewAll) {
		// TODO Auto-generated constructor stub
		this.adminViewAll=adminViewAll;
	}
	public Listener(ChangePassword changePassword) {
		// TODO Auto-generated constructor stub
		this.changePassword=changePassword;
	}
	public Listener(StoreFrame storeFrame) {
		// TODO Auto-generated constructor stub
		this.storeFrame=storeFrame;
	}
	public Listener(ViewCustomerFrame viewCustomerFrame) {
		// TODO Auto-generated constructor stub
		this.viewCustomerFrame=viewCustomerFrame;
	}
	public Listener(AdminView adminView) {
		// TODO Auto-generated constructor stub
		this.adminView=adminView;
	}
	public Listener(POSViewFoodUI posViewFoodUI) {
		// TODO Auto-generated constructor stub
		this. posViewFoodUI= posViewFoodUI;
	}
	public Listener(POSModifyCartUI posModifyCartUI) {
		// TODO Auto-generated constructor stub
		this.posModifyCartUI=posModifyCartUI;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==Login.buttonLogin){
			if(Login.rememberBox.isSelected()){
				user=new UserImpl();
				/*if(user.remember(Login.textUserID.getText(),Login.textPassword.getText())==true){
				}*/
			}
			user= new UserImpl();
			cb=new CredentialsBean();
			if(Login.textUserID.getText().trim().isEmpty()||Login.textPassword.getText().trim().isEmpty()){
				JOptionPane.showMessageDialog(Login.frame, "Fields cannot be empty","Error",JOptionPane.ERROR_MESSAGE);
			}
			/*else if(Login.textUserID.getText().trim().length()<6&&(!Login.textUserID.getText().trim().equals("adminstrator"))){
				JOptionPane.showMessageDialog(Login.frame, "Invalid userid","Error",JOptionPane.ERROR_MESSAGE);
				Login.textUserID.setText("");
			}
			else if(Login.textUserID.getText().trim().length()<8&&(!Login.textUserID.getText().trim().equals("adminstrator"))){
				JOptionPane.showMessageDialog(Login.frame, "Password length too short","Error",JOptionPane.ERROR_MESSAGE);
				Login.textUserID.setText("");
			}*/
			else if(Login.textUserID.getText().trim().equals("Admins")&&Login.textPassword.getText().trim().equals("adminstrator")){
				Login.frame.setVisible(false);
				new AdminPassword();
			}
			else{
				cb.setUserID(Login.textUserID.getText().trim());
				cb.setPassword(Login.textPassword.getText().trim());
				String str=user.login(cb);
				if(str.equalsIgnoreCase("c")||str.equalsIgnoreCase("a")){
					if(str.equalsIgnoreCase("a")){
						auth = new AuthenticationImpl();
						try{
							auth.changeLoginStatus(cb,1);
							new AdminUI();
							Login.frame.setVisible(false);
						}catch(Exception e){
							e.printStackTrace();
						}
					}
					else{
						new POSCustomerMainPageUI();
						Login.frame.setVisible(false);
					}
				}
				else{
					JOptionPane.showMessageDialog(Login.frame, "Invalid User","Error",JOptionPane.ERROR_MESSAGE);
					Login.textUserID.setText("");
					Login.textPassword.setText("");
				}
			}
		}
/*if(arg0.getSource()==posModifyCartUI.buttonUpdate){
	Customer customer=new Customer();
	CartBean foodBean=new CartBean();
	
	if(posModifyCartUI.choice.getSelectedItem().trim().isEmpty())
	{
		JOptionPane.showMessageDialog(AdminUpdate.frame,"ID cann't be Empty","Error", JOptionPane.ERROR_MESSAGE);
	}
	else
		if(posModifyCartUI.choice.getSelectedItem().trim().length()<6)
		{
			JOptionPane.showMessageDialog(AdminUpdate.frame,"Invalid ID","Error", JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			customer.modifyCart(Login.textUserID.getText().trim());
			AdminUpdate.textFoodtName.setText(foodBean.getName());
			AdminUpdate.textFoodQuantity.setText(String.valueOf(foodBean.getQuantity()));
			AdminUpdate.textFoodPrice.setText(String.valueOf(foodBean.getPrice()));
			AdminUpdate.TextFoodSize.setText(foodBean.getFoodSize());
			AdminUpdate.textFoodID.setText(foodBean.getFoodID());
			AdminUpdate.textFoodType.setText(foodBean.getType());
		}
		}*/
		if(arg0.getSource()==Login.buttonSignUp){
			Login.frame.setVisible(false);
			new POSCustomerRegisterationUI();
		}
		if(arg0.getSource()==AdminPassword.buttonSubmit)
		{
			user=new UserImpl();
			cb=new CredentialsBean();
			cb.setUserID(Login.textUserID.getText().trim());
			System.out.println(Login.textUserID.getText().trim());
			char arr[]=Login.textPassword.getPassword();
			String password=new String(arr);
			password.trim();
			cb.setPassword(password);
			if(AdminPassword.textPassword.getText().trim().isEmpty()||AdminPassword.textReEnter.getText().trim().isEmpty())
			{
				JOptionPane.showMessageDialog(AdminPassword.frame,"Password can not be empty","Error", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				if(AdminPassword.textPassword.getText().trim().equals(AdminPassword.textReEnter.getText().trim()))
				{
					if(AdminPassword.textPassword.getText().trim().length()<7)
					{
						//JOptionPane.showMessageDialog(AdminPassword.frame,"Password length too short","Error", JOptionPane.ERROR_MESSAGE);
						AdminPassword.textPassword.setText("");
						AdminPassword.textReEnter.setText("");
					}
					else
				{
						char arr1[]=AdminPassword.textPassword.getPassword();
						String password1=new String(arr1);
						password1.trim();
						System.out.println(password1);
						String str=user.changePassword(cb,password1);
						System.out.println(str);
						if(str.equalsIgnoreCase("Success"))
						{
							JOptionPane.showMessageDialog(AdminPassword.frame,"Password Successfully Changed","Success",JOptionPane.PLAIN_MESSAGE);
						}
						else
						{
							JOptionPane.showMessageDialog(AdminPassword.frame,"Failure: Invalid UserId or password","Error", JOptionPane.ERROR_MESSAGE);
						}
						AdminPassword.frame.setVisible(false);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(AdminPassword.frame,"Password does not match","Error", JOptionPane.ERROR_MESSAGE);
					AdminPassword.textPassword.setText("");
					AdminPassword.textReEnter.setText("");
				}
			}
		}

		if(arg0.getSource()==AdminPassword.buttonCancel)
		{
			AdminPassword.textPassword.setText("");
			AdminPassword.textReEnter.setText("");
		}
		if(arg0.getSource()==AdminUI.item1Add)
		{
			AdminUI.frame.setVisible(false);
			new AdminAdd();
		}
		
		if(arg0.getSource()==AdminUI.buttonLogout)
		{
			user=new UserImpl();
			if(user.logout(Login.textUserID.getText())==true)
			{
				JOptionPane.showMessageDialog(AdminUI.frame,"Logout Successfull" ,"Logout", JOptionPane.PLAIN_MESSAGE);
				AdminUI.frame.dispose();;
			}
			else
			{
				JOptionPane.showMessageDialog(AdminUI.frame,"Logout UnSuccessfull- Try Again" ,"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if(arg0.getSource()==AdminUI.item1Delete)
		{
			AdminUI.frame.dispose();
			new AdminDelete();
		}
		if(arg0.getSource()==POSViewFoodUI.add){
			System.out.println("Wwwww");
			String id=POSViewFoodUI.choice.getSelectedItem().trim();
			FoodDAO DAO= new FoodDAO();
			String foodId=DAO.getId(id);
			FoodBean bean=DAO.findByID(foodId);
			CartBean cb=new CartBean();
			cb.setCartID(Integer.valueOf(POSViewFoodUI.cartid.getText().trim()));
			cb.setFoodID(bean.getFoodID());
			cb.setUserID(Login.textUserID.getText().trim());
			cb.setType(bean.getType());
			cb.setCost(bean.getPrice()*Integer.valueOf(POSViewFoodUI.quant.getText().trim()));
			cb.setQuantity(bean.getQuantity());
			cb.setOrderDate(new Date());
			Customer c= new Customer();
			int str=c.addToCart(cb);
			if(str==1){
				JOptionPane.showMessageDialog(POSViewFoodUI.frame,"added to cart" ,"adding", JOptionPane.PLAIN_MESSAGE);
			}
			else{
				JOptionPane.showMessageDialog(POSViewFoodUI.frame,"error" ,"adding", JOptionPane.PLAIN_MESSAGE);
			}
			//cb.setOrderDate();
		}
		if(arg0.getSource()==AdminUI.item1View){
			AdminUI.frame.dispose();
			new AdminView();
		}
		if(arg0.getSource()==AdminUI.item1Update)
		{
			AdminUI.frame.setVisible(false);
			new AdminUpdate();
		}
		
		if(arg0.getSource()==AdminUI.item1ViewAll)
		{
			AdminUI.frame.setVisible(false);
			new AdminViewAll();
			
			int i=0;
			 administrator = new Administrator();
			ArrayList<FoodBean> list=new ArrayList<FoodBean>();
			String col[]=new String[]{"Food ID","Food Name","Food Type","food size","Quantity","Price"};
			
			list=administrator.viewAllFood(null);
			String rows[][]=new String[list.size()][6];
			Iterator<FoodBean> itr=list.iterator();
			while(itr.hasNext())
			{
				 foodBean = new FoodBean();
				foodBean=itr.next();
				rows[i][0]=foodBean.getFoodID();
				rows[i][1]=foodBean.getName();
				rows[i][2]=foodBean.getType();
				rows[i][3]=foodBean.getFoodSize();
				rows[i][4]=String.valueOf(foodBean.getQuantity());
				rows[i][5]=String.valueOf(foodBean.getPrice());
				i++;
			}
			
			JTable tableViewAll=new JTable(rows,col);
			tableViewAll.setVisible(false);
			JScrollPane pane=new JScrollPane(tableViewAll);
			pane.setBounds(50, 50,500,300);
			((Container) AdminViewAll.frame).add(pane);
			tableViewAll.setVisible(true);
		}
		
		
		if(arg0.getSource()==AdminUI.item2Add)
		{
			AdminUI.frame.setVisible(false);
			new StoreFrame();
		}
		if(arg0.getSource()==AdminUI.item2View){
			AdminUI.frame.dispose();
			new StoreView();
		}
		if(arg0.getSource()==AdminUI.item2Update)
		{
			AdminUI.frame.setVisible(false);
			new ModifyStoreFrame();
		}
		
		if(arg0.getSource()==AdminUI.item2Delete)
		{
			AdminUI.frame.setVisible(false);
			new DeleteStoreFrame();
		}
		
		if(arg0.getSource()==AdminUI.item2ViewAll)
		{
			AdminUI.frame.setVisible(false);
			new ViewStoreFrame();
		}
		
		/*if(arg0.getSource()==AdminUI.item3Add)
		{
			AdminUI.frame.setVisible(false);
			new AddScheduleFrame();
		}*/
		
		if(arg0.getSource()==AdminUI.item3Update)
		{
			AdminUI.frame.setVisible(false);
			new ModifyOrderFrame();
		}
		
		/*if(arg0.getSource()==AdminUI.item3Delete)
		{
			AdminUI.frame.setVisible(false);
			new DeleteScheduleId();
		}*/
		
		if(arg0.getSource()==AdminUI.item3ViewAll)
		{
			AdminUI.frame.setVisible(false);
			new ViewOrderFrame();
		}
		if(arg0.getSource()==ViewCustomerFrame.buttonBack)
		{
			ViewCustomerFrame.frame.setVisible(false);
			AdminUI.frame.setVisible(true);
		}
		if(arg0.getSource()==AdminUI.item4View)
		{
			AdminUI.frame.setVisible(false);
			new ViewCustomerFrame();
			
			/*int i=0;
			 Administrator administrator = new Administrator();
			ArrayList<ProfileBean> list=new ArrayList<ProfileBean>();
			String col[]=new String[]{"User ID","First Name","Last Name","Date Of Birth","Gender","Street","Location","City","State","Pincode","Mobile No","Email"};
			
			list=administrator.viewAllCustomer();
			String rows[][]=new String[list.size()][12];
			Iterator<ProfileBean> itr=list.iterator();
			while(itr.hasNext())
			{
				 ProfileBean profileBean = new ProfileBean();
				 profileBean=itr.next();
				rows[i][0]=profileBean.getUserID();
				rows[i][1]=profileBean.getFirstName();
				rows[i][2]=profileBean.getLastName();
				rows[i][3]=profileBean.getDateOfBirth().toString();
				rows[i][4]=profileBean.getGender();
				rows[i][5]=profileBean.getStreet();
				rows[i][5]=profileBean.getLocation();
				rows[i][5]=profileBean.getCity();
				rows[i][5]=profileBean.getState();
				rows[i][5]=profileBean.getPincode();
				rows[i][5]=profileBean.getMobileNo();
				rows[i][5]=profileBean.getEmailID();
				i++;
			}
			
			JTable tableViewAll=new JTable(rows,col);
			tableViewAll.setVisible(false);
			JScrollPane pane=new JScrollPane(tableViewAll);
			pane.setBounds(50, 50,500,300);
			((Container) AdminViewAll.frame).add(pane);
			tableViewAll.setVisible(true);*/
			}
		
		
		if(arg0.getSource()==AdminAdd.buttonAdd)
		{
			administrator=new Administrator();
			foodBean=new FoodBean();
			if(AdminAdd.textFoodtName.getText().trim().isEmpty()||AdminAdd.textFoodPrice.getText().trim().isEmpty()||AdminAdd.textFoodQuantity.getText().trim().isEmpty()||AdminAdd.textFoodType.getText().trim().isEmpty()||AdminAdd.TextFoodSize.getText().trim().isEmpty())
			{
				JOptionPane.showMessageDialog(AdminAdd.frame,"Empty feilds" ,"Error", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				try
				{
					
					foodBean.setName(AdminAdd.textFoodtName.getText().trim());
					FoodDAO dao= new FoodDAO();
					String id;
					try {
						id = dao.generateFoodId(foodBean);
						System.out.println(id);
						foodBean.setFoodID(id);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					foodBean.setFoodSize(AdminAdd.TextFoodSize.getText().trim());
					foodBean.setType(AdminAdd.textFoodType.getText().trim());
					foodBean.setQuantity(Integer.valueOf(AdminAdd.textFoodQuantity.getText().trim()));
					foodBean.setPrice(Integer.valueOf(AdminAdd.textFoodPrice.getText().trim()));
					String str;
					try {
						str = administrator.addFood(foodBean);
						System.out.println(str);
						if(str.equalsIgnoreCase("Success")||str.equalsIgnoreCase("Fail"))
						{
							if(str.equalsIgnoreCase("Success"))
							{
								JOptionPane.showMessageDialog(Login.frame,"Food Successfully Added" ,"Success", JOptionPane.PLAIN_MESSAGE);
								AdminAdd.frame.setVisible(false);
								AdminUI.frame.setVisible(true);
							}
							//AdminAdd.frame.setVisible(false);
						}
						else
						{
							//System.out.println("dcs");
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				catch(NumberFormatException er)
				{
					JOptionPane.showMessageDialog(Login.frame,"Format for  food Name is Character and for seating capacity and reservation capacity is integer","Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			
			
		}
		
		if(arg0.getSource()==AdminAdd.buttonCancel)
		{
			AdminAdd.textFoodID.setText("");
			AdminAdd.textFoodQuantity.setText("");
			AdminAdd.textFoodtName.setText("");
			AdminAdd.textFoodPrice.setText("");
			AdminAdd.TextFoodSize.setText("");
			AdminAdd.textFoodType.setText("");
		}
		
		if(arg0.getSource()==AdminAdd.buttonBack)
		{
			
			AdminAdd.frame.setVisible(false);
			AdminUI.frame.setVisible(true);
		}
		if(arg0.getSource()==AdminView.buttonView){
			new viewFoodById();
		}
		if(arg0.getSource()==AdminView.buttonBack)
		{
			
			AdminView.frame.setVisible(false);
			AdminUI.frame.setVisible(true);
		}
		if(arg0.getSource()==AdminDelete.buttonDelete)
		{
			administrator=new Administrator();
			ArrayList<String> list=new ArrayList<String>();
			
			if(AdminDelete.choice.getSelectedItem().trim().isEmpty())
			{
				JOptionPane.showMessageDialog(AdminDelete.frame,"ID cann't be null","Error", JOptionPane.ERROR_MESSAGE);
			}
			else if(AdminDelete.choice.getSelectedItem().trim().length()<6)
			{
				JOptionPane.showMessageDialog(AdminDelete.frame,"Invalid ID","Error", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				list.add((AdminDelete.choice.getSelectedItem().trim()));
				if(administrator.removeFood(null,AdminDelete.choice.getSelectedItem().trim())==true)
				{
					JOptionPane.showMessageDialog(AdminDelete.frame,"Food Successfully Deleted","Success", JOptionPane.PLAIN_MESSAGE);
					
					AdminDelete.choice.removeAll();
					
					ArrayList<FoodBean> list1=new ArrayList<FoodBean>();
					Administrator administrator = new Administrator();
					list1=administrator.viewAllFood(null);
					
					Iterator<FoodBean> itr=list1.iterator();
					while(itr.hasNext())
					{
						FoodBean foodBean = new FoodBean();
						foodBean=itr.next();
						AdminDelete.choice.add(foodBean.getFoodID());
					}
				}
				else
				{
					JOptionPane.showMessageDialog(AdminDelete.frame,"Failure-IncorectID or Food is ordered","Error", JOptionPane.ERROR_MESSAGE);
					
				}
			}
		}
		
		if(arg0.getSource()==AdminDelete.buttonBack)
		{
			AdminDelete.frame.setVisible(false);;
			AdminUI.frame.setVisible(true);
			
		}
		if(arg0.getSource()==AdminUpdate.buttonUpdate)
		{
			foodBean=new FoodBean();
			administrator=new Administrator();
			if(AdminUpdate.textFoodtName.getText().trim().isEmpty()||AdminUpdate.textFoodPrice.getText().trim().isEmpty()||AdminUpdate.textFoodQuantity.getText().trim().isEmpty()||AdminUpdate.textFoodType.getText().trim().isEmpty()||AdminUpdate.TextFoodSize.getText().trim().isEmpty())
			{
				JOptionPane.showMessageDialog(AdminUpdate.frame,"Empty feilds" ,"Error", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				try
				{
					foodBean.setFoodID(AdminUpdate.choice.getSelectedItem());
					foodBean.setName(AdminUpdate.textFoodtName.getText().trim());
					foodBean.setQuantity(Integer.valueOf(AdminUpdate.textFoodQuantity.getText().trim()));
					foodBean.setPrice(Integer.valueOf(AdminUpdate.textFoodPrice.getText().trim()));
					foodBean.setFoodSize(AdminUpdate.TextFoodSize.getText().trim());
					foodBean.setType(AdminUpdate.textFoodType.getText().trim());
					if(administrator.modifyFood(foodBean)==true)
					{
							JOptionPane.showMessageDialog(AdminUpdate.frame,"Food successfully modified" ,"Success", JOptionPane.PLAIN_MESSAGE);
							
							AdminUpdate.choice.removeAll();
							
							ArrayList<FoodBean> list1=new ArrayList<FoodBean>();
							Administrator administrator = new Administrator();
							list1=administrator.viewAllFood(null);
							
							Iterator<FoodBean> itr=list1.iterator();
							while(itr.hasNext())
							{
								FoodBean foodBean = new FoodBean();
								foodBean=itr.next();
								AdminUpdate.choice.add(foodBean.getFoodID());
							}
					}
					else
					{
						JOptionPane.showMessageDialog(AdminUpdate.frame,"Failed-Incorrect FoodID" ,"Failure", JOptionPane.PLAIN_MESSAGE);
						AdminUpdate.textFoodtName.setText("");
						AdminUpdate.textFoodQuantity.setText("");
						AdminUpdate.textFoodPrice.setText("");
					//	AdminUpdate.textFoodID.setText("");
						AdminUpdate.textFoodType.setText("");
						AdminUpdate.TextFoodSize.setText("");
					}
				}
				catch(NumberFormatException er)
				{
					JOptionPane.showMessageDialog(AdminUpdate.frame,"Format changed","Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		
		
		if(arg0.getSource()==AdminUpdate.buttonCancel)
		{
			//AdminUpdate.choice.setName("");
			AdminUpdate.textFoodtName.setText("");
			AdminUpdate.textFoodQuantity.setText("");
			AdminUpdate.textFoodPrice.setText("");
			AdminUpdate.textFoodID.setText("");
			AdminUpdate.textFoodType.setText("");
			AdminUpdate.TextFoodSize.setText("");
		}
		
		if(arg0.getSource()==AdminUpdate.buttonBack)
		{
			AdminUpdate.frame.dispose();
			
			AdminUI.frame.setVisible(true);
		}
		
		if(arg0.getSource()==AdminUpdate.buttonView)
		{
			administrator=new Administrator();
			FoodBean foodBean=new FoodBean();
			
			if(AdminUpdate.choice.getSelectedItem().trim().isEmpty())
			{
				JOptionPane.showMessageDialog(AdminUpdate.frame,"ID cann't be Empty","Error", JOptionPane.ERROR_MESSAGE);
			}
			else
				if(AdminUpdate.choice.getSelectedItem().trim().length()<6)
				{
					JOptionPane.showMessageDialog(AdminUpdate.frame,"Invalid ID","Error", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					foodBean=administrator.viewFood(AdminUpdate.choice.getSelectedItem().trim());
					AdminUpdate.textFoodtName.setText(foodBean.getName());
					AdminUpdate.textFoodQuantity.setText(String.valueOf(foodBean.getQuantity()));
					AdminUpdate.textFoodPrice.setText(String.valueOf(foodBean.getPrice()));
					AdminUpdate.TextFoodSize.setText(foodBean.getFoodSize());
					AdminUpdate.textFoodID.setText(foodBean.getFoodID());
					AdminUpdate.textFoodType.setText(foodBean.getType());
				}
		}
		if(arg0.getSource()==AdminViewAll.buttonBack)
		{
			AdminUI.frame.setVisible(true);
			AdminViewAll.frame.setVisible(false);
		}
		if(arg0.getSource()==ChangePassword.buttonSubmit)
		{
			user=new UserImpl();
			cb=new CredentialsBean();
			if(ChangePassword.textUserID.getText().trim().isEmpty())
			{
				JOptionPane.showMessageDialog(ChangePassword.frame,"UserId can not be empty","Error", JOptionPane.ERROR_MESSAGE);
			}
			else 
				if(ChangePassword.textUserID.getText().trim().length()<6)
				{
					JOptionPane.showMessageDialog(ChangePassword.frame,"Invalid UserId","Error", JOptionPane.ERROR_MESSAGE);
					ChangePassword.textUserID.setText("");
				}
				else 
					if(ChangePassword.textOldPassword.getText().trim().isEmpty())
					{
						JOptionPane.showMessageDialog(ChangePassword.frame,"OldPassword can not be empty","Error", JOptionPane.ERROR_MESSAGE);
					}
					else 
						if(ChangePassword.textOldPassword.getText().trim().length()<8)
						{
							JOptionPane.showMessageDialog(ChangePassword.frame,"Invalid OldPassword","Error", JOptionPane.ERROR_MESSAGE);
							ChangePassword.textOldPassword.setText("");
						}
						else
							if(ChangePassword.textNewPassword.getText().trim().isEmpty())
							{
								JOptionPane.showMessageDialog(ChangePassword.frame,"New Password can not be empty","Error", JOptionPane.ERROR_MESSAGE);
							}
							else 
								if(ChangePassword.textNewPassword.getText().trim().length()<8)
								{
									JOptionPane.showMessageDialog(ChangePassword.frame,"New Password too short","Error", JOptionPane.ERROR_MESSAGE);
								}
								else
									if(!ChangePassword.textNewPassword.getText().trim().equals(ChangePassword.textReEnter.getText().trim()))
									{
										JOptionPane.showMessageDialog(ChangePassword.frame,"Password mismatch","Error", JOptionPane.ERROR_MESSAGE);
									}
									else
										if(ChangePassword.textUserID.getText().trim()==login.textUserID.getText().trim())
										{
									
										cb.setUserID(ChangePassword.textUserID.getText().trim());
										cb.setPassword(ChangePassword.textOldPassword.getText().trim());
										if(user.changePassword(cb, ChangePassword.textNewPassword.getText()).equalsIgnoreCase("Success"))
										{
											JOptionPane.showMessageDialog(ChangePassword.frame,"Password Successfully changed","Success", JOptionPane.PLAIN_MESSAGE);
											ChangePassword.frame.setVisible(false);
										}
										else
										{
											JOptionPane.showMessageDialog(ChangePassword.frame,"Invalid UserId or Password","Error", JOptionPane.ERROR_MESSAGE);
											ChangePassword.frame.setVisible(false);
										}
										
									}
										else
										{
											JOptionPane.showMessageDialog(ChangePassword.frame,"Invalid UserId or Password","Error", JOptionPane.ERROR_MESSAGE);
										}
		}
		
		
		if(arg0.getSource()==ChangePassword.buttonCancel)
		{
			ChangePassword.textUserID.setText("");
			ChangePassword.textOldPassword.setText("");
			ChangePassword.textNewPassword.setText("");
			ChangePassword.textReEnter.setText("");
		}
		
		if(arg0.getSource()==ChangePassword.buttonBack)
		{
			ChangePassword.frame.dispose();
		}
		if(arg0.getSource()==StoreFrame.Buttonadd)
		{
			
			String result="";
			if(StoreFrame.namet.getText().isEmpty()||StoreFrame.statet.getText().isEmpty()||StoreFrame.cityt.getText().isEmpty()||StoreFrame.mobilet.getText().isEmpty()||StoreFrame.pincodet.getText().isEmpty()||StoreFrame.Streett.getText().isEmpty())
			{
				result="Mandatory to fill all Fields";
				JOptionPane.showMessageDialog(StoreFrame.frame,result,"Error", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				try
				{  
					if(!StoreFrame.namet.getText().trim().matches("[a-zA-Z ]+"))
					{
						JOptionPane.showMessageDialog(StoreFrame.frame, "Please enter a valid character For name","Error", JOptionPane.ERROR_MESSAGE);
					}
					else 
						if(!StoreFrame.statet.getText().trim().matches("[a-zA-Z ]+"))
						{
							JOptionPane.showMessageDialog(StoreFrame.frame, "Please enter a valid character For state","Error", JOptionPane.ERROR_MESSAGE);
						}
						else 
							if(!StoreFrame.cityt.getText().trim().matches("[a-zA-Z ]+"))
							{
								JOptionPane.showMessageDialog(StoreFrame.frame, "Please enter a valid character For city","Error", JOptionPane.ERROR_MESSAGE);
							}
							 else
								 if(StoreFrame.mobilet.getText().trim().length()<10&&(!StoreFrame.statet.getText().trim().matches("[0-9]+")))
							{
									 System.out.println(StoreFrame.mobilet.getText().trim().length()<10);
									 System.out.println(!StoreFrame.statet.getText().trim().matches("[0-9]+"));
								JOptionPane.showMessageDialog(StoreFrame.frame, "mobile no should be of length 10 and should not contain alphabets","Error", JOptionPane.ERROR_MESSAGE);
								StoreFrame.mobilet.setText("");
								//RouteFrame.TextFieldfare.setText("");
							}
							 else 
								if(StoreFrame.Streett.getText().trim().isEmpty()||(!StoreFrame.namet.getText().trim().matches("[a-zA-Z ]+"))) 
								{
									JOptionPane.showMessageDialog(StoreFrame.frame, "Please enter valid street","Error", JOptionPane.ERROR_MESSAGE);
									StoreFrame.Streett.setText("");
								}
					            else 
					            	if(!(StoreFrame.pincodet.getText().trim().length()==6)&&(!StoreFrame.namet.getText().trim().matches("[0-9]+")))
						            {
						            	JOptionPane.showMessageDialog(StoreFrame.frame, "Pincode should be of length 6 and only numbers should be there","Error", JOptionPane.ERROR_MESSAGE);
						            	StoreFrame.pincodet.setText("");
						            }
						            else
									  {	
										administrator=new Administrator();
						                	
										StoreBean routeBean=new StoreBean();
										routeBean.setName(StoreFrame.namet.getText().trim());
										routeBean.setMobileNo(StoreFrame.mobilet.getText().trim());
										routeBean.setState(StoreFrame.statet.getText().trim());
										routeBean.setPincode(StoreFrame.pincodet.getText().trim());
										routeBean.setStreet(StoreFrame.Streett.getText().trim());
										routeBean.setCity(StoreFrame.cityt.getText().trim());
										//routeBean.setState(Integer.parseInt(StoreFrame.statet.getText().trim()));
									//	routeBean.setFare((Double.parseDouble(StoreFrame.TextFieldfare.getText().trim())));
										try {
											result = administrator.addStore(routeBean);
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
											
										//routeFrame.routeIDTextField.setText(routeBean.getRouteID());
										JOptionPane.showMessageDialog(StoreFrame.frame, result);
										if(result.equalsIgnoreCase("Success"))
										{
											StoreFrame.frame.setVisible(false);
											AdminUI.frame.setVisible(true);
										}
									  }	
					 }
					catch(NumberFormatException e1)
					{
						result = "Enter values";
						JOptionPane.showMessageDialog(StoreFrame.frame, result+"or Food is booked","Error", JOptionPane.ERROR_MESSAGE);
					}
			}
		}
		
		if(arg0.getSource()==StoreFrame.Buttoncancel)
		{
			StoreFrame.namet.setText("");
			StoreFrame.statet.setText("");
			StoreFrame.cityt.setText("");
			StoreFrame.Streett.setText("");
			StoreFrame.mobilet.setText("");
			StoreFrame.pincodet.setText("");
			//StoreFrame.t.setText("");
		}
		
		if(arg0.getSource()==StoreFrame.buttonBack)
		{
			AdminUI.frame.setVisible(true);
			StoreFrame.frame.setVisible(false);
			
		}
	/*	if(arg0.getSource()==AdminUI.buttonLogout)
		{
			user=new UserImpl();
			if(user.logout(Login.textUserID.getText())==true)
			{
				
				JOptionPane.showMessageDialog(AdminUI.frame,"Logout Successfull" ,"Logout", JOptionPane.PLAIN_MESSAGE);
				AdminUI.frame.dispose();;
			}
			else
			{
				JOptionPane.showMessageDialog(AdminUI.frame,"Logout UnSuccessfull- Try Again" ,"Error", JOptionPane.ERROR_MESSAGE);
			}
		}*/
	}

}
