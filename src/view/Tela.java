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

import controller.ConsultarDisciplinasController;
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
	private JTextField tfInscricaoCodProcesso;
	private JTextField tfConsultarInscritosBuscar;
	private JTextField tfDisciplinaConsultada;
	private JTextField tfInscricaoBuscar;
	private JTextField tfnumProcesso;
	private JTextField tfCursoConsultado;
	private JTextField tfConsultarCursoBuscar;

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
		setBackground(new Color(255, 255, 255));
		setTitle("Contratação de Docentes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(240, 240, 240));
		tabbedPane.setBounds(10, 11, 604, 419);
		contentPane.add(tabbedPane);
		
			JPanel tabCurso = new JPanel();
			tabCurso.setToolTipText("Cadastro de cursos");
			tabCurso.setBackground(UIManager.getColor("Button.background"));
			tabbedPane.addTab("Curso", null, tabCurso, "Cadastro de cursos");
			tabCurso.setLayout(null);
			
			JLabel lblCursoNome = new JLabel("Nome:");
			lblCursoNome.setToolTipText("Digite o nome do Curso, sem acentuação.");
			lblCursoNome.setBounds(20, 115, 60, 30);
			lblCursoNome.setForeground(new Color(38, 75, 150));
			lblCursoNome.setFont(new Font("Segoe UI", Font.BOLD, 14));
			tabCurso.add(lblCursoNome);
			
			tfCursoNome = new JTextField();
			tfCursoNome.setBounds(80, 115, 510, 30);
			tfCursoNome.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			tfCursoNome.setColumns(10);
			tabCurso.add(tfCursoNome);
			
			tfCursoCod = new JTextField();
			tfCursoCod.setBounds(80, 70, 100, 30);
			tfCursoCod.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			tfCursoCod.setColumns(10);
			tabCurso.add(tfCursoCod);
			
			JLabel lblCurso = new JLabel("Gerenciar Cursos");
			lblCurso.setBounds(20, 20, 250, 30);
			lblCurso.setForeground(new Color(38, 75, 150));
			lblCurso.setFont(new Font("Segoe UI", Font.BOLD, 24));
			tabCurso.add(lblCurso);
			
			JLabel lblCod = new JLabel("Código:");
			lblCod.setToolTipText("Digite o código do Curso. Ex.(01)");
			lblCod.setBounds(20, 70, 60, 30);
			lblCod.setForeground(new Color(38, 75, 150));
			lblCod.setFont(new Font("Segoe UI", Font.BOLD, 14));
			tabCurso.add(lblCod);
			
			JButton btnCursoSalvar = new JButton("SALVAR");
			btnCursoSalvar.setBounds(480, 20, 110, 35);
			btnCursoSalvar.setForeground(Color.WHITE);
			btnCursoSalvar.setFont(new Font("Segoe UI", Font.BOLD, 12));
			btnCursoSalvar.setBackground(new Color(39, 179, 118));
			tabCurso.add(btnCursoSalvar);
			
			JButton btnCursoBuscar = new JButton("BUSCAR");
			btnCursoBuscar.setBounds(480, 160, 110, 30);
			btnCursoBuscar.setForeground(Color.WHITE);
			btnCursoBuscar.setFont(new Font("Segoe UI", Font.BOLD, 12));
			btnCursoBuscar.setBackground(new Color(38, 75, 150));
			tabCurso.add(btnCursoBuscar);
			
			JTextArea textArea_1_1 = new JTextArea();
			textArea_1_1.setBounds(584, 296, -419, 33);
			tabCurso.add(textArea_1_1);
			
			
			JLabel lblCursoArea = new JLabel("Área:");
			lblCursoArea.setToolTipText("Digite a Área de atuação do seu Curso. Ex. (Tecnologia)");
			lblCursoArea.setBounds(200, 70, 50, 30);
			lblCursoArea.setForeground(new Color(38, 75, 150));
			lblCursoArea.setFont(new Font("Segoe UI", Font.BOLD, 14));
			tabCurso.add(lblCursoArea);
			
			tfCursoArea = new JTextField();
			tfCursoArea.setBounds(250, 70, 340, 30);
			tfCursoArea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			tfCursoArea.setColumns(10);
			tabCurso.add(tfCursoArea);
			
			tfCursoBuscar = new JTextField();
			tfCursoBuscar.setToolTipText("Insira o código do curso");
			tfCursoBuscar.setBounds(140, 160, 330, 30);
			tfCursoBuscar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			tfCursoBuscar.setColumns(10);
			tabCurso.add(tfCursoBuscar);
			
			JScrollPane scrollPane_2 = new JScrollPane();
			scrollPane_2.setBounds(20, 205, 570, 180);
			tabCurso.add(scrollPane_2);
			
			JTextArea taCurso = new JTextArea();
			taCurso.setFont(new Font("Consolas", Font.PLAIN, 14));
			scrollPane_2.setViewportView(taCurso);
			
			CursoController cC = new CursoController(tfCursoCod, tfCursoNome, tfCursoArea, tfCursoBuscar, taCurso);
			
			JButton btnCursoExcluir = new JButton("EXCLUIR");
			btnCursoExcluir.setForeground(Color.WHITE);
			btnCursoExcluir.setFont(new Font("Segoe UI", Font.BOLD, 12));
			btnCursoExcluir.setBackground(new Color(191, 33, 47));
			btnCursoExcluir.setBounds(20, 160, 110, 30);
			tabCurso.add(btnCursoExcluir);
			btnCursoSalvar.addActionListener(cC);
			btnCursoBuscar.addActionListener(cC);
			btnCursoExcluir.addActionListener(cC);
		
		JPanel tabDisciplina = new JPanel();
		tabDisciplina.setBackground(new Color(240, 240, 240));
		tabDisciplina.setToolTipText("Cadastro de disciplina");
		tabbedPane.addTab("Disciplina", null, tabDisciplina, "Cadastro de Disciplinas");
		tabDisciplina.setLayout(null);
		
		JLabel lblDisciplinaCod = new JLabel("Cód.Disc:");
		lblDisciplinaCod.setToolTipText("Digite o Código da Disciplina. Ex.(01)");
		lblDisciplinaCod.setForeground(new Color(38, 75, 150));
		lblDisciplinaCod.setBounds(20, 70, 80, 30);
		lblDisciplinaCod.setFont(new Font("Segoe UI", Font.BOLD, 14));
		tabDisciplina.add(lblDisciplinaCod);
		
		JLabel lblDisciplinaNome = new JLabel("Nome:");
		lblDisciplinaNome.setToolTipText("Digite o Nome da Disciplina. Ex.(Contabilidade)");
		lblDisciplinaNome.setForeground(new Color(38, 75, 150));
		lblDisciplinaNome.setBounds(190, 70, 50, 30);
		lblDisciplinaNome.setFont(new Font("Segoe UI", Font.BOLD, 14));
		tabDisciplina.add(lblDisciplinaNome);
		
		JLabel lblDisciplinaDia = new JLabel("Dia:");
		lblDisciplinaDia.setToolTipText("Digite o Dia da Semana que será ministrada a Aula. Ex.(Segunda-Feira)");
		lblDisciplinaDia.setForeground(new Color(38, 75, 150));
		lblDisciplinaDia.setBounds(20, 115, 80, 30);
		lblDisciplinaDia.setFont(new Font("Segoe UI", Font.BOLD, 14));
		tabDisciplina.add(lblDisciplinaDia);
		
		JLabel lblDisciplinaHorario = new JLabel("Horário:");
		lblDisciplinaHorario.setForeground(new Color(38, 75, 150));
		lblDisciplinaHorario.setToolTipText("Digite o Horário Inicial da Disciplina. Ex.(19:20)");
		lblDisciplinaHorario.setBounds(300, 115, 60, 30);
		lblDisciplinaHorario.setFont(new Font("Segoe UI", Font.BOLD, 14));
		tabDisciplina.add(lblDisciplinaHorario);
		
		JLabel lblDisciplinaqteHoras = new JLabel("Carga Hr:");
		lblDisciplinaqteHoras.setToolTipText("Digite a Carga Horária Diaria da Disciplina. Ex.(4)");
		lblDisciplinaqteHoras.setForeground(new Color(38, 75, 150));
		lblDisciplinaqteHoras.setBounds(20, 160, 80, 30);
		lblDisciplinaqteHoras.setFont(new Font("Segoe UI", Font.BOLD, 14));
		tabDisciplina.add(lblDisciplinaqteHoras);
		
		JLabel lblDisciplinacodCurso = new JLabel("Cód.Curso:");
		lblDisciplinacodCurso.setToolTipText("Digite o Codigo do Curso. Ex.(01)");
		lblDisciplinacodCurso.setForeground(new Color(38, 75, 150));
		
		lblDisciplinacodCurso.setBounds(190, 160, 90, 30);
		lblDisciplinacodCurso.setFont(new Font("Segoe UI", Font.BOLD, 14));
		tabDisciplina.add(lblDisciplinacodCurso);
		
		tfDisciplinaCod = new JTextField();
		tfDisciplinaCod.setBounds(100, 70, 80, 30);
		tfDisciplinaCod.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		tabDisciplina.add(tfDisciplinaCod);
		tfDisciplinaCod.setColumns(10);
		
		tfDisciplinaNome = new JTextField();
		tfDisciplinaNome.setBounds(240, 70, 350, 30);
		tfDisciplinaNome.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		tfDisciplinaNome.setColumns(10);
		tabDisciplina.add(tfDisciplinaNome);
		
		tfDisciplinaDia = new JTextField();
		tfDisciplinaDia.setBounds(100, 115, 180, 30);
		tfDisciplinaDia.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		tfDisciplinaDia.setColumns(10);
		tabDisciplina.add(tfDisciplinaDia);
		
		tfDisciplinaHorario = new JTextField();
		tfDisciplinaHorario.setBounds(360, 115, 230, 30);
		tfDisciplinaHorario.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		tfDisciplinaHorario.setColumns(10);
		tabDisciplina.add(tfDisciplinaHorario);
		
		tfDisciplinaQteHoras = new JTextField();
		tfDisciplinaQteHoras.setBounds(100, 160, 80, 30);
		tfDisciplinaQteHoras.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		tfDisciplinaQteHoras.setColumns(10);
		tabDisciplina.add(tfDisciplinaQteHoras);
		
		JLabel lblDisciplina = new JLabel("Gerenciar Disciplina");
		lblDisciplina.setForeground(new Color(38, 75, 150));
		lblDisciplina.setBounds(20, 20, 260, 30);
		lblDisciplina.setFont(new Font("Segoe UI", Font.BOLD, 24));
		tabDisciplina.add(lblDisciplina);
		
		JButton btnDisciplinaBuscar = new JButton("BUSCAR");
		btnDisciplinaBuscar.setForeground(new Color(255, 255, 255));
		btnDisciplinaBuscar.setBackground(new Color(38, 75, 150));
		btnDisciplinaBuscar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnDisciplinaBuscar.setBounds(480, 210, 110, 30);
		tabDisciplina.add(btnDisciplinaBuscar);
				
		tfDisciplinaBuscar = new JTextField();
		tfDisciplinaBuscar.setToolTipText("Digite o código do curso que deseja buscar:");
		tfDisciplinaBuscar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		tfDisciplinaBuscar.setColumns(10);
		tfDisciplinaBuscar.setBounds(140, 210, 330, 30);
		tabDisciplina.add(tfDisciplinaBuscar);
		
		JButton btnDisciplinaExcluir = new JButton("EXCLUIR");
		btnDisciplinaExcluir.setBounds(20, 210, 110, 30);
		tabDisciplina.add(btnDisciplinaExcluir);
		btnDisciplinaExcluir.setForeground(Color.WHITE);
		btnDisciplinaExcluir.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnDisciplinaExcluir.setBackground(new Color(191, 33, 47));
		
		JButton btnDisciplinaSalvar = new JButton("SALVAR");
		btnDisciplinaSalvar.setBounds(480, 20, 110, 35);
		tabDisciplina.add(btnDisciplinaSalvar);
		btnDisciplinaSalvar.setForeground(new Color(255, 255, 255));
		btnDisciplinaSalvar.setBackground(new Color(39, 179, 118));
		btnDisciplinaSalvar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		
		tfDisciplinaCodCurso = new JTextField();
		tfDisciplinaCodCurso.setBounds(280, 160, 80, 30);
		tfDisciplinaCodCurso.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		tfDisciplinaCodCurso.setColumns(10);
		tabDisciplina.add(tfDisciplinaCodCurso);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 250, 570, 135);
		tabDisciplina.add(scrollPane_1);
		
		JTextArea taDisciplina = new JTextArea();
		taDisciplina.setFont(new Font("Consolas", Font.PLAIN, 14));
		scrollPane_1.setViewportView(taDisciplina);
		
		JLabel lblcodProcesso = new JLabel("N°do Processo:");
		lblcodProcesso.setToolTipText("Número do Processo, guarde este número");
		lblcodProcesso.setForeground(new Color(38, 75, 150));
		lblcodProcesso.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblcodProcesso.setBounds(390, 158, 120, 30);
		tabDisciplina.add(lblcodProcesso);
		
		tfnumProcesso = new JTextField();
		tfnumProcesso.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		tfnumProcesso.setEditable(false);
		tfnumProcesso.setColumns(10);
		tfnumProcesso.setBounds(500, 160, 80, 30);
		tabDisciplina.add(tfnumProcesso);
		
		DisciplinaController dC = new DisciplinaController(tfDisciplinaCod, tfDisciplinaNome, tfDisciplinaDia,
		                                                   tfDisciplinaHorario, tfDisciplinaQteHoras, tfDisciplinaCodCurso,
		                                                   tfDisciplinaBuscar, taDisciplina, tfnumProcesso);
		
		btnDisciplinaSalvar.addActionListener(dC);
		btnDisciplinaBuscar.addActionListener(dC);
		btnDisciplinaExcluir.addActionListener(dC);
		
		JPanel tabProfessor = new JPanel();
		tabProfessor.setLayout(null);
		tabProfessor.setToolTipText("Cadastro de professores:");
		tabProfessor.setBackground(UIManager.getColor("Button.background"));
		tabbedPane.addTab("Professor", null, tabProfessor, "Cadastro de Professores");
		
		JLabel lblProfessorNome = new JLabel("Nome:");
		lblProfessorNome.setToolTipText("Digite o nome do Professor, sem acentuação");
		lblProfessorNome.setForeground(new Color(38, 75, 150));
		lblProfessorNome.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblProfessorNome.setBounds(20, 70, 60, 30);
		tabProfessor.add(lblProfessorNome);
		
		JLabel lblProfessorCPF = new JLabel("CPF:");
		lblProfessorCPF.setToolTipText("Digite o CPF do Professor. Ex.(000.000.000/00)");
		lblProfessorCPF.setForeground(new Color(38, 75, 150));
		lblProfessorCPF.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblProfessorCPF.setBounds(380, 70, 40, 30);
		tabProfessor.add(lblProfessorCPF);
		
		tfProfessorNome = new JTextField();
		tfProfessorNome.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		tfProfessorNome.setColumns(10);
		tfProfessorNome.setBounds(80, 70, 280, 30);
		tabProfessor.add(tfProfessorNome);
		
		tfProfessorCPF = new JTextField();
		tfProfessorCPF.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		tfProfessorCPF.setColumns(10);
		tfProfessorCPF.setBounds(420, 70, 170, 30);
		tabProfessor.add(tfProfessorCPF);
		
		tfProfessorArea = new JTextField();
		tfProfessorArea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		tfProfessorArea.setColumns(10);
		tfProfessorArea.setBounds(80, 115, 280, 30);
		tabProfessor.add(tfProfessorArea);
		
		JLabel lblProfessor = new JLabel("Gerenciar Professores");
		lblProfessor.setForeground(new Color(38, 75, 150));
		lblProfessor.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblProfessor.setBounds(20, 20, 300, 30);
		tabProfessor.add(lblProfessor);
		
		JButton btnProfessorSalvar = new JButton("SALVAR");
		btnProfessorSalvar.setForeground(Color.WHITE);
		btnProfessorSalvar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnProfessorSalvar.setBackground(new Color(39, 179, 118));
		btnProfessorSalvar.setBounds(480, 20, 110, 35);
		tabProfessor.add(btnProfessorSalvar);
		
		JButton btnProfessorBuscar = new JButton("BUSCAR");
		btnProfessorBuscar.setForeground(Color.WHITE);
		btnProfessorBuscar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnProfessorBuscar.setBackground(new Color(38, 75, 150));
		btnProfessorBuscar.setBounds(480, 160, 110, 30);
		tabProfessor.add(btnProfessorBuscar);
		
		JLabel lblProfessorArea = new JLabel("Área:");
		lblProfessorArea.setToolTipText("Digite a Área que deseja atuar. Ex.(Tecnologia)");
		lblProfessorArea.setForeground(new Color(38, 75, 150));
		lblProfessorArea.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblProfessorArea.setBounds(20, 115, 60, 30);
		tabProfessor.add(lblProfessorArea);
		
		JLabel lblProfessorPontos = new JLabel("Pontos:");
		lblProfessorPontos.setToolTipText("Digite os Pontos do Professor");
		lblProfessorPontos.setForeground(new Color(38, 75, 150));
		lblProfessorPontos.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblProfessorPontos.setBounds(380, 115, 60, 30);
		tabProfessor.add(lblProfessorPontos);
		
		tfProfessorPontos = new JTextField();
		tfProfessorPontos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		tfProfessorPontos.setColumns(10);
		tfProfessorPontos.setBounds(440, 115, 150, 30);
		tabProfessor.add(tfProfessorPontos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 205, 570, 180);
		tabProfessor.add(scrollPane);
		
		JTextArea taProfessor = new JTextArea();
		taProfessor.setFont(new Font("Consolas", Font.PLAIN, 14));
		scrollPane.setViewportView(taProfessor);
		
		tfProfessorBuscar = new JTextField();
		tfProfessorBuscar.setToolTipText("Insira o CPF:");
		tfProfessorBuscar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		tfProfessorBuscar.setColumns(10);
		tfProfessorBuscar.setBounds(140, 160, 330, 30);
		tabProfessor.add(tfProfessorBuscar);
		
		JButton btnProfessorExcluir = new JButton("EXCLUIR");
		btnProfessorExcluir.setForeground(Color.WHITE);
		btnProfessorExcluir.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnProfessorExcluir.setBackground(new Color(191, 33, 47));
		btnProfessorExcluir.setBounds(20, 160, 110, 30);
		tabProfessor.add(btnProfessorExcluir);
		
		ProfessorController pC = new ProfessorController(tfProfessorNome, tfProfessorCPF, tfProfessorArea, tfProfessorPontos, tfProfessorBuscar, taProfessor);
		
		btnProfessorSalvar.addActionListener(pC);
		btnProfessorBuscar.addActionListener(pC);
		btnProfessorExcluir.addActionListener(pC);
		
		JPanel tabInscricao = new JPanel();
		tabbedPane.addTab("Inscrição", null, tabInscricao, "Inscrição para disciplina");
		tabInscricao.setLayout(null);
		
		JLabel lblInscricao = new JLabel("Nova Inscrição");
		lblInscricao.setForeground(new Color(38, 75, 150));
		lblInscricao.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblInscricao.setBounds(20, 20, 200, 30);
		tabInscricao.add(lblInscricao);
		
		JLabel lblInscricaoCPF = new JLabel("CPF Candidato:");
		lblInscricaoCPF.setToolTipText("Digite o CPF do Candidato. Ex.(000.000.000/00)");
		lblInscricaoCPF.setForeground(new Color(38, 75, 150));
		lblInscricaoCPF.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblInscricaoCPF.setBounds(20, 80, 120, 30);
		tabInscricao.add(lblInscricaoCPF);
		
		JLabel lblInscricaoCodProcesso = new JLabel("Cód.Processo:");
		lblInscricaoCodProcesso.setToolTipText("Digite o Código do Processo");
		lblInscricaoCodProcesso.setForeground(new Color(38, 75, 150));
		lblInscricaoCodProcesso.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblInscricaoCodProcesso.setBounds(20, 130, 120, 30);
		tabInscricao.add(lblInscricaoCodProcesso);
		
		tfInscricaoCPF = new JTextField();
		tfInscricaoCPF.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		tfInscricaoCPF.setColumns(10);
		tfInscricaoCPF.setBounds(150, 80, 440, 30);
		tabInscricao.add(tfInscricaoCPF);
		
		tfInscricaoCodProcesso = new JTextField();
		tfInscricaoCodProcesso.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		tfInscricaoCodProcesso.setColumns(10);
		tfInscricaoCodProcesso.setBounds(150, 130, 440, 30);
		tabInscricao.add(tfInscricaoCodProcesso);
		
		JButton btnInscricaoBuscar = new JButton("BUSCAR");
		btnInscricaoBuscar.setForeground(Color.WHITE);
		btnInscricaoBuscar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnInscricaoBuscar.setBackground(new Color(38, 75, 150));
		btnInscricaoBuscar.setBounds(480, 190, 110, 30);
		tabInscricao.add(btnInscricaoBuscar);
		
		JButton btnInscricaoExcluir = new JButton("EXCLUIR");
		btnInscricaoExcluir.setForeground(Color.WHITE);
		btnInscricaoExcluir.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnInscricaoExcluir.setBackground(new Color(191, 33, 47));
		btnInscricaoExcluir.setBounds(20, 190, 110, 30);
		tabInscricao.add(btnInscricaoExcluir);
		
		JButton btnInscricaoSalvar = new JButton("SALVAR");
		btnInscricaoSalvar.setForeground(Color.WHITE);
		btnInscricaoSalvar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnInscricaoSalvar.setBackground(new Color(39, 179, 118));
		btnInscricaoSalvar.setBounds(480, 20, 110, 35);
		tabInscricao.add(btnInscricaoSalvar);
		
		tfInscricaoBuscar = new JTextField();
		tfInscricaoBuscar.setToolTipText("Digite o CPF do candidato que deseja buscar:");
		tfInscricaoBuscar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		tfInscricaoBuscar.setColumns(10);
		tfInscricaoBuscar.setBounds(140, 190, 330, 30);
		tabInscricao.add(tfInscricaoBuscar);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(20, 235, 570, 150);
		tabInscricao.add(scrollPane_5);
		
		JTextArea taInscricao = new JTextArea();
		taInscricao.setFont(new Font("Consolas", Font.PLAIN, 14));
		scrollPane_5.setViewportView(taInscricao);
		
		JPanel tabConsultaInscritos = new JPanel();
		tabbedPane.addTab("Consultar Inscritos", null, tabConsultaInscritos, "Consulte os inscritos de uma disciplina");
		tabConsultaInscritos.setLayout(null);
		
		JLabel lblConsultarInscritos = new JLabel("Consultar Inscritos por Disciplina");
		lblConsultarInscritos.setForeground(new Color(38, 75, 150));
		lblConsultarInscritos.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblConsultarInscritos.setBounds(20, 20, 400, 30);
		tabConsultaInscritos.add(lblConsultarInscritos);
		
		tfConsultarInscritosBuscar = new JTextField();
		tfConsultarInscritosBuscar.setToolTipText("Digite o código da disciplina que deseja buscar. Ex. (01)");
		tfConsultarInscritosBuscar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		tfConsultarInscritosBuscar.setColumns(10);
		tfConsultarInscritosBuscar.setBounds(310, 70, 160, 30);
		tabConsultaInscritos.add(tfConsultarInscritosBuscar);
		
		JButton btnConsultarInscritos = new JButton("BUSCAR");
		btnConsultarInscritos.setForeground(Color.WHITE);
		btnConsultarInscritos.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnConsultarInscritos.setBackground(new Color(38, 75, 150));
		btnConsultarInscritos.setBounds(480, 70, 110, 30);
		tabConsultaInscritos.add(btnConsultarInscritos);
		
		tfDisciplinaConsultada = new JTextField();
		tfDisciplinaConsultada.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		tfDisciplinaConsultada.setColumns(10);
		tfDisciplinaConsultada.setBounds(20, 70, 280, 30);
		tfDisciplinaConsultada.setEditable(false);
		tabConsultaInscritos.add(tfDisciplinaConsultada);

		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(20, 115, 570, 270);
		tabConsultaInscritos.add(scrollPane_4);

		JTextArea taConsultarInscritos = new JTextArea();
		taConsultarInscritos.setFont(new Font("Consolas", Font.PLAIN, 14));
		scrollPane_4.setViewportView(taConsultarInscritos);


		scrollPane_4.setViewportView(taConsultarInscritos);

		ConsultarInscritosController ciC = new ConsultarInscritosController(tfConsultarInscritosBuscar, tfDisciplinaConsultada, taConsultarInscritos);
		
		JPanel tabConsultaDisciplinas = new JPanel();
		tabbedPane.addTab("Consultar Disciplinas", null, tabConsultaDisciplinas, "Consulte as disciplinas de um curso");
		tabConsultaDisciplinas.setLayout(null);
		
		JLabel lblConsultarDisciplinas = new JLabel("Consultar Disciplinas");
		lblConsultarDisciplinas.setForeground(new Color(38, 75, 150));
		lblConsultarDisciplinas.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblConsultarDisciplinas.setBounds(20, 20, 400, 30);
		tabConsultaDisciplinas.add(lblConsultarDisciplinas);
		
		tfCursoConsultado = new JTextField();
		tfCursoConsultado.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		tfCursoConsultado.setEditable(false);
		tfCursoConsultado.setColumns(10);
		tfCursoConsultado.setBounds(20, 70, 280, 30);
		tabConsultaDisciplinas.add(tfCursoConsultado);
		
		tfConsultarCursoBuscar = new JTextField();
		tfConsultarCursoBuscar.setToolTipText("Digite o código do Curso que deseja buscar");
		tfConsultarCursoBuscar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		tfConsultarCursoBuscar.setColumns(10);
		tfConsultarCursoBuscar.setBounds(310, 70, 160, 30);
		tabConsultaDisciplinas.add(tfConsultarCursoBuscar);
		
		JButton btnConsultarDisciplinas = new JButton("BUSCAR");
		btnConsultarDisciplinas.setForeground(Color.WHITE);
		btnConsultarDisciplinas.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnConsultarDisciplinas.setBackground(new Color(38, 75, 150));
		btnConsultarDisciplinas.setBounds(480, 70, 110, 30);
		tabConsultaDisciplinas.add(btnConsultarDisciplinas);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(20, 115, 570, 270);
		tabConsultaDisciplinas.add(scrollPane_3);
		
		JTextArea taConsultarDisciplinas = new JTextArea();
		taConsultarDisciplinas.setFont(new Font("Consolas", Font.PLAIN, 14));
		scrollPane_3.setViewportView(taConsultarDisciplinas);
		
		ConsultarDisciplinasController cdc = new ConsultarDisciplinasController(tfCursoConsultado, tfConsultarCursoBuscar, taConsultarDisciplinas);
		
		InscricaoController iC = new InscricaoController(tfInscricaoCPF, tfInscricaoCodProcesso, tfInscricaoBuscar, taInscricao);
		
		JButton btnInscricaoNovo = new JButton("NOVO +");
		btnInscricaoNovo.setForeground(Color.WHITE);
		btnInscricaoNovo.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnInscricaoNovo.setBackground(new Color(38, 75, 150));
		btnInscricaoNovo.setBounds(360, 20, 110, 35);
		tabInscricao.add(btnInscricaoNovo);

		btnInscricaoSalvar.addActionListener(iC);
		btnInscricaoBuscar.addActionListener(iC);
		btnInscricaoExcluir.addActionListener(iC);
		btnInscricaoNovo.addActionListener(iC);

		btnConsultarInscritos.addActionListener(ciC);
		
		btnConsultarDisciplinas.addActionListener(cdc);
	}
}