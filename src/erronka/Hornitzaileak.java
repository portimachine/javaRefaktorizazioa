package erronka;

import static javax.swing.JOptionPane.showMessageDialog;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTextField;

public class Hornitzaileak extends pertsona {

	private static final long serialVersionUID = 1L;
		
			public void hornitzaileaGehitu(String Id, String nif, String izn, String prod, String tel, String bank_num) {
				try {
				    konexioa kon=new konexioa();
				    Connection conexion = kon.getConnection();
				    
				    String query ="INSERT INTO erronkadb.hornitzailea"
						+ " Values('"+Id+"', '"+nif+"', '"+izn+"', '"+prod+"', '"+tel+"', '"+bank_num+"')";
				    Statement stmt;
				
					stmt = conexion.createStatement();
					stmt .executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Datuak ondo gehitu dira");
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Datuak ezin dira gehitu");
					e1.printStackTrace();
				}
			}
	
			public void hornitzaileaKendu(String nif){
				try {
				    konexioa kon=new konexioa();
				    Connection conexion = kon.getConnection();
				    String query ="DELETE FROM erronkadb.hornitzailea WHERE NIF= '"+nif+"'";
				    Statement st;
					st = conexion.createStatement();
					st.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Datuak ondo ezabatu dira");
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Datuak ezin dira ezabatu");
					e1.printStackTrace();
				}
		
	       }
}


