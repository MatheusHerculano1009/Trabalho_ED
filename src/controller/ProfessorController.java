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

import model.Professor;

public class ProfessorController implements ActionListener{
	
	private JTextField tfProfessorCPF;
	private JTextField tfProfessorNome;
	private JTextField tfProfessorArea;
	private JTextField tfProfessorPontos;
	private JTextField tfProfessorBuscar;
	private JTextArea taProfessor;
	
	public ProfessorController(JTextField nome, JTextField cpf, JTextField area, JTextField pontos, JTextField tfProfessorBuscar, JTextArea taProfessor) {
		tfProfessorNome = nome;
		tfProfessorCPF = cpf;
		tfProfessorArea = area;
		tfProfessorPontos = pontos;
		this.tfProfessorBuscar = tfProfessorBuscar;
		this.taProfessor = taProfessor;
	}
	
	private void pesquisarProfessor() throws IOException {
		boolean existe = false;
		String busca = tfProfessorBuscar.getText();
		Professor p = new Professor();
		String path = System.getProperty("user.home") + File.separator + "ContratacaoDocentes";
		File arq = new File(path, "professor.csv");
		if (arq.exists() && arq.isFile()) {
			FileInputStream fis = new FileInputStream(arq);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader buffer = new BufferedReader(isr);
			String linha = buffer.readLine();
			while (linha != null) {
				String[] vetLinha = linha.split(";");
				if (vetLinha[1].equals(busca)) {
					p.setNome(vetLinha[0]);
					p.setCpf(vetLinha[1]);
					p.setArea(vetLinha[2]);
					p.setPontos(Integer.parseInt(vetLinha[3]));
					taProfessor.setText("Nome: " +p.getNome()+ "\nCPF: " +p.getCpf()+ "\nÁrea: " +p.getArea()+"\nPontuação: " +p.getPontos()+ "pts");
					existe = true;
					break;
				}
				linha = buffer.readLine();
			}
			if (!existe) {
				taProfessor.setText("Essa disciplina não existe!");
			}
			buffer.close();
			isr.close();
			fis.close();
		}
	}
	
	private void cadastrarProfessor() throws IOException {
		Professor p = new Professor();
		p.setNome(tfProfessorNome.getText());
		p.setArea(tfProfessorArea.getText());
		p.setCpf(tfProfessorCPF.getText());
		p.setPontos(Integer.parseInt(tfProfessorPontos.getText()));
		
		System.out.print(p);
		registrarProfessor(p.toString());
		tfProfessorNome.setText("");
		tfProfessorCPF.setText("");
		tfProfessorArea.setText("");
		tfProfessorPontos.setText("");
		
	}

	private void registrarProfessor(String csvProfessor) throws IOException {
		String path = System.getProperty("user.home") + File.separator + "ContratacaoDocentes";
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdir();
		}
		File arq = new File(path, "professor.csv");
		boolean existe = false;
		if (arq.exists()) {
			existe = true;
		}
		FileWriter fw = new FileWriter(arq, existe);
		PrintWriter pw = new PrintWriter(fw);
		pw.write(csvProfessor+"\r\n");
		pw.flush();
		pw.close();
		fw.close();
		
	}

	public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if (cmd.equals("SALVAR")) {
				try {
					cadastrarProfessor();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (cmd.equals("BUSCAR")) {
				try {
					pesquisarProfessor();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
		
	}
	


