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
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.entities.concretes.Image;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/images")
@CrossOrigin
public class ImageController {

	private ImageService imageService;
	private JobSeekerService jobSeekerService;
	
	@Autowired
	public ImageController(ImageService imageService, JobSeekerService jobSeekerService) {
		super();
		this.imageService = imageService;
		this.jobSeekerService = jobSeekerService;
	}
	
	@PostMapping(value = "/add")
	public ResponseEntity<?> add(@RequestParam(value = "id") int id, @RequestParam(value = "imageFile") MultipartFile imageFile){
		JobSeeker jobseeker = this.jobSeekerService.getById(id).getData();
		Image image = new Image();
		image.setJobSeeker(jobseeker);
		return ResponseEntity.ok(this.imageService.add(image, imageFile));
		//Alternatif islem
		//JobSeeker jobSeeker = new JobSeeker();
		//Image image1 = new Image();
		//jobSeeker.setId(id);
		//image1.setJobSeeker(jobSeeker);
		//return ResponseEntity.ok(this.imageService.add(image1, imageFile));
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody Image image){
		return ResponseEntity.ok(this.imageService.update(image));
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> delete(@RequestParam("id") int id){
		return ResponseEntity.ok(this.imageService.delete(id));
	}
	
	@GetMapping("/getbyid")
	public ResponseEntity<?> getById(@RequestParam("id") int id){
		return ResponseEntity.ok(this.imageService.getById(id));
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.imageService.getAll());
	}

	@GetMapping("/getByJobseekerId")
	public ResponseEntity<?> getByJobseekerId(@RequestParam int id){
		return ResponseEntity.ok(this.imageService.getByJobseekerId(id));
	}
}
