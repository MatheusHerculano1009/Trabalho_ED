package model;

public class Disciplina {
	
	private int codProcesso;
	private String cod;
	private String nome;
	private String dia;
	private String horario;         //CRIAÇÃO DA CLASSE/OBJETO DISCPLINA, COM OS ATRIBUTOS, GETTERS E SETTERS
	private int qteHoras;
	private String codCurso;
	
	public Disciplina() {
		super();
	}
	
	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public int getQteHoras() {
		return qteHoras;
	}

	public void setQteHoras(int qteHoras) {
		this.qteHoras = qteHoras;
	}

	public String getCodCurso() {
		return codCurso;
	}
	
	public void setCodCurso(String codCurso) {
		this.codCurso = codCurso;	
	}
	
	public int getCodProcesso() {
		return codProcesso;
	}

	public void setCodProcesso(int codProcesso) {
		this.codProcesso = codProcesso;
	}
	
	public String toString() {
		return cod+";"+nome+";"+dia+";"+horario+";"+qteHoras+";"+codCurso+";"+codProcesso;
	}
	
}
