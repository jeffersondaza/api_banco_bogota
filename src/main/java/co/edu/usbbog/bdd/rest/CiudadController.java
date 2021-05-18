package co.edu.usbbog.bdd.rest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbbog.bdd.model.Ciudad;
import co.edu.usbbog.bdd.repo.CiudadRepository;

@RestController
@RequestMapping("/ciudad")
public class CiudadController {

	@Autowired
	CiudadRepository ciudadRepository;
	
	@GetMapping("/hola")
	public String hola() {
		return "Hola";
	}
	
	@PostMapping("/crear")
	public String crearCiudad(@RequestBody Ciudad ciudad) {
		try {
			ciudadRepository.save(ciudad);
			return "Se guardo la ciudad";
		} catch (IllegalArgumentException e) {
			return "No se guardo la ciudad: " + e.getMessage();
		}
	}
	
	@GetMapping("/cantidad")
	public int countCiudad() {
		int count = 0;
		try {
			count = (int) ciudadRepository.count();
			return count;
		} catch (IllegalArgumentException e) {
			return count;
		}
	}
	
}
