package com.example.backend;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoController {
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }



    @PostMapping("/todo")
    public TodoElement addTodo(@RequestBody TodoElement todoElement){
        return todoService.addTodo(todoElement);
    }
    @GetMapping("/todo")
    public List<TodoElement> getAllTodos(){
        return todoService.getAllTodos();

    }
    @GetMapping("/todo/{id}")
    public TodoElement getTodo(@RequestBody @PathVariable int id){
        return todoService.getTodo(id);
    }



//    public String readTodo(@RequestBody @PathVariable int id){
//        return todoService.readTodo(id);
//
//    }
    @PutMapping("/todo/{id}")
   public TodoElement editTodo(@RequestBody TodoElement todoElement, @PathVariable int id){
        return todoService.editTodo(todoElement, id);

    }
    @DeleteMapping ("/todo/{id}")
    public boolean deleteTodo(@RequestBody @PathVariable int id){
        return todoService.deleteTodo(id);

    }

}
