package com.getyourguide.demo.repo;

import com.getyourguide.demo.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

    @Query(value = "SELECT * FROM Activity a WHERE to_tsvector('english', a.title) @@ plainto_tsquery('english', :title)", nativeQuery = true)
    List<Activity> searchByTitle(String title);
}

