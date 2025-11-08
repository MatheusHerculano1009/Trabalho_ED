package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import model.Curso;

public class CursoController implements ActionListener {
	
	private JTextField tfCursoCod;
	private JTextField tfCursoNome;
	private JTextField tfCursoArea;

	public CursoController(JTextField cod, JTextField nome, JTextField area) {
		tfCursoCod = cod;
		tfCursoNome = nome;
		tfCursoArea = area;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("SALVAR")) {
			cadastrarCurso();
		}
		if (cmd.equals("BUSCAR")) {
			pesquisarCurso();
		}
	}

	private void pesquisarCurso() {
		Curso c = new Curso();
			
		System.out.print(c);		
	}

	private void cadastrarCurso() {
		Curso c = new Curso();
		c.setNome(tfCursoNome.getText());
		c.setCod(tfCursoCod.getText());
		c.setArea(tfCursoArea.getText());
		
		System.out.print(c);
	}
	
	
	
	

}
