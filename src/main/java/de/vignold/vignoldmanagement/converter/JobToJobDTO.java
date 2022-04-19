package de.vignold.vignoldmanagement.converter;

import de.vignold.vignoldmanagement.dto.JobDTO;
import de.vignold.vignoldmanagement.entity.Job;
import de.vignold.vignoldmanagement.entity.state.State;


import java.util.ArrayList;
import java.util.List;

public class JobToJobDTO {
    public static Job convertToJob(JobDTO jobDTO){
        Job job = new Job();
        //BeanUtils.copyProperties();

        if (jobDTO.getId()!=null) {
            job.setId(jobDTO.getId());
        }
        job.setDescription(jobDTO.getDescription());
        job.setDeleted(jobDTO.getDeleted());
        job.setState(State.RUNNING);
        /*job.setCreatedDate(jobDTO.getCreatedDate());
        job.setUpdatedDate(jobDTO.getUpdatedDate());*/
       // job.setOperatorId(1);




        return job;
    }

    public static JobDTO convertToJobDto(Job job){
        JobDTO jobDTO = new JobDTO();
       // BeanUtils.copyProperties(jobDTO,job);

        if (job.getId() != null) {
            jobDTO.setId(job.getId());
        }
        jobDTO.setDescription(job.getDescription());
        jobDTO.setDeleted(job.getDeleted());
        jobDTO.setState(State.RUNNING);
       /* jobDTO.setCreatedDate(job.getCreatedDate());
        jobDTO.setUpdatedDate(job.getUpdatedDate());*/
        //jobDTO.setOperatorId(1);




        return jobDTO;
    }

    public static List<JobDTO> convertToJobDTOList(List<Job> jobList){
        List<JobDTO> jobDTOList = new ArrayList<>();
        for(Job item : jobList){
            jobDTOList.add(convertToJobDto(item));
        }
        return jobDTOList;
    }
}
