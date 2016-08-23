package org.rhino.octopus.webconsole.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JsonConfig;

import org.rhino.octopus.base.model.job.JobProperties;
import org.rhino.octopus.base.model.line.Line;
import org.rhino.octopus.webconsole.model.FlowDTO;
import org.rhino.octopus.webconsole.model.HttpResult;
import org.rhino.octopus.webconsole.model.PageInfo;
import org.rhino.octopus.webconsole.service.FlowService;
import org.rhino.octopus.webconsole.util.HttpWriter;
import org.rhino.octopus.webconsole.util.JsonConvert;
import org.rhino.octopus.webconsole.util.PageInfoUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("flowController")
public class FlowController {

	private static final String PATH = "page/index.jsp";
	
	@Resource(name="flowService")
	private FlowService flowService;
	
	
	@RequestMapping("/enter.do")
	public ModelAndView enter(HttpServletRequest req, HttpServletResponse resp){
		ModelAndView view  = new ModelAndView(PATH);
		return view;
	}
	
	/**
	 * 查询Flow列表
	 * @param req
	 * @param resp
	 * @param query
	 */
	@RequestMapping("/queryFlowList.do")
	public void queryFlowList(HttpServletRequest req, HttpServletResponse resp, String params){
		HttpResult res = new HttpResult();
		try{
			FlowDTO query = (FlowDTO)JsonConvert.convertJson(params, this.getFlowConfig());
			PageInfo pageInfo = PageInfoUtil.getPageInfo(req);
			List<FlowDTO> flowList = this.flowService.queryFlowList(query, pageInfo);
			int size = this.flowService.queryFlowListSize(query);
			res.setSuccess(true);
			res.setTotal(size);
			res.setRes(flowList);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		HttpWriter.writeJSON(resp, JsonConvert.convertObj(res));
	}
	
	/**
	 * 根据ID查询Flow信息
	 * @param req
	 * @param resp
	 * @param id
	 */
	@RequestMapping("/queryFlowById.do")
	public void queryFlowById(HttpServletRequest req, HttpServletResponse resp, String id){
		
		HttpResult res = new HttpResult();
		try{
			FlowDTO flow = this.flowService.queryFlowById(id);
			res.setSuccess(true);
			res.setRes(flow);
		}catch(Exception e){
			e.printStackTrace();
			res.setSuccess(false);
		}
		
		HttpWriter.writeJSON(resp, JsonConvert.convertObj(res));
	}
	
	/**
	 * 保存Flow
	 * @param req
	 * @param resp
	 * @param flowStr
	 */
	@RequestMapping("/saveFlow.do")
	public void saveFlow(HttpServletRequest req, HttpServletResponse resp, String flowStr){
		HttpResult res = new HttpResult();
		try{
			JsonConfig config = this.getFlowConfig();
			FlowDTO flow = (FlowDTO)JsonConvert.convertJson(flowStr, config);
			this.flowService.saveFlow(flow, null);
			res.setSuccess(true);
		}catch(Exception e){
			e.printStackTrace();
			res.setSuccess(false);
		}
		
		HttpWriter.writeJSON(resp, JsonConvert.convertObj(res));
	}
	
	/**
	 * 提交Flow
	 * @param req
	 * @param resp
	 * @param flowId
	 */
	@RequestMapping("/submitFlow.do")
	public void submitFlow(HttpServletRequest req, HttpServletResponse resp, String flowId){
		HttpResult res = new HttpResult();
		try{
			this.flowService.submitFlow(flowId);
			res.setSuccess(true);
		}catch(Exception e){
			e.printStackTrace();
			res.setSuccess(false);
		}
		HttpWriter.writeJSON(resp, JsonConvert.convertObj(res));
	}
	
	/**
	 * 撤销Flow
	 * @param req
	 * @param resp
	 * @param flowId
	 */
	@RequestMapping("/repealFlow.do")
	public void repealFlow(HttpServletRequest req, HttpServletResponse resp, String flowId){
		HttpResult res = new HttpResult();
		try{
			this.flowService.repealFlow(flowId);
			res.setSuccess(true);
		}catch(Exception e){
			e.printStackTrace();
			res.setSuccess(false);
		}
		HttpWriter.writeJSON(resp, JsonConvert.convertObj(res));
	}
	
	/**
	 * 模拟运行Flow
	 * @param req
	 * @param resp
	 * @param flowId
	 */
	@RequestMapping("/simulateFlow.do")
	public void simulateFlow(HttpServletRequest req, HttpServletResponse resp, String flowId, String param){
		
	}
	
	
	private JsonConfig getFlowConfig(){
		JsonConfig config = new JsonConfig();
		Map<String, Class<?>> classMap = new HashMap<String, Class<?>>();
		classMap.put("jobList", JobProperties.class);
		classMap.put("lineList", Line.class);
		config.setClassMap(classMap);
		config.setRootClass(FlowDTO.class);
		return config;
	}
}
