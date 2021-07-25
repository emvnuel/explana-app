package io.github.emvnuel.explanaapp.controller;

import io.github.emvnuel.explanaapp.controller.dto.NamedResponse;
import io.github.emvnuel.explanaapp.model.Job;
import io.github.emvnuel.explanaapp.model.JobLevel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @GetMapping
    public ResponseEntity<List<NamedResponse>> findJobs() {
        return ResponseEntity.ok(
                Arrays.asList(Job.values()).stream()
                        .map(job -> new NamedResponse(job.name(), job.getDescription()))
                        .collect(Collectors.toList())
        );
    }

    @GetMapping("/levels")
    public ResponseEntity<List<NamedResponse>> findJobLevels() {
        return ResponseEntity.ok(
                Arrays.asList(JobLevel.values()).stream()
                        .map(job -> new NamedResponse(job.name(), job.getDescription()))
                        .collect(Collectors.toList())
        );
    }

}
