import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class RegisterData extends MYSQLConexion{
	
	public boolean registrar(UserData userr) {
	
		PreparedStatement ps =null;
		Connection con = getConexion();
		
		String sql = "INSERT INTO usuarios(usuario, nombre, apellido, telefono, correo, contraseña) VALUES(?,?,?,?,?,?)";
		
		
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, userr.getUsuario());
				ps.setString(2, userr.getNombre());
				ps.setString(3, userr.getApellido());
				ps.setString(4, userr.getTelefono());
				ps.setString(5, userr.getCorreo());
				ps.setString(6, userr.getContraseña());
				ps.execute();
				return true;


			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}

		
	}
	
	public boolean Login(UserData usuario) {

		
		PreparedStatement ps =null;
		ResultSet result = null;
		Connection con = getConexion();
		
		String sql = "SELECT idUsuario, usuario, nombre, apellido, telefono, correo, contraseña FROM usuarios WHERE usuario = ? "; 
		
		
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, usuario.getUsuario());
				result =  ps.executeQuery();
				
				if(result.next()) {
					if(usuario.getContraseña().equals(result.getString(7))) {
						
						usuario.setIdUsuario(result.getInt(1));
						usuario.setNombre(result.getString(3));
						return true;
					}else {
						return false;
					}
										
				}
				
				return false;


			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}

		
	}
	
	
	public int existeUsuario(String user) {

		
		PreparedStatement ps =null;
		ResultSet result = null;
		Connection con = getConexion();
		
		String sql = "SELECT COUNT(idUsuario) FROM usuarios WHERE usuario = ?"; 
		
		
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, user);
				result =  ps.executeQuery();
				
				if(result.next()) {
					return result.getInt(1);
				}
				
				return 1;


			} catch (SQLException e) {
				e.printStackTrace();
				return 1;
			}

		
	}

	public boolean validacionEmail(String correo) {
		
		//Patrón para validar que el correo ingresado tenga el formato de un email
		Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		
		Matcher mather = pattern.matcher(correo);
		
		return mather.find();
				
	}
	
}
