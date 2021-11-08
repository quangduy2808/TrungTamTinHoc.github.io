package vn.molu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.molu.dao.impl.UserRepository;
import vn.molu.domain.User;

@Controller
public class UserController {

	UserRepository repository = new UserRepository();

	@RequestMapping("index.html")
	public String index() {
		return "index";
	}

	@RequestMapping("login.html")
	public String login() {
		return "login";
	}

	@RequestMapping("register")
	public String register() {
		return "register";
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register(User user) {

		if (repository.save(user)) {
			return "redirect:/login.html";
		} else {
			return "redirect:/register.html";
		}
	}

//	logout
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login.html";
	}
}
