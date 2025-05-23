package co.com.AutoFacebook.utils.hooks;

import cucumber.api.java.Before;
import net.serenitybdd.screenplay.actors.OnlineCast;


import static net.serenitybdd.screenplay.actors.OnStage.*;

public class PreparacionEscenario {


    @Before
    public void sepUp() {
        setTheStage(new OnlineCast());
        theActorCalled("Usuario");
    }
}
