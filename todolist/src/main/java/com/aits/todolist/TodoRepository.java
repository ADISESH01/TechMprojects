package com.aits.todolist;

import org.springframework.data.jpa.repository.JpaRepository;
public interface TodoRepository extends JpaRepository<Todo, Long> {
	Todo findByCompleted(boolean Completed);

}
