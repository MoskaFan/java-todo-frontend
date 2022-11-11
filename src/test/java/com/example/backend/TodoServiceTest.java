package com.example.backend;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TodoServiceTest {
    TodoRepo todoRepo = mock(TodoRepo.class);
    TodoService todoService = new TodoService(todoRepo);

    @Test
    void addTodo() {
        //GIVEN

        TodoElement element = new TodoElement("1", "args", "open");
        TodoElement expected = new TodoElement("1", "args", "open");

        //When
        when(todoRepo.addTodo(element)).thenReturn(expected);
        TodoElement result = todoService.addTodo(element);
        //Then

        verify(todoRepo).addTodo(any());
        assertEquals(expected, result);

    }

    @Test
    void getAllTodos() {
        //GIVEN
        TodoElement element1 = new TodoElement("1", "args", "open");
        TodoElement element2 = new TodoElement("2", "xcc", "open");
        List<TodoElement> expected = new ArrayList<>(List.of(new TodoElement("1", "args", "open"),new TodoElement("2", "xcc", "open")));
        //When
        when(todoRepo.addTodo(element1)).thenReturn(element1);
        when(todoRepo.addTodo(element2)).thenReturn(element2);
        List<TodoElement> result = todoService.getAllTodos();
        //Then
        assertEquals(expected, result);
    }

    @Test
    void editTodo() {
        //GIVEN
        //When
        //Then
    }

    @Test
    void getTodo() {
        //GIVEN
        //When
        //Then
    }



    @Test
    void deleteTodo() {
        //GIVEN
        TodoElement element = new TodoElement("1", "args", "open");
        TodoElement actual = new TodoElement("1", "args", "open");
        boolean expected = true;
        //When
        when(todoRepo.addTodo(element)).thenReturn(actual);
        when(todoRepo.deleteTodo(element.getId())).thenReturn(expected);
        boolean result = todoService.deleteTodo(element.getId());
        //Then
        assertEquals(expected, result);
    }
}