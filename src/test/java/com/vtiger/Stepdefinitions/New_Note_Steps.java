package com.vtiger.Stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class New_Note_Steps extends BaseTest
{
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




}
