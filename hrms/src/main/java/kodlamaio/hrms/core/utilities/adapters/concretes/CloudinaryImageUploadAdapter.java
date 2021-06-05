package kodlamaio.hrms.core.utilities.adapters.concretes;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hrms.core.utilities.adapters.abstracts.CloudinaryImageUploadService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;

@Service
public class CloudinaryImageUploadAdapter implements CloudinaryImageUploadService{

	private Cloudinary cloudinary;
	
	public CloudinaryImageUploadAdapter() {
		this.cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "dejnsjh7e",
				"api_key", "842932712473155",
				"api_secret", "2VIjrOXh3K7aRzYTY6NfP7JdCAU"));
	}

	@Override
	public DataResult<Map> uploadImageFile(MultipartFile imageFile) {
		try {
			@SuppressWarnings("unchecked")
			Map<String, String> resultMap =(Map<String, String>) cloudinary.uploader().upload(imageFile.getBytes(), ObjectUtils.emptyMap());
			return new SuccessDataResult<Map>(resultMap);
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		return new ErrorDataResult<Map>();
	}

}
