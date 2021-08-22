//PRISCILA POLANCO, 2020-10331
//USO DE PATRONES DE DISEÑO (SINGLETON)
//APLICACIONES DE LOS PILARES DE LA POO
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Statement;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends JFrame {

	MYSQLConexion cc = new MYSQLConexion();
	Connection con = cc.getConexion();
	

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 444, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(169, 223, 191));
		panel.setBounds(0, 0, 462, 94);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Rose Cake - Personal Use", Font.BOLD, 63));
		lblNewLabel.setBackground(new Color(216, 191, 216));
		lblNewLabel.setBounds(65, 23, 308, 59);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(210, 180, 222));
		panel_1.setBounds(0, 91, 445, 225);
		contentPane.add(panel_1);
		
		JLabel usuarioLabel = new JLabel("USUARIO:");
		usuarioLabel.setHorizontalAlignment(SwingConstants.CENTER);
		usuarioLabel.setFont(new Font("Bittermilk", Font.PLAIN, 19));
		usuarioLabel.setBounds(54, 38, 87, 21);
		panel_1.add(usuarioLabel);
		
		JLabel contraLabel = new JLabel("CONTRASE\u00D1A: ");
		contraLabel.setFont(new Font("Bittermilk", Font.PLAIN, 19));
		contraLabel.setBounds(54, 70, 115, 30);
		panel_1.add(contraLabel);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBackground(SystemColor.inactiveCaptionBorder);
		txtUsuario.setBounds(170, 35, 195, 25);
		panel_1.add(txtUsuario);
		
		txtPassword = new JPasswordField();
		txtPassword.setBackground(SystemColor.inactiveCaptionBorder);
		txtPassword.setBounds(170, 77, 195, 25);
		panel_1.add(txtPassword);
		
		JButton btnCancel = new JButton("CANCELAR");
		btnCancel.setFocusable(false);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main1 m1 = new Main1();
				m1.setVisible(true);
				setVisible(false);
				
			}
		});
		btnCancel.setVerticalAlignment(SwingConstants.BOTTOM);
		btnCancel.setFont(new Font("Pumpkin Pancakes", Font.BOLD, 23));
		btnCancel.setBackground(new Color(204, 51, 51));
		btnCancel.setBounds(68, 127, 131, 35);
		panel_1.add(btnCancel);
		
		JButton btnLogin = new JButton("INGRESAR");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validarAcceso();
			}
		});
		btnLogin.setVerticalAlignment(SwingConstants.BOTTOM);
		btnLogin.setFocusable(false);
		btnLogin.setFont(new Font("Pumpkin Pancakes", Font.BOLD, 23));
		btnLogin.setBackground(new Color(0, 204, 255));
		btnLogin.setBounds(229, 127, 131, 35);
		panel_1.add(btnLogin);
		
		JLabel linkRegister = new JLabel("\u00BFA\u00FAn no est\u00E1 registrado? Cree una cuenta ahora.");
		linkRegister.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		linkRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		        Register regForm = new Register();
		        regForm.setVisible(true);
		        Login.this.dispose();
		        regForm.setLocationRelativeTo(null);
		        regForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		linkRegister.setHorizontalAlignment(SwingConstants.CENTER);
		linkRegister.setFont(new Font("ELEGANT TYPEWRITER", Font.BOLD, 15));
		linkRegister.setBounds(36, 174, 372, 25);
		panel_1.add(linkRegister);
	}
	
	public void validarAcceso() {
		int res = 0;
			
		
		if(txtUsuario.getText().equals("") || txtPassword.equals("")) {
			JOptionPane.showMessageDialog(null, "¡FAVOR DE COMPLETAR TODOS LOS CAMPOS!", "INFO",
					JOptionPane.INFORMATION_MESSAGE);
		
		}else {
			
			try {
				String usuario = txtUsuario.getText();
				String contra = String.valueOf(txtPassword.getPassword());
				
				String sql = "SELECT * FROM USUARIOS WHERE usuario = '" +usuario+ "' and contraseña = '"+contra+"'";
				Statement st = (Statement) con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				
				
				if(rs.next()) {
					res = 1;
					
					if(res == 1) {
						MainChoice mc = new MainChoice();
						mc.setVisible(true);
						Login.this.dispose();
						
					}else {
						JOptionPane.showMessageDialog(null, "Error en el acceso");
					}
				}
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
			}
			
		}
	}
	
}
