package de.vignold.vignoldmanagement.service;

import de.vignold.vignoldmanagement.dto.JobDTO;
import de.vignold.vignoldmanagement.entity.Job;

public interface JobService {

    void jobSave(Job job);
    void jobSaveDTO(JobDTO jobDTO);

    public Job findJobById(Long id);
    public JobDTO findJobDTOById(Long id);
}
