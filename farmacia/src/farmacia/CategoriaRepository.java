package farmacia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farmacia.farmaciaSunFlower.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>  {
	public List<Categoria> findAllByDescricaoCategoriaContainingIgnoreCase(String descricaoCategoria);
}
