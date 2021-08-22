import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/*USO DE SINGLETON. SINGLETON CREA UNA ÚNICA INSTANCIA ÚNICA 
 * DE UNA CLASE Y NOS PROPORCIONA UN ACCESO GLOBAL DE LA MISMA. 
 * COMO SI FUERA UNA VARIABLE.
 */

public class MYSQLConexion {
	
	// PROPIEDADES
    private static Connection CONN = null;

    
    // CONSTRUCTOR
    
    /*ESTE CONSTRUCTOR SE DEBE PONER PRIVATE PERO PARA PROBAR
     * QUE NUESTRA CONEXIÓN FUNCIONA CREAMOS DOS CLASES TESTCONEXIONUSUARIO
     * Y TESTCONEXION PRODUCTO LO PUSE PÚBLICO
     */
    
    public MYSQLConexion () {
		String URL = "jdbc:mysql://localhost:3306/bditla";
		String USUARIO = "root";
		String CONTRASEÑA = "priscilapolanco05";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");				
			CONN = DriverManager.getConnection(URL,USUARIO,CONTRASEÑA);
				
		} catch (ClassNotFoundException e) {
			System.out.println("ERROR EN LA CARGA DEL DRIVER");
			e.printStackTrace();
			
		}catch (SQLException e) {
			System.out.println("ERROR EN LA CONEXIÓN");
			e.printStackTrace();
		}
    } // FIN CONSTRUCTOR
		
    
    //MÉTODO
    public static Connection getConexion() {
    	if (CONN == null) {
    		new MYSQLConexion();
    	
    	}
    	return CONN;
    }
	}

