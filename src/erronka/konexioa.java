
package erronka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class konexioa {
	private static String BBDD="com.mysql.cj.jdbc.Driver";
	private static String usuario="3taldea";
	private static String contraseña="1WMG2023";
	private static String url="jdbc:mysql://192.168.15.66:3306/erronkadb";
	
	static {
		try {
			Class.forName(BBDD);
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Driver no Conectado");
		}
	}
	
	Connection con=null;
	
	public Connection getConnection() {
		try {
			con=DriverManager.getConnection(url, usuario, contraseña);
		}catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error de Conexion");
		}
		return con;
	}
}
