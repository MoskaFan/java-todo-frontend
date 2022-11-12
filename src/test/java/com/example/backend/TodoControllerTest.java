package com.example.backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.web.servlet.function.RequestPredicates.contentType;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext
class TodoControllerTest {
    @Autowired
    MockMvc mvc;
    @Autowired
    TodoRepo todoRepo;
    @Test
    void addTodo() throws Exception{

        TodoElement element = new TodoElement("1","args", "open");
        todoRepo.addTodo(new TodoElement("1","args", "open"));
        mvc.perform(put("http://localhost:8080/api/todo/"+element.getId())

                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                        {"id":"1",
                        "description":"args",
                        "status":"open"
                        }"""))
                        .andExpect(status().isOk())
                        .andExpect(content().json("""
                         {"id": "1",
                         "description": "args",
                         "status": "open"}
                         """));
    }

    @Test
    void getAllTodos() throws Exception{

        TodoElement element1 = new TodoElement("1","args", "open");
        TodoElement element2 = new TodoElement("2","lsss", "open");
        todoRepo.addTodo(new TodoElement("1","args", "open"));
        todoRepo.addTodo(new TodoElement("2","lsss", "open"));
        mvc.perform(get("http://localhost:8080/api/todo/")

                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                        [{"id":"1",
                        "description":"args",
                        "status":"open"
                        },
                        {"id":"2",
                        "description":"lsss",
                        "status":"open"
                        }]
                        """))
                        .andExpect(status().isOk())
                        .andExpect(content().json(
                        """
                        [{"id":"1",
                        "description":"args",
                        "status":"open"
                        },
                        {"id":"2",
                        "description":"lsss",
                        "status":"open"
                        }]
                         """));
    }

    @Test
    void getTodo() throws Exception{

        TodoElement element = new TodoElement("1","args", "open");
        todoRepo.addTodo(element);
        todoRepo.getTodo("1");
        mvc.perform(    MockMvcRequestBuilders
                        .get("http://localhost:8080/api/todo/{id}", 1)
                        .accept(MediaType.APPLICATION_JSON))
                        .andDo(print())
                        .andExpect(status().isOk())
                        .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                        .andExpect(content().json("""
                         {"id": "1",
                         "description": "args",
                         "status": "open"}
                         """));

    }

    @Test
    void editTodo() throws Exception{

        TodoElement element = new TodoElement("1","args", "open");
        todoRepo.addTodo(new TodoElement("1","args", "open"));
        mvc.perform(put("http://localhost:8080/api/todo/"+element.getId())

                .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                        {"id":"1",
                        "description":"args",
                        "status":"doing"
                        }"""))
                        .andExpect(status().isOk())
                        .andExpect(content().json(
                        """
                         {"id":"1",
                         "description":"args",
                         "status":"doing"
                         }"""));
    }

    @Test
    void deleteTodo() throws Exception{

        TodoElement element = new TodoElement("1","args", "open");
        todoRepo.addTodo(new TodoElement("1","args", "open"));
        todoRepo.deleteTodo("1");
        mvc.perform(delete("http://localhost:8080/api/todo/"+element.getId())

                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                        {
                        }"""))
                .andExpect(status().isOk());
    }
}