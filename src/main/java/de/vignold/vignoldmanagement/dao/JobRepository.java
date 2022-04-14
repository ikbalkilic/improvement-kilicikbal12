package de.vignold.vignoldmanagement.dao;

import de.vignold.vignoldmanagement.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

    Job findAllById(Long id);

}
