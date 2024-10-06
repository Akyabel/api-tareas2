package org.serogr.apirestful.tareas2.service;

import org.serogr.apirestful.tareas2.entities.Tarea;

import java.util.List;

public interface TareaServiceI {
    List<Tarea> listTasks();
    Tarea searchTask(Long id);
    Tarea createTask(Tarea tarea);
    Tarea updateTask(Long id, Tarea tarea);
    void deleteTask(Long id);
}
