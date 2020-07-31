package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Category;
import model.CategoryRepository;

@Controller
@RequestMapping("admin/category")
public class CategoryController {
	private CategoryRepository repository= new CategoryRepository();
	@RequestMapping("index.html")
	public String index(Model model) {
		List<Category> categories=repository.getAll();
		model.addAttribute("list", categories);
		return "category.index";
	}
	@RequestMapping("add.html")
	public String add(Model model) {
		List<Category> categories= repository.getListParent();
		Map<Integer, String> map= new HashMap<Integer, String>();
		for (Category category : categories) {
			map.put(category.getId(), category.getName());
		}
		model.addAttribute("map", map);
		model.addAttribute("obj", new Category());
		return "category.add";
		
	}
	@RequestMapping(value="add.html", method=RequestMethod.POST)
	public String add(Category obj,Model model) {
		repository.add(obj);
		return "redirect:/admin/category/index.html";
		
	}
	@RequestMapping("edit.html/{id}")
	public String edit(Model model,@PathVariable("id") int id) {
		List<Category> categories= repository.getListParent();
		Map<Integer, String> map= new HashMap<Integer, String>();
		for (Category category : categories) {
			map.put(category.getId(), category.getName());
		}
		model.addAttribute("map", map);
		model.addAttribute("obj", repository.findById(id));
		return "category.edit";
	}
	@RequestMapping(value="edit.html/{id}", method=RequestMethod.POST)
	public String edit(Category obj,Model model) {
		repository.edit(obj);
		return "redirect:/admin/category/index.html";
		
	}
	
}
