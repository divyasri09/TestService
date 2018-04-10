package com.homedepot.checkout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * 
 */
@SpringBootApplication
public class CheckoutServiceApplication {
    
    public ServiceApplication() {       //NOSONAR: Avoiding squid:S1118 as the constructor is required to be public for SpringAppilcation.run()
        super();
    }

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(ServiceApplication.class, args);     //NOSONAR: Cannot change this to ConfigurableApplicationContext just to close it

        //this is essential as it allows our application to address 404 errors with a common payload
        DispatcherServlet dispatcherServlet = (DispatcherServlet) ctx.getBean("dispatcherServlet");
        dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
    }

}
