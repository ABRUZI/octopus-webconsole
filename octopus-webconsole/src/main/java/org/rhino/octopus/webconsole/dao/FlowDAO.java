package org.rhino.octopus.webconsole.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.rhino.octopus.webconsole.model.FlowDTO;
import org.rhino.octopus.webconsole.model.PageInfo;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

@Repository("flowDAO")
public class FlowDAO {
	
	@Resource(name="sqlMapClientTemplate")
	private SqlMapClientTemplate sqlMapClientTemplate;

	public List<FlowDTO> queryFlowList(FlowDTO query, PageInfo pageInfo){
		List<FlowDTO> list =  new ArrayList<FlowDTO>();
		
		FlowDTO flow = new FlowDTO();
		flow.setId("1");
		flow.setName("测试");
		list.add(flow);
		return list;
		
		//return (List<FlowDTO>)this.sqlMapClientTemplate.queryForList("octopus.webconsole.flow.queryFlowList", query, pageInfo.getStart(), pageInfo.getPageNum());
	}
	
	public int queryFlowListSize(FlowDTO query){
		return (Integer)this.sqlMapClientTemplate.queryForObject("octopus.webconsole.flow.queryFlowListSize", query);
	}
	
	public FlowDTO queryFlowById(String id){
		return null;
	}

	public void saveNewFlow(FlowDTO flow) {
		
	}

	public void updateFlow(FlowDTO flow) {
		
	}
}
