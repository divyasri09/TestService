package com.homedepot.checkout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * 
 */

/**
 * This is the main class of the checkout service spring boot application which starts that service
 * 
 * @author VXJ8774
 *
 */
@SpringBootApplication
public class CheckoutServiceApplication {
    
    public CheckoutServiceApplication() {       //NOSONAR: Avoiding squid:S1118 as the constructor is required to be public for SpringAppilcation.run()
        super();
    }

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(CheckoutServiceApplication.class, args);     //NOSONAR: Cannot change this to ConfigurableApplicationContext just to close it

        //this is essential as it allows our application to address 404 errors with a common payload
        DispatcherServlet dispatcherServlet = (DispatcherServlet) ctx.getBean("dispatcherServlet");
        dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
    }

}
