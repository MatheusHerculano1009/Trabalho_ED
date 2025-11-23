package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.edu.fateczl.Lista;
import model.Disciplina;
import model.Inscricao;
import model.Professor;

public class ConsultarInscritosController implements ActionListener {

	private JTextField tfBuscar;
	private JTextField tfNomeDisciplina;
	private JTextArea taConsultarInscritos;
	String path = System.getProperty("user.home") + File.separator + "ContratacaoDocentes";
	File arq = new File(path, "inscricoes.csv");

	public ConsultarInscritosController(JTextField tfBuscar, JTextField tfNomeDisciplina, JTextArea taSaida) {
		this.tfBuscar = tfBuscar;
		this.tfNomeDisciplina = tfNomeDisciplina;
		this.taConsultarInscritos = taSaida;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			consultar();
		} catch (Exception ex) {
			taConsultarInscritos.setText("ERRO: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	private void consultar() throws Exception {
		String codDisciplina = tfBuscar.getText();
		Disciplina d = DisciplinaController.controladorPrincipal.disciplinaExiste(codDisciplina);
		if (d == null) {
			taConsultarInscritos.setText("Disciplina com código " + codDisciplina + " não encontrada.");
			tfNomeDisciplina.setText("");
			return;
		}
		tfNomeDisciplina.setText(d.getNome());
		taConsultarInscritos.setText("");
		Lista<Inscricao> inscricoes = carregarInscricoes();
		Lista<Professor> professoresInscritos = new Lista<>();
		int tamanho = inscricoes.size();
		for (int i = 0; i < tamanho; i++) {
			Inscricao insc = inscricoes.get(i);
			if (insc.getCodDisciplina().equals(codDisciplina)) {
				Professor p = ProfessorController.controladorPrincipal.professorExiste(insc.getCPF());
				if (p != null) {
					if (professoresInscritos.isEmpty()) {
						professoresInscritos.addFirst(p);
					} else {
						professoresInscritos.addLast(p);
					}
				}
			}
		}
		if (professoresInscritos.isEmpty()) {
			taConsultarInscritos.setText("Nenhum professor inscrito para esta disciplina.");
			return;
		}
		bubbleSort(professoresInscritos);
		exibirProfessores(professoresInscritos);
	}

	private Lista<Inscricao> carregarInscricoes() throws Exception {
		Lista<Inscricao> lista = new Lista<>();
		if (arq.exists() && arq.isFile()) {
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
				if (lista.isEmpty()) {
					lista.addFirst(i);
				} else {
					lista.addLast(i);
				}
				linha = buffer.readLine();
			}
			buffer.close();
			isr.close();
			fis.close();
		}
		return lista;
	}

	private void exibirProfessores(Lista<Professor> lista) throws Exception {
		String linha = "";
		int tamanho = lista.size();
		for (int i = 0; i < tamanho; i++) {
			Professor p = lista.get(i);
			linha += "Pontos: " + p.getPontos() + "\t";
			linha += " | Nome: " + p.getNome() + "\t";
			linha += " | CPF: " + p.getCpf() + "\t";
			linha += " | Área: " + p.getArea() + "\n";
		}
		taConsultarInscritos.setText(linha);
	}

	private void bubbleSort(Lista<Professor> lista) throws Exception {
		int n = lista.size();
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				Professor p1 = lista.get(j);
				Professor p2 = lista.get(j + 1);
				if (p1.getPontos() < p2.getPontos()) {
					lista.remove(j + 1);
					lista.remove(j);
					lista.add(p2, j);
					lista.add(p1, j + 1);
				}
			}
		}
	}
}