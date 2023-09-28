package org.learning.java.springblogricette.repository;

import org.learning.java.springblogricette.model.Ricetta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RicettaRepository extends JpaRepository<Ricetta, Integer> {
}
