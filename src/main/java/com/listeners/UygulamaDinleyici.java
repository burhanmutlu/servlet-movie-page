package com.listeners;

import java.util.Date;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class UygulamaDinleyici implements ServletContextListener {


    public void contextInitialized(ServletContextEvent sce)  { 
    	// uygulamanın başladığı an
    	System.out.println("uygulama başlatıldı:" + new Date());
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
    	// uygulamanın başladığı an
    	System.out.println("uygulama sonlandırıldı:" + new Date());
    }
	
}
