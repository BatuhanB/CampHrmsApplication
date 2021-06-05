package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Image;

public interface ImageService {

	Result add(Image image, MultipartFile imageFile);
	
	Result addAll(List<Image> image);

	Result update(Image image);

	Result delete(int id);

	DataResult<Image> getById(int id);

	DataResult<List<Image>> getAll();

	DataResult<Image> getByJobseekerId(int id);
}
