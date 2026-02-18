package com.lchokri.tasks.mappers;


import com.lchokri.tasks.domain.dto.TaskListDto;
import com.lchokri.tasks.domain.entities.TaskList;

public interface TaskListMapper {
  TaskList fromDto(TaskListDto taskDtoList);
  TaskListDto toDto(TaskList taskList);
}
