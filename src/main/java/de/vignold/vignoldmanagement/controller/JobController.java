package de.vignold.vignoldmanagement.controller;

import de.vignold.vignoldmanagement.dto.JobDTO;
import de.vignold.vignoldmanagement.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/jobs")
public class JobController {

    @Autowired
    JobService jobService;

    @GetMapping("/all")
    public List<JobDTO> findAll()
    {
        //insert your logic here and return it
        return null;
    }

    @GetMapping("/find-job-by-id/{id}")
    public ResponseEntity<?> retrieve(@PathVariable("id") Long id){
        JobDTO jobDTO=jobService.findJobDTOById(id);
        return new ResponseEntity<JobDTO>(jobDTO, HttpStatus.OK);
    }

    @PostMapping("/save-job")
    public ResponseEntity<?> saveJob(@RequestBody JobDTO jobDTO){
        jobService.jobSaveDTO(jobDTO);
        return new ResponseEntity<>(null,null, HttpStatus.OK);
    }
}
