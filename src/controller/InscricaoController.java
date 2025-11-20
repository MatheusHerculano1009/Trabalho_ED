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
import model.Inscricao;
import model.Professor;

public class InscricaoController implements ActionListener {

	private JTextField tfInscricaoCPF;
	private JTextField tfInscricaoCodProcesso;
	private JTextField tfInscricaoBuscar;
	private JTextArea taInscricao;
	private Inscricao inscricaoEmEdicao = null;
	private Lista<Inscricao> listaInscricoes = new Lista<>();
	String path = System.getProperty("user.home") + File.separator + "ContratacaoDocentes";
	File dir = new File(path);
	File arq = new File(path, "inscricoes.csv");

	public InscricaoController(JTextField CPF, JTextField codProcesso, JTextField inscricaoBuscar,
			JTextArea taInscricao) {
		tfInscricaoCPF = CPF;
		tfInscricaoCodProcesso = codProcesso;
		tfInscricaoBuscar = inscricaoBuscar;
		this.taInscricao = taInscricao;

		carregarEstruturas();
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
					Inscricao i = new Inscricao();
					i.setCPF(vetLinha[0]);
					i.setCodDisciplina(vetLinha[1]);
					i.setCodProcesso(vetLinha[2]);
					if (listaInscricoes.isEmpty()) {
						listaInscricoes.addFirst(i);
					} else {
						try {
							listaInscricoes.addLast(i);
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
	}

	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("SALVAR")) {
			try {
				salvarInscricao();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if (cmd.equals("BUSCAR")) {
			try {
				pesquisarInscricao();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if (cmd.equals("EXCLUIR")) {
			try {
				excluirInscricao();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if (cmd.equals("NOVO +")) {
			limparCampos();
		}
	}

	private void pesquisarInscricao() throws IOException {
		this.inscricaoEmEdicao = null;
		boolean existe = false;
		String busca = tfInscricaoBuscar.getText();
		Inscricao i = new Inscricao();
		try {
			int tamanho = listaInscricoes.size();
			for (int j = 0; j < tamanho; j++) {
				i = listaInscricoes.get(j);
				if (i.getCPF().equals(busca)) {
					taInscricao.setText("");
					tfInscricaoCPF.setText(i.getCPF());
					tfInscricaoCodProcesso.setText(i.getCodProcesso());
					this.inscricaoEmEdicao = i;
					existe = true;
					break;
				}
			}
			if (!existe) {
				taInscricao.setText("Essa inscrição não existe!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void salvarInscricao() throws Exception {
		if (this.inscricaoEmEdicao != null) {
			String cpfDigitado = tfInscricaoCPF.getText();
			if (!this.inscricaoEmEdicao.getCPF().equals(cpfDigitado)) {
				taInscricao.setText(
						"ERRO: O CPF da inscrição (" + this.inscricaoEmEdicao.getCPF() + ") não pode ser alterado.");
				tfInscricaoCPF.setText(this.inscricaoEmEdicao.getCPF());
				return;
			}
			inscricaoEmEdicao.setCodProcesso(tfInscricaoCodProcesso.getText());
			regravarArquivos();
			taInscricao.setText("Inscrição " + inscricaoEmEdicao.getCPF() + " atualizada com sucesso!");
			limparCampos();
			return;
		}
		String cpfDigitado = tfInscricaoCPF.getText();
		String codProcessoDigitado = tfInscricaoCodProcesso.getText();
		Professor p = ProfessorController.controladorPrincipal.professorExiste(cpfDigitado);
		if (p == null) {
			taInscricao.setText("ERRO: Professor com CPF " + cpfDigitado + " não encontrado.");
			return;
		}
		Disciplina d;
		try {
			int idProcesso = Integer.parseInt(codProcessoDigitado);
			d = DisciplinaController.controladorPrincipal.disciplinaPorProcesso(idProcesso);
			if (d == null) {
				taInscricao.setText("ERRO: Processo Seletivo N° " + codProcessoDigitado + " não encontrado.");
				return;
			}
		} catch (NumberFormatException e) {
			taInscricao.setText("ERRO: Código do Processo deve ser um número.");
			return;
		}
		int tamanho = listaInscricoes.size();
		for (int j = 0; j < tamanho; j++) {
			Inscricao insc = listaInscricoes.get(j);
			if (insc.getCPF().equals(cpfDigitado) && insc.getCodProcesso().equals(codProcessoDigitado)) {
				taInscricao.setText("ERRO: O professor " + cpfDigitado + " já está inscrito no processo "
						+ codProcessoDigitado + ".");
				return;
			}
		}
		Inscricao i = new Inscricao();
		i.setCPF(cpfDigitado);
		i.setCodProcesso(codProcessoDigitado);
		i.setCodDisciplina(d.getCod());
		if (listaInscricoes.isEmpty()) {
			listaInscricoes.addFirst(i);
		} else {
			listaInscricoes.addLast(i);
		}
		registrarInscricao(i.toString());
		taInscricao.setText(
				"Inscrição do CPF " + i.getCPF() + " no processo " + i.getCodProcesso() + " salva com sucesso!");
		limparCampos();
	}

	private void registrarInscricao(String csvInscricao) throws IOException {
		if (!dir.exists()) {
			dir.mkdir();
		}
		boolean existe = false;
		if (arq.exists()) {
			existe = true;
		}
		FileWriter fw = new FileWriter(arq, existe);
		PrintWriter pw = new PrintWriter(fw);
		pw.write(csvInscricao + "\r\n");
		pw.flush();
		pw.close();
		fw.close();
	}

	private void excluirInscricao() throws Exception {
		boolean existe = false;
		Inscricao i = new Inscricao();
		String cpf = tfInscricaoCPF.getText();
		String codProcesso = tfInscricaoCodProcesso.getText();
		if (cpf.isEmpty() || codProcesso.isEmpty()) {
			taInscricao.setText("Para excluir, preencha o CPF e o Cód. do Processo, ou busque uma inscrição.");
			return;
		}
		if (listaInscricoes.isEmpty()) {
			taInscricao.setText("Não há nenhuma inscrição registrada!");
		} else {
			if (cpf.equals("") | codProcesso.equals("")) {
				taInscricao.setText("Por favor, insira valores válidos para excluir!");
			} else {
				int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza de que deseja excluir a inscrição?",
						"Excluir Inscrição", JOptionPane.YES_NO_OPTION);
				if (resposta == JOptionPane.YES_OPTION) {
					int tamanho = listaInscricoes.size();
					for (int j = 0; j < tamanho; j++) {
						i = listaInscricoes.get(j);
						if (i.getCPF().equals(cpf) && i.getCodProcesso().equals(codProcesso)) {
							listaInscricoes.remove(j);
							existe = true;
							break;
						}
					}
					if (!existe) {
						taInscricao.setText("Não há registro dessa inscrição (CPF + Processo)!");
					} else {
						regravarArquivos();
						taInscricao.setText("Inscrição removida com sucesso");
					}
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
		Inscricao i = new Inscricao();
		int tamanho = listaInscricoes.size();
		for (int j = 0; j < tamanho; j++) {
			i = listaInscricoes.get(j);
			pw.write(i.toString() + "\r\n");
		}
		pw.flush();
		pw.close();
		fw.close();
	}

	private void limparCampos() {
		tfInscricaoCPF.setText("");
		tfInscricaoCodProcesso.setText("");
		tfInscricaoBuscar.setText("");
		this.inscricaoEmEdicao = null;
	}

}
