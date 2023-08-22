package agenda;
import java.time.LocalDate;

public class Contato {
	
    private String nome;
    private LocalDate dataNascimento;
    private String telefone;
    private String email;
    private int codigo;
    
	public Contato(int codigo, String nome, LocalDate localDate, String telefone, String email) {
		super();
		this.nome = nome;
		this.dataNascimento = localDate;
		this.telefone = telefone;
		this.email = email;
		this.codigo = codigo;
	}

	
	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(",\n CODIGO:");
		builder.append(codigo);
		builder.append(",\n NOME:");
		builder.append(nome);
		builder.append(",\n DATA DE NASCIMENTO:");
		builder.append(dataNascimento);
		builder.append(",\n TELEFONE:");
		builder.append(telefone);
		builder.append(",\n EMAIL:");
		builder.append(	email);
		builder.append("\n");
		builder.append("-----------------");
		builder.append("\n");
		return builder.toString();
	}
    
    
}
