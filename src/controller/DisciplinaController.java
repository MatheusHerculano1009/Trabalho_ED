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

import br.edu.fateczl.Lista;
import br.edu.fateczl.fila.Fila;
import model.Disciplina;

public class DisciplinaController implements ActionListener{
	
	private JTextField tfDisciplinaCod;
	private JTextField tfDisciplinaNome;
	private JTextField tfDisciplinaDia;
	private JTextField tfDisciplinaHorario;
	private JTextField tfDisciplinaQteHoras;
	private JTextField tfDisciplinaCodCurso;
	private JTextField tfDisciplinaBuscar;
	private JTextArea taDisciplina;
	private Fila<Disciplina> filaDisciplinas = new Fila<>();
	private Lista<Disciplina> listaDisciplinas = new Lista<>();
	String path = System.getProperty("user.home") + File.separator + "ContratacaoDocentes";
	File dir = new File(path);
	File arq = new File(path, "disciplinas.csv");
	FileInputStream fis = new FileInputStream(arq);
	InputStreamReader isr = new InputStreamReader(fis);
	BufferedReader buffer = new BufferedReader(isr);


	public DisciplinaController(JTextField tfDisciplinaCod, JTextField tfDisciplinaNome, JTextField tfDisciplinaDia,
								JTextField tfDisciplinaHorario, JTextField tfDisciplinaQteHoras, JTextField tfDisciplinaCodCurso, 
								JTextField tfDisciplinaBuscar, JTextArea taDisciplina) {
		this.tfDisciplinaCod = tfDisciplinaCod;
		this.tfDisciplinaNome = tfDisciplinaNome;
		this.tfDisciplinaDia = tfDisciplinaDia;
		this.tfDisciplinaHorario = tfDisciplinaHorario;
		this.tfDisciplinaQteHoras = tfDisciplinaQteHoras;
		this.tfDisciplinaCodCurso = tfDisciplinaCodCurso;
		this.tfDisciplinaBuscar = tfDisciplinaBuscar;
		this.taDisciplina = taDisciplina;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("SALVAR")) {
			try {
				cadastrarDisciplina();
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
	}

	private void pesquisarDisciplina() throws IOException {
		
		Lista disciplinas = new Lista();
		
		boolean existe = false;
		String busca = tfDisciplinaBuscar.getText();
		Disciplina d = new Disciplina();
		String path = System.getProperty("user.home") + File.separator + "ContratacaoDocentes";
		File arq = new File(path, "disciplinas.csv");
		if (arq.exists() && arq.isFile()) {
			String linha = buffer.readLine();
			while (linha != null) {
				String[] vetLinha = linha.split(";");
				if (vetLinha[0].equals(busca)) {
					d.setCod(vetLinha[0]);
					d.setNome(vetLinha[1]);
					d.setDia(vetLinha[2]);
					d.setHorario(vetLinha[3]);
					d.setQteHoras(Integer.parseInt(vetLinha[4]));
					d.setCodCurso(vetLinha[5]);
					taDisciplina.setText("Cód.: " +d.getCod()+ "\nNome: " +d.getNome()+ "\nDia: " +d.getDia()+ "\nHorário: " +d.getHorario()+
										  "\nCarga Horária: " +d.getQteHoras()+ "\nCód.Curso: " +d.getCodCurso());
					existe = true;
					break;
				}
				linha = buffer.readLine();
			}
			if (!existe) {
				taDisciplina.setText("Essa disciplina não existe!");
			}
			buffer.close();
			isr.close();
			fis.close();
			
		}
		
		
	}

	private void cadastrarDisciplina() throws IOException {
		Disciplina d = new Disciplina();
	    d.setCod(tfDisciplinaCod.getText());
	    d.setNome(tfDisciplinaNome.getText());	
	    d.setDia(tfDisciplinaDia.getText());
	    d.setHorario(tfDisciplinaHorario.getText());
	    d.setQteHoras(Integer.parseInt(tfDisciplinaQteHoras.getText()));
	    d.setCodCurso(tfDisciplinaCodCurso.getText());
	    
	    filaDisciplinas.insert(d);
	    if (listaDisciplinas.isEmpty()) {
	    	listaDisciplinas.addFirst(d);
	    } else {
	    	try {
				listaDisciplinas.addLast(d);
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
	    registrarDisciplina(d.toString());
	    
	    tfDisciplinaCod.setText("");
	    tfDisciplinaNome.setText("");
	    tfDisciplinaDia.setText("");
	    tfDisciplinaHorario.setText("");
	    tfDisciplinaQteHoras.setText("");
	    tfDisciplinaCodCurso.setText("");
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
		pw.write(csvDisciplina+"\r\n");
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
			int tamanho = listaDisciplinas.size();
			for (int i = 0; i < tamanho; i++) {
				d = listaDisciplinas.get(i);
				if (d.getCod().equals(cod)) {
					listaDisciplinas.remove(i);
					existe = true;
					break;
			} 
			if (!existe) {
				taDisciplina.setText("Não há registro dessa disciplina!");
			}
			regravarArquivos();
			}
		}
	}
	
	public void regravarArquivos() {
		
		
		
	}
	

}
