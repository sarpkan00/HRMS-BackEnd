package kodlamaio.HumanRMS.core.utilities.ImageUpload;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.HumanRMS.core.utilities.results.DataResult;
import kodlamaio.HumanRMS.core.utilities.results.ErrorDataResult;
import kodlamaio.HumanRMS.core.utilities.results.SuccessDataResult;

@Component
public class ImageUploadManager implements ImageUploadService {
	
	private Cloudinary cloudinary;
	
	@Autowired
	public ImageUploadManager() {

		this.cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "dayx2sam5",
				"api_key", "699443261618643",
				"api_secret", "LaC_8aO4_p-vseLXfpOJGuC-sjI"));
	}


	@Override
	public DataResult<Map> uploadImageFile(MultipartFile imageFile) {
		try {
			@SuppressWarnings("unchecked")
			Map<String, String> resultMap =(Map<String, String>) cloudinary.uploader().upload(imageFile.getBytes(), ObjectUtils.emptyMap());
			return new SuccessDataResult<Map>(resultMap);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return new ErrorDataResult<Map>();
	}
}
