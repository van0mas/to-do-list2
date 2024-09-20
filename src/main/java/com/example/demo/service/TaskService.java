package com.example.demo.service;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {


   private final TaskRepository repository;

    @Autowired
    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Task saveTask(Task taskModel) {
        return repository.save(taskModel);
    }

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public List<Task> findTasksByCompleted() {
        return repository.findByCompleted(true);
    }

    public Task getTaskById( long id) {
        return repository.findById(id).orElse(null);
    }

    public Task updateTask(long id, Task taskModel) {
        Task task = repository.findById(id).orElseThrow();

        task.setTitle(taskModel.getTitle());
        task.setDescription(taskModel.getDescription());
        task.setCompleted(taskModel.isCompleted());

        return repository.save(task);
    }

    public void deleteTask(long id) {
        repository.deleteById(id);
    }
}

