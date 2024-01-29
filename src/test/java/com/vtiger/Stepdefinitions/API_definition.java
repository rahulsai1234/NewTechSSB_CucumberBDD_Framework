package com.vtiger.Stepdefinitions;

import com.vtiger.common.CommonActions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class API_definition extends BaseTest {
public String API_Endpoint;
public Response resp;
public CommonActions CMN_ACT;

/*
    @Before
    public void getScenario(Scenario scenario)
    {
        initiation();

        vTCName = scenario.getName();
        logger=extent.createTest(vTCName);

    }

    @After
    public void savereport()
    {
        extent.flush();
    }


 */


@Given("endpoint_url {string}")
    public void endpoint_url(String string)
    {
        CMN_ACT=new CommonActions(driver,logger);
        API_Endpoint=prop.getProperty("API_base_URL")+string;

    }
    @When("user call get method")
    public void user_call_get_method()
    {
        resp = RestAssured.get(API_Endpoint);
        System.out.println(resp.asPrettyString());

    }
    @Then("user can see the StatusCode response")
    public void user_can_see_the_response()
    {
        CMN_ACT.writeAPI_Info(prop.getProperty("API_base_URL"),API_Endpoint,resp.asPrettyString());
        System.out.println("StatusCode+ "+resp.statusCode());
    }

    @And("Status line should be {string}")
    public void statusLineShouldBe(String arg0)
    {
        System.out.println("StatusLine= "+resp.getStatusLine());
        CMN_ACT.WriteStatusLine(arg0,resp.getStatusLine());
    }

}
