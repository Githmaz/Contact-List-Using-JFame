import javax.swing.*;

import contactStore.Contact;
import contactStore.ContactController;

import java.awt.*;
import java.awt.event.*;

public class SearchContactForm extends JFrame {
    private JLabel titleLabel;
    private JButton searchButton;
    private JButton bthButton;

	private JLabel idLabel;
	private JLabel nameLabel;
	private JLabel contactNumLabel;
	private JLabel companyLabel;
	private JLabel birthdayLabel;
	private JLabel salaryLabel;
	private JLabel empty = new JLabel();

    private JTextField idText = new JTextField(null);
	private JTextField nameText;
	private JTextField companyText;
	private JTextField contactNumText;
	private JTextField birthdayText;
	private JTextField salaryText;
    private JTextField searchText;



    SearchContactForm() {
        setSize(550, 700);
        setTitle("Search Contact ");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

//////////////////////////////////////////// TOP  panel ///////////////////////////////////////////////////////////////////////////////////////////////////////
      
        JPanel topPanel=new JPanel(new GridLayout(2,1 ,0 , 0));

        JPanel titlePanel = new JPanel();
        titleLabel = new JLabel("Search Contact");
        titleLabel.setFont(new Font("Arial Rounded MT Bold", 1, 35));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titlePanel.setBackground(new Color(221, 160, 221));
        titlePanel.add(titleLabel, BorderLayout.CENTER);
        titlePanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 0 ,0));
        topPanel.add(titlePanel);

        JPanel searchbar = new JPanel(new FlowLayout(FlowLayout.LEFT));

        searchText = new JTextField(15);
        searchText.setFont(new Font("", 0, 25));

        searchButton=new JButton("Search");
        searchButton.setFont(new Font("",1,20));
        


        searchbar.add(searchText);
        searchbar.add(searchButton);
        searchbar.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        topPanel.add(searchbar);

        add("North",topPanel);
        
/////////////////////////////////// Center panel ///////////////////////////////////////////////////////////


		///////______________________| Label panel  |___________________/////////

		JPanel labelPanel=new JPanel(new GridLayout(6,1 , 0 , 0));
		labelPanel.setBorder(BorderFactory.createEmptyBorder(-30, 10, 0 ,0));

		idLabel=new JLabel("Contact ID");
		nameLabel=new JLabel("Name");
		contactNumLabel=new JLabel("Contact Number");
		companyLabel=new JLabel("Company");
		salaryLabel=new JLabel("Salary");
		birthdayLabel = new JLabel("Birthday");

		idLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, -10 ,0));
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



		labelPanel.add(idLabel);
		labelPanel.add(nameLabel);
		labelPanel.add(contactNumLabel);
		labelPanel.add(companyLabel);
		labelPanel.add(salaryLabel);
		labelPanel.add(birthdayLabel);



		///////______________________| Text panel |___________________/////////

		JPanel textPanel=new JPanel(new GridLayout(6,1 , 0,40));
		textPanel.setBorder(BorderFactory.createEmptyBorder(0,15,20, 75));

		nameText=new JTextField(15);
		contactNumText=new JTextField(15);
		companyText=new JTextField(15);
		salaryText=new JTextField(12);
		birthdayText=new JTextField(12);

        searchButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
                String input = searchText.getText();
                Contact contact = ContactController.searchContact(input);
                if (contact != null){
                    idText.setText(contact.getId());
					idLabel.setText("Contact ID - "+ contact.getId());
                    nameText.setText(contact.getName());
                    contactNumText.setText(contact.getContactNum());
                    companyText.setText(contact.getCompany());
                    salaryText.setText(""+contact.getSalary());
                    birthdayText.setText(contact.getBirthday());
                } else {
					
                    idText.setText(null);
                    nameText.setText("");
					contactNumText.setText("");
					companyText.setText("");
					birthdayText.setText("");
					salaryText.setText("");
                    JOptionPane.showMessageDialog(null, "Contact not found...!");
                }
            }
        });

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
		
		
		nameText.setEditable(false);
		contactNumText.setEditable(false);
		companyText.setEditable(false);
		salaryText.setEditable(false);
		birthdayText.setEditable(false);

		add("Center", textPanel);
		add("West", labelPanel);

	


///////______________________| back to home  |___________________/////////
		
		bthButton=new JButton("               Back to Home              "); //
		bthButton.setFont(new Font("",1,18)); 
		bthButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
			dispose();
			 new HomePage().setVisible(true);
			}
		});

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(bthButton);
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 120, 0 ,-80));
		
		add(buttonPanel, BorderLayout.SOUTH);



    }
}
