package vn.molu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import vn.molu.dao.impl.DepartmentRepository;
import vn.molu.domain.Department;

@Controller
public class DepartmentController {
	
	DepartmentRepository repository = new DepartmentRepository();
	@RequestMapping("department/list.html")
	public String list(Model model) {
		model.addAttribute("listOfDepartment", repository.findAll());
		return "list";
	}
	
	@RequestMapping(value = "department/add.html", method = RequestMethod.GET)
	public String add(Model model) {
		 model.addAttribute("department", new Department());
		return "add";
	}
	
	@RequestMapping(value = "department/add.html", method = RequestMethod.POST)
	public String add(Department department) {
		System.out.println("a");
		repository.save(department);
		return "redirect:/department/list.html";
	}
	@RequestMapping("department/edit.html")
	public String edit(@RequestParam("id") long id, Model model) {
		model.addAttribute("department", repository.find(id));
		return "edit";
	}
	@RequestMapping(value = "department/edit.html", method = RequestMethod.POST)
	public String edit(Department department) {
		repository.edit(department);
		return "redirect:/department/list.html";
	}
	@RequestMapping("department/dels.html")
	public String del(@RequestParam("id") long id) {
		repository.delete(id);
		return "redirect:/department/list.html";
	}
}
