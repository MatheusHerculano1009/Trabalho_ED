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
import model.Curso;
import model.Disciplina;

public class CursoController implements ActionListener {
	
	public static CursoController controladorPrincipal;
	private JTextField tfCursoCod;
	private JTextField tfCursoNome;
	private JTextField tfCursoArea;
	private JTextField tfCursoBuscar;
	private JTextArea taCurso;
	private Curso cursoEmEdicao = null;
	private Fila<Curso> filaCursos = new Fila<>();
	private Lista<Curso> listaCursos = new Lista<>();
	String path = System.getProperty("user.home") + File.separator + "ContratacaoDocentes";
	File dir = new File(path);
	File arq = new File(path, "cursos.csv");

	public CursoController(JTextField cod, JTextField nome, JTextField area, JTextField tfCursoBuscar, JTextArea taCurso) {
		tfCursoCod = cod;
		tfCursoNome = nome;
		tfCursoArea = area;
		this.tfCursoBuscar = tfCursoBuscar;
		this.taCurso = taCurso;
		carregarEstruturas();
		controladorPrincipal = this;
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
	                Curso c = new Curso();
	                c.setCod(vetLinha[0]);
	                c.setNome(vetLinha[1]);
	                c.setArea(vetLinha[2]);
	                filaCursos.insert(c);
	                if (listaCursos.isEmpty()) {
	                    listaCursos.addFirst(c);
	                } else {
	                    try {
	                        listaCursos.addLast(c);
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
				salvarCurso();
			} catch (Exception e1) {
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
		if (cmd.equals("EXCLUIR")) {
			try {
				excluirCurso();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	private void pesquisarCurso() throws IOException {
		this.cursoEmEdicao = null;
		boolean existe = false;
		String busca = tfCursoBuscar.getText();
		Curso c = new Curso();
		try {
			int tamanho = listaCursos.size();
			for (int i = 0; i < tamanho; i++) {
				c = listaCursos.get(i);
				if (c.getCod().equals(busca)) {
					taCurso.setText("");
					tfCursoCod.setText(c.getCod());
					tfCursoNome.setText(c.getNome());
					tfCursoArea.setText(c.getArea());
	                this.cursoEmEdicao = c;
	                existe = true;
	                break;
				}
			}
			if (!existe) {
				taCurso.setText("Esse curso não existe!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void salvarCurso() throws Exception {
	    if (this.cursoEmEdicao != null) {
	        String codDigitado = tfCursoCod.getText();
	        if (!this.cursoEmEdicao.getCod().equals(codDigitado)) {
	            taCurso.setText("ERRO: O código do curso (" + this.cursoEmEdicao.getCod() + ") não pode ser alterado após a busca.");
	            tfCursoCod.setText(this.cursoEmEdicao.getCod()); 
	            return;
	        }

	        cursoEmEdicao.setNome(tfCursoNome.getText());
	        cursoEmEdicao.setArea(tfCursoArea.getText());
	        regravarArquivos();
	        taCurso.setText("Curso " + cursoEmEdicao.getCod() + " atualizado com sucesso!");
	    } else {
	        String codDigitado = tfCursoCod.getText();
	        int tamanho = listaCursos.size();
	        for (int i = 0; i < tamanho; i++) {
	            if (listaCursos.get(i).getCod().equals(codDigitado)) {
	                taCurso.setText("ERRO: O código " + codDigitado + " já existe. Use a busca para editá-lo.");
	                return;
	            }
	        }
	        Curso novoCurso = new Curso();
	        novoCurso.setCod(codDigitado);
	        novoCurso.setNome(tfCursoNome.getText());
	        novoCurso.setArea(tfCursoArea.getText());
	        filaCursos.insert(novoCurso);
	        if (listaCursos.isEmpty()) {
	            listaCursos.addFirst(novoCurso);
	        } else {
	            listaCursos.addLast(novoCurso);
	        }
	        registrarCurso(novoCurso.toString());
	        taCurso.setText("Curso " + novoCurso.getCod() + " salvo com sucesso!");
	    }
	    limparCampos();
	}

	private void registrarCurso(String csvCurso) throws IOException {
		if (!dir.exists()) {
			dir.mkdir();
		}
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
	
	private void excluirCurso() throws Exception {
		boolean existe = false;
		Curso c = new Curso();
		String cod = tfCursoBuscar.getText();
		if (listaCursos.isEmpty()) {
			taCurso.setText("Não há registro desse curso!");
		} else {
			int tamanho = listaCursos.size();
			for (int i = 0; i < tamanho; i++) {
				c = listaCursos.get(i);
				if (c.getCod().equals(cod)) {
					listaCursos.remove(i);
					existe = true;
					break;
				} 
			}
			if (!existe) {
				taCurso.setText("Não há registro desse curso!");
			} else {
				regravarArquivos();
				taCurso.setText("Curso removido com sucesso");
			}
		}
		tfCursoBuscar.setText("");
		limparCampos();
	}
	
	public void regravarArquivos() throws Exception {
		if (!dir.exists()) {
			dir.mkdir();
		}
		FileWriter fw = new FileWriter(arq, false); 
	    PrintWriter pw = new PrintWriter(fw);
	    Curso c = new Curso();
		int tamanho = listaCursos.size();
		for (int i = 0; i < tamanho; i++) {
			c = listaCursos.get(i);
			pw.write(c.toString()+"\r\n");
		}
		pw.flush();
		pw.close();
		fw.close();
	}
	
	public boolean cursoExiste(String codCurso) {
	    try {
	        int tamanho = listaCursos.size();
	        for (int i = 0; i < tamanho; i++) {
	            if (listaCursos.get(i).getCod().equals(codCurso)) {
	                return true;
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return false;
	}
	
	public void limparCampos() {
		tfCursoCod.setText("");
	    tfCursoNome.setText("");
	    tfCursoArea.setText("");
	    this.cursoEmEdicao = null;
	}
	
}
