package model;

import javax.swing.JPanel;

import logica.GestionDeLaInformacion;
import view.VistaPrincipal;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class Compra extends JPanel {
	public Compra(VistaPrincipal ventana, GestionDeLaInformacion gestion) {
		setSize(620, 420);
		setVisible(true);
		setLayout(null);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GRACIAS POR");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Elephant", Font.BOLD, 36));
		lblNewLabel.setBounds(140, 30, 500, 200);
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				long tiempoDeActivacion = System.currentTimeMillis() + 0500;
				while (System.currentTimeMillis() < tiempoDeActivacion) {
				}
				ventana.cambiarDePanel(0);
			}
		});
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SU COMPRA!!");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Elephant", Font.BOLD, 36));
		lblNewLabel_1.setBounds(149, 90, 500, 200);
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				long tiempoDeActivacion = System.currentTimeMillis() + 0500;
				while (System.currentTimeMillis() < tiempoDeActivacion) {
				}
				ventana.cambiarDePanel(0);
			}
		});
		add(lblNewLabel_1);
			
		
		JLabel fondo = new JLabel("");
		fondo.setBounds(0, 0, 600, 420);
		fondo.setIcon(new ImageIcon("multimedia/fondodespedida (1).jpg"));
		add(fondo);
		
	
	}
		}
			
