package ca.srikar.todo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ca.srikar.todo.model.Task;
import ca.srikar.todo.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TodoApplicationTests {

	@Autowired
	private TaskService taskService;

	@Test
	public void testCreateTask() {
		Task task = new Task("Test Task", "This is a test task.");
		Task savedTask = taskService.createTask(task);
		assertThat(savedTask.getId()).isNotNull();
	}

	// Additional tests for getAllTasks, getTaskById, updateTask, deleteTask, etc.
}
