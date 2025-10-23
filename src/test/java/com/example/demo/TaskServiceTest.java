package com.example.demo;


import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import com.example.demo.services.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class TaskServiceTest {


    private TaskRepository taskRepository;
    private TaskService taskService;

    @BeforeEach
    void setUp() {
        taskRepository = Mockito.mock(TaskRepository.class);
        taskService = new TaskService(taskRepository);
    }

    @Test
    void testGetAllTasks() {
        List<Task> mockTasks = Arrays.asList(new Task("Learn Git"), new Task("Learn Spring"));
        when(taskRepository.findAll()).thenReturn(mockTasks);

        List<Task> result = taskService.getAllTasks();
        assertEquals(2, result.size());
        assertEquals("Learn Git", result.get(0).getTitle());
    }

}
