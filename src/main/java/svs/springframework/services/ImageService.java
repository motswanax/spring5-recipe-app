package svs.springframework.services;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author BAD
 * @version 08/05/19
 */
public interface ImageService {

    void saveImageFile(Long recipeId, MultipartFile file);
}