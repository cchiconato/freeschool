package br.com.freeschool.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import br.com.freeschool.utils.EmailSender;
import br.com.freeschool.utils.ServiceMap;

@RestController
@RequestMapping(path = "/api/public/user")
public class UserService implements ServiceMap {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserVerificationRepository userVerificationRepository;
  	@Autowired
	private UserVerificationEntity userVerificationEntity;

	@RequestMapping(method = RequestMethod.POST)
	public void insert(@RequestBody UserEntity userEntity) {
		userRepository.save(userEntity);
		userVerificationEntity.setUserName(userEntity.getUsername());
		userVerificationEntity.setVerificationKey(userEntity.getToken());
		userVerificationRepository.save(userVerificationEntity);
		EmailSender.sendEmailForUserConfirmation(userEntity);
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