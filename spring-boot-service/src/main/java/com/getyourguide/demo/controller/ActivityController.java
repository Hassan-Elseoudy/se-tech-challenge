package com.getyourguide.demo.controller;

import com.getyourguide.demo.dto.ActivityResponse;
import com.getyourguide.demo.service.ActivityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ActivityController {

    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<ActivityResponse>> searchActivities(@RequestParam String title) {
        return ResponseEntity.ok(activityService.searchActivities(title));
    }
}
