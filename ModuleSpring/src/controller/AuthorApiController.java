package controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import model.Author;
import model.AuthorRepository;

@RestController
public class AuthorApiController {
	private AuthorRepository repository= new AuthorRepository();
	@GetMapping("api/author")
	public List<Author> getAll(){
		List<Author> list = repository.getAll();
		return list;
	}
	@GetMapping("api/author/{id}")
	public Author getById(@PathVariable("id") int id){
		Author list = repository.getAuthor(id);
		return list;
	}
}
