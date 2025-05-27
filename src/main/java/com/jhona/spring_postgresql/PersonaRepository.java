package com.jhona.spring_postgresql;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<PersonaModel, Long> {
}