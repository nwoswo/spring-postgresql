package com.jhona.spring_postgresql;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PersonaService {

  private final PersonaRepository repo;

  public PersonaService(PersonaRepository repo) {
    this.repo = repo;
  }

  public List<PersonaModel> findAll() {
    return repo.findAll();
  }

  public PersonaModel findById(Long id) {
    return repo.findById(id).orElseThrow();
  }

  public PersonaModel save(PersonaModel p) {
    return repo.save(p);
  }

  public PersonaModel update(Long id, PersonaModel p) {
    PersonaModel actual = findById(id);
    actual.setNombre(p.getNombre());
    return repo.save(actual);
  }

  public void delete(Long id) {
    repo.deleteById(id);
  }
}