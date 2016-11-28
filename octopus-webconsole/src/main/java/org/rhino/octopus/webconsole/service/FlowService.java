package org.rhino.octopus.webconsole.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.rhino.octopus.base.model.job.JobProperties;
import org.rhino.octopus.base.model.line.Line;
import org.rhino.octopus.webconsole.dao.FlowDAO;
import org.rhino.octopus.webconsole.model.CodeTableDTO;
import org.rhino.octopus.webconsole.model.FlowDTO;
import org.rhino.octopus.webconsole.model.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service("flowService")
public class FlowService {

	@Resource(name="flowDAO")
	private FlowDAO flowDAO;
	
	@Resource(name="jobService")
	private JobService jobService;
	
	@Resource(name="lineService")
	private LineService lineService;
	
	public List<FlowDTO> queryFlowList(FlowDTO query, PageInfo pageInfo){
		return this.flowDAO.queryFlowList(query, pageInfo);
	}
	
	public int queryFlowListSize(FlowDTO query){
		return this.flowDAO.queryFlowListSize(query);
	}

	public FlowDTO queryFlowById(String id) {
		return this.flowDAO.queryFlowById(id);
	}

	@Transactional
	public void saveFlow(FlowDTO flow, CodeTableDTO user) {
		if(StringUtils.hasText(flow.getId()) == false){
			this.saveNewFlow(flow, user);
		}else{
			this.updateFlow(flow, user);
		}
	}
	@Transactional
	public void saveNewFlow(FlowDTO flow, CodeTableDTO creator){
		
		String flowId = UUID.randomUUID().toString();
		flow.setId(flowId);
		List<JobProperties> jobList = flow.getJobList();
		for(int i = 0, len = jobList.size(); i < len; i++){
			JobProperties jobProp = jobList.get(i);
			jobProp.setFlowId(flowId);
			jobProp.setId(UUID.randomUUID().toString());
		}
		
		List<Line> lineList = flow.getLineList();
		for(int i = 0, len = lineList.size(); i < len; i++){
			Line line = lineList.get(i);
			line.setFlowId(flowId);
			line.setId(UUID.randomUUID().toString());
		}
		
		flow.setCreator(creator);
		flow.setCreateTime(new Timestamp(System.currentTimeMillis()));
		
		this.flowDAO.saveNewFlow(flow);
		this.jobService.saveNewJobs(jobList);
		this.lineService.saveNewLines(lineList);
	}
	@Transactional
	public void updateFlow(FlowDTO flow, CodeTableDTO modifier){
		flow.setModifier(modifier);
		flow.setModifyTime(new Timestamp(System.currentTimeMillis()));
		this.flowDAO.updateFlow(flow);
		
		this.jobService.deleteJobsByFlowId(flow.getId());
		this.jobService.saveNewJobs(flow.getJobList());
		
		this.lineService.deleteLinesByFlowId(flow.getId());
		this.lineService.saveNewLines(flow.getLineList());
	}

	@Transactional
	public void submitFlow(String flowId) {
		
	}
	
	@Transactional
	public void repealFlow(String flowId) {
		
	} 
}
