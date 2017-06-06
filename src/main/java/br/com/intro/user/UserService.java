package br.com.intro.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import br.com.intro.utils.EmailSender;
import br.com.intro.utils.ServiceMap;

@RestController
@RequestMapping(path = "/api/user")
public class UserService implements ServiceMap {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserVerificationRepository userVerificationRepository;
  	@Autowired
	private UserVerificationEntity userVerificationEntity;

	@RequestMapping(method = RequestMethod.GET)
	public List<UserEntity> findAll() {
		return userRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public void insert(@RequestBody UserEntity userEntity) {
		userRepository.save(userEntity);
		userVerificationEntity.setUserName(userEntity.getUserName());
		userVerificationEntity.setVerificationKey(userEntity.getToken());
		userVerificationRepository.save(userVerificationEntity);
		EmailSender.sendEmailForUserConfirmation(userVerificationEntity, userEntity);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public UserEntity update(@RequestBody UserEntity userEntity) {
		return userRepository.save(userEntity);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<UserEntity> delete(@PathVariable Long id) {
		UserEntity userFound = userRepository.findById(id);
		userRepository.delete(userFound);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(path = "/activate/{verificationKey}", method = RequestMethod.GET)
	public RedirectView activateUser(@PathVariable String verificationKey) {
		UserVerificationEntity userVerificationEntityFound = userVerificationRepository.findByVerificationKey(verificationKey);
		if (userVerificationEntityFound == null) return new RedirectView("http://conta_ja_ativa.com.br"); //TODO mudar link para página de conta já ativada;
		UserEntity userFound = userRepository.findByUserName(userVerificationEntityFound.getUserName());
		userFound.setVerified(true);
		userRepository.save(userFound);
		userVerificationRepository.delete(userVerificationEntityFound);
		return new RedirectView("http://conta_ativada_com_sucesso.com.br"); //TODO mudar link para página de conta ativada com sucesso
	}
}
