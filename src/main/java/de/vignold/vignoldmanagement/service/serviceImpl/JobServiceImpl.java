package de.vignold.vignoldmanagement.service.serviceImpl;

import de.vignold.vignoldmanagement.converter.JobToJobDTO;
import de.vignold.vignoldmanagement.dao.JobRepository;
import de.vignold.vignoldmanagement.dto.JobDTO;
import de.vignold.vignoldmanagement.entity.Job;
import de.vignold.vignoldmanagement.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobServiceImpl implements JobService {
   @Autowired
    JobRepository jobRepository;

    @Override
    public void jobSave(Job job) {
        jobRepository.save(job);
    }

    @Override
    public void jobSaveDTO(JobDTO jobDTO) {
        jobSave(JobToJobDTO.convertToJob(jobDTO));
    }

    @Override
    public Job findJobById(Long id) {
        return jobRepository.findAllById(id);
    }

    @Override
    public JobDTO findJobDTOById(Long id) {
        return JobToJobDTO.convertToJobDto(findJobById(id));
    }
}
