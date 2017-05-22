package br.com.intro.post;

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

import br.com.intro.user.UserVerificationEmailSender;
import br.com.intro.user.UserVerificationEntity;
import br.com.intro.user.UserVerificationRepository;
import br.com.intro.utils.ServiceMap;

@RestController
@RequestMapping(path = "/api/user")
public class PostService implements ServiceMap {

	@Autowired
	private PostRepository postRepository;

	@RequestMapping(method = RequestMethod.GET)
	public List<PostEntity> findAll() {
		return postRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public void insert(@RequestBody PostEntity postEntity) {
		postRepository.save(postEntity);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public PostEntity update(@RequestBody PostEntity userEntity) {
		return postRepository.save(userEntity);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<PostEntity> delete(@PathVariable Long id) {
		PostEntity postFound = postRepository.findById(id);
		postRepository.delete(postFound);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
