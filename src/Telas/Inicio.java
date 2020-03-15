package Telas;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.text.ParseException;
import javax.swing.JFrame;
import Telas.Inicio;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Inicio extends JFrame {

	//Criado por https://github.com/VinyciusC
	
	private static final long serialVersionUID = 1L;
    private JTextField Nome;
    private JTextField Dependentes;
    private JTextField Renda;
    private JTextField Idade;
    private JComboBox<?> EstadoCivil;
    private JComboBox<?> Estado;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Inicio() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Inicio.class.getResource("/imagens/Logo - Calcardev.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Calcardev");
		setBounds(290, 60, 800, 600);
		getContentPane().setLayout(null);
		

		
		Nome = new JTextField();
		Nome.setBounds(143, 211, 308, 20);
		getContentPane().add(Nome);
		Nome.setColumns(10);
		
		JFormattedTextField CPF = new JFormattedTextField();
		CPF.setBounds(143, 240, 308, 20);
		getContentPane().add(CPF);
		try {
			CPF.setFormatterFactory(new DefaultFormatterFactory(
				new MaskFormatter("###.###.###-##")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Idade = new JTextField();
		Idade.setColumns(10);
		Idade.setBounds(143, 267, 308, 20);
		getContentPane().add(Idade);
		
		JComboBox Sexo = new JComboBox();
		Sexo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Sexo.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Feminino"}));
		Sexo.setFont(new Font("Arial", Font.PLAIN, 12));
		Sexo.setBounds(143, 296, 308, 20);
		getContentPane().add(Sexo);
		
		EstadoCivil = new JComboBox();
		EstadoCivil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		EstadoCivil.setModel(new DefaultComboBoxModel(new String[] {"Solteiro", "Casado"}));
		EstadoCivil.setFont(new Font("Arial", Font.PLAIN, 12));
		EstadoCivil.setBounds(143, 324, 308, 20);
		getContentPane().add(EstadoCivil);
		
		Estado = new JComboBox();
		Estado.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Estado.setModel(new DefaultComboBoxModel(new String[] {"Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins"}));
		Estado.setFont(new Font("Arial", Font.PLAIN, 12));
		Estado.setBounds(143, 353, 308, 20);
		getContentPane().add(Estado);
		
		Dependentes = new JTextField();
		Dependentes.setColumns(10);
		Dependentes.setBounds(143, 383, 308, 20);
		getContentPane().add(Dependentes);
		
		Renda = new JTextField();
		Renda.setColumns(10);
		Renda.setBounds(143, 410, 308, 20);
		getContentPane().add(Renda);
		
		JButton btnAnalisar = new JButton("");
		btnAnalisar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAnalisar.setIcon(new ImageIcon(Inicio.class.getResource("/imagens/Bot\u00E3o - Calcardev.png")));
		btnAnalisar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				String nome = Nome.getText();
				int renda = Integer.parseInt(Renda.getText());
				int dependentes = Integer.parseInt(Dependentes.getText());
				
				if(renda < 1000) {
					JOptionPane.showMessageDialog(null, nome + ", você foi reprovado pois sua renda é baixa!", "NEGADO", JOptionPane.PLAIN_MESSAGE);
				}else {
					if(renda >= 1000) {
						if(renda < 2500){
							if(dependentes == 0) {
								JOptionPane.showMessageDialog(null, nome + ", você foi aprovado com um crédito de R$100 à R$500!", "APROVADO", JOptionPane.PLAIN_MESSAGE);
							}else {
								JOptionPane.showMessageDialog(null, nome + ", você foi reprovado pela política de crédito!", "NEGADO", JOptionPane.PLAIN_MESSAGE);
							}
						}
					}
				}
				
				if(renda >= 2500) {
					if(renda < 4550) {
						if(dependentes >= 0) {
							if(dependentes <= 3) {
								JOptionPane.showMessageDialog(null, nome + ", você foi aprovado com um crédito de R$100 à R$500!", "APROVADO", JOptionPane.PLAIN_MESSAGE);
							}else {
								JOptionPane.showMessageDialog(null, nome + ", você foi reprovado pela política de crédito!", "NEGADO", JOptionPane.PLAIN_MESSAGE);
								}
							}
						}
					}
				
				if(renda >= 4550) {
					if(renda < 8000) {
						if(dependentes <= 3) {
							JOptionPane.showMessageDialog(null, nome + ", você foi aprovado com um crédito de R$1000 à R$1500!", "APROVADO", JOptionPane.PLAIN_MESSAGE);
						}else {
							if(dependentes > 3) {
								JOptionPane.showMessageDialog(null, nome + ", você foi reprovado pela política de crédito!", "NEGADO", JOptionPane.PLAIN_MESSAGE);
							}
						}
					}
				}
				
				if(renda >= 8000) {
					if(renda < 10000) {
						if(dependentes < 3) {
							JOptionPane.showMessageDialog(null, nome + ", você foi aprovado com um crédito superior à R$2000!", "APROVADO", JOptionPane.PLAIN_MESSAGE);
						}else {
							if(dependentes >= 3) {
								if(dependentes < 5) {
									JOptionPane.showMessageDialog(null, nome + ", você foi aprovado com um crédito de R$1500 à R$2000!", "APROVADO", JOptionPane.PLAIN_MESSAGE);
								}else {
									if(dependentes >= 5) {
										if(dependentes < 6) {
											JOptionPane.showMessageDialog(null, nome + ", você foi aprovado com um crédito de R$1000 à R$1500!", "APROVADO", JOptionPane.PLAIN_MESSAGE);
										}else {
											if(dependentes >= 6) {
												if(dependentes <= 7) {
													JOptionPane.showMessageDialog(null, nome + ", você foi aprovado com um crédito de R$500 à R$1000!", "APROVADO", JOptionPane.PLAIN_MESSAGE);
												}
											}
										}
									}
								}
							}
						}
					}
				}
				
				if(renda >= 10000) {
					if(dependentes <= 3) {
						JOptionPane.showMessageDialog(null, nome + ", você foi aprovado com um crédito superior à R$2000!", "APROVADO", JOptionPane.PLAIN_MESSAGE);
					}else {
						if(dependentes > 3) {
							if(dependentes <= 6) {
								JOptionPane.showMessageDialog(null, nome + ", você foi aprovado com um crédito de R$1500 à R$2000!", "APROVADO", JOptionPane.PLAIN_MESSAGE);
							}else {
								if(dependentes > 6) {
									if(dependentes <= 8) {
										JOptionPane.showMessageDialog(null, nome + ", você foi aprovado com um crédito de R$1000 à R$1500!", "APROVADO", JOptionPane.PLAIN_MESSAGE);
									}else {
										if(dependentes > 8 ) {
											if(dependentes <= 10) {
												JOptionPane.showMessageDialog(null, nome + ", você foi aprovado com um crédito de R$500 à R$1000!", "APROVADO", JOptionPane.PLAIN_MESSAGE);
											}else {
												JOptionPane.showMessageDialog(null, nome + ", você foi reprovado pela política de crédito!", "NEGADO", JOptionPane.PLAIN_MESSAGE);
											}
										}
									}
								}
							}
						}
					}
				}
				
			}
		});
		btnAnalisar.setBounds(362, 440, 90, 25);
		getContentPane().add(btnAnalisar);
		
		JLabel Imagem = new JLabel("");
		Imagem.setIcon(new ImageIcon(Inicio.class.getResource("/imagens/Cart\u00E3o Calcard - Calcardev.png")));
		Imagem.setBounds(490, 211, 265, 254);
		getContentPane().add(Imagem);
		
		JLabel Fundo = DefaultComponentFactory.getInstance().createLabel("");
		Fundo.setIcon(new ImageIcon(Inicio.class.getResource("/imagens/Fundo - Calcardev.png")));
		Fundo.setBounds(0, 0, 794, 600);
		getContentPane().add(Fundo);
	}
}
