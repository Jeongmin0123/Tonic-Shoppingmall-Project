package controller.common;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import model.product.CrawlDAO;

/**
 * Application Lifecycle Listener implementation class InitialData
 *
 */
@WebListener
public class InitialData implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public InitialData() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
//        CrawlDAO.deleteVITA(); // deleteCrawlDB();   
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
//    	CrawlDAO.insertCrawlDB();
    }
	
}
