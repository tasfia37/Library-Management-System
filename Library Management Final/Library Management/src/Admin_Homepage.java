import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JSeparator;
import java.awt.Button;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;

public class Admin_Homepage extends JFrame {

	private JPanel contentPane;
	int xx ,xy;
	Connection conn = null;
	private JLabel dash;
	private JLabel addbookicon;
	private JLabel lblNewLabel_2;
	private JLabel lblDeleteBook;
	private JLabel lblIssuereturnABook;
	private JLabel ViewBookRecords;
	private JLabel ViewUserRecords;
	private JLabel lblAddAdmin;
	private JLabel lblRemoveAMember;
	private JLabel lblEditProfile;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JTextField bookname;
	private JTextField authorname;
	private JTextField version;
	private JPanel viewbook;
	private JPanel viewusers;
	private JTextField book;
	private JLabel lblEnterBookId;
	private JTextField name;
	private JLabel lblEnterBookName_1;
	private JButton btnViewBook;
	private JTable table;
	private JTable table_delete;
	private JButton btnDelete;
	private JTextField bookinput;
	private JTextField input2;
	private JLabel lblBookId;
	private JLabel lblStudentteacherId;
	private JTextField BID;
	private JTable table_2;
	private JTextField UID;
	private JButton buttongo;
	private JTable table_3;
	private JPanel panel_1;
	private JTable table_4;
	private JTextField inputid;
	private JLabel lblEnterId;
	private JButton btnApprove;
	private JPanel removemember;
	private JRadioButton stremove;
	private JRadioButton tremove;
	private JRadioButton aremove;
	private JTextField idinput;
	private JTextField nameinput;
	private JLabel lblEnterId_1;
	private JLabel lblEnterName;
	private JButton btnRemove;
	private JMenuBar menuBar;
	private JMenuBar menuBar_1;
	private JMenuBar menuBar_2;
	private JMenu mnSettings;
	private JMenuBar menuBar_3;
	private JMenuBar menuBar_4;
	private JLabel label_8;
	private JLabel lblEmail;
	private JLabel lblPassword;
	private JTextField adname;
	private JTextField ademail;
	private JTextField adpass;
	private JButton button;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup1 = new ButtonGroup();
	public static int adminn;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private final ButtonGroup buttonGroup3 = new ButtonGroup();
	private final ButtonGroup buttonGroup5 = new ButtonGroup();
	private final ButtonGroup removegroup = new ButtonGroup();
	static boolean r,b;
	private int stet,ir,stek;
	private JLabel lblNewLabel_7;
	private String anamee;
	private String aemaill;
	private String apasswordd;
	private int idx;
	private int bookidinput;
	private int useridinput;
	private JLabel lblNewLabel_8;
	private JRadioButton radio_student;
	private JRadioButton radio_teacher;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Homepage frame = new Admin_Homepage();
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Admin_Homepage() {
		conn= Jconnection.ConnecrDb();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 992, 660);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx = e.getX();
		        xy = e.getY();
			}
		});
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
		        int y = e.getYOnScreen();
		        Admin_Homepage.this.setLocation(x - xx, y - xy);
			}
		});
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		lblNewLabel.setForeground(new Color(128, 0, 128));
		lblNewLabel.setBackground(new Color(128, 0, 128));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblNewLabel.setBounds(942, 0, 50, 50);
		contentPane.add(lblNewLabel);
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(94, 4, 140));
		panel.setBounds(0, 0, 295, 660);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 255, 255));
		separator.setBackground(new Color(255, 255, 255));
		separator.setBounds(10, 116, 274, 9);
		panel.add(separator);
		
		
		JPanel hidebar = new JPanel();
		hidebar.setBackground(new Color(255, 255, 255));
		hidebar.setBounds(294, 21, 698, 85);
		contentPane.add(hidebar);
		JLabel lblNewLabel_1;
		
		//JLabel lblNewLabel_1;
		dash = new JLabel("DASHBOARD");
		dash.setFont(new Font("Cambria", Font.BOLD, 23));
		dash.setForeground(new Color(255, 255, 255));
		dash.setHorizontalAlignment(SwingConstants.CENTER);
		dash.setBounds(67, 66, 154, 39);
		panel.add(dash);
		
		addbookicon = new JLabel("");
		addbookicon.setIcon(new ImageIcon(Admin_Homepage.class.getResource("/image/addadmin.png")));
		addbookicon.setHorizontalAlignment(SwingConstants.CENTER);
		addbookicon.setBounds(37, 415, 26, 26);
		panel.add(addbookicon);
		
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(Admin_Homepage.class.getResource("/image/deletemember.png")));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(37, 465, 26, 26);
		panel.add(label);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Admin_Homepage.class.getResource("/image/bookrecords.png")));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(37, 365, 26, 26);
		panel.add(label_1);
		
		label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Admin_Homepage.class.getResource("/image/studentrecords.png")));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(37, 315, 26, 26);
		panel.add(label_2);
		
		label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(Admin_Homepage.class.getResource("/image/deletebook.png")));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(37, 215, 26, 26);
		panel.add(label_3);
		
		label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(Admin_Homepage.class.getResource("/image/issue.png")));
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(37, 265, 26, 26);
		panel.add(label_4);
		
		label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(Admin_Homepage.class.getResource("/image/settings.png")));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(37, 515, 26, 26);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(Admin_Homepage.class.getResource("/image/addbook.png")));
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(37, 163, 26, 26);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(Admin_Homepage.class.getResource("/image/logoutadmin.png")));
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBounds(37, 565, 26, 26);
		panel.add(label_7);
		
		JLabel lblLogout = new JLabel("LOGOUT");
		lblLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Admin_login sh=new Admin_login();
				sh.setUndecorated(true);
				sh.setVisible(true);
				dispose();
			}
		});
		lblLogout.setForeground(new Color(211, 211, 211));
		lblLogout.setFont(new Font("Calibri", Font.BOLD, 16));
		lblLogout.setBounds(65, 565, 95, 25);
		panel.add(lblLogout);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Admin_Homepage.class.getResource("/image/user32.png")));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(20, 11, 32, 32);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("ADMIN");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_4.setBounds(17, 50, 122, 14);
		panel.add(lblNewLabel_4);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(294, 55, 700, 608);
		contentPane.add(tabbedPane);
		
		JPanel addbookpanel = new JPanel();
		addbookpanel.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("ADD BOOK", null, addbookpanel, null);
		addbookpanel.setLayout(null);
		
		bookname = new JTextField();
		bookname.setFont(new Font("Calibri", Font.PLAIN, 18));
		bookname.setColumns(10);
		bookname.setBounds(153, 87, 328, 41);
		addbookpanel.add(bookname);
		
		authorname = new JTextField();
		authorname.setFont(new Font("Calibri", Font.PLAIN, 18));
		authorname.setColumns(10);
		authorname.setBounds(153, 188, 328, 41);
		addbookpanel.add(authorname);
		
		version = new JTextField();
		version.setFont(new Font("Calibri", Font.PLAIN, 18));
		version.setColumns(10);
		version.setBounds(153, 291, 328, 41);
		addbookpanel.add(version);
		
		JLabel lblEnterBookName = new JLabel("ENTER BOOK NAME");
		lblEnterBookName.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblEnterBookName.setBounds(153, 53, 193, 23);
		addbookpanel.add(lblEnterBookName);
		
		JLabel lblEnterAuthorsName = new JLabel("ENTER AUTHOR'S NAME");
		lblEnterAuthorsName.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblEnterAuthorsName.setBounds(153, 154, 219, 23);
		addbookpanel.add(lblEnterAuthorsName);
		
		JLabel lblVersion = new JLabel("VERSION");
		lblVersion.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblVersion.setBounds(153, 257, 100, 23);
		addbookpanel.add(lblVersion);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String sql= "insert into book_info"+"(b_name,b_author,b_version,availability)"+"values(?,?,?,1)";
					PreparedStatement pst= conn.prepareStatement(sql);
					pst.setNString(1,bookname.getText());
					pst.setNString(2,authorname.getText());
					pst.setNString(3,version.getText());
					
					
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Added Successfully","Status",JOptionPane.INFORMATION_MESSAGE);
					}
					catch(Exception e3){
						JOptionPane.showMessageDialog(null,"Error","Status",JOptionPane.INFORMATION_MESSAGE);
					}
			}
		});
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAdd.setBorderPainted(false);
		btnAdd.setBackground(new Color(94, 4, 140));
		btnAdd.setBounds(239, 343, 133, 47);
		addbookpanel.add(btnAdd);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("DELETE BOOK", null, panel_2, null);
		panel_2.setLayout(null);
		
		book = new JTextField();
		book.setBounds(38, 62, 189, 31);
		panel_2.add(book);
		book.setFont(new Font("Calibri", Font.PLAIN, 16));
		book.setColumns(10);
		
		lblEnterBookId = new JLabel("ENTER BOOK ID");
		lblEnterBookId.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblEnterBookId.setBounds(38, 38, 133, 23);
		panel_2.add(lblEnterBookId);
		
		name = new JTextField();
		name.setFont(new Font("Calibri", Font.PLAIN, 16));
		name.setColumns(10);
		name.setBounds(269, 62, 242, 31);
		panel_2.add(name);
		
		lblEnterBookName_1 = new JLabel("ENTER BOOK NAME");
		lblEnterBookName_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblEnterBookName_1.setBounds(269, 38, 160, 23);
		panel_2.add(lblEnterBookName_1);
		
		btnViewBook = new JButton("VIEW BOOK");
		btnViewBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showTableBook1();
			}
		});
		btnViewBook.setForeground(Color.WHITE);
		btnViewBook.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnViewBook.setBorderPainted(false);
		btnViewBook.setBackground(new Color(94, 4, 140));
		btnViewBook.setBounds(536, 62, 133, 31);
		panel_2.add(btnViewBook);
		
		
		table_delete = new JTable();
		table_delete.setBorder(new LineBorder(new Color(175, 238, 238)));
		table_delete.setBackground(new Color(240, 255, 255));
		table_delete.setBounds(10, 159, 671, 276);
		panel_2.add(table_delete);
		
		btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String sql = "delete from book_info where b_id=? and b_name=? ";
					PreparedStatement pst= conn.prepareStatement(sql);
					pst.setNString(1,book.getText());
					pst.setNString(2,name.getText());
	
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Deleted Successfully");
				}
				catch(Exception e1){
					JOptionPane.showMessageDialog(null,"Error");
				}
			}
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete.setBorderPainted(false);
		btnDelete.setBackground(new Color(94, 4, 140));
		btnDelete.setBounds(269, 446, 133, 31);
		panel_2.add(btnDelete);
		
		lblNewLabel_5 = new JLabel("    BOOK_ID                   BOOK_NAME                BOOK_AUTHOR              VERSION              AVAILABILITY");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(10, 118, 675, 26);
		panel_2.add(lblNewLabel_5);
		
		viewbook = new JPanel();
		viewbook.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("VIEW BOOKS", null, viewbook, null);
		viewbook.setLayout(null);
		
		BID = new JTextField();
		BID.setFont(new Font("Calibri", Font.PLAIN, 16));
		BID.setColumns(10);
		BID.setBounds(234, 16, 266, 31);
		viewbook.add(BID);
		
		JLabel lblEnterBookId_1 = new JLabel("ENTER BOOK ID");
		lblEnterBookId_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblEnterBookId_1.setBounds(91, 19, 133, 23);
		viewbook.add(lblEnterBookId_1);
		
		JButton btnGo = new JButton("GO");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showTableBookRecord();
			}
		});
		btnGo.setForeground(Color.WHITE);
		btnGo.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGo.setBorderPainted(false);
		btnGo.setBackground(new Color(94, 4, 140));
		btnGo.setBounds(526, 16, 107, 31);
		viewbook.add(btnGo);
		
		/*label_9 = new JLabel(" STATUS_ID            USER_NAME\t          BOOK_ID          ISSUE_DATE          TO_RETURN_DATE     RETURN_DATE");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_9.setBounds(0, 130, 685, 26);
		viewbook.add(label_9);*/
		
		table_2 = new JTable();
		table_2.setBorder(new LineBorder(new Color(175, 238, 238)));
		table_2.setBackground(new Color(240, 255, 255));
		table_2.setBounds(10, 181, 675, 388);
		viewbook.add(table_2);
		
		lblNewLabel_6 = new JLabel(" STATUS_ID            USER_ID          BOOK_ID          ISSUE_DATE          TO_RETURN_DATE     RETURN_DATE");
		lblNewLabel_6.setBounds(0, 130, 685, 26);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		viewbook.add(lblNewLabel_6);
		
		JRadioButton radioButton_1 = new JRadioButton("STUDENT");
		radioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_1.isSelected()){
					 b=true;
				}
			}
		});
		radioButton_1.setFont(new Font("Calibri", Font.PLAIN, 15));
		buttonGroup.add(radioButton_1);
		radioButton_1.setBounds(148, 85, 109, 23);
		viewbook.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("TEACHER");
		radioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radioButton_2.isSelected()){
					 b=true;
				}
			}
		});
		radioButton_2.setFont(new Font("Calibri", Font.PLAIN, 15));
		buttonGroup.add(radioButton_2);
		radioButton_2.setBounds(401, 85, 109, 23);
		viewbook.add(radioButton_2);
		
		
		JPanel issue_return = new JPanel();
		issue_return.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("ISSUE_RETURN", null, issue_return, null);
		issue_return.setLayout(null);
		
		bookinput = new JTextField();
		bookinput.setFont(new Font("Calibri", Font.PLAIN, 18));
		bookinput.setColumns(10);
		bookinput.setBounds(120, 87, 328, 41);
		issue_return.add(bookinput);
		
		input2 = new JTextField();
		input2.setFont(new Font("Calibri", Font.PLAIN, 18));
		input2.setColumns(10);
		input2.setBounds(120, 237, 328, 41);
		issue_return.add(input2);
		
		lblBookId = new JLabel("BOOK ID :");
		lblBookId.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblBookId.setBounds(120, 53, 193, 23);
		issue_return.add(lblBookId);
		
		lblStudentteacherId = new JLabel("STUDENT/TEACHER ID :");
		lblStudentteacherId.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblStudentteacherId.setBounds(120, 203, 193, 23);
		issue_return.add(lblStudentteacherId);
		
		JRadioButton student = new JRadioButton("STUDENT");
		student.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(student.isSelected())
				{
					stek=1;
				}
			}
		});
		student.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonGroup.add(student);
		student.setBounds(150, 160, 109, 23);
		issue_return.add(student);
		
		JRadioButton teacher = new JRadioButton("TEACHER");
		teacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(teacher.isSelected())
				{
					stek=2;
				}
			}
		});
		teacher.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonGroup.add(teacher);
		teacher.setBounds(287, 160, 109, 23);
		issue_return.add(teacher);
		
		JRadioButton issue = new JRadioButton("ISSUE");
		issue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(issue.isSelected())
				{
					ir=1;
				}
			}
		});
		issue.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonGroup1.add(issue);
		issue.setBounds(150, 301, 109, 23);
		issue_return.add(issue);
		
		JRadioButton returnn = new JRadioButton("RETURN");
		returnn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(returnn.isSelected())
				{
					ir=2;
				}
			}
		});
		returnn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonGroup1.add(returnn);
		returnn.setBounds(301, 301, 109, 23);
		issue_return.add(returnn);
		
		JButton btnProceed = new JButton("PROCEED");
		btnProceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookidinput=Integer.parseInt(bookinput.getText());
				useridinput=Integer.parseInt(input2.getText());
				if(ir==1)
				{
					if(stek==1)
					{
						try{
							String sql= "insert into student_status (student_id,book_id,issue_date) values("+ useridinput +","+ bookidinput +",SYSDATE())";
							PreparedStatement pst= conn.prepareStatement(sql);					
							pst.executeUpdate();
							sql= "update book_info set availability=0 where b_id="+bookidinput;
							 pst= conn.prepareStatement(sql);					
							pst.executeUpdate();							
							JOptionPane.showMessageDialog(null,"Book Issued Successfully","Status",JOptionPane.INFORMATION_MESSAGE);
							}
							catch(Exception e3){
								JOptionPane.showMessageDialog(null,"Error","Status",JOptionPane.INFORMATION_MESSAGE);
							}
					}
					else
					{
						try{
							String sql= "insert into teacher_status (teacher_id,book_id,issue_date) values("+ useridinput +","+ bookidinput +",SYSDATE())";
							PreparedStatement pst= conn.prepareStatement(sql);					
							pst.executeUpdate();
							sql= "update book_info set availability=0 where b_id="+bookidinput;
							 pst= conn.prepareStatement(sql);					
							pst.executeUpdate();							
							JOptionPane.showMessageDialog(null,"Book Issued Successfully","Status",JOptionPane.INFORMATION_MESSAGE);
							}
							catch(Exception e3){
								JOptionPane.showMessageDialog(null,"Error","Status",JOptionPane.INFORMATION_MESSAGE);
							}
					}
				}
				else
				{
					if(stek==1)
					{
						try{
							String sql= "update student_status set returned_date = SYSDATE() where book_id="+bookidinput;
							PreparedStatement pst= conn.prepareStatement(sql);					
							pst.executeUpdate();
							sql= "update book_info set availability=1 where b_id="+bookidinput;
							 pst= conn.prepareStatement(sql);					
							pst.executeUpdate();							
							JOptionPane.showMessageDialog(null,"Book Returned Successfully","Status",JOptionPane.INFORMATION_MESSAGE);
							}
							catch(Exception e3){
								JOptionPane.showMessageDialog(null,"Error","Status",JOptionPane.INFORMATION_MESSAGE);
							}
					}
					else
					{
						try{
							String sql= "update teacher_status set returned_date = SYSDATE() where book_id="+bookidinput;
							PreparedStatement pst= conn.prepareStatement(sql);					
							pst.executeUpdate();
							sql= "update book_info set availability=1 where b_id="+bookidinput;
							 pst= conn.prepareStatement(sql);					
							pst.executeUpdate();							
							JOptionPane.showMessageDialog(null,"Book Returned Successfully","Status",JOptionPane.INFORMATION_MESSAGE);
							}
							catch(Exception e3){
								JOptionPane.showMessageDialog(null,"Error","Status",JOptionPane.INFORMATION_MESSAGE);
							}
					}
				}
			}
		});
		btnProceed.setForeground(Color.WHITE);
		btnProceed.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnProceed.setBorderPainted(false);
		btnProceed.setBackground(new Color(94, 4, 140));
		btnProceed.setBounds(315, 345, 133, 41);
		issue_return.add(btnProceed);
		
		viewusers = new JPanel();
		viewusers.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("VIEW USERS", null, viewusers, null);
		viewusers.setLayout(null);
		
		JLabel lblEnterUserId = new JLabel("ENTER USER ID");
		lblEnterUserId.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblEnterUserId.setBounds(90, 64, 133, 23);
		viewusers.add(lblEnterUserId);
		
		UID = new JTextField();
		UID.setFont(new Font("Calibri", Font.PLAIN, 16));
		UID.setColumns(10);
		UID.setBounds(234, 61, 266, 31);
		viewusers.add(UID);
		
		buttongo = new JButton("GO");
		buttongo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showTableUserRecord();
			}
		});
		buttongo.setForeground(Color.WHITE);
		buttongo.setFont(new Font("Tahoma", Font.BOLD, 14));
		buttongo.setBorderPainted(false);
		buttongo.setBackground(new Color(94, 4, 140));
		buttongo.setBounds(526, 59, 107, 31);
		viewusers.add(buttongo);
		
		table_3 = new JTable();
		table_3.setBorder(new LineBorder(new Color(175, 238, 238)));
		table_3.setBackground(new Color(240, 255, 255));
		table_3.setBounds(10, 179, 675, 401);
		viewusers.add(table_3);
		
		lblNewLabel_8 = new JLabel(" STATUS_ID            USER_ID   \t          BOOK_ID          ISSUE_DATE          TO_RETURN_DATE     RETURN_DATE");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_8.setBounds(10, 154, 675, 14);
		viewusers.add(lblNewLabel_8);
		
		JRadioButton radio_student = new JRadioButton("STUDENT");
		radio_student.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radio_student.isSelected()){
					 r=true;
				}
			}
		});
		buttonGroup5.add(radio_student);
		radio_student.setFont(new Font("Calibri", Font.PLAIN, 15));
		radio_student.setBounds(203, 99, 109, 23);
		viewusers.add(radio_student);
		
		JRadioButton radio_teacher = new JRadioButton("TEACHER");
		radio_teacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(radio_teacher.isSelected()){
					 r=false;
				}
			}
		});
		buttonGroup5.add(radio_teacher);
		radio_teacher.setFont(new Font("Calibri", Font.PLAIN, 15));
		radio_teacher.setBounds(410, 99, 109, 23);
		viewusers.add(radio_teacher);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("ADD_ADMIN", null, panel_1, null);
		panel_1.setLayout(null);
		
		table_4 = new JTable();
		table_4.setForeground(new Color(0, 0, 0));
		table_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		table_4.setBorder(new LineBorder(new Color(175, 238, 238)));
		table_4.setBackground(new Color(240, 255, 255));
		table_4.setBounds(10, 64, 671, 392);
		panel_1.add(table_4);
		
		inputid = new JTextField();
		inputid.setFont(new Font("Calibri", Font.PLAIN, 16));
		inputid.setColumns(10);
		inputid.setBounds(202, 467, 266, 31);
		panel_1.add(inputid);
		
		lblEnterId = new JLabel("ENTER ID");
		lblEnterId.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblEnterId.setBounds(118, 470, 87, 23);
		panel_1.add(lblEnterId);
		
		btnApprove = new JButton("APPROVE");
		btnApprove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idx=Integer.parseInt(inputid.getText());
				
				
				try{
					String sql= "select r_name,r_email,r_password from adminrequest where r_id ="+ idx;
					PreparedStatement pst= conn.prepareStatement(sql);
					ResultSet rs=pst.executeQuery();
					while(rs.next())
					{
						anamee=rs.getString("r_name");
						aemaill=rs.getString("r_email");
						apasswordd=rs.getString("r_password");
					}
					
					}
					catch(Exception ex){
						JOptionPane.showMessageDialog(null,"Error","Status",JOptionPane.INFORMATION_MESSAGE);
					}
				
				try{
					String sql= "insert into admin_info"+"(a_name,a_email,a_password)"+"values(?,?,?)";
					PreparedStatement pst= conn.prepareStatement(sql);
					pst.setNString(1,anamee);
					pst.setNString(2,aemaill);
					pst.setNString(3,apasswordd);			
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Admin Approved Successfully","Status",JOptionPane.INFORMATION_MESSAGE);
					}
					catch(Exception e3){
						JOptionPane.showMessageDialog(null,"Error","Status",JOptionPane.INFORMATION_MESSAGE);
					}
				
				try{
					String sql = "delete from adminrequest where r_id="+idx;
					PreparedStatement pst= conn.prepareStatement(sql);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Deleted from requests Successfully");
				}
				catch(Exception e1){
					JOptionPane.showMessageDialog(null,"Error");
				}
				showrequests();
			}
		});
		btnApprove.setForeground(Color.WHITE);
		btnApprove.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnApprove.setBorderPainted(false);
		btnApprove.setBackground(new Color(94, 4, 140));
		btnApprove.setBounds(478, 465, 107, 31);
		panel_1.add(btnApprove);
		
		lblNewLabel_7 = new JLabel(" STATUS_ID                          NAME                                   EMAIL                                  APPROVAL");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7.setBounds(10, 50, 671, 14);
		panel_1.add(lblNewLabel_7);
		
		removemember = new JPanel();
		removemember.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("REMOVE MEMBER", null, removemember, null);
		removemember.setLayout(null);
		
		stremove = new JRadioButton("STUDENT");
		stremove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(stremove.isSelected())
				{
					stet=1;
				}
			}
		});
		stremove.setBounds(143, 71, 97, 29);
		removegroup.add(stremove);
		stremove.setFont(new Font("Tahoma", Font.PLAIN, 16));
		removemember.add(stremove);
		
		tremove = new JRadioButton("TEACHER");
		tremove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tremove.isSelected())
				{
					stet=2;
				}
			}
		});
		removegroup.add(tremove);
		tremove.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tremove.setBounds(309, 74, 109, 23);
		removemember.add(tremove);
		
		aremove = new JRadioButton("ADMIN");
		aremove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(aremove.isSelected())
				{
					stet=3;
				}
			}
		});
		removegroup.add(aremove);
		aremove.setFont(new Font("Tahoma", Font.PLAIN, 16));
		aremove.setBounds(459, 74, 109, 23);
		removemember.add(aremove);
		
		idinput = new JTextField();
		idinput.setFont(new Font("Calibri", Font.PLAIN, 18));
		idinput.setColumns(10);
		idinput.setBounds(154, 203, 328, 41);
		removemember.add(idinput);
		
		nameinput = new JTextField();
		nameinput.setFont(new Font("Calibri", Font.PLAIN, 18));
		nameinput.setColumns(10);
		nameinput.setBounds(154, 322, 328, 41);
		removemember.add(nameinput);
		
		lblEnterId_1 = new JLabel("ENTER ID");
		lblEnterId_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblEnterId_1.setBounds(154, 169, 193, 23);
		removemember.add(lblEnterId_1);
		
		lblEnterName = new JLabel("ENTER NAME");
		lblEnterName.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblEnterName.setBounds(154, 288, 193, 23);
		removemember.add(lblEnterName);
		
		btnRemove = new JButton("REMOVE");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(stet==1)
				{
					try{
						String sql = "delete from student_info where s_id=? and s_name=? ";
						PreparedStatement pst= conn.prepareStatement(sql);
						pst.setNString(1,idinput.getText());
						pst.setNString(2,nameinput.getText());	
						
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null,"Member Removed Successfully");
					}
					catch(Exception e1){
						JOptionPane.showMessageDialog(null,"Error");
					}
				}
				else if(stet==2)
				{
					try{
						String sql = "delete from teacher_info where t_id=? and t_name=? ";
						PreparedStatement pst= conn.prepareStatement(sql);
						pst.setNString(1,idinput.getText());
						pst.setNString(2,nameinput.getText());
						
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null,"Member Removed Successfully");
					}
					catch(Exception e1){
						JOptionPane.showMessageDialog(null,"Error");
					}	
				}
				else
				{
					try{
						String sql = "delete from admin_info where a_id=? and a_name=? ";
						PreparedStatement pst= conn.prepareStatement(sql);
						pst.setNString(1,idinput.getText());
						pst.setNString(2,nameinput.getText());
		
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null,"Member Removed Successfully");
					}
					catch(Exception e1){
						JOptionPane.showMessageDialog(null,"Error");
					}
				}
			}
		});
		btnRemove.setForeground(Color.WHITE);
		btnRemove.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnRemove.setBorderPainted(false);
		btnRemove.setBackground(new Color(94, 4, 140));
		btnRemove.setBounds(245, 395, 133, 47);
		removemember.add(btnRemove);
		
		JPanel editprofile = new JPanel();
		editprofile.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("EDIT PROFILE", null, editprofile, null);
		editprofile.setLayout(null);
		
		label_8 = new JLabel("NAME :");
		label_8.setForeground(Color.BLACK);
		label_8.setFont(new Font("Calibri", Font.BOLD, 22));
		label_8.setBounds(196, 87, 111, 27);
		editprofile.add(label_8);
		
		lblEmail = new JLabel("EMAIL :");
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Calibri", Font.BOLD, 22));
		lblEmail.setBounds(196, 187, 111, 27);
		editprofile.add(lblEmail);
		
		lblPassword = new JLabel("PASSWORD :");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Calibri", Font.BOLD, 22));
		lblPassword.setBounds(196, 288, 129, 27);
		editprofile.add(lblPassword);
		
		adname = new JTextField();
		adname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		adname.setText("");
		adname.setColumns(10);
		adname.setBackground(Color.WHITE);
		adname.setBounds(196, 125, 295, 40);
		editprofile.add(adname);
		
		ademail = new JTextField();
		ademail.setText("");
		ademail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ademail.setColumns(10);
		ademail.setBackground(Color.WHITE);
		ademail.setBounds(196, 225, 295, 40);
		editprofile.add(ademail);
		
		adpass = new JTextField();
		adpass.setText("");
		adpass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		adpass.setColumns(10);
		adpass.setBackground(Color.WHITE);
		adpass.setBounds(196, 326, 295, 40);
		editprofile.add(adpass);
		
		button = new JButton("UPDATE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String sql = "UPDATE admin_info SET a_name=?,a_email=?,a_password=? WHERE a_id=?";
					PreparedStatement pst= conn.prepareStatement(sql);
					pst.setNString(1,adname.getText());
					pst.setNString(2,ademail.getText());
					pst.setNString(3,adpass.getText());
					pst.setNString(4,Integer.toString(adminn));
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Updated Successfully");
				}
				catch(Exception e1){
					JOptionPane.showMessageDialog(null,"Error");
				}
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Segoe Print", Font.BOLD, 16));
		button.setBackground(new Color(75, 0, 130));
		button.setBounds(282, 377, 109, 39);
		editprofile.add(button);
		
		lblNewLabel_2 = new JLabel("ADD BOOK");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 18));
		lblNewLabel_2.setForeground(new Color(211, 211, 211));
		lblNewLabel_2.setBounds(65, 165, 95, 25);
		panel.add(lblNewLabel_2);
		
		lblDeleteBook = new JLabel("DELETE BOOK");
		lblDeleteBook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		lblDeleteBook.setForeground(new Color(211, 211, 211));
		lblDeleteBook.setFont(new Font("Calibri", Font.BOLD, 18));
		lblDeleteBook.setBounds(65, 215, 122, 25);
		panel.add(lblDeleteBook);
		
		lblIssuereturnABook = new JLabel("ISSUE/RETURN A BOOK");
		lblIssuereturnABook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(3);
			}
		});
		lblIssuereturnABook.setForeground(new Color(211, 211, 211));
		lblIssuereturnABook.setFont(new Font("Calibri", Font.BOLD, 16));
		lblIssuereturnABook.setBounds(65, 265, 172, 25);
		panel.add(lblIssuereturnABook);
		
		
		ViewBookRecords = new JLabel("VIEW BOOK RECORDS");
		ViewBookRecords.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		ViewBookRecords.setForeground(new Color(211, 211, 211));
		ViewBookRecords.setFont(new Font("Calibri", Font.BOLD, 16));
		ViewBookRecords.setBounds(65, 315, 172, 25);
		panel.add(ViewBookRecords);
		
		ViewUserRecords = new JLabel("VIEW USER RECORDS");
		ViewUserRecords.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(4);
			}
		});
		ViewUserRecords.setForeground(new Color(211, 211, 211));
		ViewUserRecords.setFont(new Font("Calibri", Font.BOLD, 16));
		ViewUserRecords.setBounds(65, 365, 172, 25);
		panel.add(ViewUserRecords);
		
		lblAddAdmin = new JLabel("ADD ADMIN");
		lblAddAdmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(5);
				showrequests();
			}
		});
		lblAddAdmin.setForeground(new Color(211, 211, 211));
		lblAddAdmin.setFont(new Font("Calibri", Font.BOLD, 16));
		lblAddAdmin.setBounds(65, 415, 95, 25);
		panel.add(lblAddAdmin);
		
		lblRemoveAMember = new JLabel("REMOVE A MEMBER");
		lblRemoveAMember.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(6);
			}
		});
		lblRemoveAMember.setForeground(new Color(211, 211, 211));
		lblRemoveAMember.setFont(new Font("Calibri", Font.BOLD, 16));
		lblRemoveAMember.setBounds(65, 465, 154, 25);
		panel.add(lblRemoveAMember);
		
		
		lblEditProfile = new JLabel("EDIT PROFILE");
		lblEditProfile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ResultSet rs=null;
				tabbedPane.setSelectedIndex(7);
				try{
					String sql= "select a_name,a_email,a_password from admin_info where a_id ="+adminn;
					PreparedStatement pst= conn.prepareStatement(sql);
					rs=pst.executeQuery();
					while(rs.next())
					{
						adname.setText(rs.getString("a_name"));
						ademail.setText(rs.getString("a_email"));
						adpass.setText(rs.getString("a_password"));
					}
					
					}
					catch(Exception ex){
						JOptionPane.showMessageDialog(null,"Error","Status",JOptionPane.INFORMATION_MESSAGE);
					}
			}
		});
		lblEditProfile.setForeground(new Color(211, 211, 211));
		lblEditProfile.setFont(new Font("Calibri", Font.BOLD, 16));
		lblEditProfile.setBounds(65, 515, 95, 25);
		panel.add(lblEditProfile);
		
		
		
	
	}
	public void showTableBookRecord() {
		if(b==true){
			try{
				String sql= "select * from student_status where book_id=?";	
				PreparedStatement pst= conn.prepareStatement(sql);
				pst.setNString(1,BID.getText());
				ResultSet rs = pst.executeQuery();
				table_2.setModel(DbUtils.resultSetToTableModel(rs));
				}
				catch(Exception e){
				JOptionPane.showMessageDialog(null, "Error");
				
				}
			
		}
		else{
			try{
				String sql= "select * from teacher_status where book_id=?";
				PreparedStatement pst= conn.prepareStatement(sql);
				pst.setNString(1,BID.getText());
				ResultSet rs = pst.executeQuery();
				table_2.setModel(DbUtils.resultSetToTableModel(rs));
				}
				catch(Exception e){
				JOptionPane.showMessageDialog(null, "Error");
				
				}
			
			}
		}
	public void showrequests()
	{
		try{
			String sql= "select r_id,r_name,r_email,approval from adminrequest";	
			PreparedStatement pst= conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			table_4.setModel(DbUtils.resultSetToTableModel(rs));
			}
			catch(Exception e){
			JOptionPane.showMessageDialog(null, "Error");
			
			}
	}
	
	public void showTableUserRecord() {
		if(r==true){
			try{
				String sql= "select * from student_status where student_id=?";	
				PreparedStatement pst= conn.prepareStatement(sql);
				pst.setNString(1,UID.getText());
				ResultSet rs = pst.executeQuery();
				table_3.setModel(DbUtils.resultSetToTableModel(rs));
				}
				catch(Exception e){
				JOptionPane.showMessageDialog(null, "Error");
				
				}
			
		}
		else{
			try{
				String sql= "select * from teacher_status where teacher_id=?";
				PreparedStatement pst= conn.prepareStatement(sql);
				pst.setNString(1,UID.getText());
				ResultSet rs = pst.executeQuery();
				table_3.setModel(DbUtils.resultSetToTableModel(rs));
				}
				catch(Exception e){
				JOptionPane.showMessageDialog(null, "Error");
				
				}
			
			}
		}
	
	public void showTableBook1() {
		try{
		String sql= "select * from book_info where b_id=? and b_name=?";
		
		PreparedStatement pst= conn.prepareStatement(sql);
		pst.setNString(1,book.getText());
		pst.setNString(2,name.getText());
		ResultSet rs = pst.executeQuery();
		table_delete.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(Exception e){
		JOptionPane.showMessageDialog(null, "Error");
		
		}
		
	}
}
