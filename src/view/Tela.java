package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import controller.CursoController;
import controller.DisciplinaController;
import controller.ProfessorController;

public class Tela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfDisciplinaCod;
	private JTextField tfDisciplinaNome;
	private JTextField tfDisciplinaDia;
	private JTextField tfDisciplinaHorario;
	private JTextField tfDisciplinaQteHoras;
	private JTextField tfDisciplinaCodCurso;
	private JTextField tfDisciplinaBuscar;
	private JTextField tfProfessorNome;
	private JTextField tfProfessorCPF;
	private JTextField tfProfessorArea;
	private JTextField tfProfessorPontos;
	private JTextField tfProfessorBuscar;
	private JTextField tfCursoNome;
	private JTextField tfCursoCod;
	private JTextField tfCursoArea;
	private JTextField tfCursoBuscar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Tela() {
		setTitle("Contratação de Docentes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(255, 255, 255));
		tabbedPane.setBounds(10, 11, 604, 419);
		contentPane.add(tabbedPane);
		
		JPanel tabDisciplina = new JPanel();
		tabDisciplina.setBackground(new Color(240, 240, 240));
		tabDisciplina.setToolTipText("Cadastro de disciplina");
		tabbedPane.addTab("Disciplina", null, tabDisciplina, "Cadastro de Disciplinas");
		tabDisciplina.setLayout(null);
		
		JLabel lblDisciplinaCod = new JLabel("Código");
		lblDisciplinaCod.setForeground(new Color(178, 0, 0));
		lblDisciplinaCod.setBounds(10, 72, 86, 38);
		lblDisciplinaCod.setFont(new Font("Century Gothic", Font.BOLD, 20));
		tabDisciplina.add(lblDisciplinaCod);
		
		JLabel lblDisciplinaNome = new JLabel("Nome");
		lblDisciplinaNome.setForeground(new Color(178, 0, 0));
		lblDisciplinaNome.setBounds(10, 122, 86, 38);
		lblDisciplinaNome.setFont(new Font("Century Gothic", Font.BOLD, 20));
		tabDisciplina.add(lblDisciplinaNome);
		
		JLabel lblDisciplinaDia = new JLabel("Dia");
		lblDisciplinaDia.setForeground(new Color(178, 0, 0));
		lblDisciplinaDia.setBounds(213, 72, 46, 38);
		lblDisciplinaDia.setFont(new Font("Century Gothic", Font.BOLD, 20));
		tabDisciplina.add(lblDisciplinaDia);
		
		JLabel lblDisciplinaHorario = new JLabel("Horário");
		lblDisciplinaHorario.setForeground(new Color(178, 0, 0));
		lblDisciplinaHorario.setBounds(413, 72, 86, 38);
		lblDisciplinaHorario.setFont(new Font("Century Gothic", Font.BOLD, 20));
		tabDisciplina.add(lblDisciplinaHorario);
		
		JLabel lblDisciplinaqteHoras = new JLabel("<html>Carga<br>Horária<html>");
		lblDisciplinaqteHoras.setForeground(new Color(178, 0, 0));
		lblDisciplinaqteHoras.setBounds(10, 171, 80, 64);
		lblDisciplinaqteHoras.setFont(new Font("Century Gothic", Font.BOLD, 20));
		tabDisciplina.add(lblDisciplinaqteHoras);
		
		JLabel lblDisciplinacodCurso = new JLabel("<html>Cód. do<br>Curso<html>");
		lblDisciplinacodCurso.setForeground(new Color(178, 0, 0));
		lblDisciplinacodCurso.setBounds(336, 171, 80, 64);
		lblDisciplinacodCurso.setFont(new Font("Century Gothic", Font.BOLD, 20));
		tabDisciplina.add(lblDisciplinacodCurso);
		
		tfDisciplinaCod = new JTextField();
		tfDisciplinaCod.setBounds(96, 75, 99, 33);
		tfDisciplinaCod.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tabDisciplina.add(tfDisciplinaCod);
		tfDisciplinaCod.setColumns(10);
		
		tfDisciplinaNome = new JTextField();
		tfDisciplinaNome.setBounds(96, 121, 493, 33);
		tfDisciplinaNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfDisciplinaNome.setColumns(10);
		tabDisciplina.add(tfDisciplinaNome);
		
		tfDisciplinaDia = new JTextField();
		tfDisciplinaDia.setBounds(263, 75, 140, 33);
		tfDisciplinaDia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfDisciplinaDia.setColumns(10);
		tabDisciplina.add(tfDisciplinaDia);
		
		tfDisciplinaHorario = new JTextField();
		tfDisciplinaHorario.setBounds(499, 75, 90, 33);
		tfDisciplinaHorario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfDisciplinaHorario.setColumns(10);
		tabDisciplina.add(tfDisciplinaHorario);
		
		tfDisciplinaQteHoras = new JTextField();
		tfDisciplinaQteHoras.setBounds(96, 187, 230, 33);
		tfDisciplinaQteHoras.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfDisciplinaQteHoras.setColumns(10);
		tabDisciplina.add(tfDisciplinaQteHoras);
		
		tfDisciplinaCodCurso = new JTextField();
		tfDisciplinaCodCurso.setBounds(426, 187, 163, 33);
		tfDisciplinaCodCurso.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfDisciplinaCodCurso.setColumns(10);
		tabDisciplina.add(tfDisciplinaCodCurso);
		
		JLabel lblDisciplina = new JLabel("DISCIPLINA");
		lblDisciplina.setForeground(new Color(178, 0, 0));
		lblDisciplina.setBounds(10, 11, 185, 50);
		lblDisciplina.setFont(new Font("Century Gothic", Font.BOLD, 30));
		tabDisciplina.add(lblDisciplina);
		
		JButton btnDisciplinaSalvar = new JButton("SALVAR");
		btnDisciplinaSalvar.setForeground(new Color(255, 255, 255));
		btnDisciplinaSalvar.setBackground(new Color(178, 0, 0));
		btnDisciplinaSalvar.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnDisciplinaSalvar.setBounds(490, 11, 99, 38);
		tabDisciplina.add(btnDisciplinaSalvar);
		
		JButton btnDisciplinaBuscar = new JButton("BUSCAR");
		btnDisciplinaBuscar.setForeground(new Color(255, 255, 255));
		btnDisciplinaBuscar.setBackground(new Color(178, 0, 0));
		btnDisciplinaBuscar.setFont(new Font("Century Gothic", Font.BOLD, 10));
		btnDisciplinaBuscar.setBounds(490, 250, 99, 35);
		tabDisciplina.add(btnDisciplinaBuscar);
				
		tfDisciplinaBuscar = new JTextField();
		tfDisciplinaBuscar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfDisciplinaBuscar.setColumns(10);
		tfDisciplinaBuscar.setBounds(246, 252, 230, 33);
		tabDisciplina.add(tfDisciplinaBuscar);
		
		DisciplinaController dC = new DisciplinaController(tfDisciplinaCod, tfDisciplinaNome, tfDisciplinaDia, tfDisciplinaHorario,
				tfDisciplinaQteHoras, tfDisciplinaCodCurso);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 296, 579, 84);
		tabDisciplina.add(scrollPane_1);
		
		JTextArea taDisciplina = new JTextArea();
		scrollPane_1.setViewportView(taDisciplina);
		
		JPanel tabProfessor = new JPanel();
		tabProfessor.setLayout(null);
		tabProfessor.setToolTipText("Cadastro de professores");
		tabProfessor.setBackground(UIManager.getColor("Button.background"));
		tabbedPane.addTab("Professor", null, tabProfessor, "Cadastro de Professores");
		
		JLabel lblProfessorNome = new JLabel("Nome");
		lblProfessorNome.setForeground(new Color(178, 0, 0));
		lblProfessorNome.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblProfessorNome.setBounds(10, 72, 86, 38);
		tabProfessor.add(lblProfessorNome);
		
		JLabel lblProfessorCPF = new JLabel("CPF");
		lblProfessorCPF.setForeground(new Color(178, 0, 0));
		lblProfessorCPF.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblProfessorCPF.setBounds(353, 72, 86, 38);
		tabProfessor.add(lblProfessorCPF);
		
		tfProfessorNome = new JTextField();
		tfProfessorNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfProfessorNome.setColumns(10);
		tfProfessorNome.setBounds(96, 75, 247, 33);
		tabProfessor.add(tfProfessorNome);
		
		tfProfessorCPF = new JTextField();
		tfProfessorCPF.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfProfessorCPF.setColumns(10);
		tfProfessorCPF.setBounds(402, 75, 187, 33);
		tabProfessor.add(tfProfessorCPF);
		
		tfProfessorArea = new JTextField();
		tfProfessorArea.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfProfessorArea.setColumns(10);
		tfProfessorArea.setBounds(96, 121, 218, 33);
		tabProfessor.add(tfProfessorArea);
		
		JLabel lblProfessor = new JLabel("PROFESSOR");
		lblProfessor.setForeground(new Color(178, 0, 0));
		lblProfessor.setFont(new Font("Century Gothic", Font.BOLD, 30));
		lblProfessor.setBounds(10, 11, 185, 50);
		tabProfessor.add(lblProfessor);
		
		JButton btnProfessorSalvar = new JButton("SALVAR");
		btnProfessorSalvar.setForeground(Color.WHITE);
		btnProfessorSalvar.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnProfessorSalvar.setBackground(new Color(178, 0, 0));
		btnProfessorSalvar.setBounds(490, 11, 99, 38);
		tabProfessor.add(btnProfessorSalvar);
		
		JButton btnProfessorBuscar = new JButton("BUSCAR");
		btnProfessorBuscar.setForeground(Color.WHITE);
		btnProfessorBuscar.setFont(new Font("Century Gothic", Font.BOLD, 10));
		btnProfessorBuscar.setBackground(new Color(178, 0, 0));
		btnProfessorBuscar.setBounds(490, 163, 99, 35);
		tabProfessor.add(btnProfessorBuscar);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(584, 296, -419, 33);
		tabProfessor.add(textArea_1);
		
		JLabel lblProfessorArea = new JLabel("Área");
		lblProfessorArea.setForeground(new Color(178, 0, 0));
		lblProfessorArea.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblProfessorArea.setBounds(10, 120, 86, 38);
		tabProfessor.add(lblProfessorArea);
		
		JLabel lblProfessorPontos = new JLabel("Pontos");
		lblProfessorPontos.setForeground(new Color(178, 0, 0));
		lblProfessorPontos.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblProfessorPontos.setBounds(324, 118, 86, 38);
		tabProfessor.add(lblProfessorPontos);
		
		tfProfessorPontos = new JTextField();
		tfProfessorPontos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfProfessorPontos.setColumns(10);
		tfProfessorPontos.setBounds(402, 119, 187, 33);
		tabProfessor.add(tfProfessorPontos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 207, 579, 173);
		tabProfessor.add(scrollPane);
		
		JTextArea taProfessor = new JTextArea();
		scrollPane.setViewportView(taProfessor);
		
		tfProfessorBuscar = new JTextField();
		tfProfessorBuscar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfProfessorBuscar.setColumns(10);
		tfProfessorBuscar.setBounds(250, 165, 230, 33);
		tabProfessor.add(tfProfessorBuscar);
		
		btnDisciplinaSalvar.addActionListener(dC);
		btnDisciplinaBuscar.addActionListener(dC);
		
		ProfessorController pC = new ProfessorController(tfProfessorNome, tfProfessorCPF, tfProfessorArea, tfProfessorPontos);
		
		JPanel tabCurso = new JPanel();
		tabCurso.setToolTipText("Cadastro de professores");
		tabCurso.setBackground(UIManager.getColor("Button.background"));
		tabbedPane.addTab("Curso", null, tabCurso, "Cadastro de Cursos");
		tabCurso.setLayout(null);
		
		JLabel lblCursoNome = new JLabel("Nome");
		lblCursoNome.setBounds(10, 72, 86, 38);
		lblCursoNome.setForeground(new Color(178, 0, 0));
		lblCursoNome.setFont(new Font("Century Gothic", Font.BOLD, 20));
		tabCurso.add(lblCursoNome);
		
		tfCursoNome = new JTextField();
		tfCursoNome.setBounds(96, 75, 493, 33);
		tfCursoNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfCursoNome.setColumns(10);
		tabCurso.add(tfCursoNome);
		
		tfCursoCod = new JTextField();
		tfCursoCod.setBounds(96, 121, 110, 33);
		tfCursoCod.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfCursoCod.setColumns(10);
		tabCurso.add(tfCursoCod);
		
		JLabel lbCurso = new JLabel("CURSO");
		lbCurso.setBounds(10, 11, 185, 50);
		lbCurso.setForeground(new Color(178, 0, 0));
		lbCurso.setFont(new Font("Century Gothic", Font.BOLD, 30));
		tabCurso.add(lbCurso);
		
		JButton btnCursoSalvar = new JButton("SALVAR");
		btnCursoSalvar.setBounds(490, 11, 99, 38);
		btnCursoSalvar.setForeground(Color.WHITE);
		btnCursoSalvar.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnCursoSalvar.setBackground(new Color(178, 0, 0));
		tabCurso.add(btnCursoSalvar);
		
		btnProfessorSalvar.addActionListener(pC);
		btnProfessorBuscar.addActionListener(pC);
		
		JButton btnCursoBuscar = new JButton("BUSCAR");
		btnCursoBuscar.setBounds(490, 163, 99, 35);
		btnCursoBuscar.setForeground(Color.WHITE);
		btnCursoBuscar.setFont(new Font("Century Gothic", Font.BOLD, 10));
		btnCursoBuscar.setBackground(new Color(178, 0, 0));
		tabCurso.add(btnCursoBuscar);
		
		JTextArea textArea_1_1 = new JTextArea();
		textArea_1_1.setBounds(584, 296, -419, 33);
		tabCurso.add(textArea_1_1);
		
		JLabel lblCursoCod = new JLabel("Código");
		lblCursoCod.setBounds(10, 120, 86, 38);
		lblCursoCod.setForeground(new Color(178, 0, 0));
		lblCursoCod.setFont(new Font("Century Gothic", Font.BOLD, 20));
		tabCurso.add(lblCursoCod);
		
		JLabel lblCursoArea = new JLabel("Área");
		lblCursoArea.setBounds(216, 118, 86, 38);
		lblCursoArea.setForeground(new Color(178, 0, 0));
		lblCursoArea.setFont(new Font("Century Gothic", Font.BOLD, 20));
		tabCurso.add(lblCursoArea);
		
		tfCursoArea = new JTextField();
		tfCursoArea.setBounds(275, 119, 314, 33);
		tfCursoArea.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfCursoArea.setColumns(10);
		tabCurso.add(tfCursoArea);
		
		tfCursoBuscar = new JTextField();
		tfCursoBuscar.setBounds(250, 165, 230, 33);
		tfCursoBuscar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfCursoBuscar.setColumns(10);
		tabCurso.add(tfCursoBuscar);
		
		CursoController cC = new CursoController(tfCursoCod, tfCursoNome, tfCursoArea);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 209, 579, 171);
		tabCurso.add(scrollPane_2);
		
		JTextArea taCurso = new JTextArea();
		scrollPane_2.setViewportView(taCurso);
		
		btnCursoSalvar.addActionListener(cC);
		btnCursoBuscar.addActionListener(cC);
		

	}
}
