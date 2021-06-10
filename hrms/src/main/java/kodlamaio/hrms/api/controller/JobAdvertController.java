package kodlamaio.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvert;

@RestController
@RequestMapping("/api/jobadds")
@CrossOrigin
public class JobAdvertController {

	private JobAdvertService jobAdvertService;

	@Autowired
	public JobAdvertController(JobAdvertService jobAdvertService) {
		super();
		this.jobAdvertService = jobAdvertService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvert jobAdvert) {
		return this.jobAdvertService.add(jobAdvert);
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvert>> getAll(){
		return this.jobAdvertService.getAll();
	}
	
	@PostMapping("/changeOpenToClose")
	public Result changeOpenToClose(int id) {
		return this.jobAdvertService.changeOpenToClose(id);
	}
	
	@GetMapping("/getByOpen")
	public DataResult<List<JobAdvert>> getAllOpen(){
		return this.jobAdvertService.getAllOpen();
	}
	
	@GetMapping("/findAllByOpenOrderByPublishDate")
	DataResult<List<JobAdvert>> findAllByOpenOrderByPublishDate(){
		return this.jobAdvertService.getByOpenOrderByPublishDate();
	}
	
	@GetMapping("/getAllOpenAndEmployer")
	DataResult<List<JobAdvert>> getAllOpenAndEmployer_Id(int id){
		return this.jobAdvertService.getOpenAndEmployer_Id(id);
	}
	
	
	
}