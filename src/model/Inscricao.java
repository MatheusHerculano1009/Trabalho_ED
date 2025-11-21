package model;

public class Inscricao {

	private String CPF;
	private String codDisciplina;
	private String codProcesso;

	public Inscricao() {
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getCodDisciplina() {
		return codDisciplina;
	}

	public void setCodDisciplina(String codDisciplina) {
		this.codDisciplina = codDisciplina;
	}

	public String getCodProcesso() {
		return codProcesso;
	}

	public void setCodProcesso(String codProcesso) {
		this.codProcesso = codProcesso;
	}

	public String toString() {
		return CPF + ";" + codDisciplina + ";" + codProcesso;

	}

}