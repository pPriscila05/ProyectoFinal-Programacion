//PRISCILA POLANCO, 2020-10331
//USO DE PATRONES DE DISEÑO (SINGLETON)
//APLICACIONES DE LOS PILARES DE LA POO
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JTextField txtCorreo;
	private JPasswordField txtContraseña;
	private JPasswordField txtContraseña1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 565);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(188, 143, 143));
		panel.setBounds(0, 0, 507, 104);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("REGISTER FORM");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Rose Cake - Personal Use", Font.BOLD, 58));
		lblNewLabel.setBounds(48, 29, 404, 57);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(248, 248, 255));
		panel_1.setBounds(0, 104, 507, 426);
		contentPane.add(panel_1);
		
		JLabel usulabel = new JLabel("Nombre de usuario:");
		usulabel.setFont(new Font("Bittermilk", Font.PLAIN, 19));
		usulabel.setBounds(77, 32, 150, 27);
		panel_1.add(usulabel);
		
		JLabel nomlabel = new JLabel("Nombre: ");
		nomlabel.setHorizontalAlignment(SwingConstants.TRAILING);
		nomlabel.setFont(new Font("Bittermilk", Font.PLAIN, 19));
		nomlabel.setBounds(122, 75, 105, 19);
		panel_1.add(nomlabel);
		
		JLabel lblApellido = new JLabel("Apellido:  ");
		lblApellido.setHorizontalAlignment(SwingConstants.TRAILING);
		lblApellido.setFont(new Font("Bittermilk", Font.PLAIN, 19));
		lblApellido.setBounds(150, 118, 83, 19);
		panel_1.add(lblApellido);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono: ");
		lblTelfono.setFont(new Font("Bittermilk", Font.PLAIN, 19));
		lblTelfono.setBounds(151, 155, 76, 19);
		panel_1.add(lblTelfono);
		
		JLabel lblCorreoElectrnico = new JLabel("Correo electr\u00F3nico: ");
		lblCorreoElectrnico.setFont(new Font("Bittermilk", Font.PLAIN, 19));
		lblCorreoElectrnico.setBounds(80, 190, 146, 19);
		panel_1.add(lblCorreoElectrnico);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a: ");
		lblContrasea.setFont(new Font("Bittermilk", Font.PLAIN, 19));
		lblContrasea.setBounds(128, 226, 94, 19);
		panel_1.add(lblContrasea);
		
		JLabel lblConfirmarContrasea = new JLabel("Confirmar contrase\u00F1a: ");
		lblConfirmarContrasea.setFont(new Font("Bittermilk", Font.PLAIN, 19));
		lblConfirmarContrasea.setBounds(55, 257, 178, 19);
		panel_1.add(lblConfirmarContrasea);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(235, 32, 195, 25);
		panel_1.add(txtUsuario);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(235, 74, 195, 25);
		panel_1.add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(235, 113, 195, 25);
		panel_1.add(txtApellido);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(235, 150, 195, 25);
		panel_1.add(txtTelefono);
		
		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(235, 184, 195, 25);
		panel_1.add(txtCorreo);
		
		txtContraseña = new JPasswordField();
		txtContraseña.setText("");
		txtContraseña.setBounds(235, 220, 195, 25);
		panel_1.add(txtContraseña);
		
		txtContraseña1 = new JPasswordField();
		txtContraseña1.setText("");
		txtContraseña1.setBounds(235, 251, 195, 25);
		panel_1.add(txtContraseña1);
		
		JButton btnCancel = new JButton("CANCELAR");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main1 m1 = new Main1();
				m1.setVisible(true);
				Register.this.dispose();
			}
		});
		btnCancel.setVerticalAlignment(SwingConstants.BOTTOM);
		btnCancel.setFocusable(false);

		btnCancel.setFont(new Font("Pumpkin Pancakes", Font.BOLD, 22));
		btnCancel.setBackground(new Color(204, 0, 0));
		btnCancel.setBounds(80, 311, 150, 41);
		panel_1.add(btnCancel);
		
		JButton btnRegistrar = new JButton("REGISTRARME");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrar();
			}
		});
		btnRegistrar.setVerticalAlignment(SwingConstants.BOTTOM);
		btnRegistrar.setFont(new Font("Pumpkin Pancakes", Font.BOLD, 22));
		btnRegistrar.setBackground(new Color(51, 153, 204));
		btnRegistrar.setFocusable(false);

		btnRegistrar.setBounds(268, 311, 150, 41);
		panel_1.add(btnRegistrar);
		
		JLabel lblregister = new JLabel("\u00BFYa tienes una cuenta? Ingresa ahora");
		lblregister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		        Login log = new Login();
		        log.setVisible(true);
		        Register.this.dispose();
		        log.setLocationRelativeTo(null);
		        log.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		lblregister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblregister.setHorizontalAlignment(SwingConstants.CENTER);
		lblregister.setFont(new Font("ELEGANT TYPEWRITER", Font.BOLD, 18));
		lblregister.setBounds(77, 368, 351, 27);
		panel_1.add(lblregister);
	}
	
	protected void registrar() {
		RegisterData rd = new RegisterData();
		UserData mod = new UserData();

		String pass = new String(txtContraseña.getPassword());
		String pass2 = new String(txtContraseña1.getPassword());

		if (txtUsuario.getText().equals("") || txtNombre.equals("") || txtApellido.equals("") || txtTelefono.equals("")
				|| txtCorreo.equals("") || pass.equals("") || pass2.equals("")) {

			JOptionPane.showMessageDialog(null, "¡FAVOR DE COMPLETAR TODOS LOS CAMPOS!", "INFO",
					JOptionPane.INFORMATION_MESSAGE);

		} else {

			if (pass.equals(pass2)) {

				if (rd.existeUsuario(txtUsuario.getText()) == 0) {
					
					if(rd.validacionEmail(txtCorreo.getText())) {


					mod.setUsuario(txtUsuario.getText());
					mod.setContraseña(pass);
					mod.setNombre(txtNombre.getText());
					mod.setApellido(txtApellido.getText());
					mod.setTelefono(txtTelefono.getText());
					mod.setCorreo(txtCorreo.getText());

					if (rd.registrar(mod)) {
						JOptionPane.showMessageDialog(null, "BIENVENIDO. HAZ SIDO REGISTRADO.");
						limpiar();
						MainChoice mc = new MainChoice();
						mc.setVisible(true);
						Register.this.dispose();

					} else {
						JOptionPane.showMessageDialog(contentPane, "NO HAS PODIDO SER REGISTRADO. INTENTA NUEVAMENTE.",
								"ERROR", JOptionPane.ERROR_MESSAGE);

					}
					}else {
						JOptionPane.showMessageDialog(contentPane, "EL CORREO ELECTRÓNICO NO ES VÁLIDO", "ERROR",
							JOptionPane.INFORMATION_MESSAGE);
					}
					
				} else {
					JOptionPane.showMessageDialog(contentPane, "EL USUARIO YA EXISTE", "ERROR",
							JOptionPane.INFORMATION_MESSAGE);
				}

			} else {
				JOptionPane.showMessageDialog(contentPane, "LAS CONTRASEÑAS NO COINCIDEN.", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void limpiar() {
		txtUsuario.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtTelefono.setText("");
		txtCorreo.setText("");
		txtContraseña.setText("");
		txtContraseña1.setText("");

	}

	protected void salir() {
		System.exit(0);
	}
}
