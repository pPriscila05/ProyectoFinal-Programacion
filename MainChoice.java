//PRISCILA POLANCO, 2020-10331
//USO DE PATRONES DE DISEÑO (SINGLETON)
//APLICACIONES DE LOS PILARES DE LA POO
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class MainChoice extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainChoice frame = new MainChoice();
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
	public MainChoice() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 803, 522);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(165, 223, 243));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btGestionUsuarios = new JButton("");
		btGestionUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionUsuarios gu = new GestionUsuarios();
				gu.setVisible(true);
				MainChoice.this.dispose();
				
			}
		});
		btGestionUsuarios.setBackground(new Color(216, 172, 114));
		btGestionUsuarios.setFocusable(false);
		btGestionUsuarios.setIcon(new ImageIcon("C:\\Users\\prisc\\OneDrive\\Escritorio\\JAVA\\Final\\images\\users.png"));
		btGestionUsuarios.setBounds(94, 186, 254, 192);
		contentPane.add(btGestionUsuarios);
		
		JButton btnGestionProductos = new JButton("");
		btnGestionProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionProductos gp = new GestionProductos();
				gp.setVisible(true);
				setVisible(false);
				
			}
		});
		btnGestionProductos.setIcon(new ImageIcon("C:\\Users\\prisc\\OneDrive\\Escritorio\\JAVA\\Final\\images\\products.png"));
		btnGestionProductos.setBackground(new Color(216, 172, 114));
		btnGestionProductos.setFocusable(false);
		btnGestionProductos.setBounds(441, 186, 254, 192);
		contentPane.add(btnGestionProductos);
		
		JLabel lblNewLabel = new JLabel("USUARIOS");
		lblNewLabel.setForeground(SystemColor.desktop);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Penelope Anne", Font.BOLD, 40));
		lblNewLabel.setBounds(94, 395, 254, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblProductos = new JLabel("PRODUCTOS");
		lblProductos.setForeground(SystemColor.desktop);
		lblProductos.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductos.setFont(new Font("Penelope Anne", Font.BOLD, 40));
		lblProductos.setBounds(460, 395, 232, 40);
		contentPane.add(lblProductos);
		
		JLabel lblNewLabel_1 = new JLabel("MEN\u00DA PRINCIPAL");
		lblNewLabel_1.setForeground(SystemColor.controlText);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\prisc\\OneDrive\\Escritorio\\JAVA\\Final\\images\\home (1).png"));
		lblNewLabel_1.setFont(new Font("HOLLYWOOD STARFIRE", Font.BOLD, 50));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(116, 59, 580, 116);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("CERRAR SESI\u00D3N");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(221, 62, 70));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmarSalida();
			}
		});
		btnNewButton.setFont(new Font("Pumpkin Pancakes", Font.BOLD, 22));
		btnNewButton.setFocusable(false);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\prisc\\OneDrive\\Escritorio\\JAVA\\Final\\images\\power-button (1).png"));
		btnNewButton.setBounds(563, 11, 218, 49);
		contentPane.add(btnNewButton);
		setLocationRelativeTo(null);

	}
	
	public void confirmarSalida() {
		int valor = JOptionPane.showInternalConfirmDialog(null, "¿Está seguro que desea finalizar la sesión?", "ADVERTENCIA", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
		if (valor == JOptionPane.YES_OPTION) {
			setVisible(false);
			Main1 m1 = new Main1();
			m1.setVisible(true);
		}
	}
}
