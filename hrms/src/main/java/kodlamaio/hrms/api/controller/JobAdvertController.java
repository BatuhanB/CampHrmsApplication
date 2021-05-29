package kodlamaio.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
public class JobAdvertController {

	private JobAdvertService jobAddService;

	@Autowired
	public JobAdvertController(JobAdvertService jobAddService) {
		super();
		this.jobAddService = jobAddService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvert jobAdvert) {
		return this.jobAddService.add(jobAdvert);
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvert>> getAll(){
		return this.jobAddService.getAll();
	}
	
	@PostMapping("/changeOpenToClose")
	public Result changeOpenToClose(int id) {
		return this.changeOpenToClose(id);
	}
	
	@GetMapping("/getByOpen")
	public DataResult<List<JobAdvert>> getAllOpen(){
		return this.jobAddService.getAllOpen();
	}
	
	@GetMapping("/findAllByOpenOrderByPublishDate")
	DataResult<List<JobAdvert>> findAllByOpenOrderByPublishDate(){
		return this.jobAddService.findAllByOpenOrderByPublishDate();
	}
	
	@GetMapping("/getAllOpenAndEmployer")
	DataResult<List<JobAdvert>> getAllOpenAndEmployer_Id(int id){
		return this.jobAddService.getAllOpenAndEmployer_Id(id);
	}
	
	
	
}