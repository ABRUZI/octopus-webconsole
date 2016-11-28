package org.rhino.octopus.webconsole.dao;

import java.util.List;

import org.rhino.octopus.base.model.line.Line;
import org.springframework.stereotype.Repository;

@Repository("lineDAO")
public class LineDAO {

	public void saveNewLines(List<Line> lineList){
		
	}
	
	public void deleteLinesByFlowId(String flowId){
		
	}
}
