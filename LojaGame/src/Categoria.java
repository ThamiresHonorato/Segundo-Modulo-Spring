import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entidade
@Table(name = " tb_categoria ")
public class Categoria {
	@Identidade
	@GeneratedValue(estratégia = GenerationType.IDENTITY)
	private long idCategoria;
	private @NotNull String nome;
	private String descricaoCategoria;

	@OneToMany ( mappedBy  =  " categoria " , cascade  =  CascadeType . ALL )
	@JsonIgnoreProperties ( " categoria " )
	 Lista privada<Produto>produto=
	novo  ArrayList<>();

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		isso.produto = produto;
	}

	public long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(long idCategoria) {
		isso.idCategoria = idCategoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		isso.nome = nome;
	}

	public String getDescricaoCategoria() {
		return descricaoCategoria;
	}

	public void setDescricaoCategoria(String descricaoCategoria) {
		isso.descricaoCategoria = descricaoCategoria;
	}

}
