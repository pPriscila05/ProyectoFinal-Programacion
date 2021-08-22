import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/*USO DE SINGLETON. SINGLETON CREA UNA �NICA INSTANCIA �NICA 
 * DE UNA CLASE Y NOS PROPORCIONA UN ACCESO GLOBAL DE LA MISMA. 
 * COMO SI FUERA UNA VARIABLE.
 */

public class MYSQLConexion {
	
	// PROPIEDADES
    private static Connection CONN = null;

    
    // CONSTRUCTOR
    
    /*ESTE CONSTRUCTOR SE DEBE PONER PRIVATE PERO PARA PROBAR
     * QUE NUESTRA CONEXI�N FUNCIONA CREAMOS DOS CLASES TESTCONEXIONUSUARIO
     * Y TESTCONEXION PRODUCTO LO PUSE P�BLICO
     */
    
    public MYSQLConexion () {
		String URL = "jdbc:mysql://localhost:3306/bditla";
		String USUARIO = "root";
		String CONTRASE�A = "priscilapolanco05";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");				
			CONN = DriverManager.getConnection(URL,USUARIO,CONTRASE�A);
				
		} catch (ClassNotFoundException e) {
			System.out.println("ERROR EN LA CARGA DEL DRIVER");
			e.printStackTrace();
			
		}catch (SQLException e) {
			System.out.println("ERROR EN LA CONEXI�N");
			e.printStackTrace();
		}
    } // FIN CONSTRUCTOR
		
    
    //M�TODO
    public static Connection getConexion() {
    	if (CONN == null) {
    		new MYSQLConexion();
    	
    	}
    	return CONN;
    }
	}

