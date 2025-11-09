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

import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.edu.fateczl.fila.Fila;
import model.Curso;

public class CursoController implements ActionListener {
	
	private JTextField tfCursoCod;
	private JTextField tfCursoNome;
	private JTextField tfCursoArea;
	private JTextField tfCursoBuscar;
	private JTextArea taCurso;
	private Fila filaCursos = new Fila<>();
	

	public CursoController(JTextField cod, JTextField nome, JTextField area, JTextField tfCursoBuscar, JTextArea taCurso) {
		tfCursoCod = cod;
		tfCursoNome = nome;
		tfCursoArea = area;
		this.tfCursoBuscar = tfCursoBuscar;
		this.taCurso = taCurso;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("SALVAR")) {
			try {
				cadastrarCurso();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if (cmd.equals("BUSCAR")) {
			try {
				pesquisarCurso();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	private void pesquisarCurso() throws IOException {
		String busca = tfCursoBuscar.getText();
		boolean existe = false;
		Curso c = new Curso();
		String path = System.getProperty("user.home") + File.separator + "ContratacaoDocentes";
		File arq = new File(path, "cursos.csv");
		if (arq.exists() && arq.isFile()) {
			FileInputStream fis = new FileInputStream(arq);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader buffer = new BufferedReader(isr);
			String linha = buffer.readLine();
			while (linha != null) {
				String[] vetLinha = linha.split(";");
				if (vetLinha[0].equals(busca)) {
					c.setCod(vetLinha[0]);
					c.setNome(vetLinha[1]);
					c.setArea(vetLinha[2]);
					taCurso.setText("Cód.: " +c.getCod()+ "\nNome: " +c.getNome()+ "\nÁrea: " +c.getArea());
					existe = true;
					break;
				}
				linha = buffer.readLine();
			}
			if (!existe) {
				taCurso.setText("Essa disciplina não existe!");
			}
			buffer.close();
			isr.close();
			fis.close();
			
		}
	}


	private void cadastrarCurso() throws IOException {
		Curso c = new Curso();
		c.setNome(tfCursoNome.getText());
		c.setCod(tfCursoCod.getText());
		c.setArea(tfCursoArea.getText());
	
		registrarCurso(c.toString());
		filaCursos.insert(c.toString());

		tfCursoNome.setText("");
		tfCursoCod.setText("");
		tfCursoArea.setText("");
		
		
		System.out.print(c);
	}

	private void registrarCurso(String csvCurso) throws IOException {
		String path = System.getProperty("user.home") + File.separator + "ContratacaoDocentes";
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdir();
		}
		File arq = new File(path, "cursos.csv");
		boolean existe = false;
		if (arq.exists()) {
			existe = true;
		}
		FileWriter fw = new FileWriter(arq, existe);
		PrintWriter pw = new PrintWriter(fw);
		pw.write(csvCurso+"\r\n");
		pw.flush();
		pw.close();
		fw.close();
		
	}
	
}
