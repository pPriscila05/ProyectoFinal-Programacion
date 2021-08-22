//PRISCILA POLANCO, 2020-10331
//USO DE PATRONES DE DISEÑO (SINGLETON)
//APLICACIONES DE LOS PILARES DE LA POO
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;
import java.awt.event.ActionEvent;

public class EMProductos extends JFrame {
	MYSQLConexion cc = new MYSQLConexion();
	Connection con = cc.getConexion();
	Statement st;
	
	public static GestionProductos gesprod;
	
	
	public JPanel contentPane;
	public JTextField txtidproducto;
	public JTextField txtMarca;
	public JTextField txtNombre;
	public JTextField txtCategoria;
	public JTextField txtPrecio;
	public JTextField txtCantidad;


	public EMProductos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 723, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(null);
		panel.setBackground(new Color(145, 153, 195));
		panel.setBounds(0, 0, 718, 398);
		contentPane.add(panel);
		
		JLabel lblIdproducto = new JLabel("idProducto: ");
		lblIdproducto.setForeground(SystemColor.desktop);
		lblIdproducto.setHorizontalAlignment(SwingConstants.TRAILING);
		lblIdproducto.setFont(new Font("Bittermilk", Font.PLAIN, 21));
		lblIdproducto.setBounds(71, 122, 116, 30);
		panel.add(lblIdproducto);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setForeground(SystemColor.desktop);
		lblNombre.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNombre.setFont(new Font("Bittermilk", Font.PLAIN, 21));
		lblNombre.setBounds(96, 163, 91, 30);
		panel.add(lblNombre);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setForeground(SystemColor.desktop);
		lblMarca.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMarca.setFont(new Font("Bittermilk", Font.PLAIN, 21));
		lblMarca.setBounds(96, 204, 84, 30);
		panel.add(lblMarca);
		
		JLabel lblCategora = new JLabel("Categor\u00EDa:");
		lblCategora.setForeground(SystemColor.desktop);
		lblCategora.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCategora.setFont(new Font("Bittermilk", Font.PLAIN, 21));
		lblCategora.setBounds(89, 240, 91, 32);
		panel.add(lblCategora);
		
		txtidproducto = new JTextField();
		txtidproducto.setFont(new Font("HOLLYWOOD STARFIRE", Font.PLAIN, 14));
		txtidproducto.setEditable(false);
		txtidproducto.setColumns(10);
		txtidproducto.setBackground(SystemColor.controlLtHighlight);
		txtidproducto.setBounds(192, 122, 187, 25);
		panel.add(txtidproducto);
		
		txtMarca = new JTextField();
		txtMarca.setFont(new Font("HOLLYWOOD STARFIRE", Font.PLAIN, 14));
		txtMarca.setColumns(10);
		txtMarca.setBackground(SystemColor.controlLtHighlight);
		txtMarca.setBounds(192, 206, 187, 25);
		panel.add(txtMarca);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("HOLLYWOOD STARFIRE", Font.PLAIN, 14));
		txtNombre.setColumns(10);
		txtNombre.setBackground(SystemColor.controlLtHighlight);
		txtNombre.setBounds(192, 164, 187, 25);
		panel.add(txtNombre);
		
		txtCategoria = new JTextField();
		txtCategoria.setFont(new Font("HOLLYWOOD STARFIRE", Font.PLAIN, 14));
		txtCategoria.setColumns(10);
		txtCategoria.setBackground(SystemColor.controlLtHighlight);
		txtCategoria.setBounds(192, 246, 187, 25);
		panel.add(txtCategoria);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setForeground(SystemColor.desktop);
		lblPrecio.setFont(new Font("Bittermilk", Font.PLAIN, 21));
		lblPrecio.setBounds(123, 283, 70, 30);
		panel.add(lblPrecio);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setForeground(SystemColor.desktop);
		lblCantidad.setFont(new Font("Bittermilk", Font.PLAIN, 21));
		lblCantidad.setBounds(103, 324, 91, 30);
		panel.add(lblCantidad);
		
		txtPrecio = new JTextField();
		txtPrecio.setFont(new Font("HOLLYWOOD STARFIRE", Font.PLAIN, 14));
		txtPrecio.setColumns(10);
		txtPrecio.setBackground(SystemColor.controlLtHighlight);
		txtPrecio.setBounds(193, 286, 187, 25);
		panel.add(txtPrecio);
		
		txtCantidad = new JTextField();
		txtCantidad.setFont(new Font("HOLLYWOOD STARFIRE", Font.PLAIN, 14));
		txtCantidad.setColumns(10);
		txtCantidad.setBackground(SystemColor.controlLtHighlight);
		txtCantidad.setBounds(193, 328, 187, 25);
		panel.add(txtCantidad);
		
		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.setForeground(SystemColor.desktop);
		btnGuardar.setBackground(new Color(212, 172, 13));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				EMProductos em = new EMProductos();
				em.setVisible(false);
				modificar();
				GestionProductos gp = new GestionProductos();
				gp.setVisible(true);
				mostrarDatos();
				
				}
		
			
		});
		btnGuardar.setIcon(new ImageIcon("C:\\Users\\prisc\\OneDrive\\Escritorio\\JAVA\\Final\\images\\save.png"));
		btnGuardar.setFont(new Font("Pumpkin Pancakes", Font.PLAIN, 25));
		btnGuardar.setBounds(408, 125, 215, 68);
		btnGuardar.setFocusable(false);
		panel.add(btnGuardar);
		
		JButton btnNewButton = new JButton("ELIMINAR");
		btnNewButton.setForeground(SystemColor.desktop);
		btnNewButton.setBackground(new Color(212, 172, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				EMProductos em = new EMProductos();
				em.setVisible(false);
				eliminar();
				GestionProductos gp = new GestionProductos();
				gp.setVisible(true);
				mostrarDatos();
				


			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\prisc\\OneDrive\\Escritorio\\JAVA\\Final\\images\\deleteprod.png"));
		btnNewButton.setFont(new Font("Pumpkin Pancakes", Font.PLAIN, 22));
		btnNewButton.setFocusable(false);
		btnNewButton.setBounds(408, 204, 215, 68);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("GESTIONAR PRODUCTOS");
		lblNewLabel.setForeground(SystemColor.desktop);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\prisc\\OneDrive\\Escritorio\\JAVA\\Final\\images\\gestionprod.png"));
		lblNewLabel.setFont(new Font("HOLLYWOOD STARFIRE", Font.PLAIN, 37));
		lblNewLabel.setBounds(80, 15, 565, 90);
		panel.add(lblNewLabel);
		
		JButton btnRegresar = new JButton("REGRESAR");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnRegresar.setForeground(SystemColor.desktop);
		btnRegresar.setIcon(new ImageIcon("C:\\Users\\prisc\\OneDrive\\Escritorio\\JAVA\\Final\\images\\back-arrow (1).png"));
		btnRegresar.setFont(new Font("Pumpkin Pancakes", Font.PLAIN, 22));
		btnRegresar.setBackground(new Color(212, 172, 13));
		btnRegresar.setFocusable(false);
		btnRegresar.setBounds(408, 283, 215, 68);
		panel.add(btnRegresar);
	}
	
	public void modificar() {
		
		try {
			con =cc.getConexion();
			String idProducto =txtidproducto.getText();

			PreparedStatement ps = con.prepareStatement("UPDATE productos SET nombre =?, marca = ?, categoria = ?, precio = ?, cantidad = ? WHERE idproducto = " +idProducto);
			ps.setString(1, txtNombre.getText());
			ps.setString(2, txtMarca.getText());
			ps.setString(3, txtCategoria.getText());
			ps.setString(4, txtPrecio.getText());
			ps.setString(5, txtCantidad.getText());
			ps.executeUpdate();
		    JOptionPane.showMessageDialog(null,"PRODUCTO MODIFICADO.","INFO",JOptionPane.INFORMATION_MESSAGE);
			limpiarCajas();
			mostrarDatos();

			
		} catch (Exception e) {
		    JOptionPane.showMessageDialog(null,"NINGÚN PRODUCTO HA SIDO MODIFICADO.","ERROR",JOptionPane.ERROR_MESSAGE);
		}
								
	}
	

	public void eliminar() {
		try {
			con =cc.getConexion();
			String idProducto =txtidproducto.getText();

			PreparedStatement ps = con.prepareStatement("DELETE FROM productos WHERE idproducto= " +idProducto);
			ps.executeUpdate();
		    JOptionPane.showMessageDialog(null,"PRODUCTO ELIMINADO.","INFO",JOptionPane.INFORMATION_MESSAGE);
			limpiarCajas();

		} catch (Exception e) {
		    JOptionPane.showMessageDialog(null,"NINGÚN PRODUCTO HA SIDO ELIMINADO.","ERROR",JOptionPane.ERROR_MESSAGE);
		}
	}
	public void mostrarDatos() {
		String[] columnas ={"idProducto", "Nombre", "Marca", "Categoría", "Precio", "Cantidad"};
		String [] registros = new String[6];
		
		DefaultTableModel modelo = new DefaultTableModel(null, columnas);
		
		String sql ="SELECT * FROM productos";
		try {
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				
				registros[0]=rs.getString("idproducto");
				registros[1]=rs.getString("nombre");
				registros[2]=rs.getString("marca");
				registros[3]=rs.getString("categoria");
				registros[4]=rs.getString("precio");
				registros[5]=rs.getString("cantidad");				
				modelo.addRow(registros);
				
			}
			GestionProductos gp = new GestionProductos();
			gp.tabla.setModel(modelo);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al mostrar datos: " +e.getMessage());
		}
			
	}

	public void limpiarCajas() {
		
		txtidproducto.setText("");
		txtNombre.setText("");
		txtMarca.setText("");
		txtCategoria.setText("");
		txtPrecio.setText("");
		txtCantidad.setText("");
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EMProductos frame = new EMProductos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}




}
