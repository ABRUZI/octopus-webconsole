package org.rhino.octopus.webconsole.model;

public class HttpResult {

	private boolean success;
	
	private int total;
	
	private Object res;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Object getRes() {
		return res;
	}

	public void setRes(Object res) {
		this.res = res;
	}
	
}
