//PRISCILA POLANCO, 2020-10331
//USO DE PATRONES DE DISEÑO (SINGLETON)
//APLICACIONES DE LOS PILARES DE LA POO
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;

public class GestionProductos extends JFrame {
	
	MYSQLConexion cc = new MYSQLConexion();
	Connection con = cc.getConexion();
	Statement st;
	
	int idProducto;

	private DefaultTableModel modelo;
	private JPanel contentPane;
	public JTable tabla;

	/**
	 * Launch the application.
	 */


	public GestionProductos() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 963, 708);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(141, 175, 161));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PRODUCTS MANAGEMENT");
		lblNewLabel.setForeground(SystemColor.desktop);
		lblNewLabel.setBounds(185, 25, 648, 74);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("ELEGANT TYPEWRITER", Font.BOLD, 55));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(119, 25, 70, 70);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\prisc\\OneDrive\\Escritorio\\JAVA\\Final\\images\\inventario (1).png"));
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 107, 931, 414);
		contentPane.add(scrollPane);
		
		tabla = new JTable();
		tabla.setForeground(SystemColor.desktop);
		tabla.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		tabla.setFont(new Font("HOLLYWOOD STARFIRE", Font.BOLD, 12));
		tabla.setBackground(UIManager.getColor("CheckBox.light"));
		tabla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int filaSeleccionada = tabla.getSelectedRow();{
					EMProductos em = new EMProductos();
					em.setVisible(true);
					em.setLocationRelativeTo(null);
								
				if(filaSeleccionada ==-1) {
					JOptionPane.showMessageDialog(null, "Producto no seleccionado");
				}else {
					
					int idProducto= Integer.parseInt((String)tabla.getValueAt(filaSeleccionada, 0));
					String nombre = (String)tabla.getValueAt(filaSeleccionada, 1);
					String marca = (String)tabla.getValueAt(filaSeleccionada, 2);
					String categoria = (String)tabla.getValueAt(filaSeleccionada, 3);
					String precio = (String)tabla.getValueAt(filaSeleccionada, 4);
					String cantidad = (String)tabla.getValueAt(filaSeleccionada, 5);
					

					em.txtidproducto.setText(""+idProducto);
					em.txtNombre.setText(nombre);
					em.txtMarca.setText(marca);
					em.txtCategoria.setText(categoria);
					em.txtPrecio.setText(precio);
					em.txtCantidad.setText(cantidad);
					
					
				} 

				}
					
			}		
				
			
		});
		
		
		
		tabla.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"idProducto", "Nombre", "Marca", "Categor\u00EDa", "Precio", "Cantidad"
			}
		));
		scrollPane.setViewportView(tabla);
		
		JButton btnNuevoProducto = new JButton("NUEVO");
		btnNuevoProducto.setBackground(new Color(52, 73, 105));
		btnNuevoProducto.setForeground(SystemColor.desktop);
		btnNuevoProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NuevoProducto np = new NuevoProducto();
				GestionProductos gesprod = new GestionProductos();
				gesprod.mostrarDatos();
				np.setVisible(true);
				np.setLocationRelativeTo(null);
			}
		});
		btnNuevoProducto.setFont(new Font("Pumpkin Pancakes", Font.BOLD, 38));
		btnNuevoProducto.setFocusable(false);
		btnNuevoProducto.setIcon(new ImageIcon("C:\\Users\\prisc\\OneDrive\\Escritorio\\JAVA\\Final\\images\\newprod.png"));
		btnNuevoProducto.setBounds(41, 532, 229, 101);
		contentPane.add(btnNuevoProducto);
		
		JButton btnBack = new JButton("");
		btnBack.setBackground(new Color(52, 73, 105));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				MainChoice mc = new MainChoice();
				mc.setVisible(true);
			}
		});
		btnBack.setIcon(new ImageIcon("C:\\Users\\prisc\\OneDrive\\Escritorio\\JAVA\\Final\\images\\volver-flecha (1).png"));
		btnBack.setBounds(292, 532, 156, 101);
		contentPane.add(btnBack);
		mostrarDatos();
		setLocationRelativeTo(null);
		
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
			
			tabla.setModel(modelo);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al mostrar datos: " +e.getMessage());
		}
			
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionProductos frame = new GestionProductos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
