package erronka;

import static javax.swing.JOptionPane.showMessageDialog;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTable;


public class produktuak extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField txtProduktua;
	private JTextField txtPrezioa;
	private JTextField txtKantitatea;
	private JTextField txtIdHornitzailea;
	private JTextField txtId;
	private JButton btnIdinfo;
	private JTextField textId2;
	private JTextField txtMod1;
	private JTextField txtMod2;
	private JTextField txtMod3;
	private JTextField txtMod4;
	private JTextField txtIzena;
	private JTextField txtProdId;
	private JTextField txtId_1;

	public produktuak() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 749, 642);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(137, 35, 588, 386);
		contentPane.add(table);
		
		JButton btnNewButton = new JButton("Taula");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				konexioa kon=new konexioa();
				Connection conexion = kon.getConnection();
				String sql = "SELECT * FROM produktuak";
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
						//System.out.println(rs.getString(2));
						array[0]=rs.getString(1);
						array[1]=rs.getString(2);
						array[2]=rs.getString(3);
						array[3]=rs.getString(4);
						array[4]=rs.getString(5);
						model.addRow(array);
						
					}
					
					
				} catch (SQLException e1) {
					showMessageDialog(null, "Konexio arazoak");
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(10, 7, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnGehitu = new JButton("Gehitu ");
		btnGehitu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				    konexioa kon=new konexioa();
				    Connection conexion = kon.getConnection();
				    String idProd, prod, prezioa, kantitatea, idHornitzailea;
				    idProd=txtId.getText();
				    prod=txtProduktua.getText();
				    prezioa=txtPrezioa.getText();
				    kantitatea=txtKantitatea.getText();
				    idHornitzailea=txtIdHornitzailea.getText();
				    
				    String query ="INSERT INTO erronkadb.produktuak"
						  + " Values("+idProd+", '"+prod+"', "+prezioa+", "+kantitatea+", "+idHornitzailea+")";
				    Statement stmt;
				
				    stmt = conexion.createStatement();
				    stmt .executeUpdate(query);
					showMessageDialog(null, "Produktua ongi gehitu da datu basean");
				    
				} catch (SQLException e1) {
					showMessageDialog(null, "Arazoak datuak taulan gehitzerakoan");
					e1.printStackTrace();
				}
			}
		});
		btnGehitu.setBounds(10, 31, 89, 23);
		contentPane.add(btnGehitu);
	
		btnIdinfo = new JButton("Id_info");
		btnIdinfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				konexioa kon=new konexioa();
				Connection conexion = kon.getConnection();
				String Id;
				Id=textId2.getText();
				String sql = "SELECT * FROM produktuak WHERE id_produktuak="+Id;
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
						//System.out.println(rs.getString(2));
						array[0]=rs.getString(1);
						array[1]=rs.getString(2);
						array[2]=rs.getString(3);
						array[3]=rs.getString(4);
						array[4]=rs.getString(5);
						model.addRow(array);
						
					}
					
					
				} catch (SQLException e1) {
					showMessageDialog(null, "Id okerra");
					e1.printStackTrace();
				}
			}
		});
		JButton btnAktualizatu = new JButton("Aktualizatu");
		btnAktualizatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				    konexioa kon=new konexioa();
				    Connection conexion = kon.getConnection();
				    String mod1, mod2, mod3, mod4, izn, id;
				    mod1=txtMod1.getText();
				    mod2=txtMod2.getText();
				    mod3=txtMod3.getText();
				    mod4=txtMod4.getText();
				    id=txtProdId.getText();
				    izn=txtIzena.getText();
				    String query ="UPDATE produktuak SET "+mod1+" ='"+mod2+"', "+mod3+" ='"+mod4+"' WHERE izena= '"+izn+"'&& id_produktuak="+id;
				    Statement st;
					st = conexion.createStatement();
					st .executeUpdate(query);
					showMessageDialog(null, "Datuak ondo aldatu dira");
				} catch (SQLException e1) {
					showMessageDialog(null, "Arazoa aktualizatzean.");
					e1.printStackTrace();
				}
			}
		});
		btnAktualizatu.setBounds(10, 210, 115, 23);
		contentPane.add(btnAktualizatu);
		
		JButton btnKendu = new JButton("Kendu");
		btnKendu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				    konexioa kon=new konexioa();
				    Connection conexion = kon.getConnection();
				    String id;
				    id=txtId_1.getText();
				    String query ="DELETE FROM erronkadb.produktuak WHERE id_produktuak= "+id;
				    Statement st;
					st = conexion.createStatement();
					st.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Datuak ondo ezabatu dira");
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Datuak ezin dira ezabatu");
					e1.printStackTrace();
				}
			}
		});
		btnKendu.setBounds(10, 367, 115, 23);
		contentPane.add(btnKendu);
		
		btnIdinfo.setBounds(10, 165, 89, 23);
		contentPane.add(btnIdinfo);
		
		txtProduktua = new JTextField();
		txtProduktua.setText("Produktua");
		txtProduktua.setBounds(13, 76, 112, 20);
		contentPane.add(txtProduktua);
		txtProduktua.setColumns(10);
		
		txtPrezioa = new JTextField();
		txtPrezioa.setText("Prezioa");
		txtPrezioa.setBounds(13, 100, 112, 20);
		contentPane.add(txtPrezioa);
		txtPrezioa.setColumns(10);
		
		txtKantitatea = new JTextField();
		txtKantitatea.setText("Kantitatea");
		txtKantitatea.setBounds(13, 122, 112, 20);
		contentPane.add(txtKantitatea);
		txtKantitatea.setColumns(10);
		
		txtIdHornitzailea = new JTextField();
		txtIdHornitzailea.setText("Hornitzailearen id");
		txtIdHornitzailea.setBounds(13, 143, 112, 20);
		contentPane.add(txtIdHornitzailea);
		txtIdHornitzailea.setColumns(10);
		
		txtId = new JTextField();
		txtId.setText("Id");
		txtId.setBounds(13, 55, 112, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		textId2 = new JTextField();
		textId2.setText("Id");
		textId2.setBounds(13, 189, 86, 20);
		contentPane.add(textId2);
		textId2.setColumns(10);
		
		txtMod1 = new JTextField();
		txtMod1.setText("Aldatu nahi dena");
		txtMod1.setBounds(10, 279, 115, 20);
		contentPane.add(txtMod1);
		txtMod1.setColumns(10);
		
		txtMod2 = new JTextField();
		txtMod2.setText("Aldaketa");
		txtMod2.setBounds(13, 302, 86, 20);
		contentPane.add(txtMod2);
		txtMod2.setColumns(10);
		
		txtMod3 = new JTextField();
		txtMod3.setText("Aldatu nahi dena");
		txtMod3.setBounds(12, 323, 115, 20);
		contentPane.add(txtMod3);
		txtMod3.setColumns(10);
		
		txtMod4 = new JTextField();
		txtMod4.setText("Aldaketa");
		txtMod4.setBounds(10, 345, 86, 20);
		contentPane.add(txtMod4);
		txtMod4.setColumns(10);
		
		txtIzena = new JTextField();
		txtIzena.setText("Izena");
		txtIzena.setBounds(13, 235, 86, 20);
		contentPane.add(txtIzena);
		txtIzena.setColumns(10);
		
		txtProdId = new JTextField();
		txtProdId.setText("Id produktua");
		txtProdId.setBounds(13, 258, 86, 20);
		contentPane.add(txtProdId);
		txtProdId.setColumns(10);
		
		txtId_1 = new JTextField();
		txtId_1.setText("id");
		txtId_1.setColumns(10);
		txtId_1.setBounds(13, 390, 86, 20);
		contentPane.add(txtId_1);
	}
}

