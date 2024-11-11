package com.getyourguide.demo.service;

import com.getyourguide.demo.dto.ActivityResponse;
import com.getyourguide.demo.repo.ActivityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityService {

    private final ActivityRepository activityRepository;

    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    // TODO: Add pagination to the response, For the lacking time, I could not add pagination to the response.
    public List<ActivityResponse> searchActivities(String title) {
        return activityRepository.searchByTitle(title).stream()
                .map(ActivityResponse::toActivityResponse)
                .collect(Collectors.toList());
    }

}
