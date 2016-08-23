package org.rhino.octopus.webconsole.dao;

import java.util.ArrayList;
import java.util.List;

import org.rhino.octopus.webconsole.model.FlowDTO;
import org.rhino.octopus.webconsole.model.PageInfo;
import org.springframework.stereotype.Repository;

@Repository("flowDAO")
public class FlowDAO {

	public List<FlowDTO> queryFlowList(FlowDTO query, PageInfo pageInfo){
		List<FlowDTO> list =  new ArrayList<FlowDTO>();
		
		FlowDTO flow = new FlowDTO();
		flow.setId("1");
		flow.setName("测试");
		list.add(flow);
		return list;
	}
	
	public int queryFlowListSize(FlowDTO query){
		return 1;
	}
	
	public FlowDTO queryFlowById(String id){
		return null;
	}

	public void saveNewFlow(FlowDTO flow) {
		
	}

	public void updateFlow(FlowDTO flow) {
		
	}
}
