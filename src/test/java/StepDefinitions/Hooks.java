package StepDefinitions;

import Utils.CommonMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends CommonMethods {

    @Before

    public void preConditions(){

        openBrowserAndLaunchApplication();

    }
              // Scenero class holds the complete info of your tests executions in Cucumber framework
    @After


    public void postConditions(Scenario scenario){

        byte[] pic;
        if(scenario.isFailed())
        {
            pic=takeScreenshot("failed/" +scenario.getName());
        }
        else {
            pic=takeScreenshot("passed/" +scenario.getName());
        }

        // attach the screeenshot in my report
        scenario.attach(pic,"image/png",scenario.getName());


        closeBrowser();

    }

}


