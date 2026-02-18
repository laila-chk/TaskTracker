package com.lchokri.tasks.domain.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.lchokri.tasks.domain.entities.TaskPriority;
import com.lchokri.tasks.domain.entities.TaskStatus;

//so.. the reason why we're using a record class, is that it is immutable
//so we guarantee that the data isn't going to be modified
//We also don't need to declare getters since they'll be auto-gen.
public record TaskDto (
  UUID id,
  String title,
  String description,
  LocalDateTime dueDate,
  TaskStatus status,
  TaskPriority priority
) {}
