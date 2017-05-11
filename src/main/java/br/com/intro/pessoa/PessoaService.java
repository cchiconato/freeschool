package br.com.intro.pessoa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.intro.utils.ServiceMap;

@RestController
@RequestMapping(path = "/api/pessoa")
public class PessoaService implements ServiceMap {

	@Autowired
	private PessoaRepository pessoaRepository;

	@RequestMapping(method = RequestMethod.GET)
	public List<PessoaEntity> findAll() {
		return pessoaRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public PessoaEntity insert(@RequestBody PessoaEntity pessoaEntity) {
		return pessoaRepository.save(pessoaEntity);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public PessoaEntity update(@RequestBody PessoaEntity pessoaEntity) {
		return pessoaRepository.save(pessoaEntity);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<PessoaEntity> delete(@PathVariable Long id) {
		PessoaEntity pessoaEncontrada = pessoaRepository.findById(id);
		pessoaRepository.delete(pessoaEncontrada);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}
