package de.vignold.vignoldmanagement.service;

import de.vignold.vignoldmanagement.converter.JobToJobDTO;
import de.vignold.vignoldmanagement.dao.JobRepository;
import de.vignold.vignoldmanagement.dto.JobDTO;
import de.vignold.vignoldmanagement.entity.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    JobRepository jobRepository;


    public void jobSave(Job job){
        jobRepository.save(job);
    }
    public void jobSaveDTO(JobDTO jobDTO){
        jobSave(JobToJobDTO.convertToJob(jobDTO));
    }

    public Job findJobById(Long id){
        return jobRepository.findAllById(id);
    }
    public JobDTO findJobDTOById(Long id){
        return JobToJobDTO.convertToJobDto(findJobById(id));
    }

    public void deleteJobById(Long id){
        jobRepository.deleteById(id);
    }

    public List<Job> getAllJob(){
        return jobRepository.findAll();
    }
    public List<JobDTO> getAllJobDTO(){
        return JobToJobDTO.convertToJobDTOList(getAllJob());
    }

    public Job updateJob(Long id){
        Job updateJob=jobRepository.findAllById(id);
        if (updateJob!=null){
            updateJob.setDeleted(Boolean.TRUE);
        }
        return jobRepository.save(updateJob);
    }


}
