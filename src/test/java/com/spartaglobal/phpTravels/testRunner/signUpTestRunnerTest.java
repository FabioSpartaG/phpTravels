package com.spartaglobal.phpTravels.testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;




    @RunWith(Cucumber.class)
    @CucumberOptions(
            plugin={"pretty", "html:reports/report.html"},
            tags = {""},
            features = "classpath:features/SignUpFeatures",
            glue = "com.spartaglobal.phpTravels.stepDefs.signUpStepDefs"
    )

    public class signUpTestRunnerTest
    { }

