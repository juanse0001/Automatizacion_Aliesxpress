package co.com.AutoFacebook.tasks;

import co.com.AutoFacebook.userinterface.AliExpressHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class VerifySearchResults implements Task {

    public VerifySearchResults() { // Constructor sin parámetros
    }

    @Step("{0} selecciona el primer producto encontrado en los resultados de búsqueda")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(

                WaitUntil.the(AliExpressHomePage.PRODUCT_TITLES, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(20).seconds(),

                WaitUntil.the(AliExpressHomePage.FIRST_PRODUCT_LINK, WebElementStateMatchers.isClickable())
                        .forNoMoreThan(10).seconds(),
                Click.on(AliExpressHomePage.FIRST_PRODUCT_LINK)
        );
    }

    public static VerifySearchResults andSelectFirst() {
        return instrumented(VerifySearchResults.class);
    }
}