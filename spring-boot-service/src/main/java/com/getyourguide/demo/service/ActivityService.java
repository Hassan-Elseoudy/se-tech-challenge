package com.getyourguide.demo.service;

import com.getyourguide.demo.entity.Activity;
import com.getyourguide.demo.repo.ActivityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {

    private final ActivityRepository activityRepository;

    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public List<Activity> searchActivitiesByTitle(String title) {
        return activityRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }
}
