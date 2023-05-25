package com.example.todo.controller;

import com.example.todo.model.NewTodoRequest;
import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class TodoController {
    private final TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    @PostMapping
    public void addTodo(@RequestBody NewTodoRequest request) {
        Todo newTodo = new Todo();
        newTodo.setTitle(request.title());
        newTodo.setDescription(request.description());
        newTodo.setStatus(request.status());

        todoRepository.save(newTodo);
    }

    @DeleteMapping("todo/{id}")
    public void deleteTodo(@PathVariable Integer id) {
        todoRepository.deleteById(id);
    }

    @PutMapping("todo/{id}")
    public void updateTodo(@PathVariable Integer id, @RequestBody NewTodoRequest request) {
        Todo initialItem = todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo Item is not found"));
        initialItem.setTitle(request.title());
        initialItem.setDescription(request.description());
        initialItem.setStatus(request.status());

        todoRepository.save(initialItem);
    }
}
