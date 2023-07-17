
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;

public class ViewMenu extends JFrame{
    
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JPanel midPanel;
    private JLabel titelLabel;
    private JButton btnLBName;
    private JButton btnLBSalary;
    private JButton btnLBBirthday;
    private JButton btnCancel;
    

    public ViewMenu(){
        setSize(700, 500);
        setTitle("View Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
       
//////////////////////////////////////////// TOP ///////////////////////////////////////////////////////////////////////////////////////////////////////
        topPanel = new JPanel();
        topPanel.setBackground(new Color(	102, 178, 255));
        titelLabel = new JLabel("Contact List");
        titelLabel.setFont(new Font("Arial Rounded MT Bold", 1, 42));
        titelLabel.setBorder(new EmptyBorder(20, 0, 20, 0));
        topPanel.add(titelLabel);   

//////////////////////////////////////////// Mid  ///////////////////////////////////////////////////////////////////////////////////////////////////////
        
        midPanel = new JPanel();
        midPanel.setLayout(new GridLayout(3, 1, 50, 35));
        midPanel.setBorder(BorderFactory.createEmptyBorder(40, 120, 40, 120));

        btnLBName   = new JButton("LIst by Name"); 
        btnLBSalary = new JButton("List by Salary");
        btnLBBirthday = new JButton("List by Birthday");
        
        Font font  =   new Font("", 1, 20);
        btnLBName.setFont(font);
        btnLBBirthday.setFont(font);
        btnLBSalary.setFont(font);

        midPanel.add(btnLBName);
        midPanel.add(btnLBSalary);
        midPanel.add(btnLBBirthday);




////////////////////////////////////////////   bottom  ///////////////////////////////////////////////////////////////////////////////////////////////////////        
 
    bottomPanel = new JPanel();
    btnCancel = new JButton("  Cancel  ");
    btnCancel.setFont(font);
    bottomPanel.add(btnCancel);
    bottomPanel.setBorder(BorderFactory.createEmptyBorder(0, 500, 20, 0));

    
    add("North",topPanel);
    add("South",bottomPanel);
    add("Center",midPanel);


////////////////////////////////////////// buttons actions //////////////////////////////////////////////////////////////////////////////////////////////////////

    ///////______________________| Cancel |___________________/////////
    btnCancel.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
        dispose();
            new HomePage().setVisible(true);
        }
    });
    
  ///////______________________| List by Name |___________________/////////

    btnLBName.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
        dispose();
        new SortingAndTable(0).setVisible(true);
        }
    });
    ///////______________________| List by Salary |___________________/////////

    btnLBSalary.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
        dispose();
        new SortingAndTable(1).setVisible(true);
        }
    });


      ///////______________________| List by Birthday |___________________/////////

    btnLBBirthday.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
        dispose();
        new SortingAndTable(2).setVisible(true);
        }
    });

    }


}