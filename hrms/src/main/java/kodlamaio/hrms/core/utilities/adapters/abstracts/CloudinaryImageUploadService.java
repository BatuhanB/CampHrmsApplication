package kodlamaio.hrms.core.utilities.adapters.abstracts;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;

public interface CloudinaryImageUploadService {

	DataResult<Map> uploadImageFile(MultipartFile imageFile);
}
