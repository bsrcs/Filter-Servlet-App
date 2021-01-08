package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFilter implements Filter {

    /**
     * Default constructor. 
     */
    public MyFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		//getWriter :Returns a PrintWriter object that can send character text to the client.
		PrintWriter pw = servletResponse.getWriter();
		HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
		
		
		
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

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
