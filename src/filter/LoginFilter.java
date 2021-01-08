package filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.User;

public class LoginFilter implements Filter {


    public LoginFilter() {}


	public void destroy() {}


	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		System.out.println("in LoginFilter(), time:"+ new Date().getTime());
		// check with request body
		try{
			//getWriter :Returns a PrintWriter object that can send character text to the client.
			ObjectMapper mapper = new ObjectMapper();
			User user = mapper.readValue(servletRequest.getInputStream(), User.class);
		
			if(user.getUsername().equals("admin") && user.getPassword().equals("123")) {
				System.out.println("user object: " + user);
				chain.doFilter(servletRequest, servletResponse);
			}
			else {
				HttpServletResponse response = (HttpServletResponse) servletResponse;
				response.setStatus(HttpServletResponse.SC_FORBIDDEN);
				response.getWriter().write("bad user credentials passed!");
				response.getWriter().flush();
			}
		}catch(Exception e) {
			HttpServletResponse response = (HttpServletResponse) servletResponse;
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			response.getWriter().write("Unable to process request!");
			response.getWriter().flush();
		}
		
		
		/*
		 * Checking with header
		 * 
		String headerValue = httpServletRequest.getHeader("Authorization");
		
		if(headerValue==null || headerValue.equals("")){
			pw.print("<h3>Invalid user credentials!</h3>");
			HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
			httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN); //403
		}else{
			chain.doFilter(servletRequest, servletResponse);
		}
		*/
		
		/*
		 * Checking with http form parameters
		 * 
		String uname = servletRequest.getParameter("username");
		String pass = servletRequest.getParameter("password");
		
		if(uname==null || pass==null || uname.equals("") || pass.equals("")){
			//you dont earn enough
			pw.print("<h3>Invalid user credentials!</h3>");
			HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
			httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN); //403
		}
		else{
			//ok go to daughter
			chain.doFilter(servletRequest, servletResponse);
		}*/
	}

	public void init(FilterConfig fConfig) throws ServletException {}

}
