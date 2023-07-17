import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;
 public class HomePage extends JFrame {
    private JLabel hp;
    private JButton btnAdd;
    private JButton btnUpd;
    private JButton btnSea;
    private JButton btnDele;
    private JButton btnView;
    private JButton btnExit;
    private JLabel title1;
    private JLabel title2;
    private  JLabel imageLabel;

    HomePage() {
        setSize(900, 550);
        setTitle("Home Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
       
        
        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();
       
        Color lightBlue = new Color(153, 153, 255 );

///////////////////////////////// Right Panel  //////////////////////////////////////////////

//-----------------------------------   Top     ---------------------------------------------------

        hp = new JLabel("Home Page");
        hp.setFont(new Font("Arial Rounded MT Bold", 1, 40));
        hp.setHorizontalAlignment(JLabel.CENTER);
        hp.setVerticalAlignment(JLabel.CENTER);
        hp.setBorder(new EmptyBorder(40, 0, 0, 0));


//-----------------------------------   Mid     ---------------------------------------------------

        rightPanel.setBackground(lightBlue);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(lightBlue);
        buttonPanel.setLayout(new GridLayout(5, 1, 0, 30));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(60, 75, 55, 75));

        btnAdd = new JButton("Add Contacts");
        btnUpd = new JButton("Update Contacts");
        btnSea = new JButton("Search Contacts");
        btnDele = new JButton("Delete Contacts");
        btnView = new JButton("View Contacts");

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnUpd);
        buttonPanel.add(btnSea);
        buttonPanel.add(btnDele);
        buttonPanel.add(btnView);

//----------------------------------   bottom   -----------------------------------------------	
		JPanel bottomPanel = new JPanel();
        btnExit = new JButton("Exit");
		bottomPanel.setBorder(BorderFactory.createEmptyBorder(0, 270, 0, 0));
		bottomPanel.setBackground(lightBlue);
		bottomPanel.add(btnExit);
		

 //----------------- Adding 
        rightPanel.setLayout(new BorderLayout());
        rightPanel.add(hp, BorderLayout.NORTH);
        rightPanel.add(buttonPanel, BorderLayout.CENTER);
        rightPanel.add(bottomPanel, BorderLayout.SOUTH);



//////////////////////////////// Left  Panel  ///////////////////////////////////////////////

        JPanel titlePanel = new JPanel();
        leftPanel.setBackground(new Color(255, 255, 255));
        titlePanel.setBackground(new Color(255, 255, 255));
        titlePanel.setLayout(new GridLayout(2,1,0, 0));
        title1 = new JLabel("iFRIEND");
        title1.setBorder(BorderFactory.createEmptyBorder(0,75, 0, 0));
        title2 = new JLabel("Contact Manager");
        title1.setFont(new Font("Arial Rounded MT Bold", 1, 40));
        title2.setFont(new Font("Arial Rounded MT Bold", 1, 40));
        titlePanel.add(title1);
        titlePanel.add(title2);
        title1.setVerticalAlignment(JLabel.CENTER);

    ///////////         image     //////////////////////////////////////////////
        ImageIcon imageIcon = new ImageIcon("assets/Pic.jpg");
        imageLabel = new JLabel();
        imageLabel.setIcon(imageIcon);

        leftPanel.add("North",titlePanel);
        leftPanel.add("Center",imageLabel);
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
        splitPane.setDividerLocation(400);

        add(splitPane);
        setVisible(true);
  


///////______________________| add button action|___________________/////////
         btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
               dispose();
                new AddContactForm().setVisible(true);
               
            }
        });

///////______________________| Update button action|___________________/////////
         btnUpd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
                new UpdateContactForm().setVisible(true);
            }
        });

///////______________________| Search button action|___________________/////////
        btnSea.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            dispose();
            new SearchContactForm().setVisible(true);
        }
    });

///////______________________| Delete button action|___________________/////////
        btnDele.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
           dispose();
            new DeleteContactForm().setVisible(true);
        }
    });

///////______________________| View button action|___________________/////////
        btnView.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
           dispose();
            new ViewMenu().setVisible(true);
        }
    });

///////______________________| Exit button action|___________________/////////
         btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
               dispose();
            }
        });




    }

    public static void main(String args[]){
		  SwingUtilities.invokeLater(() -> new HomePage());
    }

}
