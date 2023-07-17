
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;

import contactStore.Contact;
import contactStore.ContactController;

import java.awt.*;
import java.awt.event.*;

public class SortingAndTable extends JFrame {
    Contact [] tothetable;
    private JTable contactTable;
	private DefaultTableModel dtm;
	private JLabel titleLabel;
    private JButton btnBacktohome;

   public  SortingAndTable(int type){

////////////////////////////////////////// processing ////////////////////////////////////////////////////////////////////////

    switch (type) {
        case 0 : 	tothetable = ContactController.getAllContactSortByName();break;
        case 1 :   tothetable = ContactController.getAllContactSortBySalary();break;
        case 2 :	tothetable = ContactController.getAllContactSortByBday();break;
    }


////////////////////////////////////////////// 	 Designing   //////////////////////////////////////////////////////////

		setSize(700,500);
		setTitle("View Contact Details");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
		setLocationRelativeTo(null);
		setVisible(true);


//_________________________          top          ___________________________//
        String [] by ={"NAME","SALARY","BIRTHDAY"};
		JPanel topJPanel = new JPanel();
		titleLabel=new JLabel("LIST CONTACTS BY "+by[type]);
		titleLabel.setFont(new Font("Arial Rounded MT Bold",1,35)); 
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setBorder(new EmptyBorder(12, 0, 12, 0));
		topJPanel.setBackground(new Color(	102, 178, 255));
		topJPanel.add(titleLabel);
		
		add("North",topJPanel);
	
//_________________________          mid          ___________________________//	

		String[] columnNames={"Contact Id","Name","Number","Company","Salary","Birth Day"};
		dtm=new DefaultTableModel(columnNames,0);
		contactTable=new JTable(dtm);
		JScrollPane tablePane=new JScrollPane(contactTable);
		add("Center",tablePane);

		JTableHeader header = contactTable.getTableHeader();
		header.setBackground(new Color(160,160,160));
		
		dtm.setRowCount(0);
		for (int i = 0; i < tothetable.length; i++){
			Contact contact=tothetable[i];
			Object[] rowData={contact.getId(),contact.getName(), contact.getContactNum(),contact.getCompany(),contact.getSalary(),contact.getBirthday()};
			dtm.addRow(rowData);
				
		}
				
    ///////______________________| bottom |___________________/////////
		JPanel bottomPanel=new JPanel();
		btnBacktohome = new JButton("     Back to Home     ");
		bottomPanel.add(btnBacktohome);
		bottomPanel.setBorder(BorderFactory.createEmptyBorder(5,450, 5, 0));
		btnBacktohome.setFont(new Font("", 1, 18));
    	btnBacktohome.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evt) {
        		dispose();
            	new HomePage().setVisible(true);
        }
    });
		add("South", bottomPanel);
		

    }
  
    

    
}
