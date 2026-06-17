package org.tymi.auth.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tymi.auth.HttpModels.HttpAuthMethod;
import org.tymi.auth.Repositories.AuthMethodRepository;
import org.tymi.auth.Repositories.UserRepository;

import java.util.List;

@Service
public class UserService {
	private final UserRepository userRepository;
	private final AuthMethodRepository authMethodRepository;

	public UserService(UserRepository userRepository, AuthMethodRepository authMethodRepository) {
		this.userRepository = userRepository;
		this.authMethodRepository = authMethodRepository;
	}

	@Transactional(readOnly = true)
	public List<HttpAuthMethod> getAuthMethodsForUser(String username) {
		return authMethodRepository.findAuthMethodModelByUser_Username(username).stream().map(entry -> new HttpAuthMethod(entry.getId(), entry.getMethod().getName())).toList();
	}
}
