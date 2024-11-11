package com.getyourguide.demo.service;

import com.getyourguide.demo.dto.ActivityResponse;
import com.getyourguide.demo.entity.Activity;
import com.getyourguide.demo.repo.ActivityRepository;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.getyourguide.demo.dto.ActivityResponse.toActivityResponse;

@Service
public class ActivityService {

    private final ActivityRepository activityRepository;

    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public List<ActivityResponse> searchActivities(String title) {
        return activityRepository.searchByTitle(title).stream()
                .map(ActivityResponse::toActivityResponse)
                .collect(Collectors.toList());
    }

}
