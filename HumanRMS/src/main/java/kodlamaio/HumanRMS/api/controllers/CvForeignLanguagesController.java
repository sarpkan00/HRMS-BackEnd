package kodlamaio.HumanRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HumanRMS.business.abstracts.CvForeignLanguageService;
import kodlamaio.HumanRMS.core.utilities.results.DataResult;
import kodlamaio.HumanRMS.core.utilities.results.Result;
import kodlamaio.HumanRMS.entites.concretes.CvForeignLanguage;

@RestController
@RequestMapping("/api/languages")
@CrossOrigin
public class CvForeignLanguagesController {
	
	private CvForeignLanguageService cvForeignLanguageService;
	
	@Autowired
	public CvForeignLanguagesController(CvForeignLanguageService cvForeignLanguageService) {
		super();
		this.cvForeignLanguageService = cvForeignLanguageService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CvForeignLanguage cvForeignLanguage){
		return this.cvForeignLanguageService.add(cvForeignLanguage);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody CvForeignLanguage cvForeignLanguage){
		return this.cvForeignLanguageService.update(cvForeignLanguage);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam("id") int id){
		return this.cvForeignLanguageService.delete(id);
	}
	
	@GetMapping("/getById")
	public DataResult<CvForeignLanguage> getById(@RequestParam("id") int id){
		return this.cvForeignLanguageService.getById(id);
	}
	
	@GetMapping("/getByAllJobSeekerId")
	public DataResult<List<CvForeignLanguage>> getByAllJobSeekerId(@RequestParam("id") int id){
		return this.cvForeignLanguageService.getAllByJobSeekerId(id);
	}
	
	
	@GetMapping("/getAll")
	public DataResult<List<CvForeignLanguage>> getAll(){
		return this.cvForeignLanguageService.getAll();
	}

}
