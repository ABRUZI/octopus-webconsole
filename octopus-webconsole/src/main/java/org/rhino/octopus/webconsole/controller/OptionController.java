package org.rhino.octopus.webconsole.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.rhino.octopus.webconsole.model.CodeTableDTO;
import org.rhino.octopus.webconsole.model.HttpResult;
import org.rhino.octopus.webconsole.service.OptionService;
import org.rhino.octopus.webconsole.util.HttpWriter;
import org.rhino.octopus.webconsole.util.JsonConvert;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("optionController")
public class OptionController {

	@Resource(name="optionService")
	private OptionService optionService;
	
	@RequestMapping("/queryFlowStatusList.do")
	public void queryFlowStatusList(HttpServletResponse resp){
		
		HttpResult res = new HttpResult();
		try{
			List<CodeTableDTO> statusList = this.optionService.queryFlowStatusList();
			res.setSuccess(true);
			res.setRes(statusList);
			res.setTotal(statusList.size());
		}catch(Exception e){
			e.printStackTrace();
			res.setSuccess(false);
		}
		HttpWriter.writeJSON(resp, JsonConvert.convertObj(res));
	}
}
