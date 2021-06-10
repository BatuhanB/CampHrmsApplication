package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.business.abstracts.LinkService;
import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.business.abstracts.SkillService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.dtos.JobSeekerResumeDto;

@Service
public class JobSeekerManager implements JobSeekerService{

	private JobSeekerDao jobSeekerDao;
	
	private ExperienceService experienceService;
	private SkillService skillService;
	private LanguageService languageService;
	private ImageService imageService;
	private LinkService linkService;
	private SchoolService schoolService;

	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, ExperienceService experienceService, SkillService skillService,
			LanguageService languageService, ImageService imageService,
			LinkService linkService, SchoolService schoolService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.experienceService = experienceService;
		this.skillService = skillService;
		this.languageService = languageService;
		this.imageService = imageService;
		this.linkService = linkService;
		this.schoolService = schoolService;
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult("Jobseeker has been added.");
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll());
	}

	@Override
	public DataResult<JobSeeker> getByIdentityNumber(String identityNumber) {
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.findByIdentityNumber(identityNumber));
	}

	@Override
	public DataResult<JobSeeker> getById(int id) {
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.getOne(id));
	}

	@Override
	public DataResult<JobSeekerResumeDto> getJobseekerResumeById(int id) {
			//JobSeeker jobSeeker = this.jobSeekerDao.getById(id);
			JobSeekerResumeDto resume = new JobSeekerResumeDto();
//			resume.experience = jobSeeker.getExperience();
//			resume.language = jobSeeker.getLanguage();
//			resume.image = jobSeeker.getImage();
//			resume.link = jobSeeker.getLink();
//			resume.skill = jobSeeker.getSkill();
//			resume.school = jobSeeker.getSchool();
			resume.experience = this.experienceService.getByJobseekerId(id).getData();
			resume.language = this.languageService.getByJobseekerId(id).getData();
			resume.image = this.imageService.getByJobseekerId(id).getData();
			resume.link = this.linkService.getByJobseekerId(id).getData();
			resume.skill = this.skillService.getByJobseekerId(id).getData();
			resume.school = this.schoolService.getByJobseekerId(id).getData();
			return new SuccessDataResult<JobSeekerResumeDto>(resume,"Listed");	
	}

}
