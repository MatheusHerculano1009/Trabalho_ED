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

import controller.ConsultarInscritosController;
import controller.CursoController;
import controller.DisciplinaController;
import controller.InscricaoController;
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
	private JTextField tfInscricaoCPF;
	private JTextField tfInscricaoCodDisciplina;
	private JTextField tfInscricaoCodProcesso;
	private JTextField tfConsultarInscritosBuscar;
	private JTextField tfDisciplinaConsultada;
	private JTextField tfInscricaoBuscar;
	private JTextField tfnumProcesso;

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
		
		JLabel lblDisciplinaCod = new JLabel("<html>Cód. da<br>Disciplina<html>");
		lblDisciplinaCod.setForeground(new Color(38, 75, 150));
		lblDisciplinaCod.setBounds(378, 53, 99, 57);
		lblDisciplinaCod.setFont(new Font("Century Gothic", Font.BOLD, 20));
		tabDisciplina.add(lblDisciplinaCod);
		
		JLabel lblDisciplinaNome = new JLabel("Nome");
		lblDisciplinaNome.setForeground(new Color(38, 75, 150));
		lblDisciplinaNome.setBounds(10, 72, 86, 38);
		lblDisciplinaNome.setFont(new Font("Century Gothic", Font.BOLD, 20));
		tabDisciplina.add(lblDisciplinaNome);
		
		JLabel lblDisciplinaDia = new JLabel("Dia");
		lblDisciplinaDia.setForeground(new Color(38, 75, 150));
		lblDisciplinaDia.setBounds(10, 124, 46, 38);
		lblDisciplinaDia.setFont(new Font("Century Gothic", Font.BOLD, 20));
		tabDisciplina.add(lblDisciplinaDia);
		
		JLabel lblDisciplinaHorario = new JLabel("Horário");
		lblDisciplinaHorario.setForeground(new Color(38, 75, 150));
		lblDisciplinaHorario.setBounds(10, 186, 86, 38);
		lblDisciplinaHorario.setFont(new Font("Century Gothic", Font.BOLD, 20));
		tabDisciplina.add(lblDisciplinaHorario);
		
		JLabel lblDisciplinaqteHoras = new JLabel("<html>Carga<br>Horária<html>");
		lblDisciplinaqteHoras.setForeground(new Color(38, 75, 150));
		lblDisciplinaqteHoras.setBounds(378, 107, 80, 64);
		lblDisciplinaqteHoras.setFont(new Font("Century Gothic", Font.BOLD, 20));
		tabDisciplina.add(lblDisciplinaqteHoras);
		
		JLabel lblDisciplinacodCurso = new JLabel("<html>Cód. do<br>Curso<html>");
		lblDisciplinacodCurso.setForeground(new Color(38, 75, 150));
		lblDisciplinacodCurso.setBounds(378, 173, 80, 64);
		lblDisciplinacodCurso.setFont(new Font("Century Gothic", Font.BOLD, 20));
		tabDisciplina.add(lblDisciplinacodCurso);
		
		tfDisciplinaCod = new JTextField();
		tfDisciplinaCod.setBounds(476, 75, 99, 33);
		tfDisciplinaCod.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tabDisciplina.add(tfDisciplinaCod);
		tfDisciplinaCod.setColumns(10);
		
		tfDisciplinaNome = new JTextField();
		tfDisciplinaNome.setBounds(94, 75, 274, 33);
		tfDisciplinaNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfDisciplinaNome.setColumns(10);
		tabDisciplina.add(tfDisciplinaNome);
		
		tfDisciplinaDia = new JTextField();
		tfDisciplinaDia.setBounds(94, 127, 274, 33);
		tfDisciplinaDia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfDisciplinaDia.setColumns(10);
		tabDisciplina.add(tfDisciplinaDia);
		
		tfDisciplinaHorario = new JTextField();
		tfDisciplinaHorario.setBounds(94, 189, 274, 33);
		tfDisciplinaHorario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfDisciplinaHorario.setColumns(10);
		tabDisciplina.add(tfDisciplinaHorario);
		
		tfDisciplinaQteHoras = new JTextField();
		tfDisciplinaQteHoras.setBounds(476, 127, 99, 33);
		tfDisciplinaQteHoras.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfDisciplinaQteHoras.setColumns(10);
		tabDisciplina.add(tfDisciplinaQteHoras);
		
		JLabel lblDisciplina = new JLabel("DISCIPLINA");
		lblDisciplina.setForeground(new Color(38, 75, 150));
		lblDisciplina.setBounds(10, 11, 173, 50);
		lblDisciplina.setFont(new Font("Century Gothic", Font.BOLD, 30));
		tabDisciplina.add(lblDisciplina);
		
		JButton btnDisciplinaBuscar = new JButton("BUSCAR");
		btnDisciplinaBuscar.setForeground(new Color(255, 255, 255));
		btnDisciplinaBuscar.setBackground(new Color(38, 75, 150));
		btnDisciplinaBuscar.setFont(new Font("Century Gothic", Font.BOLD, 10));
		btnDisciplinaBuscar.setBounds(476, 248, 99, 33);
		tabDisciplina.add(btnDisciplinaBuscar);
				
		tfDisciplinaBuscar = new JTextField();
		tfDisciplinaBuscar.setToolTipText("Digite o código do curso que deseja buscar");
		tfDisciplinaBuscar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfDisciplinaBuscar.setColumns(10);
		tfDisciplinaBuscar.setBounds(299, 248, 165, 33);
		tabDisciplina.add(tfDisciplinaBuscar);
		
		JButton btnDisciplinaExcluir = new JButton("EXCLUIR");
		btnDisciplinaExcluir.setBounds(10, 245, 99, 34);
		tabDisciplina.add(btnDisciplinaExcluir);
		btnDisciplinaExcluir.setForeground(Color.WHITE);
		btnDisciplinaExcluir.setFont(new Font("Century Gothic", Font.BOLD, 13));
		btnDisciplinaExcluir.setBackground(new Color(191, 33, 47));
		
		JButton btnDisciplinaSalvar = new JButton("SALVAR");
		btnDisciplinaSalvar.setBounds(476, 11, 99, 38);
		tabDisciplina.add(btnDisciplinaSalvar);
		btnDisciplinaSalvar.setForeground(new Color(255, 255, 255));
		btnDisciplinaSalvar.setBackground(new Color(39, 179, 118));
		btnDisciplinaSalvar.setFont(new Font("Century Gothic", Font.BOLD, 15));
		
		tfDisciplinaCodCurso = new JTextField();
		tfDisciplinaCodCurso.setBounds(476, 189, 99, 33);
		tfDisciplinaCodCurso.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfDisciplinaCodCurso.setColumns(10);
		tabDisciplina.add(tfDisciplinaCodCurso);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 290, 579, 90);
		tabDisciplina.add(scrollPane_1);
		
		JTextArea taDisciplina = new JTextArea();
		scrollPane_1.setViewportView(taDisciplina);
		
		JLabel lblcodProcesso = new JLabel("N° do Processo");
		lblcodProcesso.setForeground(new Color(38, 75, 150));
		lblcodProcesso.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblcodProcesso.setBounds(193, 0, 99, 50);
		tabDisciplina.add(lblcodProcesso);
		
		tfnumProcesso = new JTextField();
		tfnumProcesso.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfnumProcesso.setEditable(false);
		tfnumProcesso.setColumns(10);
		tfnumProcesso.setBounds(304, 11, 64, 33);
		tabDisciplina.add(tfnumProcesso);
		
		DisciplinaController dC = new DisciplinaController(tfDisciplinaCod, tfDisciplinaNome, tfDisciplinaDia,
		                                                   tfDisciplinaHorario, tfDisciplinaQteHoras, tfDisciplinaCodCurso,
		                                                   tfDisciplinaBuscar, taDisciplina, tfnumProcesso);
		
		btnDisciplinaSalvar.addActionListener(dC);
		btnDisciplinaBuscar.addActionListener(dC);
		btnDisciplinaExcluir.addActionListener(dC);
		
		JPanel tabProfessor = new JPanel();
		tabProfessor.setLayout(null);
		tabProfessor.setToolTipText("Cadastro de professores");
		tabProfessor.setBackground(UIManager.getColor("Button.background"));
		tabbedPane.addTab("Professor", null, tabProfessor, "Cadastro de Professores");
		
		JLabel lblProfessorNome = new JLabel("Nome");
		lblProfessorNome.setForeground(new Color(38, 75, 150));
		lblProfessorNome.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblProfessorNome.setBounds(10, 72, 86, 38);
		tabProfessor.add(lblProfessorNome);
		
		JLabel lblProfessorCPF = new JLabel("CPF");
		lblProfessorCPF.setForeground(new Color(38, 75, 150));
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
		lblProfessor.setForeground(new Color(38, 75, 150));
		lblProfessor.setFont(new Font("Century Gothic", Font.BOLD, 30));
		lblProfessor.setBounds(10, 11, 185, 50);
		tabProfessor.add(lblProfessor);
		
		JButton btnProfessorSalvar = new JButton("SALVAR");
		btnProfessorSalvar.setForeground(Color.WHITE);
		btnProfessorSalvar.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnProfessorSalvar.setBackground(new Color(39, 179, 118));
		btnProfessorSalvar.setBounds(490, 11, 99, 38);
		tabProfessor.add(btnProfessorSalvar);
		
		JButton btnProfessorBuscar = new JButton("BUSCAR");
		btnProfessorBuscar.setForeground(Color.WHITE);
		btnProfessorBuscar.setFont(new Font("Century Gothic", Font.BOLD, 10));
		btnProfessorBuscar.setBackground(new Color(38, 75, 150));
		btnProfessorBuscar.setBounds(490, 163, 99, 35);
		tabProfessor.add(btnProfessorBuscar);
		
		JLabel lblProfessorArea = new JLabel("Área");
		lblProfessorArea.setForeground(new Color(38, 75, 150));
		lblProfessorArea.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblProfessorArea.setBounds(10, 120, 86, 38);
		tabProfessor.add(lblProfessorArea);
		
		JLabel lblProfessorPontos = new JLabel("Pontos");
		lblProfessorPontos.setForeground(new Color(38, 75, 150));
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
		tfProfessorBuscar.setToolTipText("Insira o CPF");
		tfProfessorBuscar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfProfessorBuscar.setColumns(10);
		tfProfessorBuscar.setBounds(250, 165, 230, 33);
		tabProfessor.add(tfProfessorBuscar);
		
		ProfessorController pC = new ProfessorController(tfProfessorNome, tfProfessorCPF, tfProfessorArea, tfProfessorPontos, tfProfessorBuscar, taProfessor);
		
		JButton btnProfessorExcluir = new JButton("EXCLUIR");
		btnProfessorExcluir.setForeground(Color.WHITE);
		btnProfessorExcluir.setFont(new Font("Century Gothic", Font.BOLD, 13));
		btnProfessorExcluir.setBackground(new Color(191, 33, 47));
		btnProfessorExcluir.setBounds(10, 165, 99, 35);
		tabProfessor.add(btnProfessorExcluir);
		
		JPanel tabCurso = new JPanel();
		tabCurso.setToolTipText("Cadastro de professores");
		tabCurso.setBackground(UIManager.getColor("Button.background"));
		tabbedPane.addTab("Curso", null, tabCurso, "Cadastro de cursos");
		tabCurso.setLayout(null);
		
		JLabel lblCursoNome = new JLabel("Nome");
		lblCursoNome.setBounds(10, 72, 86, 38);
		lblCursoNome.setForeground(new Color(38, 75, 150));
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
		
		JLabel lblCurso = new JLabel("CURSO");
		lblCurso.setBounds(10, 11, 185, 50);
		lblCurso.setForeground(new Color(38, 75, 150));
		lblCurso.setFont(new Font("Century Gothic", Font.BOLD, 30));
		tabCurso.add(lblCurso);
		
		JButton btnCursoSalvar = new JButton("SALVAR");
		btnCursoSalvar.setBounds(490, 11, 99, 38);
		btnCursoSalvar.setForeground(Color.WHITE);
		btnCursoSalvar.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnCursoSalvar.setBackground(new Color(39, 179, 118));
		tabCurso.add(btnCursoSalvar);
		
		btnProfessorSalvar.addActionListener(pC);
		btnProfessorBuscar.addActionListener(pC);
		
		JButton btnCursoBuscar = new JButton("BUSCAR");
		btnCursoBuscar.setBounds(490, 163, 99, 35);
		btnCursoBuscar.setForeground(Color.WHITE);
		btnCursoBuscar.setFont(new Font("Century Gothic", Font.BOLD, 10));
		btnCursoBuscar.setBackground(new Color(38, 75, 150));
		tabCurso.add(btnCursoBuscar);
		
		JTextArea textArea_1_1 = new JTextArea();
		textArea_1_1.setBounds(584, 296, -419, 33);
		tabCurso.add(textArea_1_1);
		
		JLabel lblCursoCod = new JLabel("Código");
		lblCursoCod.setBounds(10, 120, 86, 38);
		lblCursoCod.setForeground(new Color(38, 75, 150));
		lblCursoCod.setFont(new Font("Century Gothic", Font.BOLD, 20));
		tabCurso.add(lblCursoCod);
		
		JLabel lblCursoArea = new JLabel("Área");
		lblCursoArea.setBounds(216, 118, 86, 38);
		lblCursoArea.setForeground(new Color(38, 75, 150));
		lblCursoArea.setFont(new Font("Century Gothic", Font.BOLD, 20));
		tabCurso.add(lblCursoArea);
		
		tfCursoArea = new JTextField();
		tfCursoArea.setBounds(275, 119, 314, 33);
		tfCursoArea.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfCursoArea.setColumns(10);
		tabCurso.add(tfCursoArea);
		
		tfCursoBuscar = new JTextField();
		tfCursoBuscar.setToolTipText("Insira o cód. do curso");
		tfCursoBuscar.setBounds(250, 165, 230, 33);
		tfCursoBuscar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfCursoBuscar.setColumns(10);
		tabCurso.add(tfCursoBuscar);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 209, 579, 171);
		tabCurso.add(scrollPane_2);
		
		JTextArea taCurso = new JTextArea();
		scrollPane_2.setViewportView(taCurso);
		
		CursoController cC = new CursoController(tfCursoCod, tfCursoNome, tfCursoArea, tfCursoBuscar, taCurso);
		
		JButton btnCursoExcluir = new JButton("EXCLUIR");
		btnCursoExcluir.setForeground(Color.WHITE);
		btnCursoExcluir.setFont(new Font("Century Gothic", Font.BOLD, 13));
		btnCursoExcluir.setBackground(new Color(191, 33, 47));
		btnCursoExcluir.setBounds(10, 165, 99, 34);
		tabCurso.add(btnCursoExcluir);
		
		JPanel tabInscricao = new JPanel();
		tabbedPane.addTab("Inscrição", null, tabInscricao, "Inscrição para disciplina");
		tabInscricao.setLayout(null);
		
		JLabel lblInscricao = new JLabel("INSCRIÇÃO");
		lblInscricao.setForeground(new Color(38, 75, 150));
		lblInscricao.setFont(new Font("Century Gothic", Font.BOLD, 30));
		lblInscricao.setBounds(10, 11, 185, 50);
		tabInscricao.add(lblInscricao);
		
		JLabel lblInscricaoCPF = new JLabel("CPF");
		lblInscricaoCPF.setForeground(new Color(38, 75, 150));
		lblInscricaoCPF.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblInscricaoCPF.setBounds(10, 72, 55, 38);
		tabInscricao.add(lblInscricaoCPF);
		
		JLabel lblInsricaoCodDisciplina = new JLabel("Cód. da Disciplina");
		lblInsricaoCodDisciplina.setForeground(new Color(38, 75, 150));
		lblInsricaoCodDisciplina.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblInsricaoCodDisciplina.setBounds(10, 119, 240, 38);
		tabInscricao.add(lblInsricaoCodDisciplina);
		
		JLabel lblInscricaoCodProcesso = new JLabel("Cód. do Processo");
		lblInscricaoCodProcesso.setForeground(new Color(38, 75, 150));
		lblInscricaoCodProcesso.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblInscricaoCodProcesso.setBounds(315, 119, 260, 38);
		tabInscricao.add(lblInscricaoCodProcesso);
		
		tfInscricaoCPF = new JTextField();
		tfInscricaoCPF.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfInscricaoCPF.setColumns(10);
		tfInscricaoCPF.setBounds(75, 75, 514, 33);
		tabInscricao.add(tfInscricaoCPF);
		
		tfInscricaoCodDisciplina = new JTextField();
		tfInscricaoCodDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfInscricaoCodDisciplina.setColumns(10);
		tfInscricaoCodDisciplina.setEditable(false);
		tfInscricaoCodDisciplina.setBounds(10, 168, 293, 33);
		tabInscricao.add(tfInscricaoCodDisciplina);
		
		tfInscricaoCodProcesso = new JTextField();
		tfInscricaoCodProcesso.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfInscricaoCodProcesso.setColumns(10);
		tfInscricaoCodProcesso.setBounds(315, 168, 274, 33);
		tabInscricao.add(tfInscricaoCodProcesso);
		
		JButton btnInscricaoBuscar = new JButton("BUSCAR");
		btnInscricaoBuscar.setForeground(Color.WHITE);
		btnInscricaoBuscar.setFont(new Font("Century Gothic", Font.BOLD, 10));
		btnInscricaoBuscar.setBackground(new Color(38, 75, 150));
		btnInscricaoBuscar.setBounds(490, 212, 99, 33);
		tabInscricao.add(btnInscricaoBuscar);
		
		JButton btnInscricaoExcluir = new JButton("EXCLUIR");
		btnInscricaoExcluir.setForeground(Color.WHITE);
		btnInscricaoExcluir.setFont(new Font("Century Gothic", Font.BOLD, 13));
		btnInscricaoExcluir.setBackground(new Color(191, 33, 47));
		btnInscricaoExcluir.setBounds(10, 207, 99, 38);
		tabInscricao.add(btnInscricaoExcluir);
		
		JButton btnInscricaoSalvar = new JButton("SALVAR");
		btnInscricaoSalvar.setForeground(Color.WHITE);
		btnInscricaoSalvar.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnInscricaoSalvar.setBackground(new Color(39, 179, 118));
		btnInscricaoSalvar.setBounds(490, 11, 99, 38);
		tabInscricao.add(btnInscricaoSalvar);
		
		tfInscricaoBuscar = new JTextField();
		tfInscricaoBuscar.setToolTipText("Digite o CPF do candidato que desjeja buscar");
		tfInscricaoBuscar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfInscricaoBuscar.setColumns(10);
		tfInscricaoBuscar.setBounds(315, 212, 165, 33);
		tabInscricao.add(tfInscricaoBuscar);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(10, 256, 579, 124);
		tabInscricao.add(scrollPane_5);
		
		JTextArea taInscricao = new JTextArea();
		scrollPane_5.setViewportView(taInscricao);
		
		
		JPanel tabConsultaInscritos = new JPanel();
		tabbedPane.addTab("Consultar Inscritos", null, tabConsultaInscritos, "Consulte os inscritos de uma disciplina");
		tabConsultaInscritos.setLayout(null);
		
		JLabel lblConsultarInscritos = new JLabel("CONSULTAR INSCRITOS");
		lblConsultarInscritos.setForeground(new Color(38, 75, 150));
		lblConsultarInscritos.setFont(new Font("Century Gothic", Font.BOLD, 30));
		lblConsultarInscritos.setBounds(10, 11, 400, 50);
		tabConsultaInscritos.add(lblConsultarInscritos);
		
		tfConsultarInscritosBuscar = new JTextField();
		tfConsultarInscritosBuscar.setToolTipText("Digite o código da disciplina que deseja buscar");
		tfConsultarInscritosBuscar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfConsultarInscritosBuscar.setColumns(10);
		tfConsultarInscritosBuscar.setBounds(315, 72, 165, 33);
		tabConsultaInscritos.add(tfConsultarInscritosBuscar);
		
		JButton btnConsultarInscritos = new JButton("BUSCAR");
		btnConsultarInscritos.setForeground(Color.WHITE);
		btnConsultarInscritos.setFont(new Font("Century Gothic", Font.BOLD, 10));
		btnConsultarInscritos.setBackground(new Color(38, 75, 150));
		btnConsultarInscritos.setBounds(490, 72, 99, 33);
		tabConsultaInscritos.add(btnConsultarInscritos);
		
		tfDisciplinaConsultada = new JTextField();
		tfDisciplinaConsultada.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tfDisciplinaConsultada.setColumns(10);
		tfDisciplinaConsultada.setBounds(10, 72, 295, 33);
		tfDisciplinaConsultada.setEditable(false);
		tabConsultaInscritos.add(tfDisciplinaConsultada);

		JTextArea taConsultarInscritos = new JTextArea(); 
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(10, 116, 579, 264);
		tabConsultaInscritos.add(scrollPane_4);

		scrollPane_4.setViewportView(taConsultarInscritos); 

		InscricaoController iC = new InscricaoController(tfInscricaoCPF, tfInscricaoCodDisciplina, tfInscricaoCodProcesso, tfInscricaoBuscar, taInscricao);

		ConsultarInscritosController ciC = new ConsultarInscritosController(tfConsultarInscritosBuscar, tfDisciplinaConsultada, taConsultarInscritos);

		btnInscricaoSalvar.addActionListener(iC);
		btnInscricaoBuscar.addActionListener(iC);
		btnInscricaoExcluir.addActionListener(iC);

		btnConsultarInscritos.addActionListener(ciC);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(165, 370, 274, 261);
		contentPane.add(scrollPane_3);
		btnCursoSalvar.addActionListener(cC);
		btnCursoBuscar.addActionListener(cC);
		btnCursoExcluir.addActionListener(cC);
	}
	
}
