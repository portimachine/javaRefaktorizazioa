package erronka;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class eskaria extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField txtPlaterarenIda;
	private JTextField txtKopurua;
	private JTextField txtBezeroarenIda;
	private JTextField txtEskariarenIda;
	private JButton btnBezeroa;
	private JTextField txtBezeroarenIzena;
	private JTextField txtAbizena;
	private JButton btnEskariak;
	private JTextField txtMahiZenbakia;
	private JButton btnEskariaBilatu;
	private JTextField txtIdEskaria;
	
	public eskaria() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1131, 770);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(208, 10, 814, 695);
		contentPane.add(table);
		
		JButton btnKatalogoa = new JButton("Katalogoa");
		btnKatalogoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				konexioa kon=new konexioa();
				Connection conexion = kon.getConnection();
				String sql = "SELECT * FROM erronkadb.platerak";
				Statement st;
				ResultSet rs;
				
				DefaultTableModel model =new DefaultTableModel();
				
				model.addColumn("1");
				model.addColumn("2");
				model.addColumn("3");
				model.addColumn("4");
				
				table.setModel(model);
				String[] array = new String[4];
				try {
					st=conexion.createStatement();
					rs = st.executeQuery(sql);
					while (rs.next()) {
						array[0]=rs.getString(1);
						array[1]=rs.getString(2);
						array[2]=rs.getString(3);
						array[3]=rs.getString(4);
						model.addRow(array);
						
					}
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnKatalogoa.setBounds(30, 21, 85, 21);
		contentPane.add(btnKatalogoa);
		
		JButton btnBidali = new JButton("Bidali");
		btnBidali.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				    konexioa kon=new konexioa();
				    Connection conexion = kon.getConnection();
				    String id, kopurua, idBezeroa, idEskaria, mahiZenbakia;
				    id=txtPlaterarenIda.getText();
				    kopurua=txtKopurua.getText();
				    idBezeroa=txtBezeroarenIda.getText();
				    idEskaria=txtEskariarenIda.getText();
				    mahiZenbakia=txtMahiZenbakia.getText();
				    
				    String query ="INSERT INTO erronkadb.eskaria"
						+ " Values("+idEskaria+", "+idBezeroa+", "+id+", "+kopurua+", "+mahiZenbakia+")";
				    Statement stmt;
					stmt = conexion.createStatement();
					stmt .executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Datuak ondo gehitu dira");
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Datuak ezin dira gehitu");
					e1.printStackTrace();
				}
			}
		});
		btnBidali.setBounds(30, 44, 89, 23);
		contentPane.add(btnBidali);
		
		btnBezeroa = new JButton("Bezeroa ");
		btnBezeroa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String izena, abizena;
				izena=txtBezeroarenIzena.getText();
				abizena=txtAbizena.getText();
				konexioa kon=new konexioa();
				Connection conexion = kon.getConnection();
				String sql = "SELECT * FROM erronkadb.bezeroa WHERE izena= '"+izena+"'&& abizena='"+abizena+"'";
				Statement st;
				ResultSet rs;
				
				DefaultTableModel model =new DefaultTableModel();
				
				model.addColumn("idbezeroa");
				model.addColumn("Nan");
				model.addColumn("izena");
				model.addColumn("abizena");
				model.addColumn("abizena2");
				model.addColumn("banku_zenbakia");
				model.addColumn("telefonoa");
				model.addColumn("emaila");
				model.addColumn("usuarioa");
				model.addColumn("pasahitza");
				
				table.setModel(model);
				String[] array = new String[10];
				try {
					st=conexion.createStatement();
					rs = st.executeQuery(sql);
					while (rs.next()) {
						//System.out.println(rs.getString(2));
						array[0]=rs.getString(1);
						array[1]=rs.getString(2);
						array[2]=rs.getString(3);
						array[3]=rs.getString(4);
						array[4]=rs.getString(5);
						array[5]=rs.getString(6);
						array[6]=rs.getString(7);
						array[7]=rs.getString(8);
						array[8]=rs.getString(9);
						array[9]=rs.getString(10);
						model.addRow(array);
						
					}
					
					
				} catch (SQLException e1) {
					showMessageDialog(null, "Konexio arazoak");
					e1.printStackTrace();
				}
			}
		});
		btnBezeroa.setBounds(30, 186, 85, 21);
		contentPane.add(btnBezeroa);
		
		btnEskariak = new JButton("Eskariak");
		btnEskariak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				konexioa kon=new konexioa();
				Connection conexion = kon.getConnection();
				String sql = "SELECT * FROM erronkadb.eskaria";
				Statement st;
				ResultSet rs;
				
				DefaultTableModel model =new DefaultTableModel();
				
				model.addColumn("1");
				model.addColumn("2");
				model.addColumn("3");
				model.addColumn("4");
				model.addColumn("5");
				
				table.setModel(model);
				String[] array = new String[5];
				try {
					st=conexion.createStatement();
					rs = st.executeQuery(sql);
					while (rs.next()) {
						array[0]=rs.getString(1);
						array[1]=rs.getString(2);
						array[2]=rs.getString(3);
						array[3]=rs.getString(4);
						array[4]=rs.getString(5);
						model.addRow(array);
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
			    }
			}
		});
		btnEskariak.setBounds(30, 254, 85, 21);
		contentPane.add(btnEskariak);
		
		btnEskariaBilatu = new JButton("Eskaria bilatu");
		btnEskariaBilatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				konexioa kon=new konexioa();
				Connection conexion = kon.getConnection();
				String id;
				id = txtIdEskaria.getText();
				String sql = "SELECT * FROM erronkadb.eskaria WHERE ideskatutakoPlaterak="+id;
				Statement st;
				ResultSet rs;
				
				DefaultTableModel model =new DefaultTableModel();
				
				model.addColumn("1");
				model.addColumn("2");
				model.addColumn("3");
				model.addColumn("4");
				model.addColumn("5");
				
				table.setModel(model);
				String[] array = new String[5];
				try {
					st=conexion.createStatement();
					rs = st.executeQuery(sql);
					while (rs.next()) {
						array[0]=rs.getString(1);
						array[1]=rs.getString(2);
						array[2]=rs.getString(3);
						array[3]=rs.getString(4);
						array[4]=rs.getString(5);
						model.addRow(array);
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
			    }
			}
		});
		btnEskariaBilatu.setBounds(30, 277, 96, 21);
		contentPane.add(btnEskariaBilatu);
		
		txtPlaterarenIda = new JTextField();
		txtPlaterarenIda.setText("Plateraren id-a");
		txtPlaterarenIda.setBounds(30, 69, 113, 20);
		contentPane.add(txtPlaterarenIda);
		txtPlaterarenIda.setColumns(10);
		
		txtKopurua = new JTextField();
		txtKopurua.setText("Kopurua");
		txtKopurua.setBounds(30, 93, 113, 20);
		contentPane.add(txtKopurua);
		txtKopurua.setColumns(10);
		
		txtBezeroarenIda = new JTextField();
		txtBezeroarenIda.setText("Bezeroaren id-a");
		txtBezeroarenIda.setColumns(10);
		txtBezeroarenIda.setBounds(30, 117, 113, 20);
		contentPane.add(txtBezeroarenIda);
		
		txtEskariarenIda = new JTextField();
		txtEskariarenIda.setText("Eskariaren id-a");
		txtEskariarenIda.setColumns(10);
		txtEskariarenIda.setBounds(30, 139, 113, 20);
		contentPane.add(txtEskariarenIda);
		
		txtBezeroarenIzena = new JTextField();
		txtBezeroarenIzena.setText("Bezeroaren izena");
		txtBezeroarenIzena.setBounds(30, 207, 96, 19);
		contentPane.add(txtBezeroarenIzena);
		txtBezeroarenIzena.setColumns(10);
		
		txtAbizena = new JTextField();
		txtAbizena.setText("Abizena");
		txtAbizena.setBounds(30, 230, 96, 19);
		contentPane.add(txtAbizena);
		txtAbizena.setColumns(10);
		
		txtMahiZenbakia = new JTextField();
		txtMahiZenbakia.setText("Mahi zenbakia");
		txtMahiZenbakia.setColumns(10);
		txtMahiZenbakia.setBounds(30, 161, 113, 20);
		contentPane.add(txtMahiZenbakia);
		
		txtIdEskaria = new JTextField();
		txtIdEskaria.setText("Id-a eskaria");
		txtIdEskaria.setColumns(10);
		txtIdEskaria.setBounds(30, 299, 96, 19);
		contentPane.add(txtIdEskaria);
		
	}
}

