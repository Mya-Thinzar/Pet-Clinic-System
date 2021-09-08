package com.pet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.pet.util.ValidationUtil;

@WebFilter(urlPatterns="/loginPath")
public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("DO FILTER");
		String strId=req.getParameter("frmId");
		String strPassword=req.getParameter("frmPassword");
		
		String error=ValidationUtil.checkLoginUser(strId,strPassword);
		if(error==null || !error.isEmpty()){
			//error not go servlet
			req.setAttribute("error", error);
			RequestDispatcher rd=req.getRequestDispatcher("loginPath");
			rd.forward(req, resp);
		}else{
			chain.doFilter(req, resp);
		}
		
	}

}
