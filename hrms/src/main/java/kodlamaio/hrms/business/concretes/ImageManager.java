package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.core.utilities.adapters.abstracts.CloudinaryImageUploadService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ImageDao;
import kodlamaio.hrms.entities.concretes.Image;

@Service
public class ImageManager implements ImageService{

	private ImageDao imageDao;
	private CloudinaryImageUploadService imageUploadService;
	
	@Autowired
	public ImageManager(ImageDao imageDao,CloudinaryImageUploadService imageUploadService) {
		super();
		this.imageDao = imageDao;
		this.imageUploadService = imageUploadService;
				
	}

	@Override
	public Result add(Image image, MultipartFile imageFile) {
		@SuppressWarnings("unchecked")
		Map<String,String> uploadImage = this.imageUploadService.uploadImageFile(imageFile).getData();
		image.setUrl(uploadImage.get("url"));
		this.imageDao.save(image);
		return new SuccessResult("Image has been successfully added.");
	}
	
	@Override
    public Result addAll(List<Image> image) {
		imageDao.saveAll(image);
        return new SuccessResult("Image has been successfully added.");
    }

	@Override
	public Result update(Image image) {
		this.imageDao.save(image);
		return new SuccessResult("Image has been successfully updated.");
	}

	@Override
	public Result delete(int id) {
		this.imageDao.deleteById(id);;
		return new SuccessResult("Image has been successfully deleted.");
	}

	@Override
	public DataResult<Image> getById(int id) {
		return new SuccessDataResult<Image>(this.imageDao.getById(id));
	}

	@Override
	public DataResult<List<Image>> getAll() {
		return new SuccessDataResult<List<Image>>(this.imageDao.findAll());
	}

	@Override
	public DataResult<Image> getByJobseekerId(int id) {
		return new SuccessDataResult<Image>(this.imageDao.getByJobSeeker_id(id));
	}

}
