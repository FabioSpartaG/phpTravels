package com.spartaglobal.phpTravels.stepDefs.signInStepDefs;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

    @RunWith(Cucumber.class)
    @CucumberOptions(
            plugin={"pretty", "html:reports/report.html"},
            tags = {""},
            features = "classpath:features/signUpAndSignInFeatures",
            glue = "com.spartaglobal.phpTravels.stepDefs.signInStepDefs"
    )

    public class loginCucumberTestRunner
    { }
