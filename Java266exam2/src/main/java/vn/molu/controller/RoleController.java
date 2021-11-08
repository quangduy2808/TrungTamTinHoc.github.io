package vn.molu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import vn.molu.dao.impl.UserRepository;

import vn.molu.domain.User;

@Controller
public class RoleController {
//	Phải có role_admin mới edit user đươc (user: admin /pass: admin)
	UserRepository repository = new UserRepository();

//	quan ly user
	@RequestMapping("user/list.html")
	public String list(Model model) {
		model.addAttribute("listOfUser", repository.findAll());
		return "user.list";
	}

// edit user
	@RequestMapping("user/edit.html")
	public String edit(@RequestParam("username") String username, Model model) {
		model.addAttribute("user", repository.logOn(username));
		return "user.edit";
	}

	@RequestMapping(value = "user/edit.html", method = RequestMethod.POST)
	public String edit(User user) {
		repository.edit(user);
		return "redirect:/user/list.html";
	}
//	delete
	@RequestMapping("user/dels.html")
	public String del(@RequestParam("username") String username) {
		repository.delete(username);
		return "redirect:/user/list.html";
	}
}
