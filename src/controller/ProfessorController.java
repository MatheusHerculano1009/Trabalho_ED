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
import model.Professor;

public class ProfessorController implements ActionListener {

	public static ProfessorController controladorPrincipal;
	private JTextField tfProfessorCPF;
	private JTextField tfProfessorNome;
	private JTextField tfProfessorArea;
	private JTextField tfProfessorPontos;
	private JTextField tfProfessorBuscar;
	private JTextArea taProfessor;
	private Professor professorEmEdicao = null;
	private Lista<Professor> listaProfessores = new Lista<>();
	String path = System.getProperty("user.home") + File.separator + "ContratacaoDocentes";
	File dir = new File(path);
	File arq = new File(path, "professor.csv");

	public ProfessorController(JTextField nome, JTextField cpf, JTextField area, JTextField pontos,
			JTextField tfProfessorBuscar, JTextArea taProfessor) {
		tfProfessorNome = nome;
		tfProfessorCPF = cpf;
		tfProfessorArea = area;
		tfProfessorPontos = pontos;
		this.tfProfessorBuscar = tfProfessorBuscar;
		this.taProfessor = taProfessor;
		carregarEstruturas();
		controladorPrincipal = this;
	}

	public Professor professorExiste(String cpf) {
		try {
			int tamanho = listaProfessores.size();
			for (int i = 0; i < tamanho; i++) {
				Professor p = listaProfessores.get(i);
				if (p.getCpf().equals(cpf)) {
					return p;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void carregarEstruturas() {
		if (arq.exists() && arq.isFile()) {
			try {
				FileInputStream fis = new FileInputStream(arq);
				InputStreamReader isr = new InputStreamReader(fis);
				BufferedReader buffer = new BufferedReader(isr);
				String linha = buffer.readLine();
				while (linha != null) {
					String[] vetLinha = linha.split(";");
					Professor p = new Professor();
					p.setNome(vetLinha[0]);
					p.setCpf(vetLinha[1]);
					p.setArea(vetLinha[2]);
					p.setPontos(Integer.parseInt(vetLinha[3]));
					if (listaProfessores.isEmpty()) {
						listaProfessores.addFirst(p);
					} else {
						try {
							listaProfessores.addLast(p);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					linha = buffer.readLine();
				}
				buffer.close();
				isr.close();
				fis.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("SALVAR")) {
			try {
				salvarProfessor();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if (cmd.equals("BUSCAR")) {
			try {
				pesquisarProfessor();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if (cmd.equals("EXCLUIR")) {
			try {
				excluirProfessor();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	private void pesquisarProfessor() throws IOException {
		this.professorEmEdicao = null;
		boolean existe = false;
		String busca = tfProfessorBuscar.getText();
		Professor p = new Professor();
		try {
			int tamanho = listaProfessores.size();
			for (int i = 0; i < tamanho; i++) {
				p = listaProfessores.get(i);
				if (p.getCpf().equals(busca)) {
					taProfessor.setText("");
					tfProfessorCPF.setText(p.getCpf());
					tfProfessorNome.setText(p.getNome());
					tfProfessorArea.setText(p.getArea());
					int pontos = p.getPontos();
					tfProfessorPontos.setText(Integer.toString(pontos));
					this.professorEmEdicao = p;
					existe = true;
					break;
				}
			}
			if (!existe) {
				taProfessor.setText("Essa cadastro não existe!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void salvarProfessor() throws Exception {
		String codCPF = tfProfessorCPF.getText();
		if (this.professorEmEdicao != null) {
			codCPF = tfProfessorCPF.getText();
			if (!this.professorEmEdicao.getCpf().equals(codCPF)) {
				taProfessor.setText("ERRO: O CPF da professor (" + this.professorEmEdicao.getCpf()
						+ ") não pode ser alterado após a busca.");
				tfProfessorCPF.setText(this.professorEmEdicao.getCpf());
				return;
			}
			professorEmEdicao.setNome(tfProfessorNome.getText());
			professorEmEdicao.setArea(tfProfessorArea.getText());
			professorEmEdicao.setPontos(Integer.parseInt(tfProfessorPontos.getText()));
			regravarArquivos();
			taProfessor.setText("Professor " + professorEmEdicao.getNome() + " atualizado com sucesso!");

		} else {
			codCPF = tfProfessorCPF.getText();
			int tamanho = listaProfessores.size();
			for (int i = 0; i < tamanho; i++) {
				if (listaProfessores.get(i).getCpf().equals(codCPF)) {
					taProfessor.setText("ERRO: O CPF utilizado " + codCPF + " já possui cadastro.");
					return;
				}
			}
			Professor p = new Professor();
			p.setCpf(codCPF);
			p.setNome(tfProfessorNome.getText());
			p.setArea(tfProfessorArea.getText());
			String pontos = tfProfessorPontos.getText();
			p.setPontos(Integer.parseInt(pontos));
			if (listaProfessores.isEmpty()) {
				listaProfessores.addFirst(p);
			} else {
				listaProfessores.addLast(p);
			}
			registrarProfessor(p.toString());
			taProfessor.setText("Professor " + p.getNome() + " salvo com sucesso!");
			limparCampos();
		}
	}

	private void registrarProfessor(String csvProfessor) throws IOException {
		if (!dir.exists()) {
			dir.mkdir();
		}
		boolean existe = false;
		if (arq.exists()) {
			existe = true;
		}
		FileWriter fw = new FileWriter(arq, existe);
		PrintWriter pw = new PrintWriter(fw);
		pw.write(csvProfessor + "\r\n");
		pw.flush();
		pw.close();
		fw.close();
	}

	private void excluirProfessor() throws Exception {
		boolean existe = false;
		Professor p = new Professor();
		String CPF = tfProfessorBuscar.getText();
		if (listaProfessores.isEmpty()) {
			taProfessor.setText("Não há registro desse professor!");
		} else {
			if (CPF.equals("")) {
				taProfessor.setText("Por favor, insira um CPF válido para excluir!");
			} else {
				int resposta = JOptionPane.showConfirmDialog(null,
						"Tem certeza de que deseja excluir o professor CPF: " + CPF + " ?", "Excluir Professor",
						JOptionPane.YES_NO_OPTION);
				if (resposta == JOptionPane.YES_OPTION) {
					int tamanho = listaProfessores.size();
					for (int i = 0; i < tamanho; i++) {
						p = listaProfessores.get(i);
						if (p.getCpf().equals(CPF)) {
							listaProfessores.remove(i);
							existe = true;
							break;
						}
					}
					if (!existe) {
						taProfessor.setText("Não há registro desse professor!");
					} else {
						regravarArquivos();
						taProfessor.setText("Professor removido com sucesso");
					}
					tfProfessorBuscar.setText("");
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
		Professor p = new Professor();
		int tamanho = listaProfessores.size();
		for (int i = 0; i < tamanho; i++) {
			p = listaProfessores.get(i);
			pw.write(p.toString() + "\r\n");
		}
		pw.flush();
		pw.close();
		fw.close();
	}

	private void limparCampos() {
		tfProfessorNome.setText("");
		tfProfessorCPF.setText("");
		tfProfessorArea.setText("");
		tfProfessorPontos.setText("");
		this.professorEmEdicao = null;
	}

}