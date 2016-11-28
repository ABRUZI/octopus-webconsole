package org.rhino.octopus.webconsole.service;

import java.util.List;

import javax.annotation.Resource;

import org.rhino.octopus.base.model.job.JobProperties;
import org.rhino.octopus.webconsole.dao.JobDAO;
import org.springframework.stereotype.Service;

@Service("jobService")
public class JobService {

	@Resource(name="jobDAO")
	private JobDAO jobDAO;
	
	public void saveNewJobs(List<JobProperties> jobList){
		this.jobDAO.saveNewJobs(jobList);
	}
	
	public void deleteJobsByFlowId(String flowId){
		this.deleteJobsByFlowId(flowId);
	}
}
