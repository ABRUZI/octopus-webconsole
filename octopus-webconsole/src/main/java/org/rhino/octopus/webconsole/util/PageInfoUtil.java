package org.rhino.octopus.webconsole.util;

import javax.servlet.http.HttpServletRequest;

import org.rhino.octopus.webconsole.model.PageInfo;

public class PageInfoUtil {

	public static PageInfo getPageInfo(HttpServletRequest req){
		return new PageInfo();
	}
}
