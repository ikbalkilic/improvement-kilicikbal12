package de.vignold.vignoldmanagement.controller;

import de.vignold.vignoldmanagement.dto.JobDTO;
import de.vignold.vignoldmanagement.entity.Job;
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

    /*@GetMapping("/all")
    public List<Job> findAll()
    {
        List<Job> jobList=jobService.getAllJob();
        return jobList;
    }*/

    @PostMapping("/save-job")
    public ResponseEntity<?> saveJob(@RequestBody JobDTO jobDTO){
        jobService.jobSaveDTO(jobDTO);
        return new ResponseEntity<>(null,null, HttpStatus.OK);
    }

    @GetMapping("/find-all-job")
    public ResponseEntity<?> findAll()
    {
        List<JobDTO> jobDTOList=jobService.getAllJobDTO();
        return new ResponseEntity<List<JobDTO>>(jobDTOList, HttpStatus.OK);
    }

    @GetMapping("/find-job-by-id/{id}")
    public ResponseEntity<?> findByJob(@PathVariable("id") Long id){
        JobDTO jobDTO=jobService.findJobDTOById(id);
        return new ResponseEntity<JobDTO>(jobDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete-job/{id}")
    public ResponseEntity<?> deleteJobById(@PathVariable("id") Long id){
        jobService.deleteJobById(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping("/update-job/{id}")
    public ResponseEntity<?> updateJobById(@PathVariable("id") Long id){
        Job job=jobService.updateJob(id);
        return new ResponseEntity<Job>(job, HttpStatus.OK);
    }
}
