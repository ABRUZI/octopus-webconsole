package org.rhino.octopus.webconsole.service;

import java.util.List;

import javax.annotation.Resource;

import org.rhino.octopus.webconsole.dao.OptionDAO;
import org.rhino.octopus.webconsole.model.CodeTableDTO;
import org.springframework.stereotype.Service;

@Service("optionService")
public class OptionService {
	
	@Resource(name="optionDAO")
	private OptionDAO optionDAO;

	public List<CodeTableDTO> queryFlowStatusList() {
		return this.optionDAO.queryFlowStatusList();
	}

}
