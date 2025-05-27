package com.jhona.spring_postgresql;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

  private final PersonaService servicio;

  public PersonaController(PersonaService servicio) {
    this.servicio = servicio;
  }

  // GET /api/personas
  @GetMapping
  public List<PersonaModel> listar() {
    return servicio.findAll();
  }

  // GET /api/personas/{id}
  @GetMapping("/{id}")
  public PersonaModel buscar(@PathVariable Long id) {
    return servicio.findById(id);
  }

  // POST /api/personas (JSON {"nombre":"Eder"})
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public PersonaModel crear(@RequestBody PersonaModel p) {
    return servicio.save(p);
  }

  // PUT /api/personas/{id}
  @PutMapping("/{id}")
  public PersonaModel actualizar(@PathVariable Long id, @RequestBody PersonaModel p) {
    return servicio.update(id, p);
  }

  // DELETE /api/personas/{id}
  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void eliminar(@PathVariable Long id) {
    servicio.delete(id);
  }
}