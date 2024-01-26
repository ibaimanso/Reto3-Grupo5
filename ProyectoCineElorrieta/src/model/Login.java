package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import view.VistaPrincipal;
import java.awt.Dimension;

public class Login extends JPanel{

	public JTextField txtfieldUsuario;
	public JTextField textFieldContraseña;

	public Login(VistaPrincipal ventana) {
		
		
		
		setSize(ventana.getSize());
		setVisible(true);
		setLayout(null);
		/**
		 * Tamaño del panel y otras funciones
		 */
		setSize(new Dimension(612, 615));
		setLayout(null);
		JPanel panelLogin = new JPanel();
		panelLogin.setBackground(new Color(202, 46, 45));
		panelLogin.setBounds(0, 0, 700, 535);

		/**
		 * Una label con el nombre "FinestCines" 
		 */
		JLabel lblFinestCines = new JLabel("Finest Cines");
		lblFinestCines.setHorizontalAlignment(SwingConstants.LEFT);
		lblFinestCines.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblFinestCines.setBounds(200, 77, 234, 72);
		panelLogin.add(lblFinestCines);
		
	

		/**
		 * Label que te indica un texto con el nombre "Usuario"
		 */
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Rockwell", Font.BOLD, 20));
		lblUsuario.setBounds(200, 160, 165, 27);
		panelLogin.add(lblUsuario);
		
		/**
		 * Textfield para que pueda escribir el usuario
		 */
		txtfieldUsuario = new JTextField();
		txtfieldUsuario.setBounds(200, 198, 175, 20);
		panelLogin.add(txtfieldUsuario);
		txtfieldUsuario.setColumns(10);
		
		/**
		 * Label que te indica un texto con el nombre "Contraseña"
		 */
		JLabel lblcontraseña = new JLabel("Contraseña:");
		lblcontraseña.setFont(new Font("Rockwell", Font.BOLD, 20));
		lblcontraseña.setBounds(200, 236, 165, 27);
		panelLogin.add(lblcontraseña);
		
		/**
		 * Textfield para que pueda escribir la contraseña
		 */
		textFieldContraseña = new JTextField();
		textFieldContraseña.setColumns(10);
		textFieldContraseña.setBounds(200, 274, 175, 20);
		panelLogin.add(textFieldContraseña);
		
		/**
		 * Boton cuya función es que pase del PanelLogin al PanelListaGeneros o al PanelAdmin, dependiendo del
		// usuario y contraseña, cuando el usuario y contraseña estén bien, si no salta un error.
		 */
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.setBackground(Color.LIGHT_GRAY);
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((txtfieldUsuario.getText().equals("elorrieta")) && (textFieldContraseña.getText().equals("elorrieta"))) {
					JOptionPane.showMessageDialog(null, "Has iniciado sesion");
					ventana.cambiarDePanel(2);
				} else if ((txtfieldUsuario.getText().equals("admin")) && (textFieldContraseña.getText().equals("admin"))) {
					JOptionPane.showMessageDialog(null, "Has iniciado sesion como ADMIN");
					ventana.cambiarDePanel(3);
				}else {
					JOptionPane.showMessageDialog(null, "USUARIO O CONTRASEÑA INCORRECTA");
				}
			}
		});
		
		/**
		 * KeyListener para el campo de contraseña 
		 */
        textFieldContraseña.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            
            /**
             * Llama al ActionListener del botón si se presiona "Enter" en el campo de contraseña
             */
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnContinuar.doClick();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
		btnContinuar.setBounds(200, 321, 175, 20);
		panelLogin.add(btnContinuar);
		
		/**
		 * Label para el fondo del panel
		 */
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setBackground(Color.LIGHT_GRAY);
		btnRegistrarse.setBounds(200, 358, 175, 20);
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "Rellene los campos con sus datos, por favor");
					ventana.cambiarDePanel(2);
			
		panelLogin.add(btnRegistrarse);
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("multimedia/FondoLogin.png"));
		lblFondo.setBounds(-14, -93, 782, 676);
		lblFondo.setFocusable(false);
		panelLogin.add(lblFondo);
		return;
			}
		});
	}
}

