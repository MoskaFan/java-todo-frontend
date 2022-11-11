package com.example.backend;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TodoRepo {
    private List<TodoElement> todoElements;


    public TodoRepo(List<TodoElement> todoElements) {
        this.todoElements = todoElements;
    }

    public TodoElement addTodo(TodoElement todoElement){
        todoElements.add(todoElement);
        return todoElement;
    }
    public List<TodoElement> getAllTodos(){
        return todoElements;
    }



    public TodoElement getTodo(int id) {
        for (TodoElement element: todoElements) {
            if(element.getId()==id){
                return element;
            }
        }
        return null;
    }
//    public TodoElement editTodo(TodoElement todoElement, int id) {
//        for (TodoElement element: todoElements) {
//            if(!todoElements.get(id).equals(todoElement)){
//                //todoElements.get(id).description = todoElement.description;
//                //todoElements.get(id).status = todoElement.status;
//                todoElements.set(id,todoElement);
//                return todoElement;
//            }
//        }
//
//        return null;
//    }
    public TodoElement changeStatus(int id) {
        
        for (TodoElement element: todoElements) {
            element.stat
        if(!todoElements.get(id).equals(todoElement)){
                //todoElements.get(id).description = todoElement.description;
                //todoElements.get(id).status = todoElement.status;
                todoElements.set(id,todoElement);
                return todoElement;
            }
        }

        return null;
    }
    public String readTodo(int id) {
        for (TodoElement element: todoElements) {
            if(element.getId()==id){

                return element.description;
            }
        }
        return null;
    }

    public boolean deleteTodo(int id) {
        for (TodoElement element: todoElements) {
            if(element.getId()==id){

                return todoElements.remove(element);
            }
        }
        return false;
    }
}
