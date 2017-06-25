package com.realjt.summer.summer.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.realjt.summer.summer.dao.UserDao;
import com.realjt.summer.summer.domain.User;

public class SummerServlet extends HttpServlet
{
	private static final long serialVersionUID = -3903640785697216419L;

	private static final Logger log = LoggerFactory
			.getLogger(SummerServlet.class);

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		response.setCharacterEncoding("UTF-8");

		ApplicationContext applicationContext = WebApplicationContextUtils
				.getWebApplicationContext(getServletContext());

		UserDao userDao = (UserDao) applicationContext.getBean("userDao");

		try
		{
			User user = new User();
			user.setUsername("realjt");

			userDao.add(user);
		}
		catch (Exception e)
		{
			log.error("insert user error", e);
		}

		log.debug("realjt");

		response.getWriter().write("developer");
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
	}

}