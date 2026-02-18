
package com.lchokri.tasks.mappers.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.lchokri.tasks.domain.dto.TaskListDto;
import com.lchokri.tasks.domain.entities.Task;
import com.lchokri.tasks.domain.entities.TaskList;
import com.lchokri.tasks.domain.entities.TaskStatus;
import com.lchokri.tasks.mappers.TaskListMapper;
import com.lchokri.tasks.mappers.TaskMapper;

@Component
public class TaskListMapperImpl implements TaskListMapper{
  private final TaskMapper taskMapper;

  public TaskListMapperImpl(TaskMapper taskMapper) {
    this.taskMapper = taskMapper;
  }

  private Double calculateTaskListProgress(List<Task> tasks) {
    //we need to calc the finished tasks out of the total
    if (tasks == null) return null;
    double closedTasks = tasks.stream().filter(task -> TaskStatus.CLOSED == task.getStatus()).count();

    return closedTasks / tasks.size();
  }

  @Override
  public TaskList fromDto(TaskListDto taskListDto){
    return new TaskList(
      taskListDto.id(),
      taskListDto.title(),
      taskListDto.description(),
      Optional.ofNullable(taskListDto.tasks())
      .map(tasks -> tasks.stream()
        .map(taskMapper::fromDto)
        .toList()
      ).orElse(null),
      null,
      null
    );
  }

  @Override
  public TaskListDto toDto(TaskList taskList){
    return new TaskListDto(taskList.getId(), taskList.getTitle(), taskList.getDescription(),
      Optional.ofNullable(taskList.getTasks())
      .map(List::size).orElse(0),
      calculateTaskListProgress(taskList.getTasks()),
      Optional.ofNullable(taskList.getTasks())
      .map(tasks -> tasks.stream().map(taskMapper::toDto).toList()).orElse(null)
    );
  }

}
