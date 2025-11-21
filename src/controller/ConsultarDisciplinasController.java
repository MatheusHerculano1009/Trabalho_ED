package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.edu.fateczl.Lista;
import model.Disciplina;

public class ConsultarDisciplinasController implements ActionListener {

	private JTextField tfCursoConsultado;
	private JTextField tfConsultarCursoBuscar;
	private JTextArea taConsultarDisciplinas;
	String path = System.getProperty("user.home") + File.separator + "ContratacaoDocentes";
	File dir = new File(path);
	File arq = new File(path, "disciplinas.csv");
	Lista<Disciplina>[] vetor = new Lista[26];

	public ConsultarDisciplinasController(JTextField tfCursoConsultado, JTextField tfConsultarCursoBuscar,
			JTextArea taConsultarDisciplinas) {
		this.tfCursoConsultado = tfCursoConsultado;
		this.tfConsultarCursoBuscar = tfConsultarCursoBuscar;
		this.taConsultarDisciplinas = taConsultarDisciplinas;
		for (int i = 0; i < 26; i++) {
			vetor[i] = new Lista<Disciplina>();
		}
	}

	private void buscarDisciplinas() throws Exception {
		String busca = tfConsultarCursoBuscar.getText();
		String disciplina = "";
		boolean encontrou = false;
		int tamanho = vetor.length;
		for (int j = 0; j < tamanho; j++) {
			int tamanhoLista = vetor[j].size();
			for (int i = 0; i < tamanhoLista; i++) {
				Disciplina d = new Disciplina();
				d = vetor[j].get(i);
				if (d.getCodCurso().equals(busca) && d.getCodProcesso() > 0) {
					String linha = d.toString();
					String[] vetLinha = linha.split(";");
					disciplina += "Cód.Disciplina: " + vetLinha[0] + "\t";
					disciplina += "Nome: " + vetLinha[1] + "\t";
					disciplina += "Dia: " + vetLinha[2] + "\t";
					disciplina += "Horário: " + vetLinha[3] + "\t";
					disciplina += "Carga Horária: " + vetLinha[4] + "\t";
					disciplina += "Cód.Processo: " + vetLinha[6] + "\n";
					encontrou = true;
				}
			}
		}
		if (!encontrou) {
			taConsultarDisciplinas.setText("Nenhuma disciplina encontrada para o curso " + busca);
			tfCursoConsultado.setText("");
		} else {
			taConsultarDisciplinas.setText(disciplina);
			tfCursoConsultado.setText("Código do Curso: " + busca);
		}
	}

	private void hash() throws Exception {
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
					d.setCodProcesso(Integer.parseInt(vetLinha[6]));
					String nomeDisciplina = vetLinha[1];
					char primeiraLetra = Character.toUpperCase(nomeDisciplina.charAt(0));
					int posicao = primeiraLetra - 'A';
					if (posicao >= 0 && posicao < 26) {
						if (vetor[posicao].isEmpty()) {
							vetor[posicao].addFirst(d);
						} else {
							vetor[posicao].addLast(d);
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

	private void limparVetor() {
		for (int i = 0; i < 26; i++) {
			vetor[i] = new Lista<Disciplina>();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("BUSCAR")) {
			try {
				limparVetor();
				hash();
				buscarDisciplinas();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

}