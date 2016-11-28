package org.rhino.octopus.webconsole.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class HttpWriter {
	
	public static void writeJSON(HttpServletResponse resp, String json){
		try {
			resp.setCharacterEncoding("UTF-8");
			PrintWriter writer  = resp.getWriter();
			writer.write(json);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
