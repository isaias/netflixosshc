package br.com.strategiatec.netflixosshc.hystrix.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.netflix.config.ConfigurationManager;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

public class HystrixRequestFilter implements Filter {

	public HystrixRequestFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
			ServletException {
		HystrixRequestContext context = HystrixRequestContext.initializeContext();
		try {
			chain.doFilter(request, response);
		} finally {
			context.shutdown();
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		ConfigurationManager.getConfigInstance().setProperty("hystrix.threadpool.default.coreSize", Integer.valueOf(8));
		ConfigurationManager.getConfigInstance().setProperty(
				"hystrix.command.GetUserInformationCommand.execution.isolation.thread.timeoutInMilliseconds", 1000);
		ConfigurationManager.getConfigInstance().setProperty(
				"hystrix.command.GetProductAmountCommand.execution.isolation.thread.timeoutInMilliseconds", 2000);
		ConfigurationManager.getConfigInstance().setProperty(
				"hystrix.command.GetProductCommand.execution.isolation.thread.timeoutInMilliseconds", 500);
	}
}
