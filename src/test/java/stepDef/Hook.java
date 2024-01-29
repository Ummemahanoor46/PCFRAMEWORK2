package stepDef;

import base.Config;
import com.google.common.base.Strings;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook extends Config {
    public static String url;
    public static String browserType = System.getProperty("browser");
    public  static String envType = System.getProperty("env");
    public static String STUDENT_EMAIL;
    public static String STUDENT_PASSWORD;
    @Before
    //start db connection
    //setup url:
        // QA : http://www.qa.taltektc.com
        // STAGE : http://www.stage.taltektc.com
        // PROD : http://www.prod.taltektc.com
    //open browser
    public void beforeEachTest(){
        if (Strings.isNullOrEmpty(envType)) {
            envType = "qa";
        }
        if (Strings.isNullOrEmpty(browserType)){
            browserType = "chrome";
        }

        driver = setupBrowser(browserType);
      switch (envType){
          case "qa":
              url = "http://www.qa.taltektc.com";
              STUDENT_EMAIL = "chromicumme+1@gmail.com";
              STUDENT_PASSWORD = "TESTpassword99";
                      break;
          case "stg":
              url = "http://www.stage.taltektc.com";
              STUDENT_EMAIL = "chromicumme+1@gmail.com";
              STUDENT_PASSWORD = "TESTpassword99";
              break;
          case "prod":
              url = "http://www.prod.taltektc.com";
              STUDENT_EMAIL = "chromicumme+1@gmail.com";
              STUDENT_PASSWORD = "TESTpassword99";
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
