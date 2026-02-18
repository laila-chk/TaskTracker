package com.lchokri.tasks.mappers;

import com.lchokri.tasks.domain.dto.TaskDto;
import com.lchokri.tasks.domain.entities.Task;

public interface TaskMapper {
  Task fromDto(TaskDto taskDto);
  TaskDto toDto(Task task);
}
