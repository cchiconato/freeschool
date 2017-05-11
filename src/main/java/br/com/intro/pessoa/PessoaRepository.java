package br.com.intro.pessoa;

import org.springframework.data.jpa.repository.JpaRepository;
import java.lang.String;
import br.com.intro.pessoa.PessoaEntity;
import java.util.List;

public interface PessoaRepository extends JpaRepository<PessoaEntity, Long>{

	public List<PessoaEntity> findByNome(String nome);

	public PessoaEntity findById(long id);
	
	
}
