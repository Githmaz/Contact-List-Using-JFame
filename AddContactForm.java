import javax.swing.*;
import javax.swing.border.EmptyBorder;

import contactStore.Contact;
import contactStore.ContactController;
import contactStore.Validation;

import java.awt.*;
import java.awt.event.*;


public class AddContactForm extends JFrame{
	private JLabel titleLabel;
	private JButton addButton;
	private JButton cancelButton;
	private JButton bthButton;
	
	private JLabel idLabel;
	private JLabel nameLabel;
	private JLabel contactNumLabel;
	private JLabel companyLabel;
	private JLabel birthdayLabel;
	private JLabel salaryLabel;
	private JLabel empty = new JLabel();

	private JTextField idText;
	private JTextField nameText;
	private JTextField companyText;
	private JTextField contactNumText;
	private JTextField birthdayText;
	private JTextField salaryText;
	
	
	AddContactForm(){
		setSize(550,650);
		setTitle("Add Contact");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
		setLocationRelativeTo(null);
		setLayout(new  BorderLayout());

//////////////////////////////////////////// TOP ///////////////////////////////////////////////////////////////////////////////////////////////////////

		Color darkBlue = new Color(150, 225, 255 );
		titleLabel=new JLabel("ADD CONTACT ");
		titleLabel.setFont(new Font("Arial Rounded MT Bold",1,35)); 
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setBorder(new EmptyBorder(30, 0, 30, 0));
		titleLabel.setOpaque(true);
		titleLabel.setBackground(darkBlue);
		add("North",titleLabel);



////////////////////////////////////////// Center //////////////////////////////////////////////////////////////////////////////////////////////////////////////

		///////______________________| Label panel  |___________________/////////

		JPanel labelPanel=new JPanel(new GridLayout(6,1));
		labelPanel.setBorder(BorderFactory.createEmptyBorder(-10, 10, 0 ,0));

		idLabel=new JLabel("Contact ID");
		nameLabel=new JLabel("Name");
		contactNumLabel=new JLabel("Contact Number");
		companyLabel=new JLabel("Company");
		salaryLabel=new JLabel("Salary");
		birthdayLabel = new JLabel("Birthday");

		idLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0 ,0));
		nameLabel.setBorder(BorderFactory.createEmptyBorder(0, 15, 0 ,0));
		contactNumLabel.setBorder(BorderFactory.createEmptyBorder(0, 15, 0 ,0));
		companyLabel.setBorder(BorderFactory.createEmptyBorder(0, 15, 0 ,0));
		salaryLabel.setBorder(BorderFactory.createEmptyBorder(0, 15, 0 ,0));
		birthdayLabel.setBorder(BorderFactory.createEmptyBorder(0, 15, 0 ,0));

		idLabel.setFont(new Font("",1,20));
		nameLabel.setFont(new Font("",1,20));
		contactNumLabel.setFont(new Font("",1,20));
		companyLabel.setFont(new Font("",1,20));
		salaryLabel.setFont(new Font("",1,20));
		birthdayLabel.setFont(new Font("",1,20));

		
		
		idText = new JTextField(); 
		generateId();

		labelPanel.add(idLabel);
		labelPanel.add(nameLabel);
		labelPanel.add(contactNumLabel);
		labelPanel.add(companyLabel);
		labelPanel.add(salaryLabel);
		labelPanel.add(birthdayLabel);
		
		


		///////______________________| Text panel |___________________/////////

		JPanel textPanel=new JPanel(new GridLayout(6,1 , 0,40));
		textPanel.setBorder(BorderFactory.createEmptyBorder(5,15,20, 75));

		nameText=new JTextField(15);
		contactNumText=new JTextField(15);
		companyText=new JTextField(15);
		salaryText=new JTextField(12);
		birthdayText=new JTextField(12);


		nameText.setFont(new Font("",0,18));
		contactNumText.setFont( new Font("",0,18));
		companyText.setFont(new Font("",0,18));
		salaryText.setFont(new Font("",0,18));
		birthdayText.setFont(new Font("",0,18));

		JPanel salaryPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel birthdayPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));


		salaryPanel.add(salaryText);
		birthdayPanel.add(birthdayText);
		textPanel.add(empty);
		textPanel.add(nameText);
		textPanel.add(contactNumText);
		textPanel.add(companyText);
		textPanel.add(salaryPanel);
		textPanel.add(birthdayPanel);
		
		
		add("Center", textPanel);
		add("West", labelPanel);
	}	

	private void generateId(){
		String lastId=ContactController.lastId();
		if(lastId==null){
			idLabel.setText("Contact ID - C0001");
			idText.setText("C0001");
		}else{
			String s=lastId.substring(1);
			int x=Integer.parseInt(s);
			lastId=String.format("C%04d",++x);
			idText.setText(lastId);
			idLabel.setText("Contact ID - "+lastId); 
		}
			
		
//////////////////////////////////////////// buttom ///////////////////////////////////////////////////////////////////////////////////////////////////////

		///////______________________| add Contact |___________________/////////
		
		addButton=new JButton("   Add Contact   ");
		addButton.setFont(new Font("",1,18)); 


		addButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String id=idText.getText();
				String name=nameText.getText();
				String contactNum = contactNumText.getText();
				String company = companyText.getText();
				double salary=Double.parseDouble(salaryText.getText());
				String birthday = birthdayText.getText();

				if(Validation.checkPhoneNumber(contactNum)){
					JOptionPane.showMessageDialog(null,"Invalid phone number");
					int op = JOptionPane.showOptionDialog(null, "Do you want to add Phone number again?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
					if(op==JOptionPane.YES_OPTION){
						contactNumText.setText("");
					}else{
						dispose();
						new HomePage().setVisible(true);
					}
				}else if(salary<0){
					JOptionPane.showMessageDialog(null,"Invalid salary");
					int op = JOptionPane.showOptionDialog(null, "Do you want to add salary  again?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
					if(op==JOptionPane.YES_OPTION){
						salaryText.setText("");
					}else{
						dispose();
						new HomePage().setVisible(true);
					}


				}else if(!Validation.b_Day_Checker(birthday)){
					JOptionPane.showMessageDialog(null,"Invalid birthday ");
					int op = JOptionPane.showOptionDialog(null, "Do you want to add Birthday  again?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
					if(op==JOptionPane.YES_OPTION){
						birthdayText.setText("");
					}else{
						dispose();
						 new HomePage().setVisible(true);
					}

				}else{
										
				Contact contact=new Contact(id,name, contactNum ,company,salary,birthday);
				boolean isAdded=ContactController.addContact(contact);
				if(isAdded){
					JOptionPane.showMessageDialog(null,"Added Success");
					int op = JOptionPane.showOptionDialog(null, "Do you want to add another contact?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
					if(op==JOptionPane.YES_OPTION){
						generateId();
						nameText.setText("");
						contactNumText.setText("");
						companyText.setText("");
						birthdayText.setText("");
						salaryText.setText("");
					}else{
						dispose();
						new HomePage().setVisible(true);
					}	
				}
				}
			}
			
		});
	///////______________________| Cancel  |___________________/////////
	
		cancelButton=new JButton("   Cancel   ");
		cancelButton.setFont(new Font("",1,18)); 
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				nameText.setText("");
				contactNumText.setText("");
				companyText.setText("");
				birthdayText.setText("");
				salaryText.setText("");
			}
		});

	///////______________________| back to home  |___________________/////////
		
		bthButton=new JButton("               Back to Home              "); //
		bthButton.setFont(new Font("",1,18)); 
		bthButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
			dispose();
			 new HomePage().setVisible(true);
			}
		});


		
		JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		topPanel.add(addButton);
		topPanel.add(cancelButton);

		JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		bottomPanel.add(bthButton);

		JPanel buttonPanel = new JPanel(new BorderLayout());
		buttonPanel.add(topPanel, BorderLayout.NORTH);
		buttonPanel.add(bottomPanel, BorderLayout.CENTER);
		
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 120, 0 ,-60));
		
		add(buttonPanel, BorderLayout.SOUTH);


	}

}

