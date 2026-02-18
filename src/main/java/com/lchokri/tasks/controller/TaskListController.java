package com.lchokri.tasks.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lchokri.tasks.domain.dto.TaskListDto;
import com.lchokri.tasks.mappers.TaskListMapper;
import com.lchokri.tasks.services.TaskListService;

@RestController
@RequestMapping(path = "/api/task-lists")
public class TaskListController {

  private final TaskListService taskListService;
  private final TaskListMapper taskListMapper;

  TaskListController(TaskListService taskListService, TaskListMapper taskListMapper){
    this.taskListService = taskListService;
    this.taskListMapper = taskListMapper;
  }

  @GetMapping
  public List<TaskListDto> listTaskLists() {
    return taskListService.listTaskList()
    .stream()
    .map(taskListMapper::toDto)
    .toList();
  }
  
}
