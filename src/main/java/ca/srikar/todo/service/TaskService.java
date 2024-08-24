package ca.srikar.todo.service;

import ca.srikar.todo.model.Task;
import ca.srikar.todo.model.TaskStatus;
import ca.srikar.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(Task task) {
        task.setCreatedDate(LocalDateTime.now());
        task.setStatus(TaskStatus.PENDING);
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public Task updateTask(Task task) {
        task.setUpdatedDate(LocalDateTime.now());
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public void markTaskAsCompleted(Long id) {
        Task task = getTaskById(id);
        task.setStatus(TaskStatus.COMPLETED);
        taskRepository.save(task);
    }
}
