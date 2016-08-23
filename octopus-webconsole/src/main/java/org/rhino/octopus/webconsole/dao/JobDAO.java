package org.rhino.octopus.webconsole.dao;

import java.util.List;

import org.rhino.octopus.base.model.job.JobProperties;
import org.springframework.stereotype.Repository;

@Repository("jobDAO")
public class JobDAO {

	
	public void saveNewJobs(List<JobProperties> jobList){
		
	}
	
	public void deleteJobsByFlowId(String flowId){
		
	}
}
