import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JPasswordField;
import javax.swing.JRadioButton;

public class Homepage extends JFrame {

	private JPanel contentPane;
	public JTextField user;
	public int logid;
	public String logpass;
	int xx ,xy;
	Connection conn = null;
	private JPasswordField password;
	private int pp;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Homepage frame = new Homepage();
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
	public Homepage() {
		
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
			public void mouseDragged(MouseEvent arg0) {
				int x = arg0.getXOnScreen();
		        int y = arg0.getYOnScreen();
		        Homepage.this.setLocation(x - xx, y - xy);
			}
		});
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		user = new JTextField();
		user.setFont(new Font("Tahoma", Font.PLAIN, 18));
		user.setText("");
		user.setColumns(10);
		user.setBounds(514, 284, 295, 48);
		contentPane.add(user);
		
		JLabel lblNewLabel = new JLabel("USERID");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 24));
		lblNewLabel.setBounds(578, 246, 151, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setForeground(new Color(0, 0, 0));
		lblPassword.setFont(new Font("Calibri", Font.BOLD, 24));
		lblPassword.setBounds(582, 370, 135, 27);
		contentPane.add(lblPassword);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(540, 350, 32, 47);
		contentPane.add(label_1);
		label_1.setIcon(new ImageIcon(Homepage.class.getResource("/image/password1.png")));
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(551, 231, 37, 48);
		contentPane.add(label_2);
		label_2.setIcon(new ImageIcon(Homepage.class.getResource("/image/avatar.png")));
		JRadioButton radio_student = new JRadioButton("STUDENT");
		radio_student.setFont(new Font("Calibri", Font.PLAIN, 15));
		radio_student.setBackground(Color.WHITE);
		radio_student.setBounds(514, 201, 109, 23);
		buttonGroup.add(radio_student);
		contentPane.add(radio_student);
		
		JRadioButton radio_teacher = new JRadioButton("TEACHER");
		radio_teacher.setFont(new Font("Calibri", Font.PLAIN, 15));
		radio_teacher.setBackground(Color.WHITE);
		radio_teacher.setBounds(681, 201, 109, 23);
		buttonGroup.add(radio_teacher);
		contentPane.add(radio_teacher);
		
		JButton btnNewButton = new JButton("LOGIN\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int uidd=Integer.parseInt(user.getText());
				String pass=password.getText();
				ResultSet rs=null;
				if(radio_student.isSelected())
				{
					pp=0;
				try{
					String sql= "select s_password from student_info where s_id ="+uidd;
					PreparedStatement pst= conn.prepareStatement(sql);
					rs=pst.executeQuery();
					while(rs.next())
					{
						logpass=rs.getString("s_password");
					
					}
				}
					catch(Exception ex){
						JOptionPane.showMessageDialog(null,"Error","Status",JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else
				{
					pp=1;
					try{
					String sql= "select t_password from teacher_info where t_id ="+uidd;
					PreparedStatement pst= conn.prepareStatement(sql);
					rs=pst.executeQuery();
					while(rs.next())
					{
						logpass=rs.getString("t_password");
					
					}
				}
					catch(Exception ex){
						JOptionPane.showMessageDialog(null,"Error","Status",JOptionPane.INFORMATION_MESSAGE);
					}
				}
				
				if(pass.equals(logpass))
				{
					dispose();
					Student_Homepage sh=new Student_Homepage();
					Student_Homepage.userr=uidd;
					Student_Homepage.st=pp;
					sh.setUndecorated(true);
					sh.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Wrong Password","Status",JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		btnNewButton.setBackground(new Color(51, 51, 51));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 20));
		btnNewButton.setBounds(578, 496, 117, 40);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("X");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(941, 11, 25, 27);
		contentPane.add(lblNewLabel_1);
		
		password = new JPasswordField();
		password.setFont(new Font("Tahoma", Font.PLAIN, 18));
		password.setBounds(514, 408, 295, 48);
		contentPane.add(password);
		
		JLabel lblNotAUser = new JLabel("NOT A USER? ");
		lblNotAUser.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblNotAUser.setForeground(new Color(0, 0, 0));
		lblNotAUser.setBounds(740, 594, 106, 21);
		contentPane.add(lblNotAUser);
		
		JLabel lblLoginAsAdmin = new JLabel("LOGIN AS ADMIN");
		lblLoginAsAdmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Admin_login alog=new Admin_login();
				alog.setUndecorated(true);
				alog.setVisible(true);
				dispose();
				
			}
		});
		lblLoginAsAdmin.setForeground(new Color(0, 0, 0));
		lblLoginAsAdmin.setFont(new Font("Calibri", Font.BOLD, 18));
		lblLoginAsAdmin.setBounds(807, 66, 135, 21);
		contentPane.add(lblLoginAsAdmin);
		
		JLabel lblSignup = new JLabel("SIGNUP");
		lblSignup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				Signupnew sp=new Signupnew();
				sp.setUndecorated(true);
				sp.setVisible(true);
				dispose();
				
			}
		});
		lblSignup.setForeground(Color.ORANGE);
		lblSignup.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 24));
		lblSignup.setBounds(845, 585, 84, 38);
		contentPane.add(lblSignup);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Homepage.class.getResource("/image/admin.png")));
		lblNewLabel_2.setBounds(761, 43, 48, 48);
		contentPane.add(lblNewLabel_2);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 420, 660);
		contentPane.add(label);
		label.setIcon(new ImageIcon(Homepage.class.getResource("/image/photo-1456513080510-7bf3a84b82f81.jpg")));
		

	}
}
