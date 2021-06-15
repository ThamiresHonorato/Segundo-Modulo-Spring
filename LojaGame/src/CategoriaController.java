
import  java.util.List ;

import  org.springframework.beans.factory.annotation.Autowired ;
import  org.springframework.http.ResponseEntity ;
import  org.springframework.web.bind.annotation.DeleteMapping ;
import  org.springframework.web.bind.annotation.GetMapping ;
import  org.springframework.web.bind.annotation.PathVariable ;
import  org.springframework.web.bind.annotation.PostMapping ;
import  org.springframework.web.bind.annotation.PutMapping ;
import  org.springframework.web.bind.annotation.RequestBody ;
import  org.springframework.web.bind.annotation.RequestMapping ;
import  org.springframework.web.bind.annotation.RequestParam ;
import  org.springframework.web.bind.annotation.RestController ;

import  com.LojaGames.Loja.model.Categoria ;
import  com.LojaGames.Loja.repository.CategoriaRepository ;

@RestController
@RequestMapping ( " / categoria " )
public class CategoriaController {
	@Autowired
	privado  CategoriaRepository repositoryC;

	@GetMapping ( " / todos " )
	
	public  ResponseEntity < List  <Categoria >>  getAll () {
		Lista < Categoria > listaDeCategoria =

	repositoryC . encontrar tudo();

	if(listaDeCategoria.isEmpty())

	{
			retornar  ResponseEntity . status ( 204 ) . construir();
		
		}else
	{
			retornar  ResponseEntity . status ( 200 ) . corpo (listaDeCategoria);
		}

	}

	@GetMapping ( " / {idCategoria} " )
	
	public  ResponseEntity < Categoria >  GetById ( @PathVariable  long  idCategoria ) {
		return repositoryC . findById (idCategoria)
				.map (resp - >  ResponseEntity . ok (resp))
				.orElse ( ResponseEntity . notFound () . build ());
	}

	@GetMapping ( " / descricaoCategoria " )
	
	public  ResponseEntity < Object > buscarDescricaoCategoria ( @RequestParam ( defaultValue  =  " " ) String  descricaoCategoria ) {
	Lista < Categoria > listaDeCategoria = repositoryC . findAllByDescricaoCategoriaContainingIgnoreCase (descricaoCategoria);
		
		if (listaDeCategoria . isEmpty ()) {
			retornar  ResponseEntity . status ( 204 ) . construir();
			
		} else {
			retornar  ResponseEntity . status ( 200 ) . corpo (listaDeCategoria);
		}
	}

	@PostMapping
	public  ResponseEntity < Categoria > post ( @RequestBody  Categoria  nome ) {
		retornar  ResponseEntity . status ( 201 ) . corpo (repositórioC . salvar (nome));
	}

	@PutMapping
	public  ResponseEntity < Categoria > put ( @RequestBody  Categoria  nome ) {
		retornar  ResponseEntity . status ( 200 ) . corpo (repositórioC . salvar (nome));
	}

	@DeleteMapping ( " / {idCategoria} " )
	public  void  delete ( @PathVariable  long  idCategoria ) {
		repositoryC . deleteById (idCategoria);
	}
}
