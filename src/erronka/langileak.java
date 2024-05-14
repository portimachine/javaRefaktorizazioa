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


import javax.swing.JTextField;

import java.awt.event.ActionEvent;

import javax.swing.JTable;


public class langileak extends pertsona {
		
			public void langileakGehitu(String idLangilea, String izena, String abz1, String abz2, String Nan, String tel, String BankuZenb, String lan_postua, String admin) {
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
		
	
}