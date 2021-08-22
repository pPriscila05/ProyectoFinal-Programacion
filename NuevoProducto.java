import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;

public class NuevoProducto extends JFrame {
	
	MYSQLConexion cc = new MYSQLConexion();
	Connection con = cc.getConexion();
	Statement st;

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtMarca;
	private JTextField txtCategoria;
	private JTextField txtPrecio;
	private JTextField txtCantidad;


	public NuevoProducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 656);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(69, 179, 157));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NEW PRODUCTS");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("HOLLYWOOD STARFIRE", Font.BOLD, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\prisc\\OneDrive\\Escritorio\\JAVA\\Final\\images\\reserva (1).png"));
		lblNewLabel.setBounds(100, 78, 353, 99);
		contentPane.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setForeground(Color.BLACK);
		lblNombre.setFont(new Font("Bittermilk", Font.BOLD, 34));
		lblNombre.setBounds(71, 188, 131, 30);
		contentPane.add(lblNombre);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setForeground(Color.BLACK);
		lblMarca.setFont(new Font("Bittermilk", Font.BOLD, 34));
		lblMarca.setBounds(95, 246, 104, 37);
		contentPane.add(lblMarca);
		
		JLabel lblCategoria = new JLabel("Categor\u00EDa:");
		lblCategoria.setForeground(Color.BLACK);
		lblCategoria.setFont(new Font("Bittermilk", Font.BOLD, 34));
		lblCategoria.setBounds(52, 306, 147, 37);
		contentPane.add(lblCategoria);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setForeground(Color.BLACK);
		lblPrecio.setFont(new Font("Bittermilk", Font.BOLD, 34));
		lblPrecio.setBounds(95, 365, 104, 37);
		contentPane.add(lblPrecio);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setForeground(Color.BLACK);
		lblCantidad.setFont(new Font("Bittermilk", Font.BOLD, 34));
		lblCantidad.setBounds(52, 423, 147, 37);
		contentPane.add(lblCantidad);
		
		txtNombre = new JTextField();
		txtNombre.setBackground(SystemColor.textHighlightText);
		txtNombre.setBounds(212, 194, 181, 30);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtMarca = new JTextField();
		txtMarca.setBackground(SystemColor.textHighlightText);
		txtMarca.setColumns(10);
		txtMarca.setBounds(212, 255, 181, 30);
		contentPane.add(txtMarca);
		
		txtCategoria = new JTextField();
		txtCategoria.setBackground(SystemColor.textHighlightText);
		txtCategoria.setColumns(10);
		txtCategoria.setBounds(212, 315, 181, 30);
		contentPane.add(txtCategoria);
		
		txtPrecio = new JTextField();
		txtPrecio.setBackground(SystemColor.textHighlightText);
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(212, 370, 181, 30);
		contentPane.add(txtPrecio);
		
		txtCantidad = new JTextField();
		txtCantidad.setBackground(SystemColor.textHighlightText);
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(209, 425, 184, 30);
		contentPane.add(txtCantidad);
		
		JButton btnNewButton = new JButton("AGREGAR PRODUCTO");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(new Color(237, 187, 153));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertarDatos();
				NuevoProducto.this.dispose();
				GestionProductos gp =  new GestionProductos();
				gp.setVisible(true);
				gp.setLocationRelativeTo(lblCantidad);
				
				
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\prisc\\OneDrive\\Escritorio\\JAVA\\Final\\images\\carrito-de-compras (1).png"));
		btnNewButton.setFont(new Font("Pumpkin Pancakes", Font.PLAIN, 54));
		btnNewButton.setFocusable(false);
		btnNewButton.setBounds(29, 497, 499, 92);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("REGRESAR");
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBackground(new Color(237, 187, 153));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				GestionProductos gp = new GestionProductos();				
			}
		});
		btnNewButton_1.setFont(new Font("Pumpkin Pancakes", Font.BOLD, 20));
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\prisc\\OneDrive\\Escritorio\\JAVA\\Final\\images\\goback.png"));
		btnNewButton_1.setBounds(10, 11, 187, 56);
		contentPane.add(btnNewButton_1);
		setLocationRelativeTo(null);

	}
	
	public void insertarDatos() {



		if (txtNombre.getText().equals("") || txtMarca.equals("") || txtCategoria.equals("") || txtPrecio.equals("")
				|| txtCantidad.getText().equals("")) {

			JOptionPane.showMessageDialog(null, "¡FAVOR DE COMPLETAR TODOS LOS CAMPOS!", "INFO", JOptionPane.INFORMATION_MESSAGE);
		}else {
		
		try {
			
			String SQL ="INSERT INTO productos(nombre, marca, categoria, precio, cantidad) VALUES (?,?,?,?,?)";
			
			PreparedStatement pst = con.prepareStatement(SQL);
			pst.setString(1, txtNombre.getText());
			pst.setString(2, txtMarca.getText());
			pst.setString(3, txtCategoria.getText());
			pst.setString(4, txtPrecio.getText());
			pst.setString(5, txtCantidad.getText());
			pst.execute();
			JOptionPane.showMessageDialog(null, "PRODUCTO ALMACENADO EXITOSAMENTE.", "INFO", JOptionPane.INFORMATION_MESSAGE);
			GestionProductos gp = new GestionProductos();
			gp.mostrarDatos();
			limpiarCajas();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "PRODUCTO NO GUARDADO: " +e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

		}
		
	}
	}
	
	public void limpiarCajas() {
		
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
					NuevoProducto frame = new NuevoProducto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
}
