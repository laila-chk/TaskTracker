package com.lchokri.tasks.services.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lchokri.tasks.domain.entities.TaskList;
import com.lchokri.tasks.repositories.TaskListRepository;
import com.lchokri.tasks.services.TaskListService;

@Service
public class TaskListServiceImpl implements TaskListService {
  
  private TaskListRepository taskListRepository;

  TaskListServiceImpl(TaskListRepository taskListRepository){
    this.taskListRepository = taskListRepository;
  }

  @Override
  public List<TaskList> listTaskList() {
    return taskListRepository.findAll();
  }


  @Override
  public TaskList createTaskList(TaskList taskList){
    //making sure that the task list is new!
    if (taskList.getId() != null)
      throw new IllegalArgumentException("this task list already have an id!");
    //making sure args are valid:
    if(taskList.getTitle() == null || taskList.getTitle().isBlank())
      throw new IllegalArgumentException("Task list title is mandatory!");

    LocalDateTime now = LocalDateTime.now();

    return taskListRepository.save(new TaskList(
      null,
      taskList.getTitle(),
      taskList.getDescription(),
      null,
      now,
      now
    ));
  }



}
