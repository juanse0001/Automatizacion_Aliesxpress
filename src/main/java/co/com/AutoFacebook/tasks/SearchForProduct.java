package co.com.AutoFacebook.tasks;

import co.com.AutoFacebook.userinterface.AliExpressHomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SearchForProduct implements Task {

    private final String productName;

    public SearchForProduct(String productName) {
        this.productName = productName;
    }

    @Step("{0} busca el producto '#productName'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(

                WaitUntil.the(AliExpressHomePage.SEARCH_FIELD, WebElementStateMatchers.isClickable())
                        .forNoMoreThan(10).seconds(),

                Enter.theValue(productName).into(AliExpressHomePage.SEARCH_FIELD).thenHit(Keys.ENTER),

                WaitUntil.the(AliExpressHomePage.FILTER_ORDERS, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(15).seconds()
        );
    }
    public static SearchForProduct called(String productName) {
        return instrumented(SearchForProduct.class, productName);
    }
}