package net.javaguides.springboot.web;

import net.javaguides.springboot.model.Customer;
import net.javaguides.springboot.repository.CustomerRepository;
import net.javaguides.springboot.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

	@Autowired
	private CustomerRepository customerRepository ;

	@Autowired
	private CustomerService customerService ;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/")
	public String home() {
		return "Main";
	}

	@GetMapping("/customerRegistration")
	public String customerRegistration() {
		return "AddCustomer";
	}



	@PostMapping("/customerRegistration")
	public String customerRegistration(@ModelAttribute Customer customer) {

		System.out.println(customer);
		customerRepository.save(customer);
		return "redirect:/customerRegistration?success";
	}

	@GetMapping("/showCustomer")
	public String showCustomer(Model model) {

		List<Customer> Customer = new ArrayList<>(customerService.search());
		System.out.println(Customer);
		model.addAttribute("Customer", Customer);
		return "ShowCustomer";
	}

}
