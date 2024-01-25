package stepDef;

import base.Config;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook extends Config {
    public static String url;
    public static String driverType = System.getProperty("browser");
    public  static String envType = System.getProperty("env");
    @Before
    //start db connection
    //setup url:
        // QA : http://www.qa.taltektc.com
        // STAGE : http://www.stage.taltektc.com
        // PROD : http://www.prod.taltektc.com
    //open browser
    public void beforeEachTest(){

        driver = setupBrowser(driverType);
      switch (envType){
          case "qa":
              url = "http://www.qa.taltektc.com";
                      break;
          case "stg":
              url = "http://www.stage.taltektc.com";
              break;
          case "prod":
              url = "http://www.prod.taltektc.com";
              break;
      }
      driver.get(url);
    }
    @After
    //close browser
    //quit browser
    //take screenshot if the test steps or case fail
    //close db connection
    public void afterEachTest(){
        driver.quit();
    }


}
