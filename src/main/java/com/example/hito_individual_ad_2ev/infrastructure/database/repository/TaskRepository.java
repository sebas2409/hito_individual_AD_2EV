package com.example.hito_individual_ad_2ev.infrastructure.database.repository;

import com.example.hito_individual_ad_2ev.infrastructure.database.entitites.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {


    @Modifying
    @Query("UPDATE Task t SET t.status = :status WHERE t.id = :id")
    void changeTaskStatus(@Param("id") Integer id, @Param("status") String status);
}
