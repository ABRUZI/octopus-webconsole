package org.rhino.octopus.webconsole.dao;

import java.util.ArrayList;
import java.util.List;

import org.rhino.octopus.webconsole.model.CodeTableDTO;
import org.springframework.stereotype.Repository;

@Repository("optionDAO")
public class OptionDAO {

	
	public List<CodeTableDTO> queryFlowStatusList(){
		
		CodeTableDTO a = new CodeTableDTO();
		a.setCode("01");
		a.setName("设计中");
		
		CodeTableDTO b = new CodeTableDTO();
		b.setCode("02");
		b.setName("使用中");
		List<CodeTableDTO> list = new ArrayList<CodeTableDTO>();
		list.add(a);
		list.add(b);
		return list;
	}
}
