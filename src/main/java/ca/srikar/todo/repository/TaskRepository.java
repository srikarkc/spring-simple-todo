package ca.srikar.todo.repository;

import ca.srikar.todo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
    // Custom query methods if needed
}
