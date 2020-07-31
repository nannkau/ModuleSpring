package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Author;
import model.AuthorRepository;


@Controller
@RequestMapping("admin/author")
public class AuthorController {

	private AuthorRepository repository = new AuthorRepository();

	@RequestMapping("index.html")
	public String index(Model model) {
		List<Author> list = repository.getAll();
		System.out.print(list.size());
		model.addAttribute("list", list);
		return "author.index";
	}

	@RequestMapping("add.html")
	public String add() {
		return "author.add";
	}

	@RequestMapping(value = "add.html", method = RequestMethod.POST)
	public String add(Author author) {
		System.out.print("hahah");
		int data = repository.add(author);
		System.out.print(data);
		return "redirect:/admin/author/index.html";

	}

	@RequestMapping("edit.html/{id}")
	public String edit(Model model, @PathVariable("id") int id) {
		model.addAttribute("o", repository.getAuthor(id));
		return "author.edit";
	}

	@RequestMapping(value = "edit.html/{id}", method = RequestMethod.POST)
	public String edit(Model model, Author obj, @PathVariable("id") int id) {
		repository.edit(obj);
		return "redirect:/admin/author/index.html";
	}

}
