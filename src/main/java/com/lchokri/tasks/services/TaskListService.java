package com.lchokri.tasks.services;

import java.util.List;

import com.lchokri.tasks.domain.entities.TaskList;

public interface TaskListService {
  List<TaskList> listTaskList();
  TaskList createTaskList(TaskList taskList);
}
