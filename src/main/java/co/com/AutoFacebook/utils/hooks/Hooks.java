package co.com.AutoFacebook.utils.hooks;

import cucumber.api.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class Hooks {
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }
}