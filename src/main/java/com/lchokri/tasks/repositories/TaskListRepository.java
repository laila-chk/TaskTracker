package com.lchokri.tasks.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lchokri.tasks.domain.entities.TaskList;

@Repository
public interface TaskListRepository extends JpaRepository<TaskList, UUID> {
  //that's it bc all the methods we gon need are extended from JpaRepository ;)
}
