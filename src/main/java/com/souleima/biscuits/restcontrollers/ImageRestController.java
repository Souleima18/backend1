package com.souleima.biscuits.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.souleima.biscuits.entities.Image;
import com.souleima.biscuits.entities.Biscuit;
import com.souleima.biscuits.service.ImageService;
import com.souleima.biscuits.service.BiscuitService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/image")
@CrossOrigin(origins = "*")
public class ImageRestController {
	 @Autowired
	 ImageService imageService ;
	 
	 @Autowired
	 BiscuitService biscuitService;
	 
	 
	 @RequestMapping(value = "/uploadFS/{id}" , method = RequestMethod.POST)
	 public void uploadImageFS(@RequestParam("image") MultipartFile 
			 file,@PathVariable("id") Long id) throws IOException {
		 Biscuit b = biscuitService.getBiscuit(id);
		 b.setImagePath(id+".jpg");

		 Files.write(Paths.get(System.getProperty("user.home")+"/images/"+b.getImagePath())
				 , file.getBytes());
		 biscuitService.saveBiscuit(b);

	 }
	 @RequestMapping(value = "/loadfromFS/{id}" , 
			 method = RequestMethod.GET,
			 produces = MediaType.IMAGE_JPEG_VALUE)
	 public byte[] getImageFS(@PathVariable("id") Long id) throws IOException {

		 Biscuit b = biscuitService.getBiscuit(id);
		 return	 Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/images/"+b.getImagePath()));
	 }

	 
	 
	 
	 
	 
	 
	 
	 @RequestMapping(value = "/upload" , method = RequestMethod.POST)
	 public Image uploadImage(@RequestParam("image")MultipartFile file) throws IOException {
		 	return imageService.uplaodImage(file);
	 }
	 
	 @PostMapping(value = "/uplaodImageBisc/{idBisc}" )
	 public Image uploadMultiImages(@RequestParam("image")MultipartFile file,
			 @PathVariable("idBisc") Long idBisc) 
					 throws IOException {
		 return imageService.uplaodImageBisc(file,idBisc);
	 }
	 
	 @RequestMapping(value = "/getImagesBisc/{idBisc}" , method = RequestMethod.GET)
	 public List<Image> getImagesProd(@PathVariable("idBisc") Long idBisc) 
			 throws IOException {
		 return imageService.getImagesParBisc(idBisc);
	 }
	 
	 
	 
	 
	 @RequestMapping(value = "/get/info/{id}" , method = RequestMethod.GET)
	 public Image getImageDetails(@PathVariable("id") Long id) throws IOException {
	 return imageService.getImageDetails(id) ;
	 }
	 
	 
	 @RequestMapping(value = "/load/{id}" , method = RequestMethod.GET)
	 public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException 
	{
	 return imageService.getImage(id);
	 }
	 
	 
	 @RequestMapping(value = "/delete/{id}" , method = RequestMethod.DELETE)
	 public void deleteImage(@PathVariable("id") Long id){
	 imageService.deleteImage(id);
	 }
	 
	 
	
	 @RequestMapping(value="/update",method = RequestMethod.PUT)
	 public Image UpdateImage(@RequestParam("image")MultipartFile file) throws IOException {
	 return imageService.uplaodImage(file);
	 }
	}
