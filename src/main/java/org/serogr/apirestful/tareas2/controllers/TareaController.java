package org.serogr.apirestful.tareas2.controllers;

import org.serogr.apirestful.tareas2.entities.Tarea;
import org.serogr.apirestful.tareas2.service.TareaServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-tareas")
public class TareaController {
    // Se hace la inyección de dependencias.
    @Autowired
    TareaServiceI tareaServiceI;

    @GetMapping("/tarea")
    public List<Tarea> listTasks(){
        return tareaServiceI.listTasks();
    }

    @GetMapping("/tarea/{id}")
    public ResponseEntity<Tarea> searchTask(@PathVariable Long id){
        Tarea tarea = tareaServiceI.searchTask(id);
        return ResponseEntity.ok(tarea);
    }
    @PostMapping("/tarea")
    public ResponseEntity<Tarea> createTask(@RequestBody Tarea tarea){
        Tarea createdTask = tareaServiceI.createTask(tarea);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }

    @PutMapping("/tarea/{id}")
    public ResponseEntity<Tarea> updateTask(@PathVariable Long id, @RequestBody Tarea tarea){
        Tarea tareaAModificar = tareaServiceI.searchTask(id);
        if (tareaAModificar == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        tareaAModificar.setEstado(tarea.getEstado());
        tareaAModificar.setTitulo(tarea.getTitulo());
        tareaAModificar.setDescripcion(tarea.getDescripcion());
        Tarea updatedTask = tareaServiceI.updateTask(id, tareaAModificar);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/tarea/{id}")
    public ResponseEntity<Tarea> deleteTask(@PathVariable Long id){
        tareaServiceI.deleteTask(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
