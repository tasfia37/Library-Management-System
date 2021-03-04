import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.ButtonGroup;


public class Signupnew extends JFrame {
	
	Connection conn = null;
	private JPanel contentPane;
	private JTextField nameinput;
	private JTextField id_input;
	private JTextField deptinput;
	private JTextField emailinput;
	private JPasswordField passinput;
	private JPasswordField confirmpass;
	int xx ,xy;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signupnew frame = new Signupnew();
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
	public Signupnew() {
		
		conn= Jconnection.ConnecrDb();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 992, 660);
		contentPane = new JPanel();
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
		        int y = e.getYOnScreen();
		        Signupnew.this.setLocation(x - xx, y - xy);
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx = e.getX();
		        xy = e.getY();
			}
		});
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 0, 128));
		panel.setBounds(0, 0, 420, 660);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Signupnew.class.getResource("/image/User256 - Copy.png")));
		label.setBounds(79, 141, 256, 256);
		panel.add(label);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Homepage hp=new Homepage();
				hp.setUndecorated(true);
				hp.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon(Signupnew.class.getResource("/image/back.png")));
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(10, 11, 64, 64);
		panel.add(lblNewLabel_1);
		
		JRadioButton radio_student = new JRadioButton("STUDENT");
		radio_student.setFont(new Font("Calibri", Font.PLAIN, 15));
		buttonGroup.add(radio_student);
		radio_student.setBackground(Color.WHITE);
		radio_student.setBounds(571, 188, 109, 23);
		contentPane.add(radio_student);
		
		JRadioButton radio_teacher = new JRadioButton("TEACHER");
		radio_teacher.setFont(new Font("Calibri", Font.PLAIN, 15));
		buttonGroup.add(radio_teacher);
		radio_teacher.setBackground(Color.WHITE);
		radio_teacher.setBounds(742, 188, 109, 23);
		contentPane.add(radio_teacher);
		
		JButton btnNewButton = new JButton("SIGN UP");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String selection = null ;
		//	boolean radio_student = false;
			if(radio_student.isSelected()){
				try{
				String sql= "insert into student_info"+"(s_id,s_name,s_dept,s_email,s_password)"+"values(?,?,?,?,?)";
				PreparedStatement pst= conn.prepareStatement(sql);
				pst.setNString(1,id_input.getText());
				pst.setNString(2,nameinput.getText());
				pst.setNString(3,deptinput.getText());
				pst.setNString(4,emailinput.getText());
				pst.setNString(5,passinput.getText());
				
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null,"Registered Successfully","Status",JOptionPane.INFORMATION_MESSAGE);
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null,"Error","Status",JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
			else{
				try{
					String sql= "insert into teacher_info"+"(t_id,t_name,t_dept,t_email,t_password)"+"values(?,?,?,?,?)";
					PreparedStatement pst= conn.prepareStatement(sql);
					pst.setNString(1,id_input.getText());
					pst.setNString(2,nameinput.getText());
					pst.setNString(3,deptinput.getText());
					pst.setNString(4,emailinput.getText());
					pst.setNString(5,passinput.getText());
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Registered Successfully","Status",JOptionPane.INFORMATION_MESSAGE);
					}
					catch(Exception e){
						JOptionPane.showMessageDialog(null,"Error","Status",JOptionPane.INFORMATION_MESSAGE);
					}
				
				}
			}
			
		});
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 24));
		btnNewButton.setBounds(143, 462, 133, 47);
		panel.add(btnNewButton);
		
		JLabel lblCreateNewUser = new JLabel("Create New User Account....");
		lblCreateNewUser.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblCreateNewUser.setForeground(new Color(211, 211, 211));
		lblCreateNewUser.setBackground(new Color(169, 169, 169));
		lblCreateNewUser.setBounds(120, 520, 193, 14);
		panel.add(lblCreateNewUser);
		
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
		
		JLabel header = new JLabel("SIGN UP");
		header.setFont(new Font("Calibri", Font.PLAIN, 36));
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setForeground(new Color(128, 0, 128));
		header.setBounds(581, 39, 196, 50);
		contentPane.add(header);
		
		JLabel namelabel = new JLabel("NAME");
		namelabel.setFont(new Font("Calibri", Font.PLAIN, 18));
		namelabel.setBounds(537, 113, 56, 23);
		contentPane.add(namelabel);
		
		nameinput = new JTextField();
		nameinput.setFont(new Font("Calibri", Font.PLAIN, 18));
		nameinput.setBounds(537, 137, 328, 31);
		contentPane.add(nameinput);
		nameinput.setColumns(10);
		
		JLabel id_label = new JLabel("ID");
		id_label.setFont(new Font("Calibri", Font.PLAIN, 18));
		id_label.setBounds(537, 230, 56, 23);
		contentPane.add(id_label);
		
		id_input = new JTextField();
		id_input.setFont(new Font("Calibri", Font.PLAIN, 18));
		id_input.setColumns(10);
		id_input.setBounds(537, 264, 328, 31);
		contentPane.add(id_input);
		
		JLabel dept = new JLabel("DEPARTMENT");
		dept.setFont(new Font("Calibri", Font.PLAIN, 18));
		dept.setBounds(537, 306, 113, 23);
		contentPane.add(dept);
		
		deptinput = new JTextField();
		deptinput.setFont(new Font("Calibri", Font.PLAIN, 18));
		deptinput.setColumns(10);
		deptinput.setBounds(537, 340, 328, 31);
		contentPane.add(deptinput);
		
		JLabel email = new JLabel("EMAIL");
		email.setFont(new Font("Calibri", Font.PLAIN, 18));
		email.setBounds(537, 382, 56, 23);
		contentPane.add(email);
		
		emailinput = new JTextField();
		emailinput.setFont(new Font("Calibri", Font.PLAIN, 18));
		emailinput.setColumns(10);
		emailinput.setBounds(537, 416, 328, 31);
		contentPane.add(emailinput);
		
		JLabel password = new JLabel("PASSWORD");
		password.setFont(new Font("Calibri", Font.PLAIN, 18));
		password.setBounds(537, 458, 113, 23);
		contentPane.add(password);
		
		JLabel confirm_password = new JLabel("CONFIRM PASSWORD");
		confirm_password.setFont(new Font("Calibri", Font.PLAIN, 18));
		confirm_password.setBounds(537, 534, 196, 23);
		contentPane.add(confirm_password);
		
		passinput = new JPasswordField();
		passinput.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passinput.setBounds(537, 492, 328, 31);
		contentPane.add(passinput);
		
		confirmpass = new JPasswordField();
		confirmpass.setFont(new Font("Tahoma", Font.PLAIN, 18));
		confirmpass.setBounds(537, 558, 328, 31);
		contentPane.add(confirmpass);
		
		
		radio_student.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			/*	if(radio_student.isSelected()){
					radio_student.setSelected=(true);
				} */
			} 
		});
		
		
		
		/*JRadioButton rdbtnStudent = new JRadioButton("STUDENT");
		buttonGroup.add(rdbtnStudent);
		rdbtnStudent.setForeground(new Color(0, 0, 0));
		rdbtnStudent.setBackground(new Color(255, 255, 255));
		rdbtnStudent.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		rdbtnStudent.setBounds(475, 153, 109, 23);
		contentPane.add(rdbtnStudent);
		
		JRadioButton rdbtnTeacher = new JRadioButton("TEACHER");
		buttonGroup.add(rdbtnTeacher);
		rdbtnTeacher.setForeground(new Color(0, 0, 0));
		rdbtnTeacher.setFont(new Font("Tempus Sans ITC", Font.BOLD, 14));
		rdbtnTeacher.setBackground(new Color(255, 255, 255));
		rdbtnTeacher.setBounds(642, 153, 109, 23);
		contentPane.add(rdbtnTeacher);*/
	}
}
