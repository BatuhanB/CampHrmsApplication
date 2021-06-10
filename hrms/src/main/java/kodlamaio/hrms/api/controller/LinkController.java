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

import kodlamaio.hrms.business.abstracts.LinkService;
import kodlamaio.hrms.entities.concretes.Link;

@RestController
@RequestMapping("/api/links")
@CrossOrigin
public class LinkController {

	private LinkService linkService;

	@Autowired
	public LinkController(LinkService linkService) {
		super();
		this.linkService = linkService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody Link link){
		return ResponseEntity.ok(this.linkService.add(link));
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody Link link){
		return ResponseEntity.ok(this.linkService.update(link));
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> delete(@RequestParam("id") int id){
		return ResponseEntity.ok(this.linkService.delete(id));
	}
	
	@GetMapping("/getbyid")
	public ResponseEntity<?> getById(@RequestParam("id") int id){
		return ResponseEntity.ok(this.linkService.getById(id));
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.linkService.getAll());
	}
	
	@GetMapping("/getAllByJobseekerId")
	public ResponseEntity<?> getAllByJobseekerId(@RequestParam("id") int id){
		return ResponseEntity.ok(this.linkService.getByJobseekerId(id));
	}
	
}
