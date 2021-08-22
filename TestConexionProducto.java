import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConexionProducto extends MYSQLConexion{
	public static void main(String[] args) {
		MYSQLConexion con = new MYSQLConexion();
		Connection vc = null;
		Statement stm = null;
		ResultSet result = null;
		
		try {
			vc = con.getConexion();
			stm = vc.createStatement();
			
			result = stm.executeQuery("SELECT * FROM productos");
			
			while(result.next()) {

				int idProducto = result.getInt(1);
				String nombre = result.getString(2);
				String marca = result.getString(3);
				String categoria = result.getString(4);
				String precio = result.getString(5);
				String cantidad = result.getString(6);
				
				System.out.println("ID USUARIO: " + idProducto + " --> " + "NOMBRE DEL PRODUCTO: " + nombre + " --> " + 
									"MARCA: " + marca + " --> " + "CATEGORIA: " + categoria + " --> " + "PRECIO: " + precio + " --> " + 
									"CANTIDAD: " + cantidad);

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
		