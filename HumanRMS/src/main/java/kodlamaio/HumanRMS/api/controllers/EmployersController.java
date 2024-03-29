package kodlamaio.HumanRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HumanRMS.business.abstracts.EmployerService;
import kodlamaio.HumanRMS.core.utilities.results.DataResult;
import kodlamaio.HumanRMS.core.utilities.results.Result;
import kodlamaio.HumanRMS.entites.concretes.Employer;

@RestController
@RequestMapping("api/employers")
@CrossOrigin
public class EmployersController {
	
	private EmployerService employerService;
	
	@Autowired
	public EmployersController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Employer employer) {
		
		return this.employerService.add(employer);
	}
	
//	@PostMapping("/update")
//	public Result update(@RequestBody Employer employer) {
//		
//		return this.employerService.update(employer);
//	}
//	
//	@PostMapping("/delete")
//	public Result delete(@PathVariable("int") int id) {
//		
//		return this.employerService.delete(id);
//	}
//	
//	@GetMapping("/getbyid")
//	public DataResult<Employer> getById(@PathVariable("id") int id){
//		
//		return this.employerService.getById(id);
//	}
	
	@GetMapping("/getall")
	public DataResult<List<Employer>> getAll(){
		
		return this.employerService.getAll();
	}
	
	

}
