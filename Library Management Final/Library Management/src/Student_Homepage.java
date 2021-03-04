import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTable;

public class Student_Homepage extends JFrame {

	public JPanel contentPane;
	int xx ,xy;
	Connection conn = null;
	private JTextField bname;
	private JTextField authorname;
	private JTable table;
	private JTextField upname;
	private JTextField upid;
	public static int userr;
	public static int st;
	private JTextField updept;
	private JTextField upemail;
	private JTextField uppassword;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_Homepage frame = new Student_Homepage();
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
	public Student_Homepage() {
		
		conn= Jconnection.ConnecrDb();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 992, 660);
		contentPane = new JPanel();
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				int x = arg0.getXOnScreen();
		        int y = arg0.getYOnScreen();
		        Student_Homepage.this.setLocation(x - xx, y - xy);
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx = e.getX();
		        xy = e.getY();
			}
		});
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel label_2 = new JLabel("X");
		label_2.setBackground(new Color(255, 255, 255));
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		
		label_2.setForeground(new Color(25, 25, 112));
		label_2.setFont(new Font("Tahoma", Font.BOLD, 28));
		label_2.setBounds(941, 11, 25, 27);
		contentPane.add(label_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(25, 25, 112));
		panel.setForeground(new Color(0, 0, 128));
		panel.setBounds(0, 0, 295, 660);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel search = new JLabel("SEARCH");
		search.setForeground(Color.WHITE);
		search.setFont(new Font("Calibri", Font.BOLD, 15));
		search.setHorizontalAlignment(SwingConstants.CENTER);
		search.setBounds(102, 214, 76, 19);
		panel.add(search);
		
		JLabel lblViewPreviousRecords = new JLabel("VIEW PREVIOUS RECORDS");
		lblViewPreviousRecords.setHorizontalAlignment(SwingConstants.CENTER);
		lblViewPreviousRecords.setForeground(Color.WHITE);
		lblViewPreviousRecords.setFont(new Font("Calibri", Font.BOLD, 15));
		lblViewPreviousRecords.setBounds(63, 357, 173, 19);
		panel.add(lblViewPreviousRecords);
		
		JLabel lblEditProfile = new JLabel("EDIT PROFILE");
		lblEditProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditProfile.setForeground(Color.WHITE);
		lblEditProfile.setFont(new Font("Calibri", Font.BOLD, 15));
		lblEditProfile.setBounds(85, 493, 114, 19);
		panel.add(lblEditProfile);
		
		JLabel lblLogout = new JLabel("LOGOUT");
		lblLogout.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogout.setForeground(Color.WHITE);
		lblLogout.setFont(new Font("Calibri", Font.BOLD, 15));
		lblLogout.setBounds(115, 617, 65, 19);
		panel.add(lblLogout);
		
		JLabel label = new JLabel("DASHBOARD");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Cambria", Font.BOLD, 20));
		label.setBounds(63, 80, 154, 39);
		panel.add(label);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(new ImageIcon(Student_Homepage.class.getResource("/image/user32_2.png")));
		lblNewLabel_3.setBounds(131, 20, 32, 32);
		panel.add(lblNewLabel_3);
		
		JLabel usernamee = new JLabel("USER");
		usernamee.setHorizontalAlignment(SwingConstants.CENTER);
		usernamee.setForeground(Color.WHITE);
		usernamee.setFont(new Font("Calibri", Font.BOLD, 15));
		usernamee.setBounds(63, 55, 165, 14);
		panel.add(usernamee);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(294, 55, 700, 608);
		contentPane.add(tabbedPane);
		
		JPanel searchpanel = new JPanel();
		searchpanel.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("SEARCH", null, searchpanel, null);
		searchpanel.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("BOOK NAME");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(94, 10, 100, 32);
		searchpanel.add(lblNewLabel_5);
		
		JLabel lblAuthorsName = new JLabel("AUTHOR'S NAME");
		lblAuthorsName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAuthorsName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAuthorsName.setBounds(51, 54, 143, 32);
		searchpanel.add(lblAuthorsName);
		
		bname = new JTextField();
		bname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bname.setBounds(204, 11, 312, 32);
		searchpanel.add(bname);
		bname.setColumns(10);
		
		authorname = new JTextField();
		authorname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		authorname.setColumns(10);
		authorname.setBounds(204, 54, 312, 32);
		searchpanel.add(authorname);
		
		JLabel lblNewLabel_6 = new JLabel("    BOOK_ID                   BOOK_NAME\t                BOOK_AUTHOR              VERSION              AVAILABILITY");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setBounds(10, 106, 675, 26);
		searchpanel.add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.setFont(new Font("Segoe Print", Font.BOLD, 16));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 128));
		btnNewButton.setBounds(540, 33, 109, 39);
		searchpanel.add(btnNewButton);
		
		table = new JTable();
		table.setBackground(new Color(240, 248, 255));
		table.setBounds(10, 137, 675, 419);
		searchpanel.add(table);
		
		JPanel editpanel = new JPanel();
		editpanel.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("EDIT PROFILE", null, editpanel, null);
		editpanel.setLayout(null);
		
		JLabel label_1 = new JLabel("NAME");
		label_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		label_1.setBounds(57, 23, 56, 23);
		editpanel.add(label_1);
		
		upname = new JTextField();
		upname.setFont(new Font("Calibri", Font.PLAIN, 18));
		upname.setColumns(10);
		upname.setBounds(57, 57, 328, 41);
		editpanel.add(upname);
		
		JLabel label_3 = new JLabel("ID");
		label_3.setFont(new Font("Calibri", Font.PLAIN, 18));
		label_3.setBounds(57, 109, 56, 23);
		editpanel.add(label_3);
		
		upid = new JTextField();
		upid.setFont(new Font("Calibri", Font.PLAIN, 18));
		upid.setColumns(10);
		upid.setBounds(57, 143, 328, 41);
		editpanel.add(upid);
		
		JLabel label_4 = new JLabel("DEPARTMENT");
		label_4.setFont(new Font("Calibri", Font.PLAIN, 18));
		label_4.setBounds(57, 197, 113, 23);
		editpanel.add(label_4);
		
		updept = new JTextField();
		updept.setFont(new Font("Calibri", Font.PLAIN, 18));
		updept.setColumns(10);
		updept.setBounds(57, 231, 328, 41);
		editpanel.add(updept);
		
		JLabel label_5 = new JLabel("EMAIL");
		label_5.setFont(new Font("Calibri", Font.PLAIN, 18));
		label_5.setBounds(57, 283, 56, 23);
		editpanel.add(label_5);
		
		upemail = new JTextField();
		upemail.setFont(new Font("Calibri", Font.PLAIN, 18));
		upemail.setColumns(10);
		upemail.setBounds(57, 318, 328, 41);
		editpanel.add(upemail);
		
		JLabel label_6 = new JLabel("PASSWORD");
		label_6.setFont(new Font("Calibri", Font.PLAIN, 18));
		label_6.setBounds(57, 370, 113, 23);
		editpanel.add(label_6);
		
		uppassword = new JTextField();
		uppassword.setFont(new Font("Calibri", Font.PLAIN, 18));
		uppassword.setColumns(10);
		uppassword.setBounds(57, 415, 328, 41);
		editpanel.add(uppassword);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(st==0)
				{
					try{
						String sql = "UPDATE student_info SET s_name=?,s_dept=?,s_email=?,s_password=? WHERE s_id=?";
						PreparedStatement pst= conn.prepareStatement(sql);
						pst.setNString(5,upid.getText());
						pst.setNString(1,upname.getText());
						pst.setNString(2,updept.getText());
						pst.setNString(3,upemail.getText());
						pst.setNString(4,uppassword.getText());
						
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null,"Updated Successfully");
					}
					catch(Exception e1){
						JOptionPane.showMessageDialog(null,"Error");
					}
				}
				else
				{
					try{
						String sql = "UPDATE teacher_info SET t_name=?,t_dept=?,t_email=?,t_password=? WHERE t_id=?";
						PreparedStatement pst= conn.prepareStatement(sql);
						pst.setNString(5,upid.getText());
						pst.setNString(1,upname.getText());
						pst.setNString(2,updept.getText());
						pst.setNString(3,upemail.getText());
						pst.setNString(4,uppassword.getText());
						
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null,"Updated Successfully");
					}
					catch(Exception e1){
						JOptionPane.showMessageDialog(null,"Error");
					}
				}
			}
		});
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("Segoe Print", Font.BOLD, 16));
		btnUpdate.setBackground(new Color(0, 0, 128));
		btnUpdate.setBounds(146, 470, 109, 39);
		editpanel.add(btnUpdate);
		
		JPanel viewpanel = new JPanel();
		viewpanel.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("VIEW RECORDS", null, viewpanel, null);
		viewpanel.setLayout(null);
		
		table_1 = new JTable();
		table_1.setBackground(new Color(240, 248, 255));
		table_1.setBounds(10, 59, 675, 476);
		viewpanel.add(table_1);
		
		JLabel lblNewLabel_4 = new JLabel("BOOK_ID");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(10, 34, 57, 14);
		viewpanel.add(lblNewLabel_4);
		
		JLabel lblIssuedate = new JLabel("ISSUE_DATE");
		lblIssuedate.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIssuedate.setBounds(193, 34, 77, 14);
		viewpanel.add(lblIssuedate);
		
		JLabel lblReturndate = new JLabel("TO_RETURN_DATE");
		lblReturndate.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblReturndate.setBounds(361, 34, 110, 14);
		viewpanel.add(lblReturndate);
		
		JLabel lblReturndate_1 = new JLabel("RETURN_DATE");
		lblReturndate_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblReturndate_1.setBounds(560, 34, 91, 14);
		viewpanel.add(lblReturndate_1);
		
		JLabel searchh = new JLabel("");
		searchh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tabbedPane.setSelectedIndex(0);
				showTableBook();
			}
		});
		searchh.setIcon(new ImageIcon(Student_Homepage.class.getResource("/image/search64.png")));
		searchh.setForeground(Color.WHITE);
		searchh.setBounds(115, 145, 65, 65);
		panel.add(searchh);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBounds(10, 114, 275, 2);
		panel.add(separator);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(2);
				showrecords();
			}
		});
		lblNewLabel.setIcon(new ImageIcon(Student_Homepage.class.getResource("/image/records64.png")));
		lblNewLabel.setBounds(115, 281, 65, 65);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ResultSet rs=null;
				tabbedPane.setSelectedIndex(1);
				if(st==0)
				{
					try{
						String sql= "select * from student_info where s_id ="+userr;
						PreparedStatement pst= conn.prepareStatement(sql);
						rs=pst.executeQuery();
						while(rs.next())
						{
							upid.setText(rs.getString("s_id"));
							upname.setText(rs.getString("s_name"));
							updept.setText(rs.getString("s_dept"));
							upemail.setText(rs.getString("s_email"));
							uppassword.setText(rs.getString("s_password"));
						}
						
						}
						catch(Exception ex){
							JOptionPane.showMessageDialog(null,"Error","Status",JOptionPane.INFORMATION_MESSAGE);
						}
				}
				else
				{
					try{
						String sql= "select * from teacher_info where t_id ="+userr;
						PreparedStatement pst= conn.prepareStatement(sql);
						rs=pst.executeQuery();
						while(rs.next())
						{
							upid.setText(rs.getString("t_id"));
							upname.setText(rs.getString("t_name"));
							updept.setText(rs.getString("t_dept"));
							upemail.setText(rs.getString("t_email"));
							uppassword.setText(rs.getString("t_password"));
						}
						
						}
						catch(Exception ex){
							JOptionPane.showMessageDialog(null,"Error","Status",JOptionPane.INFORMATION_MESSAGE);
						}
				}
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon(Student_Homepage.class.getResource("/image/edituser64.png")));
		lblNewLabel_1.setBounds(115, 417, 65, 65);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Homepage sh=new Homepage();
				sh.setUndecorated(true);
				sh.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_2.setIcon(new ImageIcon(Student_Homepage.class.getResource("/image/logout64.png")));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(115, 553, 65, 65);
		panel.add(lblNewLabel_2);
	}
	public void showrecords()
	{
		if(st==0){
			try{
				String sql= "select book_id,issue_date,toreturn_date,returned_date from student_status where student_id="+userr;	
				PreparedStatement pst= conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();
				table_1.setModel(DbUtils.resultSetToTableModel(rs));
				}
				catch(Exception e){
				JOptionPane.showMessageDialog(null, "Error");
				
				}
			
		}
		else{
			try{
				String sql= "select * from teacher_status where t_id="+userr;
				PreparedStatement pst= conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();
				table_1.setModel(DbUtils.resultSetToTableModel(rs));
				}
				catch(Exception e){
				JOptionPane.showMessageDialog(null, "Error");
				
				}
			
			}
	}

	public void showTableData() {
		try{
		String sql= "select * from student_info";
		PreparedStatement pst= conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		table_1.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(Exception e){
		JOptionPane.showMessageDialog(null, "Error");
		
		}
		
	}
	
	public void showTableBook() {
		try{
		String sql= "select b_id ,b_name,b_author,b_version from book_info where availability=1 and b_name like ? or b_author like CONCAT(%',?,%')";
		
		//String sql="select b_id ,b_name,b_author,b_version from book_info where availability=1 and locate("+ x +",b_name) or locate("+ y + ",b_author)";
		PreparedStatement pst= conn.prepareStatement(sql);
		//pst.setNString(1,bname.getText());
		//pst.setNString(2,authorname.getText());
		ResultSet rs = pst.executeQuery();
		table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(Exception e){
		JOptionPane.showMessageDialog(null, "Error");
		
		}
		
	}
}
