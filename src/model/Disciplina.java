package model;

public class Disciplina {
	
	private int cod;
	private String nome;
	private String dia;
	private int horario;         //CRIAÇÃO DA CLASSE/OBJETO DISCPLINA, COM OS ATRIBUTOS, GETTERS E SETTERS
	private int qteHoras;
	private int codCurso;
	
	public Disciplina() {
		super();
	}
	
	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
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

	public int getHorario() {
		return horario;
	}

	public void setHorario(int horario) {
		this.horario = horario;
	}

	public int getQteHoras() {
		return qteHoras;
	}

	public void setQteHoras(int qteHoras) {
		this.qteHoras = qteHoras;
	}

	public int getCodCurso() {
		return codCurso;
	}
	
	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;	
	}
	
	public String toString() {
		return "Disciplina [cod=" + cod + ", nome=" + nome + ", dia=" + dia + ", horario=" + horario + ", qteHoras="
				+ qteHoras + ", codCurso=" + codCurso + ", getCod()=" + getCod() + ", getNome()=" + getNome()
				+ ", getDia()=" + getDia() + ", getHorario()=" + getHorario() + ", getQteHoras()=" + getQteHoras()
				+ ", getCodCurso()=" + getCodCurso() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}
