package com.lchokri.tasks.services.impl;

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
}
