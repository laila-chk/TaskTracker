package com.lchokri.tasks.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lchokri.tasks.domain.dto.TaskListDto;
import com.lchokri.tasks.domain.entities.TaskList;
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

  //from the request, we'll take 'taskListDto', use it to create taskList obj and ret taskListDto .
  @PostMapping
  public TaskListDto createTaskList(@RequestBody TaskListDto taskListDto) {
    TaskList createTaskList = taskListService.createTaskList(taskListMapper.fromDto(taskListDto));
    return taskListMapper.toDto(createTaskList);
  }

}
