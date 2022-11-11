package com.example.backend;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class TodoRepo {
    private List<TodoElement> todoElements;


    public TodoRepo(List<TodoElement> todoElements) {
        this.todoElements = todoElements;
    }

    public TodoElement addTodo(TodoElement todoElement){
        this.todoElements.add(todoElement);
        return todoElement;
    }
    public List<TodoElement> getAllTodos(){
        return todoElements;
    }

    public TodoElement getTodo(String id) {
        for (TodoElement element: todoElements) {
            if(element.getId().equals(id)){
                return element;
            }
        }
        return null;
    }
        public TodoElement editTodo(TodoElement todoElement, String id) {
            int number = this.todoElements.indexOf(getTodo(id));
            this.todoElements.set(Integer.parseInt(id)-1, todoElement);
            return todoElement;
        }

    public String readTodo(String id) {
        for (TodoElement element: todoElements) {
            if(element.getId().equals(id)){

                return element.description;
            }
        }
        return null;
    }

    public boolean deleteTodo(String id) {
        for (TodoElement element: todoElements) {
            if(element.getId().equals(id)){

                return todoElements.remove(element);
            }
        }
        return false;
    }
}
