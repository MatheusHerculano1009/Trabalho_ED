package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import br.edu.fateczl.Lista;
import model.Disciplina;

public class DisciplinaController implements ActionListener {

	public static DisciplinaController controladorPrincipal;
	private static int codProcesso;
	private JTextField tfDisciplinaCod;
	private JTextField tfDisciplinaNome;
	private JTextField tfDisciplinaDia;
	private JTextField tfDisciplinaHorario;
	private JTextField tfDisciplinaQteHoras;
	private JTextField tfDisciplinaCodCurso;
	private JTextField tfDisciplinaBuscar;
	private JTextField tfnumProcesso;
	private JTextArea taDisciplina;
	private Disciplina disciplinaEmEdicao = null;
	private Lista<Disciplina> listaDisciplinas = new Lista<>();
	String path = System.getProperty("user.home") + File.separator + "ContratacaoDocentes";
	File dir = new File(path);
	File arq = new File(path, "disciplinas.csv");

	public DisciplinaController(JTextField tfDisciplinaCod, JTextField tfDisciplinaNome, JTextField tfDisciplinaDia,
			JTextField tfDisciplinaHorario, JTextField tfDisciplinaQteHoras, JTextField tfDisciplinaCodCurso,
			JTextField tfDisciplinaBuscar, JTextArea taDisciplina, JTextField tfnumProcesso) {
		this.tfDisciplinaCod = tfDisciplinaCod;
		this.tfDisciplinaNome = tfDisciplinaNome;
		this.tfDisciplinaDia = tfDisciplinaDia;
		this.tfDisciplinaHorario = tfDisciplinaHorario;
		this.tfDisciplinaQteHoras = tfDisciplinaQteHoras;
		this.tfDisciplinaCodCurso = tfDisciplinaCodCurso;
		this.tfDisciplinaBuscar = tfDisciplinaBuscar;
		this.tfnumProcesso = tfnumProcesso;
		this.taDisciplina = taDisciplina;
		carregarEstruturas();
		controladorPrincipal = this;
	}

	public Disciplina disciplinaExiste(String codDisciplina) {
		try {
			int tamanho = listaDisciplinas.size();
			for (int i = 0; i < tamanho; i++) {
				Disciplina d = listaDisciplinas.get(i);
				if (d.getCod().equals(codDisciplina)) {
					return d;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Disciplina disciplinaPorProcesso(int codProcesso) {
		try {
			int tamanho = listaDisciplinas.size();
			for (int i = 0; i < tamanho; i++) {
				Disciplina d = listaDisciplinas.get(i);
				if (d.getCodProcesso() == codProcesso) {
					return d;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void carregarEstruturas() {
		int maiorProcesso = 0;
		if (arq.exists() && arq.isFile()) {
			try {
				FileInputStream fis = new FileInputStream(arq);
				InputStreamReader isr = new InputStreamReader(fis);
				BufferedReader buffer = new BufferedReader(isr);
				String linha = buffer.readLine();
				while (linha != null) {
					String[] vetLinha = linha.split(";");
					Disciplina d = new Disciplina();
					d.setCod(vetLinha[0]);
					d.setNome(vetLinha[1]);
					d.setDia(vetLinha[2]);
					d.setHorario(vetLinha[3]);
					d.setQteHoras(Integer.parseInt(vetLinha[4]));
					d.setCodCurso(vetLinha[5]);
					if (vetLinha.length > 6) {
						int id = Integer.parseInt(vetLinha[6]);
						d.setCodProcesso(id);
						if (id > maiorProcesso) {
							maiorProcesso = id;
						}
					} else {
						d.setCodProcesso(0);
					}
					if (listaDisciplinas.isEmpty()) {
						listaDisciplinas.addFirst(d);
					} else {
						try {
							listaDisciplinas.addLast(d);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					linha = buffer.readLine();
				}
				buffer.close();
				isr.close();
				fis.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		codProcesso = maiorProcesso + 1;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("SALVAR")) {
			try {
				salvarDisciplina();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if (cmd.equals("BUSCAR")) {
			try {
				pesquisarDisciplina();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if (cmd.equals("EXCLUIR")) {
			try {
				excluirDisciplina();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	private void pesquisarDisciplina() throws IOException {
		this.disciplinaEmEdicao = null;
		boolean existe = false;
		String busca = tfDisciplinaBuscar.getText();
		Disciplina d = new Disciplina();
		try {
			int tamanho = listaDisciplinas.size();
			for (int i = 0; i < tamanho; i++) {
				d = listaDisciplinas.get(i);
				if (d.getCod().equals(busca)) {
					taDisciplina.setText("");
					tfDisciplinaCod.setText(d.getCod());
					tfDisciplinaNome.setText(d.getNome());
					tfDisciplinaDia.setText(d.getDia());
					tfDisciplinaHorario.setText(d.getHorario());
					tfDisciplinaQteHoras.setText(String.valueOf(d.getQteHoras())); // Converte int
					tfDisciplinaCodCurso.setText(d.getCodCurso());
					tfnumProcesso.setText(Integer.toString(d.getCodProcesso()));
					this.disciplinaEmEdicao = d;
					existe = true;
					break;
				}
			}
			if (!existe) {
				taDisciplina.setText("Essa Disciplina não existe!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void salvarDisciplina() throws Exception {
		String codCursoDigitado = tfDisciplinaCodCurso.getText();
		if (!CursoController.controladorPrincipal.cursoExiste(codCursoDigitado)) {
			taDisciplina
					.setText("ERRO: O curso " + codCursoDigitado + " não está cadastrado. A disciplina não foi salva.");
			return;
		}

		if (this.disciplinaEmEdicao != null) {
			String codDigitado = tfDisciplinaCod.getText();
			if (!this.disciplinaEmEdicao.getCod().equals(codDigitado)) {
				taDisciplina.setText("ERRO: O código da disciplina (" + this.disciplinaEmEdicao.getCod()
						+ ") não pode ser alterado após a busca.");
				tfDisciplinaCod.setText(this.disciplinaEmEdicao.getCod());
				return;
			}
			disciplinaEmEdicao.setNome(tfDisciplinaNome.getText());
			disciplinaEmEdicao.setDia(tfDisciplinaDia.getText());
			disciplinaEmEdicao.setHorario(tfDisciplinaHorario.getText());
			disciplinaEmEdicao.setQteHoras(Integer.parseInt(tfDisciplinaQteHoras.getText()));
			disciplinaEmEdicao.setCodCurso(codCursoDigitado);
			regravarArquivos();
			taDisciplina.setText("Disciplina " + disciplinaEmEdicao.getCod() + " atualizada com sucesso!");

		} else {
			String codDigitado = tfDisciplinaCod.getText();
			int tamanho = listaDisciplinas.size();
			for (int i = 0; i < tamanho; i++) {
				if (listaDisciplinas.get(i).getCod().equals(codDigitado)) {
					taDisciplina.setText("ERRO: O código de disciplina " + codDigitado + " já existe.");
					return;
				}
			}
			Disciplina novaDisciplina = new Disciplina();
			novaDisciplina.setCod(codDigitado);
			novaDisciplina.setNome(tfDisciplinaNome.getText());
			novaDisciplina.setDia(tfDisciplinaDia.getText());
			novaDisciplina.setHorario(tfDisciplinaHorario.getText());
			novaDisciplina.setQteHoras(Integer.parseInt(tfDisciplinaQteHoras.getText()));
			novaDisciplina.setCodCurso(codCursoDigitado);
			novaDisciplina.setCodProcesso(codProcesso);
			codProcesso++;
			if (listaDisciplinas.isEmpty()) {
				listaDisciplinas.addFirst(novaDisciplina);
			} else {
				listaDisciplinas.addLast(novaDisciplina);
			}
			registrarDisciplina(novaDisciplina.toString());
			taDisciplina.setText("Disciplina " + novaDisciplina.getCod() + " salva com sucesso!");
			limparCampos();
		}
	}

	private void registrarDisciplina(String csvDisciplina) throws IOException {
		if (!dir.exists()) {
			dir.mkdir();
		}
		boolean existe = false;
		if (arq.exists()) {
			existe = true;
		}
		FileWriter fw = new FileWriter(arq, existe);
		PrintWriter pw = new PrintWriter(fw);
		pw.write(csvDisciplina + "\r\n");
		pw.flush();
		pw.close();
		fw.close();
	}

	private void excluirDisciplina() throws Exception {
		boolean existe = false;
		Disciplina d = new Disciplina();
		String cod = tfDisciplinaBuscar.getText();
		if (listaDisciplinas.isEmpty()) {
			taDisciplina.setText("Não há registro dessa disciplina!");
		} else {
			if (cod.equals("")) {
				taDisciplina.setText("Por favor, insira um código válido para excluir!");
			} else {
				int resposta = JOptionPane.showConfirmDialog(null,
						"Tem certeza de que deseja excluir a disciplina N°: " + cod + " ?", "Excluir Disciplina",
						JOptionPane.YES_NO_OPTION);
				if (resposta == JOptionPane.YES_OPTION) {
					int tamanho = listaDisciplinas.size();
					for (int i = 0; i < tamanho; i++) {
						d = listaDisciplinas.get(i);
						if (d.getCod().equals(cod)) {
							listaDisciplinas.remove(i);
							existe = true;
							break;
						}
					}
					if (!existe) {
						taDisciplina.setText("Não há registro dessa disciplina!");
					} else {
						regravarArquivos();
						taDisciplina.setText("Disciplina removida com sucesso");
					}
					tfDisciplinaBuscar.setText("");
					limparCampos();
				}
			}
		}
	}

	private void regravarArquivos() throws Exception {
		if (!dir.exists()) {
			dir.mkdir();
		}
		FileWriter fw = new FileWriter(arq, false);
		PrintWriter pw = new PrintWriter(fw);
		Disciplina d = new Disciplina();
		int tamanho = listaDisciplinas.size();
		for (int i = 0; i < tamanho; i++) {
			d = listaDisciplinas.get(i);
			pw.write(d.toString() + "\r\n");
		}
		pw.flush();
		pw.close();
		fw.close();
	}

	private void limparCampos() {
		tfDisciplinaCod.setText("");
		tfDisciplinaNome.setText("");
		tfDisciplinaDia.setText("");
		tfDisciplinaHorario.setText("");
		tfDisciplinaQteHoras.setText("");
		tfDisciplinaCodCurso.setText("");
		this.disciplinaEmEdicao = null;
		atualizarNumProcesso();
	}

	private void atualizarNumProcesso() {
		tfnumProcesso.setText(Integer.toString(codProcesso));
	}

}
