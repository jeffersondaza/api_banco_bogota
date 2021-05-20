package co.edu.usbbog.bdd.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbbog.bdd.model.Ciudad;
import co.edu.usbbog.bdd.repo.CiudadRepository;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500/", methods= {RequestMethod.GET, RequestMethod.POST})
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
			if (ciudadRepository.existsById(ciudad.getId())) {
				return "La ciudad ya se encuentra registrada ";
			} else {
				ciudadRepository.save(ciudad);
				return "Registrada exitosamente";
			}
		} catch (IllegalArgumentException e) {
			return "No se guardo el recibo: " + e.getMessage();
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

	@DeleteMapping("/eliminar")
	public String eliminarCiudad(@RequestBody Ciudad ciudad) {
		try {
			if (ciudadRepository.existsById(ciudad.getId())) {
				ciudadRepository.deleteById(ciudad.getId());
				return "Se ha eliminado correctamente";
			} else {
				return "La ciudad no se encuentra registrada";
			}
		} catch (IllegalArgumentException e) {
			return "No se elimino la ciudad: " + e.getMessage();
		}
	}

	@GetMapping("/buscar")
	public Map<String, Object> buscarCiudadId(Ciudad ciudad) {
		Ciudad var = new Ciudad();
		try {
			if (ciudadRepository.existsById(ciudad.getId())) {
				var = ciudadRepository.getById(ciudad.getId());

				Map<String, Object> json = new HashMap();
				json.put("id", var.getId());
				json.put("nombre", var.getNombre());
				return json;
			} else {
				return null;
			}

		} catch (IllegalArgumentException e) {
			return null;
		}
	}

	@GetMapping("/todos")
	public List<Ciudad> buscarCiudades() {
		List<Ciudad> array = new ArrayList<>();
		try {
			// List<Ciudad> lista = ciudadRepository.findAll();

			array = ciudadRepository.findAll();
			return array;

		} catch (IllegalArgumentException e) {
			return array;
		}
	}

	@PutMapping("/actualizar")
	public String actualizar(@RequestBody Ciudad ciudad) {
		try {
			if (ciudadRepository.existsById(ciudad.getId())) {
				ciudadRepository.deleteById(ciudad.getId());
				ciudadRepository.save(ciudad);

				return "actualizado correctamente";
			} else {
				return "La ciudad no existe";
			}

		} catch (IllegalArgumentException e) {
			return "Ha ocurrido un error" + e.getMessage();
		}
	}

}
