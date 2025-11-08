package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Disciplina;

public class DisciplinaController implements ActionListener{
	
	private JTextField tfDisciplinaCod;
	private JTextField tfDisciplinaNome;
	private JTextField tfDisciplinaDia;
	private JTextField tfDisciplinaHorario;
	private JTextField tfDisciplinaQteHoras;
	private JTextField tfDisciplinaCodCurso;
	private JTextArea taTextoDisciplina;
	
	

	public DisciplinaController(JTextField tfDisciplinaCod, JTextField tfDisciplinaNome, JTextField tfDisciplinaDia,
			JTextField tfDisciplinaHorario, JTextField tfDisciplinaQteHoras, JTextField tfDisciplinaCodCurso) {
		this.tfDisciplinaCod = tfDisciplinaCod;
		this.tfDisciplinaNome = tfDisciplinaNome;
		this.tfDisciplinaDia = tfDisciplinaDia;
		this.tfDisciplinaHorario = tfDisciplinaHorario;
		this.tfDisciplinaQteHoras = tfDisciplinaQteHoras;
		this.tfDisciplinaCodCurso = tfDisciplinaCodCurso;
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("SALVAR")) {
			cadastrarDisciplina();
		}
		if (cmd.equals("BUSCAR")) {
			pesquisarDisciplina();
		}
	}

	private void pesquisarDisciplina() {
		Disciplina d = new Disciplina();
		d.setCod(tfDisciplinaCod.getText());
		
		taTextoDisciplina.setText(d.toString());
		
	}

	private void cadastrarDisciplina() {
		Disciplina d = new Disciplina();
	    d.setCod(tfDisciplinaCod.getText());
	    d.setNome(tfDisciplinaNome.getText());	
	    d.setDia(tfDisciplinaDia.getText());
	    d.setHorario(tfDisciplinaHorario.getText());
	    d.setQteHoras(Integer.parseInt(tfDisciplinaQteHoras.getText()));
	    d.setCodCurso(tfDisciplinaCodCurso.getText());
	    
	    System.out.print(d);
	    cadastraDisciplina(d.toString());
	    
	}


	private void cadastraDisciplina(String string) {		
	}

}
