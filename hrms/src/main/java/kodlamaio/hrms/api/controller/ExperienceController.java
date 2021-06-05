package kodlamaio.hrms.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.entities.concretes.Experience;

@RestController
@RequestMapping("/api/experiences")
public class ExperienceController {

	private ExperienceService experienceService;

	@Autowired
	public ExperienceController(ExperienceService experienceService) {
		super();
		this.experienceService = experienceService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody Experience experience){
		return ResponseEntity.ok(this.experienceService.add(experience));
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody Experience experience){
		return ResponseEntity.ok(this.experienceService.update(experience));
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> delete(@RequestParam("id") int id){
		return ResponseEntity.ok(this.experienceService.delete(id));
	}
	
	@GetMapping("/getbyid")
	public ResponseEntity<?> getById(@RequestParam("id") int id){
		return ResponseEntity.ok(this.experienceService.getById(id));
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.experienceService.getAll());
	}
	
	@GetMapping("/getAllByJobseekerIdOrderByEndAtDesc")
	public ResponseEntity<?> getAllByJobseekerIdOrderByEndAtAsc(@RequestParam("id") int id){
		return ResponseEntity.ok(this.experienceService.getByidOrderByEndAtAsc(id));
	}
	
	@GetMapping("/getAllByJobseekerId")
	public ResponseEntity<?> getAllByJobseekerId(@RequestParam int id){
		return ResponseEntity.ok(this.experienceService.getByJobseekerId(id));
	}
}
