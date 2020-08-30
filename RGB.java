import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RGB extends JFrame {
	
	private String autor = "Autor: Thiago de Oliveira Alves\ntowo497@gmail.com";
	private String versao = "Versão: 1.0 \n 27-08-2020\n\n";
	private String rgb = " RGB é a abreviatura de um sistema de cores aditivas em que o Vermelho (Red),"
			+ " o Verde (Green) e o Azul (Blue) são combinados de várias formas\n de modo a reproduzir um"
			+ " largo espectro cromático. O propósito principal do sistema RGB é a reprodução de cores em"
			+ " dispositivos eletrônicos\n como monitores de TV e computador, retroprojetores, scanners e"
			+ " câmeras digitais, assim como na fotografia tradicional.\r\n" + 
			"\r\n" + 
			" O modelo de cores RGB é baseado na teoria de visão colorida tricromática, de Young-Helmholtz,"
			+ " e no triângulo de cores de Maxwell. O uso do modelo\n RGB como padrão para apresentação de"
			+ " cores na Internet tem suas raízes nos padrões de cores de televisões RCA de 1953 e no uso"
			+ " do padrão RGB\n nas câmeras Land/Polaroid, pós Edwin Land.";
	JPanel pan = new JPanel();
	Component[] ent = {new JLabel("Insira valores de 0 a 255 em cada cor primária e pressione Enter: "), 
			new JLabel("Vermelho "), new JTextField(4), new JLabel(" Verde "), new JTextField(4),
			new JLabel(" Azul "), new JTextField(4)};

	public RGB() {
		setTitle("Sistema RGB");
		// barra de menu
		JMenuBar barraDeMenu = new JMenuBar();
		JMenu menuSobre = new JMenu("Informações");
		JMenuItem autoria = new JMenuItem("Autor");
		autoria.addActionListener(new AutorListener());
		JMenuItem versao = new JMenuItem("Sobre o aplicativo");
		versao.addActionListener(new VersaoListener());
		JMenuItem rgb = new JMenuItem("Sobre o RGB");
		rgb.addActionListener(new RGBListener());
		menuSobre.add(autoria);
		menuSobre.add(versao);
		menuSobre.add(rgb);
		barraDeMenu.add(menuSobre);
		setJMenuBar(barraDeMenu);
		JPanel north = new JPanel();
		getContentPane().add(BorderLayout.NORTH, north);
		
		for (Component e : ent) {
			north.add(e);
		}
		
		for (int i = 2; i < ent.length; i +=2) {
			JTextField t = (JTextField) ent[i];
			t.addActionListener(new PaintListener());
			t.setToolTipText("Pressione Enter para criar a cor");
		}
		
		Font big = new Font(getName(), Font.BOLD, 18);
		
		for (Component e : ent) {
			e.setFont(big);
		}
		
		add(pan);
		setSize(1050, 700);
		setLocation(450, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new RGB();
	}
	public class PaintListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int[] rgb = new int[3];
			
			for (int i = 2, j = 0; i < ent.length && j < rgb.length; i +=2, j++) {
				JTextField t = (JTextField) ent[i];
				String tValue = t.getText().isEmpty() ? "0" : t.getText();
				int tInt = Integer.parseInt(tValue);
				if (tInt > 255 || tInt < 0) 
					JOptionPane.showMessageDialog(getParent(), "Insira um número de 0 a 255.",
							"ERRO", JOptionPane.ERROR_MESSAGE);
				else rgb[j] = tInt;
			}
			
			Color color = new Color(rgb[0], rgb[1], rgb[2]);
			pan.setBackground(color);
		}

	}
	
	private class AutorListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {			
			JOptionPane.showMessageDialog(null, autor, "Sobre mim", JOptionPane.INFORMATION_MESSAGE);

		}

	}
	
	private class VersaoListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, versao, "Sobre este", JOptionPane.INFORMATION_MESSAGE);

		}

	}	
	
	private class RGBListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, rgb, "Sobre RGB", JOptionPane.INFORMATION_MESSAGE);

		}

	}	
}
