package com.example.backend;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TodoService {
    private TodoRepo todoRepo;

    public TodoService(TodoRepo todoRepo) {
        this.todoRepo = todoRepo;
    }

//TODO ZUR LISTE HINZUFUEGEN
    public TodoElement addTodo(TodoElement todoElement) {

        return todoRepo.addTodo(todoElement);
    }
//ALLE TODOS ZURUECKBEKOMMEN
    public List<TodoElement> getAllTodos(){
        return todoRepo.getAllTodos();
    }
//    TODO AENDERN
    public TodoElement editTodo(TodoElement todoElement, int id) {
        return todoRepo.editTodo(todoElement, id);
    }
    //TODO DESCRIPTION GUCKEN
    public TodoElement getTodo(int id){
        return todoRepo.getTodo(id);
    }

    public String readTodo(int id) {
        return todoRepo.readTodo(id);
    }

    public boolean deleteTodo(int id) {
        return todoRepo.deleteTodo(id);
    }
}
