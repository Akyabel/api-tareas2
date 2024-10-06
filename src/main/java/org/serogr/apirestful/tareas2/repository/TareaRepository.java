package org.serogr.apirestful.tareas2.repository;

import org.serogr.apirestful.tareas2.entities.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {
}
