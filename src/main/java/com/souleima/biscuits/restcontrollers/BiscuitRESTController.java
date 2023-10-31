package com.souleima.biscuits.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.souleima.biscuits.entities.Biscuit;
import com.souleima.biscuits.service.BiscuitService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class BiscuitRESTController {
	@Autowired
	BiscuitService biscuitService;
	
	@RequestMapping(path="all",method =RequestMethod.GET)
	public List<Biscuit> getAllBiscuits() {
		return biscuitService.getAllBiscuits();
	 } 		
	
	@RequestMapping(value="/getbyid/{id}",method = RequestMethod.GET)
	//@GetMapping("/getbyid/{id}")
	public Biscuit getBiscuitById(@PathVariable("id") Long id) {	
		return biscuitService.getBiscuit(id);
    }
	
	@RequestMapping(value="/addbisc",method = RequestMethod.POST)
	//@PostMapping("/addprod")
	public Biscuit createBiscuit(@RequestBody Biscuit biscuit) {
		System.out.println(biscuit);
		return biscuitService.saveBiscuit(biscuit);
	}

	@RequestMapping(value="/updatebisc",method = RequestMethod.PUT)
	//@PutMapping("/updateprod")
	public Biscuit updateBiscuit(@RequestBody Biscuit biscuit) {
		return biscuitService.updateBiscuit(biscuit);
	}

	@RequestMapping(value="/delbisc/{id}",method = RequestMethod.DELETE)
	//@DeleteMapping("/delprod/{id}")
	public void deleteBiscuit(@PathVariable("id") Long id)
	{
		biscuitService.deleteBiscuitById(id);
	}
	
	@RequestMapping(value="/biscsmarque/{idMarque}",method = RequestMethod.GET)
	public List<Biscuit> getBiscuitsByCatId(@PathVariable("idMarque") Long idMarque) {
		return biscuitService.findByMarqueIdMarque(idMarque);
	 }


}
