package org.serogr.apirestful.tareas2.service;

import org.serogr.apirestful.tareas2.entities.Tarea;
import org.serogr.apirestful.tareas2.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaService implements TareaServiceI{
    @Autowired
    TareaRepository tareaRepository;
    @Override
    public List<Tarea> listTasks() {
        return tareaRepository.findAll();
    }

    @Override
    public Tarea searchTask(Long id) {
        return tareaRepository.findById(id).orElse(null);
    }

    @Override
    public Tarea createTask(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    @Override
    public Tarea updateTask(Long id, Tarea tarea) {

        return tareaRepository.save(tarea);
    }

    @Override
    public void deleteTask(Long id) {
        tareaRepository.deleteById(id);
    }
}
