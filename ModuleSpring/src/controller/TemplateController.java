package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TemplateController {
	@RequestMapping("template.html")
	public String template() {
		return "template";
	}
}
