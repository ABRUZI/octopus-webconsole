package org.rhino.octopus.webconsole.model;

import java.sql.Timestamp;

import org.rhino.octopus.base.model.flow.Flow;

/**
 * 流程模型。这个流程只在webconsole平台里做配置设计的时候使用 
 * @author 王铁
 */
public class FlowDTO extends Flow{

	/**
	 * 创建人
	 */
	private CodeTableDTO creator;
	
	/**
	 * 创建时间
	 */
	private Timestamp createTime;
	
	/**
	 * 最终修改人
	 */
	private CodeTableDTO modifier;
	
	/**
	 * 最终修改时间
	 */
	private Timestamp modifyTime;
	
	/**
	 * 状态(01设计中，02使用中)
	 */
	private CodeTableDTO status;
	
	/**
	 * 用户在界面上做设计的时候画出来的模型的JSON字符串
	 */
	private String modelStr;

	public CodeTableDTO getCreator() {
		return creator;
	}

	public void setCreator(CodeTableDTO creator) {
		this.creator = creator;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public CodeTableDTO getModifier() {
		return modifier;
	}

	public void setModifier(CodeTableDTO modifier) {
		this.modifier = modifier;
	}

	public Timestamp getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}

	public CodeTableDTO getStatus() {
		return status;
	}

	public void setStatus(CodeTableDTO status) {
		this.status = status;
	}

	public String getModelStr() {
		return modelStr;
	}

	public void setModelStr(String modelStr) {
		this.modelStr = modelStr;
	}
}
