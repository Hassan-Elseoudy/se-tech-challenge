package com.getyourguide.demo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.getyourguide.demo.entity.Activity;
import com.getyourguide.demo.service.ActivityService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ActivityController {

    private final ActivityService activityService;
    private ResourceLoader resourceLoader;

    public ActivityController(ActivityService activityService, ResourceLoader resourceLoader) {
        this.activityService = activityService;
        this.resourceLoader = resourceLoader;
    }

    @GetMapping("/debug")
    public void debug(@RequestParam(name = "title", required = false, defaultValue = "NONE") String title, Model model) {
        try {
            model.addAttribute("title", title);
            //create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();
            //read JSON file and convert to a list of activities
            var fileInputStream  = new ClassPathResource("static/activities.json").getInputStream();
            var activities = objectMapper.readValue(fileInputStream, new TypeReference<List<Activity>>() {
            });
            model.addAttribute("activities", activities);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/activities")
    public List<Activity> getAllActivities() {
        return activityService.getAllActivities();
    }

    @GetMapping("/search")
    public List<Activity> searchActivities(@RequestParam String title) {
        return activityService.searchActivities(title);
    }
}
