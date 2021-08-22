//PRISCILA POLANCO, 2020-10331
//USO DE PATRONES DE DISEÑO (SINGLETON)
//APLICACIONES DE LOS PILARES DE LA POO
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;

public class Main1 extends JFrame {
	
	public static Login frmLog;
	public static Register frmReg;

	private JPanel contentPane;

	public Main1() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 731, 603);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(93, 161, 163));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setFocusable(false);
		btnNewButton.setBackground(new Color(249, 231, 159));
		btnNewButton.setVerticalAlignment(SwingConstants.BOTTOM);
		btnNewButton.setBounds(168, 363, 381, 119);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        Login log = new Login();
				log.setVisible(true);
				log.setLocationRelativeTo(null);
				setVisible(false);
					
			 
			}
		});
		btnNewButton.setFont(new Font("Pumpkin Pancakes", Font.BOLD, 90));
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\prisc\\OneDrive\\Escritorio\\JAVA\\Final\\images\\this2.png"));
		lblNewLabel.setBounds(102, 48, 418, 316);
		contentPane.add(lblNewLabel);
		setLocationRelativeTo(null);

	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main1 frame = new Main1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
