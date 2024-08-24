package ca.srikar.todo.controller;

import ca.srikar.todo.model.Task;
import ca.srikar.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public String viewTasks(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        return "task-list";
    }

    @GetMapping("/task/new")
    public String showTaskForm(Model model) {
        model.addAttribute("task", new Task());
        return "task-form";
    }

    @PostMapping("/task")
    public String createTask(@ModelAttribute Task task) {
        taskService.createTask(task);
        return "redirect:/";
    }

    @GetMapping("/task/{id}")
    public String viewTask(@PathVariable Long id, Model model) {
        model.addAttribute("task", taskService.getTaskById(id));
        return "task-details";
    }

    @GetMapping("/task/{id}/edit")
    public String editTask(@PathVariable Long id, Model model) {
        model.addAttribute("task", taskService.getTaskById(id));
        return "task-form";
    }

    @PostMapping("/task/{id}/delete")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/";
    }

    @PostMapping("/task/{id}/complete")
    public String markTaskAsCompleted(@PathVariable Long id) {
        taskService.markTaskAsCompleted(id);
        return "redirect:/";
    }
}
