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
import vn.molu.dao.impl.EmployeeRepository;
import vn.molu.domain.Department;
import vn.molu.domain.Employee;

@Controller
public class EmployeeController {
	EmployeeRepository repository = new EmployeeRepository();
	DepartmentRepository repository2 = new DepartmentRepository();

	@RequestMapping("employee/list.html")
	public String list(Model model) {
		model.addAttribute("listOfEmployee", repository.findAll());
		return "employee.list";
	}

	@RequestMapping(value = "employee/add.html", method = RequestMethod.GET)
	public String add(Model model) {
		List<Department> list = repository2.findAll();
		Map<Long, String> map = new HashMap<>();
		for (Department item : list) {
			map.put(item.getId(), item.getName());
		}
		model.addAttribute("map", map);
		model.addAttribute("employee", new Employee());
		return "employee.add";
	}

	@RequestMapping(value = "employee/add.html", method = RequestMethod.POST)
	public String add(Employee employee) {
		repository.save(employee);
		return "redirect:/employee/list.html";
	}

	@RequestMapping("employee/edit.html")
	public String edit(@RequestParam("id") long id, Model model) {
		model.addAttribute("employee", repository.find(id));
		return "employee.edit";
	}

	@RequestMapping(value = "employee/edit.html", method = RequestMethod.POST)
	public String edit(Employee employee) {
		repository.edit(employee);
		return "redirect:/employee/list.html";
	}

	@RequestMapping("employee/dels.html")
	public String del(@RequestParam("id") long id) {
		repository.delete(id);
		return "redirect:/employee/list.html";
	}
}
