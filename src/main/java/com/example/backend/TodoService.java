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
        int id = getAllTodos().size()+1;
        TodoElement addId = new TodoElement(String.valueOf(id), todoElement.getDescription(), todoElement.getStatus());
        return todoRepo.addTodo(addId);
    }
//ALLE TODOS ZURUECKBEKOMMEN
    public List<TodoElement> getAllTodos(){
        return todoRepo.getAllTodos();
    }
//    TODO AENDERN
    public TodoElement editTodo(TodoElement todoElement, String id) {
        return todoRepo.editTodo(todoElement, id);
    }

    public TodoElement getTodo(String id){
        return todoRepo.getTodo(id);
    }

    public String readTodo(String id) {
        return todoRepo.readTodo(id);
    }

    public boolean deleteTodo(String id) {
        return todoRepo.deleteTodo(id);
    }
}
