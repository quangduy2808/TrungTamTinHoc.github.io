package vn.molu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import vn.molu.dao.impl.DepartmentRepository;
import vn.molu.dao.impl.ProjectRepository;
import vn.molu.domain.Department;
import vn.molu.domain.Project;


@Controller
public class ProjectController {
	ProjectRepository repository = new ProjectRepository();
	DepartmentRepository repository2 = new DepartmentRepository();

	@RequestMapping("project/list.html")
	public String list(Model model) {
		model.addAttribute("listOfProject", repository.findAll());
		return "project.list";
	}

	@RequestMapping(value = "project/add.html", method = RequestMethod.GET)
	public String add(Model model) {
		List<Department> list = repository2.findAll();
		Map<Long, String> map = new HashMap<>();
		for (Department item : list) {
			map.put(item.getId(), item.getName());
		}
		model.addAttribute("map", map);
		model.addAttribute("project", new Project() );
		return "project.add";
	}

	@RequestMapping(value = "project/add.html", method = RequestMethod.POST)
	public String add(Project project) {
		
		repository.save(project);
		return "redirect:/project/list.html";
	}

	@RequestMapping("project/edit.html")
	public String edit(@RequestParam("id") long id, Model model) {
		model.addAttribute("project", repository.find(id));
		return "project.edit";
	}

	@RequestMapping(value = "project/edit.html", method = RequestMethod.POST)
	public String edit(Project project) {
		repository.edit(project);
		return "redirect:/project/list.html";
	}

	@RequestMapping("project/dels.html")
	public String del(@RequestParam("id") long id) {
		repository.delete(id);
		return "redirect:/project/list.html";
	}
}
