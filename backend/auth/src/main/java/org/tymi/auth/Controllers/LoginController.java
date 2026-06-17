package org.tymi.auth.Controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tymi.auth.HttpModels.HttpAuthMethod;
import org.tymi.auth.HttpModels.BeginLoginRequest;
import org.tymi.auth.HttpModels.BeginLoginResponse;
import org.tymi.auth.Services.UserService;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class LoginController {
	private UserService userService;

	LoginController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/begin-login")
	public BeginLoginResponse beginLogin(BeginLoginRequest beginLoginRequest) {
		Logger.getLogger(LoginController.class.getName()).log(Level.INFO, "Begin Login Request");
		var methods = userService.getAuthMethodsForUser("tymi");

		return new BeginLoginResponse(methods);
	}
}
