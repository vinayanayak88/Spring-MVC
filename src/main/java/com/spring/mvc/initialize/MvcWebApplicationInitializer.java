/**
 * 
 */
package com.spring.mvc.initialize;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.spring.mvc.config.SecurityConfig;
import com.spring.mvc.config.WebMvcConfig;

/**
 * @author Vinaya Nayak
 * Jun 10, 2017
 * MvcWebApplicationInitializer.java
 */
public class MvcWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{


	@Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { WebMvcConfig.class, SecurityConfig.class};
    }
  
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }
  
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
	
	@Override public void onStartup(ServletContext servletContext) throws ServletException {

	    WebApplicationContext context = getContext();
	    servletContext.addListener(new ContextLoaderListener(context));
	    ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(context));
	    dispatcher.setLoadOnStartup(1);
	    dispatcher.addMapping("/");
	    dispatcher.setInitParameter("throwExceptionIfNoHandlerFound", "true");

	  }

	  private AnnotationConfigWebApplicationContext getContext() {
	    AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
	    context.register(WebMvcConfig.class);
	    return context;
	  }

}
