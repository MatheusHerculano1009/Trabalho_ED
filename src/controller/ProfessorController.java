package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import model.Professor;

public class ProfessorController implements ActionListener{
	
	private JTextField tfProfessorCPF;
	private JTextField tfProfessorNome;
	private JTextField tfProfessorArea;
	private JTextField tfProfessorPontos;
	
	public ProfessorController(JTextField cpf, JTextField nome, JTextField area, JTextField pontos) {
		tfProfessorCPF = cpf;
		tfProfessorNome = nome;
		tfProfessorArea = area;
		tfProfessorPontos = pontos;
	}
	
	private void pesquisarProfessor() {
		Professor p = new Professor();
		
		System.out.print(p);
	}
	
	private void cadastrarProfessor() {
		Professor p = new Professor();
		p.setNome(tfProfessorNome.getText());
		p.setArea(tfProfessorArea.getText());
		p.setCpf(tfProfessorCPF.getText());
		p.setPontos(Integer.parseInt(tfProfessorPontos.getText()));
		
		System.out.print(p);
	}

	public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if (cmd.equals("SALVAR")) {
				cadastrarProfessor();
			}
			if (cmd.equals("BUSCAR")) {
				pesquisarProfessor();
			}
		}
		
	}
	


