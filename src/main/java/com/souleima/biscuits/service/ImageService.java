package com.souleima.biscuits.service;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.souleima.biscuits.entities.Image;

public interface ImageService {
	Image uplaodImage(MultipartFile file) throws IOException;
	Image getImageDetails(Long id) throws IOException;
	ResponseEntity<byte[]> getImage(Long id) throws IOException;
	void deleteImage(Long id) ;

	
	Image uplaodImageBisc(MultipartFile file,Long idBisc) throws IOException;
	List<Image> getImagesParBisc(Long biscId);

	

}