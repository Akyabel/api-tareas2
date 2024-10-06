package org.serogr.apirestful.tareas2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.serogr.apirestful.tareas2.entities.Tarea;
import org.serogr.apirestful.tareas2.repository.TareaRepository;
import org.serogr.apirestful.tareas2.service.TareaService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

public class TareaSericeTest {

    @InjectMocks
    TareaService tareaService;
    @Mock
    TareaRepository tareaRepository;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testListarTareas(){
        List<Tarea> listaEsperada = new ArrayList<>();
        listaEsperada.add(new Tarea(1L, "Tarea1", "Hacer la tarea 1", 1));
        listaEsperada.add(new Tarea(2L, "Tarea2", "Hacer la tarea 2", 1));

        when(tareaRepository.findAll()).thenReturn(listaEsperada);
        List<Tarea> listaActual = tareaService.listTasks();

        Assertions.assertEquals(listaEsperada.get(0).getTitulo(), listaActual.get(0).getTitulo());
        Assertions.assertEquals(listaEsperada.size(), listaActual.size());
    }

    @Test
    public void testBuscarTareas(){
        Tarea tareaEsperada = new Tarea(1L, "Tarea 1", "Hacer la Tarea 1", 1);

        when(tareaRepository.findById(1L)).thenReturn(Optional.of(tareaEsperada));
        Tarea tareaActual = tareaService.searchTask(1L);

        Assertions.assertEquals(tareaEsperada, tareaActual);
    }

    @Test
    public void testCrearTarea(){
        Tarea tareaACrear = new Tarea(1L, "Tarea 1", "Hacer la Tarea 1", 1);

        when(tareaRepository.save(tareaACrear)).thenReturn(tareaACrear);
        Tarea tareaActualCreada = tareaService.createTask(tareaACrear);

        Assertions.assertEquals(tareaACrear, tareaActualCreada);
    }

    @Test
    public void testActualizarTarea(){
        Tarea tareaAActualizar = new Tarea(1L, "Tarea 1", "Hacer la Tarea 1", 1);

        when(tareaRepository.save(tareaAActualizar)).thenReturn(tareaAActualizar);
        tareaAActualizar.setTitulo("Tarea 1 Modificada");
        Tarea tareaActualActualizada = tareaService.updateTask(1L, tareaAActualizar);

        Assertions.assertEquals("Tarea 1 Modificada", tareaActualActualizada.getTitulo());
    }

    @Test
    public void testEliminarTarea(){
        willDoNothing().given(tareaRepository).deleteById(1L);
        tareaService.deleteTask(1L);
        verify(tareaRepository, times(1)).deleteById(1L);
    }
}
