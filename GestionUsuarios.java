//PRISCILA POLANCO, 2020-10331
//USO DE PATRONES DE DISEÑO (SINGLETON)
//APLICACIONES DE LOS PILARES DE LA POO
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionUsuarios extends JFrame {
	
	MYSQLConexion cc = new MYSQLConexion();
	Connection con = cc.getConexion();
	Statement st;

	int idUsuario;
	private JPanel contentPane;
	private JTable tabla;
	private JTextField txtidusuario;
	private JTextField txtnombre;
	private JTextField txtusuario;
	private JTextField txtapellido;
	private JTextField txttelefono;
	private JTextField txtcorreo;
	private JTextField txtcontraseña;




	
	public GestionUsuarios() {
		
		GestionUsuarios.this.setLocationRelativeTo(null);
		this.setTitle("Inicio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 803, 758);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 222, 179));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 104, 757, 264);
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		contentPane.setLayout(null);
		contentPane.add(scrollPane);
		
		tabla = new JTable();
		tabla.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		tabla.setFont(new Font("HOLLYWOOD STARFIRE", Font.BOLD, 12));
		tabla.setBackground(SystemColor.inactiveCaptionBorder);
		tabla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int filaSeleccionada = tabla.getSelectedRow();
				
				if(filaSeleccionada==-1) {
					JOptionPane.showMessageDialog(null, "Usuario no seleccionado");
				}else {
					idUsuario= Integer.parseInt((String)tabla.getValueAt(filaSeleccionada, 0));
					String usuario = (String)tabla.getValueAt(filaSeleccionada, 1);
					String nombre = (String)tabla.getValueAt(filaSeleccionada, 2);
					String apellido = (String)tabla.getValueAt(filaSeleccionada, 3);
					String telefono = (String)tabla.getValueAt(filaSeleccionada, 4);
					String correo = (String)tabla.getValueAt(filaSeleccionada, 5);
					String contra = (String)tabla.getValueAt(filaSeleccionada, 6);
					
					txtidusuario.setText(""+idUsuario);
					txtusuario.setText(usuario);
					txtnombre.setText(nombre);
					txtapellido.setText(apellido);
					txttelefono.setText(telefono);
					txtcorreo.setText(correo);
					txtcontraseña.setText(contra);
				
				}
			}		
		});
		tabla.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"idUsuario", "Usuario", "Nombre", "Apellido", "Tel\u00E9fono", "Correo", "Contrase\u00F1a"
			}
		));
		scrollPane.setViewportView(tabla);
		
		JPanel panel = new JPanel();
		panel.setBounds(21, 379, 757, 201);
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Datos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(153, 204, 204));
		contentPane.add(panel);
		panel.setLayout(null);

		
		JLabel lblidusuario = new JLabel("idUsuario: ");
		lblidusuario.setForeground(Color.BLACK);
		lblidusuario.setHorizontalAlignment(SwingConstants.TRAILING);
		lblidusuario.setFont(new Font("Bittermilk", Font.PLAIN, 21));
		lblidusuario.setBounds(28, 29, 99, 30);
		panel.add(lblidusuario);
		
		JLabel lblusuario = new JLabel("Usuario: ");
		lblusuario.setForeground(Color.BLACK);
		lblusuario.setHorizontalAlignment(SwingConstants.TRAILING);
		lblusuario.setFont(new Font("Bittermilk", Font.PLAIN, 21));
		lblusuario.setBounds(35, 72, 91, 30);
		panel.add(lblusuario);
		
		JLabel lblnombre = new JLabel("Nombre:");
		lblnombre.setForeground(Color.BLACK);
		lblnombre.setHorizontalAlignment(SwingConstants.TRAILING);
		lblnombre.setFont(new Font("Bittermilk", Font.PLAIN, 21));
		lblnombre.setBounds(35, 113, 84, 30);
		panel.add(lblnombre);
		
		JLabel lblapellido = new JLabel("Apellido:");
		lblapellido.setForeground(Color.BLACK);
		lblapellido.setHorizontalAlignment(SwingConstants.TRAILING);
		lblapellido.setFont(new Font("Bittermilk", Font.PLAIN, 21));
		lblapellido.setBounds(28, 149, 91, 32);
		panel.add(lblapellido);
		
		txtidusuario = new JTextField();
		txtidusuario.setFont(new Font("HOLLYWOOD STARFIRE", Font.PLAIN, 14));
		txtidusuario.setEnabled(false);
		txtidusuario.setEditable(false);
		txtidusuario.setColumns(10);
		txtidusuario.setBackground(SystemColor.inactiveCaptionBorder);
		txtidusuario.setBounds(131, 31, 187, 25);
		panel.add(txtidusuario);
		
		txtnombre = new JTextField();
		txtnombre.setFont(new Font("HOLLYWOOD STARFIRE", Font.PLAIN, 14));
		txtnombre.setColumns(10);
		txtnombre.setBackground(SystemColor.inactiveCaptionBorder);
		txtnombre.setBounds(131, 115, 187, 25);
		panel.add(txtnombre);
		
		txtusuario = new JTextField();
		txtusuario.setFont(new Font("HOLLYWOOD STARFIRE", Font.PLAIN, 14));
		txtusuario.setColumns(10);
		txtusuario.setBackground(SystemColor.inactiveCaptionBorder);
		txtusuario.setBounds(131, 73, 187, 25);
		panel.add(txtusuario);
		
		txtapellido = new JTextField();
		txtapellido.setFont(new Font("HOLLYWOOD STARFIRE", Font.PLAIN, 14));
		txtapellido.setColumns(10);
		txtapellido.setBackground(SystemColor.inactiveCaptionBorder);
		txtapellido.setBounds(131, 155, 187, 25);
		panel.add(txtapellido);
		
		JLabel lbltelefono = new JLabel("Tel\u00E9fono:");
		lbltelefono.setForeground(Color.BLACK);
		lbltelefono.setFont(new Font("Bittermilk", Font.PLAIN, 21));
		lbltelefono.setBounds(402, 28, 91, 30);
		panel.add(lbltelefono);
		
		JLabel lblcorreo = new JLabel("E-mail:");
		lblcorreo.setForeground(Color.BLACK);
		lblcorreo.setFont(new Font("Bittermilk", Font.PLAIN, 21));
		lblcorreo.setBounds(419, 70, 66, 30);
		panel.add(lblcorreo);
		
		JLabel lblcontraseña = new JLabel("Contrase\u00F1a: ");
		lblcontraseña.setForeground(Color.BLACK);
		lblcontraseña.setFont(new Font("Bittermilk", Font.PLAIN, 21));
		lblcontraseña.setBounds(385, 114, 105, 30);
		panel.add(lblcontraseña);
		
		txttelefono = new JTextField();
		txttelefono.setFont(new Font("HOLLYWOOD STARFIRE", Font.PLAIN, 14));
		txttelefono.setColumns(10);
		txttelefono.setBackground(SystemColor.inactiveCaptionBorder);
		txttelefono.setBounds(489, 31, 187, 25);
		panel.add(txttelefono);
		
		txtcorreo = new JTextField();
		txtcorreo.setFont(new Font("HOLLYWOOD STARFIRE", Font.PLAIN, 14));
		txtcorreo.setColumns(10);
		txtcorreo.setBackground(SystemColor.inactiveCaptionBorder);
		txtcorreo.setBounds(489, 73, 187, 25);
		panel.add(txtcorreo);
		
		txtcontraseña = new JTextField();
		txtcontraseña.setFont(new Font("HOLLYWOOD STARFIRE", Font.PLAIN, 14));
		txtcontraseña.setColumns(10);
		txtcontraseña.setBackground(SystemColor.inactiveCaptionBorder);
		txtcontraseña.setBounds(489, 119, 187, 25);
		panel.add(txtcontraseña);
		
		
		JLabel lblNewLabel = new JLabel("USER MANAGEMENT");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(170, 33, 501, 40);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("ELEGANT TYPEWRITER", Font.BOLD, 47));
		contentPane.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(21, 591, 757, 116);
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Operaciones", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 0, 0)));
		panel_1.setBackground(new Color(153, 204, 204));
		contentPane.add(panel_1);
		
		JButton btguardar = new JButton("GUARDAR");
		btguardar.setForeground(Color.BLACK);
		btguardar.setFocusable(false);

		btguardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarDatos();
				mostrarDatos();
			}
		});
		btguardar.setIcon(new ImageIcon("C:\\Users\\prisc\\OneDrive\\Escritorio\\JAVA\\Final\\images\\guardarusuario.png"));
		btguardar.setHorizontalAlignment(SwingConstants.LEADING);
		btguardar.setFont(new Font("HOLLYWOOD STARFIRE", Font.BOLD, 14));
		btguardar.setBackground(new Color(102, 153, 204));
		btguardar.setBounds(42, 32, 155, 55);
		panel_1.add(btguardar);
		
		JButton btnuevo = new JButton("NUEVO");
		btnuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarCajas();
			}
		});
		btnuevo.setIcon(new ImageIcon("C:\\Users\\prisc\\OneDrive\\Escritorio\\JAVA\\Final\\images\\agregar-usuario.png"));
		btnuevo.setForeground(Color.BLACK);
		btnuevo.setFocusable(false);
		btnuevo.setFont(new Font("HOLLYWOOD STARFIRE", Font.BOLD, 14));
		btnuevo.setBackground(new Color(102, 153, 204));
		btnuevo.setBounds(207, 32, 145, 55);
		panel_1.add(btnuevo);
		
		JButton btModificar = new JButton("MODIFICAR");
		btModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificar();
				mostrarDatos();
			}
		});
		btModificar.setIcon(new ImageIcon("C:\\Users\\prisc\\OneDrive\\Escritorio\\JAVA\\Final\\images\\usuarioedit.png"));
		btModificar.setForeground(Color.BLACK);
		btModificar.setFocusable(false);
		btModificar.setFont(new Font("HOLLYWOOD STARFIRE", Font.BOLD, 14));
		btModificar.setBackground(new Color(102, 153, 204));
		btModificar.setBounds(362, 32, 173, 55);
		panel_1.add(btModificar);
		
		JButton btEliminar = new JButton("ELIMINAR");
		btEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
				mostrarDatos();
			}
		});
		btEliminar.setIcon(new ImageIcon("C:\\Users\\prisc\\OneDrive\\Escritorio\\JAVA\\Final\\images\\delete.png"));
		btEliminar.setForeground(Color.BLACK);
		btEliminar.setFocusable(false);
		btEliminar.setFont(new Font("HOLLYWOOD STARFIRE", Font.BOLD, 14));
		btEliminar.setBackground(new Color(102, 153, 204));
		btEliminar.setBounds(545, 32, 170, 55);
		panel_1.add(btEliminar);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\prisc\\OneDrive\\Escritorio\\JAVA\\Final\\images\\group.png"));
		lblNewLabel_1.setBounds(120, 22, 69, 60);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainChoice mc = new MainChoice();
				mc.setVisible(true);
				GestionUsuarios.this.dispose();
			}
		});
		btnNewButton.setBackground(new Color(172, 236, 244));
		btnNewButton.setFocusable(false);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\prisc\\OneDrive\\Escritorio\\JAVA\\Final\\images\\goback.png"));
		btnNewButton.setBounds(681, 11, 82, 71);
		contentPane.add(btnNewButton);
		setLocationRelativeTo(null);
		mostrarDatos();
	}
	

	public void mostrarDatos() {
		String[] columnas ={"idUsuario", "Usuario", "Nombre", "Apellido", "Teléfono", "Correo", "Contraseña"};
		String [] registros = new String[7];
		
		DefaultTableModel modelo = new DefaultTableModel(null, columnas);
		
		String sql ="SELECT * FROM usuarios";
		try {
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				
				registros[0]=rs.getString("idUsuario");
				registros[1]=rs.getString("usuario");
				registros[2]=rs.getString("nombre");
				registros[3]=rs.getString("apellido");
				registros[4]=rs.getString("telefono");
				registros[5]=rs.getString("correo");
				registros[6]=rs.getString("contraseña");
				
				modelo.addRow(registros);
				
			}
			
			tabla.setModel(modelo);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al mostrar datos: " +e.getMessage());
		}
			
	}
	
	public void modificar() {
		int g = tabla.getSelectedRow();

		String usuario =txtusuario.getText();
		String nombre =txtnombre.getText();
		String apellido =txtapellido.getText();
		String telefono =txttelefono.getText();
		String correo = txtcorreo.getText();
		String contraseña = txtcontraseña.getText();

		String sql = "UPDATE usuarios SET usuario ='" + usuario + "',nombre = '" + nombre +"',apellido ='" + apellido + "', telefono = '" + telefono + "',correo = '" + correo + "',contraseña = '" + contraseña +"'WHERE idUsuario = " +idUsuario;
		
		if(g==-1) {
			JOptionPane.showMessageDialog(null, "Para modificar datos, debe seleccionar una fila.","INFO", JOptionPane.INFORMATION_MESSAGE);
		}else {
			try {
				if(usuario!=null || nombre!= null || apellido!= null || telefono!= null || correo!= null || contraseña!= null ) {
					
					con =cc.getConexion();
					st = con.createStatement();
					st.executeUpdate(sql);
					JOptionPane.showMessageDialog(null, "Usuario Actualizado");
					limpiarCajas();
							
				
				}else {
					JOptionPane.showMessageDialog(null, "ERROR. Debe registrar datos");
				}
				
			} catch (Exception e) {
			}
			
		}
		
		}
	public void eliminar() {
		int rg = tabla.getSelectedRow();
		
		if(rg==-1) {
			JOptionPane.showMessageDialog(null, "Para eliminar, debe seleccionar una fila.", "INFO", JOptionPane.INFORMATION_MESSAGE);
			
		}else {
			String sql = "DELETE FROM usuarios WHERE idUsuario ="+idUsuario;
			
			try {
				con=cc.getConexion();
				st=con.createStatement();
				st.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "Usuario eliminado.");
				limpiarCajas();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
		
	public void insertarDatos() {
		String pass = new String(txtcontraseña.getText());


		if (txtusuario.getText().equals("") || txtnombre.equals("") || txtapellido.equals("") || txttelefono.equals("")
				|| txtcorreo.equals("") || pass.equals("")) {

			JOptionPane.showMessageDialog(null, "¡FAVOR DE COMPLETAR TODOS LOS CAMPOS!", "INFO",
					JOptionPane.INFORMATION_MESSAGE);
		}else {
			
			
		
		try {
			
			String SQL ="INSERT INTO usuarios (usuario, nombre,apellido,telefono,correo,contraseña) VALUES (?,?,?,?,?,?)";
			
			PreparedStatement pst = con.prepareStatement(SQL);
			pst.setString(1, txtusuario.getText());
			pst.setString(2, txtnombre.getText());
			pst.setString(3, txtapellido.getText());
			pst.setString(4, txttelefono.getText());
			pst.setString(5, txtcorreo.getText());
			pst.setString(6, txtcontraseña.getText());
			pst.execute();
			JOptionPane.showMessageDialog(null, "REGISTRO ALMACENADO");
			limpiarCajas();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "REGISTRO NO GUARDADO: " +e.getMessage());

		}
		
	}
	}
	
	
	public void limpiarCajas() {
		
		txtidusuario.setText("");
		txtusuario.setText("");
		txtnombre.setText("");
		txtapellido.setText("");
		txttelefono.setText("");
		txtcorreo.setText("");
		txtcontraseña.setText("");
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionUsuarios frame = new GestionUsuarios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
