import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin_login extends JFrame {

	private JPanel contentPane;
	int xx ,xy;
	private JTextField adminuserid;
	private JPasswordField adminpass;
	private JTextField nameinput;
	private JPasswordField passwordinput;
	Connection conn = null;
	public int logid;
	public String logpass;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_login frame = new Admin_login();
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
	public Admin_login() {
		conn= Jconnection.ConnecrDb();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 992, 660);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
		        int y = e.getYOnScreen();
		        Admin_login.this.setLocation(x - xx, y - xy);
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx = e.getX();
		        xy = e.getY();
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("X");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Tahoma", Font.BOLD, 28));
		label.setBounds(941, 11, 25, 27);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				Homepage ad=new Homepage();
				ad.setUndecorated(true);
				ad.setVisible(true);
			}
		});
		label_1.setIcon(new ImageIcon(Admin_login.class.getResource("/image/back.png")));
		label_1.setBackground(Color.WHITE);
		label_1.setBounds(10, 14, 64, 64);
		contentPane.add(label_1);
		
		JLabel lblNotAnAdmin = new JLabel("NOT AN ADMIN? ");
		lblNotAnAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblNotAnAdmin.setForeground(new Color(25, 25, 112));
		lblNotAnAdmin.setFont(new Font("Calibri", Font.ITALIC, 19));
		lblNotAnAdmin.setBounds(674, 93, 152, 21);
		contentPane.add(lblNotAnAdmin);
		
		JLabel label_5 = new JLabel("SIGNUP");
		label_5.setBackground(new Color(51, 153, 204));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(new Color(0, 153, 204));
		label_5.setFont(new Font("Calibri", Font.BOLD, 31));
		label_5.setBounds(687, 116, 129, 36);
		contentPane.add(label_5);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 153, 204));
		panel_1.setBounds(0, 0, 496, 674);
		contentPane.add(panel_1);
		
		JLabel label_6 = new JLabel("");
		label_6.setBackground(Color.WHITE);
		label_6.setBounds(10, 11, 64, 64);
		panel_1.add(label_6);
		
		JLabel lblNewLabel_3 = new JLabel("LOGIN AS ADMIN");
		lblNewLabel_3.setBounds(47, 80, 399, 51);
		panel_1.add(lblNewLabel_3);
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Calibri", Font.BOLD, 34));
		
		JLabel lblUserid = new JLabel("USERID");
		lblUserid.setBounds(202, 245, 135, 27);
		panel_1.add(lblUserid);
		lblUserid.setForeground(new Color(255, 255, 255));
		lblUserid.setFont(new Font("Calibri", Font.BOLD, 25));
		
		adminuserid = new JTextField();
		adminuserid.setBounds(109, 283, 295, 40);
		panel_1.add(adminuserid);
		adminuserid.setText("");
		adminuserid.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(148, 225, 44, 49);
		panel_1.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(Admin_login.class.getResource("/image/admin.png")));
		
		JLabel label_3 = new JLabel("PASSWORD");
		label_3.setBounds(192, 382, 125, 27);
		panel_1.add(label_3);
		label_3.setForeground(new Color(255, 255, 255));
		label_3.setFont(new Font("Calibri", Font.BOLD, 25));
		
		adminpass = new JPasswordField();
		adminpass.setBounds(109, 420, 295, 40);
		panel_1.add(adminpass);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(158, 370, 52, 40);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(Admin_login.class.getResource("/image/password1.png")));
		
		JButton button = new JButton("LOGIN\r\n");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int uidd=Integer.parseInt(adminuserid.getText());;
				String pass=adminpass.getText();
				ResultSet rs=null;
				try{
					String sql= "select a_password from admin_info where a_id ="+uidd;
					PreparedStatement pst= conn.prepareStatement(sql);
					rs=pst.executeQuery();
					while(rs.next())
					{
						logpass=rs.getString("a_password");
					
					}
				}
					catch(Exception ex){
						JOptionPane.showMessageDialog(null,"Error","Status",JOptionPane.INFORMATION_MESSAGE);
					}
				
				if(pass.equals(logpass))
				{
					dispose();
					Admin_Homepage sh=new Admin_Homepage();
					Admin_Homepage.adminn=uidd;
					sh.setUndecorated(true);
					sh.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Wrong Password","Status",JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		button.setBounds(200, 499, 117, 40);
		panel_1.add(button);
		button.setForeground(new Color(51, 51, 204));
		button.setFont(new Font("Calibri", Font.BOLD, 22));
		button.setBackground(new Color(255, 255, 255));
		
		nameinput = new JTextField();
		nameinput.setBackground(Color.WHITE);
		nameinput.setText("");
		nameinput.setColumns(10);
		nameinput.setBounds(611, 258, 295, 40);
		contentPane.add(nameinput);
		
		JTextField emailinput = new JTextField();
		emailinput.setBackground(Color.WHITE);
		emailinput.setText("");
		emailinput.setColumns(10);
		emailinput.setBounds(611, 344, 295, 40);
		contentPane.add(emailinput);
		
		passwordinput = new JPasswordField();
		passwordinput.setBackground(Color.WHITE);
		passwordinput.setBounds(611, 432, 295, 40);
		contentPane.add(passwordinput);
		
		JLabel lblName = new JLabel("NAME :");
		lblName.setForeground(Color.BLACK);
		lblName.setFont(new Font("Calibri", Font.BOLD, 22));
		lblName.setBounds(611, 231, 111, 27);
		contentPane.add(lblName);
		
		JLabel lblEmail = new JLabel("E-MAIL :");
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Calibri", Font.BOLD, 22));
		lblEmail.setBounds(611, 316, 111, 27);
		contentPane.add(lblEmail);
		
		JLabel lblKey = new JLabel("KEY :");
		lblKey.setForeground(Color.BLACK);
		lblKey.setFont(new Font("Calibri", Font.BOLD, 22));
		lblKey.setBounds(611, 404, 111, 27);
		contentPane.add(lblKey);
		
		JButton btnRequest = new JButton("SEND REQUEST");
		btnRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					String sql= "insert into adminrequest (r_name,r_email,r_password,approval)"+"values(?,?,?,0)";
					PreparedStatement pst= conn.prepareStatement(sql);
					pst.setNString(1,nameinput.getText());
					pst.setNString(2,emailinput.getText());
					pst.setNString(3,passwordinput.getText());
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Your request has been sent!","Status",JOptionPane.INFORMATION_MESSAGE);
					nameinput.setText("");
					emailinput.setText("");
					passwordinput.setText("");
					}
					catch(Exception ex){
						JOptionPane.showMessageDialog(null,"Error","Status",JOptionPane.INFORMATION_MESSAGE);
					}
					
					
			}
		});
		btnRequest.setBounds(671, 493, 182, 48);
		contentPane.add(btnRequest);
		btnRequest.setForeground(Color.WHITE);
		btnRequest.setFont(new Font("Calibri", Font.BOLD, 22));
		btnRequest.setBackground(new Color(51, 51, 204));
	}
}
