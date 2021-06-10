package kodlamaio.hrms.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.entities.concretes.School;

@RestController
@RequestMapping("/api/schools")
@CrossOrigin
public class SchoolController {

	private SchoolService schoolService;

	@Autowired
	public SchoolController(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody School school){
		return ResponseEntity.ok(this.schoolService.add(school));
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody School school){
		return ResponseEntity.ok(this.schoolService.update(school));
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> delete(@RequestParam("id") int id){
		return ResponseEntity.ok(this.schoolService.delete(id));
	}
	
	@GetMapping("/getbyid")
	public ResponseEntity<?> getById(@RequestParam("id") int id){
		return ResponseEntity.ok(this.schoolService.getById(id));
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.schoolService.getAll());
	}
	
	@GetMapping("/getAllByJobseekerIdOrderByEndAtDesc")
	public ResponseEntity<?> getAllByJobseekerIdOrderByEndAtAsc(@RequestParam("id") int id){
		return ResponseEntity.ok(this.schoolService.getByJobseekerIdOrderByEndAtAsc(id));
	}
	
	@GetMapping("/getAllByJobseekerId")
	public ResponseEntity<?> getAllByJobseekerId(@RequestParam("id") int id){
		return ResponseEntity.ok(this.schoolService.getByJobseekerId(id));
	}
}
