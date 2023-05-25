package com.example.todo.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Todo {
    @Id
    @SequenceGenerator(sequenceName = "todo_id_sequence", name = "\"todo_id_sequence\"")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "todo_id_sequence")
    private Integer id;
    private String title;
    private String description;
    private boolean status;

    public Todo() {
    }

    public Todo(Integer id, String title, String description, boolean status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return status == todo.status && Objects.equals(id, todo.id) && Objects.equals(title, todo.title) && Objects.equals(description, todo.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, status);
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
