package org.rhino.octopus.webconsole.service;

import java.util.List;

import javax.annotation.Resource;

import org.rhino.octopus.base.model.line.Line;
import org.rhino.octopus.webconsole.dao.LineDAO;
import org.springframework.stereotype.Service;

@Service("lineService")
public class LineService {

	@Resource(name="lineDAO")
	private LineDAO lineDAO;
	
	public void saveNewLines(List<Line> lineList){
		this.lineDAO.saveNewLines(lineList);
	}
	
	public void deleteLinesByFlowId(String flowId){
		this.deleteLinesByFlowId(flowId);
	}
}
