  package erronka;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Panela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnProduktua;

	public Panela(String user) {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 825, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPertsona = new JButton("Pertsonak");
		btnPertsona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			    if(user.equals("Sara")||user.equals("Elena")||user.equals("Lucia")) {
					  System.out.println("ONDO DA!");
					  pertsona frame = new pertsona();
					  frame.setVisible(true);
				}else System.out.println("PASAHITZ OKERRA");
				
			}
        });
		btnPertsona.setBounds(0, 0, 264, 191);
		contentPane.add(btnPertsona);
		
		btnProduktua = new JButton("Produktua");
		btnProduktua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String admin = "1";
		        String kontsulta ="SELECT * FROM erronkadb.langilea WHERE izena='"+user+"'";
		        konexioa kon=new konexioa();
				Connection conexion = kon.getConnection();
				Statement st;
				ResultSet rs;
				try {
					st=conexion.createStatement();
					rs=st.executeQuery(kontsulta);
					while(rs.next()) {
						if(admin.equals(rs.getString(9))) {
							System.out.println("ONDO DA!");
							produktuak frame = new produktuak();
							frame.setVisible(true);
						}else System.out.println("PASAHITZ OKERRA");
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}
			
		});
		btnProduktua.setBounds(0, 191, 264, 214);
		contentPane.add(btnProduktua);
		
		JButton btnHornitza = new JButton("Faktura");
		btnHornitza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String postua = "fakturatzailea";
		        String kontsulta ="SELECT * FROM erronkadb.langilea WHERE izena='"+user+"'";
		        konexioa kon=new konexioa();
				Connection conexion = kon.getConnection();
				Statement st;
				ResultSet rs;
				try {
					st=conexion.createStatement();
					rs=st.executeQuery(kontsulta);
					while(rs.next()) {
						if(postua.equals(rs.getString(8))) {
							System.out.println("ONDO DA!");
							faktura frame = new faktura();
							frame.setVisible(true);
						}else System.out.println("PASAHITZ OKERRA");
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}
		});
		btnHornitza.setBounds(265, 0, 259, 405);
		contentPane.add(btnHornitza);
		
		JButton btnEskaria = new JButton("Eskaria");
		btnEskaria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String postua = "Kamareroa";
		        String kontsulta ="SELECT * FROM erronkadb.langilea WHERE izena='"+user+"'";
		        konexioa kon=new konexioa();
				Connection conexion = kon.getConnection();
				Statement st;
				ResultSet rs;
				try {
					st=conexion.createStatement();
					rs=st.executeQuery(kontsulta);
					while(rs.next()) {
						if(postua.equals(rs.getString(8))) {
							System.out.println("ONDO DA!");
							eskaria frame = new eskaria();
							frame.setVisible(true);
						}else System.out.println("PASAHITZ OKERRA");
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}
		});
		btnEskaria.setBounds(529, 0, 272, 405);
		contentPane.add(btnEskaria);
		
		
	}
}
