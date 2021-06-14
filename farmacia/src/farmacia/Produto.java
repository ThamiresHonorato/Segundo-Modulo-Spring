package farmacia;

import  javax.persistence.Entity ;
import  javax.persistence.FetchType ;
import  javax.persistence.GeneratedValue ;
import  javax.persistence.GenerationType ;
import  javax.persistence.Id ;
import  javax.persistence.JoinColumn ;
import  javax.persistence.ManyToOne ;
import  javax.persistence.Table ;
import  javax.validation.constraints.NotNull ;

import  com.fasterxml.jackson.annotation.JsonIgnoreProperties ;

@Entidade
@Table ( name  =  " tb_pruduto " )
public class Produto {
	@Identidade
	@GeneratedValue ( estratégia  =  GenerationType . IDENTITY )
	private  long idProduto;
	private  @NotNull  String nomeProduto;
	private  String descricaoProduto;
	private  @NotNull  double preco;

	@ManyToOne ( fetch  =  FetchType . EAGER )
	@JoinColumn ( name  =  " idCategoria " )
	@JsonIgnoreProperties ( " produto " )
	 categoria privada categoria;

	public  Categoria  getCategoria () {
		voltar categoria;
	}

	public  void  setCategoria ( Categoria  categoria ) {
		isso . categoria = categoria;
	}

	public  long  getIdProduto () {

		return idProduto;
	}

	public  void  setIdProduto ( long  idProduto ) {
		isso . idProduto = idProduto;
	}

	public  String  getNomeProduto () {
		return nomeProduto;
	}

	public  void  setNomeProduto ( String  nomeProduto ) {
		isso . nomeProduto = nomeProduto;
	}

	public  String  getDescricaoProduto () {
		return descricaoProduto;
	}

	public  void  setDescricaoProduto ( String  descricaoProduto ) {
		isso . descricaoProduto = descricaoProduto;
	}

	public  double  getPreco () {
		return preco;
	}

	public  void  setPreco ( double  preco ) {
		isso . preco = preco;
	}

}
