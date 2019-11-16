package com.pacebank.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;

@Controller
@RequestMapping(path="/")
public class MainController {
	@Autowired
	private UserRepository userRepository;

	@PostMapping(path="/register")
	public String register (@RequestParam String email
            , @RequestParam String first, @RequestParam String last 
            , @RequestParam String password) {

        User user = new User();
        user.setEmail(email);
		user.setFirstName(first);
        user.setLasttName(last);
        user.setPassword(password);
		userRepository.save(user);
		return "home";
	}

	@PostMapping(path="/login")
	public String login(@RequestParam String email, @RequestParam String password) {
        for (User user : userRepository.findByEmail(email)) {
            if (user.getPassword().equals(password)) {
                return "home";
            }
        }
        return "index";
    }
    
    @GetMapping(path="/")
	public String index() {
        return "index";
    }
    
    @GetMapping(path="/apply")
	public String apply() {
        return "apply";
    }
    
    @PostMapping(path="/submitApplication")
	public @ResponseBody String login(@RequestParam Integer salary, @RequestParam Integer yearsEmployed,  @RequestParam Integer age) {
        
        return "Success! Your application is being processed. We will update you as soon as we can.";
    }
}