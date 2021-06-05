package kodlamaio.hrms.entities.dtos;


import java.util.List;


import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kodlamaio.hrms.entities.concretes.Experience;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.concretes.Link;
import kodlamaio.hrms.entities.concretes.School;
import kodlamaio.hrms.entities.concretes.Skill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import kodlamaio.hrms.entities.concretes.Image;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobSeekerResumeDto {

	@JsonIgnore
	public JobSeeker jobSeeker;
	public List<@Valid School> school;
	public List<@Valid Language> language;
	public List<@Valid Skill> skill;
	public List<@Valid Experience> experience;
	public List<@Valid Link> link;
	public Image image;
}
