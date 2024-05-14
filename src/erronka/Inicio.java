package erronka;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Inicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUser;
	private JTextField textPwd;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Inicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Sesioa hasi");
		
		btnNewButton.setBounds(117, 130, 188, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			        String user,pwd;
			        user=textUser.getText();
			        pwd= textPwd.getText();
			        String kontsulta ="SELECT * FROM erronkadb.langilea WHERE izena='"+user+"'";
			        konexioa kon=new konexioa();
					Connection conexion = kon.getConnection();
					Statement st;
					ResultSet rs;
					try {
						st=conexion.createStatement();
						rs=st.executeQuery(kontsulta);
						while(rs.next()) {
							if(pwd.equals(rs.getString(2))){
								System.out.println("ONDO DA!");
								Panela frame = new Panela(user);
								frame.setVisible(true);
							}else System.out.println("PASAHITZ OKERRA");
						}
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}	
					
			}
		});
		textUser = new JTextField();
		textUser.setBounds(219, 65, 86, 20);
		contentPane.add(textUser);
		textUser.setColumns(10);
		
		textPwd = new JTextField();
		textPwd.setBounds(219, 96, 86, 20);
		contentPane.add(textPwd);
		textPwd.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Erabiltzailea");
		lblNewLabel.setBackground(new Color(0, 0, 255));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(117, 68, 124, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Pasahitza");
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(117, 99, 156, 14);
		contentPane.add(lblNewLabel_1);
	}
}