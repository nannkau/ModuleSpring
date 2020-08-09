package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.Product;
import model.ProductRepository;
@Controller 
@RequestMapping("home")
public class HomeController {
	private ProductRepository repository= new ProductRepository();
	private final int size=6;
	@RequestMapping(value = {"index.html"})
	public String index(Model model,@RequestParam(value = "p",required = false) Integer p) {
		if(p==null) {
			p=1;
		}
		List<Product> products= repository.getAll(p, size);
		int cout=(int) Math.ceil(repository.count()/size);
		model.addAttribute("n", cout);
		model.addAttribute("list",products);
		return "home.index";
	}
	@RequestMapping(value = {"index.html"},method = RequestMethod.POST)
	public String index(Model model,@RequestParam(value = "p",required = false) Integer p,@RequestParam("search") String search) {
		List<Product> products= new ArrayList<Product>();
		if(p==null) {
			p=1;
		}
		
		if(search!=null) {
		 products= repository.getAll(p, size,search);
		}
		else {
			 products= repository.getAll(p, size);
		}
		int cout=(int) Math.ceil(repository.count()/size);
		model.addAttribute("search", search);
		model.addAttribute("n", cout);
		model.addAttribute("list",products);
		return "home.index";
	}
	@RequestMapping("detail.html/{id}")
	public String detail(Model model,@PathVariable("id") int id) {
		Product product= repository.getById(id);
		model.addAttribute("o", product);
		return "home.detail";
	}
}
