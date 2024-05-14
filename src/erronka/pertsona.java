package erronka;

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
import org.eclipse.wb.swing.FocusTraversalOnArray;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JLabel;
import java.awt.Color;

public class pertsona extends JFrame{
	
	/**
	 * @return the txtIzena
	 */
	private JTextField getTxtIzena() {
		return txtIzena;
	}

	/**
	 * @param txtIzena the txtIzena to set
	 */
	private void setTxtIzena(JTextField txtIzena) {
		this.txtIzena = txtIzena;
	}

	/**
	 * @return the txtBankuZenbakia
	 */
	private JTextField getTxtBankuZenbakia() {
		return txtBankuZenbakia;
	}

	/**
	 * @param txtBankuZenbakia the txtBankuZenbakia to set
	 */
	private void setTxtBankuZenbakia(JTextField txtBankuZenbakia) {
		this.txtBankuZenbakia = txtBankuZenbakia;
	}

	/**
	 * @return the txtIzena1
	 */
	private JTextField getTxtIzena1() {
		return txtIzena1;
	}

	/**
	 * @param txtIzena1 the txtIzena1 to set
	 */
	private void setTxtIzena1(JTextField txtIzena1) {
		this.txtIzena1 = txtIzena1;
	}

	/**
	 * @return the txtAbz1
	 */
	private JTextField getTxtAbz1() {
		return txtAbz1;
	}

	/**
	 * @param txtAbz1 the txtAbz1 to set
	 */
	private void setTxtAbz1(JTextField txtAbz1) {
		this.txtAbz1 = txtAbz1;
	}

	/**
	 * @return the txtAbz2
	 */
	private JTextField getTxtAbz2() {
		return txtAbz2;
	}

	/**
	 * @param txtAbz2 the txtAbz2 to set
	 */
	private void setTxtAbz2(JTextField txtAbz2) {
		this.txtAbz2 = txtAbz2;
	}

	/**
	 * @return the txtBankuZenb
	 */
	private JTextField getTxtBankuZenb() {
		return txtBankuZenb;
	}

	/**
	 * @param txtBankuZenb the txtBankuZenb to set
	 */
	private void setTxtBankuZenb(JTextField txtBankuZenb) {
		this.txtBankuZenb = txtBankuZenb;
	}

	/**
	 * @return the textIzena1
	 */
	private JTextField getTextIzena1() {
		return textIzena1;
	}

	/**
	 * @param textIzena1 the textIzena1 to set
	 */
	private void setTextIzena1(JTextField textIzena1) {
		this.textIzena1 = textIzena1;
	}

	/**
	 * @return the textAbizena1
	 */
	private JTextField getTextAbizena1() {
		return textAbizena1;
	}

	/**
	 * @param textAbizena1 the textAbizena1 to set
	 */
	private void setTextAbizena1(JTextField textAbizena1) {
		this.textAbizena1 = textAbizena1;
	}

	public void langileakGehitu(String idLangilea, String izena, String abz1, String abz2, String Nan, String tel,
			String BankuZenb, String lan_postua, String admin) {
				try {
				    konexioa kon=new konexioa();
				    Connection conexion = kon.getConnection();
				    String query ="INSERT INTO erronkadb.langilea"
						+ " Values("+idLangilea+" ,'"+Nan+"', '"+izena+"', '"+abz1+"', '"+abz2+"', '"+tel+"', '"+BankuZenb+"', '"+lan_postua+"', "+admin+")";
				    Statement stmt;
					stmt = conexion.createStatement();
					stmt .executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Datuak ondo gehitu dira");
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Datuak ezin dira gehitu");
					e1.printStackTrace();
				}
				
			}

	public void langileaKendu(String langilea, String nan) {
		try {
		    konexioa kon=new konexioa();
		    Connection conexion = kon.getConnection();
		    String query ="DELETE FROM erronkadb.langilea WHERE NAN= '"+nan+"'&& izena= '"+langilea+"'";
		    Statement st;
			st = conexion.createStatement();
			st.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Datuak ondo ezabatu dira");
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "Datuak ezin dira ezabatu");
			e1.printStackTrace();
		}
	}

	public void aktualizatuTaula(String mod1, String mod2, String mod3, String mod4, String izn, String abz) {
		try {
		    konexioa kon=new konexioa();
		    Connection conexion = kon.getConnection();
		    String query ="UPDATE langilea SET "+mod1+" ="+mod2+", "+mod3+" ="+mod4+" WHERE izena= '"+izn+"'&& abizena='"+abz+"'";
		    Statement st;
			st = conexion.createStatement();
			st .executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Datuak ondo aldatu dira");
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "Datuak ez dira aldatu");
			e1.printStackTrace();
		}
	}

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JButton btnTaula;
	private JButton btnGehitu;
	private JButton btnBilatu;
	private JButton btnLangileakGehitu;
	private JButton btnLangileakKendu;
	private JButton btnLangileakAktualizatu;
	private JTextField txtLetra;
	private JTextField txtIzena;
	private JTextField txtBankuZenbakia;
	private JTextField txtTelefonoa;
	private JTextField txtProduktua;
	private JTextField txtId;
	private JTextField txtNanNif;
	private JTextField txtNif;
	private JTextField txtIzena1;
	private JTextField txtAbz1;
	private JTextField txtAbz2;
	private JTextField txtNan;
	private JTextField txtTelefonoa_1;
	private JTextField txtBankuZenb;
	private JTextField txtLana;
	private JTextField txtAdmin;
	private JTextField txtName;
	private JTextField txtNan2;
	private JTextField textIzena1;
	private JTextField textAbizena1;
	private JTextField txtModifikatu1;
	private JTextField txtModifikatu2;
	private JTextField txtModifikatu3;
	private JTextField txtModifikatu4;
	private JTextField txtLangileaId;

	public pertsona() {
	
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 964, 831);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnTaula = new JButton("Hornitzaileen taula");
		btnTaula.setBounds(10, 11, 158, 23);
		btnTaula.addActionListener(new ActionListener() {
			private final String sql = "SELECT * FROM hornitzailea";

			public void actionPerformed(ActionEvent e) {
				konexioa kon=new konexioa();
				Connection conexion = kon.getConnection();
				Statement st;
				ResultSet rs;
				
				DefaultTableModel model =new DefaultTableModel();
				
				model.addColumn("id");
				model.addColumn("Telefonoa");
				model.addColumn("Enpresa");
				model.addColumn("korreo_elektronikoa");
				model.addColumn("Helbidea");
				model.addColumn("NAN");
				
				String[] array = new String[6];
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
						model.addRow(array);
						
					}
					
					
				} catch (SQLException e1) {
					showMessageDialog(null, "Konexio arazoak");
					e1.printStackTrace();
				}
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnTaula);
		
		table = new JTable();
		table.setBounds(203, 11, 759, 656);
		contentPane.add(table);
		

		JButton btnHornitzailea = new JButton("Bilatu");
		btnHornitzailea.setBounds(10, 39, 158, 23);
		btnHornitzailea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String like;
				like=txtLetra.getText();
				konexioa kon=new konexioa();
				Connection conexion = kon.getConnection();
				String sql = "SELECT * FROM hornitzailea WHERE izena like'"+like+"%'";
				Statement st;
				ResultSet rs;
				
				DefaultTableModel model =new DefaultTableModel();
				
				model.addColumn("id");
				model.addColumn("nif");
				model.addColumn("izena");
				model.addColumn("telefonoa");
				model.addColumn("produktua");
				model.addColumn("banku_zenbakia");
				
				table.setModel(model);
				String[] array = new String[6];
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
						model.addRow(array);
						
					}
					
					
				} catch (SQLException e1) {
					showMessageDialog(null, "Konexio arazoak");
					e1.printStackTrace();
				}
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnHornitzailea);
		
		JButton btnGehitu_1 = new JButton("Gehitu hornitzailea");
		btnGehitu_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Id, nif, izn, prod, tel, bank_num;
			    Id=txtId.getText();
			    nif=txtNanNif.getText();
			    izn=txtIzena.getText();
			    prod=txtProduktua.getText();
			    tel=txtTelefonoa.getText();
			    bank_num=txtBankuZenbakia.getText(); 
			    
			    Hornitzaileak h1 = new Hornitzaileak();
			    h1.hornitzaileaGehitu(Id, nif, izn, prod, tel, bank_num);
			    
			}
		});
		btnGehitu_1.setBounds(10, 86, 142, 23);
		contentPane.add(btnGehitu_1);
		
		JButton btnKendu_1 = new JButton("Kendu hornitzailea");
		btnKendu_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nif;
			    nif=txtNif.getText();
			    
				Hornitzaileak h1 = new Hornitzaileak();
				h1.hornitzaileaKendu(nif);
			}
		});
		btnKendu_1.setBounds(10, 239, 158, 23);
		contentPane.add(btnKendu_1);
		
		JButton btnLangilea = new JButton("Langileen taula");
		btnLangilea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				konexioa kon=new konexioa();
				Connection conexion = kon.getConnection();
				String sql = "SELECT * FROM langilea";
				Statement st;
				ResultSet rs;
				
				DefaultTableModel model =new DefaultTableModel();
				
				model.addColumn("1");
				model.addColumn("2");
				model.addColumn("3");
				model.addColumn("4");
				model.addColumn("5");
				model.addColumn("6");
				model.addColumn("7");
				model.addColumn("8");
				model.addColumn("9");
				
				table.setModel(model);
				String[] array = new String[9];
				try {
					st=conexion.createStatement();
					rs = st.executeQuery(sql);
					while (rs.next()) {
						array[0]=rs.getString(1);
						array[1]=rs.getString(2);
						array[2]=rs.getString(3);
						array[3]=rs.getString(4);
						array[4]=rs.getString(5);
						array[5]=rs.getString(6);
						array[6]=rs.getString(7);
						array[7]=rs.getString(8);
						array[8]=rs.getString(9);
						model.addRow(array);
						
					}
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
			    }
			}
		});
		btnLangilea.setBounds(10, 286, 165, 23);
		contentPane.add(btnLangilea);
		
		JButton btnProduktuenTaula = new JButton("Produktuen taula");
		btnProduktuenTaula.addActionListener(new ActionListener() {
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
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnProduktuenTaula.setBounds(10, 308, 165, 23);
		contentPane.add(btnProduktuenTaula);
		
		btnLangileakGehitu = new JButton("Langileak gehitu");
		btnLangileakGehitu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String idLangilea,izena,abz1,abz2,Nan,tel,BankuZenb,lan_postua,admin;
				idLangilea=txtLangileaId.getText();
			    izena=txtIzena1.getText();
			    abz1=txtAbz1.getText();
			    abz2=txtAbz2.getText();
			    Nan=txtNan.getText();
			    tel=txtTelefonoa_1.getText();
			    BankuZenb=txtBankuZenb.getText();
			    lan_postua=txtLana.getText();
			    admin=txtAdmin.getText();
			    
				langileak l1 = new langileak();
				l1.langileakGehitu(idLangilea, izena,abz1,abz2,Nan,tel,BankuZenb,lan_postua,admin);
			}
		});
		btnLangileakGehitu.setBounds(10, 330, 165, 23);
		contentPane.add(btnLangileakGehitu);
		
		btnLangileakKendu = new JButton("Langileak kendu");
		btnLangileakKendu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String langilea, nan;
			    langilea=txtName.getText();
			    nan=txtNan2.getText();
			    
				langileak l1 = new langileak();
				l1.langileaKendu(langilea, nan);
			}
		});
		btnLangileakKendu.setBounds(10, 561, 127, 23);
		contentPane.add(btnLangileakKendu);
		
		btnLangileakAktualizatu = new JButton("Langileak aktualizatu");
		btnLangileakAktualizatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String mod1, mod2, mod3, mod4, izn, abz;
			    izn=textIzena1.getText();
			    abz=textAbizena1.getText();
			    mod1=txtModifikatu1.getText();
			    mod2=txtModifikatu2.getText();
			    mod3=txtModifikatu3.getText();
			    mod4=txtModifikatu4.getText();
			    
				langileak l1 = new langileak();
				l1.aktualizatuTaula(mod1, mod2, mod3, mod4, izn, abz);
			}
		});
		btnLangileakAktualizatu.setBounds(10, 626, 158, 23);
		contentPane.add(btnLangileakAktualizatu);
		
		
		txtLetra = new JTextField();
		txtLetra.setText("Sartu izenaren lehenengo letrak");
		txtLetra.setBounds(10, 62, 200, 20);
		contentPane.add(txtLetra);
		txtLetra.setColumns(10);
		
		txtNif = new JTextField();
		txtNif.setText("NIF");
		txtNif.setBounds(10, 262, 86, 20);
		contentPane.add(txtNif);
		txtNif.setColumns(10);
		
		txtIzena = new JTextField();
		txtIzena.setText("Izena");
		txtIzena.setBounds(10, 151, 86, 20);
		contentPane.add(txtIzena);
		txtIzena.setColumns(10);
		
		txtBankuZenbakia = new JTextField();
		txtBankuZenbakia.setText("banku-zenbakia");
		txtBankuZenbakia.setBounds(10, 215, 86, 20);
		contentPane.add(txtBankuZenbakia);
		txtBankuZenbakia.setColumns(10);
		
		txtTelefonoa = new JTextField();
		txtTelefonoa.setText("Telefonoa");
		txtTelefonoa.setBounds(10, 194, 96, 19);
		contentPane.add(txtTelefonoa);
		txtTelefonoa.setColumns(10);
		
		txtProduktua = new JTextField();
		txtProduktua.setText("Produktua");
		txtProduktua.setColumns(10);
		txtProduktua.setBounds(10, 173, 96, 19);
		contentPane.add(txtProduktua);
		
		txtId = new JTextField();
		txtId.setText("Id");
		txtId.setColumns(10);
		txtId.setBounds(10, 109, 96, 19);
		contentPane.add(txtId);
		
		txtNanNif = new JTextField();
		txtNanNif.setText("NIF");
		txtNanNif.setColumns(10);
		txtNanNif.setBounds(10, 130, 96, 19);
		contentPane.add(txtNanNif);
		
		txtIzena1 = new JTextField();
		txtIzena1.setText("Izena");
		txtIzena1.setColumns(10);
		txtIzena1.setBounds(10, 386, 86, 20);
		contentPane.add(txtIzena1);
		
		txtAbz1 = new JTextField();
		txtAbz1.setText("Lehen abizena");
		txtAbz1.setColumns(10);
		txtAbz1.setBounds(10, 407, 127, 20);
		contentPane.add(txtAbz1);
		
		txtAbz2 = new JTextField();
		txtAbz2.setText("Bigarren abizena");
		txtAbz2.setColumns(10);
		txtAbz2.setBounds(10, 428, 127, 20);
		contentPane.add(txtAbz2);
		
		txtNan = new JTextField();
		txtNan.setText("Nan-a");
		txtNan.setColumns(10);
		txtNan.setBounds(10, 450, 86, 20);
		contentPane.add(txtNan);
		
		txtTelefonoa_1 = new JTextField();
		txtTelefonoa_1.setText("Telefonoa");
		txtTelefonoa_1.setColumns(10);
		txtTelefonoa_1.setBounds(10, 472, 86, 20);
		contentPane.add(txtTelefonoa_1);
		
		txtBankuZenb = new JTextField();
		txtBankuZenb.setText("Banku zenbakia");
		txtBankuZenb.setColumns(10);
		txtBankuZenb.setBounds(10, 495, 127, 20);
		contentPane.add(txtBankuZenb);
		
		txtLana = new JTextField();
		txtLana.setText("Lan-postua");
		txtLana.setColumns(10);
		txtLana.setBounds(10, 516, 86, 20);
		contentPane.add(txtLana);
		
		txtAdmin = new JTextField();
		txtAdmin.setText("Administratzailea ");
		txtAdmin.setColumns(10);
		txtAdmin.setBounds(10, 539, 96, 20);
		contentPane.add(txtAdmin);
		
		txtName = new JTextField();
		txtName.setText("Izena");
		txtName.setColumns(10);
		txtName.setBounds(10, 585, 86, 20);
		contentPane.add(txtName);
		
		txtNan2 = new JTextField();
		txtNan2.setText("Nan-a");
		txtNan2.setColumns(10);
		txtNan2.setBounds(10, 606, 86, 20);
		contentPane.add(txtNan2);
		
		textIzena1 = new JTextField();
		textIzena1.setText("Izena");
		textIzena1.setColumns(10);
		textIzena1.setBounds(10, 652, 86, 20);
		contentPane.add(textIzena1);
		
		textAbizena1 = new JTextField();
		textAbizena1.setText("Lehen abizena");
		textAbizena1.setColumns(10);
		textAbizena1.setBounds(10, 675, 174, 20);
		contentPane.add(textAbizena1);
		
		txtModifikatu1 = new JTextField();
		txtModifikatu1.setText("Modifikatu nahi dena");
		txtModifikatu1.setColumns(10);
		txtModifikatu1.setBounds(10, 698, 174, 20);
		contentPane.add(txtModifikatu1);
		
		txtModifikatu2 = new JTextField();
		txtModifikatu2.setText("Modifikazioa");
		txtModifikatu2.setColumns(10);
		txtModifikatu2.setBounds(10, 722, 174, 20);
		contentPane.add(txtModifikatu2);
		
		txtModifikatu3 = new JTextField();
		txtModifikatu3.setText("Modifikatu nahi dena");
		txtModifikatu3.setColumns(10);
		txtModifikatu3.setBounds(10, 743, 174, 20);
		contentPane.add(txtModifikatu3);
		
		txtModifikatu4 = new JTextField();
		txtModifikatu4.setText("Modifikazioa");
		txtModifikatu4.setColumns(10);
		txtModifikatu4.setBounds(10, 764, 174, 20);
		contentPane.add(txtModifikatu4);
		
		txtLangileaId = new JTextField();
		txtLangileaId.setText("Id");
		txtLangileaId.setColumns(10);
		txtLangileaId.setBounds(10, 356, 86, 20);
		contentPane.add(txtLangileaId);
		
		JLabel lblJarriNahiDuzuna = new JLabel("Jarri nahi duzuna zenbakia ez bada jarri bi komilla(')-ren artean ");
		lblJarriNahiDuzuna.setForeground(Color.BLACK);
		lblJarriNahiDuzuna.setBackground(Color.BLUE);
		lblJarriNahiDuzuna.setBounds(203, 725, 466, 14);
		contentPane.add(lblJarriNahiDuzuna);
		
		JLabel lblJarriNahiDuzuna_1 = new JLabel("Jarri nahi duzuna zenbakia ez bada jarri bi komilla(')-ren artean ");
		lblJarriNahiDuzuna_1.setForeground(Color.BLACK);
		lblJarriNahiDuzuna_1.setBackground(Color.BLUE);
		lblJarriNahiDuzuna_1.setBounds(203, 767, 466, 14);
		contentPane.add(lblJarriNahiDuzuna_1);
	}
}
