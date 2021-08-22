import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConexionUsuario {
	public static void main(String[] args) {
		MYSQLConexion con = new MYSQLConexion();
		Connection vc = null;
		Statement stm = null;
		ResultSet result = null;
		
		try {
			vc = con.getConexion();
			stm = vc.createStatement();
			
			result = stm.executeQuery("SELECT * FROM usuarios");
			
			while(result.next()) {

				int idUsuario = result.getInt(1);
				String usuario = result.getString(2);
				String nombre = result.getString(3);
				String apellido = result.getString(4);
				String telefono = result.getString(5);
				String correo = result.getString(6);
				String contraseña = result.getString(7);
				
				System.out.println("ID USUARIO: " + idUsuario + " -- " + "NOMBRE DE USUARIO: " + usuario + " -- " + 
									"NOMBRE: " + nombre + " -- " + "APELLIDO: " + apellido + " -- " + "TELÉFONO: " + telefono + " -- " + 
									"CORREO: " + correo + " -- " + "CONTRASEÑA: "+ contraseña);

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			try {
				if (result!=null) {
					result.close();
				}
				
				if (stm !=null) {
					stm.close();
				}
				
				if (vc !=null) {
					vc.close();
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
}
}
		